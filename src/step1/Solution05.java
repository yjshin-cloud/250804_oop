package step1;

// static
public class Solution05 {
    public static void main(String[] args) {
        // static -> main -> 객체(인스턴스)에 소속되지 않았다 (별도의 메모리를 쓴다)
        Test test1 = new Test();
        test1.name = "테스트11";
        test1.test(); // 테스트2 // counter 1
        Test.name2 = "테스트22"; // Class명.변수명(메서드명) -> 인스턴스를 만들지 않고도
        // 별도의 static 메모리에 들어가 있는... 호출 가능한.
        Test test2 = new Test();
        System.out.println(test2.name); // 테스트11? ❌ 테스트? ✅
        test2.test(); // 테스트22 // counter 2
    }
}

class Test {
    String name = "테스트";
    //    static String name = "테스트";
    static String name2 = "테스트2"; // 인스턴스에 묶여있지 않고, Test라는 클래스가 공유하는 변수
    static int counter = 0;

    void test() {
        counter++; // 인스턴스 간의 구분을 넘어서서 서로 호출.
        System.out.println(name2); // 클래스 내부에서는 static 자체로 호출 가능
        System.out.println("counter : " + counter);
    }
}