package damir.android_todoapp.com.rockpaperscissors_app;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends Activity {

    Button rockBtn, paperBtn, scissorsBtn;
    TextView computerChoiceLbl, playerChoiceLbl, resultLbl, scoreLbl;

    static String rock = "Rock", paper = "Paper", scissors = "Scissors";
    static String[] choices = { rock, paper, scissors };

    static int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rockBtn = (Button)findViewById(R.id.rockBtn);
        paperBtn = (Button)findViewById(R.id.paperBtn);
        scissorsBtn = (Button)findViewById(R.id.scissorsBtn);

        computerChoiceLbl = (TextView)findViewById(R.id.computerChoiseLbl);
        playerChoiceLbl = (TextView)findViewById(R.id.playerChoiseLbl);
        resultLbl = (TextView)findViewById(R.id.resultLbl);
        scoreLbl = (TextView)findViewById(R.id.scoreLbl);
    }

    public void rockChoice(View view){

        String cmpChoice = PRS();
        String plrChoice = rock;

        computerChoiceLbl.setText(cmpChoice);
        playerChoiceLbl.setText(plrChoice);

        resultLbl.setText(Result(cmpChoice, plrChoice));

        scoreLbl.setText("Score: " + score);

    }

    public void paperChoice(View view){

        String cmpChoise = PRS();
        String plrChoise = paper;

        computerChoiceLbl.setText(cmpChoise);
        playerChoiceLbl.setText(plrChoise);

        resultLbl.setText(Result(cmpChoise, plrChoise));

        scoreLbl.setText("Score: " + score);
    }

    public void scissorsChoice(View view){

        String cmpChoice = PRS();
        String plrChoice = scissors;

        computerChoiceLbl.setText(cmpChoice);
        playerChoiceLbl.setText(plrChoice);

        resultLbl.setText(Result(cmpChoice, plrChoice));

        scoreLbl.setText("Score: " + score);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // Function that returns random value in range from 0 to 2
    public static String PRS(){

        Random rand = new Random();

        int min = 0;
        int max = 2;

        int randomNum = rand.nextInt((max - min) + 1) + min;

        return choices[randomNum];
    }

    // Funciton that checks throws and return result of how is the winner
    public static String Result(String compChoise, String playerChoise){

        String rck = rock;
        String ppr = paper;
        String scrs = scissors;

        String compWins = "Computer wins!";
        String playerWins = "User wins!";
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
