#include <stdlib.h>
#include <stdio.h>

struct competicao{
	char nome_equipe[20];
	int nr_tentativas;
	float dist_alvo;
	float tempo_prop;
};
typedef struct competicao TipoCompeticao;

struct no_fila { 
       TipoCompeticao dado;
       struct no_fila *prox;
};

typedef struct no_fila* tipofila;

void INIT_FILA (tipofila *inicio,tipofila *fim)
{
*inicio=NULL;
*fim=NULL;
}

int IsEmpty_Fila(tipofila ini, tipofila fim)
{
	if ((ini == NULL) && (fim == NULL)){
		return 1;
	} else {
		return 0;
	}
}

void ENQUEUE(tipofila *inicio, tipofila *fim, TipoCompeticao v)
{
tipofila novo;
novo=(tipofila) malloc (sizeof(struct no_fila));
if (novo==NULL) 
	 printf("Fila Cheia \n");
else  {
	 novo->dado=v;
	 novo->prox=NULL;
	if (IsEmpty_Fila(*inicio,*fim)){
	     *inicio = novo;
	     }
	else{
	     (*fim)->prox= novo;
	     }
        *fim=novo;
	}
}

int DEQUEUE(tipofila *inicio, tipofila *fim, TipoCompeticao *v)
{
	tipofila aux = *inicio;
	if(!IsEmpty_Fila(*inicio,*fim)){
		*v = (*inicio)->dado;
		*inicio = (*inicio)->prox;
		free (aux);
		if (*inicio == NULL){
			*fim = NULL;
		}
		return 1;
	} else {
		return 0;
	}
}


int FIRST(tipofila inicio, tipofila fim, TipoCompeticao *v)
{
	if (!IsEmpty_Fila(inicio,fim)){
		*v = inicio->dado;
		return 1;
    }
	else {
       printf("Fila vazia\n");
       return 0;
    }
}
