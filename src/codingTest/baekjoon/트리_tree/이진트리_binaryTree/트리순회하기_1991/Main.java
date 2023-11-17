package codingTest.baekjoon.트리_tree.이진트리_binaryTree.트리순회하기_1991;

/*
* 1. 시간제한:2초
* 2. 입력:
* (1): 이진 트리의 노드의 개수 N(1 ≤ N ≤ 26)
* (2~n): 각 노드와 그의 왼쪽 자식 노드, 오른쪽 자식 노드가 주어진다.
* 3. 출력:
* 첫째 줄에 전위 순회, 둘째 줄에 중위 순회, 셋째 줄에 후위 순회한 결과를 출력
* */

import java.io.*;
import java.util.*;
public class Main {
    static int[][] tree;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 노드수
        sc.nextLine();
        tree = new int[26][2];
        for(int i=0; i<n; i++){
            String[] temp = sc.nextLine().split(" ");
            int node = temp[0].charAt(0) - 'A';
            char left = temp[1].charAt(0);
            char right = temp[2].charAt(0);
            // 자식 노드가 없을 때 -1 저장 하기
            if(left == '.'){
                tree[node][0] = -1;
            } else {
                tree[node][0] = left - 'A';
            }
            if(right == '.'){
                tree[node][1] = -1;
            } else {
                tree[node][1] = right - 'A';
            }
        }
        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);
        System.out.println();


    }
    public static void preOrder(int now){ // 0,1,2
        if(now == -1)
            return;
        System.out.print((char) (now + 'A')); // 1.현재노드
        preOrder(tree[now][0]);               // 2.왼쪽 탐색하기, 1
        preOrder(tree[now][1]);               // 3.오른쪽 탐색, 2
    }
    public static void inOrder(int now){
        if(now == -1)
            return;
        inOrder(tree[now][0]);                  // 1.왼쪽 탐색
        System.out.print((char) (now + 'A')); // 2.현재노드
        inOrder(tree[now][1]);                  // 3.오른쪽 탐색
    }
    public static void postOrder(int now){
        if(now == -1)
            return;
        postOrder(tree[now][0]); // 1.왼쪽 탐색하기
        postOrder(tree[now][1]); // 2.오른쪽 탐색하기
        System.out.print((char) (now + 'A')); // 3.현재노드
    }
}
