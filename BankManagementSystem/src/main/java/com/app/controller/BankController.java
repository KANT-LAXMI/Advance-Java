package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.BankDTO;
import com.app.dto.signInDTO;
import com.app.entities.AccountType;
import com.app.entities.Bank;
import com.app.service.BankService;

@RestController
@RequestMapping("/patients")
public class BankController {

	@Autowired
	private BankService bankService;
	public BankController() {
		System.out.println("in constr of"+getClass());
	}
	@GetMapping
	public List<Bank> getAllBank(){
		return bankService.getBankDetails();	
	}
	@PostMapping
	public BankDTO signUp(@RequestBody @Valid BankDTO bank) {
		return bankService.AddingNew(bank);
	}
	
	@PutMapping("/update")
	public BankDTO update(@RequestBody @Valid BankDTO bnk) {
		return bankService.updateDetails(bnk);
		
	}
	@DeleteMapping("/{id}")
	public ApiResponse deleteBank(@PathVariable Long id) {
		return new ApiResponse(bankService.delete(id));
		
	}
	@GetMapping("/{id}")
	public Bank getDetailsByID(@PathVariable Long id) {
		return bankService.getDetailsByID(id);
	}
	@PostMapping("/signIn")
	public ResponseEntity<?> signInBank(@RequestBody @Valid signInDTO dt) {
		return new ResponseEntity<>(bankService.signInBank(dt), HttpStatus.OK);
	}
	@GetMapping("/bank/{type}")
	public List<Bank> getTypeDetails(@PathVariable String type){
		return bankService.getByTypesDetail(AccountType.valueOf(type.toUpperCase()));
		
	}
	
	@GetMapping("/banks/{fname}")
	public List<Bank> getFirstNameDetails(@PathVariable String fname){
		return bankService.getDetailsByName(fname);
	}
	
	
	
}
