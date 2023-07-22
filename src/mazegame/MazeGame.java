
package mazegame;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class MazeGame 
{

   
    public static void main(String[] args) throws LineUnavailableException, UnsupportedAudioFileException, IOException 
    {
        AnaPencere anapencere = new AnaPencere();
        anapencere.setVisible(true);//görülebilirlik
        
        //Burada oyuna müzik ekledik
        File file = new File("img/atarises.wav");
        AudioInputStream audiostream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audiostream); 
        clip.start();
    }
    
}
