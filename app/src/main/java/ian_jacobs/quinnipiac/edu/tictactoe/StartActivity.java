package ian_jacobs.quinnipiac.edu.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    //method that takes the text from textview.name and
    //passes it to the next view
    public void onEnter(View view){
        EditText text = (EditText)findViewById(R.id.name);
        String name = text.getText().toString();
        Intent intent = new Intent(this,TIcTacToeActivity.class);
        intent.putExtra("key", name);
        startActivity(intent);
    }
}
