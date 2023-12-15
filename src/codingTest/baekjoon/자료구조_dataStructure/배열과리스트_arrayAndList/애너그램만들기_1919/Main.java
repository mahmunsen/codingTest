package codingTest.baekjoon.자료구조_dataStructure.배열과리스트_arrayAndList.애너그램만들기_1919;
/*
 * 문제: 두 개의 영어 단어가 주어졌을 때, 두 단어가 서로 애너그램 관계에 있도록 만들기 위해서 제거해야 하는 최소 개수의 문자 수를 구하는 프로그램을 작성하시오. 문자를 제거할 때에는 아무 위치에 있는 문자든지 제거할 수 있다.
 * 입력: 첫째 줄과 둘째 줄에 영어 단어가 소문자로 주어진다. 각각의 길이는 1,000자를 넘지 않으며, 적어도 한 글자로 이루어진 단어가 주어진다.
 * 출력: 첫째 줄에 답을 출력한다.
 * */
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] li = new int[26];
        int sum = 0;
        char[] a = br.readLine().toCharArray();
        char[] b = br.readLine().toCharArray();
        // 중복되는 글자를 하나라도 찾으면 스킵
        for(char i : a) { // asc2 코드에서 a=97, 따라서 a-97=0;
            li[i - 97]++;
        }
        for(char i : b) {
            li[i - 97]--;
        }
        // 만약 첫번째에서 a가 1개, 두번째에서 a가 3개이면...
        for(int i=0; i<li.length; i++){
            li[i] = Math.abs(li[i]); // Math.abs(): 절대값 구하기
            if(li[i] != 0){ // 첫번째 라인과 두번째 라인에서 각각 중복되는 것의 개수가 불일치
                sum += li[i];
            }
        }
        System.out.println(sum);
    }
}
