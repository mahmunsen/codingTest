package codingTest.baekjoon.그래프_graph.유니온파인드_unionFind.집합의표현_1717;

/*
 * 시간제한:2초
 * 문제: 합집합 연산과, 두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산을 수행
 * a와 b가 같은 집합에 포함되어 있으면 yes, 그렇지 않다면 no를 한 줄에 하나씩 출력
 */

// https://www.acmicpc.net/problem/1717

import java.io.*;
import java.util.*;

public class Main {
    static boolean checkSame;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 숫자 개수
        int m = Integer.parseInt(st.nextToken()); // 연산의 개수

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {  // 초기화
            parent[i] = i;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken()); // 질의부분
            int a = Integer.parseInt(st.nextToken()); // 숫자 a
            int b = Integer.parseInt(st.nextToken()); // 숫자 b
            if (q == 0) { // 합치기
                union(a, b);
            } else {      // 두 원소 같은지 확인
                boolean res = checkSame(a,b);
                if(res) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }

    private static boolean checkSame(int a, int b) {
        a = find(a);
        b = find(b);
        if(a==b) return true;
        else return false;
    }

    public static int find(int a) {
        if (parent[a] == a) { // 대표노드인지 확인
            return a;
        } else {
            return parent[a] = find(parent[a]);
        }
    }

    public static void union(int a, int b) {
        // 대표노드 확인하기
        a = find(a); // 1
        b = find(b); // 2
        if (a!=b) parent[b] = a;
    }
}
