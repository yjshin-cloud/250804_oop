package step1; // package 경로

// 외부에서 이 클래스를 어떻게 접근할지 말지...
// (접근제어자) class (클래스명) {}
public class Solution01 {
    // 클래스 -> 기능 -> 메서드.
    // (클래스 내부에서 미리 정의된 입/출력 관련 설정이 있는 코드 묶음 -> 메서드)
    // 클래스 내부에 포함된 함수(프로시저) -> 메서드
    public static void main(String[] args) {
        // 메인 메서드 -> java 파일을 실행했을 때 자동으로 찾아주는 메서드. (진입점)
        // String[] args -> 매개변수(parameter) -> 외부와 매개해주는 변수
        // 변수. -> 내부에서 선언 및 할당 (초기화) -> 지역변수. 블록 내부에서 선언할 경우
        // 블록 외부에서 (메서드 외부) -> 그 경우 사용하는 걸 매개변수
        // -> 매개변수를 통해서 전달받는 값 -> 인자(인수) (arguments)
        // 변수는 매개변수, 값은 인자(인수)
        // (입력) parameter - argument
        // (출력) -> "return" -> 반환
        // void(반환 타입) -> 변수에 넣을 때 타입 체크를 할 수 있게 하는데...
        // 꼭 변수에 들어갈 필요는 없음. 그래서 아예 변수 할당이 아닌 메서드의 경우에는 'void'
        // static -> 클래스를 통해서 객체를 만들지 않아도 클래스 관련해서 static 메모리하는 영역에 저장되어 있는 메서드. (별도의 메모리에 이미 탑재 - 저장되어 있다)
        Animal animal = new Animal(); // 인스턴스 => 클래스로 만들어진 객체
        // 메모리 -> 생성자
        System.out.println(animal); // 주소값 -> 어떤 클래스를 통해 만들어진 건지 -> 주소값...
        // c, c++ 구조체와 유사
        // 변수와 메서드의 묶음
        System.out.println(animal.name); // 호출 가능 // null
        // 안 넣어줬으니까.
        System.out.println(animal.weight); // 0이 나옴.
        // Primitive (원시) 타입 -> int, double, boolean
        // 기본값 -> 0, false
        // String -> '객체' 타입, 참조 타입 => 주소값을 가지는...
        // 구조가 복잡해서 일반적으로 나타낼 수 없음 => 이 친구들의 구조를 조회할 수 있는 주소값.
        // 복잡한 구조는 '클래스' 나타냄.
        // 기본값이 없음 -> 비어있을 경우 -> '주소값이 안들어가 있네요' -> null.
        // null은, 할당을 한 상황임.
        // NullPointException -> 빈 상태로 왔는데...
        // 컴파일을 할 때는 Java에서는 Null 상태를 스스로의 힘으로 체크할 수 있는게 없음. (연산자 X)
        // javascript, kotlin은 다 있음. -> 근데 Java는 뭔가 더 해야함(Optional, Lombok)
        // Null Safety -> 현역으로 일할 때 상당히 곤란해짐? -> 왜? -> Runtime Exception.
        // 멤버 '변수'니까 수정이 됨
        animal.name = "개동이";
        System.out.println(animal.name);
        animal.weight = 5;
        System.out.println(animal.weight);
        System.out.println(animal); // 계속 주소값
        animal.bark();
    }
}

class Animal {
    String name; // 변수 -> class의 멤버 -> 멤버변수
    int weight;
    // 멤버변수는 자동으로 할당이 됩니다 (기본값)
    void bark(){
        System.out.println("멍멍!");
    }
}