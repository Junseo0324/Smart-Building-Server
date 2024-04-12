package com.example.sbas.controller;

import com.example.sbas.dto.EarthquakeDTO;
import com.example.sbas.service.EarthquakeService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/quake")
public class EarthquakeController {
    private final EarthquakeService earthquakeService;


    @GetMapping("/list")
    public String getList(EarthquakeDTO earthquakeDTO){

        return earthquakeService.findList();
    }
    @PostMapping("/save")
    public String saveData(@RequestBody EarthquakeDTO earthquakeDTO){
        Long fireDatabaseId = earthquakeService.save(earthquakeDTO);
        earthquakeService.saveFD(fireDatabaseId);
        return earthquakeDTO.toString();
    }
}
