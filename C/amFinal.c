#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "tipopilha.h"
#include "tipofila.h"

int main() {

	tipopilha topo;
	tipofila inicio, fim, i_competidores, f_competidores;
	TipoEquipe equipe_inscricao;
	TipoCompeticao competicao,aux,vencedor,rank;

	INIT(&topo);
	INIT_FILA(&inicio,&fim);
	int i = 0, qt_equipes = 0;
	char status[4];
	char sucesso[4];
	float nova_dist_alvo, menor_dist;

	printf("Inscricao de equipes\n");

	//Bloco de repeti��o para registro de equipes na pilha
	do {
		qt_equipes++; 
		printf("Informe o nome da equipe: ");
		fflush(stdin);
		gets(equipe_inscricao.nome_equipe);
		printf("Informe a turma da equipe: ");
		scanf("%c",&equipe_inscricao.turma);
		PUSH(&topo,equipe_inscricao);
		if(!IsEmpty(topo)) { //Condi��o para continuar cadastrando equipes
			printf("Deseja cadastrar outra equipe? [sim/nao]\n");
			fflush(stdin);
			gets(status);
		}
	} while(strcmp(status,"nao") == 1);




	//Bloco de repeti��o para retirar da pilha e inserir na fila os competidores, com seus nomes copiados
	do {
		POP(&topo,&equipe_inscricao);
		strcpy(competicao.nome_equipe,equipe_inscricao.nome_equipe);
		ENQUEUE(&inicio,&fim,competicao);
	} while(!IsEmpty(topo));


	DEQUEUE(&inicio,&fim,&competicao);
	//Inicializa��o de campos para substitui��o posterior
	competicao.nr_tentativas = 1;
	competicao.dist_alvo = 1000000;

	//Bloco de repeti��o para inicializa��o dos campos de lan�amento das equipes
	while(competicao.nr_tentativas  < 4) {
		printf("\n[EQUIPE::%s]Informe se o lancamento foi efetuado com sucesso[sim/nao]\n",competicao.nome_equipe);
		fflush(stdin);
		gets(sucesso);
		if(strcmp(sucesso,"sim") == 0) { // Verifica��o do sucesso ou falha do lan�amento 

			printf("Nome da equipe registrada: %s\n", competicao.nome_equipe);
			printf("\nInforme a distancia do alvo: ");
			scanf("%f",&nova_dist_alvo);
			if(nova_dist_alvo < competicao.dist_alvo) { //S� � substitu�do dist�ncias menores que as antigas
				competicao.dist_alvo = nova_dist_alvo;
			}
			printf("\nInforme o tempo de propulsao: ");
			scanf("%f",&competicao.tempo_prop);

		// Caso tenha falha no lan�amento os valores s�o iniciados como padr�o para ser inserido na fila
		} else {
			printf("\nNome da equipe registrada: %s\n", competicao.nome_equipe);
			printf("\nO lancamento falhou!\n");
			nova_dist_alvo = 9999;
			if(nova_dist_alvo < competicao.dist_alvo) { //S� � substitu�do dist�ncias menores que as antigas
				competicao.dist_alvo = nova_dist_alvo;
				competicao.tempo_prop = 0;
			}


		}
		competicao.nr_tentativas++;
		// As equipes s�o enfileiradas enquanto estiverem lan�amentos disponiveis(Adotado um padr�o de 3 lan�amentos limite)									
		if(competicao.nr_tentativas == 4) {				
			i++; //Incremento para checar o n�mero de equipes que lan�aram foguetes
			DEQUEUE(&inicio,&fim,&aux);					
			ENQUEUE(&inicio,&fim,competicao); 			
			competicao = aux; 						
			if(i == qt_equipes){//Enfileira uma vez para completar a fila ap�s todas equipes terem feito seus lan�amentos
				ENQUEUE(&inicio,&fim,competicao);
			}
			competicao.nr_tentativas++;	 // Incremento para alterar o valor inicial 0 que repete faz com que o while repita uma vez extra
			competicao.dist_alvo = 1000000;

		} 

	}
	i = 0;
	//Inicializa��o da distancia do alvo para avaliar o vencedor
	menor_dist = 999999;
	//Bloco para sele��o do competidor com menor dist�ncia
	while(i != qt_equipes) {
		i++;
		DEQUEUE(&inicio,&fim,&rank);
		if(rank.dist_alvo < menor_dist) {
			vencedor = rank;
			menor_dist = vencedor.dist_alvo;
		}
		ENQUEUE(&inicio,&fim,rank);
	}


	printf("\n\nVencedor da Spacecup: %s\n\n", vencedor.nome_equipe);
	printf("Distancia do alvo = %.2f", vencedor.dist_alvo);
	printf("\nTempo de propul��o = %.2f",vencedor.tempo_prop);

	printf("\n\nCOMPETIDORES\n");

	
	//Exibi��o no console de todos competidores
	while(!IsEmpty_Fila(inicio,fim)) {
		DEQUEUE(&inicio,&fim,&aux);
		printf("\n\nNome da equipe registrada: %s\n", aux.nome_equipe);
		printf("\nDistancia do alvo = %.2f",aux.dist_alvo);
		printf("\nTempo de propulsao: %.2f",aux.tempo_prop);

	}
	
}
