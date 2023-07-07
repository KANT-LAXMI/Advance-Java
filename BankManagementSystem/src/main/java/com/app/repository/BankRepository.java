package com.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.AccountType;
import com.app.entities.Bank;

public interface BankRepository extends JpaRepository<Bank, Long>{
	Optional<Bank> findByEmailAndPassword(String em,String pass);
	
	List<Bank> findByType(AccountType typ);
	List<Bank> findByFirstName(String nm);

}
