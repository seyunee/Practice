package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class pageItem {
    private String name;
    private int relation;
    private int cost;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRelation() {
        return relation;
    }

    public void setRelation(int relation) {
        this.relation = relation;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}

class kakaoPagingSolution {
    static List<String> kakaoPagingSolution(List<List<String>> items,int orderBy, int orderDirection, int pageSize, int pageNumber) {
        List<String> result = new ArrayList<>();
        List<pageItem> pageResult = new ArrayList<>();
        for(List<String> item : items){
            pageItem pageItem = new pageItem();
            pageItem.setName(item.get(0));
            pageItem.setRelation(Integer.parseInt(item.get(1)));
            pageItem.setCost(Integer.parseInt(item.get(2)));
            pageResult.add(pageItem);
        }

        if(orderDirection==0){
            if(orderBy == 0){
                pageResult= pageResult.stream().sorted((o1, o2) -> o1.getName().compareTo(o2.getName())).collect(Collectors.toList());
            }else if(orderBy == 1){
                pageResult=pageResult.stream().sorted(Comparator.comparing((pageItem::getRelation))).collect(Collectors.toList());
            }else{
                pageResult=pageResult.stream().sorted(Comparator.comparing((pageItem::getCost))).collect(Collectors.toList());
            }
        }else{
            if(orderBy == 0){
                pageResult=pageResult.stream().sorted((o1, o2) -> o2.getName().compareTo(o1.getName())).collect(Collectors.toList());
            }else if(orderBy == 1){
                pageResult=pageResult.stream().sorted(Comparator.comparing((pageItem::getRelation)).reversed()).collect(Collectors.toList());
            }else{
                pageResult=pageResult.stream().sorted(Comparator.comparing((pageItem::getCost)).reversed()).collect(Collectors.toList());
            }
        }

        for(int i =0 ;i<pageSize;i++){
            if(pageResult.size()>(pageSize*pageNumber)+i){
                result.add(pageResult.get((pageSize*pageNumber)+i).getName());
            }
        }


        return result;
    }
}
public class kakaoPaging {

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
        int orderBy = Integer.parseInt(bufferedReader.readLine().trim());
        int orderDirection = Integer.parseInt(bufferedReader.readLine().trim());
        int pageSize = Integer.parseInt(bufferedReader.readLine().trim());
        int pageNumber = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> result = kakaoPagingSolution.kakaoPagingSolution(arr,orderBy,orderDirection,pageSize,pageNumber);
        System.out.println(result);

        bufferedReader.close();
    }
}