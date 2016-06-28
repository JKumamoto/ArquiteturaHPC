import java.util.Scanner;

public class m_le_int{

	public static void main(String args[]){
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt(), i, j, k;
		int a[][]=new int[n][n];
		int b[][]=new int[n][n];
		int c[][]=new int[n][n];
		for(i=0; i<n; i++)
			for(j=0; j<n; j++){
				a[i][j]=scan.nextInt();
				b[i][j]=scan.nextInt();
				c[i][j]=0;
			}

		for(i=0; i<n; i++)
			for(j=0; j<n; j++)
				for(k=0; k<n; k++)
					c[i][j]+=a[i][k]*b[k][j];
	}

}
