package ifsplife.jdialog;

import ifsplife.model.Convenios;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

public class CrudConvenio extends javax.swing.JDialog {

    private boolean confirmou = false;
    private int codigo = 0;

    public CrudConvenio(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public Convenios getConvenio() {
        Convenios c = new Convenios();

        c.setCodigo_convenio(codigo);
        c.setNome(txtNome.getText());
        c.setEmail(txtEmail.getText());
        c.setCnpj(txtCNPJ.getText());
        c.setTelefone(txtContato.getText());
        c.setEndereco(txtEndereco.getText());
        c.setDesconto(((Number) txtDesconto.getValue()).doubleValue());
        return c;
    }

    public void setConvenio(Convenios convenio) {
        this.codigo = convenio.getCodigo_convenio();
        txtNome.setText(convenio.getNome());
        txtEmail.setText(convenio.getEmail());
        txtCNPJ.setText(convenio.getCnpj());
        txtContato.setText(convenio.getTelefone());
        txtEndereco.setText(convenio.getEndereco());
        txtDesconto.setValue(convenio.getDesconto());
        //
    }

    public boolean isConfirmou() {
        return confirmou;
    }

    public void desabilitarEdicao() {
        txtNome.setEditable(false);
        txtCNPJ.setEditable(false);
        txtContato.setEditable(false);
        txtEndereco.setEditable(false);
        txtEmail.setEditable(false);
        txtDesconto.setEditable(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorderGradient1 = new ifsplife.dev.swing.PanelBorderGradient();
        panelBorder1 = new ifsplife.dev.swing.PanelBorder();
        JLabelCRUD = new javax.swing.JLabel();
        JSeparatorCRUD = new javax.swing.JSeparator();
        JLabelNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        JSeparatorNome = new javax.swing.JSeparator();
        JLabelEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        JSeparatorEmail = new javax.swing.JSeparator();
        JLabelCNPJ = new javax.swing.JLabel();
        txtCNPJ = new javax.swing.JFormattedTextField();
        JSeparatorCNPJ = new javax.swing.JSeparator();
        JLabelContato = new javax.swing.JLabel();
        txtContato = new javax.swing.JFormattedTextField();
        JSeparatorContato = new javax.swing.JSeparator();
        JLabelEndereco = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        JSeparatorEndereco = new javax.swing.JSeparator();
        JLabelDesconto = new javax.swing.JLabel();
        txtDesconto = new javax.swing.JFormattedTextField();
        JSeparatorDesconto = new javax.swing.JSeparator();
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
        JLabelCRUD.setText("Cadastro de Convênios");

        JLabelNome.setText("Nome");

        txtNome.setBackground(new java.awt.Color(239, 239, 239));
        txtNome.setBorder(null);

        JLabelEmail.setText("Email");

        txtEmail.setBackground(new java.awt.Color(239, 239, 239));
        txtEmail.setBorder(null);

        JLabelCNPJ.setText("CNPJ");

        txtCNPJ.setBackground(new java.awt.Color(239, 239, 239));
        txtCNPJ.setBorder(null);
        try {
            txtCNPJ.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####.##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCNPJ.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCNPJKeyTyped(evt);
            }
        });

        JLabelContato.setText("Contato");

        txtContato.setBackground(new java.awt.Color(239, 239, 239));
        txtContato.setBorder(null);
        try {
            txtContato.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtContato.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtContatoKeyTyped(evt);
            }
        });

        JLabelEndereco.setText("Endereco");

        txtEndereco.setBackground(new java.awt.Color(239, 239, 239));
        txtEndereco.setBorder(null);

        JLabelDesconto.setText("Desconto em [%]");

        txtDesconto.setBackground(new java.awt.Color(239, 239, 239));
        txtDesconto.setBorder(null);
        txtDesconto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtDesconto.setToolTipText("");

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
                            .addComponent(JLabelEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtNome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JSeparatorNome)
                                    .addComponent(JLabelNome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JLabelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(JSeparatorEmail, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))))
                            .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(JSeparatorEndereco, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtEndereco, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(JLabelCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JSeparatorCNPJ, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                                    .addComponent(txtCNPJ))
                                .addGap(45, 45, 45)
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(JLabelContato, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JSeparatorContato, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                    .addComponent(txtContato)))
                            .addComponent(JLabelDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(JSeparatorDesconto, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtDesconto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)))
                        .addGap(0, 81, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JButtonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(JLabelCRUD, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JSeparatorCRUD, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addComponent(JLabelNome)
                                .addGap(6, 6, 6)
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(JLabelCNPJ)
                                    .addComponent(JLabelEmail))
                                .addGap(6, 6, 6)
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JSeparatorEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JSeparatorNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(JLabelContato)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JSeparatorContato, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JSeparatorCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addComponent(JLabelEndereco)
                                .addGap(28, 28, 28))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                                .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(JSeparatorEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(JLabelDesconto)
                        .addGap(3, 3, 3)
                        .addComponent(txtDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JSeparatorDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JButtonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
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
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void JButtonCadastrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JButtonCadastrarMouseClicked
        if (txtNome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "O nome deve ser preenchido.");
            txtNome.requestFocus();
        } else if (txtCNPJ.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "O CNPJ deve ser preenchido.");
            txtCNPJ.requestFocus();
        } else if (txtContato.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "O Contato deve ser preenchido.");
            txtContato.requestFocus();
        } else if (txtEndereco.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "O Endereço deve ser preenchido.");
            txtEndereco.requestFocus();
        } else if (txtEmail.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "O Email deve ser preenchido.");
            txtEmail.requestFocus();
        } else if (txtDesconto.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "O Desconto deve ser preenchido.");
            txtDesconto.requestFocus();
        } else {
            this.confirmou = true;
            this.setVisible(false);
        }    }//GEN-LAST:event_JButtonCadastrarMouseClicked

    private void JButtonCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JButtonCancelarMouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_JButtonCancelarMouseClicked

    private void txtCNPJKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCNPJKeyTyped
        char keyChar = evt.getKeyChar();
        if (Character.isDigit(keyChar) || keyChar == KeyEvent.VK_BACK_SPACE || keyChar == KeyEvent.VK_DELETE) {
        } else {
            txtCNPJ.setText("");
            JOptionPane.showMessageDialog(null, "Insira apenas números no campo.");
        }
    }//GEN-LAST:event_txtCNPJKeyTyped

    private void txtContatoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContatoKeyTyped
        char keyChar = evt.getKeyChar();
        if (Character.isDigit(keyChar) || keyChar == KeyEvent.VK_BACK_SPACE || keyChar == KeyEvent.VK_DELETE) {
        } else {
            txtContato.setText("");
            JOptionPane.showMessageDialog(null, "Insira apenas números no campo.");
        }
    }//GEN-LAST:event_txtContatoKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ifsplife.dev.swing.PanelBorderGradient JButtonCadastrar;
    private ifsplife.dev.swing.PanelBorderGradient JButtonCancelar;
    private javax.swing.JLabel JLabelCNPJ;
    private javax.swing.JLabel JLabelCRUD;
    private javax.swing.JLabel JLabelCadastrar;
    private javax.swing.JLabel JLabelCancelar;
    private javax.swing.JLabel JLabelContato;
    private javax.swing.JLabel JLabelDesconto;
    private javax.swing.JLabel JLabelEmail;
    private javax.swing.JLabel JLabelEndereco;
    private javax.swing.JLabel JLabelNome;
    private javax.swing.JSeparator JSeparatorCNPJ;
    private javax.swing.JSeparator JSeparatorCRUD;
    private javax.swing.JSeparator JSeparatorContato;
    private javax.swing.JSeparator JSeparatorDesconto;
    private javax.swing.JSeparator JSeparatorEmail;
    private javax.swing.JSeparator JSeparatorEndereco;
    private javax.swing.JSeparator JSeparatorNome;
    private ifsplife.dev.swing.PanelBorder panelBorder1;
    private ifsplife.dev.swing.PanelBorderGradient panelBorderGradient1;
    private javax.swing.JFormattedTextField txtCNPJ;
    private javax.swing.JFormattedTextField txtContato;
    private javax.swing.JFormattedTextField txtDesconto;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
