#include <stdlib.h>
#include <stdio.h>

struct equipe_inscricao{
	char nome_equipe[20];
	char turma;
};
typedef struct equipe_inscricao TipoEquipe;

	struct no { 
		TipoEquipe dado;   
		struct no *prox;
	};

	typedef struct no* tipopilha;

void INIT (tipopilha *topo)
{
*topo = NULL;
}

int IsEmpty(tipopilha topo)
{
if (topo == NULL)
   return(1);
else
  return(0);
}


void PUSH (tipopilha *topo, TipoEquipe elem)

{
tipopilha novo;
novo = (tipopilha) malloc (sizeof(struct no));
if (novo != NULL)
	{
	novo->dado=elem;
	novo->prox=*topo;
	*topo = novo;
	}
else
	printf("pilha cheia \n");
}

int POP (tipopilha *topo,TipoEquipe *elem)
{
tipopilha aux;
aux = *topo;
if (!IsEmpty(*topo))   {
     *elem=aux->dado;
     *topo=aux->prox;
     free(aux);
     return(1);
     }
else {
printf("pilha vazia \n");
      return(0);
      }
}


int TOP (tipopilha topo,TipoEquipe *elem)
{
if (!IsEmpty(topo))   {
     *elem= topo->dado;
     return(1);
     }
else {
       printf("pilha vazia \n");
       return(0);
       }
}

