package codingTest.baekjoon.자료구조_dataStructure.배열과리스트_arrayAndList.숫자의합구하기_11720;

// 1초
// 입력: (1): 숫자의 개수, n, 1<=n<=100
//      (2): 숫자 n, 공백없이 주어짐
import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 숫자개수
        String m = sc.next(); // 숫자
        int[] num = new int[n];
        int ans = 0;
        for(int i=0; i<m.length(); i++){
            num[i] = m.charAt(i) - 48; // char 53이 int의 5와 같다, -48해줘야 의도대로 된다.
            ans += num[i];
        }
        System.out.println(ans);
    }
}
