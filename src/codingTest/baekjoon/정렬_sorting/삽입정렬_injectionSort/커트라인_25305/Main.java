package codingTest.baekjoon.정렬_sorting.삽입정렬_injectionSort.커트라인_25305;
// 시간제한: 1초 -> 1억 연산 이내
// 문제: 커트라인(상 받는 인원 중 점수가 가장 낮은 사람의 점수) 구하기
/* 입력: (1): n, 응시자 수. k, 상을 받는 사람의 수 -> 1<=n<=1,000, 1<=k<=n
 *       (2): [], 각 학생의 점수들, x -> 0 <=x<=10,000 */
// 출력: 상을 받는 커트라인 출력
// 시험 응시자들 가운데 1등은 100점, 2등은 98점, 3등은 93점이다. 2등까지 상을 받으므로 커트라인은 98점이다.

//import java.io.*;
//import java.util.*;
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken()); // 학생수
//        int k = Integer.parseInt(st.nextToken()); // 상받는 학생수
//        int[] a = new int[n];
//        st = new StringTokenizer(br.readLine());
//        for(int i=0; i<n; i++){
//            a[i] = Integer.parseInt(st.nextToken());
//        }
//        for(int i=1; i<n; i++){
//          int target = a[i]; // 타겟
//          int j = i-1;       // 0번
//            // 타겟이
//          while (j>=0 && target>a[j]){
//              a[j+1] = a[j];
//              j--;
//          }
//          a[j+1] = target;
//        }
//        System.out.println(a[k-1]);
//    }
//}


import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 학생수
        int k = Integer.parseInt(st.nextToken()); // 상받는 학생수
        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<n; i++){ // index = 0은 이미 정렬된 상태를 가정, 1위치부터 시작
            int target = a[i];
            int j = i-1; // 타겟보다 이전
            while(j>=0 && a[j] <= target){
                a[j+1] = a[j];
                j--;
            }
//          target = a[j+1]; // (오답) 타겟에 새로운 값을 저장해서 타겟의 값을 바꾸면 x
            a[j+1] = target;   // 새로운 위치에 들고있던 타겟의 값을 저장 o
        }
        System.out.println(a[k-1]);
    }
}


