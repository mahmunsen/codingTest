package codingTest.baekjoon.트리_tree.세그먼트트리_indexTree.구간합구하기3_2042;

/*
* 시간제한: 2초
* 입력:
(1): N(1 ≤ N ≤ 1,000,000)과 M(1 ≤ M ≤ 10,000), K(1 ≤ K ≤ 10,000)
(N+2번째 줄부터 N+M+K+1번째 줄까지): 세 개의 정수 a, b, c가 주어지는데, a가 1인 경우 b(1 ≤ b ≤ N)번째 수를 c로 바꾸고 a가 2인 경우에는 b(1 ≤ b ≤ N)번째 수부터 c(b ≤ c ≤ N)번째 수까지의 합을 구하여 출력
* 출력: 첫째 줄부터 K줄에 걸쳐 구한 구간의 합을 출력
* */

//import java.util.*;
//import java.io.*;
//
//public class Main {
//    static long[] tree;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken()); // 수의 개수
//        int m = Integer.parseInt(st.nextToken()); // 수의 변경횟수
//        int k = Integer.parseInt(st.nextToken()); // 구간합 구하는 횟수
//        int treeHeight = 0;
//        int length = n; // n의 값을 이용, n의 값이 바뀌면 안되므로 length에 저장
//        while (length != 0) {
//            length /= 2;
//            treeHeight++;
//        }
//        int treeSize = (int) Math.pow(2, treeHeight + 1); // 2^k >= n을 만족시키는 k, 2^k*2
//        int leafNodeStartIndex = treeSize / 2 - 1; // 리프노드 시작 인덱스
//        tree = new long[treeSize + 1]; // 0인덱스 안쓸 예정, 17
//        // 데이터를 리프노드에 입력받기
//        for (int i = leafNodeStartIndex + 1; i <=leafNodeStartIndex + n; i++) { // 8~13
//            tree[i] = Long.parseLong(br.readLine());
//        }
//        setTree(treeSize - 1); // 15, 16이 아닌 이유는 원본 배열이 인덱스 8부터 시작
//        for (int i = 0; i < m + k; i++) {
//            st = new StringTokenizer(br.readLine());
//            long a = Integer.parseInt(st.nextToken());
//            int s = Integer.parseInt(st.nextToken());
//            long e = Long.parseLong(st.nextToken());
//            if (a == 1) {  // 수 바꾸기, 업데이트
//                changeVal(leafNodeStartIndex + s, e); // 리프노드 시작인덱스에 +s을 더해줘야 진짜 위치, 이 위치에 값을 e로 교체
//            } else if (a == 2) {  // 구간합 구하기
//                s = s + leafNodeStartIndex;
//                e = e + leafNodeStartIndex;
//                System.out.println(getSum(s, (int) e));
//            } else {
//                return;
//            }
//        }
//        br.close();
//    }
//    private static long getSum(int s, int e){ // 9~12
//        long partSum = 0;
//        while (s <= e){
//            if(s % 2 == 1){ // 오른쪽에 위치
//                partSum = partSum + tree[s];
//                s++;
//            }
//            if(e % 2 == 0){ // 왼쪽에 위치
//                partSum = partSum + tree[e];
//                e--;
//            }
//            s = s/2;
//            e = e/2;
//        }
//        return partSum;
//    }
//    // 값 업데이트
//    private static void changeVal(int index, long val){ // index:10
//        long diff = val - tree[index]; // 차이
//        while (index > 0){
//            tree[index] = tree[index] + diff; // tree[10] = 6
//            index = index/2;
//        }
//    }
//
//    // 일차원 배열에 구간합 채워넣기
//    private static void setTree(int i){
//        while (i!=1){
//            tree[i/2] += tree[i]; // tree[7]=tree[15], tree[7]=tree[14]
//            i--;
//        }
//    }
//}

//import java.util.*;
//import java.io.*;
//
//public class Main {
//    static long[] tree;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken()); // 수의 개수
//        int m = Integer.parseInt(st.nextToken()); // 수의 변경횟수
//        int k = Integer.parseInt(st.nextToken()); // 구간합 구하는 횟수
//        int treeHeight = 0;
//
//        int h = (int) Math.ceil(Math.log(n)/Math.log(2)) + 1;
//        int treeSize = (int) Math.pow(2, h); // 2^k >= n을 만족시키는 k, 2^k*2
//        int leafNodeStartIndex = treeSize / 2 - 1; // 리프노드 시작 인덱스
//        tree = new long[treeSize + 1]; // 0인덱스 안쓸 예정, 17
//        // 데이터를 리프노드에 입력받기
//        for (int i = leafNodeStartIndex + 1; i <=leafNodeStartIndex + n; i++) { // 8~13
//            tree[i] = Long.parseLong(br.readLine());
//        }
//        setTree(treeSize - 1); // 15, 16이 아닌 이유는 원본 배열이 인덱스 8부터 시작
//        for (int i = 0; i < m + k; i++) {
//            st = new StringTokenizer(br.readLine());
//            long a = Integer.parseInt(st.nextToken());
//            int s = Integer.parseInt(st.nextToken());
//            long e = Long.parseLong(st.nextToken());
//            if (a == 1) {  // 수 바꾸기, 업데이트
//                changeVal(leafNodeStartIndex + s, e); // 리프노드 시작인덱스에 +s을 더해줘야 진짜 위치, 이 위치에 값을 e로 교체
//            } else if (a == 2) {  // 구간합 구하기
//                s = s + leafNodeStartIndex;
//                e = e + leafNodeStartIndex;
//                System.out.println(getSum(s, (int) e));
//            } else {
//                return;
//            }
//        }
//        br.close();
//    }
//    private static long getSum(int s, int e){ // 9~12
//        long partSum = 0;
//        while (s <= e){
//            if(s % 2 == 1){ // 오른쪽에 위치
//                partSum = partSum + tree[s];
//                s++;
//            }
//            if(e % 2 == 0){ // 왼쪽에 위치
//                partSum = partSum + tree[e];
//                e--;
//            }
//            s = s/2;
//            e = e/2;
//        }
//        return partSum;
//    }
//    // 값 업데이트
//    private static void changeVal(int index, long val){ // index:10
//        long diff = val - tree[index]; // 차이
//        while (index > 0){
//            tree[index] = tree[index] + diff; // tree[10] = 6
//            index = index/2;
//        }
//    }
//
//    // 일차원 배열에 구간합 채워넣기
//    private static void setTree(int i){
//        while (i!=1){
//            tree[i/2] += tree[i]; // tree[7]=tree[15], tree[7]=tree[14]
//            i--;
//        }
//    }
//}


import java.util.*;
import java.io.*;

public class Main {
    static long[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 수의 개수
        int m = Integer.parseInt(st.nextToken()); // 수의 변경횟수
        int k = Integer.parseInt(st.nextToken()); // 구간합 구하는 횟수

        int h = (int) Math.ceil(Math.log(n)/Math.log(2)) + 1;
        int treeSize = (int) Math.pow(2, h); // 2^k*2
        int leafNodeStartIndex = treeSize / 2 - 1; // 리프노드 시작 인덱스 7
        tree = new long[treeSize + 1];
        // 데이터를 리프노드에 입력받기
        for (int i = leafNodeStartIndex +1; i <=leafNodeStartIndex + n; i++) { // 9~13
            tree[i] = Long.parseLong(br.readLine());
        }
        setTree(treeSize - 1);
        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            long e = Long.parseLong(st.nextToken());
            if (a == 1) {  // 수 바꾸기, 업데이트
                changeVal(leafNodeStartIndex + s, e);
            } else if (a == 2) {  // 구간합 구하기
                s = leafNodeStartIndex + s;
                e = leafNodeStartIndex + e;
                long sum = getSum(s, (int) e);
                System.out.println(sum);
            } else {
                return;
            }
        }
        br.close();
    }
    private static long getSum(int s, int e){
        long partSum = 0;
        while(s<=e){
            if(s%2 == 1){
                partSum += tree[s];
                s++;
            }
            if(e%2 == 0){
                partSum += tree[e];
                e--;
            }
            s = s/2;
            e = e/2;
        }
        return partSum;
    }
    // 값 업데이트
    private static void changeVal(int index, long val){
        long diff = val - tree[index]; // 차이
        while (index > 0){
            tree[index] = tree[index] + diff;
            index = index/2;
        }
    }

    // 일차원 배열에 구간합 채워넣기
    private static void setTree(int i){
        while (i!=1){
            tree[i/2] += tree[i];
            i--;
        }
    }
}