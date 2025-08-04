package step1;

public class Solution04 {
    public static void main(String[] args) {
        Bread bread = new Bread();
//        System.out.println(bread.name);
        System.out.println(bread.getName());
        Bread bread2 = new Bread();
//        System.out.println(bread2.name);
        System.out.println(bread2.getName());
//        bread2.name = "붕어빵";
        bread2.setName("붕어빵");
//        System.out.println(bread2.name);
        System.out.println(bread2.getName());
//        System.out.println(bread.name); // 단팥빵
        System.out.println(bread.getName()); // 단팥빵
        // bread, bread2는 서로 구분된 객체.
        // 멤버변수에 저장된 값은 new를 통해서 새롭게 할당이 되면
        // 연결관계가 없음. (인스턴스 변수 -> 인스턴스별로 구별되어 있어서)
        Bread bread3 = new Bread("피자빵");
//        System.out.println(bread3.name);
        System.out.println(bread3.getName());

        System.out.println(1);
        System.out.println("1"); // 실제로 호출되는게 다름 (타입에 따라)
        // 매개변수 시그니처 -> 매개변수의 '타입'을 다르게 (매개변수의 이름만 달라서는 안된다)
    }
}

class Bread {
    private String name;
    Bread() {
        name = "단팥빵";
    }
    //    Bread(String breadName) { // 외부에서 전달 받을 수 있음
//        name = breadName;
//    }
    Bread(String name) { // 매개변수의 이름이 멤버변수랑 겹칠 수 있음
        // 덮어씌우게 됨
        // name = name; // 이 본체의 name은? 그냥 빈 상태가 되는 것.
        this.name = name; // '나' = 인스턴스 자체
        // this.이름 -> 멤버변수. 그냥 이름 => 멤버변수일 수도 있고... 매개변수일 수도 있고...
    }
    // Bread -> Bread 매개변수에 따라서 별도로 하나씩 만들 수 있네
    // 매개변수가 타입(타입의 조합) -> 별도의 메서드로 판정
    // 메서드 오버로딩(Over-loading). (다형성) => Animal -> Dog, Cat...
    // => 다양한 타입에 대응해서 같은 이름인데 실제 기능이 다른...

    // getter, setter
//    String getName() { // private X?
//        return this.name;
//    }
//    void setName(String name) {
//        this.name = name;
//    }

    // 코드 > 생성 > getter setter
    // 우클릭 > 생성 > getter setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}