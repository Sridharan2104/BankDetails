package com.sri.bankdetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;  
import org.springframework.stereotype.Repository;
import com.sri.bankdetails.model.LoginBdModel;

@Repository

public interface LoginBdRepository extends JpaRepository<LoginBdModel,Integer> {

	LoginBdModel findByUsername(String username);
}
