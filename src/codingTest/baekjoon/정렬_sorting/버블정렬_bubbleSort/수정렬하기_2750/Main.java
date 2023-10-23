package codingTest.baekjoon.정렬_sorting.버블정렬_bubbleSort.수정렬하기_2750;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    // 시간제한: 1초 -> 1억 이내
    // 문제: n개의 수, 오름차순 정렬하기
    /* 입력: (1): n, 수의 개수, 1<= n <= 1,000 -> O(n²) 으로 해도 1,000,000(백만) 정도여서 버블 정렬로 풀어도 무방
            (2)~(n): 수들이 주어짐, 수들 <= 1000, 정수이고 중복 X */
    // 출력: (1) ~ (n) 줄에 오름차순으로 정렬한 결과, 한 줄에 하나씩 출력

    /** 1) Scanner + bubble sort -> 메모리: 22204 KB, 시간: 360 ms, 코드길이: 675 B */
//    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt(); // 수의 개수, n 받기
//        int[] arr = new int[n]; // 빈 배열 arr 생성
//        for (int i = 0; i < n; i++) {
//            arr[i] = sc.nextInt(); // 반복문으로 배열 arr에 담길 수들 받기
//        }
//        for (int i = 0; i < n - 1; i++) { // n개의 데이터가 있을 때 인접한 두 수의 비교연산은 총 n-1번 일어남(ex, 5개, {1, 2, 3, 4, 5} 일 때 1과 2, 2와 3, 3과 4, 4와 5 이렇게 총 4번 일어남)
//            for (int j = 0; j < n - 1 - i; j++) { // 루프 돌 때마다 정렬된 데이터가 생겨나는데 그 정렬된 데이터의 개수를 제외하고 나머지 횟수에서만 swap이 일어나야 하므로 n-1-i가 된다.
//                if (arr[j] > arr[j + 1]) {
//                    int temp = arr[j]; // 임시 변수 temp에 arr[j]의 값 저장
//                    arr[j] = arr[j + 1]; // arr[j]에는 arr[j+1]이 들어오고
//                    arr[j + 1] = temp;   // arr[j+1]에는 temp에 담긴 arr[j] 넣어준다.
//                    // temp 사용 이유? 두 원소를 직접 교환하면(arr[j] = arr[j+1]) arr[j]의 원래 값이 arr[j+1]로 덮어씌워져 데이터 손실이 일어나기 때문.
//                }
//            }
//        }
//        for (int i = 0; i < n; i++) {
//            System.out.println(arr[i]);
//        }
//    }

    /** 2) Scanner + Arrays.sort()
     * -> 메모리: 22288 KB, 시간: 344 ms, 코드길이: 426 B
     * -> 1) 보다 시간은 16ms 적게 들고 코드양도 적으나 메모리는 더 잡아먹음 */
//    public static void main(String args[]){
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] arr = new int[n];
//        for(int i = 0; i < n; i++){
//            arr[i] = sc.nextInt();
//        }
//        Arrays.sort(arr); // 오름차순 정렬
//        for(int i = 0; i < n; i++){
//            System.out.println(arr[i]);
//        }
//    }

    /** BufferedReader는 IOException, new InputStreamReader이 필요하다.
     *  Scanner는 내부적으로 예외처리가 되어 있어 throws IOException 할 필요 없다.
     *  자바의 입출력은 바이트 스트림이기 때문에 System.in으로 들어온 바이트 스트림을 new
     *  InputStreamReader을 통해 문자 스트림으로 변환해줄 필요가 있다. Scanner는 내부적으로
     *  System.in에서 바로 문자열을 읽을 수 있도록 구현되어 있기 때문에 InputStreamReader를
     *  직접 사용할 필요가 없다.*/

    /** 3) BufferedReader + bubble sort -> 메모리: 14940 KB, 시간: 188 ms, 코드길이: 834 B */
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }

    /** 4) BufferedReader + Arrays.sort() -> 메모리: 14872 KB, 시간: 176 ms, 코드길이: 590 B */
//    public static void main(String args[]) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = Integer.parseInt(br.readLine());
//        }
//       Arrays.sort(arr);
//        for (int i = 0; i < n; i++) {
//            System.out.println(arr[i]);
//        }
//    }
}
