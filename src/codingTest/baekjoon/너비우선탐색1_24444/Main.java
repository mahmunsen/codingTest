package codingTest.baekjoon.너비우선탐색1_24444;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // N: 정점의 수
    // M: 간선의 수
    // R: 시작 정점
    // 무방향 그래프, 모든 간선의 가중치는 1이다
    // 인접 정점은 오름차순으로 방문한다
    // 노드의 방문순서를 출력한다

    // 인접리스트
    // 방문 배열
    // 큐 자료구조
    static boolean[] visited; // 방문여부
    static int n, m, r;
    static ArrayList<Integer>[] adjList;
    static int cnt;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 노드 개수
        m = Integer.parseInt(st.nextToken()); // 각 노드의 리스트 개수
        r = Integer.parseInt(st.nextToken());

        visited = new boolean[n];
        adjList = new ArrayList[n]; // [1, 2, 3, 4, 5 ...]
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>(); // 각 노드마다 인접한 인덱스들을 각자의 List 에 담음, 1이면 [2, 3]
        }
        //
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine()); // 두번째줄 받는다
            int start = Integer.parseInt(st.nextToken()); // 각 노드 리스트의 첫 인덱스
            int end = Integer.parseInt(st.nextToken());   // 각 노드 리스트의 끝 인덱스
            adjList[start].add(end); // 시작점에서 끝점으로도 갈 수 있고 (무방향)
            adjList[end].add(start); // 끝점에서 시작점으로 갈 수 있다
        }
        for (int i = 0; i <= n; i++) {
            Collections.sort(adjList[i]); // 방문순서 위해 오름차순 정렬
        }
//        bfs(r);
    }

//    private static void bfs(int r) {
//        Queue<Integer> que = new LinkedList<>();
//        visited[r] = true;
//        que.add(r);
//
//        while (que.size() != 0) {
//            r = que.poll();
//            for (int i = 0; i < n; i++) {
//                if(adjList && !visited[i]){
//                    que.add(i);
//                    visited[i] = true;
//                }
//            }
//        }
//    }
}
