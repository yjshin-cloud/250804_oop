package step4;

public class EnglishChatbot extends Chatbot {
    private final String language;
    EnglishChatbot(String apiKey) {
        // Chatbot 생성자
        super(apiKey);
        this.language = "영어";
    }

    EnglishChatbot(String apiKey, String language) {
        // Chatbot 생성자
        super(apiKey);
        this.language = language;
    }

    @Override
    public String chat(String message) throws Exception {
        if (message.trim().isEmpty()) {
            throw new Exception("빈 질문은 안 됩니다!");
        }
        return super.chat(
                "%s. 100자 이내의 평문으로 된 %s(으)로 대답해줘.".formatted(message, language));
    }
}