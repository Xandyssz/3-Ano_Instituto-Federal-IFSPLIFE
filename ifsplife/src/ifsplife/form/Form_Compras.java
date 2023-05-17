package ifsplife.form;

import ifsplife.model.Fornecedores;
import ifsplife.control.ControleFornecedor;
import ifsplife.jdialog.PesquisaItens;
import ifsplife.model.Item;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Form_Compras extends javax.swing.JPanel {

    private boolean confirmou = false;
    private int codigo = 0;

    private ControleFornecedor controle = new ControleFornecedor();

    List<Item> itens = new ArrayList<>();

    public Form_Compras() {
        initComponents();

        for (Fornecedores f : controle.getTodos()) {
            jComboBoxFornecedores.addItem(f);
        }
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
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        JLabelDataDeVencimento = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        JLabelFornecedor = new javax.swing.JLabel();
        JLabelUsuario = new javax.swing.JLabel();
        JTextFieldResponsavel = new javax.swing.JTextField();
        JLabelValorFinal = new javax.swing.JLabel();
        JLabelR$ = new javax.swing.JLabel();
        JLabelTotalCompra = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        JButtonFinalizarPedido = new ifsplife.dev.swing.PanelBorderGradient();
        JLabelFinalizarPedido = new javax.swing.JLabel();
        jComboBoxFornecedores = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCompras = new ifsplife.dev.swing.Table();

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

        JLabelValorFinal.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        JLabelValorFinal.setForeground(new java.awt.Color(127, 127, 127));
        JLabelValorFinal.setText("Valor Final");

        JLabelR$.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        JLabelR$.setForeground(new java.awt.Color(127, 127, 127));
        JLabelR$.setText("R$");

        JLabelTotalCompra.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        JLabelTotalCompra.setForeground(new java.awt.Color(127, 127, 127));
        JLabelTotalCompra.setText("0.00");

        JButtonFinalizarPedido.setFirstColor(new java.awt.Color(153, 153, 153));
        JButtonFinalizarPedido.setPreferredSize(new java.awt.Dimension(90, 22));

        JLabelFinalizarPedido.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        JLabelFinalizarPedido.setForeground(new java.awt.Color(255, 255, 255));
        JLabelFinalizarPedido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLabelFinalizarPedido.setText("Finalizar Pedido");

        javax.swing.GroupLayout JButtonFinalizarPedidoLayout = new javax.swing.GroupLayout(JButtonFinalizarPedido);
        JButtonFinalizarPedido.setLayout(JButtonFinalizarPedidoLayout);
        JButtonFinalizarPedidoLayout.setHorizontalGroup(
            JButtonFinalizarPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JButtonFinalizarPedidoLayout.createSequentialGroup()
                .addComponent(JLabelFinalizarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        JButtonFinalizarPedidoLayout.setVerticalGroup(
            JButtonFinalizarPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JLabelFinalizarPedido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        jComboBoxFornecedores.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxFornecedoresItemStateChanged(evt);
            }
        });

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
                            .addComponent(JLabelFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JLabelDataDaCompra)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jComboBoxFornecedores, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                        .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder2Layout.createSequentialGroup()
                                .addComponent(JLabelDataDeVencimento)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(panelBorder2Layout.createSequentialGroup()
                                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(JTextFieldResponsavel, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JLabelUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                                    .addComponent(jSeparator5)
                                    .addComponent(jDateChooser2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JButtonFinalizarPedido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder2Layout.createSequentialGroup()
                                        .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panelBorder2Layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(JLabelR$)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(JLabelTotalCompra))
                                            .addComponent(JLabelValorFinal))
                                        .addGap(148, 148, 148)))))
                        .addContainerGap())))
        );
        panelBorder2Layout.setVerticalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(JLabelDetalhesDaCompra)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelBorder2Layout.createSequentialGroup()
                                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(JLabelDataDeVencimento)
                                    .addComponent(JLabelDataDaCompra))
                                .addGap(12, 12, 12)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelBorder2Layout.createSequentialGroup()
                                .addGap(0, 2, Short.MAX_VALUE)
                                .addComponent(JLabelUsuario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JTextFieldResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBorder2Layout.createSequentialGroup()
                                .addComponent(JLabelFornecedor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator2))))
                    .addGroup(panelBorder2Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder2Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(JLabelR$)
                                    .addComponent(JLabelTotalCompra)))
                            .addComponent(JLabelValorFinal))
                        .addGap(18, 18, 18)
                        .addComponent(JButtonFinalizarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
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
                "Nome", "Valor", "Quantidade", "SubTotal"
            }
        ));
        jScrollPane1.setViewportView(tableCompras);

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(JButtonRemoverItem1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JButtonAdicionarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JButtonRemoverItem, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelBorderTabelas, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelBorder3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(panelBorderTabelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(panelBorder3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(panelBorder1);

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxFornecedoresItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxFornecedoresItemStateChanged
        jComboBoxFornecedores.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent event) {
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    Fornecedores fornecedores = (Fornecedores) event.getItem();
                    if (fornecedores != null) {
                        JTextFieldResponsavel.setText(fornecedores.getResponsavel());
                    }
                }
            }
        });
    }//GEN-LAST:event_jComboBoxFornecedoresItemStateChanged

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        PesquisaItens pesquisa = new PesquisaItens(null, true);
        pesquisa.setVisible(true);
    }//GEN-LAST:event_jLabel22MouseClicked

    private void JButtonRemoverItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JButtonRemoverItemMouseClicked
        int linha = tableCompras.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(null, "Selecione o Item para remover.");
        } else {
            itens.remove(linha);
            // atualizarTabela();
        }
    }//GEN-LAST:event_JButtonRemoverItemMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ifsplife.dev.swing.PanelBorderGradient JButtonAdicionarItem;
    private ifsplife.dev.swing.PanelBorderGradient JButtonFinalizarPedido;
    private ifsplife.dev.swing.PanelBorderGradient JButtonRemoverItem;
    private ifsplife.dev.swing.PanelBorderGradient JButtonRemoverItem1;
    private javax.swing.JLabel JLabelDataDaCompra;
    private javax.swing.JLabel JLabelDataDeVencimento;
    private javax.swing.JLabel JLabelDetalhesDaCompra;
    private javax.swing.JLabel JLabelFinalizarPedido;
    private javax.swing.JLabel JLabelFornecedor;
    private javax.swing.JLabel JLabelR$;
    private javax.swing.JLabel JLabelTotalCompra;
    private javax.swing.JLabel JLabelUsuario;
    private javax.swing.JLabel JLabelValorFinal;
    private javax.swing.JTextField JTextFieldResponsavel;
    private javax.swing.JComboBox<Fornecedores> jComboBoxFornecedores;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator5;
    private ifsplife.dev.swing.PanelBorder panelBorder1;
    private ifsplife.dev.swing.PanelBorder panelBorder2;
    private ifsplife.dev.swing.PanelBorder panelBorder3;
    private ifsplife.dev.swing.PanelBorder panelBorderTabelas;
    private ifsplife.dev.swing.Table tableCompras;
    // End of variables declaration//GEN-END:variables
}
