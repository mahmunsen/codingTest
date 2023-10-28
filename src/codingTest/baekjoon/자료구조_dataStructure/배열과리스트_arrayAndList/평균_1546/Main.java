package codingTest.baekjoon.자료구조_dataStructure.배열과리스트_arrayAndList.평균_1546;
// 2초,
// 문제: 모든 점수를 최대값을 이용해 고친 후 이 새로운 점수들로 평균 구하기
// 입력: (1): 시험 본 과목 개수, n, n<=1000
//      (2): 세준이의 현재성적, m<=100, 음이 아닌 정수, 적어도 하나의 점수는 0보다 큼
// 출력: (1): 새로운 평균 출력, 소숫점 자리수까지 계산

import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 과목개수받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        double[] score = new double[n];
        double[] ns = new double[n];
        double max = score[0];
        double sum = 0;
        for(int i=0; i<n; i++){
            score[i] = Integer.parseInt(st.nextToken()); // 점수들 받기
            if(max<=score[i]){
                max=score[i];
            }
        }
        for(int i=0; i<n; i++){
            ns[i] = (score[i]/max)*100;
            sum += ns[i];
        }
        System.out.println(sum/n);
    }
}
