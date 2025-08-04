package step2;

// 인터페이스
public class Solution11 {
    public static void main(String[] args) {
        Runnable[] arr = {new Dog(), new Human()};
        for (Runnable r : arr) {
            r.run();
            if (r instanceof Cute) {
                ((Cute) r).doCute(); // 캐스팅
            } else if (r instanceof Talkable) {
                ((Talkable) r).talk();
            }
        }
    }
}

class Dog implements Runnable, Cute {

    @Override
    public void run() {
        System.out.println("개가 뛴다");
    }

    @Override
    public void doCute() {
        System.out.println("개는 귀엽다");
    }
}

// implements -> 구현 (상속 X) 여러개 붙일 수 있음
class Human implements Runnable, Talkable {

    @Override
    public void run() {
        System.out.println("사람이 뛴다");
    }

    @Override
    public void talk() {
        System.out.println("사람은 말한다");
    }
}

// 인터페이스 -> 자체적으로 static한 필드(변수)는 가질 수 있는데, 원칙적으로 추상화된 (구현을 강제하는)
// 메서드들의 묶음.
// Java 8+. default. private.
interface Runnable {
    String ex = "R"; // public static final
    void run();
    default void runToYou() {
        System.out.println("무언가...");
    }
}

interface Talkable {
    String ex = "T";
    void talk();
}

interface Cute {
    String ex = "C";
    void doCute();
}


// 1. 완전히 상속? 관계는 아닌데 비슷한 기능을 공유하고, 그 기능이 구현되어 있음
// - Car 달린다, Human 달린다 (run) -> 둘이 '상속'했나요?
// - 뭔가 '속성(멤버변수)'를 공유하는 건 아닌데... 결과적으로 같은 '작동'.
// 2. 재활용성을 높이기 위해 추상화를 하는데... Abstract 클래스는 클래스라 1개만 붙일 수 있음.
// -> 여러개 붙여서... 조립형으로 무언가를 만들고 싶을 수 있음.

// 클래스 : 인스턴스라는 것의 설계도. (객체를 만들어줌)
// - 멤버(인스턴스) 변수
// - 메서드들 => 생성될 때 / 사용하려면 할당.대입.
// - 클래스 자체에 귀속된 static, static 변수 (필드), static 메서드
// 추상클래스 (상속)
// 무언가 정해져있는 모양. 그 모양에서 약간씩 다를 경우. Filter AFilter BFilter.
// - 직접 생성자로 못 만듦.
// - 이것을 통해서 작성된 클래스가 개별 생성자를 가져야함 (안 작성하면 기본 생성자)
// - 추상메서드를 구현하도록 강제한다.
// -> 일단 공통적으로 사용할 기본 메서드를 구현할 수도 있고, 필요하면 추상으로 바꿀 수도 있다.
// - 나머지는 거의 같음.
// 인터페이스 -> 클린 아키텍쳐 => 레이어 (층위) => 그 층들간의 소통을 '인터페이스'. // 화면 <-> DB
// 완전히 추상화된 상태(둘이 서로를 모른다는 가정)에서는 인터페이스.
// - 직접 생성자 X. (기본적으로 모든게) 추상 메서드를 구현하도록 강제. 필요하다면 default를 둘 수 있다.
// - 다중 구현
// - 멤버 변수 X. (static만 존재)
// 구현? -> 상속, 구현 => spec(구현해야되는 세부 사항들...)
// Spring, JPA -> 사용하는 라이브러리가 정해줘요.