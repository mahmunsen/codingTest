package codingTest.baekjoon.그래프_graph.유니온파인드_unionFind.여행가자_1976;

// https://www.acmicpc.net/problem/1976
/*
 * 시간제한: 2초
 * 도시 n개, 임의의 두 도시 사이에 길이 있을 수도, 없을 수도 있다.
 * 동혁이의 여행 계획에 속한 도시들이 순서대로 주어졌을 때 가능한지 여부를 판별하는 프로그램을 작성
 *
 * */

/**
 * 행렬에서 1이 있으면 union(a,b)를 수행
 * 맨 처음 도시를 find 연산하여 대표노드를 찾는다.
 * 이외 도시들에 대해 find 연산하여 대표노드를 찾고 처음 출발하는 도시의 대표노드와 비교한다.
 * 서로 대표 노드가 다르면 no 출력, 같으면 yes
 */

import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    static int[] cities;
    static boolean checksame;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine()); // 도시의 수
        int m = Integer.parseInt(br.readLine()); // 여행 계획에 속한 도시들의 수
        // 초기화
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == 1) {
                    union(i, j); // 합치기
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        int start = find(Integer.parseInt(st.nextToken()));
        for(int i=1; i<m; i++){
            int headTo = Integer.parseInt(st.nextToken());
            if(start!=find(headTo)){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    public static int find(int k) {
        if (parent[k] == k) {
            return k;
        } else {
            return parent[k] = find(parent[k]);
        }
    }
    public static void union(int i, int j) {
        // 대표노드 찾기
        i = find(i);
        j = find(j);
        // 합치기
        if (i != j) {
            if(i<j) parent[j] = i;
            else parent[i] = j;
        }
    }
}
