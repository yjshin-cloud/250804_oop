package step1;

public class Solution07 {
    public static void main(String[] args) {
        // final -> 변수를 상수화 -> 재할당 금지
        final String name;
        name = "OK"; // 대입 1회만 가능.
//        name = "NO"; // 바꿀 수 없음.
//        const : javascript -> 초기화까지 해줘야하는 친구


class Teacher {
    final String name;

    Teacher(String name){
        this.name = name; // 생성자에서 의무적으로 만들고...
        // setter가 필요할까요?
    }
}



    }
}
