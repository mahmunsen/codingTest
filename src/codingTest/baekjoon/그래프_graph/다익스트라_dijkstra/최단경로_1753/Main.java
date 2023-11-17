package codingTest.baekjoon.그래프_graph.다익스트라_dijkstra.최단경로_1753;

/*
* 1.문제: 방향그래프가 주어지면 주어진 시작점에서 다른 모든 정점으로의 최단 경로를 구하는 프로그램을 작성하시오.
* 단, 모든 간선의 가중치는 10 이하의 자연수
*
* 2.입력:
* (1): 정점의 개수 V와 간선의 개수 E, (1 ≤ V ≤ 20,000, 1 ≤ E ≤ 300,000)
* (2): 둘째 줄에는 시작 정점의 번호 K(1 ≤ K ≤ V)
* (3~e): 세 개의 정수 (u, v, w)가 순서대로, u에서 v로 가는 가중치 w인 간선이 존재함
* u와 v는 서로 다르며 w는 10 이하의 자연수
*
* 3.출력:
* (1~v): i번째 줄에 i번 정점으로의 최단 경로의 경로값을 출력
* 시작점 자신은 0으로 출력하고, 경로가 존재하지 않는 경우에는 INF를 출력
 * */

import java.io.*;
import java.util.*;
public class Main {
    static int V, E, K;
    static int distance[];
    static boolean visited[];
    static ArrayList<Edge> list[];
    static PriorityQueue<Edge> q = new PriorityQueue<Edge>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken()); // 정점의 수, (1 ≤ V ≤ 20,000, 1 ≤ E ≤ 300,000)
        E = Integer.parseInt(st.nextToken()); // 간선의 수, K(1 ≤ K ≤ V)
        K = Integer.parseInt(br.readLine());  // 시작정점의 번호

        distance = new int[V + 1];
        visited = new boolean[V + 1]; // 방문배열
        list = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) { // 각 노드의 인접리스트 초기화
            list[i] = new ArrayList<Edge>();
        }
        for (int i = 1; i <= V; i++) { // 각 노드를 최대값으로 초기화
            distance[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < E; i++) { // 가중치가 있는 인접리스트 초기화하기
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Edge(v, w)); // list[1] = [Edge(2,2), Edge(3,3)]
        }
        // 큐에 엣지(1,0) 추가
        q.add(new Edge(K,0));
        distance[K] = 0; // 거리 초기화
        Edge current = q.poll();
        int c_v = current.vertex;

        while(!q.isEmpty()){
            if(visited[c_v]) continue;
            visited[c_v] = true;

            for(int i=0; i<list[c_v].size(); i++){
                Edge tmp = list[c_v].get(i);
                int next = tmp.vertex;
                int value = tmp.value;
                if(distance[next] > distance[c_v] + value){
                    distance[next] = distance[c_v] + value;
                    q.add(new Edge(next, distance[next]));
                }
            }
        }
        for(int i=1; i<=V; i++){
            if(visited[i]) System.out.println(distance[i]);
            else System.out.println("INF");
        }
    }
}
    class Edge implements Comparable<Edge> { // Comparable 인터페이스: 객체 간의 순서 정의하는데 사용됨
        int vertex, value;
        Edge(int vertex, int value) {
            this.vertex = vertex;
            this.value = value;
        }
        public int compareTo(Edge e){ // PriorityQueue 클래스에서 큐의 요소를 정렬하는 데 사용됨
            if(this.value > e.value) return 1; // 현재 객체의 value가 다른 객체의 value보다 크면 메서드는 1을 반환
            else return -1;
    }
}



