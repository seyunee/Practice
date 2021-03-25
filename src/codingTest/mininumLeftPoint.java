package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class mininumLeftPointSolution {
    static List<String> mininumLeftPointSolution(List<List<String>> arr) {
        List<String> result = new ArrayList<>();
        HashMap<String,Integer> leftPoint = new HashMap<>();
        for (List<String> billing : arr) {
            int point = Integer.parseInt(billing.get(2));

            if(leftPoint.containsKey(billing.get(0))){
                int originPoint = leftPoint.get(billing.get(0));
                leftPoint.put(billing.get(0),originPoint-point);
            }else{
                leftPoint.put(billing.get(0),point*-1);
            }

            if(leftPoint.containsKey(billing.get(1))){
                int originPoint = leftPoint.get(billing.get(1));
                leftPoint.put(billing.get(1),originPoint+point);
            }else{
                leftPoint.put(billing.get(1),point);
            }

        }

        List<Map.Entry<String, Integer>> entries =
                leftPoint.entrySet().stream()
                        .sorted(Map.Entry.comparingByKey()).sorted(Map.Entry.comparingByValue())
                        .collect(Collectors.toList());
        for (Map.Entry<String, Integer> entry : entries) {
            if(entry.getValue() < 0){
                System.out.print("Key"+entry.getKey()+"   Value : "+entry.getValue());
                result.add(entry.getKey());
            }
        }

        if(result.size()==0){
            result.add("None");
        }

        return result;

    }
}
public class mininumLeftPoint {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int arrRows = Integer.parseInt(bufferedReader.readLine().trim());
        int arrColums = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> arr = new ArrayList<>();

        IntStream.range(0, arrRows).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });


        List<String> result = mininumLeftPointSolution.mininumLeftPointSolution(arr);
        System.out.println(result);

        bufferedReader.close();
    }
}
