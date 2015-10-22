import java.io.*;
import java.util.Scanner;

public class FileSum {
	public static double sumFile(String filename) {
		double sum = 0;
		if (filename == null) {
			return 0;
		}
		File f = new File(filename);
		try {
			Scanner s = new Scanner(f);
			while (s.hasNext()) {
				if (s.hasNextDouble()) {
					sum += s.nextDouble();
					continue;
				}
				Object o = s.next();
				continue;
			}
			s.close();
			return sum;
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			return 0;
		}
	}

	public static void main(String[] args) {
		System.out.println(sumFile("example.txt"));
	}
}
