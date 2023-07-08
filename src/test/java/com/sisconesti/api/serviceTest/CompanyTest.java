package com.sisconesti.api.serviceTest;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.sisconesti.api.models.CompanyModel;
import com.sisconesti.api.services.CompanyService;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class CompanyTest {
	
	@Autowired
	CompanyService cs;
	
	
	public void saveTest() {
		
		CompanyModel company1 = new CompanyModel();
		company1.setCorporate_name("Empresa 01 LMTD");
		company1.setfantasy_name("Farmacia de Todos");
		
		cs.save(company1);
	}
	

}