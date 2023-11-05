package codingTest.baekjoon.탐색_search.깊이우선탐색_DFS.바이러스_2606;

/*
1. 시간제한: 1초
2. 문제: 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 출력하는 프로그램을 작성하라.
3. 입력:
(1): 컴퓨터의 수, n<=100 (정점의 수)
(2): 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수 (간선의 수)
(3~n): 직접 연결되어 있는 컴퓨터의 번호 쌍
4. 출력:
1번 컴퓨터가 웜 바이러스에 걸렸을 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 첫째 줄에 출력
*/

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited; // 방문 기록 배열
    static ArrayList<Integer>[] a; // 노드 담은 인접 리스트
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 컴퓨터의 수
        int m = Integer.parseInt(br.readLine()); // 간선의 수
        visited = new boolean[n + 1];
        a = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = new ArrayList<>(); // 현재 노드마다 연결노드 담을 인접리스트 생성
        }
        for (int i = 1; i <= m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            a[s].add(e); // 무방향 그래프이므로 예시) a[1] = {2}, a[2] = {1}
            a[e].add(s);
        }
        System.out.println(dfs(1));
    }
    public static int dfs(int v) {
        visited[v] = true;
        for (int i : a[v]) {
            if (!visited[i]) {
                cnt++;
                dfs(i);
            }
        }
        return cnt;
    }
}

