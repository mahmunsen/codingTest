package codingTest.baekjoon.자료구조_dataStructure.투포인터.좋다_1253;
// 2초
// 문제: N개의 수 중에서 어떤 수가 다른 수 두 개의 합으로 나타낼 수 있다면 그 수를 “좋다(GOOD)”고 한다.
// N개의 수가 주어지면 그 중에서 좋은 수의 개수는 몇 개인지 출력하라.
// 수의 위치가 다르면 값이 같아도 다른 수
/* 입력: (1): 수의 개수 N(1 ≤ N ≤ 2,000)
        (2): 두 번째 줄에는 i번째 수를 나타내는 Ai가 N개, |Ai| ≤ 1,000,000,000,정수
* */
// 출력: 좋은 수의 개수를 첫 번째 줄에 출력

/** 주의사항: [-2, 0, 1, 2] 음수 포함 가능, 0 + 2 = 2인데 "다른" 수 두 개의 합이어서 srt와 end가 i과 같아서는 안된다.
 *
 * srt, end가 조건에 맞게 변하므로 sum = a[srt]+a[end]로 미리 지정x
 *
 * */
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 수의 개수
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i < n; i++){ // 수들
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a); // 정렬
        int ans = 0;

        for(int i=0; i<n; i++){
            int srt = 0;
            int end = n-1;
            while (true){
                if(srt == i){
                    srt++;
                } else if (end == i) {
                    end--;
                }
                if(srt >= end){
                    break;
                }
                if(a[srt] + a[end] > a[i]){
                    end--;
                } else if(a[srt] + a[end] < a[i]){
                    srt++;
                } else {
                    ans++;
                    break;
                }
            }
        }
        System.out.println(ans);
    }
}

