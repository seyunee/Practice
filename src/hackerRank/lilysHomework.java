package hackerRank;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class lilysHomework {
    // Complete the lilysHomework function below.
    static int lilysHomework(int[] arr) {
        // arr을 오름차순 또는 내림차순의 형태로 만들어야 한다.
        // 그때가 문제에서 말한 cost가 가장 적은 경우기 때문에,
        // 이때 문제는, arr을 오름차순으로 만드는데 필요한 swap횟수와
        // arr을 내림차순으로 만드는데 필요한 swap횟수가 다르다.
        // 따라서 오름차순 및 내림차순 두 방법 모두 시행하고 그 중 작은 값을 반환한다.

        int answer_asc = 0;
        int answer_desc = 0;
        int idx,temp;
        int arr_length = arr.length;
        // 기존 arr은 오름차순에서 사용될 것
        // 내림차순에서 사용될 arr_desc을 만들고 기존 arr을 복사해서 넣는다.
        int[] arr_desc = new int[arr_length];
        System.arraycopy( arr, 0, arr_desc, 0, arr_length );

        // 오름차순으로 정렬된 sorted_arr
        int[] sorted_arr = new int[arr_length];
        System.arraycopy( arr, 0, sorted_arr, 0, arr_length );
        Arrays.sort(sorted_arr);

        // 내림차순으로 정렬된 reversed_arr
        int[] reversed_arr = new int[arr_length];
        for(int i=0;i<arr_length;i++){
            reversed_arr[i] = -1 * arr[i];
        }
        Arrays.sort(reversed_arr);
        for(int i = 0; i < arr_length; i++){
            reversed_arr[i] *= -1;
        }

        // 오름차순을 위한 hash map
        HashMap<Integer, Integer> idxMap_asc = new HashMap();
        for(int i=0;i<arr_length;i++){
            idxMap_asc.put(arr[i],i);
        }

        // 내림차순을 위한 hash map
        HashMap<Integer, Integer> idxMap_desc = new HashMap();
        for(int i=0;i<arr_length;i++){
            idxMap_desc.put(arr_desc[i],i);
        }

        // 오름차순을 통한 cost 계산
        for(int i=0;i<arr_length;i++){
            if(sorted_arr[i] != arr[i]){
                idx = idxMap_asc.get(sorted_arr[i]);
                idxMap_asc.put(arr[i],idx);
                temp = arr[i];
                arr[i] = sorted_arr[i];
                arr[idx] = temp;
                answer_asc++;
            }
        }

        // 내림차순을 통한 cost 계산
        for(int i=0;i<arr_length;i++){
            if(reversed_arr[i] != arr_desc[i]){
                idx = idxMap_desc.get(reversed_arr[i]);
                idxMap_desc.put(arr_desc[i],idx);
                temp = arr_desc[i];
                arr_desc[i] = reversed_arr[i];
                arr_desc[idx] = temp;
                answer_desc++;
            }
        }

        // 더 작은값을 반환한다.
        return answer_asc > answer_desc ? answer_desc : answer_asc;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = lilysHomework(arr);
        System.out.print(result);
        scanner.close();
    }
}
