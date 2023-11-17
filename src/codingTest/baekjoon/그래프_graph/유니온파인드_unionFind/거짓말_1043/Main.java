package codingTest.baekjoon.그래프_graph.유니온파인드_unionFind.거짓말_1043;

/*
시간제한: 2초
입력:
(1): 사람의 수, n, 파티의 수, m
(2): 진실을 아는 사람의 수, 그 개수만큼 사람들의 번호
(3~m): 각 파티마다 오는 사람의 수와 번호
조건:
n,m<=50
*/

// https://www.acmicpc.net/problem/1043

import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    static int[] truth;
    static List<int[]> partyList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 사람의 수
        int m = Integer.parseInt(st.nextToken()); // 파티의 수
        // 초기화
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        // 진실을 아는 사람 정보 받기
        st = new StringTokenizer(br.readLine());
        int truthNum = Integer.parseInt(st.nextToken());

        if (truthNum == 0) { // 그 다음이 0이면
            System.out.println(m);
            System.exit(0);
        } else { // 0이 아니면
            truth = new int[truthNum];
            for (int i = 0; i < truthNum; i++) {
                truth[i] = Integer.parseInt(st.nextToken());
            }
        }
        // 파티 참석 사람들 받기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int partyNum = Integer.parseInt(st.nextToken());
            if (partyNum == 0) {
                partyList.add(new int[]{}); // 빈 배열 추가
                continue;
            }
            int[] tmp = new int[partyNum];
            int first = Integer.parseInt(st.nextToken());
            tmp[0] = first;
            for (int j = 1; j < partyNum; j++) {
                int others = Integer.parseInt(st.nextToken());
                tmp[j] = others;
                if (first < tmp[j]) union(first, others);
                else union(others, first);
            }
            partyList.add(tmp);
        }
        int ans = 0;

        for (int[] tmp : partyList) {
            boolean flag = false;
            for (int othrs : tmp) {
                if (!check(othrs)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) ans++;
        }
        System.out.println(ans);
    }
    public static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x!=y){
            if(x>y) parent[x] = y;
            else parent[y] = x;
        }
    }
    public static boolean check(int x){
        x = find(x);
        for(int othrs : truth){
            if(x == find(othrs)) return false;
        }
        return true;
    }
}

