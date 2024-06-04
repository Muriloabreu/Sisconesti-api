package com.sisconesti.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sisconesti.api.models.BranchModel;
import com.sisconesti.api.projections.BranchJoinAllProjection;
import com.sisconesti.api.projections.BranchJoinMinProjection;


public interface BranchRepository extends JpaRepository<BranchModel, Long>{
	
	boolean existsByName(String name);
	boolean existsByCnpj(String cnpj);
	
	
	@Query(nativeQuery = true, value = """
			SELECT b.name AS nameBranch, b.cnpj, c.corporate_name AS nameCompany, cit.name AS cityName, sta.name AS nameState, sta.uf AS uf_State FROM tb_branch b 
							INNER JOIN tb_company c ON c.id = b.id_company
							INNER JOIN tb_citys cit ON cit.id = id_city
							INNER JOIN tb_states sta ON sta.id = cit.state_id
							WHERE UPPER(b.name) LIKE '%' || UPPER(?1) || '%'
							""")  
	List<BranchJoinMinProjection> seacheByNameBranch(String name);
	
	@Query(nativeQuery = true, value = """
						SELECT b.name AS nameBranch, b.cnpj, c.corporate_name AS nameCompany, cit.name AS cityName, sta.name AS nameState, sta.uf AS uf_State FROM tb_branch b 
							INNER JOIN tb_company c ON c.id = b.id_company
							INNER JOIN tb_citys cit ON cit.id = id_city
							INNER JOIN tb_states sta ON sta.id = cit.state_id 
							WHERE b.id_company = ?1 
							""")
	List<BranchJoinAllProjection>findAllById(Long id);

}
