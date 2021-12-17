package com.ciklum.codeexercise;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ciklum.codeexercise.entity.WorldCupMatches;
import com.ciklum.codeexercise.service.WorldCupMatchesService;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
class CodeExerciseApplicationTests {

	@Autowired
	WorldCupMatchesService worldCupMatchesService;
	
	
	List<WorldCupMatches> backup;
  
	@BeforeAll
	void saveBackup() {
		this.backup = worldCupMatchesService.getWorldCupBoard();
	}
   
	@AfterAll 
	void loadFromBackup() {
		this.worldCupMatchesService.deleteAll();
		backup.forEach((match) ->this.worldCupMatchesService.addWorldCupMatch(match)); 
	}
	 
	
	@Test
	@DisplayName (value = "Test1 -> Add one World Cup Match")
	void Test1() {
		this.worldCupMatchesService.deleteAll();
		WorldCupMatches match = new WorldCupMatches("Spain", 0, "United Kingdom", 0);
		this.worldCupMatchesService.addWorldCupMatch(match);
		WorldCupMatches saved = this.worldCupMatchesService.getWorldCupBoard().get(0); 
		assertTrue(match.toString().equals(saved.toString()));
	}
	
	@Test
	@DisplayName (value = "Test2 -> Add two World Cup Matches and get them on Score order")
	void Test2() {
		this.worldCupMatchesService.deleteAll();
		WorldCupMatches match1 = new WorldCupMatches("Spain", 0, "United Kingdom", 0);
		WorldCupMatches match2 = new WorldCupMatches("Argentina", 4, "Chile", 2);
		this.worldCupMatchesService.addWorldCupMatch(match1);
		this.worldCupMatchesService.addWorldCupMatch(match2);
		List<WorldCupMatches> saved = this.worldCupMatchesService.getWorldCupBoard(); 
		assertTrue(saved.size()==2 && (saved.get(0).toString().equals(match2.toString()) && saved.get(1).toString().equals(match1.toString())));
	}
	
	@Test
	@DisplayName (value = "Test3 -> Add five World Cup Matches and get them on Score and match date order")
	void Test3() throws InterruptedException {
		this.worldCupMatchesService.deleteAll();
		List<String> expectedResult = List.of("1. Uruguay 6 - Italy 6", "2. Spain 10 - Brazil 2", "3. Mexico 0 - Canada 5", "4. Argentina 3 - Australia 1", "5. Germany 2 - France 2");
		WorldCupMatches matchA = new WorldCupMatches("Mexico", 0, "Canada", 5);
		Thread.sleep(100);
		WorldCupMatches matchB = new WorldCupMatches("Spain", 10, "Brazil", 2);
		Thread.sleep(100);
		WorldCupMatches matchC = new WorldCupMatches("Germany", 2, "France", 2);
		Thread.sleep(100);
		WorldCupMatches matchD = new WorldCupMatches("Uruguay", 6, "Italy", 6);
		Thread.sleep(100);
		WorldCupMatches matchE = new WorldCupMatches("Argentina", 3, "Australia", 1);
		this.worldCupMatchesService.addWorldCupMatch(matchA);
		this.worldCupMatchesService.addWorldCupMatch(matchB);
		this.worldCupMatchesService.addWorldCupMatch(matchC);
		this.worldCupMatchesService.addWorldCupMatch(matchD);
		this.worldCupMatchesService.addWorldCupMatch(matchE);
		List<String> saved = this.worldCupMatchesService.getWorldCupBoard().stream().map(WorldCupMatches::toString).collect(Collectors.toList());
		List<String> result = saved.stream().map(match -> String.valueOf(saved.indexOf(match)+1)+". "+match).collect(Collectors.toList());
		System.out.println(result);
		Boolean asser = true;
		for (int i = 0; i < result.size(); i++) {
			if(!result.get(i).toString().equals(expectedResult.get(i).toString()))
				asser = false;
		}
		assertTrue(asser);
	}

}
