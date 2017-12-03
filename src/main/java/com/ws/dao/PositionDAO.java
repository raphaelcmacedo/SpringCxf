package com.ws.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ws.entity.Position;
import com.ws.repository.PositionRepository;

@Repository
public class PositionDAO extends GenericDAO<Position> implements PositionRepository {

	@Override
	public List<Position> listAll() {
		return super.getCurrentSession().createCriteria(Position.class).list();
	}

	@Override
	public Position findById(int id) {
		return (Position) super.getCurrentSession().get(Position.class, id);
	}
	
}
