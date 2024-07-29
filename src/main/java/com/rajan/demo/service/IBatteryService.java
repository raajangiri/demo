package com.rajan.demo.service;

import com.rajan.demo.dto.BatteryDto;
import com.rajan.demo.dto.BatteryResponseDto;

import java.util.List;

public interface IBatteryService {
    void saveBatteries(List<BatteryDto> batteryDtos);

    BatteryResponseDto getBatteriesByPostcodeRange(String startPostcode, String endPostcode);
}
