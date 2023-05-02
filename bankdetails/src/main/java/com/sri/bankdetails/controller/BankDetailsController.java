package com.sri.bankdetails.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.sri.bankdetails.model.BankDetailsModel;
import com.sri.bankdetails.service.BankDetailsService;


@RestController

public class BankDetailsController {

	@Autowired
	BankDetailsService hser;
	
	@PostMapping("/postdetails")
	public BankDetailsModel addDetails(@RequestBody BankDetailsModel dd)
	{
		return hser.saveInfo(dd);
	}
	@GetMapping("/getdetails")
	public List<BankDetailsModel> getDetails()
	{
		return hser.getInfo();
	}
	@PutMapping("/updatedetails")
	public BankDetailsModel update(@RequestBody BankDetailsModel rs)
	{
		return hser.updateInfo(rs);
	}
	@DeleteMapping("/deletedetails/{sno}")
	public String delete(@PathVariable("sno") int sh)
	{
		hser.deleteInfo(sh);
		return" deleted";
	}
//	@DeleteMapping("/deleteByReq")
//	public String deleteByRequestPara(@RequestParam ("sno") int m)
//	{
//		mser.deleteInfo(m);
//		return m+" is deleted";
//	}
	@GetMapping ("/sortdetails/{field}")
	public List<BankDetailsModel> sortBankDetailsModel(@PathVariable String field)
	{
		return hser.sortAll(field);
	}
	@GetMapping(value="/pagedetails/{field}/{size}")
	public List<BankDetailsModel> pagingBankDetailsModel(@PathVariable("field") int offset,@PathVariable("size") int  pageSize)
	
	{
	 return hser.pagingBankDetailsModel(offset, pageSize);	
	}
	@GetMapping("/pagination/{nm}/{sp}/{inr}")
	public List<BankDetailsModel> paginate(@PathVariable("nm") int num,@PathVariable("sp") int size,@PathVariable("inr") String name)
	{
		return hser.paginate(num,size,name);
	}//sp ---how many page split,inr - column name
	@GetMapping("/fetchPrefix")
	public List<BankDetailsModel> fetchBankDetailsByNamePrefix(@RequestParam String prefix)
	{
		return hser.fetchBankDetailsByNamePrefix(prefix);
	}
	@GetMapping("/fetchSuffix")
	public List<BankDetailsModel> fetchBankDetailsByNameSuffix(@RequestParam String suffix)
	{
		return hser.fetchBankDetailsByNameSuffix(suffix);
	}
}
