#include <stdio.h>
#include <stdlib.h>

unsigned double **a, **b, **c;
unsigned int size, i, j, k;

void mult(){
	for(i=0; i<size; i++)
		for(j=0; j<size; j++)
			for(k=0; k<size; k++)
				c[i][j]+=a[i][k]*b[k][j];
}

int main(void){
	scanf("%d", &size);
	a=(unsigned double **)malloc(size*sizeof(unsigned double *));
	b=(unsigned double **)malloc(size*sizeof(unsigned double *));
	c=(unsigned double **)malloc(size*sizeof(unsigned double *));
	for(i=0; i<size; i++){
		a[i]=(unsigned double *)malloc(size*sizeof(unsigned double));		
		b[i]=(unsigned double *)malloc(size*sizeof(unsigned double));
		c[i]=(unsigned double *)malloc(size*sizeof(unsigned double));
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


