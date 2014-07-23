package org.wfp.fittest.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wfp.fittest.dto.ActivityDTO;
import org.wfp.fittest.entity.Activity;
import org.wfp.fittest.repository.ActivityRepository;

@Service
public class Converter {
	@Autowired
	private ActivityRepository activityRepsository;
	
	public ActivityDTO entityToDTO(Activity activity) {
		return null;
	}
}
