package ifsplife.form;

import com.toedter.calendar.JTextFieldDateEditor;
import ifsplife.control.ControleVenda;
import ifsplife.jdialog.RelatorioVendas;
import ifsplife.model.Produtovenda;
import ifsplife.model.Vendas;
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

public class Form_RelatorioVendas extends javax.swing.JPanel {

    private SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

    ControleVenda controle = new ControleVenda();
    List<Produtovenda> itens = new ArrayList<>();

    List<Vendas> vendas = new ArrayList<>();

    public Form_RelatorioVendas() {
        initComponents();
        atualizarTabela();

        ((JTextFieldDateEditor) inicio.getDateEditor()).setEditable(false);
        ((JTextFieldDateEditor) fim.getDateEditor()).setEditable(false);

    }

    private void atualizarTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tableRelatVendas.getModel();

        modelo.setRowCount(0);

        vendas.clear();

        if (inicio.getDate() == null) {
            vendas.addAll(controle.getTodos());
        } else {
            vendas.addAll(controle.getPorPeriodo(inicio.getDate(), fim.getDate()));
        }
        for (Vendas vendas : vendas) {
            double subtotal = vendas.getValor_venda();
            String valorFormatado = String.format("R$ %.2f", subtotal);
            modelo.addRow(new Object[]{formatador.format(vendas.getData_venda()), vendas.getForma_pagamento(), valorFormatado, vendas.getCodigo_convenio().getNome()}
            );
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JButtonVisualizar = new ifsplife.dev.swing.PanelBorderGradient();
        jLabel18 = new javax.swing.JLabel();
        panelBorder1 = new ifsplife.dev.swing.PanelBorder();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableRelatVendas = new ifsplife.dev.swing.Table();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        inicio = new com.toedter.calendar.JDateChooser();
        fim = new com.toedter.calendar.JDateChooser();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        JButtonFiltrar = new ifsplife.dev.swing.PanelBorderGradient();
        jLabel19 = new javax.swing.JLabel();
        JButtonExcluir1 = new ifsplife.dev.swing.PanelBorderGradient();
        jLabel16 = new javax.swing.JLabel();

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

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        tableRelatVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Data da Venda", "Forma de Pagamento", "Valor da Venda", "Convenio"
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
        jLabel3.setText("Vendas");

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setText("Vendas Realizadas");

        jLabel2.setText("Data de Inicio");

        jLabel4.setText("Data de Fim");

        inicio.setDateFormatString("dd/MM/yyyy");

        fim.setDateFormatString("dd/MM/yyyy");

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

        JButtonExcluir1.setFirstColor(new java.awt.Color(153, 153, 153));
        JButtonExcluir1.setPreferredSize(new java.awt.Dimension(112, 35));
        JButtonExcluir1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JButtonExcluir1MouseClicked(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Relatorio");

        javax.swing.GroupLayout JButtonExcluir1Layout = new javax.swing.GroupLayout(JButtonExcluir1);
        JButtonExcluir1.setLayout(JButtonExcluir1Layout);
        JButtonExcluir1Layout.setHorizontalGroup(
            JButtonExcluir1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
        );
        JButtonExcluir1Layout.setVerticalGroup(
            JButtonExcluir1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JButtonExcluir1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JButtonVisualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(inicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(fim, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(JButtonFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel4)))
                            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JButtonVisualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JButtonExcluir1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JButtonVisualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JButtonVisualizarMouseClicked

        int linha = tableRelatVendas.getSelectedRow();

        if (linha == -1) {
            JOptionPane.showMessageDialog(null,
                    "Não foi selecionado nenhuma Venda. Selecione.");
        } else {
            RelatorioVendas tela = new RelatorioVendas(null, true);

            tela.setVendas(vendas.get(linha));
            tela.desabilitarEdicao();

            tela.setVisible(true);

        }
    }//GEN-LAST:event_JButtonVisualizarMouseClicked

    private void JButtonFiltrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JButtonFiltrarMouseClicked
        if (inicio.getDate() == null) {
            JOptionPane.showMessageDialog(null, "É Necessário preencher Data de Inicio");
        } else if (fim.getDate() == null) {
            JOptionPane.showMessageDialog(null, "É Necessário preencher Data de Fim");
        } else {
            vendas.clear();
            vendas.addAll(controle.getPorPeriodo(inicio.getDate(), fim.getDate()));
            atualizarTabela();
        }
    }//GEN-LAST:event_JButtonFiltrarMouseClicked

    private void JButtonExcluir1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JButtonExcluir1MouseClicked
        try {

            ControleVenda controle = new ControleVenda();
            List<Produtovenda> itens = new ArrayList<>();

            if (inicio.getDate() == null || fim.getDate() == null) {
                itens.addAll(controle.listarTodosProdutos());
            } else {
                itens.addAll(controle.getItensPorPeriodo(inicio.getDate(), fim.getDate()));
            }

            JasperReport relatorioCompilado
                    = JasperCompileManager.compileReport("src/ifsplife/relatorio/\\RelatorioVendaAgrup.jrxml");

            JasperPrint relatorioPreenchido = JasperFillManager.fillReport(relatorioCompilado, null,
                    new JRBeanCollectionDataSource(itens));

            JasperViewer painelRelatorio = new JasperViewer(relatorioPreenchido, false);

            painelRelatorio.show();

        } catch (JRException ex) {
            Logger.getLogger(Form_RelatorioVendas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JButtonExcluir1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ifsplife.dev.swing.PanelBorderGradient JButtonExcluir1;
    private ifsplife.dev.swing.PanelBorderGradient JButtonFiltrar;
    private ifsplife.dev.swing.PanelBorderGradient JButtonVisualizar;
    private com.toedter.calendar.JDateChooser fim;
    private com.toedter.calendar.JDateChooser inicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private ifsplife.dev.swing.PanelBorder panelBorder1;
    private ifsplife.dev.swing.Table tableRelatVendas;
    // End of variables declaration//GEN-END:variables
}
