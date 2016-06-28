public class m_fix_int{

	public static void main(String args[]){
		int n=100, i, j, k;
		int a[][]=new int[n][n];
		int b[][]=new int[n][n];
		int c[][]=new int[n][n];
		for(i=0; i<n; i++)
			for(j=0; j<n; j++){
				a[i][j]=1;
				b[i][j]=1;
				c[i][j]=0;
			}

		for(i=0; i<n; i++)
			for(j=0; j<n; j++)
				for(k=0; k<n; k++)
					c[i][j]+=a[i][k]*b[k][j];
	}

}

