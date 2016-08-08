public class Registrador{

	private int H;
	private int L;

	public Registrador(){
		this.H=0;
		this.L=0;
	}

	public int getH() {
		return H;
	}
	
	public void setH(int H) {
		this.H = H;
	}
	
	public int getL() {
		return L;
	}
	
	public void setL(int L) {
		this.L = L;
	}

	public int getX(){
		return H+L;
	}
	

}

