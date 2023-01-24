/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package IfspLife;

/**
 *
 * @author xandy
 */
public class BuscarProdutos extends javax.swing.JFrame {

    /**
     * Creates new form BuscarProdutos
     */
    public BuscarProdutos() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BackGroundImage = new javax.swing.JPanel();
        logoIFSP_LIFE = new javax.swing.JLabel();
        JLabel_Titulo = new javax.swing.JLabel();
        JLabel_CodigoDoProduto = new javax.swing.JLabel();
        JTextField_CodigoDoProduto = new javax.swing.JTextField();
        JLabel_ProcurarCodigoProduto = new javax.swing.JLabel();
        JLabel_NomeDoProduto = new javax.swing.JLabel();
        JTextField_NomeDoProduto = new javax.swing.JTextField();
        JLabel_ProcurarNomeProduto = new javax.swing.JLabel();
        JSeparador = new javax.swing.JSeparator();
        JscrollPane_DadosProdutos = new javax.swing.JScrollPane();
        JTable_Produtos = new javax.swing.JTable();
        BackGroundImageGradient = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BackGroundImage.setMaximumSize(new java.awt.Dimension(900, 500));
        BackGroundImage.setMinimumSize(new java.awt.Dimension(900, 500));
        BackGroundImage.setPreferredSize(new java.awt.Dimension(900, 500));
        BackGroundImage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logoIFSP_LIFE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoIFSP_LIFE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SplashScreen/Assets/default_transparent_765x625_resized.png"))); // NOI18N
        BackGroundImage.add(logoIFSP_LIFE, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 140, 140));

        JLabel_Titulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        JLabel_Titulo.setForeground(new java.awt.Color(255, 255, 255));
        JLabel_Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLabel_Titulo.setText("Buscar Produtos");
        BackGroundImage.add(JLabel_Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 900, 60));

        JLabel_CodigoDoProduto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        JLabel_CodigoDoProduto.setForeground(new java.awt.Color(255, 255, 255));
        JLabel_CodigoDoProduto.setText("Codigo do Produto:");
        BackGroundImage.add(JLabel_CodigoDoProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, -1, -1));
        BackGroundImage.add(JTextField_CodigoDoProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, 170, 20));

        JLabel_ProcurarCodigoProduto.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        JLabel_ProcurarCodigoProduto.setForeground(new java.awt.Color(255, 255, 255));
        JLabel_ProcurarCodigoProduto.setText("Procurar por Codigo_Remédio");
        BackGroundImage.add(JLabel_ProcurarCodigoProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, -1, -1));

        JLabel_NomeDoProduto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        JLabel_NomeDoProduto.setForeground(new java.awt.Color(255, 255, 255));
        JLabel_NomeDoProduto.setText("Nome do Produto:");
        BackGroundImage.add(JLabel_NomeDoProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 90, -1, -1));
        BackGroundImage.add(JTextField_NomeDoProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 90, 170, 20));

        JLabel_ProcurarNomeProduto.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        JLabel_ProcurarNomeProduto.setForeground(new java.awt.Color(255, 255, 255));
        JLabel_ProcurarNomeProduto.setText("Procurar por Nome_Remédio");
        BackGroundImage.add(JLabel_ProcurarNomeProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 120, -1, -1));
        BackGroundImage.add(JSeparador, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 880, 10));

        JTable_Produtos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nome", "Valor", "Vencimento", "Tipo", "Quantidade"
            }
        ));
        JscrollPane_DadosProdutos.setViewportView(JTable_Produtos);

        BackGroundImage.add(JscrollPane_DadosProdutos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 880, 340));

        BackGroundImageGradient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SplashScreen/Assets/gradient.png"))); // NOI18N
        BackGroundImageGradient.setText("jLabel1");
        BackGroundImage.add(BackGroundImageGradient, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackGroundImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackGroundImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(BuscarProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscarProdutos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BackGroundImage;
    private javax.swing.JLabel BackGroundImageGradient;
    private javax.swing.JLabel JLabel_CodigoDoProduto;
    private javax.swing.JLabel JLabel_NomeDoProduto;
    private javax.swing.JLabel JLabel_ProcurarCodigoProduto;
    private javax.swing.JLabel JLabel_ProcurarNomeProduto;
    private javax.swing.JLabel JLabel_Titulo;
    private javax.swing.JSeparator JSeparador;
    private javax.swing.JTable JTable_Produtos;
    private javax.swing.JTextField JTextField_CodigoDoProduto;
    private javax.swing.JTextField JTextField_NomeDoProduto;
    private javax.swing.JScrollPane JscrollPane_DadosProdutos;
    private javax.swing.JLabel logoIFSP_LIFE;
    // End of variables declaration//GEN-END:variables
}
