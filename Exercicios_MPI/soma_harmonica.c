#include <stdio.h>
#include <stdlib.h>
#include <mpi.h>

int main (int argc, char *argv[]) {
	int my_rank, p;
	long target;
	long nElementos = 100000000000;
	MPI_Status status;
	MPI_Init (&argc, &argv);
	MPI_Comm_rank (MPI_COMM_WORLD, &my_rank);
	MPI_Comm_size (MPI_COMM_WORLD, &p);
	long nElemProc = nElementos / (p-1);
	
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
		long proc=(my_rank-1)*nElemProc;
		if(proc==0)	proc++;
		for(target=proc; target<(proc+nElemProc); target++)
			soma+=1.0/target;
		MPI_Send(&soma, 1, MPI_DOUBLE, 0, 0, MPI_COMM_WORLD);
	}

	MPI_Finalize();
}

