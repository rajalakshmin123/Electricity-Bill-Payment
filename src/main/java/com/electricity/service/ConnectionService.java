package com.electricity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electricity.model.Connection;
import com.electricity.repository.ConnectionRepo;

@Service
public class ConnectionService {
	@Autowired
	ConnectionRepo connectionrepo;
	
	public Connection findCustomerId(int connection_id) {
		return connectionrepo.findCustomerId(connection_id);
	}
}
