package codingTest.baekjoon.탐색_search.이진탐색_binarySearch.나무자르기_2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 1초, 1 ≤ n ≤ 1,000,000, 1 ≤ m ≤ 2,000,000,000, h(나무의 높이)는 1,000,000,000보다 작거나 같은 양의 정수 또는 0이
    // 절단기 <- 높이 h 지정해야
    // (1) 나무의 수: n개, 가져가는 나무의 길이: m
    // (2) 나무의 높이들 [a, b, c, d..]
    // 적어도 m 미터를 가져가기 위해 절단기에 설정할 수 있는 높이들의 최댓값 [1, 2, 3, 4...] 중에 max
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 나무들의 갯수
        int[] trees = new int[n];
        int m = Integer.parseInt(st.nextToken()); // 상근이가 가져가는 나무의 총 길이
        int max = 0;


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken()); // 나무들
            max = Math.max(max, trees[i]);
        }

        // 절단기 높이 [a, b, c, d]
        // 나무 높이 [low .... mid ..... high] <-
        long low = 0; // 절단기 높이
        long high = max;
        while (low <= high) {
            long mid = (low + high) / 2; // 절단기 높이 중앙값
            long sum = 0;
            for (int tree : trees) {
                if (tree > mid) { // 나무들이 절단기 높이 중앙값보다 크면
                    sum += tree - mid; // 총계
                }
            }
            if (sum >= m) {  // 총계가 가져갈 나무의 총 길이보다 높으면
                low = mid + 1; // 절단기 높이를 높여야 한다.
            } else {
                high = mid - 1;
            }
        }

        System.out.println(high);
    }
}