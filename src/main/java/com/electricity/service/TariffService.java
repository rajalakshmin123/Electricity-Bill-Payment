package com.electricity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electricity.model.Tariff;
import com.electricity.repository.TariffRepo;

@Service
public class TariffService {
	@Autowired 
	TariffRepo tariffrepo;
	
	public Tariff findTariffDetailsId(int tariff_id) {
		return tariffrepo.findTariffDetailsId(tariff_id);
	}
}
