package ro.pub.cs.systems.eim.practicaltest01var08;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PracticalTest01Var08PlayActivity extends AppCompatActivity {
    private Button checkButton;
    private Button backButton;
    private TextView riddleText;

    String riddleFromMain;
    String answerFromMain;

    private EditText currentAnswer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var08_play);

        riddleText = findViewById(R.id.play_riddle_noneditable_textview);
        currentAnswer = findViewById(R.id.play_answer_edittext);

        checkButton = findViewById(R.id.check_button);
        backButton = findViewById(R.id.back_button);

        checkButton.setOnClickListener(it -> {
            if (currentAnswer.getText().toString().equals(answerFromMain)) {
                setResult(RESULT_OK, null);
                finish();
            } else {
                setResult(RESULT_CANCELED, null);
                finish();
            }
        });

        backButton.setOnClickListener(it -> {
            setResult(RESULT_CANCELED, null);
            finish();
        });

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
//                resultText.setText("0");
            } else {
                riddleFromMain = extras.getString(Constants.RIDDLE_TEXT);
                answerFromMain = extras.getString(Constants.ANSWER_TEXT);
                riddleText.setText(riddleFromMain);
            }
        } else {
//            resultText.setText(savedInstanceState.getString("resultText"));
        }
    }
}