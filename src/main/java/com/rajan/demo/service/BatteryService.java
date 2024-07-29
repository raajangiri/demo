package com.rajan.demo.service;


import com.rajan.demo.dto.BatteryDto;
import com.rajan.demo.dto.BatteryResponseDto;
import com.rajan.demo.entity.Battery;
import com.rajan.demo.repo.BatteryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BatteryService implements IBatteryService {

    private  BatteryRepository batteryRepository;

    @Override
    public void saveBatteries(List<BatteryDto> batteryDtos) {
        List<Battery> batteries = batteryDtos.stream()
                .map(dto -> {
                    Battery battery = new Battery();
                    battery.setName(dto.getName());
                    battery.setPostcode(dto.getPostcode());
                    battery.setWattCapacity(dto.getWattCapacity());
                    return battery;
                })
                .collect(Collectors.toList());
        batteryRepository.saveAll(batteries);
    }

    @Override
    public BatteryResponseDto getBatteriesByPostcodeRange(String startPostcode, String endPostcode) {
        List<Battery> batteries = batteryRepository.findByPostcodeBetween(startPostcode, endPostcode);

        List<String> batteryNames = batteries.stream()
                .map(Battery::getName)
                .sorted()
                .collect(Collectors.toList());

        double totalWattCapacity = batteries.stream()
                .mapToDouble(Battery::getWattCapacity)
                .sum();

        double averageWattCapacity = batteries.stream()
                .mapToDouble(Battery::getWattCapacity)
                .average()
                .orElse(0.0);

        BatteryResponseDto responseDto = new BatteryResponseDto();
        responseDto.setNames(batteryNames);
        responseDto.setTotalWattCapacity(totalWattCapacity);
        responseDto.setAverageWattCapacity(averageWattCapacity);

        return responseDto;
    }
}
