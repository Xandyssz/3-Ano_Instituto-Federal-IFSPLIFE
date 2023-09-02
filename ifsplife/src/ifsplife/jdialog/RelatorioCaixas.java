package ifsplife.jdialog;

import ifsplife.control.ControleCaixa;
import ifsplife.model.Caixa;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class RelatorioCaixas extends javax.swing.JDialog {

    ControleCaixa controle = new ControleCaixa();
    private boolean confirmou = false;
    private int codigo = 0;
    private SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat formatadorHora = new SimpleDateFormat("HH:mm:ss");

    Caixa c = null;

    List<Caixa> caixa = new ArrayList<>();

    public RelatorioCaixas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        atualizarTabelaItens();
        desativarInputs();
        // Adicione um ouvinte de seleção à tabela
        tableCaixas.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // Verifique se a seleção é válida e se não está ajustando
                if (!e.getValueIsAdjusting() && tableCaixas.getSelectedRow() != -1) {
                    int selectedRowIndex = tableCaixas.getSelectedRow();
                    preencherCamposComDadosDaLinhaSelecionada(selectedRowIndex);
                }
            }
        });

    }

    private void atualizarTabelaItens() {
        DefaultTableModel modelo = (DefaultTableModel) tableCaixas.getModel();

        modelo.setRowCount(0);

        caixa.clear();
        caixa.addAll(controle.getTodos());

        for (Caixa caixa : caixa) {
            modelo.addRow(new Object[]{
                caixa.getCodigo_caixa(),
                formatador.format(caixa.getData_abertura()),
                formatadorHora.format(caixa.getHorario_abertura()),
                caixa.getValor_abertura()});
        }

        modelo.fireTableDataChanged(); // Notifica a tabela sobre as mudanças nos dados
    }

    private void preencherCamposComDadosDaLinhaSelecionada(int rowIndex) {
        Caixa caixaSelecionado = caixa.get(rowIndex);
        setCaixa(caixaSelecionado);
        ativarInputs();
    }

    public boolean isConfirmou() {
        return confirmou;
    }

    private void setVisibilidade(boolean visivel) {

        jLabelRSSTotalDesconto1.setVisible(visivel);
        jLabelRSSTotalDesconto2.setVisible(visivel);
        jLabelRSSTotalDesconto3.setVisible(visivel);
        JLabelDetalhesDaCompra2.setVisible(visivel);
        panelBorder7.setVisible(visivel);
        panelBorder6.setVisible(visivel);
        
        DataFechamento.setVisible(visivel);
        jLabeDataVenda.setVisible(visivel);
        jSeparatorDataVenda.setVisible(visivel);

        jLabeDataVenda1.setVisible(visivel);
        HorarioFechamento.setVisible(visivel);
        jSeparatorDataVenda1.setVisible(visivel);

        jLabelTotalcomDesconto1.setVisible(visivel);
        jFormattedTextFieldTotalEntradas.setVisible(visivel);
        jSeparatorPorcentagem2.setVisible(visivel);

        jLabelTotalcomDesconto2.setVisible(visivel);
        jFormattedTextFieldTotalSaidas.setVisible(visivel);
        jSeparatorPorcentagem4.setVisible(visivel);

        jLabelTotalcomDesconto3.setVisible(visivel);
        jFormattedTextFieldValorFechamento.setVisible(visivel);
        jSeparatorPorcentagem5.setVisible(visivel);
    }

    public void desativarInputs() {
        setVisibilidade(false);
    }

    public void ativarInputs() {
        setVisibilidade(true);
    }

    public void desabilitarEdicao() {

        DataFechamento.setEnabled(false);
        HorarioFechamento.setEnabled(false);
        jFormattedTextFieldTotalEntradas.setEditable(false);
        jFormattedTextFieldTotalSaidas.setEditable(false);
        jFormattedTextFieldValorFechamento.setEnabled(false);
    }

    public Caixa getCaixa() {
        if (c == null) {
            c = new Caixa();
        }
        c.setCodigo_caixa(codigo);
        c.setData_fechamento(DataFechamento.getDate());
        c.setHorario_fechamento(HorarioFechamento.getDate());
        c.setTotal_entradas(((Number) jFormattedTextFieldTotalEntradas.getValue()).doubleValue());
        c.setTotal_saidas(((Number) jFormattedTextFieldTotalSaidas.getValue()).doubleValue());
        c.setValor_fechamento(((Number) jFormattedTextFieldValorFechamento.getValue()).doubleValue());
        return c;
    }

    public void setCaixa(Caixa caixa) {
        this.codigo = caixa.getCodigo_caixa();
        DataFechamento.setDate(caixa.getData_fechamento());
        HorarioFechamento.setDate(caixa.getHorario_fechamento());
        jFormattedTextFieldTotalEntradas.setValue(caixa.getTotal_entradas());
        jFormattedTextFieldTotalSaidas.setValue(caixa.getTotal_saidas());
        jFormattedTextFieldValorFechamento.setValue(caixa.getValor_fechamento());
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
        tableCaixas = new ifsplife.dev.swing.Table();
        panelBorder6 = new ifsplife.dev.swing.PanelBorder();
        panelBorder7 = new ifsplife.dev.swing.PanelBorder();
        JLabelDetalhesDaCompra2 = new javax.swing.JLabel();
        jLabelTotalcomDesconto1 = new javax.swing.JLabel();
        jLabelRSSTotalDesconto1 = new javax.swing.JLabel();
        jFormattedTextFieldTotalEntradas = new javax.swing.JFormattedTextField();
        jSeparatorPorcentagem2 = new javax.swing.JSeparator();
        jSeparatorDataVenda = new javax.swing.JSeparator();
        DataFechamento = new com.toedter.calendar.JDateChooser();
        jLabeDataVenda = new javax.swing.JLabel();
        jLabeDataVenda1 = new javax.swing.JLabel();
        jSeparatorDataVenda1 = new javax.swing.JSeparator();
        HorarioFechamento = new com.toedter.calendar.JDateChooser();
        jSeparatorPorcentagem4 = new javax.swing.JSeparator();
        jLabelRSSTotalDesconto2 = new javax.swing.JLabel();
        jFormattedTextFieldTotalSaidas = new javax.swing.JFormattedTextField();
        jLabelTotalcomDesconto2 = new javax.swing.JLabel();
        jLabelTotalcomDesconto3 = new javax.swing.JLabel();
        jLabelRSSTotalDesconto3 = new javax.swing.JLabel();
        jFormattedTextFieldValorFechamento = new javax.swing.JFormattedTextField();
        jSeparatorPorcentagem5 = new javax.swing.JSeparator();

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
        jLabelItens.setText("Gerenciamento de Caixa");

        tableCaixas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código do Caixa", "Data de Abertura", "Horario de Abertura", "Valor Abertura"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableCaixas);
        if (tableCaixas.getColumnModel().getColumnCount() > 0) {
            tableCaixas.getColumnModel().getColumn(0).setResizable(false);
            tableCaixas.getColumnModel().getColumn(1).setResizable(false);
            tableCaixas.getColumnModel().getColumn(3).setResizable(false);
        }

        panelBorder7.setBackground(new java.awt.Color(255, 255, 255));

        JLabelDetalhesDaCompra2.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        JLabelDetalhesDaCompra2.setForeground(new java.awt.Color(127, 127, 127));
        JLabelDetalhesDaCompra2.setText("Detalhes do Caixa");

        jLabelTotalcomDesconto1.setText("Total de Entradas");

        jLabelRSSTotalDesconto1.setText("R$");

        jLabeDataVenda.setText("Data de Fechamento");

        jLabeDataVenda1.setText("Horario de Fechamento");

        jLabelRSSTotalDesconto2.setText("R$");

        jLabelTotalcomDesconto2.setText("Total de Saidas");

        jLabelTotalcomDesconto3.setText("Valor de Fechamento");

        jLabelRSSTotalDesconto3.setText("R$");

        javax.swing.GroupLayout panelBorder7Layout = new javax.swing.GroupLayout(panelBorder7);
        panelBorder7.setLayout(panelBorder7Layout);
        panelBorder7Layout.setHorizontalGroup(
            panelBorder7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder7Layout.createSequentialGroup()
                .addGroup(panelBorder7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(JLabelDetalhesDaCompra2))
                    .addGroup(panelBorder7Layout.createSequentialGroup()
                        .addGroup(panelBorder7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder7Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(panelBorder7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(DataFechamento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                                    .addComponent(jSeparatorDataVenda)
                                    .addComponent(jLabeDataVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(21, 21, 21)
                                .addGroup(panelBorder7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jSeparatorDataVenda1)
                                    .addComponent(jLabeDataVenda1, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                                    .addComponent(HorarioFechamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(panelBorder7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelBorder7Layout.createSequentialGroup()
                                    .addComponent(jLabelRSSTotalDesconto3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jFormattedTextFieldValorFechamento, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jSeparatorPorcentagem5, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelTotalcomDesconto3, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelBorder7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelBorder7Layout.createSequentialGroup()
                                .addComponent(jLabelRSSTotalDesconto1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFormattedTextFieldTotalEntradas, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparatorPorcentagem2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelTotalcomDesconto1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelBorder7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelBorder7Layout.createSequentialGroup()
                                .addComponent(jLabelRSSTotalDesconto2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFormattedTextFieldTotalSaidas, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparatorPorcentagem4, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelTotalcomDesconto2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 48, Short.MAX_VALUE))
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
                            .addComponent(jFormattedTextFieldTotalEntradas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelRSSTotalDesconto1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparatorPorcentagem2)
                        .addGap(66, 66, 66))
                    .addGroup(panelBorder7Layout.createSequentialGroup()
                        .addGroup(panelBorder7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabeDataVenda1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelBorder7Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jSeparatorDataVenda1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBorder7Layout.createSequentialGroup()
                                .addComponent(jLabelTotalcomDesconto2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelBorder7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jFormattedTextFieldTotalSaidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelRSSTotalDesconto2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparatorPorcentagem4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelBorder7Layout.createSequentialGroup()
                        .addGroup(panelBorder7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabeDataVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelBorder7Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(panelBorder7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(HorarioFechamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(DataFechamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparatorDataVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelTotalcomDesconto3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBorder7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jFormattedTextFieldValorFechamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelRSSTotalDesconto3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparatorPorcentagem5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBorder6, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE)
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

    private void JLabelCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLabelCancelarMouseClicked
        this.dispose();
    }//GEN-LAST:event_JLabelCancelarMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DataFechamento;
    private com.toedter.calendar.JDateChooser HorarioFechamento;
    private ifsplife.dev.swing.PanelBorderGradient JButtonCancelar;
    private javax.swing.JLabel JLabelCancelar;
    private javax.swing.JLabel JLabelDetalhesDaCompra2;
    private javax.swing.JSeparator JSeparatorCRUD;
    private javax.swing.JFormattedTextField jFormattedTextFieldTotalEntradas;
    private javax.swing.JFormattedTextField jFormattedTextFieldTotalSaidas;
    private javax.swing.JFormattedTextField jFormattedTextFieldValorFechamento;
    private javax.swing.JLabel jLabeDataVenda;
    private javax.swing.JLabel jLabeDataVenda1;
    private javax.swing.JLabel jLabelItens;
    private javax.swing.JLabel jLabelRSSTotalDesconto1;
    private javax.swing.JLabel jLabelRSSTotalDesconto2;
    private javax.swing.JLabel jLabelRSSTotalDesconto3;
    private javax.swing.JLabel jLabelTotalcomDesconto1;
    private javax.swing.JLabel jLabelTotalcomDesconto2;
    private javax.swing.JLabel jLabelTotalcomDesconto3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparatorDataVenda;
    private javax.swing.JSeparator jSeparatorDataVenda1;
    private javax.swing.JSeparator jSeparatorPorcentagem2;
    private javax.swing.JSeparator jSeparatorPorcentagem4;
    private javax.swing.JSeparator jSeparatorPorcentagem5;
    private ifsplife.dev.swing.PanelBorder panelBorder1;
    private ifsplife.dev.swing.PanelBorder panelBorder6;
    private ifsplife.dev.swing.PanelBorder panelBorder7;
    private ifsplife.dev.swing.PanelBorderGradient panelBorderGradient1;
    private ifsplife.dev.swing.Table tableCaixas;
    // End of variables declaration//GEN-END:variables
}
