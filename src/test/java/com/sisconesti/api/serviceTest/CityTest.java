package com.sisconesti.api.serviceTest;

import java.time.LocalDateTime;
import java.time.ZoneId;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.sisconesti.api.models.CityModel;
import com.sisconesti.api.models.StateModel;
import com.sisconesti.api.services.CityService;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class CityTest {
	
	@Autowired
	CityService cs;
	
	@Test 
	public void saveTest() {
		
		StateModel sm1 = new StateModel();
		sm1.setId(2L);
		
		CityModel c1 = new CityModel();
		c1.setName("Escada");
		c1.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTF")));
		c1.setState(sm1);
		
		cs.save(c1);
	}
	
 
}
