package ifsplife.form;

import com.toedter.calendar.JTextFieldDateEditor;
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
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Form_Compras extends javax.swing.JPanel {

    private SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

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
        desabilitarTextos();
        DataCompra.setDate(new Date());
        
                ((JTextFieldDateEditor) JLabelDataDeVencimento.getDateEditor()).setEditable(false);

    }

    public void setAlterar(boolean alterar) {
        this.alterar = alterar;
    }

    public boolean isConfirmou() {
        return confirmou;
    }

    public void desabilitarTextos() {
        DataCompra.setEnabled(false);
        txtProduto.setEditable(false);
        txtValorProduto.setEditable(false);
        txtValorTotalProduto.setEditable(false);
        fornecedores.setEditable(false);
        valorParcela.setEnabled(false);
    }

    public void limparTexto() {
        txtProduto.setText("");
        txtValorProduto.setText("");
        txtQuantidadeItem.setText("");
        txtValorTotalProduto.setText("");
    }

    private void setVisibilidade(boolean visivel) {
        JLabelDataDeVencimento.setVisible(visivel);
        JLabelFornecedor.setVisible(visivel);
        //
        fornecedores.setVisible(visivel);
        jLabel2.setVisible(visivel);
        jSeparator3.setVisible(visivel);
        //

        comboParcelas.setVisible(visivel);
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
        jLabelDataVencimento.setVisible(visivel);
        jSeparatorDataVencimento.setVisible(visivel);
        jLabel4.setVisible(visivel);
        valorParcela.setVisible(visivel);
        jSeparator7.setVisible(visivel);
        JButtonAdicionarItem2.setVisible(visivel);
        jLabel20.setVisible(visivel);
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

        c.setPagamentocompra(pagamentos);

        for (Pagamentocompra p : pagamentos) {
            p.setcodigo_caixa(ControleCaixa.getCaixaAberto());
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
                formatador.format(pagamento.getVencimento()),
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

    public void atualizarEstoque(int quantidadeComprada) {
        int estoqueAnterior = itemSelecionado.getQuantidade();
        int estoqueAtualizado = estoqueAnterior - quantidadeComprada;
        itemSelecionado.setQuantidade(estoqueAtualizado);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelBorder1 = new ifsplife.dev.swing.PanelBorder();
        ProdutosDaCompra = new javax.swing.JLabel();
        ButtonPesquisarProduto = new ifsplife.dev.swing.PanelBorderGradient();
        txtPesquisarProduto = new javax.swing.JLabel();
        JButtonAdicionarProduto = new ifsplife.dev.swing.PanelBorderGradient();
        txtAdicionarProduto = new javax.swing.JLabel();
        JButtonRemoverProduto = new ifsplife.dev.swing.PanelBorderGradient();
        txtRemoverProduto = new javax.swing.JLabel();
        panelDetalhesCompra = new ifsplife.dev.swing.PanelBorder();
        panelDetalhes = new ifsplife.dev.swing.PanelBorder();
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
        jLabelProduto = new javax.swing.JLabel();
        txtProduto = new javax.swing.JTextField();
        jSeparatorProduto = new javax.swing.JSeparator();
        jLabelValorProduto = new javax.swing.JLabel();
        txtValorProduto = new javax.swing.JFormattedTextField();
        jSeparatorValorProduto = new javax.swing.JSeparator();
        jLabelQtdItem = new javax.swing.JLabel();
        txtQuantidadeItem = new javax.swing.JTextField();
        jSeparatorQtdItem = new javax.swing.JSeparator();
        jLabelValorTotalProdutos = new javax.swing.JLabel();
        txtValorTotalProduto = new javax.swing.JFormattedTextField();
        jSeparatorValorTotal = new javax.swing.JSeparator();
        jScrollPaneProdutos = new javax.swing.JScrollPane();
        tableCompras = new ifsplife.dev.swing.Table();
        panelBorderParcelas = new ifsplife.dev.swing.PanelBorder();
        jScrollPaneParcelas = new javax.swing.JScrollPane();
        tableParcelas = new ifsplife.dev.swing.Table();
        panelBorderParcelass = new ifsplife.dev.swing.PanelBorder();
        panelBorder6 = new ifsplife.dev.swing.PanelBorder();
        JButtonAdicionarItem2 = new ifsplife.dev.swing.PanelBorderGradient();
        jLabel20 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        valorParcela = new javax.swing.JFormattedTextField();
        comboParcelas = new javax.swing.JComboBox<>();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabelDataVencimento = new javax.swing.JLabel();
        JLabelDataDeVencimento = new com.toedter.calendar.JDateChooser();
        jSeparatorDataVencimento = new javax.swing.JSeparator();

        setMaximumSize(new java.awt.Dimension(1047, 744));
        setPreferredSize(new java.awt.Dimension(987, 711));
        setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBackground(new java.awt.Color(239, 239, 239));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        ProdutosDaCompra.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        ProdutosDaCompra.setForeground(new java.awt.Color(127, 127, 127));
        ProdutosDaCompra.setText("Produtos da Compra");

        ButtonPesquisarProduto.setFirstColor(new java.awt.Color(153, 153, 153));
        ButtonPesquisarProduto.setPreferredSize(new java.awt.Dimension(90, 22));

        txtPesquisarProduto.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txtPesquisarProduto.setForeground(new java.awt.Color(255, 255, 255));
        txtPesquisarProduto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtPesquisarProduto.setText("Pesquisar Produto");
        txtPesquisarProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPesquisarProdutoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout ButtonPesquisarProdutoLayout = new javax.swing.GroupLayout(ButtonPesquisarProduto);
        ButtonPesquisarProduto.setLayout(ButtonPesquisarProdutoLayout);
        ButtonPesquisarProdutoLayout.setHorizontalGroup(
            ButtonPesquisarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtPesquisarProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );
        ButtonPesquisarProdutoLayout.setVerticalGroup(
            ButtonPesquisarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtPesquisarProduto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        JButtonAdicionarProduto.setFirstColor(new java.awt.Color(153, 153, 153));
        JButtonAdicionarProduto.setPreferredSize(new java.awt.Dimension(90, 22));

        txtAdicionarProduto.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txtAdicionarProduto.setForeground(new java.awt.Color(255, 255, 255));
        txtAdicionarProduto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtAdicionarProduto.setText("Adicionar Produto");
        txtAdicionarProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtAdicionarProdutoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout JButtonAdicionarProdutoLayout = new javax.swing.GroupLayout(JButtonAdicionarProduto);
        JButtonAdicionarProduto.setLayout(JButtonAdicionarProdutoLayout);
        JButtonAdicionarProdutoLayout.setHorizontalGroup(
            JButtonAdicionarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtAdicionarProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
        );
        JButtonAdicionarProdutoLayout.setVerticalGroup(
            JButtonAdicionarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtAdicionarProduto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        JButtonRemoverProduto.setFirstColor(new java.awt.Color(153, 153, 153));
        JButtonRemoverProduto.setPreferredSize(new java.awt.Dimension(90, 22));
        JButtonRemoverProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JButtonRemoverProdutoMouseClicked(evt);
            }
        });

        txtRemoverProduto.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txtRemoverProduto.setForeground(new java.awt.Color(255, 255, 255));
        txtRemoverProduto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtRemoverProduto.setText("Remover Produto");
        txtRemoverProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtRemoverProdutoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout JButtonRemoverProdutoLayout = new javax.swing.GroupLayout(JButtonRemoverProduto);
        JButtonRemoverProduto.setLayout(JButtonRemoverProdutoLayout);
        JButtonRemoverProdutoLayout.setHorizontalGroup(
            JButtonRemoverProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtRemoverProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
        );
        JButtonRemoverProdutoLayout.setVerticalGroup(
            JButtonRemoverProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtRemoverProduto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        panelDetalhes.setBackground(new java.awt.Color(255, 255, 255));

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

        jComboBoxFormaPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o Pagamento...", "Pix", "Cartão de Crédito", "Cartão de Débito" }));

        javax.swing.GroupLayout panelDetalhesLayout = new javax.swing.GroupLayout(panelDetalhes);
        panelDetalhes.setLayout(panelDetalhesLayout);
        panelDetalhesLayout.setHorizontalGroup(
            panelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDetalhesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDetalhesLayout.createSequentialGroup()
                        .addComponent(JLabelDetalhesDaCompra)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelDetalhesLayout.createSequentialGroup()
                        .addGroup(panelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDetalhesLayout.createSequentialGroup()
                                .addGroup(panelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(JTextFieldResponsavel)
                                    .addGroup(panelDetalhesLayout.createSequentialGroup()
                                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(panelDetalhesLayout.createSequentialGroup()
                                .addGroup(panelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JLabelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelDetalhesLayout.createSequentialGroup()
                                        .addGroup(panelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(DataCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(JLabelDataDaCompra))
                                        .addGap(18, 18, 18)
                                        .addGroup(panelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jSeparatorPorcentagem2)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jComboBoxFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(panelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(panelDetalhesLayout.createSequentialGroup()
                                                .addGroup(panelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(fornecedores)
                                                    .addComponent(JLabelFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton1))
                                            .addGroup(panelDetalhesLayout.createSequentialGroup()
                                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                .addGroup(panelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(JLabelValorFinal1)
                                    .addGroup(panelDetalhesLayout.createSequentialGroup()
                                        .addComponent(JLabelR$1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(valorFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(JButtonAdicionarItem1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        panelDetalhesLayout.setVerticalGroup(
            panelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDetalhesLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(JLabelDetalhesDaCompra)
                .addGroup(panelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDetalhesLayout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(jSeparator2)
                        .addContainerGap())
                    .addGroup(panelDetalhesLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(JLabelDataDaCompra)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DataCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelDetalhesLayout.createSequentialGroup()
                        .addGroup(panelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDetalhesLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(panelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelDetalhesLayout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBoxFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jSeparatorPorcentagem2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelDetalhesLayout.createSequentialGroup()
                                        .addComponent(JLabelFornecedor)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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
                            .addGroup(panelDetalhesLayout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(JLabelValorFinal1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(JLabelR$1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(valorFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JButtonAdicionarItem1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(4, 13, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout panelDetalhesCompraLayout = new javax.swing.GroupLayout(panelDetalhesCompra);
        panelDetalhesCompra.setLayout(panelDetalhesCompraLayout);
        panelDetalhesCompraLayout.setHorizontalGroup(
            panelDetalhesCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDetalhesCompraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelDetalhes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelDetalhesCompraLayout.setVerticalGroup(
            panelDetalhesCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDetalhesCompraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelDetalhes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabelProduto.setText("Produtos:");

        jLabelValorProduto.setText("Valor do Produto:");

        txtValorProduto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        txtValorProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorProdutoActionPerformed(evt);
            }
        });

        jLabelQtdItem.setText("Quantidade do Produto:");

        txtQuantidadeItem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtQuantidadeItemKeyReleased(evt);
            }
        });

        jLabelValorTotalProdutos.setText("Valor Total do Produto:");

        txtValorTotalProduto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));

        jScrollPaneProdutos.setBackground(new java.awt.Color(239, 239, 239));

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
        jScrollPaneProdutos.setViewportView(tableCompras);

        panelBorderParcelas.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPaneParcelas.setBackground(new java.awt.Color(239, 239, 239));

        tableParcelas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Parcela", "Vencimento", "Valor", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPaneParcelas.setViewportView(tableParcelas);

        javax.swing.GroupLayout panelBorderParcelasLayout = new javax.swing.GroupLayout(panelBorderParcelas);
        panelBorderParcelas.setLayout(panelBorderParcelasLayout);
        panelBorderParcelasLayout.setHorizontalGroup(
            panelBorderParcelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 559, Short.MAX_VALUE)
            .addGroup(panelBorderParcelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelBorderParcelasLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPaneParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        panelBorderParcelasLayout.setVerticalGroup(
            panelBorderParcelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 264, Short.MAX_VALUE)
            .addGroup(panelBorderParcelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelBorderParcelasLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPaneParcelas, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        panelBorder6.setBackground(new java.awt.Color(255, 255, 255));

        JButtonAdicionarItem2.setFirstColor(new java.awt.Color(153, 153, 153));
        JButtonAdicionarItem2.setPreferredSize(new java.awt.Dimension(90, 22));
        JButtonAdicionarItem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JButtonAdicionarItem2MouseClicked(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Gerar Parcelas");
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

        valorParcela.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));

        comboParcelas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione a Quantidade...", "1x", "2x", "3x", "4x", "5x", "6x", "7x", "8x", "9x", "10x", "11x", "12x" }));
        comboParcelas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboParcelasItemStateChanged(evt);
            }
        });

        jLabel2.setText("Parcelas");

        jLabelDataVencimento.setText("Data de Vencimento");

        javax.swing.GroupLayout panelBorder6Layout = new javax.swing.GroupLayout(panelBorder6);
        panelBorder6.setLayout(panelBorder6Layout);
        panelBorder6Layout.setHorizontalGroup(
            panelBorder6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder6Layout.createSequentialGroup()
                        .addGroup(panelBorder6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(comboParcelas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator3))
                        .addGap(18, 18, 18)
                        .addGroup(panelBorder6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(valorParcela, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelBorder6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JLabelDataDeVencimento, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                            .addComponent(jSeparatorDataVencimento)
                            .addComponent(jLabelDataVencimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(JButtonAdicionarItem2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelBorder6Layout.setVerticalGroup(
            panelBorder6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder6Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(panelBorder6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder6Layout.createSequentialGroup()
                        .addGroup(panelBorder6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBorder6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(valorParcela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBorder6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder6Layout.createSequentialGroup()
                        .addComponent(jLabelDataVencimento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JLabelDataDeVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparatorDataVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JButtonAdicionarItem2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout panelBorderParcelassLayout = new javax.swing.GroupLayout(panelBorderParcelass);
        panelBorderParcelass.setLayout(panelBorderParcelassLayout);
        panelBorderParcelassLayout.setHorizontalGroup(
            panelBorderParcelassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorderParcelassLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(panelBorder6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBorderParcelassLayout.setVerticalGroup(
            panelBorderParcelassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorderParcelassLayout.createSequentialGroup()
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
                        .addComponent(ProdutosDaCompra)
                        .addGap(9, 9, 9)
                        .addComponent(ButtonPesquisarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JButtonAdicionarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JButtonRemoverProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelDetalhesCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addComponent(jScrollPaneProdutos, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                                .addGap(49, 49, 49)
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panelBorder1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(panelBorderParcelass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(panelBorderParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9))
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jSeparatorProduto)
                                    .addComponent(txtProduto)
                                    .addComponent(jLabelProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtValorProduto)
                                    .addComponent(jLabelValorProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jSeparatorValorProduto, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtQuantidadeItem)
                                    .addComponent(jSeparatorQtdItem)
                                    .addComponent(jLabelQtdItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtValorTotalProduto)
                                    .addComponent(jSeparatorValorTotal)
                                    .addComponent(jLabelValorTotalProdutos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)))))
                .addGap(7, 7, 7))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JButtonRemoverProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JButtonAdicionarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(ButtonPesquisarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ProdutosDaCompra)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelBorder1Layout.createSequentialGroup()
                            .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelProduto)
                                .addComponent(jLabelValorProduto))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jSeparatorProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelBorder1Layout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addComponent(txtValorProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jSeparatorValorProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(jLabelQtdItem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtQuantidadeItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparatorQtdItem, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(jLabelValorTotalProdutos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtValorTotalProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparatorValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(panelBorderParcelas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelBorderParcelass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDetalhesCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(panelBorder1);

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents

    private void txtPesquisarProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPesquisarProdutoMouseClicked
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

            if (pesquisa.isSelecionou()) {
                itemSelecionado = pesquisa.getProdutoSelecionado();
                txtProduto.setText(itemSelecionado.getNome());
                txtValorProduto.setValue(itemSelecionado.getValor());
            }
        }

    }//GEN-LAST:event_txtPesquisarProdutoMouseClicked

    private void JButtonRemoverProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JButtonRemoverProdutoMouseClicked
        if (!ControleCaixa.isCaixaAberto()) {
            JOptionPane.showMessageDialog(null, "Não existe um caixa aberto. Abra um caixa antes de realizar a compra.");
            return;
        }

        int linha = tableCompras.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(null, "Selecione o Produto para remover.");
        } else {
            itens.remove(linha);
        }
    }//GEN-LAST:event_JButtonRemoverProdutoMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        PesquisaFornecedores pesquisa = new PesquisaFornecedores(null, true);
        pesquisa.setVisible(true);

        if (pesquisa.isSelecionou()) {

            fornecedorSelecionado = pesquisa.getFornecedorSelecionado();
            fornecedores.setText(fornecedorSelecionado.getNome());
            JTextFieldResponsavel.setText(fornecedorSelecionado.getResponsavel());
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void txtValorProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorProdutoActionPerformed

    private void txtQuantidadeItemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantidadeItemKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getKeyCode() == KeyEvent.VK_DELETE || txtQuantidadeItem.getText().isEmpty()) {
            txtValorTotalProduto.setValue(null); // Apague o valor total do produto se a quantidade for apagada ou nula
            return;
        }

        String quantidadeItemText = txtQuantidadeItem.getText();
        String nomeItemText = txtProduto.getText();
        double valorItem;

        if (nomeItemText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "O nome do Produto não pode estar em branco", "Erro", JOptionPane.ERROR_MESSAGE);
            evt.consume();
            txtQuantidadeItem.setText("");
            txtPesquisarProduto.requestFocus();
            txtValorTotalProduto.setValue(null);
            return;
        }

        try {
            valorItem = ((Number) txtValorProduto.getValue()).doubleValue();
            int quantidadeItem = Integer.parseInt(quantidadeItemText);
            double valorTotalItens = valorItem * quantidadeItem;
            txtValorTotalProduto.setValue(valorTotalItens);

        } catch (NumberFormatException | ClassCastException | NullPointerException e) {
            if (e instanceof NullPointerException || e instanceof ClassCastException) {
                JOptionPane.showMessageDialog(this, "O valor do Produto não é válido, insira um valor válido", "Erro", JOptionPane.ERROR_MESSAGE);
                txtQuantidadeItem.setText("");

                evt.consume();
                txtValorProduto.requestFocus();
                txtValorTotalProduto.setValue(null);

            } else if (e instanceof NumberFormatException) {
                JOptionPane.showMessageDialog(this, "A quantidade de Produtos não é um número válido", "Erro", JOptionPane.ERROR_MESSAGE);
                evt.consume();
                txtQuantidadeItem.setText("");

                txtQuantidadeItem.requestFocus();
                txtValorTotalProduto.setValue(null);
            }
        }
    }//GEN-LAST:event_txtQuantidadeItemKeyReleased

    private void JButtonAdicionarItem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JButtonAdicionarItem1MouseClicked

    }//GEN-LAST:event_JButtonAdicionarItem1MouseClicked

    private void txtRemoverProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtRemoverProdutoMouseClicked
        if (!ControleCaixa.isCaixaAberto()) {
            JOptionPane.showMessageDialog(null, "Não existe um caixa aberto. Abra um caixa antes de realizar a compra.");
            return;
        }

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

    }//GEN-LAST:event_txtRemoverProdutoMouseClicked

    private void txtAdicionarProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAdicionarProdutoMouseClicked
        if (!ControleCaixa.isCaixaAberto()) {
            JOptionPane.showMessageDialog(null, "Não existe um caixa aberto. Abra um caixa antes de realizar a compra.");
            return;
        }

        if (this.itemSelecionado == null) {
            JOptionPane.showMessageDialog(null, "Não foi selecionado um Produto");
            txtPesquisarProduto.requestFocus();
        } else if (txtQuantidadeItem.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "A Quantidade de Produtos deve ser preenchida");
            txtQuantidadeItem.requestFocus();
        } else {
            ativarInputs();
            Produtocompra novo = new Produtocompra();

            novo.setcodigo_produto(itemSelecionado);
            novo.setQuantidade(Integer.parseInt(txtQuantidadeItem.getText()));
            novo.setPreco(((Number) txtValorProduto.getValue()).doubleValue());
            novo.setSubtotal(((Number) txtValorTotalProduto.getValue()).doubleValue());

            boolean flag = false;
            for (Produtocompra itens : itens) {
                Produto produto = itens.getcodigo_produto();
                if (produto.getcodigo_produto() == itemSelecionado.getcodigo_produto()) {
                    flag = true;
                    int quantidadeAdicional = Integer.parseInt(txtQuantidadeItem.getText());
                    double valorAdicional = (double) txtValorTotalProduto.getValue();

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
    }//GEN-LAST:event_txtAdicionarProdutoMouseClicked

    private void JTextFieldResponsavelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTextFieldResponsavelMouseClicked
        PesquisaFornecedores pesquisa = new PesquisaFornecedores(null, true);
        pesquisa.setVisible(true);
        fornecedorSelecionado = pesquisa.getFornecedorSelecionado();
        fornecedores.setText(fornecedorSelecionado.getNome());
        JTextFieldResponsavel.setText(fornecedorSelecionado.getResponsavel());
    }//GEN-LAST:event_JTextFieldResponsavelMouseClicked

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        String selectedValueF = (String) jComboBoxFormaPagamento.getSelectedItem();

        if ("Selecione o Pagamento...".equals(selectedValueF)) {
            JOptionPane.showMessageDialog(null, "Por favor, selecione uma forma de pagamento.", "Forma de Pagamento Não Selecionada", JOptionPane.ERROR_MESSAGE);
            comboParcelas.requestFocus();
        } else if (fornecedores.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha o campo de fornecedor.", "Fornecedor Não Informado", JOptionPane.ERROR_MESSAGE);
            fornecedores.requestFocus();
        } else {
            c = this.getCompras();
            controleCompra.adicionar(c);

            for (Produtocompra item : itens) {
                atualizarEstoque(item.getQuantidade());
            }

            atualizarTabelaItens();

            String totalString = String.valueOf(total);
            double valorFormatado = Double.parseDouble(totalString);

            DecimalFormat decimalFormat = new DecimalFormat("#.##"); // Define o formato desejado
            String valorFinalFormatado = decimalFormat.format(valorFormatado); // Formata o valor
            valorFinal.setText(valorFinalFormatado);

            JOptionPane.showMessageDialog(null, "O Pedido foi finalizado com sucesso.", "Pedido Finalizado", JOptionPane.INFORMATION_MESSAGE);

            DefaultTableModel model = (DefaultTableModel) tableCompras.getModel();
            DefaultTableModel model2 = (DefaultTableModel) tableParcelas.getModel();

            model.setRowCount(0);
            model2.setRowCount(0);
        }
    }//GEN-LAST:event_jLabel18MouseClicked

    private void JButtonAdicionarItem2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JButtonAdicionarItem2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_JButtonAdicionarItem2MouseClicked

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked

        String selectedValue = (String) comboParcelas.getSelectedItem();

        if ("Selecione a Quantidade...".equals(selectedValue)) {
            JOptionPane.showMessageDialog(null, "É necessário selecionar a quantidade de parcelas.");
            comboParcelas.requestFocus();
        } else if (JLabelDataDeVencimento.getDate() == null) {
            JOptionPane.showMessageDialog(null, "A Data de Vencimento da Parcela deve ser preenchida.");
            JLabelDataDeVencimento.requestFocus();
        } else if (valorParcela.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "O Valor da Parcela deve ser preenchido.");
            valorParcela.requestFocus();
        } else {
            String numericPart = selectedValue.replaceAll("\\D+", "");

            pagamentos.clear();
            int sequencia = Integer.parseInt(numericPart);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(JLabelDataDeVencimento.getDate());

            for (int i = 0; i < sequencia; i++) {
                Pagamentocompra parcela = new Pagamentocompra();

                parcela.setParcela(i + 1);
                parcela.setVencimento(calendar.getTime());
                parcela.setValor(Double.valueOf(valorParcela.getText()));
                parcela.setStatus("Pendente");
                parcela.setcodigo_caixa(ControleCaixa.getCaixaAberto());
                parcela.setCodigo_compra(c);
                pagamentos.add(parcela);

                calendar.add(Calendar.MONTH, 1);
            }
            atualizarTabelaParcelas();

            JLabelDataDeVencimento.setDate(null);
            valorParcela.setText("");
        }
    }//GEN-LAST:event_jLabel20MouseClicked

    private void comboParcelasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboParcelasItemStateChanged
        String selectedParcela = comboParcelas.getSelectedItem().toString();
        double valorTotal = Double.parseDouble(valorFinal.getValue().toString());

        switch (selectedParcela) {
            case "1x" -> {
                valorParcela.setText(valorFinal.getValue().toString());
            }
            case "2x" -> {
                valorParcela.setText(Double.toString(valorTotal / 2));
            }
            case "3x" -> {
                valorParcela.setText(Double.toString(valorTotal / 3));
            }
            case "4x" -> {
                valorParcela.setText(Double.toString(valorTotal / 4));
            }
            case "5x" -> {
                valorParcela.setText(Double.toString(valorTotal / 5));
            }
            case "6x" -> {
                valorParcela.setText(Double.toString(valorTotal / 6));
            }
            case "7x" -> {
                valorParcela.setText(Double.toString(valorTotal / 7));
            }
            case "8x" -> {
                valorParcela.setText(Double.toString(valorTotal / 8));
            }
            case "9x" -> {
                valorParcela.setText(Double.toString(valorTotal / 9));
            }
            case "10x" -> {
                valorParcela.setText(Double.toString(valorTotal / 10));
            }
            case "11x" -> {
                valorParcela.setText(Double.toString(valorTotal / 11));
            }
            case "12x" -> {
                valorParcela.setText(Double.toString(valorTotal / 12));
            }
        }
    }//GEN-LAST:event_comboParcelasItemStateChanged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ifsplife.dev.swing.PanelBorderGradient ButtonPesquisarProduto;
    private com.toedter.calendar.JDateChooser DataCompra;
    private ifsplife.dev.swing.PanelBorderGradient JButtonAdicionarItem1;
    private ifsplife.dev.swing.PanelBorderGradient JButtonAdicionarItem2;
    private ifsplife.dev.swing.PanelBorderGradient JButtonAdicionarProduto;
    private ifsplife.dev.swing.PanelBorderGradient JButtonRemoverProduto;
    private javax.swing.JLabel JLabelDataDaCompra;
    private com.toedter.calendar.JDateChooser JLabelDataDeVencimento;
    private javax.swing.JLabel JLabelDetalhesDaCompra;
    private javax.swing.JLabel JLabelFornecedor;
    private javax.swing.JLabel JLabelR$1;
    private javax.swing.JLabel JLabelUsuario;
    private javax.swing.JLabel JLabelValorFinal1;
    private javax.swing.JTextField JTextFieldResponsavel;
    private javax.swing.JLabel ProdutosDaCompra;
    private javax.swing.JComboBox<String> comboParcelas;
    private javax.swing.JTextField fornecedores;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBoxFormaPagamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelDataVencimento;
    private javax.swing.JLabel jLabelProduto;
    private javax.swing.JLabel jLabelQtdItem;
    private javax.swing.JLabel jLabelValorProduto;
    private javax.swing.JLabel jLabelValorTotalProdutos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPaneParcelas;
    private javax.swing.JScrollPane jScrollPaneProdutos;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparatorDataVencimento;
    private javax.swing.JSeparator jSeparatorPorcentagem2;
    private javax.swing.JSeparator jSeparatorProduto;
    private javax.swing.JSeparator jSeparatorQtdItem;
    private javax.swing.JSeparator jSeparatorValorProduto;
    private javax.swing.JSeparator jSeparatorValorTotal;
    private ifsplife.dev.swing.PanelBorder panelBorder1;
    private ifsplife.dev.swing.PanelBorder panelBorder6;
    private ifsplife.dev.swing.PanelBorder panelBorderParcelas;
    private ifsplife.dev.swing.PanelBorder panelBorderParcelass;
    private ifsplife.dev.swing.PanelBorder panelDetalhes;
    private ifsplife.dev.swing.PanelBorder panelDetalhesCompra;
    private ifsplife.dev.swing.Table tableCompras;
    private ifsplife.dev.swing.Table tableParcelas;
    private javax.swing.JLabel txtAdicionarProduto;
    private javax.swing.JLabel txtPesquisarProduto;
    private javax.swing.JTextField txtProduto;
    private javax.swing.JTextField txtQuantidadeItem;
    private javax.swing.JLabel txtRemoverProduto;
    private javax.swing.JFormattedTextField txtValorProduto;
    private javax.swing.JFormattedTextField txtValorTotalProduto;
    private javax.swing.JFormattedTextField valorFinal;
    private javax.swing.JFormattedTextField valorParcela;
    // End of variables declaration//GEN-END:variables
}
