package codingTest.codility.firstUnique;

// time complexitiy: O(N)
// map의 getOrDefault(key, 0) : 찾는 key가 존재하면 key가 아니라 해당 key에 매핑되어 있는 값을 반환하고, 그렇지 않으면 디폴트 값이 반환됨.

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }
        int answer = solution(nums);
        System.out.println(answer);

    }

    public static int solution(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            int cnt = map.getOrDefault(i, 0); // 처음에는 map에 해당 키에 대한 값이 없으므로 0
            map.put(i, ++cnt); // map에 해당 키(숫자)와 +1을 넣어준다.
        }
        for(int i : nums){
            if(map.get(i) == 1){ // ex) key, 4에 대한 값이 1이면 return 4;
                return i;
            }
        }
       return -1;
    }
}


