#### 문자열 배열 → 정수 배열로 캐스팅하는 방법:

1) for문 이용: charAt()
2) stream 사용: stream().mapToInt()

`1) charAt(i) - '0' 사용하는 이유`

- charAt()은 String 타입으로 받은 문자열을 char타입으로 한 글자만 받게 해주는 함수이다.
    * ex) String 타입 "54321" → charAt(0)은 "5", charAt(1)은 "4", 이런식이 된다. 
  
- 그런데 결국 int 타입 5 가 아닌 char 타입 "5" 이기 때문에 <u>**int로 바꿔주려면 아스키코드로 변환된다.**</u>
- 아스키코드는 10진법으로 여기서 문자열'0'은 숫자 48과 같다.
- 따라서 '0' 또는 48을 빼주어야 의도된 결과를 얻을 수 있다.

        String n = "123";

        n.charAt(0); // 1
        n.charAt(1); // 2
        n.charAt(2); // 3

        (int)n.charAt(0) + (int)n.charAt(1) // 49 + 50 = 99

        '0'(char) => 48 
        '1'(char) => 49
        '2'(char) => 50

<details>
<summary> 위에서  - '0'(48)을 해줘야 원하는 숫자가 나온다. </summary>
<div markdown="1">

        n.charAt(0)-'0' = 49-48 = 1
        n.charAt(1)-'0' = 50-48 = 2

</div>
</details>

<cite>참고</cite> --- https://yeoncoding.tistory.com/418 



