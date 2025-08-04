package step3;

import java.util.Random;

public class Solution16 {
    public static void main(String[] args) {
        System.out.println(fun1());
        System.out.println(fun2());
        System.out.println(fun3());
        System.out.println(fun4());
    }

    static int fun1() {
        return 0;
    }

    static int fun2() {
        try {
            Random rd = new Random();
            if (rd.nextInt(10000) != 0) {
                throw new Exception("에러 발생");
            }
            return 1;
        } catch (Exception e) {
            return 2;
        }
    }

    static int fun3() {
        try {
            Random rd = new Random();
            if (rd.nextBoolean()) { // 확률이 반반
                throw new Exception("에러 발생");
            }
            return 3;
        } catch (Exception e) {
            return 4;
        } finally {
            System.out.println("무조건 실행되는 코드");
        }
    }

    static int fun4() {
        try {
            Random rd = new Random();
            if (rd.nextInt(10000) != 0) {
                throw new Exception("에러 발생");
            }
            System.out.println("정상");
            return 5;
        } catch (Exception e) {
            System.out.println("에러");
            return 6;
        } finally {
            return 7; // 무조건 덮어요
            // 그래서... 일반적으로 finally return을 쓰지 않음.
        }
    }
}