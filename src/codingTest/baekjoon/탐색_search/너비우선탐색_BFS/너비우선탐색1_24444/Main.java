package codingTest.baekjoon.탐색_search.너비우선탐색_BFS.너비우선탐색1_24444;

/*
1. 시간제한: 1초 -> 1억 연산 이내, 시간초과로 n^2는 불가.
2. 문제:
N개의 정점과 M개의 간선으로 구성된 무방향 그래프
정점 번호는 1번부터 N번이고 모든 간선의 가중치는 1
정점 R에서 시작하여 너비 우선 탐색으로 노드를 방문할 경우 노드의 방문 순서를 출력하자.
3. 입력:
(1): 정점의 수 N (5 ≤ N ≤ 100,000), 간선의 수 M (1 ≤ M ≤ 200,000), 시작 정점 R (1 ≤ R ≤ N)
(2~m): 간선 정보 u v, 정점 u와 정점 v의 가중치 1인 양방향 간선, (1 ≤ u < v ≤ N, u ≠ v)
4. 출력:
- 첫째 줄부터 N개의 줄에 정수를 한 개씩 출력
- i번째 줄에는 정점 i의 방문 순서를 출력
- 시작 정점의 방문 순서는 1, 시작 정점에서 방문할 수 없는 경우 0을 출력
*/

import java.io.*;
import java.util.*;
public class Main {
    static int[] visited;
    static ArrayList<Integer>[] a;
    static int n, m, r;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 정점의 수
        m = Integer.parseInt(st.nextToken()); // 간선의 수
        r = Integer.parseInt(st.nextToken()); // 시작 정점
        // 초기화
        visited = new int[n+1];
        a = new ArrayList[n+1];
        for(int i=1; i<=n; i++){ // 노드마다 인접리스트 생성
            a[i] = new ArrayList<>();
        }
        for(int i=1; i<=m; i++){  // 인접리스트에 데이터 담기
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            a[s].add(e);
            a[e].add(s);
        }
        for(int i=1; i<=n; i++){
            Collections.sort(a[i]);
        }
        bfs(r);
        for(int i=1; i<=n; i++){
            bw.write(String.valueOf(visited[i]) + "\n");
            bw.flush();
        }
    }
    public static void bfs(int r){
        Queue<Integer> q = new LinkedList<>();
        int cnt = 1;
        q.offer(r); // 1) 큐에 노드 삽입
        visited[r] = cnt++; // 2) 방문기록
        while (!q.isEmpty()){ // 3) 큐가 빌때까지 큐에서 노드 데이터 가져온다
            int k = q.poll();
            for(int i=0; i<a[k].size(); i++){ // 3) 노드의 인접리스트 방문
                int p = a[k].get(i);
                if(visited[p]!=0){
                    continue;}
                    q.offer(p);   // 각 요소들을 큐에 삽입
                    visited[p] = cnt++; // visited에 기록
            }
        }
    }
}

/**
 *
 * visited[r] = cnt++;
 *
 * 위 코드는 다음과 같이 두 단계로 구성됨.
 * 1) visited[r]에 cnt를 저장
 * 2) cnt에 기존에 저장되어 있던 값에 +1 더해서 업데이트(cnt++ => "cnt = cnt+1")
 *
 * */