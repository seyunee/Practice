package beakJoon.coding;

public class night {
    public static void main (String[] args){
        String now = "c2";

        int[] movex = {-2,-2,-1,-1,1,1,2,2};
        int[] movey = {1,-1,2,-2,2,-2,1,-1};

        int nowx = now.charAt(0) - 'a'+1;
        int nowy = now.charAt(1) - '0';

        int result = 0;
        for(int i=0; i<8;i++){
            if(nowx + movex[i] > 0 && nowx + movex[i] <= 8 && nowy + movey[i] > 0 && nowy + movey[i] <= 8){
                result++;
            }
        }

        System.out.println("result= "+result);
    }
}
