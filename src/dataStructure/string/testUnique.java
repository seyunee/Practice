package dataStructure.string;

public class testUnique {
    public static void main (String[] args){
        System.out.println(isUnique("aabcdddserfa"));
        System.out.println(isUnique("abcdefrgst"));
    }

    private static boolean isUnique(String str){
        int checker = 0;
        for (int i=0; i<str.length() ; i++){
            int val = str.charAt(i) - 'a';
            if((checker & (1 << val)) > 0){
                return false;
            }
            checker |= (1 << val);
        }
        return true;

    }
}
