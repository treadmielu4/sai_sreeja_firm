package com.firm.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firm.dao.FirmDAO;
import com.firm.model.Firm;

@Service
public class FirmService {
	
	@Autowired
	FirmDAO firmDao;
	
	public List<Firm> allFirm(){
		return (List<Firm>) firmDao.findAll();
	}
	
	public List<Firm> topFiveFirm(){
		return (List<Firm>) stockDao.findTopFiveFirms();
	}
	
	public Firm searchFirmById(int id){
		Optional<Firm> s = firmDao.findById(id);
		if(s.isPresent()){
			return s.get();
		}
		return null;
	}
	
	public Firm searchFirmByName(String name){
		Optional<Firm> s = firmDao.findByFirmName(name);
		if(s.isPresent()){
			return s.get();
		}
		return null;
	}
	
	public List<Firm> searchFirmBySalary(Double startSalary, Double endSalary){
		return (List<Firm>) firmDao.findBySalaryBetween(startSalary,endSalary);
	}
	
	public List<Firm> searchFirmByVolume(Double startVolume, Double endVolume){
		return (List<Firm>) firmDao.findByVolumeBetween(startVolume,endVolume);
	}
	
	public List<Firm> searchFirmByDate(Date startDate, Date endDate){
		return (List<Firm>) firmDao.findByDateBetween(startDate,endDate);
	}
	
}
