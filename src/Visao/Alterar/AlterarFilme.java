package Visao.Alterar;

import DAO.CategoriaDAO;
import DAO.ClassificacaoDAO;
import DAO.Conexao;
import DAO.FilmeDAO;
import Modelo.Categoria;
import Modelo.Classificacao;
import Modelo.Filme;
import java.io.File;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class AlterarFilme extends javax.swing.JFrame {
    public AlterarFilme() {
        initComponents();
        AtualizaCombo1();
        AtualizaCombo2();
        setResizable(false);
        setLocationRelativeTo(this);
        setTitle("Video Locadora");
    }
 private void InserirDados(int cod){
        Connection con = Conexao.AbrirConexao();
        FilmeDAO sql = new FilmeDAO(con);
        List<Filme> lista = new ArrayList<>();
        lista = sql.CapturarFilme(cod);
        for(Filme f :lista){
            jTextField1.setText(""+f.getCode());
            jTextField2.setText(""+f.getTitulo());
            jTextField3.setText(""+f.getAno());
            jFormattedTextField1.setText(""+f.getDuracao());
            jTextField6.setText(""+f.getIdcategoria());
            jTextField7.setText(""+f.getIdclassificacao());
            jTextField4.setText(""+f.getCapa());
        }
 }
 
    private void AtualizaCombo1(){
        Connection con = Conexao.AbrirConexao();
        CategoriaDAO sql = new CategoriaDAO(con);
        List<Categoria> lista = new ArrayList<>();
        lista =  sql.ListarComboCategoria();
        jComboBox1.addItem("");
        
        for(Categoria c :lista){
        jComboBox1.addItem(c.getNome());
        }
        Conexao.FecharConexao(con);
    }
    
    private void AtualizaCombo2(){
        Connection con = Conexao.AbrirConexao();
        ClassificacaoDAO sql = new ClassificacaoDAO(con);
        List<Classificacao> lista = new ArrayList<>();
        lista =  sql.ListarComboClassificacao();
        jComboBox2.addItem("");
        
        for(Classificacao c :lista){
        jComboBox2.addItem(c.getNome());
        }
        Conexao.FecharConexao(con);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(null);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(null);

        jLabel2.setText("Código:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(40, 20, 50, 30);
        jPanel2.add(jTextField1);
        jTextField1.setBounds(90, 20, 80, 30);

        jLabel3.setText("Título:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(40, 70, 50, 30);
        jPanel2.add(jTextField2);
        jTextField2.setBounds(90, 70, 360, 30);
        jPanel2.add(jTextField3);
        jTextField3.setBounds(90, 130, 110, 30);

        jLabel4.setText("Ano");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(40, 130, 50, 30);
        jPanel2.add(jTextField4);
        jTextField4.setBounds(90, 280, 290, 30);

        jLabel5.setText("Capa:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(40, 280, 50, 30);

        jLabel6.setText("Duração:");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(250, 130, 70, 30);

        jLabel7.setText("Categoria:");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(20, 180, 70, 30);
        jPanel2.add(jTextField6);
        jTextField6.setBounds(90, 180, 40, 30);

        jLabel8.setText("Classificação:");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(10, 230, 90, 30);
        jPanel2.add(jTextField7);
        jTextField7.setBounds(90, 230, 40, 30);

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox1);
        jComboBox1.setBounds(150, 180, 300, 30);

        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox2);
        jComboBox2.setBounds(150, 230, 300, 30);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Captura de Tela (150).png"))); // NOI18N
        jLabel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.add(jLabel9);
        jLabel9.setBounds(460, 90, 280, 150);

        jButton2.setText("Ok");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);
        jButton2.setBounds(390, 280, 60, 30);

        try {
            jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel2.add(jFormattedTextField1);
        jFormattedTextField1.setBounds(333, 130, 110, 30);

        jButton3.setText("Ok");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);
        jButton3.setBounds(180, 20, 60, 30);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 80, 780, 340);

        jButton6.setText("Salvar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6);
        jButton6.setBounds(130, 440, 120, 50);

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(470, 440, 120, 50);

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Alterar Filme");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 780, 80);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        Connection con = Conexao.AbrirConexao();
        CategoriaDAO sql = new CategoriaDAO(con);
        List<Categoria> lista = new ArrayList<>();
        String nome = jComboBox1.getSelectedItem().toString();
        lista = sql.ConsultaCodigoCategoria(nome);
        if(nome.equals("")){
            jTextField6.setText("");
        }
        for(Categoria c : lista){
            int cod = c.getCode();
            jTextField6.setText(""+cod);
        }
        Conexao.FecharConexao(con);
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        Connection con = Conexao.AbrirConexao();
        ClassificacaoDAO sql = new ClassificacaoDAO(con);
        List<Classificacao> lista = new ArrayList<>();
        String nome = jComboBox2.getSelectedItem().toString();
        lista = sql.ConsultaCodigoClassificacao(nome);

        for(Classificacao c : lista){
            int cod = c.getCode();
            jTextField7.setText(""+cod);
        }
        Conexao.FecharConexao(con);
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try{
            JFileChooser foto = new JFileChooser();
            foto.setCurrentDirectory( new File("/C:/Users/Rudinilly/Documents/NetBeansProjects/LocadoraRudinilly/build/classes/Imagens"));
            foto.setDialogTitle("Carregar Capa");
            foto.showOpenDialog(this);
            String a = ""+foto.getSelectedFile().getName();
            jTextField4.setText(a);
            jLabel9.setIcon(new ImageIcon("/C:/Users/Rudinilly/Documents/NetBeansProjects/LocadoraRudinilly/build/classes/Imagens/"+jTextField4.getText()+"/"));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"não foi possível carregar capa");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        int code = Integer.parseInt(jTextField1.getText());
        String titulo = jTextField2.getText();
        int ano = Integer.parseInt(jTextField3.getText());
        String duracao = jFormattedTextField1.getText();
        int idcategoria = Integer.parseInt(jTextField6.getText());
        int idclassificacao = Integer.parseInt(jTextField7.getText());
        String capa = jTextField4.getText();
        if(titulo.equalsIgnoreCase("")||duracao.equalsIgnoreCase("")||capa.equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null,"Todos os Campos Precisam ser Preenchidos","Erro",JOptionPane.WARNING_MESSAGE);

        }else{
            Connection con = Conexao.AbrirConexao();
            FilmeDAO sql = new FilmeDAO(con);
            Filme f = new Filme();
            f.setTitulo(titulo);
            f.setAno(ano);
            f.setDuracao(duracao);
            f.setIdcategoria(idcategoria);
            f.setIdclassificacao(idclassificacao);
            f.setCapa(capa);
            f.setCode(code);
            sql.Alterar_Filme(f);

            Conexao.FecharConexao(con);

            jTextField2.setText("");
            jTextField3.setText("");

            JOptionPane.showMessageDialog(null,"Inserido Com Sucesso","Mensagem",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
  String codigo = jTextField1.getText();
        int cod = 0;
        Connection con = Conexao.AbrirConexao();
        FilmeDAO sql = new FilmeDAO(con);

                
        if(codigo.equals("")){
            JOptionPane.showMessageDialog(null,"Digite um Código Para Atualizar","Erro",JOptionPane.WARNING_MESSAGE);
            jTextField2.setText("");
            jTextField3.setText("");
        }else{
        cod = Integer.parseInt(codigo);
        if(sql.Testar_Filme(cod)==false){
              JOptionPane.showMessageDialog(null,"Filme não encontrado","Erro",JOptionPane.ERROR_MESSAGE);
              jTextField2.setText("");
              jTextField3.setText("");
              Conexao.FecharConexao(con);
        }else{
        jTextField2.setText("");
        jTextField3.setText("");
       
        InserirDados(cod);
        }
        }
           
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(AlterarFilme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlterarFilme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlterarFilme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlterarFilme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlterarFilme().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
