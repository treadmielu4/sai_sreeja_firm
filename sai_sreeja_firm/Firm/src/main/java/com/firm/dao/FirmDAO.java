package com.firm.dao;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.firm.model.Firm;

@Repository
public interface FirmDAO extends CrudRepository<Firm, Integer> {
	
	@Query(nativeQuery = true, value = "select * from firms order by salary desc limit 5;")
	public List<Firm> findTopFiveFirms();

	public Optional<Firm> findByFirmName(String name);

	public List<Firm> findBySalaryBetween(Double startSalary, Double endSalary);

	public List<Firm> findByVolumeBetween(Double startVolume, Double endVolume);

	public List<Firm> findByDateBetween(Date startDate, Date endDate);
	
	
}
