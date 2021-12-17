package com.ciklum.codeexercise;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ciklum.codeexercise.entity.WorldCupMatches;
import com.ciklum.codeexercise.service.WorldCupMatchesService;

@SpringBootTest
class CodeExerciseApplicationTests {

	@Autowired
	WorldCupMatchesService worldCupMatchesService;
	
	List<WorldCupMatches> backup;
	
	@BeforeAll
	void saveBackup() {
		this.backup = this.worldCupMatchesService.getWorldCupBoard();
		this.worldCupMatchesService.deleteAll();
	}
	
	@AfterAll 
	void loadFromBackup() {
		backup.forEach((match) -> this.worldCupMatchesService.addWorldCupMatch(match));
	}
	
	@Test
	void contextLoads() {
	}

}
