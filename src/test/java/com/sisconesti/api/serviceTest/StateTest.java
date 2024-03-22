package com.sisconesti.api.serviceTest;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.sisconesti.api.models.StateModel;
import com.sisconesti.api.services.StateService;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class StateTest {
	
	@Autowired
	StateService ss;
	
	
	//@Test
	@Ignore
	public void saveStateTest() {	
	StateModel sm1 = new StateModel();
	
	sm1.setName("Bahia");
	sm1.setUf("BA");
	
	ss.save(sm1);
	
	}
	
	@Test
	public void listar() {
		
		List<StateModel> states = ss.findAll();
		
		for (StateModel state : states) {
			
			System.out.println("===========================================\nid: " + state.getId() + "\nUF: " + state.getUf() + "\nName State: " + state.getName());
		}
		
		
		
	}
	
	
}
