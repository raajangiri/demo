package com.rajan.demo.controller;


import com.rajan.demo.dto.BatteryDto;
import com.rajan.demo.dto.BatteryResponseDto;
import com.rajan.demo.entity.Battery;
import com.rajan.demo.service.IBatteryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/batteries")

public class BatteryController {

    @Autowired
    private IBatteryService batteryService;

    @PostMapping
    public ResponseEntity<String> addBatteries(@RequestBody List<BatteryDto> batteryDtos) {
        batteryService.saveBatteries(batteryDtos);
        return new ResponseEntity<>("Batteries added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/range")
    public ResponseEntity<BatteryResponseDto> getBatteriesByPostcodeRange(
            @RequestParam String startPostcode,
            @RequestParam String endPostcode
    ) {
        BatteryResponseDto result = batteryService.getBatteriesByPostcodeRange(startPostcode, endPostcode);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}