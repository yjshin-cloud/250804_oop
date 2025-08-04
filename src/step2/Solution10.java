package step2;

public class Solution10 {
    public static void main(String[] args) {
//        new Worker();
        Worker[] workers = {new FarmWorker(), new SeaWorker()};
        for (Worker w : workers) {
//            System.out.println(w);
            w.work();
        }
    }
}

abstract class Worker {
    // Worker가 이 친구만 별도로 써주려는게 아니라
    // 공통 타입처럼
//    void work() {
//        System.out.println("일한다!");
//    }
    String name; // 일반적 클래스의 멤버변수도 사용 가능
    static String title = "ok!"; // static

    abstract void work(); // 추상메서드(스펙)
    void run() {
        System.out.println("뛴다!"); // 일반 공통 메서드를 가져도 되고...
    }
}

class FarmWorker extends Worker {

    @Override // abstract method를 선언할 걸 상속한다면 무조건 override 해줘야함
    void work() {
        System.out.println("농장 좋아!");
    }
}

class SeaWorker extends Worker {

    @Override
    void work() {
        System.out.println("바다 좋아!");
    }
}