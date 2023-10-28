package codingTest.baekjoon.자료구조_dataStructure.배열과리스트_arrayAndList.방배정_13300;
// 2초
// 문제: 남남, 여여, 같은 학년, 한 방에 배정받을 수 있는 인원수, k, 조건에 맞는 방의 최소 개수 구하기
/* 입력: (1): 학생수, 1<=n<=1000, 한방에 최대인원, k, 1<k<=1000,
        (2)~(n): (학생의 성별s, 학년y), 여학생: 0, 남학생: 1
   출력: 최소 방의 수
*
* */

/** rm[s][j]가 0일 수도 있는데 조건을 빠뜨림(처음버전)*/
//import java.io.*;
//import java.util.*;
//public class Main {
//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken()); // 학생 수 n
//        int k = Integer.parseInt(st.nextToken()); // 방 최대인원 수 k
//        int[][] rm = new int[2][7]; // 성별, 학년 -> 학년 사이즈가 7인 이유: i가 1부터 시작할 거라서
//        int s, g;
//        int cnt = 0;
//
//        for(int i=0; i<n; i++){
//            st = new StringTokenizer(br.readLine());
//            s = Integer.parseInt(st.nextToken());
//            g = Integer.parseInt(st.nextToken());
//            rm[s][g]++;
//        }
//
//        for(int i=0; i<2; i++){
//            for(int j=1; j<7; j++){
//                cnt += rm[i][j]/k;
//                if(rm[i][j]%2 !=0){
//                    cnt++;
//                }
//            }
//        }
//        System.out.println(cnt);
//    }
//}


import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 학생 수 n
        int k = Integer.parseInt(st.nextToken()); // 방 최대인원 수 k
        int[][] rm = new int[2][7]; // 성별, 학년 -> 학년 사이즈가 7인 이유: i가 1부터 시작할 거라서
        int s, g;
        int cnt = 0;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            rm[s][g]++;
        }
        for(int i=1; i<7; i++){
            if(rm[0][i] != 0){
                cnt += rm[0][i]%k != 0 ? rm[0][i]/k+1 : rm[0][i]/k;
            }
            if(rm[1][i] != 0){
                cnt += rm[1][i]%k != 0 ? rm[1][i]/k+1 : rm[1][i]/k;
            }
        }
        System.out.println(cnt);
    }
}
