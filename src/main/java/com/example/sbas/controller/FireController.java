package com.example.sbas.controller;

import com.example.sbas.dto.FireDTO;
import com.example.sbas.service.FireService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fire")
public class FireController {

    private final FireService fireService;

   @GetMapping(value = "/list") // GET = DB 값 조회
    public String getList(FireDTO fireDTO){

       return fireService.findList();
    }

    @PostMapping("/save") // POST = DB 에 값 추가
    public String saveData(@RequestBody FireDTO fireDTO){
        fireService.save(fireDTO);

        return fireDTO.toString();
    }
}
