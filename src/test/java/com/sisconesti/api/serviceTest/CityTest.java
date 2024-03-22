package com.sisconesti.api.serviceTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.Ignore;
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
	
	//@Test
	@Ignore
	public void saveTest() {
		
		StateModel sm1 = new StateModel();
		sm1.setId(2L);
		
		CityModel c1 = new CityModel();
		c1.setName("Gameleira");
		
		LocalDateTime dt1 = LocalDateTime.now();
		LocalDateTime dt2 = LocalDateTime.parse("2023-07-07T11:02:10");
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		
		LocalDateTime dt3 = LocalDateTime.parse("07/07/2023 11:02:10", formatter );
		
		c1.setState(sm1);
		
		cs.save(c1);
	}
	
	@Test
	public void listar() {
		
		List<CityModel> citys = cs.findAll();
		
		for (CityModel city : citys) {
			
			System.out.println("===========================================\nid: " + city.getId() + "\nName City: " + city.getName() + "\nUF: " + city.getState().getUf() + "\nName State: " + city.getState().getName());
		}
		
		
		
	}
	
 
}
