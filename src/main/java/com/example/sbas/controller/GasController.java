package com.example.sbas.controller;


import com.example.sbas.dto.GasDTO;
import com.example.sbas.service.GasService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/gas")
public class GasController {

    private final GasService gasService;


    @PostMapping("/save")
    public String gasSave(@RequestBody GasDTO gasDTO){

        gasService.save(gasDTO);
        return gasDTO.toString();
    }
}
