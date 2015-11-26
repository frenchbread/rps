package damir.android_todoapp.com.rockpaperscissors_app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends Activity {

    Button rockBtn, paperBtn, scissorsBtn;
    TextView computerChoiceText, playerChoiceText, resultText, scoreText, highestScoreText;

    ImageView computerChoiceImg, playerChoiceImg;

    String rock, paper, scissors;
    String choices[];

    static int hightestScore = 0;
    static int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rockBtn = (Button)findViewById(R.id.rockBtn);
        paperBtn = (Button)findViewById(R.id.paperBtn);
        scissorsBtn = (Button)findViewById(R.id.scissorsBtn);

        computerChoiceText = (TextView)findViewById(R.id.computerChoiceText);
        playerChoiceText = (TextView)findViewById(R.id.playerChoiceText);
        resultText = (TextView)findViewById(R.id.resultText);
        scoreText = (TextView)findViewById(R.id.scoreText);
        highestScoreText = (TextView)findViewById(R.id.highestScoreText);

        computerChoiceImg = (ImageView)findViewById(R.id.computerChoiceImg);
        playerChoiceImg = (ImageView)findViewById(R.id.playerChoiceImg);

        rock = getResources().getString(R.string.rock_text);
        paper = getResources().getString(R.string.paper_text);
        scissors = getResources().getString(R.string.scissors_text);

        choices = new String[] { rock, paper, scissors };
    }

    public void rockChoice(View view){

        String cmpChoice = PRS();
        String plrChoice = rock;

        setTheWinner(cmpChoice, plrChoice);
    }

    public void paperChoice(View view) {

        String cmpChoice = PRS();
        String plrChoice = paper;

        setTheWinner(cmpChoice, plrChoice);
    }

    public void scissorsChoice(View view){

        String cmpChoice = PRS();
        String plrChoice = scissors;

        setTheWinner(cmpChoice, plrChoice);
    }

    // Function that returns random value in range from 0 to 2
    public String PRS(){

        Random rand = new Random();

        int min = 0;
        int max = 2;

        int randomNum = rand.nextInt((max - min) + 1) + min;

        return choices[randomNum];
    }

    public void setTheWinner(String cmpChoice, String plrChoice){

        String Result = Result(cmpChoice, plrChoice);

        computerChoiceText.setText(cmpChoice);
        playerChoiceText.setText(plrChoice);

        changeImages(cmpChoice, plrChoice);

        resultText.setText(Result);

        scoreText.setText("Score: " + score);

        if (score >= hightestScore){
            hightestScore = score;
        }

        highestScoreText.setText("Highest score: " + hightestScore);
    }

    // Function that updates Images
    public void changeImages(String cmpChoice, String plrChoice){

        for (int i=0; i<choices.length; i++){
            if (cmpChoice == rock){
                computerChoiceImg.setBackgroundResource(R.drawable.rock);
            } else if (cmpChoice == paper){
                computerChoiceImg.setBackgroundResource(R.drawable.paper);
            } else if (cmpChoice == scissors){
                computerChoiceImg.setBackgroundResource(R.drawable.scissors);
            }
        }

        for (int j=0; j<choices.length; j++){
            if (plrChoice == rock){
                playerChoiceImg.setBackgroundResource(R.drawable.rock);
            } else if (plrChoice == paper){
                playerChoiceImg.setBackgroundResource(R.drawable.paper);
            } else if (plrChoice == scissors){
                playerChoiceImg.setBackgroundResource(R.drawable.scissors);
            }
        }

    }

    // Funciton that checks throws and return result of how is the winner
    public String Result(String compChoise, String playerChoise){

        String rck = rock;
        String ppr = paper;
        String scrs = scissors;

        String compWins = "Computer wins!";
        String playerWins = "Player wins!";
        String even = "Even! Try again!";

        // computer - player

        if (compChoise == playerChoise) {
            return even;
        }

        // rock - paper -> paper wins
        if ((compChoise == rck) && (playerChoise == ppr)){

            score++;

            return playerWins;
        }

        // rock - scissors -> rock wins
        if ((compChoise == rck) && (playerChoise == scrs)){

            score = 0;

            return compWins;
        }

        // scissors - rock -> rock wins
        if ((compChoise == scrs) && (playerChoise == rck)){

            score++;

            return playerWins;
        }

        // scissors - paper -> scissors win
        if ((compChoise == scrs) && (playerChoise == ppr)){

            score = 0;

            return compWins;
        }

        // paper - scissors -> scissors win
        if ((compChoise == ppr) && (playerChoise == scrs)){

            score++;

            return playerWins;
        }

        // paper - rock -> paper wins
        if ((compChoise == ppr) && (playerChoise == rck)){

            score = 0;

            return compWins;
        }

        return "Ooops! Something is wrong!";
    }
}
