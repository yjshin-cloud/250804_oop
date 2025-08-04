package step1;

import ex.Student;

// 접근제어자, 캡슐화
public class Solution02 {
    public static void main(String[] args) {
        Car car = new Car(); // 같은 java 파일, 같은 경로(패키지)
        // Java가 클래스 기반임
        // 다른 클래스에서 다른 클래스를 아무런 제약 없이 변수를 수정하는게 맞나?
        // car.color // private를 걸면 '모르는 상태'
        car.name = "타요";
        Student student = new Student(); // 다른 패키지
//        student.name; // 아무것도 안한다는 것 -> 패키지 경로가 다르면 인식 안하겠다
        // 직접 값을 호출하거나 수정하는게 아니라, 그거와 매칭되는 메서드를 만들어주고 싶은 것
        // 호출하거나 수정하는 것 -> 접근자 (접근제어자 != 접근자)
        Hello hello = new Hello();
    }
    // 중첩 class (별도의 파일로 만들어가 중첩 static...)
    public static class Hello { // 외부 메모리로 뺀다

    }
}

// 요새는 일반적이지 않음
class Car { // Public이 아님
    private String color;
    // private, public, (default), protected
    // 외부의 접근 허한다 : public
    // 외부의 접근을 막는다 : private
    String name;
}