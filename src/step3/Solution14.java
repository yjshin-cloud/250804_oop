package step3;

import java.util.Random;

// throw, catch, finally
public class Solution14 {
    public static void main(String[] args) {
//        test3(); // Uncheck라 throws로 올려도... 그냥...
        try {
            test3(); // 최종적으로 Exception까지 내려가게 된다
            Random rd = new Random();
            if (rd.nextDouble() > 0.5) {
                test();
            } else {
                test2();
            }
        } catch (CustomException ce) {
            System.out.println("커스텀 익셉션");
        } catch (Exception e) {
            System.out.println("그냥 익셉션");
        }
    }

    static void test() throws Exception {
        throw new Exception(); // new 생성해서 -> Exception을 발생시킴
        // 2 중에 하나로.
        // try catch / 시그니쳐로 올려버리던가
    }

    static void test2() throws CustomException {
        throw new CustomException();
    }

    static void test3() throws WarningException {
        throw new WarningException();
    }
}

class WarningException extends RuntimeException {

}

class CustomException extends Exception {

}