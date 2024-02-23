package org.gpt.interactionchatgpt.service;

import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.service.OpenAiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class gptService {

    @Value("${openai.api.key}")
    private String apiKey;

    public String askChatGpt(String question) {
        if (apiKey == null || apiKey.isEmpty()) {
            throw new IllegalArgumentException("OPENAI_API_KEY environment variable not set");
        }

        OpenAiService service = new OpenAiService(apiKey);

        ChatMessage message = new ChatMessage("user", question);

        ChatCompletionRequest completionRequest = ChatCompletionRequest.builder()
                .model("gpt-3.5-turbo")
                .messages(Collections.singletonList(message))
                .maxTokens(1000)
                .n(1)
                .build();

        String response = service.createChatCompletion(completionRequest).getChoices().get(0).getMessage().getContent();
        return response;
    }
}
