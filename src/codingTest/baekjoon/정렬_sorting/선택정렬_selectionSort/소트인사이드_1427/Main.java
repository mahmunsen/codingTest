package codingTest.baekjoon.정렬_sorting.선택정렬_selectionSort.소트인사이드_1427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    // 시간제한: 2초 -> 2억 이내
    // 문제: 수의 각 자리수를 내림차순 정렬하기
    // 입력: (1): 정렬해야 할 수 n, n <= 1,000,000,000(10억), 자연수
    // 출력: (1) 줄에 자리수를 내림차순으로 정렬한 수 출력

    /** 1-1) Scanner + bubble sort, charAt() */
//    public static void main(String args[]){
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt(); // int 범위: -2,147,483,648에서 2,147,483,647까지의 범위의 정수만, 32비트
//        String nToString = Integer.toString(n); // int -> String 으로 변환
//        int[] arr = new int[nToString.length()];
//        int result = 0;
//        for(int i = 0; i < arr.length; i++){    // arr 배열
//           arr[i] = nToString.charAt(i) - '0';
//        }
//        for(int i = 0; i < arr.length-1; i++){    // ex: [5, 4, 3, 2, 1]
//            for(int j = 0; j < arr.length-1-i; j++){
//                if(arr[j] < arr[j+1]){
//                    int temp = arr[j+1];
//                    arr[j+1] = arr[j];
//                    arr[j] = temp;
//                }
//            }
//        }
//        for(int i = 0; i < arr.length; i++){
//            result = result * 10 + arr[i];
//        }
//        System.out.println(result);
//    }

    /** 1-2) Scanner + bubble sort, StringBuilder */
//    public static void main(String args[]){
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt(); // 정수 n 받기
//        String nStr = Integer.toString(n); // int -> String, "2143"
//        String[] strArr = new String[nStr.length()];
//        for(int i = 0; i < nStr.length(); i++){
//            strArr[i] = String.valueOf(nStr.charAt(i));  // String -> String[]
//        }
//        for(int i = 0; i < strArr.length-1; i++){    // ex: [5, 4, 3, 2, 1]
//            for(int j = 0; j <  strArr.length-1-i; j++){
//                if(Integer.parseInt(strArr[j]) < Integer.parseInt(strArr[j+1])){
//                    int temp = Integer.parseInt(strArr[j+1]);
//                    strArr[j+1] =  strArr[j];
//                    strArr[j] = String.valueOf(temp);
//                }
//            }
//        }
//        StringBuilder st = new StringBuilder();
//        for(String str : strArr){ // StringBuilder 사용, String[] -> String 변환
//            st.append(str);
//        }
//        int result = Integer.parseInt(st.toString());
//        System.out.println(result);
//    }

    /** 1-2) Scanner + bubble sort, stream의 mapToInt 사용 */
//    public static void main(String args[]){
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt(); // 정수 n 받기
////        String nStr = Integer.toString(n);
//        String nStr = String.valueOf(n); // "2143"
//        int[] arr = Stream.of(nStr.split("")).mapToInt(Integer::parseInt).toArray(); // String -> int[], [2, 1, 4, 3]
//        for(int i = 0; i < arr.length-1; i ++){
//            for(int j = 0; j < arr.length-1-i; j++){
//                if(arr[j] < arr[j+1]){
//                    int temp = arr[j+1]; // 큰 수(arr[j+1])를 temp 에 저장
//                    arr[j+1] = arr[j];   // 큰 수 자리(arr[j+1])에 작은 수(arr[j]) 저장
//                    arr[j] = temp;       // 작은 수 자리에 큰 수(arr[j+1])를 저장해놓은 temp 넣음
//                }
//            }
//        }
//        StringBuilder st = new StringBuilder(); // append()에 String[]이 아니라 String 값을 넣어야함.
//        String[] str = new String[arr.length];
//        for(int i = 0; i < arr.length; i++){
//            str[i] = String.valueOf(arr[i]); // int[] -> String[]
//            st.append(str[i]);               // String[] -> String
//        }
//        int result = Integer.parseInt(st.toString()); // String -> int
//        System.out.println(result);
//    }
    /** 1-3) Scanner + Arrays.sort() + System.out.print() */
//    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt(); // 2143
//        char[] arr = String.valueOf(n).toCharArray(); // ["2", "1", "4", "3"]
//        Arrays.sort(arr); // [1, 2, 3, 4]
//
//        for (int i = arr.length - 1; i >= 0; i--){
//            System.out.print(arr[i]);
//        }
//    }

    /** 1-4) BufferedReader + Arrays.sort() + System.out.print() */
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] arr = Integer.toString(n).toCharArray();
        Arrays.sort(arr);

        for(int i = arr.length - 1; i >= 0; i--){
            System.out.print(arr[i]);
        }
    }
}
