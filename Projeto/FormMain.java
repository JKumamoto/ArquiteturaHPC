import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FormMain extends javax.swing.JFrame {

	private static final long serialVersionUID=1L;
	private AssemblyMachine maquina;
	
    public FormMain() {
        initComponents();
		String caminho="";
		try{
			while(caminho.equals("")){
				JFrame parent=new JFrame();
				JFileChooser chooser=new JFileChooser();
				int returnVal=chooser.showOpenDialog(parent);
				if(returnVal==JFileChooser.APPROVE_OPTION)
					caminho=chooser.getSelectedFile().getAbsolutePath();
			}
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
			maquina=new AssemblyMachine(hash, programa);
			System.out.println("maquina pronta");
			Load();
		}catch(FileNotFoundException e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro no arquivo "+caminho);
		}
		Update();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        AH = new javax.swing.JTextField();
        AL = new javax.swing.JTextField();
        BH = new javax.swing.JTextField();
        BL = new javax.swing.JTextField();
        CH = new javax.swing.JTextField();
        CL = new javax.swing.JTextField();
        DL = new javax.swing.JTextField();
        DH = new javax.swing.JTextField();
        ZF = new javax.swing.JTextField();
        IC = new javax.swing.JTextField();
        SF = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        reload = new javax.swing.JButton();
        previous = new javax.swing.JButton();
        next = new javax.swing.JButton();
        last = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("AX");
        jLabel2.setText("BX");
        jLabel3.setText("CX");
        jLabel4.setText("DX");
        jLabel5.setText("IC");
        jLabel6.setText("ZF");
        jLabel7.setText("SF");
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        reload.setText("Recarregar");
        reload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reloadActionPerformed(evt);
            }
        });
        previous.setText("Anterior");
        previous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousActionPerformed(evt);
            }
        });
        next.setText("Proximo");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });
        last.setText("Ultimo");
        last.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(IC, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ZF, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(SF, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(AH, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AL, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BH, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BL, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CH, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CL, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(DH, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DL, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(reload, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(previous, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(last, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(reload, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                        .addComponent(previous, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(next, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(last, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(AH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(BH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(CH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(DH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(IC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(ZF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(SF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void Update(){
		AH.setText(""+maquina.getN("AH"));
		AL.setText(""+maquina.getN("AL"));
		BH.setText(""+maquina.getN("BH"));
		BL.setText(""+maquina.getN("BL"));
		CH.setText(""+maquina.getN("CH"));
		CL.setText(""+maquina.getN("CL"));
		DH.setText(""+maquina.getN("DH"));
		DL.setText(""+maquina.getN("DL"));
		IC.setText(""+maquina.getN("IC"));
		SF.setText(""+maquina.getN("SF"));
		ZF.setText(""+maquina.getN("ZF"));
	}

    private void reloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reloadActionPerformed
		maquina.ORG("100h");
		Update();
    }//GEN-LAST:event_reloadActionPerformed

    private void previousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousActionPerformed
		int r=maquina.Previous();
		if(r>0){
			maquina.ORG("100h");
			for(int l=r-1; l>0; l--)
				if(maquina.isrunning())
					run();
		}
		Update();
    }//GEN-LAST:event_previousActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
		if(maquina.isrunning())
			run();
		Update();
    }//GEN-LAST:event_nextActionPerformed

    private void lastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastActionPerformed
		while(maquina.isrunning())
			run();
		Update();
    }//GEN-LAST:event_lastActionPerformed

	private void run(){
		ArrayList<String> commands=maquina.Next();
		while(commands.size()==0)
			commands=maquina.Next();
		System.out.println(commands.get(0));
		AssemblyOperations(commands);
		maquina.INC("IC");
	}

	private void Load(){
		ArrayList<String> w=maquina.Load();
		for(String s:w)
			jTextArea1.append(s+"\n");
		while(maquina.isrunning())
			run();
	}

	private void AssemblyOperations(ArrayList<String> commands){
		String function=commands.get(0);
		if(function.equals("MOV"))
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

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AH;
    private javax.swing.JTextField AL;
    private javax.swing.JTextField BH;
    private javax.swing.JTextField BL;
    private javax.swing.JTextField CH;
    private javax.swing.JTextField CL;
    private javax.swing.JTextField DH;
    private javax.swing.JTextField DL;
    private javax.swing.JTextField IC;
    private javax.swing.JTextField SF;
    private javax.swing.JTextField ZF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton last;
    private javax.swing.JButton next;
    private javax.swing.JButton previous;
    private javax.swing.JButton reload;
    // End of variables declaration//GEN-END:variables
}
