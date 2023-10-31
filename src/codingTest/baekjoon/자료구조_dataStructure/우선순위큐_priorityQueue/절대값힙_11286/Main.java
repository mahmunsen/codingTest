package codingTest.baekjoon.자료구조_dataStructure.우선순위큐_priorityQueue.절대값힙_11286;
// 2초
// 문제: 절대값이 가장 작은 수 출력한 뒤 배열에서 제거, 절댓값이 가장 작은 값이 여러개 -> 가장 작은 수를 출력한 후 그 값을 배열에서 제거
/* 입력: (1): 연산의 개수 N(1≤N≤100,000),
*       (2): 다음 n개줄부터 연산에 대한 정보를 나타내는 정수 x 주어짐. 만약 x가 0이 아니라면 배열에 x라는 값을 넣는(추가하는) 연산이고, x가 0이라면 배열에서 절댓값이 가장 작은 값을 출력하고 그 값을 배열에서 제거하는 경우
* */
// 출력: 만약 배열이 비어 있는 경우인데 절댓값이 가장 작은 값을 출력하라고 한 경우에는 0을 출력

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 연산의 개수

        // 절대값이 작은 순으로 우선순위 정렬
        // 절대값이 같을 경우 음수를 우선순위 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int fst = Math.abs(a); // Math.abs(): 절대값 구하는 함수
            int snd = Math.abs(b);
            if(fst == snd){
                return a > b ? 1:-1;  // 절대값이 값으면 음수 우선
            }
            return fst - snd; // 절대값이 작은 데이터 우선
        });

        for(int i=0; i<n; i++){
            int req = Integer.parseInt(br.readLine());
            if(req == 0){
                if(pq.isEmpty()){
                    System.out.println("0");
                } else System.out.println(pq.poll());
            }
            else {
                pq.add(req);
            }
        }
    }
}
