package ifsplife.jdialog;

import ifsplife.control.ControleCaixa;
import ifsplife.model.Convenios;
import ifsplife.control.ControleConvenio;
import ifsplife.model.Produtovenda;
import ifsplife.model.Vendas;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class RelatorioVendas extends javax.swing.JDialog {

    ControleConvenio controle = new ControleConvenio();
    private boolean confirmou = false;
    private int codigo = 0;
    private SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
    Vendas v = null;

    List<Vendas> vendas = new ArrayList<>();
    List<Produtovenda> itens = new ArrayList<>();

    public RelatorioVendas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        for (Convenios c : controle.getTodos()) {
            jComboBoxConvenios1.addItem(c);
        }
    }

    private void atualizarTabelaItens() {
        DefaultTableModel modelo = (DefaultTableModel) tableVendas.getModel();

        modelo.setRowCount(0);
        int sequencia = 1;

        // varre todos os produtos que estão no controle
        for (Produtovenda item : itens) {
            modelo.addRow(new Object[]{
                item.getcodigo_produto().getNome(),
                item.getcodigo_produto().getValor(),
                item.getQuantidade(), // Obtém a quantidade do item individualmente
                item.getSubtotal()});
        }
    }

    public boolean isConfirmou() {
        return confirmou;
    }

    public void desabilitarEdicao() {

        DataVenda.setEnabled(false);
        jComboBoxConvenios1.setEnabled(false);
        jFormattedTextFieldPorcentagem1.setEditable(false);
        jFormattedTextFieldTotalcomDesconto.setEditable(false);
        jComboBoxFormaPagamento.setEnabled(false);
    }

    public Vendas getVendas() {
        if (v == null) {
            v = new Vendas();
        }
        v.setData_venda(DataVenda.getDate());
        for (Produtovenda item : itens) {
            v.adicionarItem(item);
        }
        v.setForma_pagamento((String) jComboBoxFormaPagamento.getSelectedItem());
        v.setValor_venda(0.00);
        v.setcodigo_caixa(ControleCaixa.getCaixaAberto());
        v.setCodigo_convenio((Convenios) jComboBoxConvenios1.getSelectedItem());

        return v;
    }

    public void setVendas(Vendas vendas) {
        this.codigo = vendas.getCodigo_venda();
        DataVenda.setDate(vendas.getData_venda());
        jComboBoxConvenios1.setSelectedItem(vendas.getCodigo_convenio());
        jFormattedTextFieldPorcentagem1.setValue(vendas.getCodigo_convenio().getDesconto());
        jFormattedTextFieldTotalcomDesconto.setValue(String.valueOf(vendas.getValor_venda()));
        jComboBoxFormaPagamento.setSelectedItem(vendas.getForma_pagamento());
        itens.addAll(vendas.getProdutovendaList());
        atualizarTabelaItens();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorderGradient1 = new ifsplife.dev.swing.PanelBorderGradient();
        panelBorder1 = new ifsplife.dev.swing.PanelBorder();
        JButtonCancelar = new ifsplife.dev.swing.PanelBorderGradient();
        JLabelCancelar = new javax.swing.JLabel();
        JSeparatorCRUD = new javax.swing.JSeparator();
        jLabelItens = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableVendas = new ifsplife.dev.swing.Table();
        panelBorder6 = new ifsplife.dev.swing.PanelBorder();
        panelBorder7 = new ifsplife.dev.swing.PanelBorder();
        JLabelDetalhesDaCompra2 = new javax.swing.JLabel();
        jLabelSelecioneConvenio1 = new javax.swing.JLabel();
        jSeparatorConvenios1 = new javax.swing.JSeparator();
        jLabelDescontoConvenios1 = new javax.swing.JLabel();
        jLabelPorcentagem1 = new javax.swing.JLabel();
        jFormattedTextFieldPorcentagem1 = new javax.swing.JFormattedTextField();
        jSeparatorPorcentagem1 = new javax.swing.JSeparator();
        jLabelTotalcomDesconto1 = new javax.swing.JLabel();
        jLabelRSSTotalDesconto1 = new javax.swing.JLabel();
        jComboBoxFormaPagamento = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jFormattedTextFieldTotalcomDesconto = new javax.swing.JFormattedTextField();
        jSeparatorPorcentagem2 = new javax.swing.JSeparator();
        jSeparatorPorcentagem3 = new javax.swing.JSeparator();
        jSeparatorDataVenda = new javax.swing.JSeparator();
        DataVenda = new com.toedter.calendar.JDateChooser();
        jLabeDataVenda = new javax.swing.JLabel();
        jComboBoxConvenios1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        panelBorder1.setBackground(new java.awt.Color(239, 239, 239));
        panelBorder1.setPreferredSize(new java.awt.Dimension(411, 317));

        JButtonCancelar.setFirstColor(new java.awt.Color(153, 153, 153));
        JButtonCancelar.setPreferredSize(new java.awt.Dimension(90, 22));

        JLabelCancelar.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        JLabelCancelar.setForeground(new java.awt.Color(255, 255, 255));
        JLabelCancelar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLabelCancelar.setText("Voltar");
        JLabelCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JLabelCancelarMouseClicked(evt);
            }
        });

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

        jLabelItens.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabelItens.setForeground(new java.awt.Color(127, 127, 127));
        jLabelItens.setText("Detalhes dos Produtos");

        tableVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome", "Valor Unitario", "Quantidade", "SubTotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableVendas);

        panelBorder7.setBackground(new java.awt.Color(255, 255, 255));

        JLabelDetalhesDaCompra2.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        JLabelDetalhesDaCompra2.setForeground(new java.awt.Color(127, 127, 127));
        JLabelDetalhesDaCompra2.setText("Detalhes da Venda");

        jLabelSelecioneConvenio1.setText("Selecione o Convênio:");

        jLabelDescontoConvenios1.setText("Desconto do Convênio:");

        jLabelPorcentagem1.setText("%");

        jLabelTotalcomDesconto1.setText("Valor Total dos Itens com Desconto:");

        jLabelRSSTotalDesconto1.setText("R$");

        jComboBoxFormaPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pix", "Cartão de Crédito", "Cartão de Débito" }));

        jLabel1.setText("Forma de pagamento:");

        jLabeDataVenda.setText("Data da Venda:");

        jComboBoxConvenios1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxConvenios1ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout panelBorder7Layout = new javax.swing.GroupLayout(panelBorder7);
        panelBorder7.setLayout(panelBorder7Layout);
        panelBorder7Layout.setHorizontalGroup(
            panelBorder7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLabelDetalhesDaCompra2)
                    .addGroup(panelBorder7Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(panelBorder7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jSeparatorPorcentagem3)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBoxFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBorder7Layout.createSequentialGroup()
                                .addGroup(panelBorder7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(DataVenda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                                    .addComponent(jSeparatorDataVenda)
                                    .addComponent(jLabeDataVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(panelBorder7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panelBorder7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabelSelecioneConvenio1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jSeparatorConvenios1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jComboBoxConvenios1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabelPorcentagem1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelBorder7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jFormattedTextFieldPorcentagem1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparatorPorcentagem1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelDescontoConvenios1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panelBorder7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelBorder7Layout.createSequentialGroup()
                                        .addComponent(jLabelRSSTotalDesconto1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jFormattedTextFieldTotalcomDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jSeparatorPorcentagem2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelTotalcomDesconto1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(0, 30, Short.MAX_VALUE))
        );
        panelBorder7Layout.setVerticalGroup(
            panelBorder7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder7Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(JLabelDetalhesDaCompra2)
                .addGap(15, 15, 15)
                .addGroup(panelBorder7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder7Layout.createSequentialGroup()
                        .addComponent(jLabelTotalcomDesconto1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBorder7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jFormattedTextFieldTotalcomDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelRSSTotalDesconto1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparatorPorcentagem2))
                    .addGroup(panelBorder7Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(panelBorder7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jFormattedTextFieldPorcentagem1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPorcentagem1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxConvenios1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparatorPorcentagem1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBorder7Layout.createSequentialGroup()
                        .addGroup(panelBorder7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabeDataVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelBorder7Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(DataVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparatorDataVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBorder7Layout.createSequentialGroup()
                                .addComponent(jLabelSelecioneConvenio1)
                                .addGap(34, 34, 34)
                                .addComponent(jSeparatorConvenios1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelDescontoConvenios1))
                        .addGap(0, 1, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparatorPorcentagem3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout panelBorder6Layout = new javax.swing.GroupLayout(panelBorder6);
        panelBorder6.setLayout(panelBorder6Layout);
        panelBorder6Layout.setHorizontalGroup(
            panelBorder6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBorder7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBorder6Layout.setVerticalGroup(
            panelBorder6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBorder7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabelItens)
                        .addGap(18, 597, Short.MAX_VALUE)
                        .addComponent(JButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelBorder6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(JSeparatorCRUD)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelItens))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JSeparatorCRUD, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelBorder6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelBorderGradient1Layout = new javax.swing.GroupLayout(panelBorderGradient1);
        panelBorderGradient1.setLayout(panelBorderGradient1Layout);
        panelBorderGradient1Layout.setHorizontalGroup(
            panelBorderGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorderGradient1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, 933, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBorderGradient1Layout.setVerticalGroup(
            panelBorderGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorderGradient1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, 663, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorderGradient1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorderGradient1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxConvenios1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxConvenios1ItemStateChanged
        jComboBoxConvenios1.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent event) {
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    Convenios item = (Convenios) event.getItem();
                    if (item != null) {
                        jFormattedTextFieldPorcentagem1.setValue(item.getDesconto());
                    }
                }
            }
        });
    }//GEN-LAST:event_jComboBoxConvenios1ItemStateChanged
    private void JLabelCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLabelCancelarMouseClicked
        this.dispose();
    }//GEN-LAST:event_JLabelCancelarMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DataVenda;
    private ifsplife.dev.swing.PanelBorderGradient JButtonCancelar;
    private javax.swing.JLabel JLabelCancelar;
    private javax.swing.JLabel JLabelDetalhesDaCompra2;
    private javax.swing.JSeparator JSeparatorCRUD;
    private javax.swing.JComboBox<Convenios> jComboBoxConvenios1;
    private javax.swing.JComboBox<String> jComboBoxFormaPagamento;
    private javax.swing.JFormattedTextField jFormattedTextFieldPorcentagem1;
    private javax.swing.JFormattedTextField jFormattedTextFieldTotalcomDesconto;
    private javax.swing.JLabel jLabeDataVenda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelDescontoConvenios1;
    private javax.swing.JLabel jLabelItens;
    private javax.swing.JLabel jLabelPorcentagem1;
    private javax.swing.JLabel jLabelRSSTotalDesconto1;
    private javax.swing.JLabel jLabelSelecioneConvenio1;
    private javax.swing.JLabel jLabelTotalcomDesconto1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparatorConvenios1;
    private javax.swing.JSeparator jSeparatorDataVenda;
    private javax.swing.JSeparator jSeparatorPorcentagem1;
    private javax.swing.JSeparator jSeparatorPorcentagem2;
    private javax.swing.JSeparator jSeparatorPorcentagem3;
    private ifsplife.dev.swing.PanelBorder panelBorder1;
    private ifsplife.dev.swing.PanelBorder panelBorder6;
    private ifsplife.dev.swing.PanelBorder panelBorder7;
    private ifsplife.dev.swing.PanelBorderGradient panelBorderGradient1;
    private ifsplife.dev.swing.Table tableVendas;
    // End of variables declaration//GEN-END:variables
}
