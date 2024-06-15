import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GuessingGameAWT extends Frame implements ActionListener {
    private TextField guessInput;
    private Label feedbackLabel;
    private Button guessButton;
    private int numberToGuess;
    private int numberOfAttempts;

    public GuessingGameAWT() {
        // Setup the Frame
        setLayout(new FlowLayout());
        setTitle("Number Guessing Game");
        setSize(300, 150);

        // Generate the random number
        Random random = new Random();
        numberToGuess = random.nextInt(100) + 1;
        numberOfAttempts = 0;

        // Create GUI components
        Label promptLabel = new Label("Enter your guess (1-100): ");
        guessInput = new TextField(10);
        guessButton = new Button("Guess");
        feedbackLabel = new Label("Try to guess the number!");

        // Add components to the Frame
        add(promptLabel);
        add(guessInput);
        add(guessButton);
        add(feedbackLabel);

        // Add action listener to the button
        guessButton.addActionListener(this);

        // Close the window properly
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        // Make the frame visible
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            int userGuess = Integer.parseInt(guessInput.getText());
            numberOfAttempts++;
            if (userGuess < numberToGuess) {
                feedbackLabel.setText("Too low! Try again.");
            } else if (userGuess > numberToGuess) {
                feedbackLabel.setText("Too high! Try again.");
            } else {
                feedbackLabel.setText("Congratulations! You've guessed it in " + numberOfAttempts + " attempts.");
                guessButton.setEnabled(false); // Disable button after correct guess
            }
            guessInput.setText(""); // Clear the input field
        } catch (NumberFormatException e) {
            feedbackLabel.setText("Please enter a valid number.");
        }
    }

    public static void main(String[] args) {
        new GuessingGameAWT();
    }
}
