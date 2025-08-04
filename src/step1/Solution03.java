package step1;

import java.util.Random;

// 생성자, 메서드, this
public class Solution03 {
    public static void main(String[] args) {
        // static -> 별도 메모리
        Solution03 sol = new Solution03();
        // 내 설계도로 static에다가 객체를 만드는...
        // static 메서드
        // new -> 메모리에다가 기록.
        System.out.println(sol.random);
        System.out.println(sol.random2);
        System.out.println(sol.random3);
    }

    String hello = "안녕하세요."; // 초기화는 가능
    int random;
    int random2;
    int random3;

    // 생성자 (내가 별도로 지정 안해도 기본 생성자 만들어짐)
    public Solution03(){
//        super();
        Random rd = new Random(); // 직접 대입하려면 이런 변수를 개수만큼 호출.
        random = rd.nextInt(100);
        // 복잡한 코드로도 (여러줄로) 변수에 작업을 하듯이
        // 멤버변수에도 작억할 수 있게.. 넣어 줄 수 있음
        random2 = rd.nextInt(100);
        random3 = rd.nextInt(100);
    } // 우리가 안 만들어도 가지고 있는 기본 생성자
    // 생성할 때 쓰는 전용 기능.
}
