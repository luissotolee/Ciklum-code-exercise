package com.ciklum.codeexercise.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ciklum.codeexercise.entity.WorldCupMatches;

@Service
public interface WorldCupMatchesService {
	public List<WorldCupMatches> getWorldCupBoard();
	public void addWorldCupMatch(WorldCupMatches worldCupMatch);
	public void deleteAll();
}
