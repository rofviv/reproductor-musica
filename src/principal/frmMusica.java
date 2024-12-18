package principal;

import clases.MP3;
import com.sun.awt.AWTUtilities;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

@SuppressWarnings("serial")
public final class frmMusica extends javax.swing.JFrame implements Runnable {

    MP3 musica = new MP3();
    frmLista frmLista;
    JFileChooser archivos = new JFileChooser("D:\\Mis documentos\\Musica");
    FileFilter extension = new FileNameExtensionFilter("MP3 Files", "mp3", "mpeg3");
    URL direccion = null;
    private int x;
    private int y;
    Thread sonar;

    @Override
    public void run() {
        try {
            while (musica.reproduciendo()) {
                lblTiempo.setVisible(true);
                if (musica.termino()) {
                    if (musica.repetir()) {
                        musica.detener();
                        musica.reproducir();
                    } else if (frmLista.musicaSeleccionada + 1 < frmLista.mLista.getSize()) {
                        musica.detener();
                        frmLista.siguienteMusica();
                        System.out.println(frmLista.musicaSeleccionada);
                        sonarCancion(frmLista.mLista2.getElementAt(frmLista.musicaSeleccionada));
                        setTitulo(frmLista.mLista.getElementAt(frmLista.musicaSeleccionada));
                        frmLista.lstLista.setSelectedIndex(frmLista.musicaSeleccionada);
                        System.out.println(frmLista.musicaSeleccionada + "  -- - ");                        
                    } else {
                        lblEstado.setText("Detenido.");
                        musica.detener();
                        sonar.stop();
                    }
                } else {
                    lblTiempo.setText(musica.getTiempoActual() + "/" + musica.getDuracion());
                    pgrBarraProgreso.setValue(((int) musica.mediaPlayer().getMediaTime().getSeconds() * 100)
                            / (int) musica.mediaPlayer().getDuration().getSeconds());
                }
                Thread.sleep(20);
            }
            while (musica.pausado()) {
                lblTiempo.setVisible(true);
                Thread.sleep(983);
                lblTiempo.setVisible(false);
                Thread.sleep(983);
            }
        } catch (InterruptedException ex) {
        }
    }

    private void diseñoForm() {
        this.setSize(new Dimension(320, 170));
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 30, 30);
        AWTUtilities.setWindowShape(this, forma);
        this.setIconImage(new ImageIcon(getClass().getResource("/imagenes/saxofon.png")).getImage());
    }

    public void reproducir() {
        musica.reproducir();
        lblEstado.setText("En reproducción...");
        sonar = new Thread(this);
        sonar.start();
    }

    public void detener() {
        musica.detener();
        lblEstado.setText("Detenido.");
        lblTiempo.setText("00:00/" + musica.getDuracion());
        pgrBarraProgreso.setValue(0);
    }

    public void setTitulo(String titulo) {
        lblNombre.setText(titulo);
    }

    public void sonarCancion(URL dir) {
        if (musica.reproduciendo() || pgrBarraProgreso.getValue() != 0) {
            detener();
            musica.guardarDireccion(dir);
            reproducir();
        } else {
            musica.guardarDireccion(dir);
            reproducir();
        }
        lblTiempo.setText("00:00/" + musica.getDuracion());

    }

    public frmMusica() {
        this.setUndecorated(true);
        initComponents();
        diseñoForm();
        frmLista = new frmLista(this, false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFondo1 = new clases.pnlFondo();
        btnLista = new javax.swing.JButton();
        btnExaminar = new javax.swing.JButton();
        btnPlay = new javax.swing.JButton();
        btnPause = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        btnRepetir = new javax.swing.JButton();
        btnMinimizar = new javax.swing.JButton();
        lblNombre = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblTiempo = new javax.swing.JLabel();
        pgrBarraProgreso = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Reproductor MP3");
        setUndecorated(true);
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

        pnlFondo1.setPreferredSize(new java.awt.Dimension(320, 170));
        pnlFondo1.setLayout(null);

        btnLista.setBackground(new java.awt.Color(255, 204, 0));
        btnLista.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        btnLista.setForeground(new java.awt.Color(255, 204, 0));
        btnLista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lista2.png"))); // NOI18N
        btnLista.setText(">>");
        btnLista.setToolTipText("Lista");
        btnLista.setBorder(null);
        btnLista.setBorderPainted(false);
        btnLista.setContentAreaFilled(false);
        btnLista.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLista.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnLista.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLista.setIconTextGap(-3);
        btnLista.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lista.png"))); // NOI18N
        btnLista.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnListaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnListaMouseExited(evt);
            }
        });
        btnLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaActionPerformed(evt);
            }
        });
        pnlFondo1.add(btnLista);
        btnLista.setBounds(289, 80, 20, 30);

        btnExaminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.png"))); // NOI18N
        btnExaminar.setToolTipText("Examinar");
        btnExaminar.setBorder(null);
        btnExaminar.setBorderPainted(false);
        btnExaminar.setContentAreaFilled(false);
        btnExaminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExaminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExaminar.setIconTextGap(-3);
        btnExaminar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar1.png"))); // NOI18N
        btnExaminar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnExaminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnExaminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExaminarActionPerformed(evt);
            }
        });
        pnlFondo1.add(btnExaminar);
        btnExaminar.setBounds(230, 10, 22, 22);

        btnPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/play1.png"))); // NOI18N
        btnPlay.setToolTipText("Reproducir");
        btnPlay.setBorder(null);
        btnPlay.setBorderPainted(false);
        btnPlay.setContentAreaFilled(false);
        btnPlay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPlay.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPlay.setIconTextGap(-3);
        btnPlay.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/play.png"))); // NOI18N
        btnPlay.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnPlay.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });
        pnlFondo1.add(btnPlay);
        btnPlay.setBounds(137, 131, 33, 33);

        btnPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pause1.png"))); // NOI18N
        btnPause.setToolTipText("Pausar");
        btnPause.setBorder(null);
        btnPause.setBorderPainted(false);
        btnPause.setContentAreaFilled(false);
        btnPause.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPause.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPause.setIconTextGap(-3);
        btnPause.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pause.png"))); // NOI18N
        btnPause.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnPause.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPauseActionPerformed(evt);
            }
        });
        pnlFondo1.add(btnPause);
        btnPause.setBounds(175, 131, 33, 33);

        btnStop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/stop1.png"))); // NOI18N
        btnStop.setToolTipText("Detener");
        btnStop.setBorder(null);
        btnStop.setBorderPainted(false);
        btnStop.setContentAreaFilled(false);
        btnStop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnStop.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnStop.setIconTextGap(-3);
        btnStop.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/stop.png"))); // NOI18N
        btnStop.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnStop.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });
        pnlFondo1.add(btnStop);
        btnStop.setBounds(100, 131, 33, 33);

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cerrar.png"))); // NOI18N
        btnCerrar.setToolTipText("Cerrar");
        btnCerrar.setBorder(null);
        btnCerrar.setBorderPainted(false);
        btnCerrar.setContentAreaFilled(false);
        btnCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCerrar.setIconTextGap(-3);
        btnCerrar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cerrar1.png"))); // NOI18N
        btnCerrar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnCerrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        pnlFondo1.add(btnCerrar);
        btnCerrar.setBounds(289, 0, 30, 30);

        btnRepetir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/notRepetir.png"))); // NOI18N
        btnRepetir.setToolTipText("Repetir");
        btnRepetir.setBorder(null);
        btnRepetir.setBorderPainted(false);
        btnRepetir.setContentAreaFilled(false);
        btnRepetir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRepetir.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnRepetir.setIconTextGap(-3);
        btnRepetir.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnRepetir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRepetir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRepetirActionPerformed(evt);
            }
        });
        pnlFondo1.add(btnRepetir);
        btnRepetir.setBounds(10, 40, 20, 20);

        btnMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/minimizar.png"))); // NOI18N
        btnMinimizar.setToolTipText("Minimizar");
        btnMinimizar.setBorder(null);
        btnMinimizar.setBorderPainted(false);
        btnMinimizar.setContentAreaFilled(false);
        btnMinimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMinimizar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnMinimizar.setIconTextGap(-3);
        btnMinimizar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/minimizar1.png"))); // NOI18N
        btnMinimizar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnMinimizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMinimizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinimizarActionPerformed(evt);
            }
        });
        pnlFondo1.add(btnMinimizar);
        btnMinimizar.setBounds(292, 30, 24, 24);

        lblNombre.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setText("Examinar...");
        lblNombre.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        pnlFondo1.add(lblNombre);
        lblNombre.setBounds(10, 11, 210, 20);

        lblEstado.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        lblEstado.setForeground(new java.awt.Color(255, 255, 255));
        pnlFondo1.add(lblEstado);
        lblEstado.setBounds(10, 140, 80, 20);
        pnlFondo1.add(jSeparator1);
        jSeparator1.setBounds(10, 30, 210, 10);

        lblTiempo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTiempo.setForeground(new java.awt.Color(255, 255, 255));
        lblTiempo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTiempo.setText("00:00/00:00");
        pnlFondo1.add(lblTiempo);
        lblTiempo.setBounds(232, 130, 70, 14);

        pgrBarraProgreso.setForeground(new java.awt.Color(204, 102, 0));
        pgrBarraProgreso.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pgrBarraProgreso.setPreferredSize(new java.awt.Dimension(100, 14));
        pgrBarraProgreso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pgrBarraProgresoMouseClicked(evt);
            }
        });
        pnlFondo1.add(pgrBarraProgreso);
        pgrBarraProgreso.setBounds(215, 150, 100, 8);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlFondo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo1, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExaminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExaminarActionPerformed
//        archivos.setFileFilter(extension);
        int opcion = archivos.showOpenDialog(this);
        if (opcion == JFileChooser.APPROVE_OPTION) {
            try {
                sonarCancion(archivos.getSelectedFile().toURL());
                setTitulo(archivos.getSelectedFile().getName());
                frmLista.introducirLista(archivos.getSelectedFile().getName());
                frmLista.introducirDireccion(archivos.getSelectedFile().toURL());
                System.out.println(archivos.getSelectedFile().toURL());
                System.out.println(archivos.getSelectedFile());
            } catch (MalformedURLException ex) {
                System.err.println("Mala reproducción.");
            }
        }
    }//GEN-LAST:event_btnExaminarActionPerformed

    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed
        if (musica.getDireccion() != null) {
            reproducir();
        }
    }//GEN-LAST:event_btnPlayActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnMinimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizarActionPerformed
        setExtendedState(ICONIFIED);
    }//GEN-LAST:event_btnMinimizarActionPerformed

    private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopActionPerformed
        if (musica.reproduciendo() || musica.pausado()) {
            detener();
        }
    }//GEN-LAST:event_btnStopActionPerformed

    private void btnPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPauseActionPerformed
        if (musica.reproduciendo()) {
            musica.pausar();
            lblEstado.setText("Pausado.");
        }
    }//GEN-LAST:event_btnPauseActionPerformed

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        Point point = MouseInfo.getPointerInfo().getLocation();
        this.setLocation(point.x - x, point.y - y);
        setCursor(new Cursor(MOVE_CURSOR));
    }//GEN-LAST:event_formMouseDragged

    private void btnRepetirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRepetirActionPerformed
        if (musica.repetir()) {
            musica.setRepetir(false);
            btnRepetir.setIcon(new ImageIcon(getClass().getResource("/imagenes/notRepetir.png")));
        } else {
            musica.setRepetir(true);
            btnRepetir.setIcon(new ImageIcon(getClass().getResource("/imagenes/repetir.png")));
        }
    }//GEN-LAST:event_btnRepetirActionPerformed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        setCursor(new Cursor(DEFAULT_CURSOR));
    }//GEN-LAST:event_formMouseReleased

    private void btnListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaActionPerformed
        if (!frmLista.isVisible()) {
            frmLista.posicion(getX(), getY());
            frmLista.setVisible(true);
            btnLista.setText("<<");
        } else {
            frmLista.dispose();
            btnLista.setText(">>");
        }
    }//GEN-LAST:event_btnListaActionPerformed

    private void btnListaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnListaMouseEntered
        btnLista.setForeground(new Color(255, 250, 0));
    }//GEN-LAST:event_btnListaMouseEntered

    private void btnListaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnListaMouseExited
        btnLista.setForeground(new Color(255, 204, 0));
    }//GEN-LAST:event_btnListaMouseExited

    private void pgrBarraProgresoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pgrBarraProgresoMouseClicked
        if (musica.reproduciendo()) {
            pgrBarraProgreso.setValue(pgrBarraProgreso.getMousePosition().x);
            musica.asignarTiempo((pgrBarraProgreso.getValue() * musica.mediaPlayer().getDuration().getSeconds()) / 100);
        }
    }//GEN-LAST:event_pgrBarraProgresoMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new frmMusica().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnExaminar;
    private javax.swing.JButton btnLista;
    private javax.swing.JButton btnMinimizar;
    private javax.swing.JButton btnPause;
    private javax.swing.JButton btnPlay;
    private javax.swing.JButton btnRepetir;
    private javax.swing.JButton btnStop;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTiempo;
    private javax.swing.JProgressBar pgrBarraProgreso;
    private clases.pnlFondo pnlFondo1;
    // End of variables declaration//GEN-END:variables
}
