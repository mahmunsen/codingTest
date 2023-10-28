package codingTest.baekjoon.자료구조_dataStructure.배열과리스트_arrayAndList.알파벳개수_10808;
// 1초
// 문제: 단어 s, 알파벳이 단어에 몇 개가 포함되어 있는지 구하라.
// 입력: (1): 단어 s, s의 길이는 <100, 소문자로만.
// 출력: 단어에 포함된 a, b ....z의 개수를 공백으로 구분해서 출력

/**
 * 아스키코드: 숫자 0 = 48, 대문자 A = 65, 소문자 a = 97
 * "입력값 - 97" 을 해서 배열의 인덱스 값으로 사용
 * */

import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next(); // 단어 받기
        int[] n = new int[26];
        for(int i=0; i<s.length(); i++){
            n[s.charAt(i)-97] += 1; // a는 아스키코드에서 97과 같음
        }
        for(int i=0; i<26; i++){
            System.out.print(n[i] + " "); // 공백있이 출력이므로 " ", 한칸 띄워줌
        }
    }
}
