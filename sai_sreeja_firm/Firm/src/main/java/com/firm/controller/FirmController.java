package com.stock.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.stock.model.Firm;
import com.stock.service.FirmService;

@Controller
public class StockController {
	
	@Autowired
	FirmService firmService;
	
	@GetMapping(value="/allFirms")
	public ResponseEntity<?> firmList()
	{
		return new ResponseEntity<List<Firm>>(firmService.allFirm(),HttpStatus.OK);
	}
	
	@GetMapping(value="/topFiveFirms")
	public ResponseEntity<?> topFiveFirms()
	{
		return new ResponseEntity<List<Firm>>(firmService.topFiveFirm(),HttpStatus.OK);
	}
	
	@GetMapping(value="/searchFirmById/{id}")
	public ResponseEntity<?> searchFirmById(@PathVariable("id") int id)
	{
		Firm frm = firmService.searchFirmById(id);
		if(s==null){
			return new ResponseEntity<String>("not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Firm>(frm,HttpStatus.OK);
	}
	
	@GetMapping(value="/searchFirmByName/{name}")
	public ResponseEntity<?> searchFirmById(@PathVariable("name") String name)
	{
		Firm f= firmService.searchFirmByName(name);
		if(s==null){
			return new ResponseEntity<String>("not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Firm>(f,HttpStatus.OK);
	}
	
	@GetMapping(value="/searchFirmBySalary/{startSalary}/{endSalary}")
	public ResponseEntity<?> searchFirmBySalary(@PathVariable("startSalary") Double startSalary, @PathVariable("endSalary") Double endSalary)
	{
		List<Firm> s = firmService.searchFirmBySalary(startSalary,endSalary);
		if(s.size()==0){
			return new ResponseEntity<String>("not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Firm>>(s,HttpStatus.OK);
	}
	
	@GetMapping(value="/searchFirmByVolume/{startVolume}/{endVolume}")
	public ResponseEntity<?> searchFirmByVolume(@PathVariable("startVolume") Double startVolume, @PathVariable("endVolume") Double endVolume )
	{
		List<Firm> s = firmService.searchFirmByVolume(startVolume,endVolume);
		if(s.size()==0){
			return new ResponseEntity<String>("not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Firm>>(s,HttpStatus.OK);
	}
	
	@GetMapping(value="/searchFirmByDate/{startDate}/{endDate}")
	public ResponseEntity<?> searchFirmById(@PathVariable("startDate") Date startDate, @PathVariable("endDate") Date endDate )
	{
		List<Firm> f = firmService.searchFirmByDate(startDate,endDate);
		if(s.size()==0){
			return new ResponseEntity<String>("not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Firm>>(f,HttpStatus.OK);
	}
}
