/**
 * 
 */
package dive.dev.thirdy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dive.dev.thirdy.models.Accounts;
import dive.dev.thirdy.repo.AccountsRepository;

/**
 * @author Eazy Bytes
 *
 */

@RestController
public class AccountsController {
	
	@Autowired
	private AccountsRepository accountsRepository;

//	@Autowired
//	private CustomerRepository customerRepository;
	
//	@PostMapping("/myAccount")
//	public Accounts getAccountDetails(@RequestBody Customer customer) {
//
//		Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId());
//		if (accounts != null) {
//			return accounts;
//		} else {
//			return null;
//		}
//
//	}
//	
	//saya added below GetMapping
	
//	@GetMapping("/myAccountGet")
//	@ResponseBody
//	public String getParam1(@RequestParam String scid, @RequestParam String ccspackage){
//		System.out.println("Scid :" + scid);
//		System.out.println("Cccspackage :" + ccspackage);
//		
//		Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId());
//		
//		return "Promote Successfull : "+ "scid = "+scid + "&" + "ccspackage = "+ ccspackage;
//	}

	// saya JPA join
	
	@GetMapping("/getaccounts")
	@ResponseBody
	public List<Accounts> findAllAccounts(){
			
		return accountsRepository.findAll();
	}

}
