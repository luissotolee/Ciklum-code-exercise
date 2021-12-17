package com.ciklum.codeexercise.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ciklum.codeexercise.dao.WorldCupMatchesDao;
import com.ciklum.codeexercise.entity.WorldCupMatches;
import com.ciklum.codeexercise.repository.WorldCupMatchesRepository;

@Component
public class WorldCupMatchesDaoImpl implements WorldCupMatchesDao{

	private WorldCupMatchesRepository worldCupMatchesRepository;
	
	public WorldCupMatchesDaoImpl(WorldCupMatchesRepository worldCupRepository) {
		this.worldCupMatchesRepository = worldCupRepository;
	}
	
	@Override
	public List<WorldCupMatches> getWorldCupBoard() {
		return this.worldCupMatchesRepository.getWorldCupBoard();
	}

	@Override
	public void addWorldCupMatch(WorldCupMatches worldCupMatch) {
		this.worldCupMatchesRepository.save(worldCupMatch);
	}

}
