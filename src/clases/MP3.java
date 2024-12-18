package clases;

import java.net.URL;
import javax.media.Manager;
import javax.media.Player;
import javax.media.Time;

public class MP3 {

    private Player mediaPlayer;
    private URL url;
    private boolean detenido, pausa, repetir;

    public MP3() {
        mediaPlayer = null;
        detenido = true;
        pausa = repetir = false;
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
    
    public boolean repetir() {
        return repetir;
    }
    
    public void setRepetir(boolean t) {
        this.repetir = t;
    }

    public boolean termino() {
        return mediaPlayer.getMediaTime().getSeconds() == mediaPlayer.getDuration().getSeconds();
    }

    public Player mediaPlayer() {
        return mediaPlayer;
    }

    public URL getDireccion() {
        return url;
    }

    private String tiempo(int min, int seg) {
        if (min < 10) {
            if (seg < 10) {
                return "0" + min + ":0" + seg;
            }
            return "0" + min + ":" + seg;
        } else {
            if (seg < 10) {
                return min + ":0" + seg;
            }
            return min + ":" + seg;
        }
    }

    public String getTiempoActual() {
        int min = (int) (mediaPlayer.getMediaTime().getSeconds() / 60);
        int seg = (int) (mediaPlayer.getMediaTime().getSeconds() - (min * 60));
        return tiempo(min, seg);
    }

    public String getDuracion() {
        int min = (int) (mediaPlayer.getDuration().getSeconds() / 60);
        int seg = (int) (mediaPlayer.getDuration().getSeconds() - (min * 60));
        return tiempo(min, seg);
    }

    public void guardarDireccion(URL url) {
        try {
            mediaPlayer = Manager.createRealizedPlayer(this.url = url);
        } catch (Exception e) {
            System.err.println("Archivo incompatible.");
        }
    }

    public void reproducir() {
        if (reproduciendo()) {
            detener();
        }
        mediaPlayer.start();
        detenido = pausa = false;
    }

    public void pausar() {
        if (reproduciendo()) {
            mediaPlayer.stop();
            detenido = pausa = true;
        }
    }

    public void detener() {
        if (reproduciendo() || pausado()) {
            mediaPlayer.stop();
            guardarDireccion(url);
            detenido = true;
            pausa = false;
            System.out.println("Se detuvo");
        }
    }
    
    public void asignarTiempo(double tiempo) {
        mediaPlayer.setMediaTime(new Time(tiempo));
    }
}
