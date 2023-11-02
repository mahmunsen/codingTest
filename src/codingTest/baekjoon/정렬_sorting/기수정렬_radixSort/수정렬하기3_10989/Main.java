package codingTest.baekjoon.정렬_sorting.기수정렬_radixSort.수정렬하기3_10989;
/*
1. 시간제한: 5초
2. 문제:
N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성
3. 입력:
(1): 수의 개수 N(1 ≤ N ≤ 10,000,000)
(2~n): 수<=10,000, 자연수
4. 출력:
첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력
*/

///** 카운팅 정렬(counting sort) */
//
//import java.io.*;
//import java.util.*;
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        // 수의 범위 (0 ~ 10000) 사실상 0은 제외
//        int[] cnt = new int[10001];
//        for(int i=0; i<n; i++){
//            // 해당 인덱스의 값을 1 증가
//            cnt[Integer.parseInt(br.readLine())]++;
//        }
//        br.close();
//        StringBuilder sb= new StringBuilder();
//
//        // 0은 입력 범위 밖에 있으므로 제외
//        for(int i=1; i<10001; i++) { // b[1], b[2] .... b[7]
//                                     //  2,    2,
//            while(cnt[i] > 0){       // cnt[2], 2> 0
//                sb.append(i).append("\n"); // 1, 1, 2, 2 ...
//                cnt[i]--;
//            }
//        }
//        System.out.println(sb);
//    }
//}

/** 기수 정렬(radix sort) */

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] data = new int[n];
        for(int i=0; i<n; i++){
            data[i] = Integer.parseInt(br.readLine());
        }
        radixSort(data);
        for(int el:data) bw.write(el + "\n");
        bw.flush();
        bw.close();
    }
    public static void radixSort(int[] data){
        int max = data[0]; // 맥스값 중요 -> 최고값을 기준으로 횟수를 정할 수 있기 때문. 만약 최고값이 501이면 세 자리이므로 세 번의 계수정렬을 실시해야 함을 알 수 있다.
        for(int i:data) if(max<i) max =i; // 최고값
        for(int i=1; max/i>0; i*=10) countSort(data, i); // 1의 자리부터 최대 자릿수까지 반복하여 계수 정렬 수행
    }
    // 각 자리수에 대해 계수 정렬을 수행하는 함수
    public static void countSort(int[] data, int digit){ // digit=자릿수(1, 10, 100, 1000)
        int size = data.length;
        int[] temp = new int[size]; // 데이터의 위치를 옮겨야 정렬이 되기 때문에 temp필요
        int[] cnt = new int[10]; // 각 자리수의 빈도를 저장하는 배열
        for(int i=0; i<size; i++) cnt[(data[i]/digit)%10]++; // 각 자리수의 빈도를 저장.
        for(int i=1; i<10; i++) cnt[i] += cnt[i-1];   // temp의 인덱스: 계수를 누적합한 결과로 구함
        for(int i= size-1; i>=0; i--){  // 뒤에서부터 해야 결과 배열에 원소를 올바른 위치에 넣음
            int cntValue = (data[i]/digit)%10;
            int newIdx = cnt[cntValue]-1; // 숫자 10이라는 배열 번호 없음. 9까지 있으니 -1 해줘야 실제 인덱스가 나온다.
            temp[newIdx] = data[i];
            cnt[cntValue]--;
        }
        for(int i=0; i<size; i++) data[i] = temp[i];
    }
}

// 기수 정렬 참고: https://www.youtube.com/watch?v=j9SGZIbIhxM
