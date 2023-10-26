package codingTest.baekjoon.그래프_graph.그래프의표현.이분그래프판별하기_1707;



/** 이분 그래프: 인접한 노드들을 인접하기 않은 두 집합으로 나눌 수 있을 때.
 * 집합: A - B - A (A - A - A가 아니라 노드1과 노드2는 각각 서로 다른 집합에 속해야 한다)
 * 노드: 1 - 2 - 3
 * */

// 시간제한: 2초
// 이분 그래프 판별하기
/* 입력: (1): 테스트 케이스의 개수, k, 2 ≤ k ≤ 5
 *       (각 케이스 첫째줄): 그래프 정점의 개수, v, 간선의 개수, e 주어짐, 1 ≤ v ≤ 20,000, 1 ≤ e ≤ 200,000
 *       (각 케이스 둘째줄 ~ e줄): 간선에 대한 정보, 인접한 두 정점의 번호, u,v(!u=v) 주어짐
 *  출력: 주어진 그래프가 이분 그래프이면 YES, 아니면 NO 출력
 *
 * */

// 1-3-2
// 인접리스트 이용, 무방향 그래프
/* 어떻게 판별? 이미 방문한 노드를 만났을 때 같은 집합이면 NO -> break
 *            다른 집합이면 YES
 * */
// 모든 노드를 기점으로 dfs 실시해야 <- 그래프가 끊어져 있을 수도 있기 때문


import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] a;
    static int[] check;
    static boolean[] visited; // 방문 여부 판별
    static boolean isBiprt;   // 이분 그래프 여부
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine()); // 테스트 케이스 받기
        for (int t = 0; t < testCase; t++) { // 테스트 케이스만큼 돌린다
            String[] s = br.readLine().split(" "); // 빈칸을 두고 split
            int v = Integer.parseInt(s[0]); // 노드 받기
            int e = Integer.parseInt(s[1]); // 간선 받기

            // 초기화
            a = new ArrayList[v + 1]; // 각 노드를 담는 인접리스트, 인덱스 0을 쓰지 않을 것이기 때문에, 크기가 v+1
            visited = new boolean[v + 1];
            check = new int[v + 1];
            isBiprt = true;

            // 각 노드마다 각자의 인접리스트 생성
            for (int i = 1; i <= v; i++) {
                a[i] = new ArrayList<Integer>(); // a[1], a[2], a[3]
            }
            // 엣지 정보 저장
            for (int i = 0; i < e; i++) {
                s = br.readLine().split(" ");
                int start = Integer.parseInt(s[0]); // 시작노드, 1,2
                int end = Integer.parseInt(s[1]);   // 끝노드, 3,3
                // 무방향이어서 아래와 같이 저장
                a[start].add(end); // a[1] = [3]
                // a[2] = [3]
                a[end].add(start); // a[3] = [1,2]
            }
            // 모든 노드에서 DFS시작.
            for (int i = 1; i <= v; i++) {
                if (isBiprt) {
                    dfs(i);
                } else break;
            }
            if (isBiprt) System.out.println("YES");
            else System.out.println("NO");
        }
    }
   private static void dfs(int start){
        visited[start] = true; // 초기화, visited[1] = true, visited[3]
        for(int i : a[start]){ // start에서 연결된 모든 노드를 탐색, i(3) : a[1]
            if(!visited[i]){  // 방문한 노드가 아니면
                // 바로 직전에 있는 노드와 다른 집합으로 분류를 해줌
                check[i] = (check[start] + 1) % 2;  // check[3] = 1
                dfs(i);
            } else if(check[start] == check[i]){ // 방문한 노드일 때
                    isBiprt = false;
            }
        }
   }
}

