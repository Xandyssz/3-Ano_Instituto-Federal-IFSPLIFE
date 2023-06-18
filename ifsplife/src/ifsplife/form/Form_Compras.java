package ifsplife.form;

import ifsplife.model.Fornecedores;
import ifsplife.control.ControleFornecedor;
import ifsplife.control.ControleCompra;
import ifsplife.jdialog.PesquisaFornecedores;
import ifsplife.jdialog.PesquisaItens;
import ifsplife.model.Compras;
import ifsplife.model.Item;
import ifsplife.model.Itemcompra;
import ifsplife.model.Pagamentocompra;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Form_Compras extends javax.swing.JPanel {

    ControleCompra controleCompra = new ControleCompra();
    ControleFornecedor controle = new ControleFornecedor();

    List<Itemcompra> itens = new ArrayList<>();
    List<Pagamentocompra> pagamentos = new ArrayList<>();

    boolean alterar = false;
    private boolean confirmou = false;
    private int codigo = 0;
    private double total = 0;

    Fornecedores fornecedorSelecionado = null;
    Item itemSelecionado = null;
    Item i = null;
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
        jDateChooser2.setVisible(visivel);
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
        jSeparator3.setVisible(visivel);
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
        for (Itemcompra item : itens) {
            c.adicionarItem(item);
        }
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
        for (Itemcompra ic : itens) {
            modelo.addRow(new Object[]{
                ic.getCodigo_item().getNome(),
                ic.getCodigo_item().getValor(),
                txtQuantidadeItem.getText(),
                ic.getSubtotal()});
            total += ic.getSubtotal();
        }
        String totalString = String.valueOf(total);
        valorFinal.setText(totalString);
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
        JLabelDataDeVencimento = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
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
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCompras = new ifsplife.dev.swing.Table();
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

        setPreferredSize(new java.awt.Dimension(1028, 704));
        setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBackground(new java.awt.Color(239, 239, 239));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(127, 127, 127));
        jLabel2.setText("Itens da Compra");

        JButtonRemoverItem1.setFirstColor(new java.awt.Color(153, 153, 153));
        JButtonRemoverItem1.setPreferredSize(new java.awt.Dimension(90, 22));

        jLabel22.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Pesquisar Item");
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout JButtonRemoverItem1Layout = new javax.swing.GroupLayout(JButtonRemoverItem1);
        JButtonRemoverItem1.setLayout(JButtonRemoverItem1Layout);
        JButtonRemoverItem1Layout.setHorizontalGroup(
            JButtonRemoverItem1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
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
        jLabel17.setText("Adicionar Item");
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout JButtonAdicionarItemLayout = new javax.swing.GroupLayout(JButtonAdicionarItem);
        JButtonAdicionarItem.setLayout(JButtonAdicionarItemLayout);
        JButtonAdicionarItemLayout.setHorizontalGroup(
            JButtonAdicionarItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
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
        jLabel19.setText("Remover Item");
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });

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

        JLabelDataDeVencimento.setText("Data do Vencimento");

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
                                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JLabelDataDaCompra)
                                    .addComponent(DataCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JLabelDataDeVencimento)
                                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JLabelFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelBorder2Layout.createSequentialGroup()
                                        .addComponent(fornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton1))))
                            .addGroup(panelBorder2Layout.createSequentialGroup()
                                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(JTextFieldResponsavel, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                                        .addGroup(panelBorder2Layout.createSequentialGroup()
                                            .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jSeparator2)))
                                    .addComponent(JLabelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelBorder2Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jSeparatorPorcentagem2)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jComboBoxFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(panelBorder2Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(69, 69, 69)
                        .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder2Layout.createSequentialGroup()
                                .addComponent(JButtonAdicionarItem1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(206, 206, 206))
                            .addGroup(panelBorder2Layout.createSequentialGroup()
                                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(JLabelValorFinal1)
                                    .addGroup(panelBorder2Layout.createSequentialGroup()
                                        .addComponent(JLabelR$1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(valorFinal)))
                                .addGap(210, 210, 210))))))
        );
        panelBorder2Layout.setVerticalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(JLabelDetalhesDaCompra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder2Layout.createSequentialGroup()
                        .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(panelBorder2Layout.createSequentialGroup()
                                    .addComponent(JLabelDataDaCompra)
                                    .addGap(12, 12, 12)
                                    .addComponent(DataCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelBorder2Layout.createSequentialGroup()
                                    .addComponent(JLabelDataDeVencimento)
                                    .addGap(34, 34, 34))
                                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBorder2Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(JLabelFornecedor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(fornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1))))
                        .addGap(2, 2, 2)
                        .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder2Layout.createSequentialGroup()
                                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 6, Short.MAX_VALUE)
                                    .addComponent(jSeparator3))
                                .addGap(16, 16, 16)
                                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelBorder2Layout.createSequentialGroup()
                                        .addComponent(JLabelUsuario)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JTextFieldResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelBorder2Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBoxFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jSeparatorPorcentagem2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelBorder2Layout.createSequentialGroup()
                        .addComponent(JLabelValorFinal1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JLabelR$1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(valorFinal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JButtonAdicionarItem1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout panelBorder3Layout = new javax.swing.GroupLayout(panelBorder3);
        panelBorder3.setLayout(panelBorder3Layout);
        panelBorder3Layout.setHorizontalGroup(
            panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBorder2, javax.swing.GroupLayout.PREFERRED_SIZE, 1012, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBorder3Layout.setVerticalGroup(
            panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBorder2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
        });

        jFormattedTextFieldValorTotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));

        jLabelValorTotal.setText("Valor Total do Item:");

        jLabelQtdItem.setText("Quantidade do Item:");

        jLabelValorItem.setText("Valor do Item:");

        jLabelItem.setText("Item:");

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtItem, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparatorItem, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelItem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparatorValorItem, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelValorItem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jFormattedTextFieldValorItem))
                        .addGap(18, 18, 18)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtQuantidadeItem)
                            .addComponent(jLabelQtdItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparatorQtdItem))
                        .addGap(18, 18, 18)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addComponent(jSeparatorValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabelValorTotal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                                    .addComponent(jFormattedTextFieldValorTotal, javax.swing.GroupLayout.Alignment.LEADING))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(JButtonRemoverItem1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JButtonAdicionarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JButtonRemoverItem, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(521, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelBorder3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelBorderTabelas, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(panelBorderTabelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 274, Short.MAX_VALUE))
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelBorder3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel1.add(panelBorder1);

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        if (DataCompra.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Deve ser selecionada a data da compra");
            DataCompra.requestFocus();
        } else {
            PesquisaItens pesquisa = new PesquisaItens(null, true);
            pesquisa.setVisible(true);
            itemSelecionado = pesquisa.getItemSelecionado();
            txtItem.setText(itemSelecionado.getNome());
            jFormattedTextFieldValorItem.setValue(itemSelecionado.getValor());
        }

    }//GEN-LAST:event_jLabel22MouseClicked

    private void JButtonRemoverItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JButtonRemoverItemMouseClicked
        int linha = tableCompras.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(null, "Selecione o Item para remover.");
        } else {
            itens.remove(linha);
//             atualizarTabela();
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
            JOptionPane.showMessageDialog(this, "O nome do item não pode estar em branco", "Erro", JOptionPane.ERROR_MESSAGE);
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

    }//GEN-LAST:event_JButtonAdicionarItem1MouseClicked

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked

    }//GEN-LAST:event_jLabel19MouseClicked

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        if (this.itemSelecionado == null) {
            JOptionPane.showMessageDialog(null, "Não foi selecionado um item");
            jLabel22.requestFocus();
        } else if (txtQuantidadeItem.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "A Quantidade de Itens deve ser preenchida");
            txtQuantidadeItem.requestFocus();
        } else {
            ativarInputs();
            Itemcompra novo = new Itemcompra();

            novo.setCodigo_item(itemSelecionado);
            novo.setQuantidade(Integer.parseInt(txtQuantidadeItem.getText()));
            novo.setPreco(((Number) jFormattedTextFieldValorItem.getValue()).doubleValue());
            novo.setSubtotal(((Number) jFormattedTextFieldValorTotal.getValue()).doubleValue());

            boolean flag = false;
            for (Itemcompra itens : itens) {

                if (itens.getCodigo_item().getCodigo_item() == itemSelecionado.getCodigo_item()) {
                    flag = true;
                    int quantidadeAtual = itens.getQuantidade();
                    double valorAtual = itens.getSubtotal();

                    int quantidadeAdicional = Integer.parseInt(txtQuantidadeItem.getText());
                    double valorAdicional = (double) jFormattedTextFieldValorTotal.getValue();

                    itens.setQuantidade(quantidadeAtual + quantidadeAdicional);
                    itens.setSubtotal((double) (valorAtual + valorAdicional));

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
            valorFinal.setText(totalString);

            JOptionPane.showMessageDialog(null, "O Pedido foi finalizado com sucesso.");
        }
    }//GEN-LAST:event_jLabel18MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DataCompra;
    private ifsplife.dev.swing.PanelBorderGradient JButtonAdicionarItem;
    private ifsplife.dev.swing.PanelBorderGradient JButtonAdicionarItem1;
    private ifsplife.dev.swing.PanelBorderGradient JButtonRemoverItem;
    private ifsplife.dev.swing.PanelBorderGradient JButtonRemoverItem1;
    private javax.swing.JLabel JLabelDataDaCompra;
    private javax.swing.JLabel JLabelDataDeVencimento;
    private javax.swing.JLabel JLabelDetalhesDaCompra;
    private javax.swing.JLabel JLabelFornecedor;
    private javax.swing.JLabel JLabelR$1;
    private javax.swing.JLabel JLabelUsuario;
    private javax.swing.JLabel JLabelValorFinal1;
    private javax.swing.JTextField JTextFieldResponsavel;
    private javax.swing.JTextField fornecedores;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBoxFormaPagamento;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JFormattedTextField jFormattedTextFieldValorItem;
    private javax.swing.JFormattedTextField jFormattedTextFieldValorTotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabelItem;
    private javax.swing.JLabel jLabelQtdItem;
    private javax.swing.JLabel jLabelValorItem;
    private javax.swing.JLabel jLabelValorTotal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparatorItem;
    private javax.swing.JSeparator jSeparatorPorcentagem2;
    private javax.swing.JSeparator jSeparatorQtdItem;
    private javax.swing.JSeparator jSeparatorValorItem;
    private javax.swing.JSeparator jSeparatorValorTotal;
    private ifsplife.dev.swing.PanelBorder panelBorder1;
    private ifsplife.dev.swing.PanelBorder panelBorder2;
    private ifsplife.dev.swing.PanelBorder panelBorder3;
    private ifsplife.dev.swing.PanelBorder panelBorderTabelas;
    private ifsplife.dev.swing.Table tableCompras;
    private javax.swing.JTextField txtItem;
    private javax.swing.JTextField txtQuantidadeItem;
    private javax.swing.JFormattedTextField valorFinal;
    // End of variables declaration//GEN-END:variables
}
