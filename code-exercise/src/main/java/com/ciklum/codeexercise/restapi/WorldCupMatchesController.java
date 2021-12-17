package com.ciklum.codeexercise.restapi;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ciklum.codeexercise.entity.WorldCupMatches;
import com.ciklum.codeexercise.service.WorldCupMatchesService;

@RestController
public class WorldCupMatchesController {

	private final WorldCupMatchesService worldCupMatchesService;
	
	public WorldCupMatchesController(WorldCupMatchesService worldCupService) {
		this.worldCupMatchesService = worldCupService;
	}
	
	@GetMapping("/getWorldCupBoard")
	@ResponseBody
	public List<String> getWorldCupBoard() {
		List<WorldCupMatches> board = worldCupMatchesService.getWorldCupBoard();
		List<String> result = board.stream().map(WorldCupMatches::toString).collect(Collectors.toList());
		return result.stream().map(match -> String.valueOf(result.indexOf(match)+1)+". "+match).collect(Collectors.toList());
	}
	
	@GetMapping("/addMatch/{homeTeam} - {awayTeam}: {homeScore} - {awayScore}")
	@ResponseBody
	public String addMatch(@PathVariable String homeTeam, @PathVariable String awayTeam, @PathVariable int homeScore, @PathVariable int awayScore) {
		WorldCupMatches match = new WorldCupMatches(homeTeam, homeScore, awayTeam, awayScore);
		worldCupMatchesService.addWorldCupMatch(match);
		return "Match Added!";
	}
}
