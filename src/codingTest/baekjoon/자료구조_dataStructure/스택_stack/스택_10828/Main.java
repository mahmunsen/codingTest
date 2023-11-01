package codingTest.baekjoon.자료구조_dataStructure.스택_stack.스택_10828;
/*
1. 시간제한: .5초
2. 문제:
- push X: 정수 X를 스택에 넣는 연산이다.
- pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
- size: 스택에 들어있는 정수의 개수를 출력한다.
- empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
- top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.

3. 입력: (1): 명령의 수 N (1 ≤ N ≤ 10,000)
        (2~n): 명령이 하나씩 주어짐, 1<=정수<=100,000
4. 출력: 한 줄에 하나씩 출력
*/

/**
 * 버전1  버전2
 */

//import java.io.*;
//import java.util.*;
//
//public class Main {
//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine()); // 명령의 수
//        Stack<Integer> st = new Stack<>();
//
//        for(int i=0; i<n; i++){
//            String s = br.readLine();
//            if(s.contains("push")){
//                String[] word = s.split(" ");
//                int num = Integer.parseInt(word[1]);
//                st.push(num);
//            } else if(s.equals("top")){
//                if (st.empty()){
//                    System.out.println(-1);
//                } else System.out.println(st.peek());
//            } else if(s.equals("size")){
//                System.out.println(st.size());
//            } else if(s.equals("empty")){
//                if(st.empty()){
//                    System.out.println(1);
//                } else System.out.println(0);
//            } else if(s.equals("pop")){
//                if(st.empty()){
//                    System.out.println(-1);
//                } else {
//                    int temp = st.pop();
//                    System.out.println(temp);
//                }
//            }
//        }
//    }
//}

/** 버전2 */

import java.io.*;
import java.util.*;

public class Main {
    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 명령의 수


        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            switch (s){
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "top":
                    top();
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    empty();
                    break;
                case "pop":
                    pop();
                    break;
            }
        }
    }
    public static void top(){
        if(stack.empty()) System.out.println(-1);
        else System.out.println(stack.peek());
    }
    public static void empty(){
        if(stack.empty()) System.out.println(1);
        else System.out.println(0);
    }
    public static void pop(){
        if(stack.empty()) System.out.println(-1);
        else {
            int temp = stack.pop();
            System.out.println(temp);
        }
    }
}
