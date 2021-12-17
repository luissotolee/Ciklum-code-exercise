package com.ciklum.codeexercise.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class WorldCupMatches implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue
	private Long id;
	
	private String homeTeamName;
	
	private int homeTeamScore;
	
	private String awayTeamName;
	
	private int awayTeamScore;
	
	private Date matchDate;
	
	public WorldCupMatches(){}
	
	public WorldCupMatches(String homeName, int homeScore, String awayName, int awayScore, Date date) {
		this.homeTeamName = homeName;
		this.homeTeamScore = homeScore;
		this.awayTeamName = awayName;
		this.awayTeamScore = awayScore;
		this.matchDate = date;
	}
	
	public WorldCupMatches(String homeName, int homeScore, String awayName, int awayScore) {
		this.homeTeamName = homeName;
		this.homeTeamScore = homeScore;
		this.awayTeamName = awayName;
		this.awayTeamScore = awayScore;
		this.matchDate = new Date(System.currentTimeMillis());
	}

	public String getHomeTeamName() {
		return homeTeamName;
	}

	public void setHomeTeamName(String homeTeamName) {
		this.homeTeamName = homeTeamName;
	}

	public int getHomeTeamScore() {
		return homeTeamScore;
	}

	public void setHomeTeamScore(int homeTeamScore) {
		this.homeTeamScore = homeTeamScore;
	}

	public String getAwayTeamName() {
		return awayTeamName;
	}

	public void setAwayTeamName(String awayTeamName) {
		this.awayTeamName = awayTeamName;
	}

	public int getAwayTeamScore() {
		return awayTeamScore;
	}

	public void setAwayTeamScore(int awayTeamScore) {
		this.awayTeamScore = awayTeamScore;
	}

	public Date getMatchDate() {
		return matchDate;
	}

	public void setMatchDate(Date matchDate) {
		this.matchDate = matchDate;
	}
	
	public String toString() {
		return this.homeTeamName+" "+this.homeTeamScore+" - "+this.awayTeamName+" "+this.awayTeamScore;
	}
	
}
