package clases;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class SonidoMP3 {

    FileInputStream fis;
    BufferedInputStream bis;
    private Player music;
    private boolean detenido;
    private boolean pausa;
    private long pauseMusica;
    private long totalMusica;

    public SonidoMP3() {
        music = null;
        detenido = true;
        pausa = false;
        pauseMusica = 0;
        totalMusica = 0;
    }

    public long getDuracionMusica() {
        return totalMusica;
    }

    public boolean reproduciendo() {
        return !detenido;
    }

    public boolean pausado() {
        return pausa;
    }

    public boolean detenido() {
        return detenido;
    }

    public void reproducir(String direccion) {
        if (!reproduciendo()) {
            prepararCancion(direccion);
            sonar();
        } else {
            detener();
            prepararCancion(direccion);
            sonar();
        }
    }

    private void prepararCancion(String dir) {
        try {
            fis = new FileInputStream(dir);
            bis = new BufferedInputStream(fis);
            comprobarEstado();
            music = new Player(bis);
        } catch (FileNotFoundException | JavaLayerException e) {
            System.err.println("Hubo un error al buscar la cancion.");
        }
    }

    private void comprobarEstado() {
        try {
            if (!pausa) {
                totalMusica = fis.available();
                detenido = false;
            } else {
                fis.skip(totalMusica - pauseMusica);
                pausa = detenido = false;
            }
        } catch (Exception e) {
        }
    }

    private void sonar() {
        new Thread() {
            @Override
            public void run() {
                try {
                    music.play();
                    detener();
                } catch (Exception e) {
                    System.err.println("Hubo un error al intentar sonar la cancion.");
                }
            }
        }.start();
    }

    public void pausar() {
        if (reproduciendo()) {
            try {
                pauseMusica = fis.available();
                music.close();
                pausa = detenido = true;
            } catch (Exception e) {
            }
        }
    }

    public void detener() {
        if (reproduciendo()) {
            music.close();
            music = null;
            detenido = true;
            pauseMusica = totalMusica = 0;
        }
    }
}
