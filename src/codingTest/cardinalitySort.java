package codingTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Item implements Comparable<Item> {

    private int decimal;
    private String binaryString;
    private int binarySum;

    public Item(int decimal,String binaryString,  int binarySum) {
        this.decimal = decimal;
        this.binaryString = binaryString;
        this.binarySum = binarySum;
    }

    public Integer getDecimal() {
        return this.decimal;
    }

    // 정렬 기준은 '점수가 낮은 순서'
    @Override
    public int compareTo(Item other) {
        if (this.binarySum < other.binarySum) {
            return -1;
        }
        return 1;
    }
}


public class cardinalitySort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N, M을 공백을 기준으로 구분하여 입력 받기
        int n = sc.nextInt();
        ArrayList<Item> nums = new ArrayList<Item>();

        // 2차원 리스트의 맵 정보 입력 받기
        for (int i = 0; i < n; i++) {
            int decimal = sc.nextInt();
            String binaryString = Integer.toBinaryString(decimal);
            int binarySum = 0;
            for(int j = 0; j < binaryString.length(); j++) {
                binarySum+= binaryString.charAt(j) - '0';
            }
            nums.add( new Item(decimal, binaryString, binarySum));
        }

        Collections.sort(nums);

        for(int i=0 ; i<nums.size();i++){
            System.out.println(nums.get(i).getDecimal() + " " );
        }

    }
}
