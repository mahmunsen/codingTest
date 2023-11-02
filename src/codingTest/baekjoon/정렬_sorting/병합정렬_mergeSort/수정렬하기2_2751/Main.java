package codingTest.baekjoon.정렬_sorting.병합정렬_mergeSort.수정렬하기2_2751;
/*
1. 시간제한: 2초 -> 2억 연산 이내
2. 문제:
N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성
3. 입력:
(1): 수의 개수 N(1 ≤ N ≤ 1,000,000)
(2~n): |수|<=1,000,000, 정수, 중복x
4. 출력:
*/

/** 1. BufferedReader + BufferedWriter + Collections.sort() */

//import java.io.*;
//import java.util.*;
//public class Main {
//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        int n = Integer.parseInt(br.readLine());
//        List<Integer> a = new ArrayList<>();
//        for(int i=0; i<n; i++){
//            a.add(Integer.parseInt(br.readLine()));
//        }
//        Collections.sort(a);
//        for(int el : a){
//            bw.write(String.valueOf(el + "\n"));
//        }
//        bw.flush();
//        bw.close();
//    }
//}

/** 2. BufferedReader + StringBuilder + Collections.sort() */

//import java.io.*;
//import java.util.*;
//public class Main {
//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        int n = Integer.parseInt(br.readLine());
//        List<Integer> a = new ArrayList<>();
//        for(int i=0; i<n; i++){
//            a.add(Integer.parseInt(br.readLine()));
//        }
//        Collections.sort(a);
//        for(int el : a){
//            sb.append(el).append("\n");
//        }
//       System.out.println(sb.toString());
//    }
//}


/** 3. BufferedReader + StringBuilder + 병합정렬 */

import java.io.*;
import java.util.*;
public class Main {
    static int[] sorted;
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(br.readLine());
        }
        mergeSort(a, 0, n-1);
        for(int i=0; i<n; i++){
            System.out.println(a[i] + " ");
        }
    }
    public static int[] mergeSort(int[] a, int s, int e){
        if(s<e) {
            int m = (s + e) / 2; // 중간
            mergeSort(a, s, m);
            mergeSort(a, m + 1, e);
            merge(a, s, m, e);
        }
        return a;
    }
    public static int[] merge(int[] a, int s, int m, int e){
        sorted = new int[n]; // 정렬된 요소들을 넣을 빈 배열
        int k = s; // 합병한 배열의 인덱스
        int j = m+1; // 오른쪽 배열 시작 인덱스
        while(s<=m && j<=e){
            if(a[s]<=a[j]){
                sorted[k++] = a[s++];
            } else {
                sorted[k++] = a[j++];
            }
        }
        if(s>m){
            for(int i=j; i<=e;i++){
                sorted[k++] = a[i];
            }
        } else{
            for(int i=s; i<=m; i++){
                sorted[k++] = a[i];
            }
        }
        // 원래 배열에 복사
        for(int i=s; i<=e; i++){
            a[i] = sorted[i];
        }
        return a;
    }
}


