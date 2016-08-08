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

			File file=new File(caminho);
			Scanner scan=new Scanner(file);
			ArrayList<String> processo=new ArrayList<String>();
			String linha=scan.nextLine();
			processo.add(linha);
			while(scan.hasNext()){
				linha=scan.nextLine();
				processo.add(linha);
			}
			Maquina maq=new Maquina(processo, funcoes());
			maq.Loop();
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

	public static HashMap<String, Runnable> funcoes(){
		HashMap<String, Runnable> hash=new HashMap<String, Runnable>();

		return hash;
	}

}

