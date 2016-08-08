import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Maquina{

	private HashMap<String, Runnable> Operacoes;
	private Processador proc;
	private Registrador A, B, C, D;

	public Maquina(ArrayList<String> Programa, HashMap<String, Runnable> Operacoes){
		this.proc=new Processador(Programa);
		this.Operacoes=Operacoes;
		this.A=new Registrador();		
		this.B=new Registrador();
		this.C=new Registrador();
		this.D=new Registrador();
	}

	public void Loop(){
		int i=0;
		while(i<proc.Max()){
			ArrayList<String> palavras=proc.ProcessaLinha(proc.getLinha(i));
			System.out.println("Linha "+(i+1)+":");
			for(String word:palavras)
				System.out.print(word+" ");
			System.out.println("");
			i++;
		}
	}

}

