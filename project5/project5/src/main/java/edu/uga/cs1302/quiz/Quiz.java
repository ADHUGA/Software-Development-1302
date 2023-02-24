package edu.uga.cs1302.quiz;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

// Rerpesent a quiz
public class Quiz {

	public static final int TOTAL_QUESTIONS = 6;

	// list of questions and score
	private ArrayList<Question> questions;
	private int score;

	// create a quiz
	public Quiz(QuestionCollection questionCollection) {

		questions = new ArrayList<>();

		ArrayList<Integer> selected = new ArrayList<>();

		// while not all questions selected
		while (questions.size() != TOTAL_QUESTIONS) {
			int index = ThreadLocalRandom.current().nextInt(questionCollection.size());
			if (!selected.contains(index)) { // if not already selected
				selected.add(index);
				// add Question
				questions.add(new Question(questionCollection.getCountry(index), questionCollection.getContinents()));
			}
		}
	}

	public Question getQuestion(int index) {
		return questions.get(index);
	}

	public int getScore() {
		return score;
	}

	
	// answer the question
	public boolean answer(int question, int index) {
		if (getQuestion(question).answer(index)) { // correct
			score++;
			return true;
		}

		return false;
	}

}
