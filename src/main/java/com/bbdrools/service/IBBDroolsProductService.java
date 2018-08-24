package com.bbdrools.service;

import com.bbdrools.dto.DiscountRequestDTO;
import com.bbdrools.dto.DiscountResponseDTO;

public interface IBBDroolsProductService {

	public DiscountResponseDTO runRules(DiscountRequestDTO request);
}
