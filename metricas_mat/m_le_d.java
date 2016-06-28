import java.util.Scanner;

public class m_le_d{

	public static void main(String args[]){
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt(), i, j, k;
		double a[][]=new double[n][n];
		double b[][]=new double[n][n];
		double c[][]=new double[n][n];
		for(i=0; i<n; i++)
			for(j=0; j<n; j++){
				a[i][j]=scan.nextDouble();
				b[i][j]=scan.nextDouble();
				c[i][j]=0;
			}

		for(i=0; i<n; i++)
			for(j=0; j<n; j++)
				for(k=0; k<n; k++)
					c[i][j]+=a[i][k]*b[k][j];
	}

}

