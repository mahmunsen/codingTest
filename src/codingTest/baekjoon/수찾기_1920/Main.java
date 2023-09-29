//package codingTest.baekjoon.수찾기_1920;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//public class Main {
//    // N개의 정수 속 X 정수 존재 여부 찾기
//    // (1) n: 배열의 크기
//    // (2) 배열의 원소
//    // (3) m: 찾아야 할 수의 개수
//    // (4) 찾아야 할 수들
//    // 1초, (1 ≤ N, M ≤ 100,000) -> n2 (단순 반복문)으로 풀 수 없음. nlogn
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//
//        int n = Integer.parseInt(br.readLine());
//        int[] arr = new int[n]; // 배열의 크기
//
//        st = new StringTokenizer(br.readLine());
//        for(int i = 0; i < n; i++){
//            arr[i] = Integer.parseInt(st.nextToken()); // arr 배열의 원소들
//        }
//
//        Arrays.sort(arr); // arr 배열 정렬 [1, 2, 3, 4, 5]
//
//        int m = Integer.parseInt(br.readLine());
//        int start = 0;  //
//        int end = n - 1;
//        int mid = (start + end) / 2;
//        boolean find = false;
//
//        st = new StringTokenizer(br.readLine());
//        for(int i = 0; i < m; i++){
//            int target = Integer.parseInt(st.nextToken()); // find 배열의 원소들 [1, 3, 7, 9, 5]
//            while ( start <= end ){
//                if (target < arr[mid]){
//                    end = mid -1;
//                } else if (target > arr[mid]){
//                    start = mid + 1;
//                } else {
//                    find = true;
//                    break;
//                }
//            }
//            if(find) System.out.println(1);
//            else System.out.println(0);
//        }
//    }
//}
package codingTest.baekjoon.수찾기_1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    // N개의 정수 속 X 정수 존재 여부 찾기
    // (1) n: 배열의 크기
    // (2) 배열의 원소
    // (3) m: 찾아야 할 수의 개수
    // (4) 찾아야 할 수들
    // 1초, (1 ≤ N, M ≤ 100,000) -> n2 (단순 반복문)으로 풀 수 없음. nlogn
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n]; // 배열의 크기

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken()); // arr 배열의 원소들
        }

        Arrays.sort(arr); // arr 배열 정렬 [1, 2, 3, 4, 5]

        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            int target = Integer.parseInt(st.nextToken()); // find 배열의 원소들 [1, 3, 7, 9, 5]

            // 업데이트 되는 값들(아래)
            boolean find = false;
            int start = 0; // 첫번째 인덱스
            int end = n - 1; // 끝 인덱스

            while ( start <= end ){
                // 업데이트 되는 값
                int mid = (start + end) / 2;
                if (arr[mid] > target){
                    end = mid -1;
                } else if (arr[mid] < target){
                    start = mid + 1;
                } else {
                    find = true;
                    break;
                }
            }
            if(find) System.out.println(1);
            else System.out.println(0);
        }
    }
}
