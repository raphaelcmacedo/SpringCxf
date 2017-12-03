package com.ws.service;

import java.util.List;

import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ws.entity.Position;
import com.ws.repository.PositionRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class PositionService {

	@Autowired
	private PositionRepository repository;

	public List<Position> listAll() {
		return repository.listAll();
	}

	public Position findById(@PathParam("id") int id) {
		return repository.findById(id);
	}

	public Position save(Position position) {
		return repository.save(position);
	}

	public void delete(@PathParam("id") int id) {
		Position position = repository.findById(id);
		repository.delete(position);
	}
}
