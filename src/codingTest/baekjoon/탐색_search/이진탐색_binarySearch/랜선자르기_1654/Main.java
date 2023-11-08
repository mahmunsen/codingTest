package codingTest.baekjoon.탐색_search.이진탐색_binarySearch.랜선자르기_1654;
// 2초 -> 약 2억 연산 내로 문제 풀어야.
// 1 <= k <= 10,000, 1 <= n <= 1,000,000, k <= n, n2 연산 불가
// 각 랜선 길이 <= 2^31 -1, 2^31 은 약 20억

import java.util.*;
import java.io.*;
public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] l = new int[k];
        long max = 0;
        for(int i = 0; i < k; i++){
            l[i] = Integer.parseInt(br.readLine());
            if(l[i] > max){
                max = l[i];
            }
        }

        long low = 1;  // 길이가 자연수라 0이면 안된다.
        long high = max;
        long mid = 0;  // long타입은 소숫점 무시한다.
        while(low <= high){
            mid = (low + high) / 2;
            long sum = 0;
            for(int i=0; i<k; i++){
                sum += l[i]/mid;
            }
            if (sum >= n){
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        System.out.println((low+high)/2);
    }
}