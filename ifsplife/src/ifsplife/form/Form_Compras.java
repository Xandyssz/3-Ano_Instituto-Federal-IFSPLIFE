package ifsplife.form;

import ifsplife.control.ControleCaixa;
import ifsplife.model.Fornecedores;
import ifsplife.control.ControleFornecedor;
import ifsplife.control.ControleCompra;
import ifsplife.jdialog.PesquisaFornecedores;
import ifsplife.jdialog.PesquisaItens;
import ifsplife.model.Compras;
import ifsplife.model.Produto;
import ifsplife.model.Produtocompra;
import ifsplife.model.Pagamentocompra;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Form_Compras extends javax.swing.JPanel {

    ControleCompra controleCompra = new ControleCompra();
    ControleFornecedor controle = new ControleFornecedor();

    List<Produtocompra> itens = new ArrayList<>();
    List<Pagamentocompra> pagamentos = new ArrayList<>();

    boolean alterar = false;
    private boolean confirmou = false;
    private int codigo = 0;
    private double total = 0;

    Fornecedores fornecedorSelecionado = null;
    Produto itemSelecionado = null;
    Produto i = null;
    Compras c = null;

    public Form_Compras() {
        initComponents();
        desativarInputs();
    }

    public void setAlterar(boolean alterar) {
        this.alterar = alterar;
    }

    public boolean isConfirmou() {
        return confirmou;
    }

    public void limparTexto() {
        txtItem.setText("");
        jFormattedTextFieldValorItem.setText("");
        txtQuantidadeItem.setText("");
        jFormattedTextFieldValorTotal.setText("");
    }

    private void setVisibilidade(boolean visivel) {
        JLabelDataDeVencimento.setVisible(visivel);
        JLabelFornecedor.setVisible(visivel);
        fornecedores.setVisible(visivel);
        jButton1.setVisible(visivel);
        JLabelUsuario.setVisible(visivel);
        JTextFieldResponsavel.setVisible(visivel);
        jSeparator2.setVisible(visivel);
        jLabel1.setVisible(visivel);
        jComboBoxFormaPagamento.setVisible(visivel);
        jSeparatorPorcentagem2.setVisible(visivel);
        JLabelValorFinal1.setVisible(visivel);
        JLabelR$1.setVisible(visivel);
        valorFinal.setVisible(visivel);
        JButtonAdicionarItem1.setVisible(visivel);
        jLabel18.setVisible(visivel);
        jSeparator4.setVisible(visivel);
        jSeparator5.setVisible(visivel);
    }

    public void desativarInputs() {
        setVisibilidade(false);
    }

    public void ativarInputs() {
        setVisibilidade(true);
    }

    public Compras getCompras() {
        if (c == null) {
            c = new Compras();
        }

        c.setData_compra(DataCompra.getDate());
        for (Produtocompra item : itens) {
            c.adicionarItem(item);
        }
        
//        for(Pagamentocompra pagamento : pagamentos)
//        {
//            c.adicionarPagameto(item);
//        }
        
        c.setForma_pagamento((String) jComboBoxFormaPagamento.getSelectedItem());
        String compraText = valorFinal.getText().replace(",", ".");
        double valorCompra;
        valorCompra = Double.parseDouble(compraText);
        c.setCodigo_fornecedor(fornecedorSelecionado);
        c.setValortotal(valorCompra);

        return c;
    }

    private void atualizarTabelaItens() {
        DefaultTableModel modelo = (DefaultTableModel) tableCompras.getModel();

        modelo.setRowCount(0);

        total = 0;
        // varre todos os produtos que estão no controle
        for (Produtocompra ic : itens) {
            modelo.addRow(new Object[]{
                ic.getcodigo_produto().getNome(),
                ic.getcodigo_produto().getValor(),
                ic.getQuantidade(),
                ic.getSubtotal()});
            total += ic.getSubtotal();
        }
        String totalString = String.valueOf(total);
        valorFinal.setText(totalString);
    }

    private void atualizarTabelaParcelas() {
        DefaultTableModel modelo = (DefaultTableModel) tableParcelas.getModel();

        modelo.setRowCount(0);
        int sequencia = 1;

        // varre todos os produtos que estão no controle
        for (Pagamentocompra pagamento : pagamentos) {
            modelo.addRow(new Object[]{pagamento.getParcela(), 
                pagamento.getVencimento(), 
                pagamento.getValor(),
                pagamento.getStatus()});
        }
    }

    public double somarValoresTabela() {
        int numRows = tableCompras.getRowCount();
        int valorColumnIndex = 3;
        // Índice da coluna "Valor" (começando em 0)
        double somaTabela = 0;
        for (int i = 0; i < numRows; i++) {
            Object valorCelula = tableCompras.getValueAt(i, valorColumnIndex);
            if (valorCelula instanceof Number) {
                somaTabela += ((Number) valorCelula).doubleValue();
            }
        }
        return somaTabela;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelBorder1 = new ifsplife.dev.swing.PanelBorder();
        jLabel2 = new javax.swing.JLabel();
        JButtonRemoverItem1 = new ifsplife.dev.swing.PanelBorderGradient();
        jLabel22 = new javax.swing.JLabel();
        JButtonAdicionarItem = new ifsplife.dev.swing.PanelBorderGradient();
        jLabel17 = new javax.swing.JLabel();
        JButtonRemoverItem = new ifsplife.dev.swing.PanelBorderGradient();
        jLabel19 = new javax.swing.JLabel();
        panelBorderTabelas = new ifsplife.dev.swing.PanelBorder();
        panelBorder3 = new ifsplife.dev.swing.PanelBorder();
        panelBorder2 = new ifsplife.dev.swing.PanelBorder();
        JLabelDetalhesDaCompra = new javax.swing.JLabel();
        JLabelDataDaCompra = new javax.swing.JLabel();
        DataCompra = new com.toedter.calendar.JDateChooser();
        JLabelFornecedor = new javax.swing.JLabel();
        JLabelUsuario = new javax.swing.JLabel();
        JTextFieldResponsavel = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        fornecedores = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        JLabelValorFinal1 = new javax.swing.JLabel();
        JLabelR$1 = new javax.swing.JLabel();
        JButtonAdicionarItem1 = new ifsplife.dev.swing.PanelBorderGradient();
        jLabel18 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxFormaPagamento = new javax.swing.JComboBox<>();
        jSeparatorPorcentagem2 = new javax.swing.JSeparator();
        valorFinal = new javax.swing.JFormattedTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparatorValorTotal = new javax.swing.JSeparator();
        jSeparatorQtdItem = new javax.swing.JSeparator();
        jSeparatorValorItem = new javax.swing.JSeparator();
        jSeparatorItem = new javax.swing.JSeparator();
        txtItem = new javax.swing.JTextField();
        jFormattedTextFieldValorItem = new javax.swing.JFormattedTextField();
        txtQuantidadeItem = new javax.swing.JTextField();
        jFormattedTextFieldValorTotal = new javax.swing.JFormattedTextField();
        jLabelValorTotal = new javax.swing.JLabel();
        jLabelQtdItem = new javax.swing.JLabel();
        jLabelValorItem = new javax.swing.JLabel();
        jLabelItem = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCompras = new ifsplife.dev.swing.Table();
        panelBorder4 = new ifsplife.dev.swing.PanelBorder();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableParcelas = new ifsplife.dev.swing.Table();
        panelBorder5 = new ifsplife.dev.swing.PanelBorder();
        panelBorder6 = new ifsplife.dev.swing.PanelBorder();
        jLabel3 = new javax.swing.JLabel();
        JLabelDataDeVencimento = new com.toedter.calendar.JDateChooser();
        jSeparator6 = new javax.swing.JSeparator();
        JButtonAdicionarItem2 = new ifsplife.dev.swing.PanelBorderGradient();
        jLabel20 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        valorParcela = new javax.swing.JFormattedTextField();

        setMaximumSize(new java.awt.Dimension(1047, 744));
        setPreferredSize(new java.awt.Dimension(987, 711));
        setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBackground(new java.awt.Color(239, 239, 239));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(127, 127, 127));
        jLabel2.setText("Produtos da Compra");

        JButtonRemoverItem1.setFirstColor(new java.awt.Color(153, 153, 153));
        JButtonRemoverItem1.setPreferredSize(new java.awt.Dimension(90, 22));

        jLabel22.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Pesquisar Produto");
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout JButtonRemoverItem1Layout = new javax.swing.GroupLayout(JButtonRemoverItem1);
        JButtonRemoverItem1.setLayout(JButtonRemoverItem1Layout);
        JButtonRemoverItem1Layout.setHorizontalGroup(
            JButtonRemoverItem1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );
        JButtonRemoverItem1Layout.setVerticalGroup(
            JButtonRemoverItem1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        JButtonAdicionarItem.setFirstColor(new java.awt.Color(153, 153, 153));
        JButtonAdicionarItem.setPreferredSize(new java.awt.Dimension(90, 22));

        jLabel17.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Adicionar Produto");
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout JButtonAdicionarItemLayout = new javax.swing.GroupLayout(JButtonAdicionarItem);
        JButtonAdicionarItem.setLayout(JButtonAdicionarItemLayout);
        JButtonAdicionarItemLayout.setHorizontalGroup(
            JButtonAdicionarItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
        );
        JButtonAdicionarItemLayout.setVerticalGroup(
            JButtonAdicionarItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
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
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout JButtonRemoverItemLayout = new javax.swing.GroupLayout(JButtonRemoverItem);
        JButtonRemoverItem.setLayout(JButtonRemoverItemLayout);
        JButtonRemoverItemLayout.setHorizontalGroup(
            JButtonRemoverItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
        );
        JButtonRemoverItemLayout.setVerticalGroup(
            JButtonRemoverItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        panelBorderTabelas.setBackground(new java.awt.Color(255, 255, 255));
        panelBorderTabelas.setPreferredSize(new java.awt.Dimension(939, 385));

        javax.swing.GroupLayout panelBorderTabelasLayout = new javax.swing.GroupLayout(panelBorderTabelas);
        panelBorderTabelas.setLayout(panelBorderTabelasLayout);
        panelBorderTabelasLayout.setHorizontalGroup(
            panelBorderTabelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelBorderTabelasLayout.setVerticalGroup(
            panelBorderTabelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 385, Short.MAX_VALUE)
        );

        panelBorder2.setBackground(new java.awt.Color(255, 255, 255));

        JLabelDetalhesDaCompra.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        JLabelDetalhesDaCompra.setForeground(new java.awt.Color(127, 127, 127));
        JLabelDetalhesDaCompra.setText("Detalhes da Compra");

        JLabelDataDaCompra.setText("Data da Compra");

        JLabelFornecedor.setText("Fornecedor");

        JLabelUsuario.setText("Responsável");

        JTextFieldResponsavel.setEditable(false);
        JTextFieldResponsavel.setForeground(new java.awt.Color(127, 127, 127));
        JTextFieldResponsavel.setText("nome");
        JTextFieldResponsavel.setBorder(null);
        JTextFieldResponsavel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTextFieldResponsavelMouseClicked(evt);
            }
        });

        jButton1.setText("Pesquisar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

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
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });

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

        jLabel1.setText("Forma de pagamento:");

        jComboBoxFormaPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pix", "Cartão de Crédito", "Cartão de Débito" }));

        javax.swing.GroupLayout panelBorder2Layout = new javax.swing.GroupLayout(panelBorder2);
        panelBorder2.setLayout(panelBorder2Layout);
        panelBorder2Layout.setHorizontalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder2Layout.createSequentialGroup()
                        .addComponent(JLabelDetalhesDaCompra)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelBorder2Layout.createSequentialGroup()
                        .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder2Layout.createSequentialGroup()
                                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(JTextFieldResponsavel)
                                    .addGroup(panelBorder2Layout.createSequentialGroup()
                                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(panelBorder2Layout.createSequentialGroup()
                                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JLabelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelBorder2Layout.createSequentialGroup()
                                        .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(DataCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(JLabelDataDaCompra))
                                        .addGap(18, 18, 18)
                                        .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jSeparatorPorcentagem2)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jComboBoxFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(panelBorder2Layout.createSequentialGroup()
                                                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(fornecedores)
                                                    .addComponent(JLabelFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton1))
                                            .addGroup(panelBorder2Layout.createSequentialGroup()
                                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(JLabelValorFinal1)
                                    .addGroup(panelBorder2Layout.createSequentialGroup()
                                        .addComponent(JLabelR$1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(valorFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(JButtonAdicionarItem1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        panelBorder2Layout.setVerticalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(JLabelDetalhesDaCompra)
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder2Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(jSeparator2)
                        .addContainerGap())
                    .addGroup(panelBorder2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(JLabelDataDaCompra)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DataCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelBorder2Layout.createSequentialGroup()
                        .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder2Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelBorder2Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBoxFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jSeparatorPorcentagem2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelBorder2Layout.createSequentialGroup()
                                        .addComponent(JLabelFornecedor)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(fornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton1))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JLabelUsuario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTextFieldResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBorder2Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(JLabelValorFinal1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(JLabelR$1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(valorFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JButtonAdicionarItem1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(4, 13, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout panelBorder3Layout = new javax.swing.GroupLayout(panelBorder3);
        panelBorder3.setLayout(panelBorder3Layout);
        panelBorder3Layout.setHorizontalGroup(
            panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBorder2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBorder3Layout.setVerticalGroup(
            panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBorder2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jFormattedTextFieldValorItem.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        jFormattedTextFieldValorItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldValorItemActionPerformed(evt);
            }
        });

        txtQuantidadeItem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtQuantidadeItemKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtQuantidadeItemKeyTyped(evt);
            }
        });

        jFormattedTextFieldValorTotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));

        jLabelValorTotal.setText("Valor Total do Produto:");

        jLabelQtdItem.setText("Quantidade do Produto:");

        jLabelValorItem.setText("Valor do Produto:");

        jLabelItem.setText("Produtos:");

        jScrollPane1.setBackground(new java.awt.Color(239, 239, 239));

        tableCompras.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableCompras);

        panelBorder4.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane2.setBackground(new java.awt.Color(239, 239, 239));

        tableParcelas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Data Vencimento", "Valor", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableParcelas);

        javax.swing.GroupLayout panelBorder4Layout = new javax.swing.GroupLayout(panelBorder4);
        panelBorder4.setLayout(panelBorder4Layout);
        panelBorder4Layout.setHorizontalGroup(
            panelBorder4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
            .addGroup(panelBorder4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelBorder4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        panelBorder4Layout.setVerticalGroup(
            panelBorder4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 295, Short.MAX_VALUE)
            .addGroup(panelBorder4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelBorder4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        panelBorder6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setText("Data de Vencimento");

        JButtonAdicionarItem2.setFirstColor(new java.awt.Color(153, 153, 153));
        JButtonAdicionarItem2.setPreferredSize(new java.awt.Dimension(90, 22));

        jLabel20.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Adicionar Parcecla");
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout JButtonAdicionarItem2Layout = new javax.swing.GroupLayout(JButtonAdicionarItem2);
        JButtonAdicionarItem2.setLayout(JButtonAdicionarItem2Layout);
        JButtonAdicionarItem2Layout.setHorizontalGroup(
            JButtonAdicionarItem2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JButtonAdicionarItem2Layout.createSequentialGroup()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        JButtonAdicionarItem2Layout.setVerticalGroup(
            JButtonAdicionarItem2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel4.setText("Valor");

        javax.swing.GroupLayout panelBorder6Layout = new javax.swing.GroupLayout(panelBorder6);
        panelBorder6.setLayout(panelBorder6Layout);
        panelBorder6Layout.setHorizontalGroup(
            panelBorder6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(JLabelDataDeVencimento, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                    .addComponent(jSeparator6))
                .addGap(18, 18, 18)
                .addGroup(panelBorder6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator7)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(valorParcela))
                .addGap(20, 20, 20)
                .addComponent(JButtonAdicionarItem2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelBorder6Layout.setVerticalGroup(
            panelBorder6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder6Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(panelBorder6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelBorder6Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JLabelDataDeVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBorder6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(panelBorder6Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelBorder6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(valorParcela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JButtonAdicionarItem2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19))))
        );

        javax.swing.GroupLayout panelBorder5Layout = new javax.swing.GroupLayout(panelBorder5);
        panelBorder5.setLayout(panelBorder5Layout);
        panelBorder5Layout.setHorizontalGroup(
            panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder5Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(panelBorder6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBorder5Layout.setVerticalGroup(
            panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder5Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(panelBorder6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(9, 9, 9)
                        .addComponent(JButtonRemoverItem1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JButtonAdicionarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JButtonRemoverItem, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(panelBorder3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(panelBorder1Layout.createSequentialGroup()
                                        .addComponent(jScrollPane1)
                                        .addGap(49, 49, 49)
                                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(panelBorder5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addComponent(panelBorder4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(9, 9, 9)))
                                .addComponent(panelBorderTabelas, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtItem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparatorItem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelItem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparatorValorItem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelValorItem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jFormattedTextFieldValorItem, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtQuantidadeItem, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelQtdItem, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparatorQtdItem, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jSeparatorValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jFormattedTextFieldValorTotal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabelValorTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(7, 7, 7))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JButtonRemoverItem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JButtonAdicionarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(JButtonRemoverItem1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(panelBorderTabelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(284, Short.MAX_VALUE))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                .addComponent(jSeparatorValorItem, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addComponent(panelBorder4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelBorder5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelBorder3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jPanel1.add(panelBorder1);

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        if (!ControleCaixa.isCaixaAberto()) {
            JOptionPane.showMessageDialog(null, "Não existe um caixa aberto. Abra um caixa antes de realizar a compra.");
            return;
        }

        if (DataCompra.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Deve ser selecionada a data da compra");
            DataCompra.requestFocus();
        } else {
            PesquisaItens pesquisa = new PesquisaItens(null, true);
            pesquisa.setVisible(true);
            itemSelecionado = pesquisa.getProdutoSelecionado();
            txtItem.setText(itemSelecionado.getNome());
            jFormattedTextFieldValorItem.setValue(itemSelecionado.getValor());
        }

    }//GEN-LAST:event_jLabel22MouseClicked

    private void JButtonRemoverItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JButtonRemoverItemMouseClicked
        int linha = tableCompras.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(null, "Selecione o Produto para remover.");
        } else {
            itens.remove(linha);
        }
    }//GEN-LAST:event_JButtonRemoverItemMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        PesquisaFornecedores pesquisa = new PesquisaFornecedores(null, true);
        pesquisa.setVisible(true);
        fornecedorSelecionado = pesquisa.getFornecedorSelecionado();
        fornecedores.setText(fornecedorSelecionado.getNome());
        JTextFieldResponsavel.setText(fornecedorSelecionado.getResponsavel());
    }//GEN-LAST:event_jButton1MouseClicked

    private void jFormattedTextFieldValorItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldValorItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldValorItemActionPerformed

    private void txtQuantidadeItemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantidadeItemKeyReleased
        String quantidadeItemText = txtQuantidadeItem.getText();
        String nomeItemText = txtItem.getText();
        double valorItem;

        if (nomeItemText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "O nome do Produto não pode estar em branco", "Erro", JOptionPane.ERROR_MESSAGE);
            jLabel22.requestFocus();
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
                JOptionPane.showMessageDialog(this, "O valor do Produto não é válido, insira um valor válido", "Erro", JOptionPane.ERROR_MESSAGE);
                jFormattedTextFieldValorItem.requestFocus();
                jFormattedTextFieldValorTotal.setValue(null);

            } else if (e instanceof NumberFormatException) {
                JOptionPane.showMessageDialog(this, "A quantidade de Produtos não é um número válido", "Erro", JOptionPane.ERROR_MESSAGE);
                txtQuantidadeItem.requestFocus();
                jFormattedTextFieldValorTotal.setValue(null);

            }
        }

    }//GEN-LAST:event_txtQuantidadeItemKeyReleased

    private void JButtonAdicionarItem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JButtonAdicionarItem1MouseClicked

    }//GEN-LAST:event_JButtonAdicionarItem1MouseClicked

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        int linha = tableCompras.getSelectedRow();
        int valorColumnIndex = 3;
        double somaTabela = 0;

        if (linha == -1) {
            JOptionPane.showMessageDialog(null, "Selecione o Produto para remover.");
        } else {
            Object valorCelula = tableCompras.getValueAt(linha, valorColumnIndex);
            if (valorCelula instanceof Number) {
                double valorRemovido = ((Number) valorCelula).doubleValue();
                somaTabela -= valorRemovido;
            }

            itens.remove(linha);
            atualizarTabelaItens();
            limparTexto();

            double soma = somarValoresTabela();
            valorFinal.setText("");
            valorFinal.setValue(soma);

        }

    }//GEN-LAST:event_jLabel19MouseClicked

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        if (this.itemSelecionado == null) {
            JOptionPane.showMessageDialog(null, "Não foi selecionado um Produto");
            jLabel22.requestFocus();
        } else if (txtQuantidadeItem.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "A Quantidade de Produtos deve ser preenchida");
            txtQuantidadeItem.requestFocus();
        } else {
            ativarInputs();
            Produtocompra novo = new Produtocompra();

            novo.setcodigo_produto(itemSelecionado);
            novo.setQuantidade(Integer.parseInt(txtQuantidadeItem.getText()));
            novo.setPreco(((Number) jFormattedTextFieldValorItem.getValue()).doubleValue());
            novo.setSubtotal(((Number) jFormattedTextFieldValorTotal.getValue()).doubleValue());

            boolean flag = false;
            for (Produtocompra itens : itens) {
                Produto produto = itens.getcodigo_produto();
                if (produto.getcodigo_produto() == itemSelecionado.getcodigo_produto()) {
                    flag = true;
                    int quantidadeAdicional = Integer.parseInt(txtQuantidadeItem.getText());
                    double valorAdicional = (double) jFormattedTextFieldValorTotal.getValue();

                    itens.setQuantidade(itens.getQuantidade() + quantidadeAdicional);
                    itens.setSubtotal(itens.getSubtotal() + valorAdicional);
                    break;

                }
            }

            if (!flag) {
                itens.add(novo);

            }

            atualizarTabelaItens();
            limparTexto();

            double soma = somarValoresTabela();
            valorFinal.setValue(soma);
        }
    }//GEN-LAST:event_jLabel17MouseClicked

    private void JTextFieldResponsavelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTextFieldResponsavelMouseClicked
        PesquisaFornecedores pesquisa = new PesquisaFornecedores(null, true);
        pesquisa.setVisible(true);
        fornecedorSelecionado = pesquisa.getFornecedorSelecionado();
        fornecedores.setText(fornecedorSelecionado.getNome());
        JTextFieldResponsavel.setText(fornecedorSelecionado.getResponsavel());
    }//GEN-LAST:event_JTextFieldResponsavelMouseClicked

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        if (this.confirmou = true) {
            c = this.getCompras();
            controleCompra.adicionar(c);

            atualizarTabelaItens();

            String totalString = String.valueOf(total);
            double valorFormatado = Double.parseDouble(totalString);

            DecimalFormat decimalFormat = new DecimalFormat("#.##"); // Define o formato desejado
            String valorFinalFormatado = decimalFormat.format(valorFormatado); // Formata o valor
            valorFinal.setText(valorFinalFormatado);

            JOptionPane.showMessageDialog(null, "O Pedido foi finalizado com sucesso.");
        }
    }//GEN-LAST:event_jLabel18MouseClicked

    private void txtQuantidadeItemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantidadeItemKeyTyped
        if (Character.isDigit(evt.getKeyChar())) {
        } else {
            JOptionPane.showMessageDialog(null, "Insira apenas números no campo.");
            txtQuantidadeItem.setText("");
        }
    }//GEN-LAST:event_txtQuantidadeItemKeyTyped

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel20MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DataCompra;
    private ifsplife.dev.swing.PanelBorderGradient JButtonAdicionarItem;
    private ifsplife.dev.swing.PanelBorderGradient JButtonAdicionarItem1;
    private ifsplife.dev.swing.PanelBorderGradient JButtonAdicionarItem2;
    private ifsplife.dev.swing.PanelBorderGradient JButtonRemoverItem;
    private ifsplife.dev.swing.PanelBorderGradient JButtonRemoverItem1;
    private javax.swing.JLabel JLabelDataDaCompra;
    private com.toedter.calendar.JDateChooser JLabelDataDeVencimento;
    private javax.swing.JLabel JLabelDetalhesDaCompra;
    private javax.swing.JLabel JLabelFornecedor;
    private javax.swing.JLabel JLabelR$1;
    private javax.swing.JLabel JLabelUsuario;
    private javax.swing.JLabel JLabelValorFinal1;
    private javax.swing.JTextField JTextFieldResponsavel;
    private javax.swing.JTextField fornecedores;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBoxFormaPagamento;
    private javax.swing.JFormattedTextField jFormattedTextFieldValorItem;
    private javax.swing.JFormattedTextField jFormattedTextFieldValorTotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelItem;
    private javax.swing.JLabel jLabelQtdItem;
    private javax.swing.JLabel jLabelValorItem;
    private javax.swing.JLabel jLabelValorTotal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparatorItem;
    private javax.swing.JSeparator jSeparatorPorcentagem2;
    private javax.swing.JSeparator jSeparatorQtdItem;
    private javax.swing.JSeparator jSeparatorValorItem;
    private javax.swing.JSeparator jSeparatorValorTotal;
    private ifsplife.dev.swing.PanelBorder panelBorder1;
    private ifsplife.dev.swing.PanelBorder panelBorder2;
    private ifsplife.dev.swing.PanelBorder panelBorder3;
    private ifsplife.dev.swing.PanelBorder panelBorder4;
    private ifsplife.dev.swing.PanelBorder panelBorder5;
    private ifsplife.dev.swing.PanelBorder panelBorder6;
    private ifsplife.dev.swing.PanelBorder panelBorderTabelas;
    private ifsplife.dev.swing.Table tableCompras;
    private ifsplife.dev.swing.Table tableParcelas;
    private javax.swing.JTextField txtItem;
    private javax.swing.JTextField txtQuantidadeItem;
    private javax.swing.JFormattedTextField valorFinal;
    private javax.swing.JFormattedTextField valorParcela;
    // End of variables declaration//GEN-END:variables
}
