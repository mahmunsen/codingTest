package codingTest.baekjoon.자료구조_dataStructure.큐_queue.카드2_2164;

// 2초
/* 문제: n장의 카드, 1부터 N까지의 번호, 1번 카드가 제일 위에, N번 카드가 제일 아래인 상태로 순서대로 카드가 놓임
 카드가 한 장 남을 때까지, 제일 위에 있는 카드를 바닥에 버린다. 그 다음, 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮기는 걸 반복
  N이 주어졌을 때, 제일 마지막에 남게 되는 카드를 구하는 프로그램
* */
// 입력: (1): 정수 N(1 ≤ N ≤ 500,000)
// 출력: (1): 남게 되는 카드의 번호를 출력

import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=n; i++){ // queue에 원소 다 넣기
            q.add(i);
        }
        while (q.size()>1){ // 마지막 한장이 남을 때까지
            q.poll(); // 맨 위의 것을 버린다
            q.add(q.poll()); // 그 다음 것을 제일 아래로 옮긴다
        }
        System.out.println(q.poll()); // 남은 하나 출력
    }
}
