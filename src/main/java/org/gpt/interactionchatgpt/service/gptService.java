package org.gpt.interactionchatgpt.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class gptService {

    /*@Value("${openai.api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    public String handle(String message) {
        String url = "https://api.openai.com/v1/chat/completions";
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(apiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        String payload = "{\"model\": \"gpt-3.5-turbo\", \"messages\": [" + message + "]}";
        HttpEntity<String> request = new HttpEntity<>(payload, headers);

        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, request, String.class);
        return responseEntity.getBody();
    }*/

    @Value("${openai.api.key}")
    private String apiKey;

    public String handle(String question) {
        String url = "https://api.openai.com/v1/engines/davinci-codex/completions";

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(apiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("prompt", question);
        requestMap.put("max_tokens", 100);
        requestMap.put("n", 1);
        requestMap.put("stop", "\n");

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(requestMap, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

        return response.getBody();
    }
}
