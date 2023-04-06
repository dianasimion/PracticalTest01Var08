package ro.pub.cs.systems.eim.practicaltest01var08;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01Var08MainActivity extends AppCompatActivity {
    private EditText riddleEditText;
    private EditText answerEditText;
    private Button playButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var08_main);

        riddleEditText = findViewById(R.id.riddle_edittext);
        answerEditText = findViewById(R.id.answer_edittext);

        playButton = findViewById(R.id.play_button);
        playButton.setOnClickListener(it -> {
            if (riddleEditText.getText().toString().trim().length() != 0  && answerEditText.getText().toString().trim().length() != 0) {
                Intent intent = new Intent(getApplicationContext(), PracticalTest01Var08PlayActivity.class);
                intent.putExtra(Constants.RIDDLE_TEXT, riddleEditText.getText().toString());
                intent.putExtra(Constants.ANSWER_TEXT, answerEditText.getText().toString());
                startActivityForResult(intent, Constants.REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(Constants.RIDDLE_TEXT, riddleEditText.getText().toString());
        outState.putString(Constants.ANSWER_TEXT, answerEditText.getText().toString());
    }

    // []instance
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        String rid = savedInstanceState.getString(Constants.RIDDLE_TEXT);
        String ans = savedInstanceState.getString(Constants.ANSWER_TEXT);

        riddleEditText.setText(rid);
        answerEditText.setText(ans);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Constants.REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "You guessed", Toast.LENGTH_LONG).show();
                Log.d(Constants.TOAST_TAG, "You guessed");
            }
            if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Try again", Toast.LENGTH_LONG).show();
                Log.d(Constants.TOAST_TAG, "Try again");
            }
        }
    }
}