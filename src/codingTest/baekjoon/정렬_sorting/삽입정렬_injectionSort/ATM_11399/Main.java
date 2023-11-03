package codingTest.baekjoon.정렬_sorting.삽입정렬_injectionSort.ATM_11399;
/*
1. 시간제한: 1초
2. 문제:
줄을 서 있는 사람의 수 N과 각 사람이 돈을 인출하는데 걸리는 시간 Pi가 주어졌을 때, 각 사람이 돈을 인출하는데 필요한 시간의 합의 최솟값을 구하는 프로그램
3. 입력:
(1): 사람의 수 N(1 ≤ N ≤ 1,000)
(2): 각 사람이 돈을 인출하는데 걸리는 시간 Pi,(1 ≤ Pi ≤ 1,000)
4. 출력:
(1): 각 사람이 돈을 인출하는데 필요한 시간의 합의 최솟값을 출력
*/

/** 1. Arrays.sort() */

//import java.io.*;
//import java.util.*;
//public class Main {
//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine()); // 사람의 수
//        int[] a = new int[n];
//        // [3,1,4,3,2] -> [1,2,3,3,4] (정렬) -> 1+(1+2)+(1+2+3)... (구간합)
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        for(int i=0; i<n; i++){
//            a[i] = Integer.parseInt(st.nextToken());
//        }
//        Arrays.sort(a);
//        int sum = 0;
//        int prev = 0;
//        for(int i=0; i<n; i++){
//            sum += prev + a[i];  // 이전 대기시간 누적합 + 사람마다 현재 걸리는 시간
//            prev += a[i];        // 이전 대기시간 누적합
//        }
//        System.out.println(sum);
//    }
//}

/** 2. Counting sort */

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 사람의 수
        int[] a = new int[1001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(n-- >0){
            a[Integer.parseInt(st.nextToken())]++; // 3이면 a[3]에 +1, 또 3이 들어오면 a[3]은 2
        }
        int prev = 0;
        int sum = 0;
        for(int i=0; i<1001; i++){

            // 해당 i index가 0이 될 때 까지 반복
            while(a[i]-- >0){ // a[1] = 1, a[2] = 1, a[3] = 2, a[4] = 1
                sum += (i+prev);

                prev += i;
            }
        }
        System.out.println(sum);
    }
}
