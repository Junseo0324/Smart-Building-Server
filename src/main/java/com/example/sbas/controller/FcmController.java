package com.example.sbas.controller;

import com.example.sbas.dto.FCMDto;
import com.example.sbas.service.FcmService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fcm")
public class FcmController {

    private final FcmService fcmService;
    @PostMapping("/send")
    public void sendNotification(@RequestBody FCMDto fcmDto) throws IOException {
        fcmService.sendMessageTo(
                fcmDto.getMessage().getToken(),
                fcmDto.getMessage().getNotification().getTitle(),
                fcmDto.getMessage().getNotification().getBody(),
                fcmDto.getMessage().getData().getWarningId()
        );

    }
    @PostMapping("/sendData")
    public void sendData(@RequestBody FCMDto fcmDto) throws IOException{
        fcmService.sendDataTo(
                fcmDto.getMessage().getToken(),
                fcmDto.getMessage().getData().getWarningId()
        );
        System.out.println(fcmDto.getMessage().getData().getWarningId());
    }

}
