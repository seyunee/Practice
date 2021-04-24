package codingTest.lotte;

public class zigzeg {
    static long solution(int n, int r, int c) {
        long[][] nMatrix = new long[n][n];
        int x = 0, y = 0;
        long count = 0;

        nMatrix[x][y] = count++;
        if(r-1==x && c-1==y) return count;
        if(r-1==n && c-1==n) return n*n;

        while(count < n * n) {
            if(y + 1 < n) {
                y++;
            } else {
                x++;
            }

            count++;
            if(r-1==x && c-1==y) return count;
            while(y - 1 > -1 && x + 1 < n) {
                ++x;
                --y;
                count++;
                if(r-1==x && c-1==y) return count;
            }

            if(x + 1 < n) {
                x++;
            } else {
                y++;
            }
            count++;
            if(r-1==x && c-1==y) return count;
            while(x - 1 > -1 && y + 1 < n) {
                --x;
                ++y;
                count++;
                if(r-1==x && c-1==y) return count;
            }
        }

        for(long[] xx : nMatrix) {
            for(long nn : xx) {
                System.out.printf("%d ", nn);
            } System.out.println();
        }


        return count;
    }

    public static void main(String[] agrs) {
        int n = 6;
        int r = 5;
        int c = 5;


        System.out.println(solution(n, r, c));

// 1 2 6 7 15
// 3 5 8 14 16
// 4 9 13 17 22
// 10 12 18 21 23
// 11 19 20 24 25
    }
}
