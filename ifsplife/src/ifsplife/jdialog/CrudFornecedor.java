package ifsplife.jdialog;

import ifsplife.model.Fornecedores;
import javax.swing.JOptionPane;

public class CrudFornecedor extends javax.swing.JDialog {

    private boolean confirmou = false;
    private int codigo = 0;

    public CrudFornecedor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public Fornecedores getFornecedores() {
        Fornecedores fornecedores = new Fornecedores();

        fornecedores.setCodigoFornecedor(codigo);
        fornecedores.setNome(JTextFieldNome.getText());
        fornecedores.setCnpj(JFormatedTextCNPJ.getText());
        fornecedores.setTelefone(JFormatedTextContato.getText());
        fornecedores.setEmail(JTextFieldEmail.getText());
        fornecedores.setEndereco(JTextFieldEndereco.getText());
        fornecedores.setCidade(JTextFieldCidade.getText());
        fornecedores.setCep(JFormatedTextCEP.getText());
        fornecedores.setUf((String) JComboBoxEstado.getSelectedItem());
        return fornecedores;
    }

    public void setFornecedor(Fornecedores fornecedores) {
        this.codigo = fornecedores.getCodigoFornecedor();
        JTextFieldNome.setText(fornecedores.getNome());
        JFormatedTextCNPJ.setText(fornecedores.getCnpj());
        JFormatedTextContato.setText(fornecedores.getTelefone());
        JTextFieldEmail.setText(fornecedores.getEmail());
        JTextFieldEndereco.setText(fornecedores.getEndereco());
        JTextFieldCidade.setText((fornecedores.getCidade()));
        JFormatedTextCEP.setText(fornecedores.getCep());
        JComboBoxEstado.setSelectedItem(fornecedores.getUf());
    }

    public boolean isConfirmou() {
        return confirmou;
    }

    public void desabilitarEdicao() {

        JTextFieldNome.setEditable(false);
        JFormatedTextCNPJ.setEditable(false);
        JFormatedTextContato.setEditable(false);
        JTextFieldEmail.setEditable(false);
        JTextFieldEndereco.setEditable(false);
        JTextFieldCidade.setEditable(false);
        JFormatedTextCEP.setEditable(false);
        JComboBoxEstado.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorderGradient1 = new ifsplife.dev.swing.PanelBorderGradient();
        panelBorder1 = new ifsplife.dev.swing.PanelBorder();
        JLabelCRUD = new javax.swing.JLabel();
        JSeparatorCRUD = new javax.swing.JSeparator();
        JLabelNome = new javax.swing.JLabel();
        JTextFieldNome = new javax.swing.JTextField();
        JSeparatorNome = new javax.swing.JSeparator();
        JLabelCNPJ = new javax.swing.JLabel();
        JFormatedTextCNPJ = new javax.swing.JFormattedTextField();
        JSeparatorCPF = new javax.swing.JSeparator();
        JLabelContato = new javax.swing.JLabel();
        JFormatedTextContato = new javax.swing.JFormattedTextField();
        JSeparatorContato = new javax.swing.JSeparator();
        JLabelEmail = new javax.swing.JLabel();
        JTextFieldEmail = new javax.swing.JTextField();
        JSeparatorEmail = new javax.swing.JSeparator();
        JLabelEndereco = new javax.swing.JLabel();
        JTextFieldEndereco = new javax.swing.JTextField();
        JSeparatorEndereco = new javax.swing.JSeparator();
        JLabelCidade = new javax.swing.JLabel();
        JTextFieldCidade = new javax.swing.JTextField();
        JSeparatorCidade = new javax.swing.JSeparator();
        JLabelCEP = new javax.swing.JLabel();
        JFormatedTextCEP = new javax.swing.JFormattedTextField();
        JSeparatorCEP = new javax.swing.JSeparator();
        JLabelEstado = new javax.swing.JLabel();
        JComboBoxEstado = new javax.swing.JComboBox<>();
        JSeparatorEstado = new javax.swing.JSeparator();
        JButtonCadastrar = new ifsplife.dev.swing.PanelBorderGradient();
        JLabelCadastrar = new javax.swing.JLabel();
        JButtonCancelar = new ifsplife.dev.swing.PanelBorderGradient();
        JLabelCancelar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        panelBorder1.setBackground(new java.awt.Color(239, 239, 239));
        panelBorder1.setPreferredSize(new java.awt.Dimension(411, 317));

        JLabelCRUD.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        JLabelCRUD.setForeground(new java.awt.Color(0, 78, 146));
        JLabelCRUD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLabelCRUD.setText("Cadastro de Fornecedores");

        JLabelNome.setText("Nome");

        JTextFieldNome.setBackground(new java.awt.Color(239, 239, 239));
        JTextFieldNome.setBorder(null);

        JLabelCNPJ.setText("CNPJ");

        JFormatedTextCNPJ.setBackground(new java.awt.Color(239, 239, 239));
        JFormatedTextCNPJ.setBorder(null);
        try {
            JFormatedTextCNPJ.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####.##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        JLabelContato.setText("Contato");

        JFormatedTextContato.setBackground(new java.awt.Color(239, 239, 239));
        JFormatedTextContato.setBorder(null);
        try {
            JFormatedTextContato.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        JLabelEmail.setText("Email");

        JTextFieldEmail.setBackground(new java.awt.Color(239, 239, 239));
        JTextFieldEmail.setBorder(null);

        JLabelEndereco.setText("Endereco");

        JTextFieldEndereco.setBackground(new java.awt.Color(239, 239, 239));
        JTextFieldEndereco.setBorder(null);

        JLabelCidade.setText("Cidade");

        JTextFieldCidade.setBackground(new java.awt.Color(239, 239, 239));
        JTextFieldCidade.setBorder(null);

        JLabelCEP.setText("CEP");

        JFormatedTextCEP.setBackground(new java.awt.Color(239, 239, 239));
        JFormatedTextCEP.setBorder(null);
        try {
            JFormatedTextCEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        JLabelEstado.setText("Estado");

        JComboBoxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));

        JButtonCadastrar.setFirstColor(new java.awt.Color(153, 153, 153));
        JButtonCadastrar.setPreferredSize(new java.awt.Dimension(90, 22));
        JButtonCadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JButtonCadastrarMouseClicked(evt);
            }
        });

        JLabelCadastrar.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        JLabelCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        JLabelCadastrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLabelCadastrar.setText("Cadastrar");

        javax.swing.GroupLayout JButtonCadastrarLayout = new javax.swing.GroupLayout(JButtonCadastrar);
        JButtonCadastrar.setLayout(JButtonCadastrarLayout);
        JButtonCadastrarLayout.setHorizontalGroup(
            JButtonCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JLabelCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
        );
        JButtonCadastrarLayout.setVerticalGroup(
            JButtonCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JLabelCadastrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        JButtonCancelar.setFirstColor(new java.awt.Color(153, 153, 153));
        JButtonCancelar.setPreferredSize(new java.awt.Dimension(90, 22));
        JButtonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JButtonCancelarMouseClicked(evt);
            }
        });

        JLabelCancelar.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        JLabelCancelar.setForeground(new java.awt.Color(255, 255, 255));
        JLabelCancelar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLabelCancelar.setText("Cancelar");

        javax.swing.GroupLayout JButtonCancelarLayout = new javax.swing.GroupLayout(JButtonCancelar);
        JButtonCancelar.setLayout(JButtonCancelarLayout);
        JButtonCancelarLayout.setHorizontalGroup(
            JButtonCancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JLabelCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
        );
        JButtonCancelarLayout.setVerticalGroup(
            JButtonCancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JLabelCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JSeparatorCRUD, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLabelCRUD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(JTextFieldNome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JSeparatorNome)
                                    .addComponent(JLabelNome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panelBorder1Layout.createSequentialGroup()
                                        .addComponent(JSeparatorCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(JSeparatorContato, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelBorder1Layout.createSequentialGroup()
                                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(JFormatedTextCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(JLabelCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(JLabelContato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(JFormatedTextContato))))
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelBorder1Layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(JTextFieldEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                                            .addComponent(JSeparatorEmail)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addComponent(JLabelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(JSeparatorEndereco)
                                    .addComponent(JLabelEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JTextFieldEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JLabelCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JSeparatorCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JTextFieldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JLabelCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JSeparatorCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JFormatedTextCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                                        .addComponent(JButtonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(panelBorder1Layout.createSequentialGroup()
                                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(JSeparatorEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(JComboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(JLabelEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 539, Short.MAX_VALUE)))
                                .addComponent(JButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 24, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(JLabelCRUD, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JSeparatorCRUD, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addComponent(JLabelNome)
                                .addGap(6, 6, 6)
                                .addComponent(JTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(JLabelCNPJ)
                                    .addComponent(JLabelContato))
                                .addGap(6, 6, 6)
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(JFormatedTextCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JFormatedTextContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JSeparatorContato, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JSeparatorCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JSeparatorNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(JLabelEmail)
                        .addGap(28, 28, 28)
                        .addComponent(JSeparatorEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(JLabelEndereco)
                                    .addComponent(JLabelCidade))
                                .addGap(25, 25, 25))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(JTextFieldEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JTextFieldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JSeparatorCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JSeparatorEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(JLabelCEP)
                        .addGap(3, 3, 3)
                        .addComponent(JFormatedTextCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JSeparatorCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(JLabelEstado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JComboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JSeparatorEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JButtonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelBorderGradient1Layout = new javax.swing.GroupLayout(panelBorderGradient1);
        panelBorderGradient1.setLayout(panelBorderGradient1Layout);
        panelBorderGradient1Layout.setHorizontalGroup(
            panelBorderGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorderGradient1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, 863, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelBorderGradient1Layout.setVerticalGroup(
            panelBorderGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorderGradient1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorderGradient1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorderGradient1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void JButtonCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JButtonCancelarMouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_JButtonCancelarMouseClicked

    private void JButtonCadastrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JButtonCadastrarMouseClicked
        if (JTextFieldNome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "O nome deve ser preenchido.");
            JTextFieldNome.requestFocus();
        } else if (JFormatedTextCNPJ.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "O CNPJ deve ser preenchido.");
            JFormatedTextCNPJ.requestFocus();
        } else if (JFormatedTextContato.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "O Contato deve ser preenchido.");
            JFormatedTextContato.requestFocus();
        } else if (JTextFieldEmail.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "O Email deve ser preenchido.");
            JTextFieldEmail.requestFocus();
        } else if (JTextFieldEndereco.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "O Endereço deve ser preenchido.");
            JTextFieldEndereco.requestFocus();
        } else if (JTextFieldCidade.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "A Cidade deve ser preenchida.");
            JTextFieldCidade.requestFocus();
        } else if (JFormatedTextCEP.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "O CEP deve ser preenchido.");
            JFormatedTextCEP.requestFocus();
        } else if (JComboBoxEstado.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null,
                    "Algum item deve ser selecionado.");
            JComboBoxEstado.requestFocus();
        } else {
            this.confirmou = true;
            this.setVisible(false);
        }
    }//GEN-LAST:event_JButtonCadastrarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ifsplife.dev.swing.PanelBorderGradient JButtonCadastrar;
    private ifsplife.dev.swing.PanelBorderGradient JButtonCancelar;
    private javax.swing.JComboBox<String> JComboBoxEstado;
    private javax.swing.JFormattedTextField JFormatedTextCEP;
    private javax.swing.JFormattedTextField JFormatedTextCNPJ;
    private javax.swing.JFormattedTextField JFormatedTextContato;
    private javax.swing.JLabel JLabelCEP;
    private javax.swing.JLabel JLabelCNPJ;
    private javax.swing.JLabel JLabelCRUD;
    private javax.swing.JLabel JLabelCadastrar;
    private javax.swing.JLabel JLabelCancelar;
    private javax.swing.JLabel JLabelCidade;
    private javax.swing.JLabel JLabelContato;
    private javax.swing.JLabel JLabelEmail;
    private javax.swing.JLabel JLabelEndereco;
    private javax.swing.JLabel JLabelEstado;
    private javax.swing.JLabel JLabelNome;
    private javax.swing.JSeparator JSeparatorCEP;
    private javax.swing.JSeparator JSeparatorCPF;
    private javax.swing.JSeparator JSeparatorCRUD;
    private javax.swing.JSeparator JSeparatorCidade;
    private javax.swing.JSeparator JSeparatorContato;
    private javax.swing.JSeparator JSeparatorEmail;
    private javax.swing.JSeparator JSeparatorEndereco;
    private javax.swing.JSeparator JSeparatorEstado;
    private javax.swing.JSeparator JSeparatorNome;
    private javax.swing.JTextField JTextFieldCidade;
    private javax.swing.JTextField JTextFieldEmail;
    private javax.swing.JTextField JTextFieldEndereco;
    private javax.swing.JTextField JTextFieldNome;
    private ifsplife.dev.swing.PanelBorder panelBorder1;
    private ifsplife.dev.swing.PanelBorderGradient panelBorderGradient1;
    // End of variables declaration//GEN-END:variables
}
