package codingTest.baekjoon.정렬_sorting.선택정렬_selectionSort.세수_10817;
/*
시간제한: 1초
문제:
세 정수 A, B, C가 주어진다. 이때, 두 번째로 큰 정수를 출력
(1 ≤ A, B, C ≤ 100)
*/
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] a = new int[3];
        for(int i=0; i<3; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<2; i++){
            int min = i;

            for(int j=i+1; j<3; j++){
                if(a[j] < a[min]){
                    min =j;
                }
            }
            int temp = a[min];
            a[min] = a[i];
            a[i] = temp;
        }
        bw.write(String.valueOf(a[1]));
        bw.flush();
        bw.close();
    }
}
