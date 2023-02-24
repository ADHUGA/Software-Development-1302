package edu.uga.cs1302.quiz;

import java.io.Serializable;
import java.util.Date;


// Result of quiz
public class QuizResult implements  Serializable{

	private Date date;
	private int score;

	public QuizResult(int score) {
		this.date = new Date();
		this.score = score;
	}

	public Date getDate() {
		return date;
	}

	public int getScore() {
		return score;
	}


}
