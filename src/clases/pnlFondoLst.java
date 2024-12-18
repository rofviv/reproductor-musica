package clases;

import java.awt.Graphics;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class pnlFondoLst extends javax.swing.JPanel {

    ImageIcon marco;

    public pnlFondoLst() {
        initComponents();
    }

    @Override
    public void paintComponent(Graphics g) {
        if (marco == null) {
            marco = new ImageIcon(getClass().getResource("/imagenes/fondo7.jpg"));
        }
        g.drawImage(marco.getImage(), 0, 0, 155, 280, null);
        setOpaque(false);
        super.paintComponent(g);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
