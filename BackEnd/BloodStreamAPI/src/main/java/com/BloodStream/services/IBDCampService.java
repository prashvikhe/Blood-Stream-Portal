package com.BloodStream.services;

import java.util.List;

import com.BloodStream.dto.BDCampDto;
import com.BloodStream.pojos.BDCamp;

public interface IBDCampService {

	List<BDCampDto> getAllCamps();

	BDCamp saveCamp(BDCampDto dto);

	boolean deleteCampById(Long id);

	BDCamp updateCampById(Long id, BDCamp camp);

	boolean registerUserForCamp(Long id, Long campid);

}
