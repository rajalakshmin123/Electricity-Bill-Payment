package com.electricity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.electricity.model.Tariff;

public interface TariffRepo extends JpaRepository<Tariff, String> {
	@Query(value = "SELECT * FROM public.tariff where tariff_id = ?1",
			  nativeQuery = true)
	Tariff findTariffDetailsId(@Param("tariff_id") int tariff_id);
}
