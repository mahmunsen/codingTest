package codingTest.baekjoon.조합_combination.이항계수2_11051;


import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 초기화
        int[][] d = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            d[i][0] = 1;
            d[i][1] = i;
            d[i][i] = 1;
            for(int j=1; j<i; j++){
                d[i][j] = (d[i-1][j-1] + d[i-1][j])%10007;
            }
        }
        System.out.println(d[n][k]);
    }
}
