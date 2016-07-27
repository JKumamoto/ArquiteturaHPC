#include <stdio.h>
#include <stdlib.h>
#include <mpi.h>

int cmpfunc (const void * a, const void * b){
   return ( *(int*)a - *(int*)b );
}

int main (int argc, char *argv[]) {
	int i, my_rank, p, target, maior;
	int nElementos = 16;
	MPI_Status status;
	MPI_Init (&argc, &argv);
	MPI_Comm_rank (MPI_COMM_WORLD, &my_rank);
	MPI_Comm_size (MPI_COMM_WORLD, &p);
	int nElemProc = nElementos / p;
	
	// Gera vetor original    
	int *vetor = 0;
	if(my_rank==0)
		for(i=0; i<nElementos; i++)
			vetor=(int *)malloc(nElementos*sizeof(int));
	else
		for(i=0; i<nElemProc; i++)
			vetor=(int *)malloc(nElemProc*sizeof(int));

	if (my_rank == 0)
	  for (i = 0; i < nElementos; i++)
		vetor[i] = i+1;
	
	// Copia dados para demais processos
	if(my_rank==0)
		for(target=1; target<p; target++)
			MPI_Send(vetor+nElemProc*target, nElemProc, MPI_INT, target, 0, MPI_COMM_WORLD);
	else
		MPI_Recv(vetor, nElemProc, MPI_INT, 0, 0, MPI_COMM_WORLD, &status);

	//sort
	qsort(vetor, nElemProc, sizeof(int), cmpfunc);
	maior=vetor[nElemProc-1];
	printf("Maior do processo %d: %d\n", my_rank, maior);

	if(my_rank==0){
		int max;
		for(target=1; target<p; target++){
			MPI_Recv(&max, 1, MPI_INT, target, 0, MPI_COMM_WORLD, &status);
			if(maior<max)	maior=max;
		}
		printf("Maior Global: %d\n", maior);
	}else
		MPI_Send(&maior, 1, MPI_INT, 0, 0, MPI_COMM_WORLD);

	free (vetor);
	MPI_Finalize();
}

