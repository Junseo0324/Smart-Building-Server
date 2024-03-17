package com.example.sbas.controller;


import com.example.sbas.dto.FireDTO;
import com.example.sbas.service.FireService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fire")
public class FireController {

    private final FireService fireService;


   @GetMapping("/list") // GET = DB 값 조회
    public String fireList(FireDTO fireDTO){
        // fireService.list() 함수 예정 --> list 조회
       return fireDTO.toString();

    }
    @PostMapping("/save") // POST = DB 에 값 추가
    public String fireSave(@RequestBody FireDTO fireDTO){

        fireService.save(fireDTO);
        return fireDTO.toString();
    }
}
