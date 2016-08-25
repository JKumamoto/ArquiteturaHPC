import java.util.ArrayList;
import java.util.HashMap;

public class AssemblyMachine{

	private HashMap<String, Registrador> Registradores;
	private LanguageProcessor Processor;
	private int linhas;
	private int[] function;
	private int functioncounter;
	private boolean running;

	public AssemblyMachine(HashMap<String, Registrador> Registradores, ArrayList<String> programa){
		this.Registradores=Registradores;
		this.Processor=new LanguageProcessor(programa);
		this.linhas=0;
		this.function=new int[10];
		for(int i=0; i<10; i++)
			function[i]=0;
		this.functioncounter=0;
		this.running=true;
	}

	public void Stop(){
		this.running=false;
	}

	public boolean isrunning(){
		if(linhas>=Processor.Max())	Stop();
		return running;
	}

	public ArrayList<String> Next(){
		String linha=Processor.getLinha(linhas);
		ArrayList<String> word=Processor.ProcessaLinha(linha);
		linhas++;
		return word;
	}

	public int Previous(){
		int l=0;
		if(linhas>1)
			l=linhas-1;
		return l;
	}

	public int getX(String nome){
		return getN(nome+"L")+getN(nome+"H");
	}

	private int toNumber(String word) throws NumberFormatException{
		int n=0;
		int x=word.indexOf('h');
		if(x>=0){
		}else
			n=Integer.parseInt(word);

		return n;
	}

	public int getN(String val){
		int n=0;
		try{
			n=toNumber(val);
		}catch(NumberFormatException e){
			if(val.indexOf('X')==1){
				char[] nome=val.toCharArray();
				n=getX(""+nome[0]);
			}else
				n=Registradores.get(val).getvalor();
		}
		return n;
	}

	public void ORG(String val){
		if(val.equals("100h")||val.equals("100H")){
			linhas=1;
			running=true;
			for(String h : Registradores.keySet())
				Registradores.get(h).setvalor(0);
		}
	}

	private int movs(String pos, int val){
		int carry=Registradores.get(pos).setvalor(val);
		return carry;
	}

	private void mov_over(String pos, int val){
		int carry=movs(pos+"L", val);
		if(carry>0){
			carry=movs(pos+"H", carry);
			if(carry>0){
				Registradores.get("CF").setvalor(1);
				MOV(pos+"X", ""+carry);
			}
		}
	}

	public void MOV(String pos, String val){
		int n=getN(val);
		if(Registradores.containsKey(pos)){
			if(Registradores.get(pos).gettipo())
				mov_over(Registradores.get(pos).getNome(), n);
			else{
				int carry=movs(pos, n);
				if(carry>0){
					Registradores.get("CF").setvalor(1);
					MOV(pos, ""+carry);
				}	
			}
		}else if(pos.equals("AX"))
			mov_over("A", n);
		else if(pos.equals("BX"))
			mov_over("B", n);
		else if(pos.equals("CX"))
			mov_over("C", n);
		else if(pos.equals("DX"))
			mov_over("D", n);
	}

	public void ADD(String a, String b){
		MOV(a, ""+(getN(a)+getN(b)));
	}

	public void SUB(String a, String b){
		MOV(a, ""+(getN(a)-getN(b)));
	}

	public void MUL(String a){
		int operando=getN(a);
		if(operando<255||operando>-255){
			mov_over("A", Registradores.get("AL").getvalor()*operando);
		}else{
			int val=getX("A")*operando;
			int aux=val-32767;
			if(aux<0){
				mov_over("A", val);
				mov_over("D", 0);
			}else{
				mov_over("A", 32767);
				mov_over("D", aux);
			}
		}
	}

	public void DIV(String a){
		int operando=getN(a);
		if(operando<255||operando>-255){
			Registradores.get("AL").setvalor(getX("A")/operando);
			Registradores.get("AH").setvalor(getX("A")%operando);
		}else{
			int val=getX("A")+getX("D");
			mov_over("A", val/operando);
			mov_over("D", val%operando);
		}
	}

	public void CMP(String a, String b){
		int n=getN(a)-getN(b);
		Registradores.get("SF").setvalor(0);
		Registradores.get("ZF").setvalor(0);
		if(n==0)
			Registradores.get("ZF").setvalor(1);
		else if(n<0)
			Registradores.get("SF").setvalor(1);
	}

	public void INC(String a){
		int n=getN(a)+1;
		MOV(a, ""+n);
	}

	public void DEC(String a){
		Registradores.get(a).setvalor(getN(a)-1);
	}

	public void NEG(String a){
		Registradores.get(a).setvalor(getN(a)*-1);
	}

	public void JMP(String label){
		function[functioncounter++]=linhas;
		label+=":";
		for(int i=0; i<Processor.Max(); i++){
			String search=Processor.getCommand(i);
			if(search.equals(label)){
				linhas=i+1;
				break;
			}
		}
	}

	public void JZ(String label){
		if(getN("ZF")==1)
			JMP(label);
	}

	public void JNZ(String label){
		if(getN("ZF")==0)
			JMP(label);
	}

	public void JG(String label){
		if((getN("ZF")==0)&&(getN("SF")==0))
			JMP(label);
	}

	public void JGE(String label){
		if(getN("SF")==0)
			JMP(label);
	}

	public void RET(){
		if(functioncounter!=0)
			linhas=function[--functioncounter];
		else	Stop();
	}

}

