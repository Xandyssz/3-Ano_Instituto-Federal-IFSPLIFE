package ifsplife.jdialog;

public class PesquisaItens extends javax.swing.JDialog {

    public PesquisaItens(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorderGradient1 = new ifsplife.dev.swing.PanelBorderGradient();
        panelBorder1 = new ifsplife.dev.swing.PanelBorder();
        JLabelCRUD = new javax.swing.JLabel();
        JSeparatorCRUD = new javax.swing.JSeparator();
        JButtonCadastrar = new ifsplife.dev.swing.PanelBorderGradient();
        JLabelSelecionar = new javax.swing.JLabel();
        JButtonCancelar = new ifsplife.dev.swing.PanelBorderGradient();
        JLabelCancelar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        panelBorder1.setBackground(new java.awt.Color(239, 239, 239));
        panelBorder1.setPreferredSize(new java.awt.Dimension(411, 317));

        JLabelCRUD.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        JLabelCRUD.setForeground(new java.awt.Color(0, 78, 146));
        JLabelCRUD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLabelCRUD.setText("Pesquisa de Item");

        JButtonCadastrar.setFirstColor(new java.awt.Color(153, 153, 153));
        JButtonCadastrar.setPreferredSize(new java.awt.Dimension(90, 22));

        JLabelSelecionar.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        JLabelSelecionar.setForeground(new java.awt.Color(255, 255, 255));
        JLabelSelecionar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLabelSelecionar.setText("Selecionar");

        javax.swing.GroupLayout JButtonCadastrarLayout = new javax.swing.GroupLayout(JButtonCadastrar);
        JButtonCadastrar.setLayout(JButtonCadastrarLayout);
        JButtonCadastrarLayout.setHorizontalGroup(
            JButtonCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JLabelSelecionar, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
        );
        JButtonCadastrarLayout.setVerticalGroup(
            JButtonCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JLabelSelecionar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        JButtonCancelar.setFirstColor(new java.awt.Color(153, 153, 153));
        JButtonCancelar.setPreferredSize(new java.awt.Dimension(90, 22));
        JButtonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JButtonCancelarMouseClicked(evt);
            }
        });

        JLabelCancelar.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        JLabelCancelar.setForeground(new java.awt.Color(255, 255, 255));
        JLabelCancelar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLabelCancelar.setText("Cancelar");

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

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JSeparatorCRUD, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JLabelCRUD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addContainerGap(604, Short.MAX_VALUE)
                .addComponent(JButtonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(JLabelCRUD, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JSeparatorCRUD, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 420, Short.MAX_VALUE)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JButtonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout panelBorderGradient1Layout = new javax.swing.GroupLayout(panelBorderGradient1);
        panelBorderGradient1.setLayout(panelBorderGradient1Layout);
        panelBorderGradient1Layout.setHorizontalGroup(
            panelBorderGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorderGradient1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, 863, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelBorderGradient1Layout.setVerticalGroup(
            panelBorderGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorderGradient1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
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

    private void JButtonCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JButtonCancelarMouseClicked
       this.dispose();
    }//GEN-LAST:event_JButtonCancelarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ifsplife.dev.swing.PanelBorderGradient JButtonCadastrar;
    private ifsplife.dev.swing.PanelBorderGradient JButtonCancelar;
    private javax.swing.JLabel JLabelCRUD;
    private javax.swing.JLabel JLabelCancelar;
    private javax.swing.JLabel JLabelSelecionar;
    private javax.swing.JSeparator JSeparatorCRUD;
    private ifsplife.dev.swing.PanelBorder panelBorder1;
    private ifsplife.dev.swing.PanelBorderGradient panelBorderGradient1;
    // End of variables declaration//GEN-END:variables
}
