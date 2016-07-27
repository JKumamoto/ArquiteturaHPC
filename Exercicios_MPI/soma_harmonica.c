#include <stdio.h>
#include <stdlib.h>
#include <mpi.h>

int main (int argc, char *argv[]) {
	int my_rank, p, target;
	int nElementos = 10;
	MPI_Status status;
	MPI_Init (&argc, &argv);
	MPI_Comm_rank (MPI_COMM_WORLD, &my_rank);
	MPI_Comm_size (MPI_COMM_WORLD, &p);
	int nElemProc = nElementos / (p-1);
	
	double soma=0;
	
	// Obtem somas dos demais processos
	if(my_rank==0){
		double val;
		for(target=1; target<p; target++){
			MPI_Recv(&val, 1, MPI_DOUBLE, target, 0, MPI_COMM_WORLD, &status);
			soma+=val;
		}
		printf("%f\n", soma);
	}else{
		int proc=(my_rank-1)*nElemProc;
		for(target=proc; target<(proc+nElemProc); target++){
			if(target==0)	soma=1;
			else 	soma+=1/target;
			printf("[%d]: %f\n", my_rank, soma);
		}
		MPI_Send(&soma, 1, MPI_DOUBLE, 0, 0, MPI_COMM_WORLD);
	}

	MPI_Finalize();
}

