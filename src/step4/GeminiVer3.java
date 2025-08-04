package step4;

import java.awt.*;
import java.util.Scanner;

// https://github.com/notlikelion/250801_flow-control/blob/main/src/step5/GeminiChatVer2Another.java
public class GeminiVer3 {
    public static void main(String[] args) {
        // 일단은 Interface, Abstract Class, Class 설계
        // -> 객체 메서드, static 메서드
        // throw, throws, return을 적절하게 사용해서. 좀 더 '프로그램'스럽게

        // https://aistudio.google.com/apikey
        // Main 메서드가 있는 클래스 파일 > 매개변수를 사용하여 실행
        // 환경변수 : GEMINI_API_KEY=??????????
        String apiKey = System.getenv("GEMINI_API_KEY");
//        Chatbot chatbot = new RoleChatbot(apiKey);
//        Chatbot chatbot = new RoleChatbot(apiKey, "100자 이내로, MBTI가 INTJ인 사람처럼 대답해줘.");
        Scanner sc = new Scanner(System.in);
//        System.out.print("당신과 상담할 사람을 서술해보세요 : ");
//        Chatbot chatbot = new RoleChatbot(apiKey, sc.nextLine() + "라고 설명된 사람이 대답하는 듯이 해줘.");
//        Chatbot chatbot = new EnglishChatbot(apiKey);
        Chatbot chatbot = new EnglishChatbot(apiKey, "일본어");
        while (true) {
            System.out.print("질문을 입력하세요 : ");
            String question = sc.nextLine();
            if (question.equals("종료")) {
                System.out.println("대화 종료");
                return;
            }
            try {
                String resp = chatbot.chat(question);
                System.out.println(resp);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

    }
}