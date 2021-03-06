package lab14;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Stats {
	public static HashMap<String, Integer> wins(File f) {
		HashMap<String, Integer> map = new HashMap<>();
		try {
			BufferedReader bf = new BufferedReader(new FileReader(f));
			 
			while (bf.readLine() != null) {
				String line = bf.readLine();
				String[] conts = line.split(" ");
				if (conts[0].equals("0")) {
					for (int i = 7; i < conts.length; i++) {
						if (map.get(conts[i]) == null) {
							map.put(conts[i], 1);
						}
						int oldValue = map.get(conts[i]);
						map.replace(conts[i], oldValue, ++oldValue);
					}
				}
				if (conts[0].equals("1")) {
					for (int i = 1; i < 6; i++) {
						if (map.get(conts[i]) == null) {
							map.put(conts[i], 1);
						}
						int oldValue = map.get(conts[i]);
						map.replace(conts[i], oldValue, ++oldValue);
					}
				}
			}
			bf.close();
			return map;
		} catch (Exception e) {
			System.out.println("Exception occured, idk why bro");
		}
		return map;
	}
	public static String winner(HashMap<String, Integer> map) {
		String winner = null;
		int wins = 0;
		for (String key: map.keySet()) {
			if (wins < map.get(key)) {
				wins = map.get(key);
				winner = key;
			}
		}
		return winner;
	}
	public static void main(String args[]) {
		File f = new File("input.txt");
		System.out.println(winner(wins(f)));
	}
}
