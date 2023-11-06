package codingTest.baekjoon.탐색_search.너비우선탐색_BFS.DFS와BFS프로그램_1260;
/*
시간제한: 2초
조건:
- 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000)
- 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다.
*/

import java.io.*;
import java.util.*;

public class Main {
    static int n, m, v;
    static boolean[] visited;
    static int[][] a;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 정점 개수
        m = Integer.parseInt(st.nextToken()); // 간선 개수
        v = Integer.parseInt(st.nextToken()); // 시작 정점

        // 초기화
        visited = new boolean[n+1];
        a = new int[n+1][n+1];

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            a[s][e] = a[e][s] = 1; // 1로 방문 표시
        }

        dfs(v);
        sb.append("\n");
        visited = new boolean[n+1];
        bfs(v);
        System.out.println(sb);
    }
    public static void dfs(int v){
        visited[v] = true; // 1) dfs로 들어온 순간 그 노드를 true
        sb.append(v + " ");

        for(int i=1; i<a.length; i++){ // 2)
            if(a[v][i] == 1 && !visited[i]){ // 연결되어 있는데(1) 아직 방문하지 않았다면
                dfs(i);
            }
        }

    }
    public static void bfs(int v){ // v=1
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        visited[v] = true;
        while (!q.isEmpty()){
            v = q.poll();
            sb.append(v + " ");
            for(int i=1; i<a.length; i++){
                if(a[v][i] == 1 && !visited[i]){
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
