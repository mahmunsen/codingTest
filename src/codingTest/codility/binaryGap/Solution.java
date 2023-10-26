package codingTest.codility.binaryGap;
import java.util.Scanner;


/** 직접 이진수로 변환 */

//public class Solution {
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        /* 8%2 = 0
//        *  4(8/2)%2 = 0
//        *  2((8/2)/2)%2 =0
//        *  1(((8/2)/2)/2) = 1
//        * */
//
//        // 십진수 -> 이진수 변환
//        String binary = "";
//        while(n > 0){
//            binary += n%2;
//            n = n/2;
//
//        }
//        // 거꾸로 출력
//        for(int i=binary.length()-1; i >=0; i--){
//            System.out.print(binary.charAt(i));
//        }
//    }
//}

/**
 * toBinaryString() 이용
 */

// String 으로 전환, lastIndexOf(), split()
// 1과 1 사이의 0의 갯수를 구하는 것.

// 32 -> 100000 -> 0
// 529 -> 1000010001 -> 5
// 15 -> 1111 -> 0
// 20 -> 10100 -> 1
// 42 -> 101010 -> 1

/** 아래는 이전에 코딜리티에 제출한 문제, 결과: 80 */
//public class Solution {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        long n = sc.nextInt();
//        // 십진수 -> 이진수 변환
//        String binary = Long.toBinaryString(n);
//        String[] k = binary.split("1"); // 1을 기준으로 split
//        int max = 0;
//        int answer = 0;
//
//        if (!binary.contains("01")) {
//            System.out.println(answer);
//        }// "01" 포함하지 않을 때
//        else {
//            if (binary.lastIndexOf("1") == binary.length() - 1) {
//                for (int i = 0; i < k.length; i++) {
//                    if (k[i].length() >= max) {
//                        max = k[i].length();
//                    }
//                }
//            } else {
//                for (int i = 0; i < k.length; i++) { // 10100
//                    if(k[k.length-1].length() > k[i].length()){
//                        max = k[i].length();
//                    } else if(k[k.length-1].length() < k[i].length() && max <= k[i].length()) {
//                        max = k[i].length();
//                    }
//                }
//            }
//            answer = max;
//            System.out.println(answer);
//        }
//    }
//}




// 수정: 마지막 인덱스 빼버리고 그전의 맥스 값 리턴
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        // 십진수 -> 이진수 변환
        String binary = Long.toBinaryString(n);
        String[] k = binary.split("1"); // 1을 기준으로 split
        int max = 0;
        int answer = 0;

        if (!binary.contains("01")) {
            System.out.println(answer);
        }// "01" 포함하지 않을 때
        else {
            if (binary.lastIndexOf("1") == binary.length() - 1) {
                for (int i = 0; i < k.length; i++) {
                    if (k[i].length() >= max) {
                        max = k[i].length();
                    }
                }
            } else {
                for (int i = 0; i < k.length-1; i++) { // 10100
                   if(max <= k[i].length()){
                       max = k[i].length();
                   }
                }
            }
            answer = max;
            System.out.println(answer);
        }
    }
}




/** 아래는 코딜리티에 최종 제출한 해답, 결과: 100 */

//import java.util.*;
//
//class Solution {
//    public int solution(int N) {
//        String binary = Integer.toBinaryString(N);
//        String[] k = binary.split("1");
//        int max = 0;
//        int answer = 0;
//
//        if (!binary.contains("01")) {
//            return answer;
//        }
//        else {
//            if (binary.lastIndexOf("1") == binary.length() - 1) {
//                for (int i = 0; i < k.length; i++) {
//                    if (k[i].length() >= max) {
//                        max = k[i].length();
//                    }
//                }
//            } else {
//                for (int i = 0; i < k.length-1; i++) {
//                    if(max <= k[i].length()){
//                        max = k[i].length();
//                    }
//                }
//            }
//            answer = max;
//            return answer;
//        }
//
//    }
//}