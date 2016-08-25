import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class Main{

	private static AssemblyMachine maquina;

	public static void main(String args[]){
		try{
			String caminho="";
			while(caminho.equals(""))
				caminho=escolheArquivo();

			Scanner scan=new Scanner(new File(caminho));
			ArrayList<String> programa=new ArrayList<String>();
			String linha=scan.nextLine();
			if(!linha.equals(""))
				programa.add(linha);
			while(scan.hasNext()){
				linha=scan.nextLine();
				if(!linha.equals(""))
					programa.add(linha);
			}
			maquina=new AssemblyMachine(reg(), programa);
			Loop();
		}catch(Exception e){
			e.printStackTrace();
		}
		System.exit(0);
	}

	private static void Loop(){
		Scanner scan=new Scanner(System.in);
		if(maquina.isrunning()){
			String n=scan.nextLine();
			run();
		}
		Update();
	}

	private static void run(){
		ArrayList<String> commands=maquina.Next();
		try{
			AssemblyOperations(commands);
		}catch(IndexOutOfBoundsException e){
			run();
		}
	}

	private static void Update(){
		String[] r={"AL", "AH", "BL", "BH", "CL", "CH", "DL", "DH", "IC", "CF", "ZF", "SF"};
		for(String n : r)
			System.out.println(n+="="+maquina.getN(n));
	}
	
	private static void AssemblyOperations(ArrayList<String> commands) throws IndexOutOfBoundsException{
		String function=commands.get(0);
		if(function.equals("ORG"))
			maquina.ORG(commands.get(1));
		else if(function.equals("MOV"))
			maquina.MOV(commands.get(1), commands.get(2));
		else if(function.equals("ADD"))
			maquina.ADD(commands.get(1), commands.get(2));
		else if(function.equals("SUB"))
			maquina.SUB(commands.get(1), commands.get(2));
		else if(function.equals("MUL"))
			maquina.MUL(commands.get(1));
		else if(function.equals("DIV"))
			maquina.DIV(commands.get(1));
		else if(function.equals("CMP"))
			maquina.CMP(commands.get(1), commands.get(2));
		else if(function.equals("INC"))
			maquina.INC(commands.get(1));
		else if(function.equals("DEC"))
			maquina.DEC(commands.get(1));
		else if(function.equals("NEG"))
			maquina.NEG(commands.get(1));
		else if(function.equals("JMP"))
			maquina.JMP(commands.get(1));
		else if(function.equals("JZ"))
			maquina.JZ(commands.get(1));
		else if(function.equals("JNZ"))
			maquina.JNZ(commands.get(1));
		else if(function.equals("JG"))
			maquina.JG(commands.get(1));
		else if(function.equals("JGE"))
			maquina.JGE(commands.get(1));
		else if(function.equals("RET"))
			maquina.RET();
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
		hash.put("SF", new Registrador("SF", false));
		return hash;
	}

}

