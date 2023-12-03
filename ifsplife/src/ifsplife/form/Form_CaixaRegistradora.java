package ifsplife.form;

import ifsplife.control.ControleCaixa;
import ifsplife.control.ControleCompra;
import ifsplife.control.ControleMovimentacao;
import ifsplife.control.ControleVenda;
import ifsplife.jdialog.CrudCaixa;
import ifsplife.jdialog.CrudMovimentacao;
import ifsplife.jdialog.RelatorioCaixas;
import ifsplife.model.Caixa;
import ifsplife.model.Movimentacao;
import java.awt.Color;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Form_CaixaRegistradora extends javax.swing.JPanel {

    ControleMovimentacao controlemovimentacao = new ControleMovimentacao();
    ControleCaixa controlecaixa = new ControleCaixa();

    List<Movimentacao> movimentacao = new ArrayList<>();
    List<Caixa> caixas = new ArrayList<>();

    private boolean confirmou = false;
    private int codigo = 0;

    private SimpleDateFormat teste = new SimpleDateFormat("HH:mm");

    public Form_CaixaRegistradora() {
        initComponents();
        desabilitarTextos();
        if (ControleCaixa.isCaixaAberto()) {
            AbrirFecharCaixa.setText("Fechar Caixa");
            caixaStatus.setText("status do caixa: aberto");
            caixaStatus.setForeground(Color.GREEN);
            ControleCaixa.atualizarCaixa();
            setarMovimentacoes();
        } else {
            AbrirFecharCaixa.setText("Abrir Caixa");
            caixaStatus.setText("status do caixa: fechado");
            caixaStatus.setForeground(Color.RED);
        }
        atualizarTabela();
    }

    private void setarMovimentacoes() {
        Caixa caixa = ControleCaixa.getCaixaAberto();
        ControleVenda controlevenda = new ControleVenda();
        ControleCompra controlecompra = new ControleCompra();

        JTextFieldDataDeAbertura.setEnabled(false);
        JTextFieldHorarioDeAbertura.setEnabled(false);
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        JTextFieldDataDeAbertura.setDate(caixa.getData_abertura());
        JTextFieldHorarioDeAbertura.setText(format.format(caixa.getHorario_abertura()));
        JFormattedTextFieldValorInicial.setValue(caixa.getValor_abertura());

        ////////// PREENCHE O INPUT [VALOR TOTAL] para fechar o caixa
        JFormattedTextFieldValorTotal.setValue(caixa.getValor_abertura()
                + caixa.getSuplementacao()
                + controlevenda.getTotalVendaPorCaixa(caixa)
                - caixa.getSangria()
                - controlecompra.getTotalParcelasPago(caixa));

        // PREENCHE INPUTS
        JFormattedTextFieldSuplementacao.setValue(caixa.getSuplementacao());
        JFormattedTextFieldVendas.setValue(controlevenda.getTotalVendaPorCaixa(caixa));
        JFormattedTextFieldCompras.setValue(controlecompra.getTotalParcelasPago(caixa));
        JFormattedTextFieldSangria.setValue(caixa.getSangria());
        //////////
    }

    private void atualizarTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tableMovimentacoes.getModel();

        modelo.setRowCount(0);

        movimentacao.clear();
        movimentacao.addAll(controlemovimentacao.getMovPorCaixa(controlecaixa.getCaixaAberto()));

        for (Movimentacao movimentacao : movimentacao) {
            double valor = movimentacao.getValor();
            String valorFormatado = String.format("R$ %.2f", valor);
            modelo.addRow(new Object[]{movimentacao.getMotivo(), valorFormatado, movimentacao.getTipo()});

        }
    }

    public boolean isConfirmou() {
        return confirmou;
    }

    public void desabilitarTextos() {
        JTextFieldDataDeAbertura.setEnabled(false);
        JTextFieldHorarioDeAbertura.setEditable(false);
        JFormattedTextFieldValorInicial.setEditable(false);
        JFormattedTextFieldValorTotal.setEditable(false);
        JFormattedTextFieldSangria.setEditable(false);
        JFormattedTextFieldSuplementacao.setEditable(false);
        JFormattedTextFieldCompras.setEditable(false);
        JFormattedTextFieldVendas.setEditable(false);
    }

    public void limparTextos() {
        JTextFieldDataDeAbertura.setDate(null);
        JTextFieldHorarioDeAbertura.setText("");
        JFormattedTextFieldValorInicial.setText("");
        JFormattedTextFieldValorTotal.setText("");
        JFormattedTextFieldSangria.setText("");
        JFormattedTextFieldSuplementacao.setText("");
        //
        JFormattedTextFieldCompras.setText("");
        JFormattedTextFieldVendas.setText("");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelBorderTela = new ifsplife.dev.swing.PanelBorder();
        JLabelMovimentacao = new javax.swing.JLabel();
        caixaStatus = new javax.swing.JLabel();
        JScrollPaneMovimentacao = new javax.swing.JScrollPane();
        tableMovimentacoes = new ifsplife.dev.swing.Table();
        panelBorderDetalhesCaixa = new ifsplife.dev.swing.PanelBorder();
        jLabelDeatalhesDoCaixa = new javax.swing.JLabel();
        jLabelDataDeAbertura = new javax.swing.JLabel();
        JTextFieldDataDeAbertura = new com.toedter.calendar.JDateChooser();
        jSeparatorDataDeAbertura = new javax.swing.JSeparator();
        jLabelHorarioDeAbertura = new javax.swing.JLabel();
        JTextFieldHorarioDeAbertura = new javax.swing.JTextField();
        jSeparatorHorarioDeAbertura = new javax.swing.JSeparator();
        jLabelValorInicial = new javax.swing.JLabel();
        jLabelRSInicial = new javax.swing.JLabel();
        JFormattedTextFieldValorInicial = new javax.swing.JFormattedTextField();
        jSeparatorValorInicial = new javax.swing.JSeparator();
        jLabelValorTotal = new javax.swing.JLabel();
        jLabelRSTotal = new javax.swing.JLabel();
        JFormattedTextFieldValorTotal = new javax.swing.JFormattedTextField();
        jSeparatorValorTotal = new javax.swing.JSeparator();
        jLabelValorSangria = new javax.swing.JLabel();
        jLabelRSSangria = new javax.swing.JLabel();
        JFormattedTextFieldSangria = new javax.swing.JFormattedTextField();
        jSeparatorSangria = new javax.swing.JSeparator();
        jLabelValorSuplementacao = new javax.swing.JLabel();
        jLabelRSSuplementacao = new javax.swing.JLabel();
        JFormattedTextFieldSuplementacao = new javax.swing.JFormattedTextField();
        jSeparatorSuplementacao = new javax.swing.JSeparator();
        JButtonMovimentacaoCaixa1 = new ifsplife.dev.swing.PanelBorderGradient();
        GerenciamentoCaixa = new javax.swing.JLabel();
        JButtonMovimentacaoCaixa = new ifsplife.dev.swing.PanelBorderGradient();
        MovimentacaoCaixa = new javax.swing.JLabel();
        JButtonCaixa = new ifsplife.dev.swing.PanelBorderGradient();
        AbrirFecharCaixa = new javax.swing.JLabel();
        jLabelValorSuplementacao1 = new javax.swing.JLabel();
        JFormattedTextFieldVendas = new javax.swing.JFormattedTextField();
        jSeparatorSuplementacao1 = new javax.swing.JSeparator();
        jLabelRSSuplementacao1 = new javax.swing.JLabel();
        jSeparatorSangria1 = new javax.swing.JSeparator();
        JFormattedTextFieldCompras = new javax.swing.JFormattedTextField();
        jLabelValorSangria1 = new javax.swing.JLabel();
        jLabelRSSangria1 = new javax.swing.JLabel();

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBackground(new java.awt.Color(239, 239, 239));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        panelBorderTela.setBackground(new java.awt.Color(255, 255, 255));

        JLabelMovimentacao.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        JLabelMovimentacao.setForeground(new java.awt.Color(127, 127, 127));
        JLabelMovimentacao.setText("Movimentações");

        caixaStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        caixaStatus.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        tableMovimentacoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Descrição", "Valor", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableMovimentacoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        JScrollPaneMovimentacao.setViewportView(tableMovimentacoes);

        panelBorderDetalhesCaixa.setBackground(new java.awt.Color(255, 255, 255));
        panelBorderDetalhesCaixa.setPreferredSize(new java.awt.Dimension(935, 387));

        jLabelDeatalhesDoCaixa.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabelDeatalhesDoCaixa.setForeground(new java.awt.Color(127, 127, 127));
        jLabelDeatalhesDoCaixa.setText("Detalhes do Caixa");

        jLabelDataDeAbertura.setText("Data de Abertura");

        JTextFieldDataDeAbertura.setDateFormatString("dd/MM/yyyy");

        jLabelHorarioDeAbertura.setText("Horário de Abertura");

        JTextFieldHorarioDeAbertura.setBorder(null);

        jLabelValorInicial.setText("Valor Inicial");

        jLabelRSInicial.setText("R$");

        JFormattedTextFieldValorInicial.setBorder(null);
        JFormattedTextFieldValorInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        JFormattedTextFieldValorInicial.setText("0");

        jLabelValorTotal.setText("Valor Final");

        jLabelRSTotal.setText("R$");

        JFormattedTextFieldValorTotal.setBorder(null);
        JFormattedTextFieldValorTotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        JFormattedTextFieldValorTotal.setText("0");

        jLabelValorSangria.setText("Valor Sangria");

        jLabelRSSangria.setText("R$");

        JFormattedTextFieldSangria.setBorder(null);
        JFormattedTextFieldSangria.setForeground(new java.awt.Color(255, 0, 0));
        JFormattedTextFieldSangria.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        JFormattedTextFieldSangria.setText("0");

        jLabelValorSuplementacao.setText("Valor Suplementação");

        jLabelRSSuplementacao.setText("R$");

        JFormattedTextFieldSuplementacao.setBorder(null);
        JFormattedTextFieldSuplementacao.setForeground(new java.awt.Color(0, 153, 51));
        JFormattedTextFieldSuplementacao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        JFormattedTextFieldSuplementacao.setText("0");

        JButtonMovimentacaoCaixa1.setFirstColor(new java.awt.Color(153, 153, 153));
        JButtonMovimentacaoCaixa1.setPreferredSize(new java.awt.Dimension(90, 22));

        GerenciamentoCaixa.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        GerenciamentoCaixa.setForeground(new java.awt.Color(255, 255, 255));
        GerenciamentoCaixa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GerenciamentoCaixa.setText("Gerenciamento de Caixa");
        GerenciamentoCaixa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GerenciamentoCaixaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout JButtonMovimentacaoCaixa1Layout = new javax.swing.GroupLayout(JButtonMovimentacaoCaixa1);
        JButtonMovimentacaoCaixa1.setLayout(JButtonMovimentacaoCaixa1Layout);
        JButtonMovimentacaoCaixa1Layout.setHorizontalGroup(
            JButtonMovimentacaoCaixa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JButtonMovimentacaoCaixa1Layout.createSequentialGroup()
                .addComponent(GerenciamentoCaixa, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        JButtonMovimentacaoCaixa1Layout.setVerticalGroup(
            JButtonMovimentacaoCaixa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(GerenciamentoCaixa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        JButtonMovimentacaoCaixa.setFirstColor(new java.awt.Color(153, 153, 153));
        JButtonMovimentacaoCaixa.setPreferredSize(new java.awt.Dimension(90, 22));
        JButtonMovimentacaoCaixa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JButtonMovimentacaoCaixaMouseClicked(evt);
            }
        });

        MovimentacaoCaixa.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        MovimentacaoCaixa.setForeground(new java.awt.Color(255, 255, 255));
        MovimentacaoCaixa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MovimentacaoCaixa.setText("Movimentação do Caixa");

        javax.swing.GroupLayout JButtonMovimentacaoCaixaLayout = new javax.swing.GroupLayout(JButtonMovimentacaoCaixa);
        JButtonMovimentacaoCaixa.setLayout(JButtonMovimentacaoCaixaLayout);
        JButtonMovimentacaoCaixaLayout.setHorizontalGroup(
            JButtonMovimentacaoCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JButtonMovimentacaoCaixaLayout.createSequentialGroup()
                .addComponent(MovimentacaoCaixa, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        JButtonMovimentacaoCaixaLayout.setVerticalGroup(
            JButtonMovimentacaoCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MovimentacaoCaixa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        JButtonCaixa.setFirstColor(new java.awt.Color(153, 153, 153));
        JButtonCaixa.setPreferredSize(new java.awt.Dimension(90, 22));

        AbrirFecharCaixa.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        AbrirFecharCaixa.setForeground(new java.awt.Color(255, 255, 255));
        AbrirFecharCaixa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AbrirFecharCaixa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AbrirFecharCaixaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout JButtonCaixaLayout = new javax.swing.GroupLayout(JButtonCaixa);
        JButtonCaixa.setLayout(JButtonCaixaLayout);
        JButtonCaixaLayout.setHorizontalGroup(
            JButtonCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JButtonCaixaLayout.createSequentialGroup()
                .addComponent(AbrirFecharCaixa, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        JButtonCaixaLayout.setVerticalGroup(
            JButtonCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AbrirFecharCaixa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        jLabelValorSuplementacao1.setText("Valor Vendas");

        JFormattedTextFieldVendas.setBorder(null);
        JFormattedTextFieldVendas.setForeground(new java.awt.Color(0, 153, 51));
        JFormattedTextFieldVendas.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        JFormattedTextFieldVendas.setText("0");

        jLabelRSSuplementacao1.setText("R$");

        JFormattedTextFieldCompras.setBorder(null);
        JFormattedTextFieldCompras.setForeground(new java.awt.Color(204, 0, 0));
        JFormattedTextFieldCompras.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        JFormattedTextFieldCompras.setText("0");

        jLabelValorSangria1.setText("Valor Compra");

        jLabelRSSangria1.setText("R$");

        javax.swing.GroupLayout panelBorderDetalhesCaixaLayout = new javax.swing.GroupLayout(panelBorderDetalhesCaixa);
        panelBorderDetalhesCaixa.setLayout(panelBorderDetalhesCaixaLayout);
        panelBorderDetalhesCaixaLayout.setHorizontalGroup(
            panelBorderDetalhesCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorderDetalhesCaixaLayout.createSequentialGroup()
                .addGroup(panelBorderDetalhesCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorderDetalhesCaixaLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabelDeatalhesDoCaixa))
                    .addGroup(panelBorderDetalhesCaixaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelBorderDetalhesCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorderDetalhesCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabelValorInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jSeparatorValorInicial, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                                .addComponent(jSeparatorDataDeAbertura, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                                .addComponent(jLabelDataDeAbertura, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                                .addGroup(panelBorderDetalhesCaixaLayout.createSequentialGroup()
                                    .addComponent(jLabelRSInicial)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(JFormattedTextFieldValorInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(JTextFieldDataDeAbertura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelBorderDetalhesCaixaLayout.createSequentialGroup()
                                    .addComponent(jLabelRSSangria)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(JFormattedTextFieldSangria, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabelValorSangria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparatorSangria))
                            .addGroup(panelBorderDetalhesCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(panelBorderDetalhesCaixaLayout.createSequentialGroup()
                                    .addComponent(jLabelRSSangria1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(JFormattedTextFieldCompras, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabelValorSangria1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparatorSangria1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelBorderDetalhesCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorderDetalhesCaixaLayout.createSequentialGroup()
                                .addComponent(jLabelRSTotal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JFormattedTextFieldValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBorderDetalhesCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jSeparatorSuplementacao, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jSeparatorValorTotal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(panelBorderDetalhesCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparatorSuplementacao1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelValorSuplementacao1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelBorderDetalhesCaixaLayout.createSequentialGroup()
                                        .addComponent(jLabelRSSuplementacao1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JFormattedTextFieldVendas, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(panelBorderDetalhesCaixaLayout.createSequentialGroup()
                                .addGroup(panelBorderDetalhesCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelHorarioDeAbertura, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparatorHorarioDeAbertura, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JTextFieldHorarioDeAbertura, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelValorSuplementacao, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelBorderDetalhesCaixaLayout.createSequentialGroup()
                                        .addComponent(jLabelRSSuplementacao)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JFormattedTextFieldSuplementacao, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                                .addGroup(panelBorderDetalhesCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JButtonCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JButtonMovimentacaoCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JButtonMovimentacaoCaixa1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(36, 36, 36))
        );
        panelBorderDetalhesCaixaLayout.setVerticalGroup(
            panelBorderDetalhesCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorderDetalhesCaixaLayout.createSequentialGroup()
                .addGroup(panelBorderDetalhesCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelBorderDetalhesCaixaLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabelDeatalhesDoCaixa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelBorderDetalhesCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelDataDeAbertura)
                            .addComponent(jLabelHorarioDeAbertura))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTextFieldDataDeAbertura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparatorDataDeAbertura, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelValorInicial)
                        .addGap(12, 12, 12)
                        .addGroup(panelBorderDetalhesCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelRSInicial)
                            .addComponent(JFormattedTextFieldValorInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparatorValorInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBorderDetalhesCaixaLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JButtonMovimentacaoCaixa1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelBorderDetalhesCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorderDetalhesCaixaLayout.createSequentialGroup()
                                .addComponent(JButtonMovimentacaoCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JButtonCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBorderDetalhesCaixaLayout.createSequentialGroup()
                                .addComponent(JTextFieldHorarioDeAbertura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparatorHorarioDeAbertura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelValorTotal)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBorderDetalhesCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelRSTotal)
                            .addComponent(JFormattedTextFieldValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparatorValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panelBorderDetalhesCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelBorderDetalhesCaixaLayout.createSequentialGroup()
                        .addComponent(jLabelValorSuplementacao)
                        .addGap(6, 6, 6)
                        .addGroup(panelBorderDetalhesCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelRSSuplementacao)
                            .addComponent(JFormattedTextFieldSuplementacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparatorSuplementacao, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jLabelValorSuplementacao1)
                        .addGap(6, 6, 6)
                        .addGroup(panelBorderDetalhesCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JFormattedTextFieldVendas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelRSSuplementacao1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparatorSuplementacao1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBorderDetalhesCaixaLayout.createSequentialGroup()
                        .addComponent(jLabelValorSangria)
                        .addGap(6, 6, 6)
                        .addGroup(panelBorderDetalhesCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelRSSangria)
                            .addComponent(JFormattedTextFieldSangria, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparatorSangria, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelValorSangria1)
                        .addGap(6, 6, 6)
                        .addGroup(panelBorderDetalhesCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelRSSangria1)
                            .addComponent(JFormattedTextFieldCompras, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparatorSangria1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelBorderTelaLayout = new javax.swing.GroupLayout(panelBorderTela);
        panelBorderTela.setLayout(panelBorderTelaLayout);
        panelBorderTelaLayout.setHorizontalGroup(
            panelBorderTelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorderTelaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorderTelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JScrollPaneMovimentacao)
                    .addComponent(panelBorderDetalhesCaixa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelBorderTelaLayout.createSequentialGroup()
                        .addComponent(JLabelMovimentacao, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(caixaStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelBorderTelaLayout.setVerticalGroup(
            panelBorderTelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorderTelaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorderTelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JLabelMovimentacao, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(caixaStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JScrollPaneMovimentacao, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelBorderDetalhesCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(panelBorderTela);

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents

    private void AbrirFecharCaixaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AbrirFecharCaixaMouseClicked
        int escolha = JOptionPane.showConfirmDialog(null, "Deseja " + (ControleCaixa.isCaixaAberto() ? "fechar" : "abrir") + " o caixa?", "Confirmação", JOptionPane.YES_NO_OPTION);

        if (escolha == JOptionPane.YES_OPTION) {
            CrudCaixa abrirCaixa = new CrudCaixa(null, true);

            if (!ControleCaixa.isCaixaAberto()) {
                abrirCaixa.setVisible(true);
                if (abrirCaixa.isConfirmou()) {
                    Caixa c = abrirCaixa.getCaixa();

                    JTextFieldDataDeAbertura.setDate(c.getData_abertura());
                    JTextFieldHorarioDeAbertura.setText(teste.format(c.getHorario_abertura()));
                    JFormattedTextFieldValorInicial.setValue(c.getValor_abertura());
                    controlecaixa.abrir(c);
                    caixaStatus.setText("status do caixa: Aberto");
                    caixaStatus.setForeground(Color.GREEN);
                    AbrirFecharCaixa.setText("Fechar Caixa");
                    atualizarTabela();
                }
            } else {
                int fecharEscolha = JOptionPane.showConfirmDialog(null, "Deseja realmente fechar o caixa?", "Confirmação", JOptionPane.YES_NO_OPTION);

                if (fecharEscolha == JOptionPane.YES_OPTION) {
                    Caixa c = ControleCaixa.getCaixaAberto();
                    c.setData_fechamento(new Date());
                    c.setHorario_fechamento(new Date());
                    c.setStatus("Fechado");
                    c.setTotal_entradas(((Number) JFormattedTextFieldSuplementacao.getValue()).doubleValue());
                    c.setTotal_saidas(((Number) JFormattedTextFieldSangria.getValue()).doubleValue());
                    c.setValor_fechamento(((Number) JFormattedTextFieldValorTotal.getValue()).doubleValue());
                    controlecaixa.fechar(c);
                    caixaStatus.setText("status do caixa: fechado");
                    caixaStatus.setForeground(Color.RED);
                    AbrirFecharCaixa.setText("Abrir Caixa");
                    DefaultTableModel model = (DefaultTableModel) tableMovimentacoes.getModel();
                    model.setRowCount(0);
                    limparTextos();
                    atualizarTabela();

                }
            }
        }
    }//GEN-LAST:event_AbrirFecharCaixaMouseClicked

    private void JButtonMovimentacaoCaixaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JButtonMovimentacaoCaixaMouseClicked
        if (!ControleCaixa.isCaixaAberto()) {
            JOptionPane.showMessageDialog(null, "Não existe um caixa aberto. Abra um caixa antes de realizar uma movimentacao");
            return;
        }

        CrudMovimentacao movimentacao = new CrudMovimentacao(null, true);

        movimentacao.setVisible(true);

        if (movimentacao.isConfirmou()) {
            Movimentacao m = movimentacao.getMovimentacao();
            controlemovimentacao.adicionar(m);

            ControleCaixa controleCaixa = new ControleCaixa();

            Caixa caixa = ControleCaixa.getCaixaAberto();

            caixa.getMovimentacao().add(m);

            controleCaixa.fechar(caixa);

            atualizarTabela();

            setarMovimentacoes();
        }
    }//GEN-LAST:event_JButtonMovimentacaoCaixaMouseClicked

    private void GerenciamentoCaixaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GerenciamentoCaixaMouseClicked
        if (ControleCaixa.isCaixaAberto()) {
            JOptionPane.showMessageDialog(null, "Existe um caixa aberto. Feche-o antes de abrir Gerenciamento.");
            return;
        }

        RelatorioCaixas tela = new RelatorioCaixas(null, true);

        tela.desabilitarEdicao();

        tela.setVisible(true);

    }//GEN-LAST:event_GerenciamentoCaixaMouseClicked

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AbrirFecharCaixa;
    private javax.swing.JLabel GerenciamentoCaixa;
    private ifsplife.dev.swing.PanelBorderGradient JButtonCaixa;
    private ifsplife.dev.swing.PanelBorderGradient JButtonMovimentacaoCaixa;
    private ifsplife.dev.swing.PanelBorderGradient JButtonMovimentacaoCaixa1;
    private javax.swing.JFormattedTextField JFormattedTextFieldCompras;
    private javax.swing.JFormattedTextField JFormattedTextFieldSangria;
    private javax.swing.JFormattedTextField JFormattedTextFieldSuplementacao;
    private javax.swing.JFormattedTextField JFormattedTextFieldValorInicial;
    private javax.swing.JFormattedTextField JFormattedTextFieldValorTotal;
    private javax.swing.JFormattedTextField JFormattedTextFieldVendas;
    private javax.swing.JLabel JLabelMovimentacao;
    private javax.swing.JScrollPane JScrollPaneMovimentacao;
    private com.toedter.calendar.JDateChooser JTextFieldDataDeAbertura;
    private javax.swing.JTextField JTextFieldHorarioDeAbertura;
    private javax.swing.JLabel MovimentacaoCaixa;
    private javax.swing.JLabel caixaStatus;
    private javax.swing.JLabel jLabelDataDeAbertura;
    private javax.swing.JLabel jLabelDeatalhesDoCaixa;
    private javax.swing.JLabel jLabelHorarioDeAbertura;
    private javax.swing.JLabel jLabelRSInicial;
    private javax.swing.JLabel jLabelRSSangria;
    private javax.swing.JLabel jLabelRSSangria1;
    private javax.swing.JLabel jLabelRSSuplementacao;
    private javax.swing.JLabel jLabelRSSuplementacao1;
    private javax.swing.JLabel jLabelRSTotal;
    private javax.swing.JLabel jLabelValorInicial;
    private javax.swing.JLabel jLabelValorSangria;
    private javax.swing.JLabel jLabelValorSangria1;
    private javax.swing.JLabel jLabelValorSuplementacao;
    private javax.swing.JLabel jLabelValorSuplementacao1;
    private javax.swing.JLabel jLabelValorTotal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparatorDataDeAbertura;
    private javax.swing.JSeparator jSeparatorHorarioDeAbertura;
    private javax.swing.JSeparator jSeparatorSangria;
    private javax.swing.JSeparator jSeparatorSangria1;
    private javax.swing.JSeparator jSeparatorSuplementacao;
    private javax.swing.JSeparator jSeparatorSuplementacao1;
    private javax.swing.JSeparator jSeparatorValorInicial;
    private javax.swing.JSeparator jSeparatorValorTotal;
    private ifsplife.dev.swing.PanelBorder panelBorderDetalhesCaixa;
    private ifsplife.dev.swing.PanelBorder panelBorderTela;
    private ifsplife.dev.swing.Table tableMovimentacoes;
    // End of variables declaration//GEN-END:variables
}
