package com.app.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.app.dto.BankDTO;
import com.app.dto.signInDTO;
import com.app.entities.AccountType;
import com.app.entities.Bank;

public interface BankService {
	public List<Bank> getBankDetails();
	public BankDTO AddingNew(@Valid BankDTO bank);
	public BankDTO updateDetails( @Valid BankDTO bnk);
	public String delete(Long id);
	public Bank getDetailsByID(Long id);
	public BankDTO signInBank(signInDTO dt);
	public List<Bank> getByTypesDetail(AccountType typ);
	public List<Bank> getDetailsByName(String nm);
	

}
