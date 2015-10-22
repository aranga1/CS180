import java.awt.image.BufferedImage;

public class GaussianBlur {
	// The mask used for the blur
	private int[][] mask = { { 1, 2, 1 }, { 2, 4, 2 }, { 1, 2, 1 } };

	// The Picture representation of the image supplied by the user
	private Picture image;

	// The resulting BufferedImage with Gaussian blur applied
	private BufferedImage resultImage;

	public GaussianBlur(BufferedImage image) {
		this.image = new Picture(image);
		resultImage = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
	}

	public int calcWeightedValueCenter(int x, int y) {
		int div = mask[0][0] + mask[0][1] + mask[0][2] + mask[1][0]
				+ mask[1][1] + mask[1][2] + mask[2][0] + mask[2][1]
				+ mask[2][2];
		int red = (image.getPixelRedValue(x - 1, y - 1) * mask[0][0]
				+ image.getPixelRedValue(x, y - 1) * mask[0][1]
				+ image.getPixelRedValue(x + 1, y - 1) * mask[0][2]
				+ image.getPixelRedValue(x - 1, y) * mask[1][0]
				+ image.getPixelRedValue(x, y) * mask[1][1]
				+ image.getPixelRedValue(x + 1, y) * mask[1][2]
				+ image.getPixelRedValue(x - 1, y + 1) * mask[2][0]
				+ image.getPixelRedValue(x, y + 1) * mask[2][1] + 
				image.getPixelRedValue(x + 1, y + 1) * mask[2][2])
				/ div;

		int green = (image.getPixelGreenValue(x - 1, y - 1) * mask[0][0]
				+ image.getPixelGreenValue(x, y - 1) * mask[0][1]
				+ image.getPixelGreenValue(x + 1, y - 1) * mask[0][2]
				+ image.getPixelGreenValue(x - 1, y) * mask[1][0]
				+ image.getPixelGreenValue(x, y) * mask[1][1]
				+ image.getPixelGreenValue(x + 1, y) * mask[1][2]
				+ image.getPixelGreenValue(x - 1, y + 1) * mask[2][0]
				+ image.getPixelGreenValue(x, y + 1) * mask[2][1] + 
				image.getPixelGreenValue(x + 1, y + 1) * mask[2][2])
				/ div;

		int blue = (image.getPixelBlueValue(x - 1, y - 1) * mask[0][0]
				+ image.getPixelBlueValue(x, y - 1) * mask[0][1]
				+ image.getPixelBlueValue(x + 1, y - 1) * mask[0][2]
				+ image.getPixelBlueValue(x - 1, y) * mask[1][0]
				+ image.getPixelBlueValue(x, y) * mask[1][1]
				+ image.getPixelBlueValue(x + 1, y) * mask[1][2]
				+ image.getPixelBlueValue(x - 1, y + 1) * mask[2][0]
				+ image.getPixelBlueValue(x, y + 1) * mask[2][1] + 
				image.getPixelBlueValue(x + 1, y + 1) * mask[2][2])
				/ div;

		int rgbValue = red * 65536 + green * 256 + blue;
		return rgbValue;
	}

	/**
	 * Mode 1: top left corner Mode 2: top right corner Mode 3: bottom right
	 * corner Mode 4: bottom left corner
	 */
	public int calcWeightedValueCorner(int x, int y, int mode) {

		switch (mode) {

			case 1: // top left corner
				int div = mask[1][1] + mask[1][2] + mask[2][1] + mask[2][2];
	
				int red = (image.getPixelRedValue(x, y) * mask[1][1]
						+ image.getPixelRedValue(x + 1, y) * mask[1][2]
						+ image.getPixelRedValue(x, y + 1) * mask[2][1] + 
						image.getPixelRedValue(x + 1, y + 1) * mask[2][2])
						/ div;
	
				int green = (image.getPixelGreenValue(x, y) * mask[1][1]
						+ image.getPixelGreenValue(x + 1, y) * mask[1][2]
						+ image.getPixelGreenValue(x, y + 1) * mask[2][1] + 
						image.getPixelGreenValue(x + 1, y + 1) * mask[2][2])
						/ div;
	
				int blue = (image.getPixelBlueValue(x, y) * mask[1][1]
						+ image.getPixelBlueValue(x + 1, y) * mask[1][2]
						+ image.getPixelBlueValue(x, y + 1) * mask[2][1] + 
						image.getPixelBlueValue(x + 1, y + 1) * mask[2][2])
						/ div;
	
				int rgbValue = red * 65536 + green * 256 + blue;
				return rgbValue;
	
			case 2: // top right corner
				div = mask[1][0] + mask[1][1] + mask[2][0] + mask[2][1];
	
				red = (image.getPixelRedValue(x - 1, y) * mask[1][0]
						+ image.getPixelRedValue(x, y) * mask[1][1]
						+ image.getPixelRedValue(x - 1, y + 1) * mask[2][0] + 
						image.getPixelRedValue(x, y + 1) * mask[2][1])
						/ div;
	
				green = (image.getPixelGreenValue(x - 1, y) * mask[1][0]
						+ image.getPixelGreenValue(x, y) * mask[1][1]
						+ image.getPixelGreenValue(x - 1, y + 1) * mask[2][0] + 
						image.getPixelGreenValue(x, y + 1) * mask[2][1])
						/ div;
	
				blue = (image.getPixelBlueValue(x - 1, y) * mask[1][0]
						+ image.getPixelBlueValue(x, y) * mask[1][1]
						+ image.getPixelBlueValue(x - 1, y + 1) * mask[2][0] + 
						image.getPixelBlueValue(x, y + 1) * mask[2][1])
						/ div;
	
				rgbValue = red * 65536 + green * 256 + blue;
				return rgbValue;

			case 3: // lower right corner
				div = mask[0][0] + mask[0][1] + mask[1][0] + mask[1][1];
	
				red = (image.getPixelRedValue(x - 1, y - 1) * mask[0][0]
						+ image.getPixelRedValue(x, y - 1) * mask[0][1]
						+ image.getPixelRedValue(x - 1, y) * mask[1][0] + 
						image.getPixelRedValue(x, y) * mask[1][1])
						/ div;
	
				green = (image.getPixelGreenValue(x - 1, y - 1) * mask[0][0]
						+ image.getPixelGreenValue(x, y - 1) * mask[0][1]
						+ image.getPixelGreenValue(x - 1, y) * mask[1][0] + 
						image.getPixelGreenValue(x, y) * mask[1][1])
						/ div;
	
				blue = (image.getPixelBlueValue(x - 1, y - 1) * mask[0][0]
						+ image.getPixelBlueValue(x, y - 1) * mask[0][1]
						+ image.getPixelBlueValue(x - 1, y) * mask[1][0] + 
						image.getPixelBlueValue(x, y) * mask[1][1])
						/ div;
	
				rgbValue = red * 65536 + green * 256 + blue;
				return rgbValue;
	
			case 4: // lower left corner
				div = mask[0][1] + mask[0][2] + mask[1][1] + mask[1][2];
	
				red = (image.getPixelRedValue(x, y - 1) * mask[0][1]
						+ image.getPixelRedValue(x + 1, y - 1) * mask[0][2]
						+ image.getPixelRedValue(x, y) * mask[1][1] + 
						image.getPixelRedValue(x + 1, y) * mask[1][2])
						/ div;
	
				green = (image.getPixelGreenValue(x, y - 1) * mask[0][1]
						+ image.getPixelGreenValue(x + 1, y - 1) * mask[0][2]
						+ image.getPixelGreenValue(x, y) * mask[1][1] + 
						image.getPixelGreenValue(x + 1, y) * mask[1][2])
						/ div;
	
				blue = (image.getPixelBlueValue(x, y - 1) * mask[0][1]
						+ image.getPixelBlueValue(x + 1, y - 1) * mask[0][2]
						+ image.getPixelBlueValue(x, y) * mask[1][1] + 
						image.getPixelBlueValue(x + 1, y) * mask[1][2])
						/ div;
	
				rgbValue = red * 65536 + green * 256 + blue;
				return rgbValue;
	
			default:
				return 0;
		}
	}

	/**
	 * Mode 1: top edge Mode 2: right edge Mode 3: bottom edge Mode 4: left edge
	 */
	public int calcWeightedValueEdge(int x, int y, int mode) {
		// TODO: implement this method
		int div;
		int red = 0;
		int green = 0;
		int blue = 0;
		
		switch (mode) {
			case 1: // No y-1, top edge
				div = mask[1][0] + mask[1][1] + mask[1][2] + mask[2][0]
						+ mask[2][1] + mask[2][2];
				red = (image.getPixelRedValue(x - 1, y) * mask[1][0]
						+ image.getPixelRedValue(x, y) * mask[1][1]
						+ image.getPixelRedValue(x + 1, y) * mask[1][2]
						+ image.getPixelRedValue(x - 1, y + 1) * mask[2][0]
						+ image.getPixelRedValue(x, y + 1) * mask[2][1] + 
						image.getPixelRedValue(x + 1, y + 1) * mask[2][2])
						/ div;
				green = (image.getPixelGreenValue(x - 1, y) * mask[1][0]
						+ image.getPixelGreenValue(x, y) * mask[1][1]
						+ image.getPixelGreenValue(x + 1, y) * mask[1][2]
						+ image.getPixelGreenValue(x - 1, y + 1) * mask[2][0]
						+ image.getPixelGreenValue(x, y + 1) * mask[2][1] + 
						image.getPixelGreenValue(x + 1, y + 1) * mask[2][2])
						/ div;
	
				blue = (image.getPixelBlueValue(x - 1, y) * mask[1][0]
						+ image.getPixelBlueValue(x, y) * mask[1][1]
						+ image.getPixelBlueValue(x + 1, y) * mask[1][2]
						+ image.getPixelBlueValue(x - 1, y + 1) * mask[2][0]
						+ image.getPixelBlueValue(x, y + 1) * mask[2][1] + 
						image.getPixelBlueValue(x + 1, y + 1) * mask[2][2])
						/ div;
				break;
	
			case 2: // No x+1, right edge
				div = mask[0][0] + mask[0][1] + mask[1][0] + mask[1][1]
						+ mask[2][0] + mask[2][1];
				red = (image.getPixelRedValue(x - 1, y - 1) * mask[0][0]
						+ image.getPixelRedValue(x, y - 1) * mask[0][1]
						+ image.getPixelRedValue(x - 1, y) * mask[1][0]
						+ image.getPixelRedValue(x, y) * mask[1][1]
						+ image.getPixelRedValue(x - 1, y + 1) * mask[2][0] + 
						image.getPixelRedValue(x, y + 1) * mask[2][1])
						/ div;
	
				green = (image.getPixelGreenValue(x - 1, y - 1) * mask[0][0]
						+ image.getPixelGreenValue(x, y - 1) * mask[0][1]
						+ image.getPixelGreenValue(x - 1, y) * mask[1][0]
						+ image.getPixelGreenValue(x, y) * mask[1][1]
						+ image.getPixelGreenValue(x - 1, y + 1) * mask[2][0] + 
						image.getPixelGreenValue(x, y + 1) * mask[2][1])
						/ div;
	
				blue = (image.getPixelBlueValue(x - 1, y - 1) * mask[0][0]
						+ image.getPixelBlueValue(x, y - 1) * mask[0][1]
						+ image.getPixelBlueValue(x - 1, y) * mask[1][0]
						+ image.getPixelBlueValue(x, y) * mask[1][1]
						+ image.getPixelBlueValue(x - 1, y + 1) * mask[2][0] + 
						image.getPixelBlueValue(x, y + 1) * mask[2][1])
						/ div;
				break;
	
			case 3: // No y+1, bottom edge
				div = mask[0][0] + mask[0][1] + mask[0][2] + mask[1][0]
						+ mask[1][1] + mask[1][2];
				red = (image.getPixelRedValue(x - 1, y - 1) * mask[0][0]
						+ image.getPixelRedValue(x, y - 1) * mask[0][1]
						+ image.getPixelRedValue(x + 1, y - 1) * mask[0][2]
						+ image.getPixelRedValue(x - 1, y) * mask[1][0]
						+ image.getPixelRedValue(x, y) * mask[1][1] + 
						image.getPixelRedValue(x + 1, y) * mask[1][2])
						/ div;
	
				green = (image.getPixelGreenValue(x - 1, y - 1) * mask[0][0]
						+ image.getPixelGreenValue(x, y - 1) * mask[0][1]
						+ image.getPixelGreenValue(x + 1, y - 1) * mask[0][2]
						+ image.getPixelGreenValue(x - 1, y) * mask[1][0]
						+ image.getPixelGreenValue(x, y) * mask[1][1] + 
						image.getPixelGreenValue(x + 1, y) * mask[1][2])
						/ div;
	
				blue = (image.getPixelBlueValue(x - 1, y - 1) * mask[0][0]
						+ image.getPixelBlueValue(x, y - 1) * mask[0][1]
						+ image.getPixelBlueValue(x + 1, y - 1) * mask[0][2]
						+ image.getPixelBlueValue(x - 1, y) * mask[1][0]
						+ image.getPixelBlueValue(x, y) * mask[1][1] + 
						image.getPixelBlueValue(x + 1, y) * mask[1][2])
						/ div;
				break;
	
			case 4: // No x-1, left edge
				div = mask[0][1] + mask[0][2] + mask[1][1] + mask[1][2]
						+ mask[2][1] + mask[2][2];
				red = (image.getPixelRedValue(x, y - 1) * mask[0][1]
						+ image.getPixelRedValue(x + 1, y - 1) * mask[0][2]
						+ image.getPixelRedValue(x, y) * mask[1][1]
						+ image.getPixelRedValue(x + 1, y) * mask[1][2]
						+ image.getPixelRedValue(x, y + 1) * mask[2][1] + 
						image.getPixelRedValue(x + 1, y + 1) * mask[2][2])
						/ div;
	
				green = (image.getPixelGreenValue(x, y - 1) * mask[0][1]
						+ image.getPixelGreenValue(x + 1, y - 1) * mask[0][2]
						+ image.getPixelGreenValue(x, y) * mask[1][1]
						+ image.getPixelGreenValue(x + 1, y) * mask[1][2]
						+ image.getPixelGreenValue(x, y + 1) * mask[2][1] + 
						image.getPixelGreenValue(x + 1, y + 1) * mask[2][2])
						/ div;
	
				blue = (image.getPixelBlueValue(x, y - 1) * mask[0][1]
						+ image.getPixelBlueValue(x + 1, y - 1) * mask[0][2]
						+ image.getPixelBlueValue(x, y) * mask[1][1]
						+ image.getPixelBlueValue(x + 1, y) * mask[1][2]
						+ image.getPixelBlueValue(x, y + 1) * mask[2][1] + 
						image.getPixelBlueValue(x + 1, y + 1) * mask[2][2])
						/ div;
				break;
	
		}
		int rgbValue = red * 65536 + green * 256 + blue;
		return rgbValue;
	}

	public BufferedImage applyFilter() {
		for (int i = 0; i < resultImage.getWidth(); i++) {
			for (int j = 0; j < resultImage.getHeight(); j++) {
				if (i == 0 && j == 0) {
					resultImage.setRGB(i, j, calcWeightedValueCorner(i, j, 1));
				} else if (i == 0 && j == resultImage.getHeight() - 1) {
					resultImage.setRGB(i, j, calcWeightedValueCorner(i, j, 4));
				} else if (j == 0 && i == resultImage.getWidth() - 1) {
					resultImage.setRGB(i, j, calcWeightedValueCorner(i, j, 2));
				} else if (i == resultImage.getWidth() - 1
						&& j == resultImage.getHeight() - 1) {
					resultImage.setRGB(i, j, calcWeightedValueCorner(i, j, 3));
				} else if (i == 0) {
					resultImage.setRGB(i, j, calcWeightedValueEdge(i, j, 4));
				} else if (j == 0) {
					resultImage.setRGB(i, j, calcWeightedValueEdge(i, j, 1));
				} else if (i == resultImage.getWidth() - 1) {
					resultImage.setRGB(i, j, calcWeightedValueEdge(i, j, 2));
				} else if (j == resultImage.getHeight() - 1) {
					resultImage.setRGB(i, j, calcWeightedValueEdge(i, j, 3));
				} else {
					resultImage.setRGB(i, j, calcWeightedValueCenter(i, j));
				}
			}
		}
		// TODO: implement this method
		// for (each row)
		// for (each column)
		// check where in the matrix we are
		// resultImage.setRGB(column, row, applyMask(column, row));
		return resultImage;
	}
}
