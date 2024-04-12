package com.example.sbas.controller;


import com.example.sbas.dto.GasDTO;
import com.example.sbas.service.GasService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/gas")
public class GasController {

    private final GasService gasService;

    @GetMapping("/list")
    public String getList(GasDTO gasDTO){

        return gasService.findList();
    }

    @PostMapping("/save")
    public String saveData(@RequestBody GasDTO gasDTO){
        Long gasDatabaseId = gasService.save(gasDTO);

        gasService.saveFD(gasDatabaseId);
        return gasDTO.toString();
    }
}
