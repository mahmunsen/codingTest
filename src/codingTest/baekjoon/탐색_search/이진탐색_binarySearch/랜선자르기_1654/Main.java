package codingTest.baekjoon.탐색_search.이진탐색_binarySearch.랜선자르기_1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 2초 -> 약 2억 연산 내로 문제 풀어야.
    // 1 <= k <= 10,000, 1 <= n <= 1,000,000, k <= n, n2 연산 불가
    // 각 랜선 길이 <= 2^31 -1, 2^31 은 약 20억

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken()); // 이미 가지고 있는 랜선 수
        int n = Integer.parseInt(st.nextToken()); // 필요한 랜선 수
        int[] lines = new int[k]; // 이미 가지고 있는 랜선들
        int max = 0; // 자를 수 있는 최대 길이

        for (int i = 0; i < k; i++){
            lines[i] = Integer.parseInt(br.readLine());
            max = Math.min(lines[i], lines[i]);
        }

        // todo 밑부분 디버깅
        double low = 0;  // 자를 수 있는 최소 길이
        double high = max; // 자를 수 있는 최대 길이
        while(low <= high){
            double mid = Math.floor((low + high) / 2);  // 중앙값, 소숫점 버림
            int sum = 0;  // 길이의 합계
            for (int line : lines){
                sum += line / mid;
            }
            if (sum <= n){
                high = mid - 1;
            } else if (sum > n){
                low = mid + 1;
            }
        }
        System.out.println(high);
    }
}
