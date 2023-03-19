package ifsplife.form;

public class Form_Profile extends javax.swing.JPanel {

    public Form_Profile() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder2 = new ifsplife.dev.swing.PanelBorder();
        txtNome = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        JLabelNome = new javax.swing.JLabel();
        JTextFieldNome = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        JLabelDataNascimento = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        JTextFieldEmail = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabelEndereco = new javax.swing.JLabel();
        JTextFieldEndereco = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabelContato = new javax.swing.JLabel();
        JFormatedTextFieldContato = new javax.swing.JFormattedTextField();
        Separador = new javax.swing.JSeparator();
        jLabelCidade = new javax.swing.JLabel();
        JTextFieldCidade = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        JLabelCargo = new javax.swing.JLabel();
        JComboBoxCargo = new javax.swing.JComboBox<>();
        jLabelEstado = new javax.swing.JLabel();
        JComboBoxEstados = new javax.swing.JComboBox<>();
        JButtonAlterarDados = new ifsplife.dev.swing.PanelBorderGradient();
        jLabel16 = new javax.swing.JLabel();
        JButtonAlterarSenha = new ifsplife.dev.swing.PanelBorderGradient();
        jLabel15 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(239, 239, 239));
        setLayout(new java.awt.GridLayout(1, 0));

        panelBorder2.setBackground(new java.awt.Color(255, 255, 255));

        txtNome.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        txtNome.setText("jLabel1");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        JLabelNome.setText("Nome");

        JTextFieldNome.setBorder(null);

        JLabelDataNascimento.setText("Data de Nascimento");

        jLabelEmail.setText("Email");

        JTextFieldEmail.setBorder(null);

        jLabelEndereco.setText("Endereço");

        JTextFieldEndereco.setBorder(null);

        jLabelContato.setText("Contato");

        JFormatedTextFieldContato.setBorder(null);
        try {
            JFormatedTextFieldContato.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabelCidade.setText("Cidade");

        JTextFieldCidade.setBorder(null);

        JLabelCargo.setText("Cargo");

        JComboBoxCargo.setEditable(true);
        JComboBoxCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gerente", "Atendente", "Pizzaiolo" }));

        jLabelEstado.setText("Estado");

        JComboBoxEstados.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        JComboBoxEstados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JComboBoxEstadosActionPerformed(evt);
            }
        });

        JButtonAlterarDados.setPreferredSize(new java.awt.Dimension(112, 35));

        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Alterar Dados");

        javax.swing.GroupLayout JButtonAlterarDadosLayout = new javax.swing.GroupLayout(JButtonAlterarDados);
        JButtonAlterarDados.setLayout(JButtonAlterarDadosLayout);
        JButtonAlterarDadosLayout.setHorizontalGroup(
            JButtonAlterarDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
        );
        JButtonAlterarDadosLayout.setVerticalGroup(
            JButtonAlterarDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        JButtonAlterarSenha.setPreferredSize(new java.awt.Dimension(112, 35));

        jLabel15.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Alterar Senha");

        javax.swing.GroupLayout JButtonAlterarSenhaLayout = new javax.swing.GroupLayout(JButtonAlterarSenha);
        JButtonAlterarSenha.setLayout(JButtonAlterarSenhaLayout);
        JButtonAlterarSenhaLayout.setHorizontalGroup(
            JButtonAlterarSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
        );
        JButtonAlterarSenhaLayout.setVerticalGroup(
            JButtonAlterarSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelEndereco, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelEmail, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(252, 252, 252))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator1)
                            .addComponent(JLabelNome)
                            .addComponent(JTextFieldNome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(JLabelDataNascimento)
                        .addGap(0, 347, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(JComboBoxCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabelEstado)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(JComboBoxEstados, 0, 374, Short.MAX_VALUE)))
                            .addComponent(jSeparator2)
                            .addComponent(jSeparator4)
                            .addComponent(JTextFieldEndereco)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabelContato)
                                    .addComponent(JLabelCargo)
                                    .addComponent(Separador)
                                    .addComponent(JFormatedTextFieldContato, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabelCidade)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(JTextFieldCidade, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jSeparator7)))
                            .addComponent(JTextFieldEmail))
                        .addGap(6, 6, 6))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JButtonAlterarDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JButtonAlterarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLabelNome)
                    .addComponent(JLabelDataNascimento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabelEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelEndereco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTextFieldEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelContato)
                    .addComponent(jLabelCidade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JFormatedTextFieldContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTextFieldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator7)
                    .addComponent(Separador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLabelCargo)
                    .addComponent(jLabelEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JComboBoxCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JComboBoxEstados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JButtonAlterarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JButtonAlterarDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelBorder2Layout = new javax.swing.GroupLayout(panelBorder2);
        panelBorder2.setLayout(panelBorder2Layout);
        panelBorder2Layout.setHorizontalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder2Layout.createSequentialGroup()
                        .addComponent(txtNome)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelBorder2Layout.setVerticalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtNome)
                .addGap(40, 40, 40)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        add(panelBorder2);
    }// </editor-fold>//GEN-END:initComponents

    private void JComboBoxEstadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JComboBoxEstadosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JComboBoxEstadosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ifsplife.dev.swing.PanelBorderGradient JButtonAlterarDados;
    private ifsplife.dev.swing.PanelBorderGradient JButtonAlterarSenha;
    private javax.swing.JComboBox<String> JComboBoxCargo;
    private javax.swing.JComboBox<String> JComboBoxEstados;
    private javax.swing.JFormattedTextField JFormatedTextFieldContato;
    private javax.swing.JLabel JLabelCargo;
    private javax.swing.JLabel JLabelDataNascimento;
    private javax.swing.JLabel JLabelNome;
    private javax.swing.JTextField JTextFieldCidade;
    private javax.swing.JTextField JTextFieldEmail;
    private javax.swing.JTextField JTextFieldEndereco;
    private javax.swing.JTextField JTextFieldNome;
    private javax.swing.JSeparator Separador;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabelCidade;
    private javax.swing.JLabel jLabelContato;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelEndereco;
    private javax.swing.JLabel jLabelEstado;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator7;
    private ifsplife.dev.swing.PanelBorder panelBorder2;
    private javax.swing.JLabel txtNome;
    // End of variables declaration//GEN-END:variables
}
