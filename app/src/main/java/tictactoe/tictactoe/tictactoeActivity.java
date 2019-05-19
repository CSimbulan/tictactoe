package tictactoe.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class tictactoeActivity extends AppCompatActivity
{
    Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab6);
    }

    private void setContentsOfTextView(int id, String newContents) {
        View view = findViewById(id);
        TextView textView = (TextView) view;
        textView.setText(newContents);
    }

    private String getItemSelected(int id)  {
        View view = findViewById(id);
        Spinner spinner = (Spinner) view;
        String string = spinner.getSelectedItem().toString();
        return string;
    }

    private String getInputOfTextField(int id)  {
        View view = findViewById(id);
        EditText editText = (EditText) view;
        String input = editText.getText().toString();
        return input;
    }

    public void buttonStart (View view) {
        String first = getItemSelected(R.id.spinnerFirst);
        char P = 'X';
        if (first.equals("Player O")) {
            P = 'O';
        }
        String pX = getInputOfTextField(R.id.inputNameX);
        String pO = getInputOfTextField(R.id.inputNameO);
        game = new Game(P, pX, pO);
        setContentsOfTextView(R.id.labelOutput, game.toString());
    }

    public void buttonPlay(View view) {
        int row = Integer.parseInt(getItemSelected(R.id.spinnerRow));
        int col = Integer.parseInt(getItemSelected(R.id.spinnerCol));
        game.setBoard(row,col);
        setContentsOfTextView(R.id.labelOutput, game.toString());
    }
}
