public class Registrador{

	private String Nome;
	private int valor;
	private boolean tipo;

	public Registrador(String Nome, boolean tipo){
		this.Nome=Nome;
		this.valor=0;
		this.tipo=tipo;
	}

	public String getNome(){
		return Nome;
	}

	public boolean gettipo(){
		return tipo;
	}

	public int getvalor(){
		return valor;
	}

	public int setvalor(int x){
		if(x>255){
			this.valor=255;
			return x-255;
		}else
			this.valor=x;
		return 0;
	}

}

