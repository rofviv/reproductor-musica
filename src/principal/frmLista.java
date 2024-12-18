package principal;

import com.sun.awt.AWTUtilities;
import java.awt.Cursor;
import java.awt.Dimension;
import static java.awt.Frame.MOVE_CURSOR;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class frmLista extends javax.swing.JDialog {

    DefaultListModel<String> mLista = new DefaultListModel<>();
    DefaultListModel<URL> mLista2 = new DefaultListModel<>();
    frmMusica frmM;
    JFileChooser archivos = new JFileChooser("D:\\Mis documentos\\Musica");
    private int x, y;
    int musicaSeleccionada = 0;

    public frmLista(frmMusica parent, boolean modal) {
        super(parent, modal);
        frmM = parent;
        this.setUndecorated(true);
        initComponents();
        diseñoForm();
    }

    @SuppressWarnings("unchecked")
    public void introducirLista(String titulo) {
        mLista.addElement(titulo);
        lstLista.setModel(mLista);
    }

    public void introducirDireccion(URL dir) {
        mLista2.addElement(dir);
        lstDireccion.setModel(mLista2);
    }

    public void posicion(int x, int y) {
        this.setLocation(x + 321, y);
    }

    public boolean enLista(String titulo) {
        return mLista.contains(titulo);
    }
    
    public void siguienteMusica() {
        System.out.println("Desde el metodo: " + musicaSeleccionada);
        musicaSeleccionada++;
    }
    

    private void diseñoForm() {
        this.setSize(new Dimension(155, 280));
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 30, 30);
        AWTUtilities.setWindowShape(this, forma);
        this.setIconImage(new ImageIcon(getClass().getResource("/imagenes/saxofon.png")).getImage());
        try {            
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");            
            SwingUtilities.updateComponentTreeUI(this);
        }
        catch(Exception erro) {
           
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        lstDireccion = new javax.swing.JList();
        pnlFondoLst1 = new clases.pnlFondoLst();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstLista = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        btnAñadir = new javax.swing.JButton();
        btnQuitar = new javax.swing.JButton();

        jScrollPane2.setViewportView(lstDireccion);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(153, 102, 0));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });

        lstLista.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        lstLista.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        lstLista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstListaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lstLista);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 51));
        jLabel1.setText("Reproductor RR");

        btnAñadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/añadir.png"))); // NOI18N
        btnAñadir.setToolTipText("Añadir");
        btnAñadir.setBorder(null);
        btnAñadir.setBorderPainted(false);
        btnAñadir.setContentAreaFilled(false);
        btnAñadir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAñadir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/añadir2.png"))); // NOI18N
        btnAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirActionPerformed(evt);
            }
        });

        btnQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/delete2.png"))); // NOI18N
        btnQuitar.setToolTipText("Quitar");
        btnQuitar.setBorder(null);
        btnQuitar.setBorderPainted(false);
        btnQuitar.setContentAreaFilled(false);
        btnQuitar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnQuitar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/delete.png"))); // NOI18N
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFondoLst1Layout = new javax.swing.GroupLayout(pnlFondoLst1);
        pnlFondoLst1.setLayout(pnlFondoLst1Layout);
        pnlFondoLst1Layout.setHorizontalGroup(
            pnlFondoLst1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLst1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLst1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFondoLst1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(pnlFondoLst1Layout.createSequentialGroup()
                        .addComponent(btnAñadir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnQuitar)))
                .addContainerGap())
        );
        pnlFondoLst1Layout.setVerticalGroup(
            pnlFondoLst1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLst1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlFondoLst1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAñadir, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondoLst1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondoLst1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lstListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstListaMouseClicked
        try {
            if (lstLista.getSelectedValue() != null) {
                if (evt.getClickCount() == 2) {
                    lstDireccion.setSelectedIndex(lstLista.getSelectedIndex());
                    musicaSeleccionada = lstLista.getSelectedIndex();
                    frmM.sonarCancion(new URL(lstDireccion.getSelectedValue().toString()));
                    frmM.setTitulo(lstLista.getSelectedValue().toString());
                }
            }
        } catch (MalformedURLException ex) {
            System.out.println("Aqui");
        }
    }//GEN-LAST:event_lstListaMouseClicked

    private void btnAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirActionPerformed
        int opcion = archivos.showOpenDialog(this);
        if (opcion == JFileChooser.APPROVE_OPTION) {
            if (!enLista(archivos.getSelectedFile().getName())) {
                try {
                    introducirLista(archivos.getSelectedFile().getName());
                    introducirDireccion(archivos.getSelectedFile().toURL());
                } catch (MalformedURLException ex) {
                    System.err.println("Error al insertar en la lista.");
                }
            }
        }
    }//GEN-LAST:event_btnAñadirActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        if (lstLista.getSelectedValue() != null) {
            mLista2.removeElementAt(lstLista.getSelectedIndex());
            mLista.removeElementAt(lstLista.getSelectedIndex());
            lstLista.setModel(mLista);
            lstDireccion.setModel(mLista2);
        }
    }//GEN-LAST:event_btnQuitarActionPerformed

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        Point point = MouseInfo.getPointerInfo().getLocation();
        this.setLocation(point.x - x, point.y - y);
        setCursor(new Cursor(MOVE_CURSOR));
    }//GEN-LAST:event_formMouseDragged

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_formMouseReleased

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                frmLista dialog = new frmLista((frmMusica) new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAñadir;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList lstDireccion;
    public javax.swing.JList lstLista;
    private clases.pnlFondoLst pnlFondoLst1;
    // End of variables declaration//GEN-END:variables
}
