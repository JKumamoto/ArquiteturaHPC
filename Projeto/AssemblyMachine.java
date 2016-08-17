import java.util.ArrayList;
import java.util.HashMap;

public class AssemblyMachine{

	private HashMap<String, Registrador> Registradores;
	private boolean running;

	public AssemblyMachine(HashMap<String, Registrador> Registradores){
		this.Registradores=Registradores;
		this.running=true;
	}
	
	public boolean isrunning(){
		return running;
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
		if(Registradores.get(a).getvalor()==getN(b))
			Registradores.get("ZF").setvalor(1);
		else Registradores.get("ZF").setvalor(0);
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

	public void RET(){
		running=false;
	}

}

