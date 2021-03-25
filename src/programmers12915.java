import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class programmers12915 {
    //메소드 시작
    public void main(String[] args)
    {
        String[] strings = {"abce", "abcd", "cdx"};
        int n=2;
        String[] result = solution(strings,n);
    }

    public String[] solution(String[] strings, int n) {
        String[] answer = {};

        List<Map<String, String>> sort = new ArrayList<>();
        for(String string : strings){
            Map<String, String> mapString = Map.of(string,string.substring(n,n+1));
            sort.add(mapString);
        }

        sort.stream().sorted().forEach(System.out::println);
        return answer;
    }
}
