package com.ciklum.codeexercise.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ciklum.codeexercise.entity.WorldCupMatches;

@Repository
public interface WorldCupMatchesDao {
	List<WorldCupMatches> getWorldCupBoard();
	void addWorldCupMatch(WorldCupMatches worldCupMatch);
}
