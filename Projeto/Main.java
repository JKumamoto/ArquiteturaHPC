import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class Main{

	public static void main(String args[]){
		try{
			String caminho="";
			while(caminho.equals(""))
				caminho=escolheArquivo();

			Scanner scan=new Scanner(new File(caminho));
			ArrayList<String> processo=new ArrayList<String>();
			String linha=scan.nextLine();
			processo.add(linha);
			while(scan.hasNext()){
				linha=scan.nextLine();
				processo.add(linha);
			}
			AssemblyMachine maq=new AssemblyMachine(reg());
		}catch(Exception e){
			e.printStackTrace();
		}
		System.exit(0);
	}

	public static String escolheArquivo(){
		String path="";
		JFrame parent=new JFrame();
		JFileChooser chooser=new JFileChooser();
		int returnVal=chooser.showOpenDialog(parent);
		if(returnVal==JFileChooser.APPROVE_OPTION)
			path=chooser.getSelectedFile().getAbsolutePath();
		return path;
	}

	public static HashMap<String, Registrador> reg(){
		HashMap<String, Registrador> hash=new HashMap<String, Registrador>();
		hash.put("AL", new Registrador("A", true));
		hash.put("AH", new Registrador("A", false));
		hash.put("BL", new Registrador("B", true));
		hash.put("BH", new Registrador("B", false));
		hash.put("CL", new Registrador("C", true));
		hash.put("CH", new Registrador("C", false));
		hash.put("DL", new Registrador("D", true));
		hash.put("DH", new Registrador("D", false));
		hash.put("IC", new Registrador("IC", false));
		hash.put("CF", new Registrador("CF", false));
		hash.put("ZF", new Registrador("ZF", false));
		return hash;
	}

}

