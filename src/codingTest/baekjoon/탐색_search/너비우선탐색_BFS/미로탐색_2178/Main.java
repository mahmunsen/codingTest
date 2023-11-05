package codingTest.baekjoon.탐색_search.너비우선탐색_BFS.미로탐색_2178;

/*
1. 시간제한: 1초
2. 문제: N×M크기의 배열로 표현되는 미로, 1: 이동가능, 0: 이동불가, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하기, 서로 인접한 칸으로만 이동
3. 입력:
(1): 두 정수 N, M(2 ≤ N, M ≤ 100)
(2~n): M개의 정수로 미로가 주어짐
4. 출력:
(1): 지나야 하는 최소의 칸 수를 출력
*/

import java.io.*;
import java.util.*;
public class Main {
    static int[] dx = {0, 1, 0, -1}; // 상하좌우 탐색 위한 define값 정의 변수
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited; // 방문 기록 배열
    static int n, m;
    static int[][] a;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[n][m];
        visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for(int j=0; j<m; j++){
                a[i][j] = Integer.parseInt(line.substring(j, j+1));
            }
        }
        bfs(0,0);
        System.out.println(a[n-1][m-1]); // 인덱스가 0부터 시작해서 -1 해준다.
    }
    private static void bfs(int i, int j){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i,j}); // 큐 자료구조에 노드 삽입, {0,0}
        visited[i][j] = true; // 초기화
        while (!queue.isEmpty()){  // 큐가 비어있을 때까지
            int now[] = queue.poll(); // 큐에서 노드 데이터 가져오기
            for(int k=0; k<4; k++){  // 상하좌우로 탐색
                int x = now[0] + dx[k];  // 0 + 0/1/-1/0
                int y = now[1] + dy[k];  // 0 + 1/0/0/-1
                if(x >= 0 && y >= 0 && x < n && y < m){ // 배열을 넘어가면 안됨
                    if(a[x][y]!=0 && !visited[x][y]){ // 0이여서 갈수 없거나 이미 방문한 배열이면 안됨
                        // 이제 탐색 가능한 곳
                        visited[x][y] = true;
                        a[x][y] = a[now[0]][now[1]] + 1; // 그 직전의 위치, now[0], now[1]를 넣어주고 depth 보다 +1 크게.
                        queue.add(new int[] {x, y});
                    }
                }
            }
        }
    }
}
