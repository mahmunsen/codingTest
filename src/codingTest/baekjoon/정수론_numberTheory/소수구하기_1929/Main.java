package codingTest.baekjoon.정수론_numberTheory.소수구하기_1929;
// 시간제한: 2초, 메모리제한: 256mb
// 문제: m이상 n이하의 소수를 모두 출력
// 입력: (1) 자연수 m, n (1 <= m <= n <= 1,000,000) m이상 n이하의 소수가 하나 이상 있는 입력
// 출력: 한 줄에 하나씩, 증가하는 순서대로 소수 출력

//import java.util.Scanner;
//public class Main {
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int m = sc.nextInt(); // 시작 숫자
//        int n = sc.nextInt(); // 끝 숫자
//        int[] a = new int[n+1];
//
//        for(int i=1; i<=n; i++) {
//            a[i] = i;
//        }
//        for(int i=2; i <=Math.sqrt(n); i++){
//            if(a[i]==0) continue;  // 0이면 스킵
//           for(int j=i+i; j<=n; j=j+i){ // j = 4부터 시작, j+i(4+2)...16까지
//               a[j] = 0; // a[4] = 4 -> 0, a[6] = 6 -> 0 ...
//           }
//        }
//        for(int i=m; i<=n; i++){
//            if(a[i]!=0){
//                System.out.println(a[i]);
//            }
//        }
//    }
//}


import java.util.Scanner;
public class Main {
    public static boolean[] a;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(); // 시작 숫자
        int n = sc.nextInt(); // 끝 숫자
        a = new boolean[n+1];

        get_prime();

        for(int i = m; i <= n; i++){
            if(!a[i]==true){
                System.out.println(i);
            }
        }
    }
    private static void get_prime() {
        a[0] = a[1] = true;

        for(int i=2; i<=Math.sqrt(a.length); i++){
            if(a[i]) continue;
            for(int j = i+i; j < a.length; j=j+i) {
                a[j] = true;
            }
        }
    }
}

