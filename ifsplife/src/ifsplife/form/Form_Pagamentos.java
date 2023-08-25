package ifsplife.form;

import ifsplife.control.ControlePagamento;
import ifsplife.jdialog.RelatorioVendas;
import ifsplife.model.Compras;
import ifsplife.model.Pagamentocompra;
import ifsplife.model.Produtocompra;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

public class Form_Pagamentos extends javax.swing.JPanel {

    private SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

    ControlePagamento controle = new ControlePagamento();
    List<Produtocompra> itens = new ArrayList<>();
    List<Pagamentocompra> pagamentos = new ArrayList<>();

    public Form_Pagamentos() {
        initComponents();
        atualizarTabela();
        desabilitarTextos();
        inicio.setDate(new Date());
    }

    public void desabilitarTextos() {
        inicio.setEnabled(false);
    }

    private void atualizarTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tablePagamentos.getModel();

        modelo.setRowCount(0);
        pagamentos.clear();
        pagamentos.addAll(controle.getPorPeriodo(inicio.getDate(), fim.getDate()));

//        if (inicio.getDate() == null) {
//            pagamentos.addAll(controle.realizarPagamento(pagamento));
//        } else {
//            pagamentos.addAll(controle.getPorPeriodo(inicio.getDate(), fim.getDate()));
//        }
        for (Pagamentocompra pagamentos : pagamentos) {
            modelo.addRow(new Object[]{pagamentos.getCodigo_compra().getCodigo_compra(), pagamentos.getParcela(),formatador.format(pagamentos.getVencimento()), pagamentos.getStatus()}
            );
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new ifsplife.dev.swing.PanelBorder();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePagamentos = new ifsplife.dev.swing.Table();
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
        JButtonPagar = new ifsplife.dev.swing.PanelBorderGradient();
        jLabel18 = new javax.swing.JLabel();
        JButtonRelatorio = new ifsplife.dev.swing.PanelBorderGradient();
        jLabel16 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(239, 239, 239));

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        tablePagamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código da Compra", "Parcela", "Data de Vencimento", "Status"
            }
        ));
        jScrollPane1.setViewportView(tablePagamentos);

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(127, 127, 127));
        jLabel3.setText("Pagamentos");

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
        jLabel1.setText("Pagamentos");

        jLabel2.setText("Data de Inicio");

        jLabel4.setText("Data de Fim");

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

        JButtonPagar.setFirstColor(new java.awt.Color(153, 153, 153));
        JButtonPagar.setPreferredSize(new java.awt.Dimension(112, 35));
        JButtonPagar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JButtonPagarMouseClicked(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Pagar");

        javax.swing.GroupLayout JButtonPagarLayout = new javax.swing.GroupLayout(JButtonPagar);
        JButtonPagar.setLayout(JButtonPagarLayout);
        JButtonPagarLayout.setHorizontalGroup(
            JButtonPagarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
        );
        JButtonPagarLayout.setVerticalGroup(
            JButtonPagarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        JButtonRelatorio.setFirstColor(new java.awt.Color(153, 153, 153));
        JButtonRelatorio.setPreferredSize(new java.awt.Dimension(112, 35));
        JButtonRelatorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JButtonRelatorioMouseClicked(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Relatorio");

        javax.swing.GroupLayout JButtonRelatorioLayout = new javax.swing.GroupLayout(JButtonRelatorio);
        JButtonRelatorio.setLayout(JButtonRelatorioLayout);
        JButtonRelatorioLayout.setHorizontalGroup(
            JButtonRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
        );
        JButtonRelatorioLayout.setVerticalGroup(
            JButtonRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addComponent(JButtonRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JButtonPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(inicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addGap(8, 8, 8)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JButtonPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JButtonRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JButtonPagarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JButtonPagarMouseClicked

        int linha = tablePagamentos.getSelectedRow();

        if (linha == -1) {
            JOptionPane.showMessageDialog(null,
                    "Não foi selecionado nenhum Pagamento. Selecione.");
        } else {
            ///////////////
        }
    }//GEN-LAST:event_JButtonPagarMouseClicked

    private void JButtonFiltrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JButtonFiltrarMouseClicked
        if (inicio.getDate() == null) {
            JOptionPane.showMessageDialog(null, "É Necessário preencher Data de Inicio");
        } else if (fim.getDate() == null) {
            JOptionPane.showMessageDialog(null, "É Necessário preencher Data de Fim");
        } else {
            pagamentos.clear();
            pagamentos.addAll(controle.getPorPeriodo(inicio.getDate(), fim.getDate()));
            atualizarTabela();
        }
    }//GEN-LAST:event_JButtonFiltrarMouseClicked

    private void JButtonRelatorioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JButtonRelatorioMouseClicked
        try {
            JasperReport relatorioCompilado
                    = JasperCompileManager.compileReport("src/ifsplife/relatorio/RelatorioVendas.jrxml");

            JasperPrint relatorioPreenchido = JasperFillManager.fillReport(relatorioCompilado, null,
                    new JRBeanCollectionDataSource(pagamentos));

            JasperViewer painelRelatorio = new JasperViewer(relatorioPreenchido, false);

            painelRelatorio.show();

        } catch (JRException ex) {
            Logger.getLogger(Form_Pagamentos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JButtonRelatorioMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ifsplife.dev.swing.PanelBorderGradient JButtonFiltrar;
    private ifsplife.dev.swing.PanelBorderGradient JButtonPagar;
    private ifsplife.dev.swing.PanelBorderGradient JButtonRelatorio;
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
    private ifsplife.dev.swing.Table tablePagamentos;
    // End of variables declaration//GEN-END:variables
}
