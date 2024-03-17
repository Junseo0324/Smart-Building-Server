package com.example.sbas.controller;

import com.example.sbas.dto.EarthquakeDTO;
import com.example.sbas.service.EarthquakeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/quake")
public class EarthquakeController {
    private final EarthquakeService earthquakeService;

    @PostMapping("/save")

    public String quakeSave(@RequestBody EarthquakeDTO earthquakeDTO){

        earthquakeService.save(earthquakeDTO);
        return earthquakeDTO.toString();
    }
}
