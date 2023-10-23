package codingTest.baekjoon.탐욕알고리즘_greedyAlgorithm.로프_2217;

// 시간제한: 2초 -> 2억 연산 이내, 메모리제한: 192mb
/* 입력: (1): 로프개수, n, 1<= n <= 100,000
        (2~): 각 로프가 버틸 수 있는 최대중량, arr[n], arr[n] < 10,000인 자연수
* */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 로프개수
        int[] w = new int[n]; // 최대 중량들
        for(int i = 0; i < n; i++){
            w[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(w); // 오름 차순 정렬
        int max = w[n-1]; // 최대값

        // 10, 15, 20, 25
        // 10, 15, 1000 -> 1000
        for(int i = 0; i < n; i++){
            /* i가 0일 때 -> w[0] * n ,
                   1 -> w[1] * (n-1)
                   2 -> w[2] * (n-2)
                  n-1 -> w[n-1] * (n-(n-1)) */
           max = Math.max(max, w[i]*(n-i));
        }
        System.out.println(max);
    }
}
