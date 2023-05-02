package com.sri.bankdetails.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sri.bankdetails.model.BankDetailsModel;

@Repository

public interface BankDetailsRepository extends JpaRepository<BankDetailsModel,Integer>{

	List<BankDetailsModel> findByNameStartingWith(String prefix);
	List<BankDetailsModel> findByNameEndingWith(String suffix);
}
