package hackerRank;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Stream;

public class encryption_1 {
    // Complete the encryption function below.
    static String encryption(String s) {
        //String s = "haveaniceday";
        int l = s.length();

        int col = (int)Math.sqrt(l);

        if(Math.pow(col, 2) != l) {
            col += 1;
        }

        System.out.println(col);
        System.out.println("-----------");

        List<String> list = new ArrayList<String>();
        String tmp = "";
        boolean remain = false;
        for(int i=0; i<l; i++) {
            remain = true;
            tmp += Character.toString(s.charAt(i));
            if((i+1) % col == 0) {
                list.add(tmp);
                tmp = "";
                remain = false;
            }
        }

        if(remain) {
            list.add(tmp);
        }

        System.out.println("-----------");
        for(int i=0; i<list.size(); i++) {
            System.out.println(list.get(i).toString());
        }


        String enc = "";
        String result = "";
        for(int j=0; j<col; j++) {
            for(int i=0; i<list.size(); i++) {
                String nonenc = list.get(i);
                if(nonenc.length() > j) {
                    enc += nonenc.charAt(j);
                }
            }
            result = result + enc + " ";
            enc = "";
        }
        System.out.println(result);
        return result;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String s = scanner.nextLine();

        String result = encryption(s);
        System.out.print(result);
        scanner.close();
    }
}
