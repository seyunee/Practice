package dataStructure.sort;

import java.util.Arrays;
import java.util.Collections;

public class twoArraysSort {
    public static void main(String[] args) {
        int n = 5;
        int k = 3;
        Integer[] arr1 = {1,2,5,4,3};
        Integer[] arr2 = {5,5,6,6,5};

        Arrays.sort(arr1);
        Arrays.sort(arr2, Collections.reverseOrder());

        for(int i=0;i<k;i++){
            if(arr1[i]<arr2[i]){
                int tmp = arr1[i];
                arr1[i] = arr2[i];
                arr2[i] = tmp;
            }else{
                break;
            }
        }

        int total = 0;
        for(int i=0;i<arr1.length;i++){
            total += arr1[i];
        }

        System.out.println(total);
    }

}
