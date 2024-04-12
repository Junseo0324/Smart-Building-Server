package com.example.sbas.dto;

import com.google.firebase.messaging.Message;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FCMDataDTO {
    //private boolean validateOnly;
    private Message message;

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor

    @Getter
    public static class Message{
        private String token;
        private Data data;
    }


    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class Data{
        private String warningId;
    }
}
