package step4;

public class RoleChatbot extends Chatbot {
    private final String role;

    RoleChatbot(String apiKey) {
        // Chatbot 생성자
        super(apiKey); // 실제 구현한 RoleChatbot
        this.role = "너는 위로를 위한 챗봇이야. 200자 이내로 감정적 위로를 위한 내용으로 답변해줘.";
    }


    RoleChatbot(String apiKey, String role) {
        // Chatbot 생성자
        super(apiKey); // 실제 구현한 RoleChatbot
        this.role = role;
    }
    // this.apiKey를 하면 Chatbot에 전달이 안됨
    // 오버라이딩이라던가 있지 않나요? 이친구가 그냥 받으면 안돼요?


    @Override
    public String chat(String message) throws Exception {
        if (message.trim().isEmpty()) {
            throw new Exception("빈 질문은 안 됩니다!");
        }
        return super.chat(
                "%s. %s".formatted(message, role));
    }
}