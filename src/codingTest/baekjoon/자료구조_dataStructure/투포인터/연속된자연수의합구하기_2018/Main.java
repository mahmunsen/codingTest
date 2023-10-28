package codingTest.baekjoon.자료구조_dataStructure.투포인터.연속된자연수의합구하기_2018;
// 2초
// 문제: 자연수 N은, 몇 개의 연속된 자연수의 합, 1 ≤ N ≤ 10,000,000, 이때, 사용하는 자연수는 N이하
// 15를 나타내는 방법은 15, 7+8, 4+5+6, 1+2+3+4+5의 4가지

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 정수 받기
        int cnt = 1; // n 자기자신
        int sum = 1;
        int start = 1;
        int end = 1;

        while(end!=n){ // 이미 cnt에서 n자기자신인 부분을 반영했기 때문에 end는 n전까지만
            if(sum == n){
                cnt++; end++; sum = sum + end; // end++됐으므로 sum에도 반영
            } else if(sum > n){
                sum = sum - start; // 합계에서 앞 인덱스 빼줌
                start++; // 앞 인덱스 +1
            } else {
                end++; sum = sum + end;
            }
        }
        System.out.println(cnt);
    }
}
