package codingTest.baekjoon.자료구조_dataStructure.스택_stack.스택으로오름차순수열만들기_1874;
// 2초
/* 문제: 스택에 push하는 순서는 반드시 오름차순,
        임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지, 있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지
* */
/* 입력: (1): n (1≤ n ≤100,000)
*       (2): 2~n번째 줄에 수열, 1이상 n이하의 정수가 하나씩, 같은 정수가 두번 나오지 X
* */
// 출력: 한 줄에 한 개씩 출력, push연산은 +로, pop 연산은 -로, 불가능한 경우 NO를 출력

import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // n, 수열 개수
        int[] a = new int[n]; // 빈 수열 배열 생성
        for(int i=0; i < a.length; i++){
            a[i] = sc.nextInt();
        }
        Stack<Integer> st = new Stack<>();
        int num = 1;
        boolean result = true;
        StringBuffer sb = new StringBuffer(); // 스택 담을 그릇
        for(int i=0; i < a.length; i++){
                if(a[i] >= num) {
                    while (a[i] >= num) {
                        st.push(num++);
                        sb.append("+\n");
                    }
                    st.pop();
                    sb.append("-\n");
                } else {
                    int k = st.pop();
                    if(k > a[i]) {
                        System.out.println("NO");
                        result = false;
                        break;
                    } else {
                        sb.append("-\n");
                    }
                }
        }
        if(result) System.out.println(sb.toString());
    }
}
