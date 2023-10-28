package codingTest.baekjoon.자료구조_dataStructure.투포인터.주몽_1940;
// 2초
// 두 개의 고유한 재료로 갑옷 만듬, M(1 ≤ M ≤ 10,000,000), N(1 ≤ N ≤ 15,000)
// 입력: (1): 재료의 개수 N(1 ≤ N ≤ 15,000)
//      (2): 갑옷을 만드는데 필요한 수 M(1 ≤ M ≤ 10,000,000)
//      (3): N개의 재료들이 가진 고유한 번호들이 공백을 사이에 두고 주어진다, 100,000보다 작거나 같은 자연수

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 재료 개수
        int m = Integer.parseInt(br.readLine()); // 갑옷을 만드는데 필요한 수
        int[] a = new int[n];
        int cnt = 0;
        int start = 0; // 시작 인덱스
        int end = n-1; // 끝 인덱스
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
           a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a); // 오름차순 정렬, [1,2,3,4,5,7]
        while(start<end) {
            if (a[start] + a[end] < m) {
                start++;
            } else if (a[start] + a[end] > m) {
                end--;
            } else {
                cnt++;
                start++;
                end--;
            }
        }
        System.out.println(cnt);
    }
}
