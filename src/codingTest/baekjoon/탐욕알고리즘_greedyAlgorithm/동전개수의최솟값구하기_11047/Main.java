package codingTest.baekjoon.탐욕알고리즘_greedyAlgorithm.동전개수의최솟값구하기_11047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 시간 제한: 1초 -> 1억 연산 이내
    // 동전의 종류: n, 동전가치의 합, k, 이때 필요한 동전 개수의 최솟값 구하기 -> 최솟값 구하려면 큰 금액으로 구성해야
    /* 입력: (1): 1<= n <= 10, 1 <= k <= 100,000,000 (10억)
            (2): 둘째줄부터 n개 줄, 동전의 배열, arr[i]가 오름차순, (1 <= arr[i] <= 1,000,000, arr[0] = 1, arr[n-1]은 arr[n-2]의 배수
    * */
    // 출력: k원을 만드는 데 필요한 동전 개수의 최솟값 구하기
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 동전의 개수
        int k = Integer.parseInt(st.nextToken()); // 동전들 가치의 합
        int[] arr = new int[n]; // 동전들 배열, 빈배열 arr 생성
        int cnt = 0; // 최솟값
        for (int i = 0; i < arr.length; i++){ // arr 배열에 들어갈 수들 받기
            arr[i] = Integer.parseInt(br.readLine());
        }
        // 그리디 함수, 큰 수부터 사용하기
        for (int i = arr.length-1; i >= 0; i--){ // 큰 수부터 사용하기 위해 역순으로 탐색
            if (arr[i] < k){ // k 보다 작아야 나눌 수 있다, 100 < 200
               cnt += (k / arr[i]);  // 몫
               k = (k % arr[i]); // 동전들의 합인 k에 나머지로 업데이트
            }
        }
        System.out.println(cnt);
    }
}
