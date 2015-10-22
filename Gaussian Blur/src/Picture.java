import java.awt.image.BufferedImage;

/**
 * The Picture class wraps a BufferedImage providing methods that allow for
 * access to individual pixel component values as well as selected methods from
 * the BufferedImage class. Do NOT modify this file!
 * 
 * @author Neil Allison, nalliso@purdue.edu
 *
 */
public class Picture {
	/**
	 * Image supplied by the user.
	 */
	BufferedImage image;

	/**
	 * Constructor
	 * 
	 * @param image
	 *            The image supplied by the user to modify
	 */
	public Picture(BufferedImage image) {
		this.image = image;
	}

	/**
	 * Isolates the magnitude of the red component of a pixel at coordinates (x,
	 * y) from the image provided to the constructor. May throw an
	 * ArrayOutOfBoundsException if the given coordinates are not within the
	 * bounds of the image.
	 * 
	 * @param x
	 *            The x-coordinate of the pixel
	 * @param y
	 *            The y-coordinate of the pixel
	 * 
	 * @return the magnitude of the pixel's red component
	 */
	public int getPixelRedValue(int x, int y) {
		return (image.getRGB(x, y) >> 16) & 0x0FF;
	}

	/**
	 * Isolates the magnitude of the green component of a pixel at coordinates
	 * (x, y) from the image provided to the constructor. May throw an
	 * ArrayOutOfBoundsException if the given coordinates are not within the
	 * bounds of the image.
	 * 
	 * @param x
	 *            The x-coordinate of the pixel
	 * @param y
	 *            The y-coordinate of the pixel
	 * 
	 * @return the magnitude of the pixel's green component
	 */
	public int getPixelGreenValue(int x, int y) {
		return (image.getRGB(x, y) >> 8) & 0x0FF;
	}

	/**
	 * Isolates the magnitude of the blue component of a pixel at coordinates
	 * (x, y) from the image provided to the constructor. May throw an
	 * ArrayOutOfBoundsException if the given coordinates are not within the
	 * bounds of the image.
	 * 
	 * @param x
	 *            The x-coordinate of the pixel
	 * @param y
	 *            The y-coordinate of the pixel
	 * 
	 * @return the magnitude of the pixel's blue component
	 */
	public int getPixelBlueValue(int x, int y) {
		return image.getRGB(x, y) & 0x0FF;
	}

	/**
	 * Gets the height of the image measured in pixels.
	 * 
	 * @return The height of the image in pixels.
	 */
	public int getHeight() {
		return this.image.getHeight();
	}

	/**
	 * Gets the width of the image measured in pixels.
	 * 
	 * @return The width of the image in pixels.
	 */
	public int getWidth() {
		return this.image.getWidth();
	}

	/**
	 * Sets the RGB value of a pixel at the given (x, y) coordinates to the
	 * given RGB value. May throw an ArrayOutOfBoundsException if the given
	 * coordinates are not within the bounds of the image.
	 * 
	 * @param x
	 *            The x-coordinate of the image
	 * @param y
	 *            The y-coordinate of the image
	 * @param rgb
	 *            The RGB value to set this pixel
	 */
	public void setRGB(int x, int y, int rgb) {
		image.setRGB(x, y, rgb);
	}

	/**
	 * Gets the image associated with this Picture class.
	 * 
	 * @return The resultant BufferedImage
	 */
	public BufferedImage getBufferedImage() {
		return this.image;
	}
}