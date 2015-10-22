public class StrRev {
    public String revString(String str) {
        String temp = "";
        String words = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 32) {
                words += temp + " ";
                temp = "";
            }
            else {
                temp = str.charAt(i) + temp;
            }
        }
        words += temp;
        return words;
    }
    
    public static void main(String args[]) {
        StrRev s = new StrRev();
        String n = "This is me";
        System.out.println(s.revString(n));
    }
}
    