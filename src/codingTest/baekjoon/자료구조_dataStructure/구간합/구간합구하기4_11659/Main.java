package codingTest.baekjoon.자료구조_dataStructure.구간합.구간합구하기4_11659;

// 1초
// 문제: 수 N개가 주어졌을 때, i번째 수부터 j번째 수까지 합을 구하는 프로그램을 작성
// 입력: (1): 첫째 줄에 수의 개수 N과 합을 구해야 하는 횟수 M
//      (2): 둘째 줄에는 N개의 수, n<= 1000, 자연수
//      (3): 셋째 줄부터 M개의 줄에는 합을 구해야 하는 구간 i와 j
// 출력: 총 M개의 줄에 입력으로 주어진 i번째 수부터 j번째 수까지 합을 출력

/* 1 ≤ N ≤ 100,000
   1 ≤ M ≤ 100,000
   1 ≤ i ≤ j ≤ N
* */
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] s = new long[n+1]; // 합배열 생성
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){  // 합배열 구하기
            s[i] = s[i-1] +  Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int o = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            System.out.println(s[t] - s[o-1]); // s[j] - s[i-1]
        }
    }
}
