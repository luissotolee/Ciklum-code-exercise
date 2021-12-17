package com.ciklum.codeexercise.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ciklum.codeexercise.dao.WorldCupMatchesDao;
import com.ciklum.codeexercise.entity.WorldCupMatches;
import com.ciklum.codeexercise.service.WorldCupMatchesService;

@Component
public class WorldCupMatchesServiceImpl implements WorldCupMatchesService{

	private WorldCupMatchesDao worldCupMatchesDao;
	
	public WorldCupMatchesServiceImpl(WorldCupMatchesDao worldCupDao) {
		this.worldCupMatchesDao = worldCupDao;
	}
	
	@Override
	public List<WorldCupMatches> getWorldCupBoard() {
		return this.worldCupMatchesDao.getWorldCupBoard();
	}

	@Override
	public void addWorldCupMatch(WorldCupMatches worldCupMatch) {
		this.worldCupMatchesDao.addWorldCupMatch(worldCupMatch);
	}

}
