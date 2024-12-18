package principal;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Musica {

    public static void main(String[] args) {
        try {
            FileInputStream fis;
            Player player;
            fis = new FileInputStream("D:\\Mis documentos\\Musica\\Pendiente\\tumblr.com - Rio roma Tan solo un minuto.mp3");
            BufferedInputStream bis = new BufferedInputStream(fis);

            player = new Player(bis);
            player.play();
        } catch (JavaLayerException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
