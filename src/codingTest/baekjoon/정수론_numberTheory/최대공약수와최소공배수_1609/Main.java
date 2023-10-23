package codingTest.baekjoon.정수론_numberTheory.최대공약수와최소공배수_1609;
// 시간제한: 1초
// 문제: 두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.
// 입력: (1) 두 개의 자연수, a, b <= 10,000인 자연수
// 출력: (1) 두 수의 최대공약수, (2) 두 수의 최소공배수

/**
 * 1) 최대공약수(gcd, greatest common divisor): 두 수의 공약수 중 가장 큰 수, ex) 18, 24의 공약수 = {1, 2, 3, 6}, 최대공약수 = 6
 *
 *
 * 2) 최소공배수(lcm, largest common multiple): 공통된 배수를 공배수라 하는데 그 중 가장 작은수, ex) 2, 3의 공배수 = {6, 12, 18}, 최소공배수 = 6 */



//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.StringTokenizer;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int m = Integer.parseInt(st.nextToken()); // 두 수 차례로 받기
//        int n = Integer.parseInt(st.nextToken());
//        List<Integer> a = new ArrayList<>();
//        // 최대공약수 구하기
//        for(int i=1; i<=Math.min(m, n); i++){
//            if((m%i)==0 && (n%i)==0){
//                a.add(i);
//            }
//        }
//        int max = a.get(0);
//        for(int i=0; i < a.size(); i++){
//            if(a.get(i) > max){
//                max = a.get(i);
//            }
//        }
//        // 최소공배수 구하기
//        int k = m/max; // 3
//        int l = n/max; // 4
//        int min = max * k * l;
//
//        System.out.println(max);
//        System.out.println(min);
//    }
//}


//import java.util.Scanner;
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt();
//        int b = sc.nextInt();
//
//        // a = md
//        // b = nd
//        // 최소공배수 = mnd
//
//        int d = gcd(a ,b); // 최대공약수
//        System.out.println(d);
//        System.out.println((a*b)/d);
//    }
//    public static int gcd(int a, int b){
//       if(b == 0) return a;
//
//       return gcd(b, a%b);
//    }
//}

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = a*b;
        while(b!=0){
            int r = a%b;
            a = b;
            b = r;
        }
        System.out.println(a);
        System.out.println(c/a);
    }
}