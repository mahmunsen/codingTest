package codingTest.baekjoon.조합_combination.이항계수1_11050;

/*
* 이항계수: n개 중 k를 선택하는 조합의 수
*
*  */

import java.io.*;
import java.util.*;
public class Main {
    static int[][] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 총 개수
        int k = Integer.parseInt(st.nextToken()); // 선택수

        d = new int[n+1][n+1];

        for(int i=1; i<=n; i++){
            d[i][0] = 1; // n개 중 0개 선택하는 경우
            d[i][1] = i; // n개 중 1개 선택하는 경우
            d[i][i] = 1; // n개 중 n개 선택하는 경우
            for(int j=1; j<i; j++){ // j<i 이므로 j=2부터 시작
                d[i][j] = d[i-1][j-1] + d[i-1][j];
            }
        }
        System.out.println(d[n][k]);
    }
}
