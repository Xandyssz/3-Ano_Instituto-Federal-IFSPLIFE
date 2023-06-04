package ifsplife.form;

import ifsplife.control.ControleVenda;
import ifsplife.model.Itemvenda;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class Form_RelatorioVendas extends javax.swing.JPanel {

    ControleVenda controle = new ControleVenda();

    List<Itemvenda> itens = new ArrayList<>();

    public Form_RelatorioVendas() {
        initComponents();
        tableRelatVendas.getColumnModel().getColumn(0).setPreferredWidth(30);
        tableRelatVendas.getColumnModel().getColumn(1).setPreferredWidth(250);
        tableRelatVendas.getColumnModel().getColumn(0).setPreferredWidth(100);
        tableRelatVendas.getColumnModel().getColumn(0).setPreferredWidth(100);

        atualizarTabela();

    }

    private void atualizarTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tableRelatVendas.getModel();

        modelo.setRowCount(0);

        for (Itemvenda itens : itens) {
            modelo.addRow(new Object[]{itens.getCodigo_venda().getData_venda(), itens.getCodigo_item(), itens.getCodigo_item().getCategoria(), itens.getCodigo_venda().getValor_venda()}
            );
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JButtonVisualizar = new ifsplife.dev.swing.PanelBorderGradient();
        jLabel18 = new javax.swing.JLabel();
        JButtonEditar = new ifsplife.dev.swing.PanelBorderGradient();
        jLabel17 = new javax.swing.JLabel();
        JButtonExcluir = new ifsplife.dev.swing.PanelBorderGradient();
        jLabel15 = new javax.swing.JLabel();
        panelBorder1 = new ifsplife.dev.swing.PanelBorder();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableRelatVendas = new ifsplife.dev.swing.Table();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        search2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        clear1 = new javax.swing.JLabel();
        jLabelFIltro = new javax.swing.JLabel();
        comboFiltro = new javax.swing.JComboBox<>();
        jLabelCategoria = new javax.swing.JLabel();
        jLabelCategoria1 = new javax.swing.JLabel();
        jLabelCategoria2 = new javax.swing.JLabel();
        jLabelCategoria3 = new javax.swing.JLabel();
        comboFiltroValor = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(239, 239, 239));

        JButtonVisualizar.setFirstColor(new java.awt.Color(153, 153, 153));
        JButtonVisualizar.setPreferredSize(new java.awt.Dimension(112, 35));
        JButtonVisualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JButtonVisualizarMouseClicked(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Visualizar");

        javax.swing.GroupLayout JButtonVisualizarLayout = new javax.swing.GroupLayout(JButtonVisualizar);
        JButtonVisualizar.setLayout(JButtonVisualizarLayout);
        JButtonVisualizarLayout.setHorizontalGroup(
            JButtonVisualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
        );
        JButtonVisualizarLayout.setVerticalGroup(
            JButtonVisualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        JButtonEditar.setFirstColor(new java.awt.Color(153, 153, 153));
        JButtonEditar.setPreferredSize(new java.awt.Dimension(112, 35));
        JButtonEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JButtonEditarMouseClicked(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Editar");

        javax.swing.GroupLayout JButtonEditarLayout = new javax.swing.GroupLayout(JButtonEditar);
        JButtonEditar.setLayout(JButtonEditarLayout);
        JButtonEditarLayout.setHorizontalGroup(
            JButtonEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
        );
        JButtonEditarLayout.setVerticalGroup(
            JButtonEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        JButtonExcluir.setFirstColor(new java.awt.Color(153, 153, 153));
        JButtonExcluir.setPreferredSize(new java.awt.Dimension(112, 35));
        JButtonExcluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JButtonExcluirMouseClicked(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Excluir");

        javax.swing.GroupLayout JButtonExcluirLayout = new javax.swing.GroupLayout(JButtonExcluir);
        JButtonExcluir.setLayout(JButtonExcluirLayout);
        JButtonExcluirLayout.setHorizontalGroup(
            JButtonExcluirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
        );
        JButtonExcluirLayout.setVerticalGroup(
            JButtonExcluirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        tableRelatVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome", "Quantidade", "Valor Unitario", "SubTotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableRelatVendas);

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(127, 127, 127));
        jLabel3.setText("Item");

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 693, Short.MAX_VALUE)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setText("Relatório de Vendas Realizadas no Sistema");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        search2.setForeground(new java.awt.Color(153, 153, 153));
        search2.setBorder(null);
        search2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                search2KeyTyped(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ifsplife/view/icon/search.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        clear1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ifsplife/view/icon/x.png"))); // NOI18N
        clear1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clear1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(clear1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(search2, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(search2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(clear1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabelFIltro.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabelFIltro.setText("Filtro:");

        comboFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Medicamentos", "Cosméticos", "Perfumes", "Higiene Pessoal", "Alimentos" }));
        comboFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboFiltroActionPerformed(evt);
            }
        });

        jLabelCategoria.setFont(new java.awt.Font("SansSerif", 2, 14)); // NOI18N
        jLabelCategoria.setForeground(new java.awt.Color(0, 78, 146));
        jLabelCategoria.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCategoria.setText("Categoria");
        jLabelCategoria.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabelCategoria1.setFont(new java.awt.Font("SansSerif", 2, 14)); // NOI18N
        jLabelCategoria1.setForeground(new java.awt.Color(0, 78, 146));
        jLabelCategoria1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCategoria1.setText("data de início:");
        jLabelCategoria1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabelCategoria2.setFont(new java.awt.Font("SansSerif", 2, 14)); // NOI18N
        jLabelCategoria2.setForeground(new java.awt.Color(0, 78, 146));
        jLabelCategoria2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCategoria2.setText("data final:");
        jLabelCategoria2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabelCategoria3.setFont(new java.awt.Font("SansSerif", 2, 14)); // NOI18N
        jLabelCategoria3.setForeground(new java.awt.Color(0, 78, 146));
        jLabelCategoria3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCategoria3.setText("Valor até:");
        jLabelCategoria3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        comboFiltroValor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Medicamentos", "Cosméticos", "Perfumes", "Higiene Pessoal", "Alimentos" }));
        comboFiltroValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboFiltroValorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JButtonVisualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelCategoria1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelCategoria2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelFIltro, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboFiltroValor, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelCategoria3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabelCategoria1)
                            .addComponent(jLabelCategoria2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(comboFiltroValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelFIltro)
                                        .addComponent(comboFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabelCategoria3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelCategoria, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9)
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JButtonVisualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JButtonEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JButtonEditarMouseClicked

    }//GEN-LAST:event_JButtonEditarMouseClicked

    private void JButtonVisualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JButtonVisualizarMouseClicked

    }//GEN-LAST:event_JButtonVisualizarMouseClicked

    private void JButtonExcluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JButtonExcluirMouseClicked

    }//GEN-LAST:event_JButtonExcluirMouseClicked

    private void search2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search2KeyTyped
        atualizarTabela();
    }//GEN-LAST:event_search2KeyTyped

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        atualizarTabela();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void clear1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clear1MouseClicked
        search2.setText("");
    }//GEN-LAST:event_clear1MouseClicked

    private void comboFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboFiltroActionPerformed

    }//GEN-LAST:event_comboFiltroActionPerformed

    private void comboFiltroValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboFiltroValorActionPerformed

    }//GEN-LAST:event_comboFiltroValorActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ifsplife.dev.swing.PanelBorderGradient JButtonEditar;
    private ifsplife.dev.swing.PanelBorderGradient JButtonExcluir;
    private ifsplife.dev.swing.PanelBorderGradient JButtonVisualizar;
    private javax.swing.JLabel clear1;
    private javax.swing.JComboBox<String> comboFiltro;
    private javax.swing.JComboBox<String> comboFiltroValor;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelCategoria;
    private javax.swing.JLabel jLabelCategoria1;
    private javax.swing.JLabel jLabelCategoria2;
    private javax.swing.JLabel jLabelCategoria3;
    private javax.swing.JLabel jLabelFIltro;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private ifsplife.dev.swing.PanelBorder panelBorder1;
    private javax.swing.JTextField search2;
    private ifsplife.dev.swing.Table tableRelatVendas;
    // End of variables declaration//GEN-END:variables
}
