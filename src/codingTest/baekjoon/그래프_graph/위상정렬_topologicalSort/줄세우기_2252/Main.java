package codingTest.baekjoon.그래프_graph.위상정렬_topologicalSort.줄세우기_2252;

/*
* 입력: N(1 ≤ N ≤ 32,000), M(1 ≤ M ≤ 100,000), M:키를 비교한 횟수
*/

import java.io.*;
import java.util.*;
// https://www.acmicpc.net/problem/2252
public class Main {
    static ArrayList<ArrayList<Integer>> a = new ArrayList<>();
    static int[] inDegree; // 진입차수 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // n명의 학생
        int m = Integer.parseInt(st.nextToken()); // 키를 비교한 횟수

        inDegree = new int[n+1];
        // n만큼 인접리스트 생성
        for(int i=0; i<=n; i++){
            a.add(new ArrayList<>());
        }
        // 방향성 설정
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()); // 선발
            int e = Integer.parseInt(st.nextToken()); // 후발
            a.get(s).add(e);
            inDegree[e]++;
        }
        Queue<Integer> q = new LinkedList<>();
        // 진입차수가 0인것 찾아 넣기
        for(int i=1; i<=n; i++){
            if(inDegree[i] == 0){
                q.offer(i);
            }
        }
        while (!q.isEmpty()){  // q가 빌 때까지
            int now = q.poll(); // 빠져나감
            System.out.print(now + " ");
            for(int next: a.get(now)){
                inDegree[next]--;
                if(inDegree[next] == 0){
                    q.offer(next);
                }
            }
        }
    }
}
