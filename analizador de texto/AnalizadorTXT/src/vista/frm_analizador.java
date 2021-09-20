/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Edicion
 */
public class frm_analizador extends javax.swing.JFrame {

    JFileChooser seleccionar=new JFileChooser();
    File archivo;
    FileInputStream entrada;
    FileOutputStream salida;
    /**
     * Creates new form frm_analizador
     */
    public frm_analizador() {
        initComponents();
        setLocationRelativeTo(null);
    }
  
     
    public void Palabras_pares_impares(String cadena, int contador){
        String[] words = cadena.split("\\s+");
        int par=0;
        int impar=0;
        for (int i = 0; i <= contador; i++) {
                words[i] = words[i].replaceAll("[^\\w]", "");
                int par_impar = words[i].length();
                System.out.println(par_impar);
                if (par_impar % 2 == 0){
                    impar += 1;
                    txt_par.setText("" + impar);
                    
                }else{
                    par += 1;
                    txt_impar.setText("" + par);
                }
                
        }
        
        
    }
    
    public void Repeticiones_letra_u(String cadena){
        int contadorVocales = 0;
        char letraArray[] = cadena.toCharArray();
        char letra = letraArray[0];
        int contadorLetraRepetida = 0;

        for(int i=0; i<cadena.length(); i++){
            switch(cadena.charAt(i)){
                case 'u': case 'U': case 'ú':
                    contadorVocales++;
                    break;
            }
        }
        txt_u.setText("" + contadorVocales);
    }
    
    public void Repeticiones_letra_o(String cadena){
        int contadorVocales = 0;
        char letraArray[] = cadena.toCharArray();
        char letra = letraArray[0];
        int contadorLetraRepetida = 0;

        for(int i=0; i<cadena.length(); i++){
            switch(cadena.charAt(i)){
                case 'o': case 'O': case 'ó':
                    contadorVocales++;
                    break;
            }
        }
        txt_o.setText("" + contadorVocales);
    }
    
    public void Repeticiones_letra_i(String cadena){
        int contadorVocales = 0;
        char letraArray[] = cadena.toCharArray();
        char letra = letraArray[0];
        int contadorLetraRepetida = 0;

        for(int i=0; i<cadena.length(); i++){
            switch(cadena.charAt(i)){
                case 'i': case 'I': case 'í':
                    contadorVocales++;
                    break;
            }
        }
        txt_i.setText("" + contadorVocales);
    }
    
    public void Repeticiones_letra_e(String cadena){
        int contadorVocales = 0;
        char letraArray[] = cadena.toCharArray();
        char letra = letraArray[0];
        int contadorLetraRepetida = 0;

        for(int i=0; i<cadena.length(); i++){
            switch(cadena.charAt(i)){
                case 'e': case 'E': case 'é':
                    contadorVocales++;
                    break;
            }
        }
        txt_e.setText("" + contadorVocales);
    }
    
     public void Repeticiones_letra_a(String cadena){
        int contadorVocales = 0;
        char letraArray[] = cadena.toCharArray();
        char letra = letraArray[0];
        int contadorLetraRepetida = 0;

        for(int i=0; i<cadena.length(); i++){
            switch(cadena.charAt(i)){
                case 'a': case 'A': case 'á':
                    contadorVocales++;
                    break;
            }
        }
        txt_a.setText("" + contadorVocales);
    }
    
    public void ultimapalabra(){
    String longitud=txt_area.getText();
        int cadena=longitud.lastIndexOf(" ");
        String ult=longitud.substring(cadena);
        txt_ultpalab.setText(ult);

    }    
     public void Palabra_central(String cadena, int contador){    
        String[] words = cadena.split("\\s+");
        int mitad = contador/2;
        if (contador%2!=0){
            mitad = mitad + 1;
        }
        int contador2 = mitad - 1;
        for (int i = 0; i <= mitad; i++) {
            if(i == contador2){
                words[i] = words[i].replaceAll("[^\\w]", "");
                txt_palabc.setText("" + words[i]);
            }
        }
        
    }
    
    public void letrac(){   
    String longitud=txt_area.getText();
     int num = longitud.length();
    for (int i=0;i<=(num-1);i++){
        int j=i/2;
        char cadena=longitud.charAt(j);
        txt_letrac.setText(String.valueOf(cadena));
        }
    }   
    public void ultletra(){
    String longitud=txt_area.getText();
     int num = longitud.length();
    for (int i=0;i<=(num-1);i++){
        char cadena=longitud.charAt(i);
        txt_ultletra.setText(String.valueOf(cadena));
    }
    }       
    public void primerletra(){
    String longitud=txt_area.getText();
        char cadena=longitud.charAt(0);
        txt_1letra.setText(String.valueOf(cadena));
    }    
    public void longitudpalabras(){
    String longitud=txt_area.getText();
    StringTokenizer st= new StringTokenizer(longitud);
        txt_palab.setText(""+st.countTokens());
    
    }    
    
    public void longitud(){
    String longitud=txt_area.getText();
    int cadena=longitud.length();
        txt_long.setText(String.valueOf(cadena));
    
    }    
    public void copiar(String copiar){
        StringSelection ss=new StringSelection(copiar);
        Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
        cb.setContents(ss, null);
    }
    
    public String pegar(){
        String resultado="";
        Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable contenido=cb.getContents(null);
        if(contenido.isDataFlavorSupported(DataFlavor.stringFlavor)){
            try {
                resultado=(String) contenido.getTransferData(DataFlavor.stringFlavor);
            } catch (UnsupportedFlavorException | IOException ex) {
               JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        return resultado;
    }
    
    public String AbrirArchivo (File archivo){
        String documento="";
            try{
                entrada=new FileInputStream(archivo);
                int ascci;
                while((ascci=entrada.read())!=-1){
                    char caracter=(char)ascci;
                    documento+=caracter;
                }
            }catch(IOException e){
            }
            return documento;    
        }

    public String GuardarArchivo (File archivo,String documento){
        String mensaje=null;
        try{
            salida=new FileOutputStream(archivo);
            byte[]bytxt=documento.getBytes();
            salida.write(bytxt);
            mensaje="Archivo Guardado";
        }catch(IOException e){
        }
        return mensaje;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_area = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txt_long = new javax.swing.JTextField();
        txt_palab = new javax.swing.JTextField();
        txt_1letra = new javax.swing.JTextField();
        txt_ultletra = new javax.swing.JTextField();
        txt_letrac = new javax.swing.JTextField();
        txt_1p = new javax.swing.JTextField();
        txt_a = new javax.swing.JTextField();
        txt_e = new javax.swing.JTextField();
        txt_i = new javax.swing.JTextField();
        txt_o = new javax.swing.JTextField();
        txt_u = new javax.swing.JTextField();
        txt_par = new javax.swing.JTextField();
        txt_impar = new javax.swing.JTextField();
        txt_palabc = new javax.swing.JTextField();
        txt_ultpalab = new javax.swing.JTextField();
        txt_murcielago = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PROGRAMACION II");

        jLabel1.setFont(new java.awt.Font("The Bold Font", 1, 14)); // NOI18N
        jLabel1.setText("TRADUCCIÓN A CLAVE MURCIELAGO");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Ingrese un texto o abra un archivo");

        jScrollPane1.setViewportView(txt_area);

        jButton1.setText("Procesar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Longitud del Texto:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Total de Palabras:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Primera letra del texto:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Última letra del texto:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Letra central del texto:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Primera Palabra:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Palabra Central:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Última Palabra:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Repeticiones de \"A\", \"a\" ó \"á\":");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Repeticiones de \"E\", \"e\" ó \"é\":");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Repeticiones de \"I\", \"i\" ó \"í\":");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Repeticiones de \"O\", \"o\" u \"ó\":");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Repeticiones de \"U\", \"u\" ó \"ú\":");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Palabras con cantidad de caracteres par:");

        jLabel18.setFont(new java.awt.Font("The Bold Font", 1, 14)); // NOI18N
        jLabel18.setText("Manejo de Cadenas");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Palabras con cantidad de caracteres impar:");

        txt_long.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_longActionPerformed(evt);
            }
        });

        txt_palab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_palabActionPerformed(evt);
            }
        });

        txt_1letra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_1letraActionPerformed(evt);
            }
        });

        txt_ultletra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ultletraActionPerformed(evt);
            }
        });

        txt_letrac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_letracActionPerformed(evt);
            }
        });

        txt_1p.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_1pActionPerformed(evt);
            }
        });

        txt_a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_aActionPerformed(evt);
            }
        });

        txt_e.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_eActionPerformed(evt);
            }
        });

        txt_i.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_iActionPerformed(evt);
            }
        });

        txt_o.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_oActionPerformed(evt);
            }
        });

        txt_u.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_uActionPerformed(evt);
            }
        });

        txt_par.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_parActionPerformed(evt);
            }
        });

        txt_impar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_imparActionPerformed(evt);
            }
        });

        txt_palabc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_palabcActionPerformed(evt);
            }
        });

        txt_ultpalab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ultpalabActionPerformed(evt);
            }
        });

        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txt_ultpalab))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txt_ultletra, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txt_letrac, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txt_1p))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txt_palabc))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txt_palab))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txt_long, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txt_1letra, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(16, 16, 16)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel14)
                                                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addComponent(jLabel19)
                                            .addComponent(jLabel16))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_a, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_e, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_i, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_o, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_u, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_par, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_impar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(92, 92, 92)
                                        .addComponent(jLabel1)))
                                .addGap(0, 7, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(jLabel18)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_murcielago)
                .addGap(17, 17, 17))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(101, 101, 101))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txt_long, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_a, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txt_palab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_e, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txt_1letra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_i, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txt_ultletra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_o, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(txt_letrac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_u, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(txt_1p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_par, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(txt_impar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_palabc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ultpalab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_murcielago, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                .addContainerGap())
        );

        jDesktopPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jMenu1.setText("Archivo");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setText("Abrir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem2.setText("Guardar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F12, 0));
        jMenuItem3.setText("Guardar Como");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Editar");

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem4.setText("Copiar");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem5.setText("Cortar");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem6.setText("Pegar");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem7.setText("Buscar");
        jMenu2.add(jMenuItem7);

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem8.setText("Reemplazar");
        jMenu2.add(jMenuItem8);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        if(seleccionar.showDialog(null, "Abrir")==JFileChooser.APPROVE_OPTION){
            archivo=seleccionar.getSelectedFile();
            if(archivo.canRead()){
                if(archivo.getName().endsWith("txt")){
                    String documento=AbrirArchivo(archivo);
                    txt_area.setText(documento);
                }else{
                    JOptionPane.showMessageDialog(null, "Archivo No Compatible");
                }
            }
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
       
            archivo=seleccionar.getSelectedFile();
            if(archivo.getName().endsWith("txt")){
                String Documento=txt_area.getText();
                String mensaje=GuardarArchivo(archivo,Documento);
                if(mensaje!=null){
                    JOptionPane.showMessageDialog(null, mensaje);
                }else{
                JOptionPane.showMessageDialog(null, "Archivo No Compatible");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Guardar Documento de Texto");
            }
        
                       
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        if(seleccionar.showDialog(null, "Guardar")==JFileChooser.APPROVE_OPTION){
            archivo=seleccionar.getSelectedFile();
            if(archivo.getName().endsWith("txt")){
                String Documento=txt_area.getText();
                String mensaje=GuardarArchivo(archivo,Documento);
                if(mensaje!=null){
                    JOptionPane.showMessageDialog(null, mensaje);
                }else{
                JOptionPane.showMessageDialog(null, "Archivo No Compatible");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Guardar Documento de Texto");
            }
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        copiar(txt_area.getText());
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        copiar(txt_area.getText());
        txt_area.setText("");
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        txt_area.setText(pegar());
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void txt_longActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_longActionPerformed
        // TODO add your handling code here:
      
    
    }//GEN-LAST:event_txt_longActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String cadena_completa;
       cadena_completa = txt_area.getText();
       
        int contador = 1, pos;
        cadena_completa = cadena_completa.trim();                              
        if (cadena_completa.isEmpty()) { 
            contador = 0;
        } else {
                pos = cadena_completa.indexOf(" "); 
                while (pos != -1) {   //mientras que se encuentre un espacio en blanco
                       contador++;    //se cuenta una palabra
                       pos = cadena_completa.indexOf(" ", pos + 1); //se busca el siguiente espacio en blanco                       
                }                                     //a continuación del actual
        }
         
        
        
        longitud();
        longitudpalabras();
        primerletra();
        ultletra();
        letrac();
        
        StringTokenizer tokens = new StringTokenizer(cadena_completa);
        String primeraPalabra = tokens.nextToken();
        txt_1p.setText("" +primeraPalabra);
        
        String frase = txt_area.getText();
        Clave_murcielago(frase);
        
        Palabra_central(cadena_completa,contador);
        ultimapalabra();
        Repeticiones_letra_a(cadena_completa);
        Repeticiones_letra_e(cadena_completa);
        Repeticiones_letra_i(cadena_completa);
        Repeticiones_letra_o(cadena_completa);
        Repeticiones_letra_u(cadena_completa);
        Palabras_pares_impares(cadena_completa,contador);
         
      
    }//GEN-LAST:event_jButton1ActionPerformed

      public void Clave_murcielago(String frase){
 //System.out.println(frase);
          Scanner sc = new Scanner(System.in);
        char[] cadena = new char[900];
        
        //Sentencia for aninidada de if en la cual comprobaremos la cadena de texto enviada!
        for(int i=0; i<frase.length(); i++)
        {
            
            //Con estos if comprobamos las letras que se ingresan
            switch (frase.charAt(i)) {
                case 'M':
                case 'm':
                    cadena[i] = '0';
                    //System.out.println("0");
                    break;
                case 'U':
                case 'u':
                    cadena[i] = '1';
                    //System.out.println("1");
                    break;
                case 'R':
                case 'r':
                    cadena[i] = '2';
                    //System.out.println("2");
                    break;
                case 'C':
                case 'c':
                    cadena[i] = '3';
                    //System.out.println("3");
                    break;
                case 'I':
                case 'i':
                    cadena[i] = '4';
                    //System.out.println("4");
                    break;
                case 'E':
                case 'e':
                    cadena[i] = '5';
                    //System.out.println("5");
                    break;
                case 'L':
                case 'l':
                    cadena[i] = '6';
                    //System.out.println("6");
                    break;
                case 'A':
                case 'a':
                    cadena[i] = '7';
                    //System.out.println("7");
                    break;
                case 'G':
                case 'g':
                    cadena[i] = '8';
                    //System.out.println("8");
                    break;
                case 'O':
                case 'o':
                    cadena[i] = '9';
                    //System.out.println("9");
                    break;
                default:
                    cadena[i] = frase.charAt(i);
                    break;
            }
        String resultado = String.valueOf(cadena);
        //System.out.println(cadena);
        //System.out.println(resultado);
       txt_murcielago.setText(resultado);
      
        }
    }
    
    private void txt_palabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_palabActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_palabActionPerformed

    private void txt_1letraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_1letraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_1letraActionPerformed

    private void txt_ultletraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ultletraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ultletraActionPerformed

    private void txt_letracActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_letracActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_letracActionPerformed

    private void txt_1pActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_1pActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_1pActionPerformed

    private void txt_aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_aActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_aActionPerformed

    private void txt_eActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_eActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_eActionPerformed

    private void txt_iActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_iActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_iActionPerformed

    private void txt_oActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_oActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_oActionPerformed

    private void txt_uActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_uActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_uActionPerformed

    private void txt_parActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_parActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_parActionPerformed

    private void txt_imparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_imparActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_imparActionPerformed

    private void txt_palabcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_palabcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_palabcActionPerformed

    private void txt_ultpalabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ultpalabActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ultpalabActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frm_analizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_analizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_analizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_analizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_analizador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txt_1letra;
    private javax.swing.JTextField txt_1p;
    private javax.swing.JTextField txt_a;
    private javax.swing.JTextField txt_area;
    private javax.swing.JTextField txt_e;
    private javax.swing.JTextField txt_i;
    private javax.swing.JTextField txt_impar;
    private javax.swing.JTextField txt_letrac;
    private javax.swing.JTextField txt_long;
    private javax.swing.JTextField txt_murcielago;
    private javax.swing.JTextField txt_o;
    private javax.swing.JTextField txt_palab;
    private javax.swing.JTextField txt_palabc;
    private javax.swing.JTextField txt_par;
    private javax.swing.JTextField txt_u;
    private javax.swing.JTextField txt_ultletra;
    private javax.swing.JTextField txt_ultpalab;
    // End of variables declaration//GEN-END:variables
}
