package dataStructure.sort;

public class QuickSort {
    private static void quickSort(int[] arr){
        quickSort(arr, 0, arr.length-1);
    }

    private static void quickSort(int[] arr, int start, int end){
        int part2 = partition(arr, start, end);
        if(start < part2-1){
            quickSort(arr, start, part2-1);
        }
        if(part2<end){
            quickSort(arr, part2, end);
        }
    }

    private static int partition(int[] arr, int start, int end){
        int pivot = arr[(start+end)/2];
        while (start<=end){
            while (arr[start] < pivot) start++;
            while (arr[end] > pivot) end--;
            if(start<=end){
                swap(arr, start, end);
                start++;
                end--;
            }
        }
        System.out.println("start== "+ start);
        System.out.println("arr[start]== "+ arr[start]);
        return start;
    }

    private static void swap(int[] arr, int start, int end){
        int tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
    }

    private static void printArray(int[] arr){
        for(int data : arr){
            System.out.print(data + ", ");
        }
        System.out.println();
    }

    public static void main (String[] args){
        int[] arr = {3,9,4,8,5,1,7,6,2,0};

        printArray(arr);
        quickSort(arr);
        printArray(arr);
    }
}
