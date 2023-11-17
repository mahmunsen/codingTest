package codingTest.baekjoon.동적계획법_dp.타일링_11726;
/*
* 2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오
* 입력: 첫째 줄에 n이 주어진다. (1 ≤ n ≤ 1,000)
* 출력: 첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.
* */

import java.io.*;
import java.util.*;
public class Main {
    static int[] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 2*n에서 n
        // n-1 일때 경우의 수를 안다고 가정하고 d[n-1]에서 d[n]이 될 때 경우의 수 생각해보기
        // 점화식 세우기: d[n] = d[n-1] + d[n-2]
        // d<= 1000;

        // 초기화
        d = new int[1001];
        d[1] = 1; // 2*1
        d[2] = 2; // 2*2
        for(int i=3; i<=n; i++){
            d[i] = (d[i-1] + d[i-2]) % 10007;
        }
        System.out.println(d[n]);
    }
}
