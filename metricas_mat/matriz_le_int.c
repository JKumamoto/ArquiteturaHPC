#include <stdio.h>
#include <stdlib.h>

unsigned int **a, **b, **c;
unsigned int size, i, j, k;

void mult(){
	for(i=0; i<size; i++)
		for(j=0; j<size; j++)
			for(k=0; k<size; k++)
				c[i][j]+=a[i][k]*b[k][j];
}

int main(void){
	scanf("%d", &size);
	a=(unsigned int **)malloc(size*sizeof(unsigned int *));
	b=(unsigned int **)malloc(size*sizeof(unsigned int *));
	c=(unsigned int **)malloc(size*sizeof(unsigned int *));
	for(i=0; i<size; i++){
		a[i]=(unsigned int *)malloc(size*sizeof(unsigned int));		
		b[i]=(unsigned int *)malloc(size*sizeof(unsigned int));
		c[i]=(unsigned int *)malloc(size*sizeof(unsigned int));
	}
	for(i=0; i<size; i++)
		for(j=0; j<size; j++){
			scanf("%d", &k);
			a[i][j]=k;
			scanf("%d", &k);
			b[i][j]=k;
			c[i][j]=0;
		}

	mult();
	return 0;
}

