package codingTest.baekjoon.동적계획법_dp.정수를1로만들기_1463;

/*
* 시간제한: 0.15 초
* X가 3으로 나누어 떨어지면, 3으로 나눈다.
* X가 2로 나누어 떨어지면, 2로 나눈다.
* 1을 뺀다.
*
* 문제: 정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.
* 입력: 1<= N<= 10^6, 정수
* 출력: 첫째 줄에 연산을 하는 횟수의 최솟값을 출력
* */

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] d = new int[n+1];
        d[1] = 0;
        for(int i=2; i<=n; i++){
            d[i] = d[i-1]+1;
            if(i%2 == 0) d[i] = Math.min(d[i],d[i/2]+1);
            if(i%3 == 0) d[i] = Math.min(d[i],d[i/3]+1);
        }
        bw.write(String.valueOf(d[n]));
        bw.flush();
    }
}
