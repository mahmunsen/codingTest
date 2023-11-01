package codingTest.baekjoon.자료구조_dataStructure.큐_queue.큐2_18258;
/*
1. 시간제한: 1초
2. 문제:
push X: 정수 X를 큐에 넣는 연산이다.
pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 큐에 들어있는 정수의 개수를 출력한다.
empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
3. 입력: (1): 주어지는 명령의 수 N (1 ≤ N ≤ 2,000,000)
        (2~n번째): 명령이 하나씩 주어지는데 1<=정수<=100,000
4. 출력: 한 줄에 하나씩 출력
* */

import java.io.*;
import java.util.*;

public class Main {
    static Deque<Integer> q = new LinkedList<>();
    static  StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            switch (s){
                case "push":
                    q.offer(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    pop();
                    break;
                case "size":
                    sb.append(q.size()).append('\n');
                    break;
                case "empty":
                    empty();
                    break;
                case "front":
                    front();
                    break;
                case "back":
                    back();
                    break;
            }
        }
        System.out.println(sb.toString());
    }
    public static void pop(){
        if(!(q.size()==0)) sb.append(q.poll()).append('\n');
        else sb.append(-1).append('\n');
    }
    public static void empty(){
        if(!(q.size()==0)) sb.append(0).append('\n');
        else sb.append(1).append('\n');
    }
    public static void front(){
        if(!(q.size()==0)) sb.append(q.peek()).append('\n');
        else sb.append(-1).append('\n');
    }
    public static void back(){
        if(!(q.size()==0)) sb.append(q.peekLast()).append('\n');
        else sb.append(-1).append('\n');
    }
}
