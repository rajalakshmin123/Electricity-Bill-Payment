package com.electricity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.electricity.model.*;

public interface ConnectionRepo extends JpaRepository<Connection, String> {
	@Query(value = "SELECT * FROM public.connection where connection_id = ?1",
			  nativeQuery = true)
	Connection findCustomerId(@Param("connection_id") int connection_id);
}
