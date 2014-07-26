package org.wfp.fittest.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wfp.fittest.service.UtilityService;

@Service
@Transactional(readOnly = true)
public class UtilityServiceImpl implements UtilityService {

}
