package ifsplife.form;

import ifsplife.control.ControleConvenio;
import ifsplife.jdialog.PesquisaItens;
import ifsplife.model.Convenios;
import ifsplife.model.Funcionarios;
import ifsplife.model.Item;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Form_Vendas extends javax.swing.JPanel {

    private boolean confirmou = false;
    private int codigo = 0;
    Item itemSelecionado = null;
    private ControleConvenio controle = new ControleConvenio();

//    ControleVendas controle = new ControleVendas();
//    List<Venda> listaVendas = new ArrayList<>();

    public Form_Vendas() {
        initComponents();

        txtItem.setEditable(false);
        jFormattedTextFieldValorTotal.setEditable(false);
        jFormattedTextFieldPorcentagem.setEditable(false);
        jFormattedTextFieldTotalcomDesconto.setEditable(false);
        jFormattedTextFieldValorItem.setEditable(false);

        for (Convenios c : controle.getTodos()) {
            jComboBoxConvenios.addItem(c);
        }

//        atualizarTabela();

    }

//    private void atualizarTabela() {
//        DefaultTableModel modelo = (DefaultTableModel) table1.getModel();
//
//        modelo.setRowCount(0);
//
//        listaVendas.clear();
//        listaVendas.addAll(controle.getTodos());
//
//        for (Venda venda : listaVendas) {
//            modelo.addRow(new Object[]{venda.getNome(), venda.Valor(), venda.getQuantidade(), venda.SubTotal()}
//            );
//        }
//    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelBorder1 = new ifsplife.dev.swing.PanelBorder();
        jLabel2 = new javax.swing.JLabel();
        JButtonPesquisarItem = new ifsplife.dev.swing.PanelBorderGradient();
        jLabel17 = new javax.swing.JLabel();
        JButtonAdicionarItem = new ifsplife.dev.swing.PanelBorderGradient();
        jLabel20 = new javax.swing.JLabel();
        JButtonRemoverItem = new ifsplife.dev.swing.PanelBorderGradient();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableVendas = new ifsplife.dev.swing.Table();
        panelBorder4 = new ifsplife.dev.swing.PanelBorder();
        panelBorder5 = new ifsplife.dev.swing.PanelBorder();
        JLabelDetalhesDaCompra1 = new javax.swing.JLabel();
        jLabelItem = new javax.swing.JLabel();
        txtItem = new javax.swing.JTextField();
        jSeparatorItem = new javax.swing.JSeparator();
        jLabelValorItem = new javax.swing.JLabel();
        jFormattedTextFieldValorItem = new javax.swing.JFormattedTextField();
        jSeparatorValorItem = new javax.swing.JSeparator();
        jLabelQtdItem = new javax.swing.JLabel();
        jFormattedTextFieldQtdItem = new javax.swing.JFormattedTextField();
        jSeparatorQtdItem = new javax.swing.JSeparator();
        jLabelValorTotal = new javax.swing.JLabel();
        RSTotal = new javax.swing.JLabel();
        jFormattedTextFieldValorTotal = new javax.swing.JFormattedTextField();
        jSeparatorValorTotal = new javax.swing.JSeparator();
        jLabelSelecioneConvenio = new javax.swing.JLabel();
        jComboBoxConvenios = new javax.swing.JComboBox<>();
        jSeparatorConvenios = new javax.swing.JSeparator();
        jLabelDescontoConvenios = new javax.swing.JLabel();
        jLabelPorcentagem = new javax.swing.JLabel();
        jFormattedTextFieldPorcentagem = new javax.swing.JFormattedTextField();
        jSeparatorPorcentagem = new javax.swing.JSeparator();
        jLabelTotalcomDesconto = new javax.swing.JLabel();
        jLabelRSSTotalDesconto = new javax.swing.JLabel();
        jSeparatorTotalDesconto = new javax.swing.JSeparator();
        jFormattedTextFieldTotalcomDesconto = new javax.swing.JFormattedTextField();
        JLabelValorFinal1 = new javax.swing.JLabel();
        JLabelR$1 = new javax.swing.JLabel();
        JLabelTotalCompra1 = new javax.swing.JLabel();
        JButtonAdicionarItem1 = new ifsplife.dev.swing.PanelBorderGradient();
        jLabel18 = new javax.swing.JLabel();

        setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBackground(new java.awt.Color(239, 239, 239));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(127, 127, 127));
        jLabel2.setText("Itens da Venda");

        JButtonPesquisarItem.setFirstColor(new java.awt.Color(153, 153, 153));
        JButtonPesquisarItem.setPreferredSize(new java.awt.Dimension(90, 22));

        jLabel17.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Pesquisar Item");
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout JButtonPesquisarItemLayout = new javax.swing.GroupLayout(JButtonPesquisarItem);
        JButtonPesquisarItem.setLayout(JButtonPesquisarItemLayout);
        JButtonPesquisarItemLayout.setHorizontalGroup(
            JButtonPesquisarItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
        );
        JButtonPesquisarItemLayout.setVerticalGroup(
            JButtonPesquisarItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        JButtonAdicionarItem.setFirstColor(new java.awt.Color(153, 153, 153));
        JButtonAdicionarItem.setPreferredSize(new java.awt.Dimension(90, 22));

        jLabel20.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Adicionar Item");

        javax.swing.GroupLayout JButtonAdicionarItemLayout = new javax.swing.GroupLayout(JButtonAdicionarItem);
        JButtonAdicionarItem.setLayout(JButtonAdicionarItemLayout);
        JButtonAdicionarItemLayout.setHorizontalGroup(
            JButtonAdicionarItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
        );
        JButtonAdicionarItemLayout.setVerticalGroup(
            JButtonAdicionarItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        JButtonRemoverItem.setFirstColor(new java.awt.Color(153, 153, 153));
        JButtonRemoverItem.setPreferredSize(new java.awt.Dimension(90, 22));
        JButtonRemoverItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JButtonRemoverItemMouseClicked(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Remover Item");

        javax.swing.GroupLayout JButtonRemoverItemLayout = new javax.swing.GroupLayout(JButtonRemoverItem);
        JButtonRemoverItem.setLayout(JButtonRemoverItemLayout);
        JButtonRemoverItemLayout.setHorizontalGroup(
            JButtonRemoverItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
        );
        JButtonRemoverItemLayout.setVerticalGroup(
            JButtonRemoverItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        tableVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome", "Valor", "Quantidade", "SubTotal"
            }
        ));
        jScrollPane1.setViewportView(tableVendas);

        panelBorder5.setBackground(new java.awt.Color(255, 255, 255));

        JLabelDetalhesDaCompra1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        JLabelDetalhesDaCompra1.setForeground(new java.awt.Color(127, 127, 127));
        JLabelDetalhesDaCompra1.setText("Detalhes da Venda");

        jLabelItem.setText("Item:");

        jLabelValorItem.setText("Valor do Item:");

        jFormattedTextFieldValorItem.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));

        jLabelQtdItem.setText("Quantidade do Item:");

        jFormattedTextFieldQtdItem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jFormattedTextFieldQtdItemKeyReleased(evt);
            }
        });

        jLabelValorTotal.setText("Valor Total dos Itens:");

        RSTotal.setText("R$");

        jFormattedTextFieldValorTotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));

        jLabelSelecioneConvenio.setText("Selecione o Convênio:");

        jComboBoxConvenios.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxConveniosItemStateChanged(evt);
            }
        });

        jLabelDescontoConvenios.setText("Desconto do Convênio:");

        jLabelPorcentagem.setText("%");

        jLabelTotalcomDesconto.setText("Valor Total dos Itens com Desconto:");

        jLabelRSSTotalDesconto.setText("R$");

        jFormattedTextFieldTotalcomDesconto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));

        JLabelValorFinal1.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        JLabelValorFinal1.setForeground(new java.awt.Color(127, 127, 127));
        JLabelValorFinal1.setText("Valor Final");

        JLabelR$1.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        JLabelR$1.setForeground(new java.awt.Color(127, 127, 127));
        JLabelR$1.setText("R$");

        JLabelTotalCompra1.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        JLabelTotalCompra1.setForeground(new java.awt.Color(127, 127, 127));
        JLabelTotalCompra1.setText("0.00");

        JButtonAdicionarItem1.setFirstColor(new java.awt.Color(153, 153, 153));
        JButtonAdicionarItem1.setPreferredSize(new java.awt.Dimension(90, 22));

        jLabel18.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Finalizar Pedido");

        javax.swing.GroupLayout JButtonAdicionarItem1Layout = new javax.swing.GroupLayout(JButtonAdicionarItem1);
        JButtonAdicionarItem1.setLayout(JButtonAdicionarItem1Layout);
        JButtonAdicionarItem1Layout.setHorizontalGroup(
            JButtonAdicionarItem1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JButtonAdicionarItem1Layout.createSequentialGroup()
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        JButtonAdicionarItem1Layout.setVerticalGroup(
            JButtonAdicionarItem1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout panelBorder5Layout = new javax.swing.GroupLayout(panelBorder5);
        panelBorder5.setLayout(panelBorder5Layout);
        panelBorder5Layout.setHorizontalGroup(
            panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLabelDetalhesDaCompra1)
                    .addGroup(panelBorder5Layout.createSequentialGroup()
                        .addGroup(panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparatorQtdItem, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelBorder5Layout.createSequentialGroup()
                                .addGroup(panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jSeparatorValorItem)
                                        .addComponent(jLabelItem, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelValorItem, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtItem, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                                        .addComponent(jFormattedTextFieldValorItem)
                                        .addComponent(jSeparatorItem))
                                    .addGroup(panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabelQtdItem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                                        .addComponent(jFormattedTextFieldQtdItem, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addGap(18, 18, 18)
                                .addGroup(panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelPorcentagem)
                                    .addComponent(RSTotal))))
                        .addGap(3, 3, 3)
                        .addGroup(panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder5Layout.createSequentialGroup()
                                .addGroup(panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBoxConvenios, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jSeparatorConvenios, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jSeparatorValorTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                                    .addComponent(jLabelValorTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelSelecioneConvenio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelDescontoConvenios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jFormattedTextFieldPorcentagem, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jFormattedTextFieldValorTotal))
                                .addGap(18, 18, 18)
                                .addComponent(jLabelRSSTotalDesconto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelTotalcomDesconto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                                    .addComponent(jSeparatorTotalDesconto, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                                    .addComponent(jFormattedTextFieldTotalcomDesconto, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)))
                            .addComponent(jSeparatorPorcentagem, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(115, 115, 115)
                .addGroup(panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder5Layout.createSequentialGroup()
                        .addComponent(JLabelR$1)
                        .addGap(18, 18, 18)
                        .addComponent(JLabelTotalCompra1)
                        .addGap(68, 68, 68))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder5Layout.createSequentialGroup()
                        .addComponent(JButtonAdicionarItem1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))
                    .addGroup(panelBorder5Layout.createSequentialGroup()
                        .addComponent(JLabelValorFinal1)
                        .addContainerGap())))
        );
        panelBorder5Layout.setVerticalGroup(
            panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder5Layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(JLabelDetalhesDaCompra1)
                .addGroup(panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder5Layout.createSequentialGroup()
                                .addComponent(jLabelItem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparatorItem, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelValorItem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jFormattedTextFieldValorItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxConvenios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelBorder5Layout.createSequentialGroup()
                                .addComponent(jLabelTotalcomDesconto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelRSSTotalDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jFormattedTextFieldTotalcomDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparatorTotalDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparatorValorItem, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelQtdItem)
                        .addGap(0, 0, 0)
                        .addComponent(jFormattedTextFieldQtdItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparatorQtdItem, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBorder5Layout.createSequentialGroup()
                        .addGroup(panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder5Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabelValorTotal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(RSTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jFormattedTextFieldValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparatorValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelSelecioneConvenio)
                                .addGap(34, 34, 34)
                                .addComponent(jSeparatorConvenios, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelDescontoConvenios)
                                .addGap(0, 0, 0)
                                .addGroup(panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jFormattedTextFieldPorcentagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelPorcentagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(panelBorder5Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(JLabelValorFinal1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(JLabelR$1)
                                    .addComponent(JLabelTotalCompra1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JButtonAdicionarItem1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jSeparatorPorcentagem, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout panelBorder4Layout = new javax.swing.GroupLayout(panelBorder4);
        panelBorder4.setLayout(panelBorder4Layout);
        panelBorder4Layout.setHorizontalGroup(
            panelBorder4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBorder5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBorder4Layout.setVerticalGroup(
            panelBorder4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBorder5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JButtonPesquisarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JButtonAdicionarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JButtonRemoverItem, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(panelBorder4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JButtonPesquisarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JButtonAdicionarItem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JButtonRemoverItem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBorder4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        jPanel1.add(panelBorder1);

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        PesquisaItens pesquisa = new PesquisaItens(null, true);
        pesquisa.setVisible(true);
        itemSelecionado = pesquisa.getItemSelecionado();
        txtItem.setText(itemSelecionado.getNome());
        jFormattedTextFieldValorItem.setValue(itemSelecionado.getValor());
    }//GEN-LAST:event_jLabel17MouseClicked

    private void jComboBoxConveniosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxConveniosItemStateChanged

        jComboBoxConvenios.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent event) {
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    Convenios item = (Convenios) event.getItem();
                    if (item != null) {
                        jFormattedTextFieldPorcentagem.setValue(item.getDesconto());
                        calcularValorFinal();
                    }
                }
            }
        });
    }//GEN-LAST:event_jComboBoxConveniosItemStateChanged

    private void jFormattedTextFieldQtdItemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextFieldQtdItemKeyReleased
        double valorItem;
        String quantidadeItemText = jFormattedTextFieldQtdItem.getText();
        String nomeItemText = txtItem.getText();

        if (nomeItemText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "O nome do item não pode estar em branco", "Erro", JOptionPane.ERROR_MESSAGE);
            txtItem.requestFocus();
            jFormattedTextFieldQtdItem.setValue("");
            jFormattedTextFieldValorTotal.setValue(null);

            return;
        }

        try {
            valorItem = ((Number) jFormattedTextFieldValorItem.getValue()).doubleValue();
            int quantidadeItem = Integer.parseInt(quantidadeItemText);

            double valorTotalItens = valorItem * quantidadeItem;
            jFormattedTextFieldValorTotal.setValue(valorTotalItens);

        } catch (NumberFormatException | ClassCastException | NullPointerException e) {
            if (e instanceof NullPointerException || e instanceof ClassCastException) {
                JOptionPane.showMessageDialog(this, "O valor do item não é válido, insira um valor válido", "Erro", JOptionPane.ERROR_MESSAGE);
                jFormattedTextFieldValorItem.requestFocus();
                jFormattedTextFieldValorTotal.setValue(null);

            } else if (e instanceof NumberFormatException) {
                JOptionPane.showMessageDialog(this, "A quantidade de itens não é um número válido", "Erro", JOptionPane.ERROR_MESSAGE);
                jFormattedTextFieldQtdItem.requestFocus();
                jFormattedTextFieldValorTotal.setValue(null);

            }
        }
    }//GEN-LAST:event_jFormattedTextFieldQtdItemKeyReleased

    private void JButtonRemoverItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JButtonRemoverItemMouseClicked
//        Integer linha = table1.getSelectedRow();
//
//        if (linha == -1) {
//            JOptionPane.showMessageDialog(null,
//                    "Não foi selecionado nenhum Fornecedor. Selecione.");
//        } else {
//            Integer resposta = JOptionPane.showConfirmDialog(null,
//                    "Deseja excluir esse Fornecedor?",
//                    "Exclusão de Fornecedor",
//                    JOptionPane.YES_NO_OPTION);
//
//            if (resposta == JOptionPane.YES_OPTION) {
//                controle.remover(listaFornecedores.get(linha));
//                atualizarTabela();
//            }
//        }
    }//GEN-LAST:event_JButtonRemoverItemMouseClicked

    private void calcularValorFinal() {

        double ValorTotalItemComDesconto;
        double ValorTotalItem;
        double DescontoPercentual;
        double DescontoDecimal;
        double valorDesconto;

        ValorTotalItem = ((Number) jFormattedTextFieldValorTotal.getValue()).doubleValue();
        DescontoPercentual = ((Number) jFormattedTextFieldPorcentagem.getValue()).doubleValue();

        DescontoDecimal = DescontoPercentual / 100;
        valorDesconto = ValorTotalItem * DescontoDecimal;
        ValorTotalItemComDesconto = ValorTotalItem - valorDesconto;;
        jFormattedTextFieldTotalcomDesconto.setValue(ValorTotalItemComDesconto);

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ifsplife.dev.swing.PanelBorderGradient JButtonAdicionarItem;
    private ifsplife.dev.swing.PanelBorderGradient JButtonAdicionarItem1;
    private ifsplife.dev.swing.PanelBorderGradient JButtonPesquisarItem;
    private ifsplife.dev.swing.PanelBorderGradient JButtonRemoverItem;
    private javax.swing.JLabel JLabelDetalhesDaCompra1;
    private javax.swing.JLabel JLabelR$1;
    private javax.swing.JLabel JLabelTotalCompra1;
    private javax.swing.JLabel JLabelValorFinal1;
    private javax.swing.JLabel RSTotal;
    private javax.swing.JComboBox<Convenios> jComboBoxConvenios;
    private javax.swing.JFormattedTextField jFormattedTextFieldPorcentagem;
    private javax.swing.JFormattedTextField jFormattedTextFieldQtdItem;
    private javax.swing.JFormattedTextField jFormattedTextFieldTotalcomDesconto;
    private javax.swing.JFormattedTextField jFormattedTextFieldValorItem;
    private javax.swing.JFormattedTextField jFormattedTextFieldValorTotal;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabelDescontoConvenios;
    private javax.swing.JLabel jLabelItem;
    private javax.swing.JLabel jLabelPorcentagem;
    private javax.swing.JLabel jLabelQtdItem;
    private javax.swing.JLabel jLabelRSSTotalDesconto;
    private javax.swing.JLabel jLabelSelecioneConvenio;
    private javax.swing.JLabel jLabelTotalcomDesconto;
    private javax.swing.JLabel jLabelValorItem;
    private javax.swing.JLabel jLabelValorTotal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparatorConvenios;
    private javax.swing.JSeparator jSeparatorItem;
    private javax.swing.JSeparator jSeparatorPorcentagem;
    private javax.swing.JSeparator jSeparatorQtdItem;
    private javax.swing.JSeparator jSeparatorTotalDesconto;
    private javax.swing.JSeparator jSeparatorValorItem;
    private javax.swing.JSeparator jSeparatorValorTotal;
    private ifsplife.dev.swing.PanelBorder panelBorder1;
    private ifsplife.dev.swing.PanelBorder panelBorder4;
    private ifsplife.dev.swing.PanelBorder panelBorder5;
    private ifsplife.dev.swing.Table tableVendas;
    private javax.swing.JTextField txtItem;
    // End of variables declaration//GEN-END:variables
}
