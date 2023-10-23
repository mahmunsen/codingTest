package codingTest.baekjoon.탐욕알고리즘_greedyAlgorithm.주유소_13305;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

// 시간제한: 2초 -> 2억 연산 이내
// 리터당 가격이 낮은 도시에서 가장 많은 양의 리터 -> 총비용 낮게 나옴
/* 입력: (1): 도시의 개수, n, 2<= n <= 100,000, 정수
        (2): 도로간 길이들, n-1개, 자연수
        (3): 도시의 리터당 가격들, n개, 1<= 도시 간 총 거리 <= 1,000,000,000(10억), 1<= 리터당 가격 <= 1,000,000,000(10억) -> -2,147,483,648 < int형 < 2,147,483,647
* */
// 출력: 제일 왼쪽 도시에서 제일 오른쪽 도시로 가는 최소 비용

// 서브태스크는 뭐지..? 추가조건에 맞게 풀어보라는 건가? 원래의 제약조건 외에 아무런 제약 조건이 없다???
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 도시 개수
        int[] km = new int[n-1]; // 도시간 도로길이
        long sum = 0; // int형 데이터 범위를 넘어섬
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < km.length; i++) {
            km[i] = Integer.parseInt(st.nextToken());
        }
        int[] p = new int[n]; // 각 도시의 주유소 기름가격
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }
        // 기름 값이 내림차순일 경우 주유함 -> 5와 2 일때 주유, 1은 주유X
        int min = p[0]; // 최소값 초기화, 5
        for (int i = 0; i < p.length - 1; i++) {
             if (min > p[i]) {
                min = p[i]; // 최소값 업데이트
            }
            sum += min * km[i]; // (5*2) + (2*3) + (2*1)
        }
        System.out.println(sum);
    }
}