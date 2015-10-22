import java.io.File;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class ImageFilterClient {
	public static void main(String[] args) {

		File f = new File("Noisy.jpg");
		LoadImage img = new LoadImage(f);
		BufferedImage originalImage = img.getOriginalImage();
		if (originalImage == null) {
			System.out.println("null");
		}
		// Create a new File object with the image file name as argument (i.e.
		// image.jpg)
		LoadImage img1 = new LoadImage(f);
		BufferedImage resultImage = img1.getOriginalImage();
		if (resultImage == null) {
			System.out.println("null");
		}
		GaussianBlur modifier = new GaussianBlur(resultImage);
		resultImage = modifier.applyFilter();

		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 2));

		ImageIcon originalImg = new ImageIcon(originalImage);
		ImageIcon resultImg = new ImageIcon(resultImage);

		JLabel firstImg = new JLabel(originalImg);
		JLabel secondImg = new JLabel(resultImg);

		panel.add(firstImg);
		panel.add(secondImg);
		frame.add(panel);
		frame.pack();
		frame.setTitle("Image Filter");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		// Create a new LoadImage object with the loaded File as an argument
		// Get the BufferedImage from the LoadImage object and save it in a
		// variable (originalImage)
		// This BufferedImage variable will represent the original, unchanged
		// image

		// Create another LoadImage object with the same File as an argument
		// Get the BufferedImage from the LoadImage object and save it in
		// another variable (resultImage)
		// This BufferedImage variable will be used with the GaussianBlur class

		// Using the resultImage, create a GaussianBlur object, call the
		// applyFilter() method,
		// and store the result back into resultImage

		// Create the GUI components

	}
}