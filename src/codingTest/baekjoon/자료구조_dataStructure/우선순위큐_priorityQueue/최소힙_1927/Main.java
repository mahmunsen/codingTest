package codingTest.baekjoon.자료구조_dataStructure.우선순위큐_priorityQueue.최소힙_1927;
/*
1. 시간제한: 1초
2. 문제:
배열에 자연수 x를 넣는다.
배열에서 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다.
3. 입력: (1): 연산의 개수 N(1 ≤ N ≤ 100,000)
        (2~n): 정수 x, x가 자연수라면 배열에 x라는 값을 추가하는 연산, x가 0이라면 배열에서 가장 작은 값을 출력하고 그 값을 배열에서 제거하는 경우
4. 출력:
0이 주어진 횟수만큼 답을 출력,
비어 있는 경우인데 가장 작은 값을 출력하라고 한 경우에는 0을 출력
* */
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> min = new PriorityQueue<>((a,b) -> a-b);
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                if(min.isEmpty()){
                    System.out.println(0);
                } else System.out.println(min.poll());
            } else {
                min.offer(num);
            }
        }
    }
}
