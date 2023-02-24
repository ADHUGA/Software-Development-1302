package edu.uga.cs1302.quiz;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.converter.DateTimeStringConverter;

// GUI application
public class GeographyQuiz extends Application {
	
	//File file = new File(getClass().getResource("country_continent.csv").getFile());	// files 
	private static final String COUNTRIES_FILE = "country_continent.csv", SCORES_FILE = "quizzes.dat";

	
	
	// to store all countries and results
	private QuestionCollection questionCollection = new QuestionCollection();
	private ArrayList<QuizResult> quizResults = new ArrayList<>();

	// new game stage gui components
	private Stage stageNewGame;
	private Scene quizScene, closeScene;
	private Label lblQuestion, lblAnswer, lblFinalScore;
	private ToggleGroup tgOptions;
	private ArrayList<RadioButton> btnOptions;
	private Button btnSubmit, btnClose;

	// view scores stage gui components
	private Stage stageViewScores;
	private TextArea txtScores;
	private Button btnCloseViewScores;

	
	// help stage gui components
	private Stage stageHelp;
	private TextArea txtHelp;
	private Button btnCloseHelp;

	
	// current quiz and current question
	private Quiz currentQuiz;
	private int iCurrentQuestion;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// read countries and quiz results
		questionCollection.readCountries(COUNTRIES_FILE);
		readQuizResults();

		BorderPane root = new BorderPane();
		root.setPadding(new Insets(10));

		
		// summary label
		Label lblSummary = new Label(
				"Welcome to the Geography Quiz Game!" + "\n\nThis quiz lets you play a quiz of 6 questions "
						+ "\nwhere each question asks to answer the continent "
						+ "\nof a country from the three possible choices.");
		lblSummary.setTextAlignment(TextAlignment.CENTER);
		root.setCenter(lblSummary);

		
		// buttons
		Button btnNewQuiz = new Button("New Quiz");
		Button btnViewResults = new Button("View Results");
		Button btnHelp = new Button("Help");
		Button btnExit = new Button("Quit");

		HBox pnlButtons = new HBox(10, btnNewQuiz, btnViewResults, btnHelp, btnExit);
		pnlButtons.setAlignment(Pos.CENTER);

		root.setBottom(pnlButtons);

		
		// create other stages
		createNewGameStage();
		createViewScoresStage();
		createHelpStage();

		
		// buttons action
		btnNewQuiz.setOnAction(this::newGameHandler);
		btnViewResults.setOnAction(this::displayScores);
		btnHelp.setOnAction(e -> stageHelp.show());
		btnExit.setOnAction(e -> primaryStage.close());

		
		// create scene and show the main stage
		Scene scene = new Scene(root, 500, 300);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Geography Quiz App");
		primaryStage.show();

	}

	
	
	// creates new game stage
	private void createNewGameStage() {
		stageNewGame = new Stage();
		stageNewGame.initModality(Modality.APPLICATION_MODAL);
		stageNewGame.setTitle("Quiz!");

		lblQuestion = new Label("");
		lblAnswer = new Label("");
		tgOptions = new ToggleGroup();
		btnOptions = new ArrayList<>();
		for (int i = 0; i < Question.POSSIBLE_CHOICES; i++) {
			RadioButton rbOption = new RadioButton();
			rbOption.setToggleGroup(tgOptions);
			btnOptions.add(rbOption);
		}
		btnSubmit = new Button("Submit");
		btnClose = new Button("Close");

		btnSubmit.setOnAction(this::submitHandler);

		VBox root = new VBox(10, lblQuestion);
		root.setPadding(new Insets(10, 50, 10, 50));
		root.setAlignment(Pos.CENTER_LEFT);
		root.getChildren().addAll(btnOptions);
		root.getChildren().addAll(btnSubmit, lblAnswer);
		quizScene = new Scene(root, 500, 500);
		stageNewGame.setScene(quizScene);

		lblFinalScore = new Label();
		btnClose.setOnAction(e -> stageNewGame.close());
		root = new VBox(10, lblFinalScore, btnClose);
		root.setAlignment(Pos.CENTER);
		closeScene = new Scene(root, 500, 500);
	}

	
	// handler for new game button
	private void newGameHandler(ActionEvent e) {
		currentQuiz = new Quiz(questionCollection);
		iCurrentQuestion = 0;
		stageNewGame.setScene(quizScene);
		displayCurrentQuestion();
		stageNewGame.show();

	}

	
	// display current question
	private void displayCurrentQuestion() {
		Question question = currentQuiz.getQuestion(iCurrentQuestion);
		ArrayList<String> choices = question.getOptions();
		lblQuestion.setText(String.format("Q%d: In which continent is %s located?", iCurrentQuestion + 1,
				question.getCountry().getCountry()));
		for (int i = 0; i < choices.size(); i++) {
			btnOptions.get(i).setText(choices.get(i));
		}
		lblAnswer.setText("");
		tgOptions.selectToggle(null);
	}

	
	// submit handler
	private void submitHandler(ActionEvent e) {

		// find selection option
		int index = btnOptions.indexOf(tgOptions.getSelectedToggle());
		if (index == -1) { // nothing selected
			lblAnswer.setText("Please select an option!");
			return;
		} else {
			// answer
			boolean answer = currentQuiz.answer(iCurrentQuestion, index);
			if (answer) // correct
				lblAnswer.setText("Correct!");
			else  // incorrect
				lblAnswer.setText("Incorrect! Correct answer is "
						+ currentQuiz.getQuestion(iCurrentQuestion).getCountry().getContinent());
			
		}

		
		
		// wait for 3 seconds
		Task<Void> delayedClosing = new Task<Void>() {
			@Override
			protected Void call() {
				try {
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException ex) {
					System.out.println(e);
				}
				return null;
			}
		};

		
		// move to next question
		delayedClosing.setOnSucceeded(ex -> {
			if (iCurrentQuestion == Quiz.TOTAL_QUESTIONS - 1) { //last question
				try {
					quizResults.add(0, new QuizResult(currentQuiz.getScore()));
					saveQuizResults();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				lblFinalScore.setText("You score is " + currentQuiz.getScore() + " out of " + Quiz.TOTAL_QUESTIONS);
				stageNewGame.setScene(closeScene);
			} else { // move to next ques
				iCurrentQuestion++;
				displayCurrentQuestion();
			}
		});

		new Thread(delayedClosing).start();

	}

	
	// save quiz results to file
	public void saveQuizResults() throws Exception {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SCORES_FILE));
		oos.writeObject(quizResults);
		oos.close();
	}

	
	// read quiz results from file
	public void readQuizResults() throws Exception {
		try {
			ObjectInputStream oos = new ObjectInputStream(new FileInputStream(SCORES_FILE));
			quizResults = (ArrayList<QuizResult>) oos.readObject();
			oos.close();
		} catch (FileNotFoundException e) {
			quizResults = new ArrayList<>();
		}

	}

	
	// create view scores stage
	private void createViewScoresStage() {
		stageViewScores = new Stage();
		stageViewScores.setTitle("Scores");
		txtScores = new TextArea();
		txtScores.setPrefRowCount(20);
		txtScores.setPrefColumnCount(100);
		txtScores.setEditable(false);
		txtScores.setFont(new Font("Monospaced", 15));
		stageViewScores.initModality(Modality.APPLICATION_MODAL);

		btnCloseViewScores = new Button("Close");
		btnCloseViewScores.setOnAction(e -> stageViewScores.close());

		VBox root = new VBox(10, txtScores, btnCloseViewScores);
		root.setPadding(new Insets(10));

		Scene scene = new Scene(root, 500, 500);
		stageViewScores.setScene(scene);
	}

	
	// display all scores
	public void displayScores(ActionEvent event) {
		DateTimeStringConverter converter = new DateTimeStringConverter("dd/MM/yyyy hh:mm:ss");
		txtScores.setText("");
		for (QuizResult quizResult : quizResults) {
			txtScores.appendText(
					String.format("%s \t\t %d%n", converter.toString(quizResult.getDate()), quizResult.getScore()));
		}
		stageViewScores.show();
	}

	
	// help stage
	private void createHelpStage() {
		stageHelp = new Stage();
		stageHelp.setTitle("Help");
		txtHelp = new TextArea();
		txtHelp.setPrefRowCount(20);
		txtHelp.setPrefColumnCount(100);
		txtHelp.setEditable(false);
		txtHelp.setFont(new Font("monospaced", 15));
		stageHelp.initModality(Modality.APPLICATION_MODAL);

		txtHelp.setText("Geography Quiz Instructions\n"
				+ "\n1. New Quiz: The Quiz starts in a new window and presents 6 questions (one by by one) to the player."
				+ "\n             Each question asks user to select the continent of a country from the possible 3 choices."
				+ "\n             After selecting the choice, user can press the submit. The result will be displayed in the same screen"
				+ "\n             and then next question is shown after 3 seconds. At teh end of quiz, final score is also shown."
				+ "\n"
				+ "\n2. View Past Scores: The application also keeps track of all the cmpleted quizzes time and score "
				+ "\n                     and this option can be used to view all the past quix scores sorted from latest to oldest"
				+ ""
				+ "\n\n3. Help: Shows the help screen"
				+ ""
				+ "\n\n4. Quit: This option closes the application");
		

		btnCloseHelp = new Button("Close");
		btnCloseHelp.setOnAction(e -> stageHelp.close());

		VBox root = new VBox(10, txtHelp, btnCloseHelp);
		root.setPadding(new Insets(10));

		Scene scene = new Scene(root, 1000, 500);
		stageHelp.setScene(scene);
	}

	public static void main(String[] args) throws IOException {
		launch(args);

	}

}
