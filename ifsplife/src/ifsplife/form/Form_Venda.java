package ifsplife.form;

import ifsplife.control.ControleCaixa;
import ifsplife.control.ControleConvenio;
import ifsplife.control.ControleVenda;
import ifsplife.jdialog.PesquisaItens;
import ifsplife.model.Convenios;
import ifsplife.model.Produto;
import ifsplife.model.Produtovenda;
import ifsplife.model.Vendas;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Form_Venda extends javax.swing.JPanel {

    boolean alterar = false;
    boolean confirmou = false;

    private double total = 0;
    private int codigo = 0;

    Produto itemSelecionado = null;
    Produto i = null;
    Vendas v = null;

    Date data = new Date();

    ControleConvenio controle = new ControleConvenio();
    ControleVenda controleVenda = new ControleVenda();

    List<Produtovenda> itens = new ArrayList<>();

    public Form_Venda() {
        initComponents();
        desativarInputs();
        desabilitarTextos();
        DataVenda.setDate(new Date());

        for (Convenios c : controle.getTodos()) {
            jComboBoxConvenios.addItem(c);
        }
    }

    public void setAlterar(boolean alterar) {
        this.alterar = alterar;
    }

    public boolean isConfirmou() {
        return confirmou;
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
        String vendaText = valorFinal.getText().replace(",", ".");
        double valorVenda;
        valorVenda = Double.parseDouble(vendaText);
        v.setValor_venda(valorVenda);
        v.setcodigo_caixa(ControleCaixa.getCaixaAberto());
        v.setCodigo_convenio((Convenios) jComboBoxConvenios.getSelectedItem());

        return v;
    }

    private void atualizarTabelaItens() {
        DefaultTableModel modelo = (DefaultTableModel) tableVendas.getModel();
        modelo.setRowCount(0);

        total = 0;
        for (Produtovenda pv : itens) {
            modelo.addRow(new Object[]{
                pv.getcodigo_produto().getNome(),
                pv.getcodigo_produto().getValor(),
                pv.getQuantidade(), // Obtém a quantidade do item individualmente
                pv.getSubtotal()});
            total += pv.getSubtotal();
        }
        valorFinal.setText(String.valueOf(total));
    }

    public void desabilitarTextos() {
        DataVenda.setEnabled(false);
        txtItem.setEditable(false);
        jFormattedTextFieldValorTotal.setEditable(false);
        jFormattedTextFieldPorcentagem.setEditable(false);
        jFormattedTextFieldTotalcomDesconto.setEditable(false);
        jFormattedTextFieldValorItem.setEditable(false);
        txtValorTabela.setEditable(false);
    }

    public void desabilitarCombo() {
        jComboBoxConvenios.setEnabled(!txtValorTabela.getText().isEmpty());
    }

    public void limparTexto() {
        txtItem.setText("");
        jFormattedTextFieldValorItem.setText("");
        txtQuantidadeItem.setText("");
        jFormattedTextFieldValorTotal.setText("");
        jFormattedTextFieldPorcentagem.setText("");
        jFormattedTextFieldTotalcomDesconto.setText("");
    }

    private void setVisibilidade(boolean visivel) {
        RSTotal1.setVisible(visivel);
        jLabelValorTotal1.setVisible(visivel);
        txtValorTabela.setVisible(visivel);
        jSeparatorValorTotal1.setVisible(visivel);
        jLabelSelecioneConvenio.setVisible(visivel);
        jComboBoxConvenios.setVisible(visivel);
        jSeparatorConvenios.setVisible(visivel);
        jLabelDescontoConvenios.setVisible(visivel);
        jLabelPorcentagem.setVisible(visivel);
        jFormattedTextFieldPorcentagem.setVisible(visivel);
        jSeparatorPorcentagem.setVisible(visivel);
        jLabelTotalcomDesconto.setVisible(visivel);
        jLabelRSSTotalDesconto.setVisible(visivel);
        jFormattedTextFieldTotalcomDesconto.setVisible(visivel);
        jLabel1.setVisible(visivel);
        jComboBoxFormaPagamento.setVisible(visivel);
        jSeparatorPorcentagem1.setVisible(visivel);
        jSeparatorPorcentagem2.setVisible(visivel);
        JLabelValorFinal1.setVisible(visivel);
        JLabelR$1.setVisible(visivel);
        valorFinal.setVisible(visivel);
        JButtonAdicionarItem1.setVisible(visivel);
        jLabel18.setVisible(visivel);
    }

    public void desativarInputs() {
        setVisibilidade(false);
    }

    public void ativarInputs() {
        setVisibilidade(true);
    }

    private void calcularValorFinal() {
        double ValorTotalItemComDesconto,
                ValorTotalItem,
                DescontoPercentual,
                DescontoDecimal,
                valorDesconto;

        ValorTotalItem = ((Number) jFormattedTextFieldValorTotal.getValue()).doubleValue();
        DescontoPercentual = ((Number) jFormattedTextFieldPorcentagem.getValue()).doubleValue();

        DescontoDecimal = DescontoPercentual / 100;
        valorDesconto = ValorTotalItem * DescontoDecimal;
        ValorTotalItemComDesconto = ValorTotalItem - valorDesconto;
        jFormattedTextFieldTotalcomDesconto.setValue(ValorTotalItemComDesconto);
        valorFinal.setText(jFormattedTextFieldTotalcomDesconto.getText());
    }

    public double somarValoresTabela() {
        int numRows = tableVendas.getRowCount();
        int valorColumnIndex = 3;
        // Índice da coluna "Valor" (começando em 0)
        double somaTabela = 0;
        for (int i = 0; i < numRows; i++) {
            Object valorCelula = tableVendas.getValueAt(i, valorColumnIndex);
            if (valorCelula instanceof Number) {
                somaTabela += ((Number) valorCelula).doubleValue();
            }
        }
        return somaTabela;
    }

    public void atualizarEstoque(int quantidadeVendida) {
        int estoqueAnterior = itemSelecionado.getQuantidade();
        int estoqueAtualizado = estoqueAnterior - quantidadeVendida;
        itemSelecionado.setQuantidade(estoqueAtualizado);

//        System.out.println("Estoque do item " + itemSelecionado.getNome() + " atualizado:");
//        System.out.println("Estoque anterior: " + estoqueAnterior);
//        System.out.println("Quantidade vendida: " + quantidadeVendida);
//        System.out.println("Estoque atualizado: " + estoqueAtualizado);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelBorder1 = new ifsplife.dev.swing.PanelBorder();
        jLabel2 = new javax.swing.JLabel();
        JButtonPesquisarItem = new ifsplife.dev.swing.PanelBorderGradient();
        jLabelPesquisar = new javax.swing.JLabel();
        JButtonAdicionarItem = new ifsplife.dev.swing.PanelBorderGradient();
        jLabel20 = new javax.swing.JLabel();
        JButtonRemoverItem = new ifsplife.dev.swing.PanelBorderGradient();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableVendas = new ifsplife.dev.swing.Table();
        panelBorder4 = new ifsplife.dev.swing.PanelBorder();
        panelBorder5 = new ifsplife.dev.swing.PanelBorder();
        JLabelDetalhesDaCompra1 = new javax.swing.JLabel();
        jLabelSelecioneConvenio = new javax.swing.JLabel();
        jComboBoxConvenios = new javax.swing.JComboBox<>();
        jSeparatorConvenios = new javax.swing.JSeparator();
        jLabelDescontoConvenios = new javax.swing.JLabel();
        jLabelPorcentagem = new javax.swing.JLabel();
        jFormattedTextFieldPorcentagem = new javax.swing.JFormattedTextField();
        jSeparatorPorcentagem = new javax.swing.JSeparator();
        jLabelTotalcomDesconto = new javax.swing.JLabel();
        jLabelRSSTotalDesconto = new javax.swing.JLabel();
        JLabelValorFinal1 = new javax.swing.JLabel();
        JLabelR$1 = new javax.swing.JLabel();
        JButtonAdicionarItem1 = new ifsplife.dev.swing.PanelBorderGradient();
        jLabel18 = new javax.swing.JLabel();
        txtValorTabela = new javax.swing.JFormattedTextField();
        jLabelValorTotal1 = new javax.swing.JLabel();
        RSTotal1 = new javax.swing.JLabel();
        jSeparatorValorTotal1 = new javax.swing.JSeparator();
        valorFinal = new javax.swing.JLabel();
        jComboBoxFormaPagamento = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jFormattedTextFieldTotalcomDesconto = new javax.swing.JFormattedTextField();
        jSeparatorPorcentagem1 = new javax.swing.JSeparator();
        jSeparatorPorcentagem2 = new javax.swing.JSeparator();
        jSeparatorDataVenda = new javax.swing.JSeparator();
        DataVenda = new com.toedter.calendar.JDateChooser();
        jLabeDataVenda = new javax.swing.JLabel();
        jLabelItem = new javax.swing.JLabel();
        txtItem = new javax.swing.JTextField();
        jSeparatorItem = new javax.swing.JSeparator();
        jLabelValorItem = new javax.swing.JLabel();
        jFormattedTextFieldValorItem = new javax.swing.JFormattedTextField();
        jSeparatorValorItem = new javax.swing.JSeparator();
        jSeparatorQtdItem = new javax.swing.JSeparator();
        txtQuantidadeItem = new javax.swing.JTextField();
        jLabelQtdItem = new javax.swing.JLabel();
        jSeparatorValorTotal = new javax.swing.JSeparator();
        jFormattedTextFieldValorTotal = new javax.swing.JFormattedTextField();
        jLabelValorTotal = new javax.swing.JLabel();

        setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBackground(new java.awt.Color(239, 239, 239));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(127, 127, 127));
        jLabel2.setText("Produtos da Venda");

        JButtonPesquisarItem.setFirstColor(new java.awt.Color(153, 153, 153));
        JButtonPesquisarItem.setPreferredSize(new java.awt.Dimension(90, 22));

        jLabelPesquisar.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabelPesquisar.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPesquisar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPesquisar.setText("Pesquisar Produto");
        jLabelPesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPesquisarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout JButtonPesquisarItemLayout = new javax.swing.GroupLayout(JButtonPesquisarItem);
        JButtonPesquisarItem.setLayout(JButtonPesquisarItemLayout);
        JButtonPesquisarItemLayout.setHorizontalGroup(
            JButtonPesquisarItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
        );
        JButtonPesquisarItemLayout.setVerticalGroup(
            JButtonPesquisarItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelPesquisar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        JButtonAdicionarItem.setFirstColor(new java.awt.Color(153, 153, 153));
        JButtonAdicionarItem.setPreferredSize(new java.awt.Dimension(90, 22));
        JButtonAdicionarItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JButtonAdicionarItemMouseClicked(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Adicionar Produto");

        javax.swing.GroupLayout JButtonAdicionarItemLayout = new javax.swing.GroupLayout(JButtonAdicionarItem);
        JButtonAdicionarItem.setLayout(JButtonAdicionarItemLayout);
        JButtonAdicionarItemLayout.setHorizontalGroup(
            JButtonAdicionarItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
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
        jLabel19.setText("Remover Produto");

        javax.swing.GroupLayout JButtonRemoverItemLayout = new javax.swing.GroupLayout(JButtonRemoverItem);
        JButtonRemoverItem.setLayout(JButtonRemoverItemLayout);
        JButtonRemoverItemLayout.setHorizontalGroup(
            JButtonRemoverItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
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

        panelBorder5.setBackground(new java.awt.Color(255, 255, 255));

        JLabelDetalhesDaCompra1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        JLabelDetalhesDaCompra1.setForeground(new java.awt.Color(127, 127, 127));
        JLabelDetalhesDaCompra1.setText("Detalhes da Venda");

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

        JLabelValorFinal1.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        JLabelValorFinal1.setForeground(new java.awt.Color(127, 127, 127));
        JLabelValorFinal1.setText("Valor Final");

        JLabelR$1.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        JLabelR$1.setForeground(new java.awt.Color(127, 127, 127));
        JLabelR$1.setText("R$");

        JButtonAdicionarItem1.setFirstColor(new java.awt.Color(153, 153, 153));
        JButtonAdicionarItem1.setPreferredSize(new java.awt.Dimension(90, 22));
        JButtonAdicionarItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JButtonAdicionarItem1MouseClicked(evt);
            }
        });

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

        jLabelValorTotal1.setText("Valor Total dos Itens selecionados:");

        RSTotal1.setText("R$");

        valorFinal.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        valorFinal.setForeground(new java.awt.Color(127, 127, 127));
        valorFinal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        valorFinal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jComboBoxFormaPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pix", "Cartão de Crédito", "Cartão de Débito" }));

        jLabel1.setText("Forma de pagamento:");

        jLabeDataVenda.setText("Data da Venda:");

        javax.swing.GroupLayout panelBorder5Layout = new javax.swing.GroupLayout(panelBorder5);
        panelBorder5.setLayout(panelBorder5Layout);
        panelBorder5Layout.setHorizontalGroup(
            panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLabelDetalhesDaCompra1)
                    .addGroup(panelBorder5Layout.createSequentialGroup()
                        .addGroup(panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelBorder5Layout.createSequentialGroup()
                                .addComponent(jLabelPorcentagem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jFormattedTextFieldPorcentagem, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparatorPorcentagem, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelDescontoConvenios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelBorder5Layout.createSequentialGroup()
                                        .addComponent(jLabelRSSTotalDesconto)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jFormattedTextFieldTotalcomDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jSeparatorPorcentagem1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelTotalcomDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelBorder5Layout.createSequentialGroup()
                                .addGroup(panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(DataVenda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                                    .addComponent(jSeparatorDataVenda)
                                    .addComponent(jLabeDataVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(24, 24, 24)
                                .addGroup(panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelBorder5Layout.createSequentialGroup()
                                        .addComponent(RSTotal1)
                                        .addGroup(panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panelBorder5Layout.createSequentialGroup()
                                                .addGap(3, 3, 3)
                                                .addComponent(jLabelValorTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder5Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(txtValorTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder5Layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(jSeparatorValorTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(36, 36, 36)
                        .addGroup(panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jSeparatorPorcentagem2)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBoxFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jComboBoxConvenios, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelSelecioneConvenio, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jSeparatorConvenios, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                .addGroup(panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder5Layout.createSequentialGroup()
                        .addGroup(panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelBorder5Layout.createSequentialGroup()
                                .addComponent(JLabelR$1)
                                .addGap(97, 97, 97))
                            .addComponent(JButtonAdicionarItem1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52))
                    .addGroup(panelBorder5Layout.createSequentialGroup()
                        .addGroup(panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(valorFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JLabelValorFinal1))
                        .addGap(9, 9, 9))))
        );
        panelBorder5Layout.setVerticalGroup(
            panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder5Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(JLabelDetalhesDaCompra1)
                .addGroup(panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(JLabelValorFinal1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JLabelR$1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(valorFinal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JButtonAdicionarItem1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelBorder5Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder5Layout.createSequentialGroup()
                                .addGroup(panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelSelecioneConvenio)
                                    .addGroup(panelBorder5Layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addComponent(jComboBoxConvenios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparatorConvenios, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBorder5Layout.createSequentialGroup()
                                .addGroup(panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelValorTotal1)
                                    .addComponent(jLabeDataVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(RSTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtValorTabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addComponent(jSeparatorValorTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBorder5Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(DataVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparatorDataVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder5Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparatorPorcentagem2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBorder5Layout.createSequentialGroup()
                                .addComponent(jLabelTotalcomDesconto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jFormattedTextFieldTotalcomDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelRSSTotalDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparatorPorcentagem1))
                            .addGroup(panelBorder5Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jFormattedTextFieldPorcentagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelPorcentagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparatorPorcentagem, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelDescontoConvenios))
                        .addContainerGap())))
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

        jLabelItem.setText("Produto:");

        jLabelValorItem.setText("Valor do Produto:");

        jFormattedTextFieldValorItem.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));

        txtQuantidadeItem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtQuantidadeItemKeyReleased(evt);
            }
        });

        jLabelQtdItem.setText("Quantidade do Produto:");

        jFormattedTextFieldValorTotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));

        jLabelValorTotal.setText("Valor Total do Produto:");

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(panelBorder4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JButtonPesquisarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JButtonAdicionarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JButtonRemoverItem, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtItem, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparatorItem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                            .addComponent(jLabelItem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparatorValorItem, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelValorItem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                            .addComponent(jFormattedTextFieldValorItem))
                        .addGap(18, 18, 18)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtQuantidadeItem)
                            .addComponent(jLabelQtdItem, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                            .addComponent(jSeparatorQtdItem, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparatorValorTotal)
                            .addComponent(jLabelValorTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jFormattedTextFieldValorTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))))
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(JButtonPesquisarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(JButtonAdicionarItem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JButtonRemoverItem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(panelBorder1Layout.createSequentialGroup()
                            .addComponent(jLabelItem)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jSeparatorItem, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelBorder1Layout.createSequentialGroup()
                            .addComponent(jLabelValorItem)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jFormattedTextFieldValorItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jSeparatorValorItem, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(jLabelQtdItem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtQuantidadeItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparatorQtdItem, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(jLabelValorTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextFieldValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparatorValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBorder4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        jPanel1.add(panelBorder1);

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelPesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPesquisarMouseClicked
        if (!ControleCaixa.isCaixaAberto()) {
            JOptionPane.showMessageDialog(null, "Não existe um caixa aberto. Abra um caixa antes de realizar a venda.");
            return;
        }

        if (DataVenda.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Deve ser selecionada a data da venda");
            DataVenda.requestFocus();
        } else {
            PesquisaItens pesquisa = new PesquisaItens(null, true);
            pesquisa.setVisible(true);
            itemSelecionado = pesquisa.getProdutoSelecionado();
            txtItem.setText(itemSelecionado.getNome());
            jFormattedTextFieldValorItem.setValue(itemSelecionado.getValor());
        }

    }//GEN-LAST:event_jLabelPesquisarMouseClicked

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

    private void JButtonRemoverItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JButtonRemoverItemMouseClicked
        if (!ControleCaixa.isCaixaAberto()) {
            JOptionPane.showMessageDialog(null, "Não existe um caixa aberto. Abra um caixa antes de realizar a venda.");
            return;
        }
        
        int linha = tableVendas.getSelectedRow();
        int valorColumnIndex = 3;
        double somaTabela = 0;

        if (linha == -1) {
            JOptionPane.showMessageDialog(null, "Selecione o Produto para remover.");
        } else {
            Object valorCelula = tableVendas.getValueAt(linha, valorColumnIndex);
            if (valorCelula instanceof Number) {
                double valorRemovido = ((Number) valorCelula).doubleValue();
                somaTabela -= valorRemovido;
            }

            itens.remove(linha);
            atualizarTabelaItens();
            limparTexto();

            double soma = somarValoresTabela();
            txtValorTabela.setText("");
            txtValorTabela.setValue(soma);

        }

    }//GEN-LAST:event_JButtonRemoverItemMouseClicked

    private void JButtonAdicionarItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JButtonAdicionarItemMouseClicked

        if (!ControleCaixa.isCaixaAberto()) {
            JOptionPane.showMessageDialog(null, "Não existe um caixa aberto. Abra um caixa antes de realizar a venda.");
            return;
        }

        jComboBoxConvenios.setEnabled(true);

        if (this.itemSelecionado == null) {
            JOptionPane.showMessageDialog(null, "Não foi selecionado um Produto");
            JButtonPesquisarItem.requestFocus();
        } else if (txtQuantidadeItem.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "A Quantidade de Produtos deve ser preenchida");
            txtQuantidadeItem.requestFocus();
        } else {
            // Verificar o estoque do item selecionado
            int quantidadeDesejada = Integer.parseInt(txtQuantidadeItem.getText());
            int estoqueDisponivel = itemSelecionado.getQuantidade();

            if (quantidadeDesejada > estoqueDisponivel) {
                JOptionPane.showMessageDialog(null, "Quantidade solicitada superior ao estoque disponível");
                txtQuantidadeItem.setText("");
                jFormattedTextFieldValorTotal.setText("");
                txtQuantidadeItem.requestFocus();
                return;
            }

            ativarInputs();
            Produtovenda novo = new Produtovenda();

            novo.setcodigo_produto(itemSelecionado);
            novo.setQuantidade(Integer.parseInt(txtQuantidadeItem.getText()));
            novo.setPreco(((Number) jFormattedTextFieldValorItem.getValue()).doubleValue());
            novo.setSubtotal(((Number) jFormattedTextFieldValorTotal.getValue()).doubleValue());

            boolean flag = false;
            for (Produtovenda item : itens) {
                Produto produto = item.getcodigo_produto();
                if (produto.getcodigo_produto() == itemSelecionado.getcodigo_produto()) {
                    flag = true;
                    int quantidadeAdicional = Integer.parseInt(txtQuantidadeItem.getText());
                    double valorAdicional = (double) jFormattedTextFieldValorTotal.getValue();

                    item.setQuantidade(item.getQuantidade() + quantidadeAdicional);
                    item.setSubtotal(item.getSubtotal() + valorAdicional);
                    break;
                }
            }

            if (!flag) {
                itens.add(novo);
            }

            atualizarTabelaItens();
            limparTexto();

            double soma = somarValoresTabela();
            txtValorTabela.setValue(soma);
        }
    }//GEN-LAST:event_JButtonAdicionarItemMouseClicked
    private void txtQuantidadeItemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantidadeItemKeyReleased
        String quantidadeItemText = txtQuantidadeItem.getText();
        String nomeItemText = txtItem.getText();
        double valorItem;

        if (nomeItemText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "O nome do item não pode estar em branco", "Erro", JOptionPane.ERROR_MESSAGE);
            JButtonPesquisarItem.requestFocus();
            txtQuantidadeItem.setText("");
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
                txtQuantidadeItem.requestFocus();
                jFormattedTextFieldValorTotal.setValue(null);

            }
        }
    }//GEN-LAST:event_txtQuantidadeItemKeyReleased

    private void JButtonAdicionarItem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JButtonAdicionarItem1MouseClicked
        if (this.confirmou = true) {
            v = this.getVendas();
            controleVenda.adicionar(v);

            // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
            for (Produtovenda item : itens) {
                atualizarEstoque(item.getQuantidade());
            }
            // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

            atualizarTabelaItens();

            String totalString = String.valueOf(total);
            double valorFormatado = Double.parseDouble(totalString);

            DecimalFormat decimalFormat = new DecimalFormat("#.##"); // Define o formato desejado
            String valorFinalFormatado = decimalFormat.format(valorFormatado); // Formata o valor
            valorFinal.setText(valorFinalFormatado);

            JOptionPane.showMessageDialog(null, "O Pedido foi finalizado com sucesso.");

            DefaultTableModel model = (DefaultTableModel) tableVendas.getModel();
            model.setRowCount(0);
            desativarInputs();
        }
    }//GEN-LAST:event_JButtonAdicionarItem1MouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DataVenda;
    private ifsplife.dev.swing.PanelBorderGradient JButtonAdicionarItem;
    private ifsplife.dev.swing.PanelBorderGradient JButtonAdicionarItem1;
    private ifsplife.dev.swing.PanelBorderGradient JButtonPesquisarItem;
    private ifsplife.dev.swing.PanelBorderGradient JButtonRemoverItem;
    private javax.swing.JLabel JLabelDetalhesDaCompra1;
    private javax.swing.JLabel JLabelR$1;
    private javax.swing.JLabel JLabelValorFinal1;
    private javax.swing.JLabel RSTotal1;
    private javax.swing.JComboBox<Convenios> jComboBoxConvenios;
    private javax.swing.JComboBox<String> jComboBoxFormaPagamento;
    private javax.swing.JFormattedTextField jFormattedTextFieldPorcentagem;
    private javax.swing.JFormattedTextField jFormattedTextFieldTotalcomDesconto;
    private javax.swing.JFormattedTextField jFormattedTextFieldValorItem;
    private javax.swing.JFormattedTextField jFormattedTextFieldValorTotal;
    private javax.swing.JLabel jLabeDataVenda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabelDescontoConvenios;
    private javax.swing.JLabel jLabelItem;
    private javax.swing.JLabel jLabelPesquisar;
    private javax.swing.JLabel jLabelPorcentagem;
    private javax.swing.JLabel jLabelQtdItem;
    private javax.swing.JLabel jLabelRSSTotalDesconto;
    private javax.swing.JLabel jLabelSelecioneConvenio;
    private javax.swing.JLabel jLabelTotalcomDesconto;
    private javax.swing.JLabel jLabelValorItem;
    private javax.swing.JLabel jLabelValorTotal;
    private javax.swing.JLabel jLabelValorTotal1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparatorConvenios;
    private javax.swing.JSeparator jSeparatorDataVenda;
    private javax.swing.JSeparator jSeparatorItem;
    private javax.swing.JSeparator jSeparatorPorcentagem;
    private javax.swing.JSeparator jSeparatorPorcentagem1;
    private javax.swing.JSeparator jSeparatorPorcentagem2;
    private javax.swing.JSeparator jSeparatorQtdItem;
    private javax.swing.JSeparator jSeparatorValorItem;
    private javax.swing.JSeparator jSeparatorValorTotal;
    private javax.swing.JSeparator jSeparatorValorTotal1;
    private ifsplife.dev.swing.PanelBorder panelBorder1;
    private ifsplife.dev.swing.PanelBorder panelBorder4;
    private ifsplife.dev.swing.PanelBorder panelBorder5;
    private ifsplife.dev.swing.Table tableVendas;
    private javax.swing.JTextField txtItem;
    private javax.swing.JTextField txtQuantidadeItem;
    private javax.swing.JFormattedTextField txtValorTabela;
    private javax.swing.JLabel valorFinal;
    // End of variables declaration//GEN-END:variables
}
