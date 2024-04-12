package com.example.sbas.controller;

import com.example.sbas.dto.WarningDTO;
import com.example.sbas.service.WarningService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/warning")
public class WarningController {
    private final WarningService warningService;

    @PostMapping("/save")
    public String saveData(@RequestBody WarningDTO warningDTO){
        warningService.save(warningDTO);

        return warningDTO.toString();
    }
}
