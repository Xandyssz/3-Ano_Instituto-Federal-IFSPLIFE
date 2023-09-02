package ifsplife.jdialog;

import ifsplife.control.ControleFuncionario;
import ifsplife.control.FuncionarioOuSenhaIncorretaException;
import ifsplife.model.Funcionarios;
import ifsplife.main.Main_adm;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JDialog {

    private boolean senhaVisivel = false;

    public Login(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorderGradient1 = new ifsplife.dev.swing.PanelBorderGradient();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        JLabelNome = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        JSeparatorNome = new javax.swing.JSeparator();
        JLabelSenha = new javax.swing.JLabel();
        JSeparatorSenha = new javax.swing.JSeparator();
        panelBorderGradientLogin = new ifsplife.dev.swing.PanelBorderGradient();
        JLabelCadastrar = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        exibirSenha = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ifsplife/view/icon/ifspLIFE-logo.png"))); // NOI18N

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        JLabelNome.setForeground(new java.awt.Color(255, 255, 255));
        JLabelNome.setText("Login");

        txtLogin.setText("admin");
        txtLogin.setBorder(null);
        txtLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtLoginMouseClicked(evt);
            }
        });

        JLabelSenha.setForeground(new java.awt.Color(255, 255, 255));
        JLabelSenha.setText("Senha");

        panelBorderGradientLogin.setBackground(new java.awt.Color(255, 255, 255));
        panelBorderGradientLogin.setFirstColor(new java.awt.Color(195, 186, 186));
        panelBorderGradientLogin.setSecondColor(new java.awt.Color(51, 51, 51));
        panelBorderGradientLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelBorderGradientLoginMouseClicked(evt);
            }
        });

        JLabelCadastrar.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        JLabelCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        JLabelCadastrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLabelCadastrar.setText("Logar");

        javax.swing.GroupLayout panelBorderGradientLoginLayout = new javax.swing.GroupLayout(panelBorderGradientLogin);
        panelBorderGradientLogin.setLayout(panelBorderGradientLoginLayout);
        panelBorderGradientLoginLayout.setHorizontalGroup(
            panelBorderGradientLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JLabelCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
        );
        panelBorderGradientLoginLayout.setVerticalGroup(
            panelBorderGradientLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JLabelCadastrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ifsplife/view/icon/x.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        txtSenha.setText("admin");

        exibirSenha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ifsplife/view/icon/icons8-visível-25.png"))); // NOI18N
        exibirSenha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exibirSenhaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelBorderGradient1Layout = new javax.swing.GroupLayout(panelBorderGradient1);
        panelBorderGradient1.setLayout(panelBorderGradient1Layout);
        panelBorderGradient1Layout.setHorizontalGroup(
            panelBorderGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorderGradient1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelBorderGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorderGradient1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addGroup(panelBorderGradient1Layout.createSequentialGroup()
                        .addGroup(panelBorderGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorderGradient1Layout.createSequentialGroup()
                                .addGap(119, 119, 119)
                                .addComponent(panelBorderGradientLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBorderGradient1Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addGroup(panelBorderGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(JLabelNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JSeparatorNome, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JLabelSenha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JSeparatorSenha, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                                    .addComponent(txtSenha))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(exibirSenha)))
                        .addGap(0, 45, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelBorderGradient1Layout.setVerticalGroup(
            panelBorderGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
            .addGroup(panelBorderGradient1Layout.createSequentialGroup()
                .addGroup(panelBorderGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorderGradient1Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(JLabelNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JSeparatorNome, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JLabelSenha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBorderGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(exibirSenha))
                        .addGap(4, 4, 4)
                        .addComponent(JSeparatorSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelBorderGradientLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelBorderGradient1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelBorderGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorderGradient1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jSeparator1))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorderGradient1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorderGradient1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtLoginMouseClicked
        txtLogin.setText("");
    }//GEN-LAST:event_txtLoginMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        System.exit(0);
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void panelBorderGradientLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBorderGradientLoginMouseClicked
        try {
            Funcionarios funcionarios = ControleFuncionario.login(txtLogin.getText(), txtSenha.getText());
            if (funcionarios.getNivelacesso().equals("Administrador")) {
                this.dispose();
                Main_adm main = new Main_adm();
                main.setVisible(true);
            } else {
                this.dispose();
                Main_adm main = new Main_adm();
                main.setVisible(true);
            }
        } catch (FuncionarioOuSenhaIncorretaException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            txtSenha.setText("");
        }

    }//GEN-LAST:event_panelBorderGradientLoginMouseClicked

    private void exibirSenhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exibirSenhaMouseClicked

        // Código para alternar a visibilidade da senha
        if (senhaVisivel) {
            txtSenha.setEchoChar('*'); // Ocultar senha
            senhaVisivel = false;
        } else {
            txtSenha.setEchoChar((char) 0); // Mostrar senha
            senhaVisivel = true;
        }
    }//GEN-LAST:event_exibirSenhaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabelCadastrar;
    private javax.swing.JLabel JLabelNome;
    private javax.swing.JLabel JLabelSenha;
    private javax.swing.JSeparator JSeparatorNome;
    private javax.swing.JSeparator JSeparatorSenha;
    private javax.swing.JLabel exibirSenha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private ifsplife.dev.swing.PanelBorderGradient panelBorderGradient1;
    private ifsplife.dev.swing.PanelBorderGradient panelBorderGradientLogin;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
