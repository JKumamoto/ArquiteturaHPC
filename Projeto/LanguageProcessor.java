import java.util.ArrayList;
import java.util.Scanner;

public class LanguageProcessor{

	private ArrayList<String> Programa;

	public LanguageProcessor(ArrayList<String> code){
		this.Programa=new ArrayList<String>();
		for(int i=0; i<code.size(); i++){
			String linha=code.get(i);
			ArrayList<String> st=filterCommand(ProcessaLinha(linha));
			String s="";
			for(String a:st)
				s+=a+" ";
			if((!s.equals(""))||(!s.equals(" ")))
				Programa.add(s);
		}
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

	public ArrayList<String> filterCommand(ArrayList<String> st){
		ArrayList<String> filtered=new ArrayList<String>();
		for(int j=0; j<st.size(); j++){
			String a=st.get(j), nova="";
			if(a.contains(",")){
				char[] w=a.toCharArray();
				for(int i=0; i<(w.length-1); i++)
					nova+=w[i];
				a=nova;
			}else if(a.contains(";")){
				char[] w=a.toCharArray();
				for(int i=0; i<(w.length-1); i++)
					nova+=w[i];
				a=nova;
				j=st.size();
			}
			if(!a.equals(""))
				filtered.add(a);
		}
		return filtered;
	}

	public String getCommand(int i){
		ArrayList<String> array=ProcessaLinha(getLinha(i));
		if(array.size()==0)
			return "";
		return array.get(0);
	}

}

