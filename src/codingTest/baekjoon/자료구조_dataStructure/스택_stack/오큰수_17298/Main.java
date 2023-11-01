package codingTest.baekjoon.자료구조_dataStructure.스택_stack.오큰수_17298;
/*
1. 시간제한: 1초
2. 문제: 수열의 각 원소 Ai에 대해서 오큰수 NGE(i)를 구하려고 한다.
        Ai의 오큰수는 오른쪽에 있으면서 Ai보다 큰 수 중에서 가장 왼쪽에 있는 수를 의미한다.
        그러한 수가 없는 경우에 오큰수는 -1
3. 입력: (1): 수열 A의 크기 N (1 ≤ N ≤ 1,000,000)
        (2): A1, A2, ..., AN (1 ≤ Ai ≤ 1,000,000)
4. 출력: 총 N개의 수 NGE(1), NGE(2), ..., NGE(N)을 공백으로 구분해 출력한다.
* */
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 수열의 크기
        int[] a = new int[n];
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){ // [3, 5, 2, 7]
            a[i] = sc.nextInt();
        }
        for(int i=0; i<n; i++){ // i = 0, 1, 2, 3
            while(!stack.isEmpty() && a[stack.peek()]<a[i]){ // a[2] < a[3], 2<7
                a[stack.pop()] = a[i]; //a[2] = a[3] [5, 5, 7, -1]
            }
            stack.push(i);
        }

        while (!stack.isEmpty()){
            a[stack.pop()] = -1;
        }
        for(int i=0; i<n; i++){
            sb.append(a[i]).append(" ");
        }
        System.out.println(sb);
    }
}
