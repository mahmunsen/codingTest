package codingTest.baekjoon.탐색_search.깊이우선탐색_DFS.연결요소의개수_11724;
/*
1. 시간제한: 3초
2. 문제: 방향없는 그래프가 주어졌을 때, 연결 요소의 개수를 구하는 프로그램을 작성하라.
3. 입력:
(1): 정점의 개수 N, 간선의 개수 M, (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2)
(2~M): 간선의 양 끝점 u와 v가 주어짐 (1 ≤ u, v ≤ N, u ≠ v)
4. 출력:
첫째 줄에 연결 요소의 개수를 출력
*/

import java.io.*;
import java.util.*;
public class Main {
    static boolean[] visited; // 방문 배열 기록
    static ArrayList<Integer>[] a; // 정점 정보 담을 인접리스트
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 정점의 개수
        int m = Integer.parseInt(st.nextToken()); // 간선의 개수
        visited = new boolean[n+1]; // 인덱스 1부터 사용할 예정이라 n+1
        a = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            a[i] = new ArrayList<>(); // 각 노드마다 배열 생성
        }
        for(int i=1; i<=m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            a[s].add(e); // 무방향 그래프 -> 시작점에 끝점 더해주고, 끝점에 시작점 더해준다.
            a[e].add(s);
        }
        int cnt = 0;     // 연결 요소의 개수
        for(int i=1; i<=n; i++){
            if(!visited[i]){
                cnt++;
                dfs(i);
            }
        }
        System.out.println(cnt);
    }
    private static void dfs(int v){
        if(visited[v]){
            return;
        }
        visited[v] = true; // visited 배열에 현재 노드 방문 기록하기
        for(int i: a[v]){  // 현재 노드의 연결 노드 중
            if(!visited[i]){ // 방문하지 않는 노드로
                dfs(i);      // dfs 실행
            }
        }
    }
}
