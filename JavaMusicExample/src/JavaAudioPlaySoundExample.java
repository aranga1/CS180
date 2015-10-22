	import javax.sound.sampled.AudioInputStream;
	import javax.sound.sampled.AudioSystem;
	import javax.sound.sampled.Clip;
	import java.io.*;
	public class JavaAudioPlaySoundExample {
	    public static void main(String[] args) {
	    try{
	    	File f = new File("music.mp3");
	    	AudioInputStream as = AudioSystem.getAudioInputStream(f);
	        Clip clip = AudioSystem.getClip();
	        clip.open(as);
	        clip.start();
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();;
	    }
	    }
	}
