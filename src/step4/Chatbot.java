package step4;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public abstract class Chatbot implements IGemini {
    // 추상이니까 꼭 구현하는 게 의무는 아님
    final String apiKey;

    // super
    protected Chatbot(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public String chat(String message) throws Exception {
        // chat -> apiKey.
//        System.out.println(apiKey);
        // 1. 요청 받은 메시지를 다듬거나 추가. Role, 가이드를 추가
        String templateMessage = handleMessage(message);
        // 2. GEMINI 통신
        String geminiResponse = callGemini(apiKey, templateMessage);
        // 3. 응답 받는 텍스트를 다듬는.
        // String changedText = changeResult(geminiResponse);
        //return changedText;
        return changeResult(geminiResponse);
    }

    private String handleMessage(String message) {
        return  """
                {
                    "contents": [
                      {
                        "parts": [
                          {
                            "text": "%s"
                          }
                        ]
                      }
                    ]
                  }
                """.formatted(message);
    }

    // 아예 메모리로 빼놓자
    private static final String GEMINI_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent";
    private static final HttpClient client = HttpClient.newHttpClient();

    private String callGemini(String apiKey, String text) throws IOException, InterruptedException {
        // IOException, InterruptedException ? throws로 올렸는데 왜 빨간불 안 떠요?
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(GEMINI_URL))
                .headers("Content-Type", "application/json",
                        "X-goog-api-key", apiKey)
                .POST(HttpRequest.BodyPublishers.ofString(text))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body(); // 응답 body.
    }

    private String changeResult(String result) {
        return result
                .split("\"text\": \"")[1] // 0, 1, 2....
                .split("}")[0]
                .replace("\\n", "")
                .replace("\"", "")
                .trim();
    }
}