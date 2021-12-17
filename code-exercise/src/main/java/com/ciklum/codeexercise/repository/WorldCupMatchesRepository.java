package com.ciklum.codeexercise.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ciklum.codeexercise.entity.WorldCupMatches;

public interface WorldCupMatchesRepository extends JpaRepository <WorldCupMatches, Long>{

	@Query(value = "SELECT * FROM WORLD_CUP_MATCHES order by (HOME_TEAM_SCORE + AWAY_TEAM_SCORE) desc, MATCH_DATE desc", nativeQuery = true)
	List<WorldCupMatches> getWorldCupBoard();
}
