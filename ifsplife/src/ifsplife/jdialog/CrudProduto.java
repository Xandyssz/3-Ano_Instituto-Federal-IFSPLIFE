package ifsplife.jdialog;

import com.toedter.calendar.JTextFieldDateEditor;
import ifsplife.model.Produto;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

public class CrudProduto extends javax.swing.JDialog {

    private boolean confirmou = false;
    private int codigo = 0;
    private String buttonClickedText;

    public CrudProduto(java.awt.Frame parent, boolean modal, String buttonClickedText) {
        super(parent, modal);
        initComponents();
        this.buttonClickedText = buttonClickedText;
        JLabelCadastrar.setText(buttonClickedText); // Define o texto do JLabel
        desabilitarBotoes();
        
        ((JTextFieldDateEditor) dataFabricao.getDateEditor()).setEditable(false);
        ((JTextFieldDateEditor) dataValidade.getDateEditor()).setEditable(false);

    }

    public Produto getProduto() {
        Produto produto = new Produto();

        produto.setcodigo_produto(codigo);
        produto.setNome(txtNome.getText());
        produto.setDosagem(txtDosagem.getText());
        produto.setDescricao(txtDescricao.getText());
        produto.setLote(((Number) txtLote.getValue()).intValue());
        produto.setCategoria((String) comboCategoria.getSelectedItem());
        produto.setData_fabricacao(dataFabricao.getDate());
        produto.setData_validade(dataValidade.getDate());
        produto.setValor(((Number) txtValor.getValue()).doubleValue());

        return produto;
    }

    public void setProduto(Produto produto) {
        this.codigo = produto.getcodigo_produto();
        txtNome.setText(produto.getNome());
        txtDosagem.setText(produto.getDosagem());
        txtDescricao.setText(produto.getDescricao());
        txtLote.setValue(produto.getLote());
        comboCategoria.setSelectedItem(produto.getCategoria());
        dataFabricao.setDate(produto.getData_fabricacao());
        dataValidade.setDate(produto.getData_validade());
        txtValor.setValue(produto.getValor());

        // ^
    }

    public boolean isConfirmou() {
        return confirmou;
    }

    public void desabilitarEdicao() {
        txtNome.setEditable(false);
        txtDosagem.setEditable(false);
        txtDescricao.setEditable(false);
        txtLote.setEditable(false);
        comboCategoria.setEnabled(false);
        dataFabricao.setEnabled(false);
        dataValidade.setEnabled(false);
        txtQuantidade.setEditable(false);
        txtValor.setEditable(false);
    }

    public void desabilitarBotoes() {
        JLabelDosagem.setVisible(false);
        txtDosagem.setVisible(false);
        JSeparatorDosagem.setVisible(false);
        txtQuantidade.setEditable(false);
        JLabelQuantidade.setVisible(false);
        txtQuantidade.setVisible(false);
        JSeparatorQuantidade.setVisible(false);
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
        JLabelDosagem = new javax.swing.JLabel();
        txtDosagem = new javax.swing.JTextField();
        JSeparatorDosagem = new javax.swing.JSeparator();
        JLabelDescricao = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        JSeparatorDescricao = new javax.swing.JSeparator();
        JLabelLote = new javax.swing.JLabel();
        txtLote = new javax.swing.JFormattedTextField();
        JSeparatorLote = new javax.swing.JSeparator();
        JLabelCategoria = new javax.swing.JLabel();
        comboCategoria = new javax.swing.JComboBox<>();
        JSeparatorCategoria = new javax.swing.JSeparator();
        JLabelDataFabricacao = new javax.swing.JLabel();
        dataFabricao = new com.toedter.calendar.JDateChooser();
        JSeparatorDataFabricacao = new javax.swing.JSeparator();
        JLabelDataValidade1 = new javax.swing.JLabel();
        dataValidade = new com.toedter.calendar.JDateChooser();
        JSeparatorDataValidade = new javax.swing.JSeparator();
        JLabelValor = new javax.swing.JLabel();
        txtValor = new javax.swing.JFormattedTextField();
        JSeparatorValor = new javax.swing.JSeparator();
        JLabelQuantidade = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JFormattedTextField();
        JSeparatorQuantidade = new javax.swing.JSeparator();
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
        JLabelCRUD.setText("Cadastro de Produtos");

        JLabelNome.setText("Nome");

        txtNome.setBackground(new java.awt.Color(239, 239, 239));
        txtNome.setBorder(null);

        JLabelDosagem.setText("Dosagem");

        txtDosagem.setBackground(new java.awt.Color(239, 239, 239));
        txtDosagem.setBorder(null);
        txtDosagem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDosagemKeyTyped(evt);
            }
        });

        JLabelDescricao.setText("Descricao");

        txtDescricao.setBackground(new java.awt.Color(239, 239, 239));
        txtDescricao.setBorder(null);

        JLabelLote.setText("Lote");

        txtLote.setBackground(new java.awt.Color(239, 239, 239));
        txtLote.setBorder(null);
        txtLote.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtLote.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLoteKeyTyped(evt);
            }
        });

        JLabelCategoria.setText("Categoria do Produto");

        comboCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cosméticos", "Perfumes", "Medicamentos", "Higiene Pessoal", "Alimentos" }));
        comboCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCategoriaActionPerformed(evt);
            }
        });

        JLabelDataFabricacao.setText("Data de Fabricação");

        JLabelDataValidade1.setText("Data de Validade");

        JLabelValor.setText("Valor");

        txtValor.setBackground(new java.awt.Color(239, 239, 239));
        txtValor.setBorder(null);
        txtValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        txtValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValorKeyTyped(evt);
            }
        });

        JLabelQuantidade.setText("Quantidade ");

        txtQuantidade.setBackground(new java.awt.Color(239, 239, 239));
        txtQuantidade.setBorder(null);
        txtQuantidade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtQuantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtQuantidadeKeyTyped(evt);
            }
        });

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
                            .addComponent(JLabelLote, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLote, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JSeparatorLote, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(JLabelDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JSeparatorDescricao)
                                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JSeparatorDataFabricacao, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JLabelDataFabricacao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dataFabricao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(dataValidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JSeparatorDataValidade)
                                    .addComponent(JLabelDataValidade1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(JButtonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9))))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelBorder1Layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(JLabelValor, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JSeparatorValor, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panelBorder1Layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(JLabelQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JSeparatorQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtNome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JSeparatorNome)
                                    .addComponent(JLabelNome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(JSeparatorCategoria, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelBorder1Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(JLabelCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JLabelDosagem, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JSeparatorDosagem, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDosagem, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(JLabelCRUD, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JSeparatorCRUD, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                        .addComponent(txtDosagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JSeparatorDosagem, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                        .addComponent(JSeparatorNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JLabelCategoria)
                            .addComponent(JLabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JLabelDosagem))
                        .addGap(0, 0, 0)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JSeparatorCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                            .addComponent(JLabelLote)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(JSeparatorLote, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addComponent(JLabelDataValidade1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dataValidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(JSeparatorDataValidade, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addComponent(JLabelDataFabricacao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dataFabricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(JSeparatorDataFabricacao, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addComponent(JLabelDescricao)
                                .addGap(25, 25, 25))
                            .addComponent(txtDescricao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JSeparatorDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                                .addComponent(JLabelValor)
                                .addGap(31, 31, 31)))
                        .addComponent(JSeparatorValor, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                                .addComponent(JLabelQuantidade)
                                .addGap(31, 31, 31)))
                        .addComponent(JSeparatorQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JButtonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout panelBorderGradient1Layout = new javax.swing.GroupLayout(panelBorderGradient1);
        panelBorderGradient1.setLayout(panelBorderGradient1Layout);
        panelBorderGradient1Layout.setHorizontalGroup(
            panelBorderGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorderGradient1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, 774, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBorderGradient1Layout.setVerticalGroup(
            panelBorderGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorderGradient1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        if (txtNome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "O nome deve ser preenchido.");
            txtNome.requestFocus();
        } else if (txtDescricao.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "A Descrição deve ser preenchida.");
            txtDescricao.requestFocus();

        } else if (txtLote.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "O Lote deve ser preenchido");
            txtLote.requestFocus();
        } else if (comboCategoria.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null,
                    "Alguma categoria deve ser selecionada.");
            comboCategoria.requestFocus();
        } else if (dataFabricao.getDate() == (null)) {
            JOptionPane.showMessageDialog(null,
                    "A Data de Fabricação deve ser preenchida.");
            dataFabricao.requestFocus();

        } else if (dataValidade.getDate() == (null)) {
            JOptionPane.showMessageDialog(null,
                    "A Data de Validade deve ser preenchida");
            dataValidade.requestFocus();
        } else if (txtValor.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "O Valor deve ser preenchido.");
            txtValor.requestFocus();
        } else {
            this.confirmou = true;
            this.setVisible(false);
        }    }//GEN-LAST:event_JButtonCadastrarMouseClicked

    private void txtDosagemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDosagemKeyTyped
        char keyChar = evt.getKeyChar();
        if (Character.isDigit(keyChar) || keyChar == KeyEvent.VK_BACK_SPACE || keyChar == KeyEvent.VK_DELETE) {
        } else if (keyChar == 'm' || keyChar == 'g') {
        } else {
            JOptionPane.showMessageDialog(null, "Insira apenas números no campo.");
            evt.consume();
        }
    }//GEN-LAST:event_txtDosagemKeyTyped

    private void txtLoteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLoteKeyTyped
        char keyChar = evt.getKeyChar();
        if (Character.isDigit(keyChar) || keyChar == KeyEvent.VK_BACK_SPACE || keyChar == KeyEvent.VK_DELETE) {
        } else {
            JOptionPane.showMessageDialog(null, "Insira apenas números no campo.");
            evt.consume();
        }
    }//GEN-LAST:event_txtLoteKeyTyped

    private void txtValorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorKeyTyped
        char keyChar = evt.getKeyChar();
        if (Character.isDigit(keyChar) || keyChar == KeyEvent.VK_BACK_SPACE || keyChar == KeyEvent.VK_DELETE) {
        } else if (keyChar == '.' || keyChar == ',') {
        } else {
            JOptionPane.showMessageDialog(null, "Insira apenas números no campo.");
            evt.consume();
        }
    }//GEN-LAST:event_txtValorKeyTyped

    private void txtQuantidadeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantidadeKeyTyped
        char keyChar = evt.getKeyChar();
        if (Character.isDigit(keyChar) || keyChar == KeyEvent.VK_BACK_SPACE || keyChar == KeyEvent.VK_DELETE) {
        } else {
            txtQuantidade.setText("");
            JOptionPane.showMessageDialog(null, "Insira apenas números no campo.");
        }
    }//GEN-LAST:event_txtQuantidadeKeyTyped

    private void comboCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCategoriaActionPerformed
        if (comboCategoria.getSelectedItem().equals("Medicamentos")) {
            JLabelDosagem.setVisible(true);
            txtDosagem.setVisible(true);
            JSeparatorDosagem.setVisible(true);
        } else {
            JLabelDosagem.setVisible(false);
            txtDosagem.setVisible(false);
            JSeparatorDosagem.setVisible(false);
        }
    }//GEN-LAST:event_comboCategoriaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ifsplife.dev.swing.PanelBorderGradient JButtonCadastrar;
    private ifsplife.dev.swing.PanelBorderGradient JButtonCancelar;
    private javax.swing.JLabel JLabelCRUD;
    private javax.swing.JLabel JLabelCadastrar;
    private javax.swing.JLabel JLabelCancelar;
    private javax.swing.JLabel JLabelCategoria;
    private javax.swing.JLabel JLabelDataFabricacao;
    private javax.swing.JLabel JLabelDataValidade1;
    private javax.swing.JLabel JLabelDescricao;
    private javax.swing.JLabel JLabelDosagem;
    private javax.swing.JLabel JLabelLote;
    private javax.swing.JLabel JLabelNome;
    private javax.swing.JLabel JLabelQuantidade;
    private javax.swing.JLabel JLabelValor;
    private javax.swing.JSeparator JSeparatorCRUD;
    private javax.swing.JSeparator JSeparatorCategoria;
    private javax.swing.JSeparator JSeparatorDataFabricacao;
    private javax.swing.JSeparator JSeparatorDataValidade;
    private javax.swing.JSeparator JSeparatorDescricao;
    private javax.swing.JSeparator JSeparatorDosagem;
    private javax.swing.JSeparator JSeparatorLote;
    private javax.swing.JSeparator JSeparatorNome;
    private javax.swing.JSeparator JSeparatorQuantidade;
    private javax.swing.JSeparator JSeparatorValor;
    private javax.swing.JComboBox<String> comboCategoria;
    private com.toedter.calendar.JDateChooser dataFabricao;
    private com.toedter.calendar.JDateChooser dataValidade;
    private ifsplife.dev.swing.PanelBorder panelBorder1;
    private ifsplife.dev.swing.PanelBorderGradient panelBorderGradient1;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtDosagem;
    private javax.swing.JFormattedTextField txtLote;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtQuantidade;
    private javax.swing.JFormattedTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
