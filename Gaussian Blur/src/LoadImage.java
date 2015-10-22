import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class LoadImage {
	private BufferedImage image;

	public LoadImage(File f) {
		try {
			this.image = ImageIO.read(f);
		} catch (IllegalArgumentException e) {
			System.out.println("this isn't an image");
		} catch (IOException e) {
			System.out.println("IO exception");
		}

	}

	public BufferedImage getOriginalImage() {
		return image;
	}

}
