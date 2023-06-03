package ifsplife.jdialog;

import ifsplife.model.Item;
import javax.swing.JOptionPane;

public class CrudItem extends javax.swing.JDialog {

    private boolean confirmou = false;
    private int codigo = 0;

    public CrudItem(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public Item getItem() {
        Item item = new Item();

        item.setCodigo_item(codigo);
        item.setNome(txtNome.getText());
        item.setDosagem(txtDosagem.getText());
        item.setDescricao(txtDescricao.getText());
        item.setLote(Integer.parseInt(txtLote.getText()));
        item.setCategoria((String) comboCategoria.getSelectedItem());
        item.setData_fabricacao(dataFabricao.getDate());
        item.setData_validade(dataValidade.getDate());
        item.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
        item.setValor((Double) txtValor.getValue());

        return item;
    }

    public void setItem(Item item) {
        this.codigo = item.getCodigo_item();
        txtNome.setText(item.getNome());
        txtDosagem.setText(item.getDosagem());
        txtDescricao.setText(item.getDescricao());
        txtLote.setValue(item.getLote());
        comboCategoria.setSelectedItem(item.getCategoria());
        dataFabricao.setDate(item.getData_fabricacao());
        dataValidade.setDate(item.getData_validade());
        txtQuantidade.setValue(item.getQuantidade());
        txtValor.setValue(item.getValor());
    }

    public boolean isConfirmou() {
        return confirmou;
    }

    public void desabilitarEdicao() {
        txtNome.setEditable(false);
        txtDosagem.setEditable(false);
        txtDescricao.setEditable(false);
        txtLote.setEditable(false);
        comboCategoria.setEditable(false);
        dataFabricao.setEnabled(false);
        dataValidade.setEnabled(false);
        txtQuantidade.setEditable(false);
        txtValor.setEditable(false);
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
        JLabelCategoria = new javax.swing.JLabel();
        comboCategoria = new javax.swing.JComboBox<>();
        JSeparatorCategoria = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        panelBorder1.setBackground(new java.awt.Color(239, 239, 239));
        panelBorder1.setPreferredSize(new java.awt.Dimension(411, 317));

        JLabelCRUD.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        JLabelCRUD.setForeground(new java.awt.Color(0, 78, 146));
        JLabelCRUD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLabelCRUD.setText("Cadastro de Itens");

        JLabelNome.setText("Nome");

        txtNome.setBackground(new java.awt.Color(239, 239, 239));
        txtNome.setBorder(null);

        JLabelDosagem.setText("Dosagem");

        txtDosagem.setBackground(new java.awt.Color(239, 239, 239));
        txtDosagem.setBorder(null);

        JLabelDescricao.setText("Descricao");

        txtDescricao.setBackground(new java.awt.Color(239, 239, 239));
        txtDescricao.setBorder(null);

        JLabelLote.setText("Lote");

        txtLote.setBackground(new java.awt.Color(239, 239, 239));
        txtLote.setBorder(null);
        txtLote.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        JLabelDataFabricacao.setText("Data de Fabricação");

        JLabelDataValidade1.setText("Data de Validade");

        JLabelValor.setText("Valor");

        txtValor.setBackground(new java.awt.Color(239, 239, 239));
        txtValor.setBorder(null);
        txtValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        JLabelQuantidade.setText("Quantidade ");

        txtQuantidade.setBackground(new java.awt.Color(239, 239, 239));
        txtQuantidade.setBorder(null);
        txtQuantidade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

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

        JLabelCategoria.setText("Categoria do Item");

        comboCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Medicamentos", "Cosméticos", "Perfumes", "Higiene Pessoal", "Alimentos" }));

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
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(JLabelCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtNome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(JSeparatorNome)
                                        .addComponent(JLabelNome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(19, 19, 19)
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JLabelDosagem, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JSeparatorDosagem, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDosagem, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(JLabelDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JSeparatorDescricao)
                                    .addComponent(txtDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE))))
                        .addGap(0, 59, Short.MAX_VALUE))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JLabelLote, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLote, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JSeparatorLote, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JSeparatorCategoria, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                                .addComponent(JButtonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)))))
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(JLabelCRUD, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JSeparatorCRUD, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JLabelNome)
                                .addGap(6, 6, 6)
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(JSeparatorNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelBorder1Layout.createSequentialGroup()
                                        .addComponent(JLabelDosagem)
                                        .addGap(25, 25, 25))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                                        .addComponent(txtDosagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addComponent(JSeparatorDosagem, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelBorder1Layout.createSequentialGroup()
                                        .addComponent(JLabelDescricao)
                                        .addGap(25, 25, 25))
                                    .addComponent(txtDescricao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JSeparatorDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addComponent(JLabelCategoria)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JSeparatorCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addComponent(JLabelLote)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JSeparatorLote, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                .addComponent(JSeparatorDataFabricacao, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(4, 4, 4)
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

        } else if (txtQuantidade.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "A Quantidade deve ser preenchida.");
            txtQuantidade.requestFocus();

        } else if (txtValor.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "O Valor deve ser preenchido.");
            txtValor.requestFocus();
        } else {
            this.confirmou = true;
            this.setVisible(false);
        }    }//GEN-LAST:event_JButtonCadastrarMouseClicked


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
