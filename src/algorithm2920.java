public class algorithm2920 {
    //메소드 시작
    public void main(String[] args)
    {
        int [] codes = {1, 2, 3, 4, 5, 6, 7, 8};
        int n=2;
        String result = solution(codes);
    }

    public String solution( int [] codes) {
        String answer = "ascending";

        for(int i=0;i<codes.length-1;i++){
            if((codes[i]<codes[i+1]) && answer.equals("ascending") ){
                answer ="ascending";
            }else if((codes[i]>codes[i+1]) && answer.equals("desending")){
                answer ="desending";
            }else{
                answer ="mixed";
            }

        }

        return answer;
    }
}
