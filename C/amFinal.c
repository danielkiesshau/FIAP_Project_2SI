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

	//Bloco de repetição para registro de equipes na pilha
	do {
		qt_equipes++; 
		printf("Informe o nome da equipe: ");
		fflush(stdin);
		gets(equipe_inscricao.nome_equipe);
		printf("Informe a turma da equipe: ");
		scanf("%c",&equipe_inscricao.turma);
		PUSH(&topo,equipe_inscricao);
		if(!IsEmpty(topo)) { //Condição para continuar cadastrando equipes
			printf("Deseja cadastrar outra equipe? [sim/nao]\n");
			fflush(stdin);
			gets(status);
		}
	} while(strcmp(status,"nao") == 1);




	//Bloco de repetição para retirar da pilha e inserir na fila os competidores, com seus nomes copiados
	do {
		POP(&topo,&equipe_inscricao);
		strcpy(competicao.nome_equipe,equipe_inscricao.nome_equipe);
		ENQUEUE(&inicio,&fim,competicao);
	} while(!IsEmpty(topo));


	DEQUEUE(&inicio,&fim,&competicao);
	//Inicialização de campos para substituição posterior
	competicao.nr_tentativas = 1;
	competicao.dist_alvo = 1000000;

	//Bloco de repetição para inicialização dos campos de lançamento das equipes
	while(competicao.nr_tentativas  < 4) {
		printf("\n[EQUIPE::%s]Informe se o lancamento foi efetuado com sucesso[sim/nao]\n",competicao.nome_equipe);
		fflush(stdin);
		gets(sucesso);
		if(strcmp(sucesso,"sim") == 0) { // Verificação do sucesso ou falha do lançamento 

			printf("Nome da equipe registrada: %s\n", competicao.nome_equipe);
			printf("\nInforme a distancia do alvo: ");
			scanf("%f",&nova_dist_alvo);
			if(nova_dist_alvo < competicao.dist_alvo) { //Só é substituído distâncias menores que as antigas
				competicao.dist_alvo = nova_dist_alvo;
			}
			printf("\nInforme o tempo de propulsao: ");
			scanf("%f",&competicao.tempo_prop);

		// Caso tenha falha no lançamento os valores são iniciados como padrão para ser inserido na fila
		} else {
			printf("\nNome da equipe registrada: %s\n", competicao.nome_equipe);
			printf("\nO lancamento falhou!\n");
			nova_dist_alvo = 9999;
			if(nova_dist_alvo < competicao.dist_alvo) { //Só é substituído distâncias menores que as antigas
				competicao.dist_alvo = nova_dist_alvo;
				competicao.tempo_prop = 0;
			}


		}
		competicao.nr_tentativas++;
		// As equipes são enfileiradas enquanto estiverem lançamentos disponiveis(Adotado um padrão de 3 lançamentos limite)									
		if(competicao.nr_tentativas == 4) {				
			i++; //Incremento para checar o número de equipes que lançaram foguetes
			DEQUEUE(&inicio,&fim,&aux);					
			ENQUEUE(&inicio,&fim,competicao); 			
			competicao = aux; 						
			if(i == qt_equipes){//Enfileira uma vez para completar a fila após todas equipes terem feito seus lançamentos
				ENQUEUE(&inicio,&fim,competicao);
			}
			competicao.nr_tentativas++;	 // Incremento para alterar o valor inicial 0 que repete faz com que o while repita uma vez extra
			competicao.dist_alvo = 1000000;

		} 

	}
	i = 0;
	//Inicialização da distancia do alvo para avaliar o vencedor
	menor_dist = 999999;
	//Bloco para seleção do competidor com menor distância
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
	printf("\nTempo de propulção = %.2f",vencedor.tempo_prop);

	printf("\n\nCOMPETIDORES\n");

	
	//Exibição no console de todos competidores
	while(!IsEmpty_Fila(inicio,fim)) {
		DEQUEUE(&inicio,&fim,&aux);
		printf("\n\nNome da equipe registrada: %s\n", aux.nome_equipe);
		printf("\nDistancia do alvo = %.2f",aux.dist_alvo);
		printf("\nTempo de propulsao: %.2f",aux.tempo_prop);

	}
	
}
