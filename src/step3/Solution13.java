package step3;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Solution13 {
    public static void main(String[] args) throws FileNotFoundException {
        // 1. 발생 안하겠지... 뭐...
        // 2. tomcat, sentry... 에러처리하는게 이 코드 밖에.
        //  - 컨트롤러 -> 서버에서 가장 최종적으로 바깥에 있는 진입점. -> throws.
        // -> tomcat 툴이 알아서 처리해줌.
        handleFile(); // 2가지.
        // 상위로 올릴지, 본인이 try-catch할지에 대해서 선택.

        // Runtime Exception -> 시그니쳐에 포함시킬 의무 X.
    }

    // handleFile라는 메서드를 써주려면 try-catch 흐름 제어를 해줘야한다.
    static void handleFile() throws FileNotFoundException { // 시그니쳐
        // try catch로 묶었다?
        FileReader fr = new FileReader("file.txt");
        // 내가 처리 안할건데? 이 메서드를 부르는 곳에서 try catch해.
    }
}

// throw는 그럼 어디든 처리가 되는 곳까지 계속 상위로 올리는거라 생각하면 되는걸까요?
// -> 상위로 올라가는데... -> 빌드(편집할 때) 자바가 잡아주느냐?
// 1. 자체적으로 Check가 되는 종류 익셉션이라 메서드 시그니쳐에 꼭 반영해야되는 경우
// 2. 1/0처럼 ArithmeticException -> Runtime Exception의 경우에는...
// - 내가 이걸 인지해서 catch문을 일단 그냥 걸고 가는 경우.
// - throws에다가 Runtime Exception 계열을 수동으로 적어놓거나.
// 처리가 되는지 안되는지... catch -> 무언가 처리가 되면서 마무리 sout...
// 처리가 안되면 -> 프로그램 꺼짐. (튕김)