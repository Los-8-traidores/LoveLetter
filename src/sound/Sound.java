package sound;

import java.io.File;

import javax.print.DocFlavor.INPUT_STREAM;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.JOptionPane;

public class Sound {
	Clip clip;
	
	public Sound (String filePath) throws Exception{
		AudioInputStream audioInput = AudioSystem.getAudioInputStream(new File(filePath));
		clip = AudioSystem.getClip();
		clip.open(audioInput);
	}
	
	
	public void play () {
		clip.stop();
		clip.flush();
		clip.setMicrosecondPosition(0);
		synchronized (this) {
			clip.start();
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		}
	}
	
	public void stop () {
		clip.stop();
	}
//	public void setVolume(float volume) {
//		if (volume < 0f || volume > 1f)
//			throw new IllegalArgumentException("Volume not valid: " + volume);
//		FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
//		gainControl.setValue(20f * (float) Math.log10(volume));
//	}
	
}
