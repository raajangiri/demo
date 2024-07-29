package com.rajan.demo;

import com.rajan.demo.dto.BatteryDto;
import com.rajan.demo.entity.Battery;
import com.rajan.demo.repo.BatteryRepository;
import com.rajan.demo.service.BatteryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.when;

@SpringBootTest
class DemoApplicationTests {
	@Mock
	private BatteryRepository batteryRepository;

	@InjectMocks
	private BatteryService batteryService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testSaveBatteries() {
		BatteryDto battery1 = new BatteryDto();
		battery1.setName("Battery A");
		battery1.setPostcode("1000");
		battery1.setWattCapacity(500);

		BatteryDto battery2 = new BatteryDto();
		battery2.setName("Battery B");
		battery2.setPostcode("2000");
		battery2.setWattCapacity(600);

		List<BatteryDto> batteries = Arrays.asList(battery1, battery2);
		batteryService.saveBatteries(batteries);
	}

	@Test
	void testGetBatteriesByPostcodeRange() {
		List<Battery> all = batteryRepository.findAll();
		System.out.println(all);


	}

}
