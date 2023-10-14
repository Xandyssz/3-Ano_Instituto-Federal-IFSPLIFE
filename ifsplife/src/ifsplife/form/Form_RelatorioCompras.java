package ifsplife.form;

import com.toedter.calendar.JTextFieldDateEditor;
import ifsplife.control.ControleCompra;
import ifsplife.jdialog.RelatorioCompras;
import ifsplife.model.Compras;
import ifsplife.model.Produtocompra;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class Form_RelatorioCompras extends javax.swing.JPanel {

    private SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

    ControleCompra controle = new ControleCompra();

    List<Compras> compras = new ArrayList<>();
    List<Produtocompra> itens = new ArrayList<>();

    public Form_RelatorioCompras() {
        initComponents();
        tableRelatCompras.getColumnModel().getColumn(0).setPreferredWidth(30);
        tableRelatCompras.getColumnModel().getColumn(1).setPreferredWidth(250);
        tableRelatCompras.getColumnModel().getColumn(0).setPreferredWidth(100);

        atualizarTabela();

        ((JTextFieldDateEditor) inicio.getDateEditor()).setEditable(false);
        ((JTextFieldDateEditor) fim.getDateEditor()).setEditable(false);

    }

    private void atualizarTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tableRelatCompras.getModel();

        modelo.setRowCount(0);

        compras.clear();

        if (inicio.getDate() == null) {
            compras.addAll(controle.getTodos());
        } else {
            compras.addAll(controle.getPorPeriodo(inicio.getDate(), fim.getDate()));
        }

        for (Compras compras : compras) {
            modelo.addRow(new Object[]{formatador.format(compras.getData_compra()), compras.getCodigo_fornecedor().getNome(), compras.getValortotal(), compras.getForma_pagamento()}
            );
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JButtonVisualizar2 = new ifsplife.dev.swing.PanelBorderGradient();
        jLabel22 = new javax.swing.JLabel();
        JButtonVisualizar = new ifsplife.dev.swing.PanelBorderGradient();
        jLabel18 = new javax.swing.JLabel();
        JButtonExcluir = new ifsplife.dev.swing.PanelBorderGradient();
        jLabel15 = new javax.swing.JLabel();
        panelBorder1 = new ifsplife.dev.swing.PanelBorder();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableRelatCompras = new ifsplife.dev.swing.Table();
        jLabel3 = new javax.swing.JLabel();
        JButtonFiltrar = new ifsplife.dev.swing.PanelBorderGradient();
        jLabel19 = new javax.swing.JLabel();
        inicio = new com.toedter.calendar.JDateChooser();
        fim = new com.toedter.calendar.JDateChooser();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(239, 239, 239));

        JButtonVisualizar2.setFirstColor(new java.awt.Color(153, 153, 153));
        JButtonVisualizar2.setPreferredSize(new java.awt.Dimension(112, 35));
        JButtonVisualizar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JButtonVisualizar2MouseClicked(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Relatorio");

        javax.swing.GroupLayout JButtonVisualizar2Layout = new javax.swing.GroupLayout(JButtonVisualizar2);
        JButtonVisualizar2.setLayout(JButtonVisualizar2Layout);
        JButtonVisualizar2Layout.setHorizontalGroup(
            JButtonVisualizar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
        );
        JButtonVisualizar2Layout.setVerticalGroup(
            JButtonVisualizar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

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

        tableRelatCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Data da Compra", "Fornecedor", "Valor Total", "Pagamento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableRelatCompras);

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(127, 127, 127));
        jLabel3.setText("Compras");

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                .addContainerGap())
        );

        JButtonFiltrar.setFirstColor(new java.awt.Color(153, 153, 153));
        JButtonFiltrar.setPreferredSize(new java.awt.Dimension(112, 35));
        JButtonFiltrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JButtonFiltrarMouseClicked(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Filtrar");

        javax.swing.GroupLayout JButtonFiltrarLayout = new javax.swing.GroupLayout(JButtonFiltrar);
        JButtonFiltrar.setLayout(JButtonFiltrarLayout);
        JButtonFiltrarLayout.setHorizontalGroup(
            JButtonFiltrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
        );
        JButtonFiltrarLayout.setVerticalGroup(
            JButtonFiltrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jLabel2.setText("Data de Inicio");

        jLabel4.setText("Data de Fim");

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setText("Compras Realizadas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JButtonVisualizar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JButtonVisualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(inicio, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                .addComponent(jSeparator1))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fim, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JButtonFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4))
                        .addGap(36, 36, 36))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(17, 17, 17))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JButtonFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(fim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(8, 8, 8)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JButtonVisualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JButtonVisualizar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JButtonVisualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JButtonVisualizarMouseClicked

        int linha = tableRelatCompras.getSelectedRow();

        if (linha == -1) {
            JOptionPane.showMessageDialog(null,
                    "Não foi selecionado nenhuma Compra. Selecione.");
        } else {
            RelatorioCompras tela = new RelatorioCompras(null, true);

            tela.setCompras(compras.get(linha));
            tela.desabilitarEdicao();

            tela.setVisible(true);

        }
    }//GEN-LAST:event_JButtonVisualizarMouseClicked

    private void JButtonExcluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JButtonExcluirMouseClicked
        Integer linha = tableRelatCompras.getSelectedRow();

        if (linha == -1) {
            JOptionPane.showMessageDialog(null,
                    "Não foi selecionado nenhuma Compra. Selecione.");
        } else {
            Integer resposta = JOptionPane.showConfirmDialog(null,
                    "Deseja excluir essa Compra?",
                    "Exclusão da Compra",
                    JOptionPane.YES_NO_OPTION);

            if (resposta == JOptionPane.YES_OPTION) {
                controle.remover(compras.get(linha));
                atualizarTabela();
            }
        }
    }//GEN-LAST:event_JButtonExcluirMouseClicked

    private void JButtonVisualizar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JButtonVisualizar2MouseClicked
        try {
            JasperReport relatorioCompilado
                    = JasperCompileManager.compileReport("src/ifsplife/relatorio/\\RelatorioCompraAgrup.jrxml");

            JasperPrint relatorioPreenchido = JasperFillManager.fillReport(relatorioCompilado, null,
                    new JRBeanCollectionDataSource(controle.listarTodosProdutos()));

            JasperViewer painelRelatorio = new JasperViewer(relatorioPreenchido, false);

            painelRelatorio.show();

        } catch (JRException ex) {
            Logger.getLogger(Form_RelatorioVendas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JButtonVisualizar2MouseClicked

    private void JButtonFiltrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JButtonFiltrarMouseClicked
        if (inicio.getDate() == null) {
            JOptionPane.showMessageDialog(null, "É Necessário preencher Data de Inicio");
        } else if (fim.getDate() == null) {
            JOptionPane.showMessageDialog(null, "É Necessário preencher Data de Fim");
        } else {
            compras.clear();
            compras.addAll(controle.getPorPeriodo(inicio.getDate(), fim.getDate()));
            atualizarTabela();
        }
    }//GEN-LAST:event_JButtonFiltrarMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ifsplife.dev.swing.PanelBorderGradient JButtonExcluir;
    private ifsplife.dev.swing.PanelBorderGradient JButtonFiltrar;
    private ifsplife.dev.swing.PanelBorderGradient JButtonVisualizar;
    private ifsplife.dev.swing.PanelBorderGradient JButtonVisualizar2;
    private com.toedter.calendar.JDateChooser fim;
    private com.toedter.calendar.JDateChooser inicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private ifsplife.dev.swing.PanelBorder panelBorder1;
    private ifsplife.dev.swing.Table tableRelatCompras;
    // End of variables declaration//GEN-END:variables
}
