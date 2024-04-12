package com.example.sbas.service;

import com.example.sbas.dto.FCMDataDTO;
import com.example.sbas.dto.FCMDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.auth.oauth2.GoogleCredentials;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.apache.http.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;

@Service
@Slf4j
@RequiredArgsConstructor
public class FcmService {

    private final String API_URL = "https://fcm.googleapis.com/v1/projects/serverName/messages:send";
    private final ObjectMapper objectMapper;

    private String getAccessToken() throws IOException{
        GoogleCredentials googleCredentials = GoogleCredentials.fromStream(new ClassPathResource("sbas-server.json").getInputStream())
                .createScoped(Arrays.asList("https://www.googleapis.com/auth/cloud-platform"));

        googleCredentials.refreshIfExpired();

        return googleCredentials.getAccessToken().getTokenValue();
    }

    //make message : 알림 파라미터를 FCM이 요구하는 형태로 가공
    public String makeMessage(
            String targetToken,String title, String body, String warningId) throws JsonProcessingException{
        FCMDto fcmMessage = FCMDto.builder()
                .message(
                    FCMDto.Message.builder()
                            .token(targetToken)
                            .notification(
                                    FCMDto.Notification.builder()
                                            .title(title)
                                            .body(body)
                                            .build()
                            )
                            .data(FCMDto.Data.builder()
                                    .warningId(warningId)
                                    .build()
                            )
                            .build()
                )
//                .validateOnly(false)
                .build();

        return objectMapper.writeValueAsString(fcmMessage);
    }

    public String makeDataMessage(String targetToken, String warningId) throws IOException{
        FCMDataDTO fcmMessage = FCMDataDTO.builder()
                .message(
                        FCMDataDTO.Message.builder()
                                .token(targetToken)
                                .data(FCMDataDTO.Data.builder()
                                        .warningId(warningId)
                                        .build()
                                )
                                .build()
                )
                //.validateOnly(false)
                .build();

        return objectMapper.writeValueAsString(fcmMessage);
    }
    public void sendMessageTo(String targetToken,String title,String body, String warningId) throws IOException{
        String message = makeMessage(targetToken,title,body,warningId);

        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody =RequestBody.create(message, MediaType.get("application/json; charset=UTF-8"));

        Request request = new Request.Builder()
                .url(API_URL)
                .post(requestBody)
                .addHeader(HttpHeaders.AUTHORIZATION,"Bearer "+getAccessToken())
                .addHeader(HttpHeaders.CONTENT_TYPE,"application/json; utf-8")
                .build();

        Response response = client.newCall(request).execute();
        System.out.println(response.body().string()); // 응답 본문 출력
        System.out.println(message);
    }

    public void sendDataTo(String targetToken,String warningId) throws IOException{
        String message = makeDataMessage(targetToken,warningId);

        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = RequestBody.create(message,MediaType.get("application/json; charset=UTF-8"));

        Request request = new Request.Builder().url(API_URL)
                .post(requestBody).addHeader(HttpHeaders.AUTHORIZATION,"Bearer "+ getAccessToken())
                .addHeader(HttpHeaders.CONTENT_TYPE,"application/json; utf-8")
                .build();

        Response response = client.newCall(request).execute();
        System.out.println(response.body().string()); // 응답 본문 출력
        System.out.println(message);

    }
}

