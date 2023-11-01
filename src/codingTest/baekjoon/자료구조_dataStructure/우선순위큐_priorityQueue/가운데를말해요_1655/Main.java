package codingTest.baekjoon.자료구조_dataStructure.우선순위큐_priorityQueue.가운데를말해요_1655;
/*
1. 시간제한: .1초
2. 문제:
정수를 하나씩 외칠때마다 지금까지 백준이가 말한 수 중에서 중간값을 말해야 한다.
외친 수의 개수가 짝수개라면 중간에 있는 두 수 중에서 작은 수를 말해야 한다.
3. 입력: (1): 백준이가 외치는 정수의 개수 N, 1<=N<=100,000
        (2~n): -10,000<=정수<=10,000
4. 출력: 한 줄에 하나씩 N줄에 걸쳐 말해야 하는 수를 순서대로 출력
* */
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        // 짝수 -> 중간에 있는 두 수 중 작은수
        // 홀수 -> 중간값 리턴
        PriorityQueue<Integer> min = new PriorityQueue<>((a, b) -> a - b);
        PriorityQueue<Integer> max = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (min.size() == max.size()) max.offer(num); // 개수가 같으면 max로
            else min.offer(num); // 개수가 다르면 min 으로

            if (!min.isEmpty() && !max.isEmpty()) {
                if (min.peek() < max.peek()) {
                    int tmp = min.poll();
                    min.offer(max.poll());
                    max.offer(tmp);
                }
            }
            sb.append(max.peek() + "\n");
        }
        System.out.println(sb);
    }
}


