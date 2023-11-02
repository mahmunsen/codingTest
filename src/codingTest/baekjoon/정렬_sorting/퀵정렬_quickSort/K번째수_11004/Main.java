package codingTest.baekjoon.정렬_sorting.퀵정렬_quickSort.K번째수_11004;
/*
1. 시간제한: 2초 -> 2억 연산 이내
2. 문제:
수 N개 A1, A2, ..., AN이 주어진다.
A를 오름차순 정렬했을 때, 앞에서부터 K번째 있는 수를 구하는 프로그램을 작성하라.
3. 입력:
(1): N(1 ≤ N ≤ 5,000,000), K (1 ≤ K ≤ N)
(2): A1, A2, ..., AN, (-109 ≤ Ai ≤ 109)
4. 출력:
A를 정렬했을 때, 앞에서부터 K번째 있는 수를 출력
*/

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 수의 개수
        int k = Integer.parseInt(st.nextToken()); // k번
        int[] a = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        int srt = 0;
        int end = n-1;

        quickSort(a, srt, end);
        bw.write(String.valueOf(a[k-1])); // BufferedWriter 를 사용하려면 String 형으로 변환이 필요
        bw.flush();
        br.close();
        bw.close();
    }
    public static void quickSort(int[] a, int srt, int end){
        int part2 = partition(a, srt, end);  //파티션 나누고 오른쪽 값 첫번째 값을 받아옴
        if(srt<part2-1){ //왼쪽 파티션의 요소가 하나 이상
            quickSort(a, srt, part2-1);
        }
        if(part2<end){ //오른쪽 파티션의 요소가 하나 이상
            quickSort(a, part2, end);
        }
    }
    public static int partition(int[] a, int srt, int end){
        int pv = a[(srt+end)/2];
        while(srt<=end){
            while(a[srt]<pv) srt++;
            while(a[end]>pv) end--;
            if(srt<=end) {
                swap(a, srt, end);
                srt++;
                end--;
            }
        }
        return srt;
    }
    public static void swap(int[] a, int srt, int end){
        int temp = a[srt];
        a[srt] = a[end];
        a[end] = temp;
    }
}

