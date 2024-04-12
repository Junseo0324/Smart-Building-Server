package com.example.sbas.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FCMDto {
//    private boolean    validateOnly;
    private Message    message;

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor

    @Getter
    public static class Message {
        private Notification notification;
        private String      token;
        private Data        data;
    }

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class Notification {
        private String  title;
        private String  body;
    }

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class Data{
        private String warningId;
    }

}
