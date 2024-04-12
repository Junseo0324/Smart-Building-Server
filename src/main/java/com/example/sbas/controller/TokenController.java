package com.example.sbas.controller;

import com.example.sbas.dto.TokenDTO;
import com.example.sbas.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/token")
public class TokenController {

    private final TokenService tokenService;
    public static String token;
    @PostMapping("/save")
    public String saveToken(@RequestBody TokenDTO tokenDTO){
        token = tokenService.save(tokenDTO);
        return tokenDTO.toString();
    }
}
