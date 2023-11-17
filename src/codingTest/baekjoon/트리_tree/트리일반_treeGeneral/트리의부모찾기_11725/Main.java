package codingTest.baekjoon.트리_tree.트리일반_treeGeneral.트리의부모찾기_11725;

/*
1. 문제: 루트 없는 트리가 주어진다. 이때, 트리의 루트를 1이라고 정했을 때, 각 노드의 부모를 구하는 프로그램을 작성하시오.
2. 입력:
첫째 줄에 노드의 개수 N (2 ≤ N ≤ 100,000)
둘째 줄부터 N-1개의 줄에 트리 상에서 연결된 두 정점
3. 출력:
첫째 줄부터 N-1개의 줄에 각 노드의 부모 노드 번호를 2번 노드부터 순서대로 출력
*/

import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static ArrayList<Integer>[] tree;
    static int[] ans;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 노드 수(2<=n<=100000)

        // 초기화
        tree = new ArrayList[n+1];
        visited = new boolean[n+1];
        ans = new int[n+1];

        for(int i=1; i<=n; i++){
            tree[i] = new ArrayList<>();
        }

        for(int i=1; i<n; i++){
            StringTokenizer st =  new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            tree[s].add(e);
            tree[e].add(s);
        }
        dfs(1);
        for(int i=2; i<=n; i++){
            System.out.println(ans[i]);
        }
    }
    static void dfs(int i){
        visited[i] = true;
        for(int k: tree[i]){
            if(!visited[k]){
                ans[k] = i;
                dfs(k);
            }
        }
    }
}
