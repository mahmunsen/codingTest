package codingTest.baekjoon.탐욕알고리즘_greedyAlgorithm.안테나_18310;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

// 시간제한: 1초, 메모리제한: 256 mb
// 문제: 집들 중에 안테나 한 개 설치, 안테나로부터 모든 집까지의 거리 총 합이 최소가 되야.
// 집이 있는 곳에서만 설치 가능
/* 입력: (1) 집의수, n, 자연수, 1 <= n <= 200,000
        (2) 집의 위치들, arr[i], 1 <= arr[i] < 100,000, 자연수
* */
// 출력: 안테나를 설치할 위치의 값 출력, 안테나를 설치할 위치 값이 여러개인 경우, 가장 작은 값 출력.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 집의 수
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {     // 위치값 받기
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 정렬해서 중앙에 안테나를 놓는 것이 최솟값을 뽑을 수 있음.
        Arrays.sort(arr); // [1, 5, 7, 9]

        if ((n % 2) == 0) { // 집의 개수가 짝수일 때, 예를 들어 [1, 2, 3, 4] 라면 2, 3이 중앙값들
            System.out.println(arr[(n / 2) - 1]); // 더 작은 수인 2를 출력
        } else {          // 집의 개수가 홀수일 때
            System.out.println(arr[n / 2]);
        }
    }
}
