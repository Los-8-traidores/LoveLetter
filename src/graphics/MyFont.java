package graphics;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

public class MyFont {
	private static String fontPath = "EnchantedLand.ttf";
	protected static Font myFont;
	
	public static Font createFont () {
		try {
			myFont = Font.createFont(Font.TRUETYPE_FONT, new File(fontPath)).deriveFont(20f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(fontPath)));
			
		} catch (IOException | FontFormatException e) {
			e.printStackTrace();
		}
		
		return myFont;
	}
	
	
	
}
