package beakJoon.coding;

import java.util.ArrayList;
import java.util.Collections;

public class stringResort {
    public static void main (String[] args){
        String str = "AJKDLSI412K4JSJ9D";
        ArrayList<Character> onlyStr = new ArrayList<>();
        int number = 0;

        for(int i=0;i<str.length();i++){
            if(Character.isLetter(str.charAt(i))){
                onlyStr.add(str.charAt(i));
            }else{
                number+=str.charAt(i)-'0';
            }
        }

        Collections.sort(onlyStr);
        for(Character only : onlyStr){
            System.out.print(only);
        }
        System.out.println(number);
    }
}
