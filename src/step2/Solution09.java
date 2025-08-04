package step2;

public class Solution09 {
    public static void main(String[] args) {
        Car car = new Car();
        System.out.println(car.price); // ?
        car.hello();
        car.hello2();
        car.trigger();
        System.out.println("Color : " + car.getColor());
        RacingCar car2 = new RacingCar();
        System.out.println(car2.price); // ? 같게??
        car2.hello();
        car2.hello2();
        car2.trigger();
        car2.trigger(100);
        System.out.println("Color : " + car2.getColor());
        Car car3 = new RacingCar();
        // 정적 바인딩 (static, final, private, 생성자, 멤버변수)
        System.out.println(car3.price); // ? Car의 Price가 나왔음
        // 동적 바인딩 (나머지 public...)
        car3.hello();
        car3.hello2(); // Override와 상관없이 메서드에서는 생성자에 쓴 타입을 바탕으로 메서드를 출력
        // 상속을 하다보면 상속 받은 입장에서 상위 클래스의 메서드를 재정의하는...
        // Override <-> Overloading
        // Override는 상속 받아놓고 보니 다시 써야해서 이름과 매개변수의 타입이 완전히 겹치는 경우
        // 덮어 씌우는 듯이 작성
        // Overloading은 같은 이름인데 매개변수의 타입이 달라서...
        car3.trigger(); // trigger는 있는데...
//        car3.trigger(100);
        // 사무직 -> 개발자
        // 메서드? -> 개발자가 사무직으로 위장하면 개발자의 일을 못시키는...
        System.out.println("Color : " + car3.getColor());

        // 요지는 뭐나면, getter, setter 캡슐화/은닉화
        // 이렇게 하는 이유 중에 하나가, 바인딩.
        // 이걸 getter/setter를 쓰게 하면, 무조건 생성자를 써준 타입의 멤버변수를 쓴다

    }
}

class RacingCar extends Car {
    // 캡슐화를 해서 getter, setter를 사용하면, binding을 할 때 한쪽으로 결정이 남.
    int price = 50000; // 본인의 price.
    private String color = "red";

    String getColor() {
        return color;
    }

    // void hello() -> 본인 내부의 Car 시절의 price와 해당 메서드.
    void hello() { // 이게 없으면 이전에 상속 받은 것 자체를...
        System.out.println("안녕하세요, 제 가격은 " + price + "입니다!");
        // super.price X
        // this.price
    }

    @Override // 어노테이션, 애너테이션. 표시 -> 제대로 된 오버라이딩인지 검사
        // 오버로딩이라든가, 아니면 상위 클래스에 없는 메서드라면 오류표시.
    void hello2() {
        System.out.println("안녕하세요, 제 가격은 " + price + "입니다!");
    }

    @Override
    void trigger() {
        super.trigger();
        System.out.println("레이싱카라 좀 더 빨리 걸림");
    }

    void trigger(int speed) {
        System.out.println(speed + "의 속도로 달려가기 위해 시동검");
    }
}

class Car {
    int price = 10000;
    private final String color = "yellow";

    void trigger() {
        System.out.println("시동 걸림");
    }

    String getColor() {
        return color;
    }

    void hello() {
        System.out.println("안녕하세요, 제 가격은 " + price + "입니다!");
    }

    void hello2() {
        System.out.println("안녕하세요, 제 가격은 " + price + "입니다!");
    }
}