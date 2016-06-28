#include <stdio.h>
#include <stdlib.h>

int main(int argc, char* argv[]){
   int tamanho, i, j;
   tamanho = atoi(argv[1]);
   printf("%2d\n", tamanho);
   for (i=0;i<tamanho; i++){
      for (j=0;j<tamanho; j++){
          printf("%2d",1);
      }
      printf("\n");
   }
   for (i=0;i<tamanho; i++){
      for (j=0;j<tamanho; j++){
          printf("%2d ",1);
      }
      printf("\n");
   }
   return 0;
}
