package com.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dto.BankDTO;
import com.app.dto.signInDTO;
import com.app.entities.AccountType;
import com.app.entities.Bank;
import com.app.repository.BankRepository;
@Service
@Transactional
public class BankServiceImpl implements BankService{
	@Autowired
	private BankRepository bankRepo;
	@Autowired
	private ModelMapper mapper;
	@Override
	public List<Bank> getBankDetails() {
		// TODO Auto-generated method stub
		return bankRepo.findAll();
	}
	@Override
	public BankDTO AddingNew(@Valid BankDTO bank) {
		Bank bnk=mapper.map(bank, Bank.class);
		return mapper.map(bankRepo.save(bnk), BankDTO.class);
	}
	@Override
	public BankDTO updateDetails(@Valid BankDTO bnk) {
		Bank bank=mapper.map(bnk, Bank.class);
		return mapper.map(bankRepo.save(bank), BankDTO.class);
	}
	@Override
	public String delete(Long id) {
		String message="Deletion failed";
		if(bankRepo.existsById(id)) {
			bankRepo.deleteById(id);
			message="Deletion Successfully";
		}
		return message;
	}
	@Override
	public Bank getDetailsByID(Long id) {
		
		//return bankRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("bank with given id is not present"));
		return bankRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("not present by given id"));
	}
	@Override
	public BankDTO signInBank(signInDTO dt) {
		Bank bk=bankRepo.findByEmailAndPassword(dt.getEmail(), dt.getPassword())
				.orElseThrow(()->new ResourceNotFoundException("not present"));
		return mapper.map(bk, BankDTO.class);
	}
	@Override
	public List<Bank> getByTypesDetail(AccountType typ) {
			
		return bankRepo.findByType(typ);
	}
	@Override
	public List<Bank> getDetailsByName(String nm) {
		// TODO Auto-generated method stub
		return bankRepo.findByFirstName(nm);
	}
	
	
	
	
	

}
