package step1;

// String, final, instanceof, NullPointerException
public class Solution06 {
    // String?
    public static void main(String[] args) {
        char c = 'a'; // 한 글자. 그리고 ASCII. UTF-8?
        // 문자 -> 여러개의 문자를 엮을 때? 문자 배열을 만든다 char[]?
        // C언어. -> 문자배열 -> 문자열. 줄 -> String.
        String s = "abcd"; // 본질적으로? 문자의 배열. -> 객체(참조 타입)
        // 대문자로 시작하는 클래스를 기반으로한 타입. 조회시 '기본적으로'는 주소값이 나와야하는데...
        System.out.println(s); // 자동으로 내부에 있는 문자들을 하나로 엮어서 표시 설정.
        char[] cArr = new char[5];
        // 어쨌든 배열이라 편의 기능 X. replace, trim... 문자열용 메서드들. 사용할 수 없음.
        cArr[0] = 'a';
        cArr[1] = 'b';
        cArr[2] = 'c';
        cArr[3] = 'd';
        cArr[4] = 'e';
        System.out.println(cArr);
        System.out.println(System.identityHashCode(cArr));
        String abcde = "abcde";
        System.out.println(abcde);
        System.out.println(System.identityHashCode(abcde));
        cArr[2] = 'f';
        System.out.println(cArr);
        System.out.println(System.identityHashCode(cArr));
        abcde = abcde.replace('c', 'f');
        System.out.println(abcde);
        System.out.println(System.identityHashCode(abcde));
//        abcde.toCharArray() -> 문자배열로 전환도 가능.
        // String 같은 경우에는 '부분만 수정해서 원본을 보존하는 방법'이 없음.
        // "..." -> 객체인데 생성자 없죠? 특수 생성 문법. -> 캐싱(임시저장) -> 썼던 걸 불러올 수 있음.
        // Scanner 입력을 받거나 '+'로 합성해서 비슷한게 만들지면 '다르다'라고 인식됨 ==.
        // equals.
        // 알고리즘 같은 거 할 때 -> String으로 하면 무조건 시간 오버. StringBuffer.
        // 문자열을 반복하는 법
        for (char ch : abcde.toCharArray()) {
            System.out.println(ch); // 좀 더 빠르고, 메모리도 덜 먹고.
        }
        for (String v : abcde.split("")) {
            System.out.println(v);
        }
    }
}