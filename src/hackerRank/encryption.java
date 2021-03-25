package hackerRank;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Stream;

public class encryption {
    // Complete the encryption function below.
    static String encryption(String s) {
        String newstr = s.trim();
        String result = "";

        int rows = (int)Math.sqrt(newstr.length());
        int colums = rows+1;
        rows =(rows*colums)<newstr.length()?colums:rows;
        int length =0;
        while (length<colums){
            for(int i=length;i<newstr.length();i=i+colums){
                result+= s.charAt(i);
            }
            length++;
            result+=" ";
        }

        /*String[][] encypt = new String[rows][colums];
        int length =0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<colums;j++) {
                if(length<newstr.length())
                {
                    encypt[i][j]=newstr.substring(length,length+1);
                    length++;
                }
            }
        }

        for(int i=0;i<colums;i++){
            for(int j=0;j<rows;j++) {
                if(encypt[j][i]!=null){
                    result+=encypt[j][i];
                }
            }
            result+=" ";
        }*/

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
