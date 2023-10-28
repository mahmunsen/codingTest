package codingTest.baekjoon.자료구조_dataStructure.배열과리스트_arrayAndList.숫자의개수_2577;
// 1초,
// 문제: a*b*c의 결과에 0~9가 몇번씩 쓰였는지
// A = 150, B = 266, C = 427 이라면 A × B × C = 150 × 266 × 427 = 17037300, 0이 3번, 1이 1번, 3이 2번, 7이 2번

// 입력: (1): a, (2): b, (3): c, 100<=a,b,c<1000, 자연수
// 출력: (1): 0이 몇번 쓰였는지 출력, (2)~(10): 1~9 숫자가 각각 몇 번 쓰였는지 출력

import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int sum = a*b*c; // 17037300
        String k = String.valueOf(sum);
        int[] arr = new int[10]; // 0~9;

        for(int i=0; i<k.length(); i++){
            arr[k.charAt(i)-48] +=1;
        }
        for(int i=0; i<10; i++){
            System.out.println(arr[i]);
        }
    }
}



