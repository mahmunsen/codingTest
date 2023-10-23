package codingTest.baekjoon.탐욕알고리즘_greedyAlgorithm.거스름돈_5585;
// 시간제한: 1초, 메모리제한: 128 mb
// 문제: 1000엔 지폐를 내고 받을 최소 잔돈의 개수를 구하기, 잔돈으로 500, 100, 50, 5, 1
// 입력: (1) n, 타로가 내야할 돈, 1 <= n < 1,000, 정수
// 출력: 최소로 받을 잔돈의 개수

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
public class Main {
    /** 1번 */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 타로가 내야할 돈 받기
        int[] arr = {500, 100, 50, 10, 5, 1};
        int pay = 1000; // 타로가 낼 돈
        int change = pay - n; // 잔돈
        int cnt = 0; // 최소로 받을 잔돈의 개수
        // 가장 큰 수를 사용해서 나눠야 잔돈의 개수가 최소로 나옴
        for(int i = 0; i < arr.length; i++){
//            if(change/arr[i] > 0){      //  if(arr[i] < change) 왜 이렇게 하면 틀리다고 할까..?
                cnt += change / arr[i];   // 몫 620/500, 1+1
                change = change % arr[i]; // 나머지 120
//            }
        }
        System.out.println(cnt);
    }

    /** 2번 */
//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = 1000 - Integer.parseInt(br.readLine()); // 잔돈
//        int[] arr = {500, 100, 50, 10, 5, 1};
//        int cnt = 0; // 최소로 받을 잔돈의 개수
//        // 가장 큰 수를 사용해서 나눠야 잔돈의 개수가 최소로 나옴
//        for(int i : arr){
//            cnt += n / i;
//            n %= i; // 나눌 잔돈 업데이트 해줘야한다. n = n % i;
//        }
//        System.out.println(cnt);
//    }
}
