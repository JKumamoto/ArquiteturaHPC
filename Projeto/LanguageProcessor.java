import java.util.ArrayList;
import java.util.Scanner;

public class LanguageProcessor{

	private ArrayList<String> Programa;

	public LanguageProcessor(ArrayList<String> Programa){
		this.Programa=Programa;
	}

	public String getLinha(int i){
		return Programa.get(i);
	}

	public int Max(){
		return Programa.size();
	}

	public ArrayList<String> ProcessaLinha(String linha){
		ArrayList<String> palavras=new ArrayList<String>();
		Scanner Processador=new Scanner(linha);
		while(Processador.hasNext()){
			String w=Processador.next();
			palavras.add(w.toUpperCase());
		}
		return palavras;
	}

}

