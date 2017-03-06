package ian_jacobs.quinnipiac.edu.tictactoe;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class TIcTacToeActivity extends AppCompatActivity {

    //create an instance of the tic tac toe interface
    ITicTacToe ttt = new TicTacToe();



    //method used to save the state of the the board and buttons
    @Override public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        //save button 1
        BitmapDrawable draw=(BitmapDrawable)((ImageButton)findViewById(R.id.one)).getDrawable();
        Bitmap bmp = ((BitmapDrawable)draw).getBitmap();
        outState.putParcelable("one", bmp);
        //save button 2
        BitmapDrawable draw2=(BitmapDrawable)((ImageButton)findViewById(R.id.two)).getDrawable();
        Bitmap bmp2 = ((BitmapDrawable)draw2).getBitmap();
        outState.putParcelable("two", bmp2);
        //save button 3
        BitmapDrawable draw3=(BitmapDrawable)((ImageButton)findViewById(R.id.three)).getDrawable();
        Bitmap bmp3 = ((BitmapDrawable)draw3).getBitmap();
        outState.putParcelable("three", bmp3);
        //save button 4
        BitmapDrawable draw4=(BitmapDrawable)((ImageButton)findViewById(R.id.four)).getDrawable();
        Bitmap bmp4 = ((BitmapDrawable)draw4).getBitmap();
        outState.putParcelable("four", bmp4);
        //save button 5
        BitmapDrawable draw5=(BitmapDrawable)((ImageButton)findViewById(R.id.five)).getDrawable();
        Bitmap bmp5 = ((BitmapDrawable)draw5).getBitmap();
        outState.putParcelable("five", bmp5);
        //save button 6
        BitmapDrawable draw6=(BitmapDrawable)((ImageButton)findViewById(R.id.six)).getDrawable();
        Bitmap bmp6 = ((BitmapDrawable)draw6).getBitmap();
        outState.putParcelable("six", bmp6);
        //save button 7
        BitmapDrawable draw7=(BitmapDrawable)((ImageButton)findViewById(R.id.seven)).getDrawable();
        Bitmap bmp7 = ((BitmapDrawable)draw7).getBitmap();
        outState.putParcelable("seven", bmp7);
        //save button 8
        BitmapDrawable draw8=(BitmapDrawable)((ImageButton)findViewById(R.id.eight)).getDrawable();
        Bitmap bmp8 = ((BitmapDrawable)draw8).getBitmap();
        outState.putParcelable("eight", bmp8);
        //save button 0
        BitmapDrawable draw0=(BitmapDrawable)((ImageButton)findViewById(R.id.zero)).getDrawable();
        Bitmap bmp0 = ((BitmapDrawable)draw0).getBitmap();
        outState.putParcelable("zero", bmp0);

        //save state of the board
        String board = ttt.getBoard();
        outState.putString("board", board);


        //save the game state
        TextView v = (TextView)findViewById(R.id.status);
        String out = v.getText().toString();
        outState.putString("state", out);


        super.onSaveInstanceState(outState);

    }

    //method used to restore the saved instances
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);

        //load the save state of button 0
        Bitmap bmp0=  savedInstanceState.getParcelable("zero");
        ((ImageButton)findViewById(R.id.zero)).setImageBitmap(bmp0);
        //load save state of button 1
        Bitmap bmp=  savedInstanceState.getParcelable("one");
        ((ImageButton)findViewById(R.id.one)).setImageBitmap(bmp);
        //load the save state of button 2
        Bitmap bmp2=  savedInstanceState.getParcelable("two");
        ((ImageButton)findViewById(R.id.two)).setImageBitmap(bmp2);
        //load the save state of button 3
        Bitmap bmp3=  savedInstanceState.getParcelable("three");
        ((ImageButton)findViewById(R.id.three)).setImageBitmap(bmp3);
        //load the save state of button 4
        Bitmap bmp4=  savedInstanceState.getParcelable("four");
        ((ImageButton)findViewById(R.id.four)).setImageBitmap(bmp4);
        //load the save state of button 5
        Bitmap bmp5=  savedInstanceState.getParcelable("five");
        ((ImageButton)findViewById(R.id.five)).setImageBitmap(bmp5);
        //load the save state of button 6
        Bitmap bmp6=  savedInstanceState.getParcelable("six");
        ((ImageButton)findViewById(R.id.six)).setImageBitmap(bmp6);
        //load the save state of button 7
        Bitmap bmp7=  savedInstanceState.getParcelable("seven");
        ((ImageButton)findViewById(R.id.seven)).setImageBitmap(bmp7);
        //load the save state of button 8
        Bitmap bmp8=  savedInstanceState.getParcelable("eight");
        ((ImageButton)findViewById(R.id.eight)).setImageBitmap(bmp8);


        //load in the board
        String in = savedInstanceState.getString("board");
        ttt.setUP(in);

        //load in the game status
        String out = savedInstanceState.getString("state");
        TextView v = (TextView)findViewById(R.id.status);
        v.setText(out);
        v.setTextColor(Color.WHITE);
    }


    //method called when the activity is created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe);
        //intent to get the name from previous activity
        Intent intent = getIntent();
        String name = intent.getStringExtra("key");
        TextView welcome = (TextView)findViewById(R.id.name);
        welcome.setText("HI " + name + "!");
        if(savedInstanceState != null){
            onRestoreInstanceState(savedInstanceState);                 //if needed to restore state call onRestore used when orientation changed
        }
    }

    //set all the buttons to a blank image
    public void clearButtons(){
        ImageButton btn = (ImageButton)findViewById(R.id.zero);
        btn.setImageResource(R.drawable.blank);
        ImageButton btn1 = (ImageButton)findViewById(R.id.one);
        btn1.setImageResource(R.drawable.blank);
        ImageButton btn2 = (ImageButton)findViewById(R.id.two);
        btn2.setImageResource(R.drawable.blank);
        ImageButton btn3 = (ImageButton)findViewById(R.id.three);
        btn3.setImageResource(R.drawable.blank);
        ImageButton btn4 = (ImageButton)findViewById(R.id.four);
        btn4.setImageResource(R.drawable.blank);
        ImageButton btn5 = (ImageButton)findViewById(R.id.five);
        btn5.setImageResource(R.drawable.blank);
        ImageButton btn6 = (ImageButton)findViewById(R.id.six);
        btn6.setImageResource(R.drawable.blank);
        ImageButton btn7 = (ImageButton)findViewById(R.id.seven);
        btn7.setImageResource(R.drawable.blank);
        ImageButton btn8 = (ImageButton)findViewById(R.id.eight);
        btn8.setImageResource(R.drawable.blank);
    }

    //set the tile for the move of the computer
    public void setCompTile(int local){
        ImageButton btn1 = (ImageButton)findViewById(R.id.zero); //create image button
        switch (local) {                                           //switch to get the id of the locatoin
            case 0 : btn1 = (ImageButton)findViewById(R.id.zero); break;
            case 1 : btn1 = (ImageButton)findViewById(R.id.one); break;
            case 2 : btn1 = (ImageButton)findViewById(R.id.two); break;
            case 3 : btn1 = (ImageButton)findViewById(R.id.three); break;
            case 4 : btn1 = (ImageButton)findViewById(R.id.four); break;
            case 5 : btn1 = (ImageButton)findViewById(R.id.five); break;
            case 6 : btn1 = (ImageButton)findViewById(R.id.six); break;
            case 7 : btn1 = (ImageButton)findViewById(R.id.seven); break;
            case 8 : btn1 = (ImageButton)findViewById(R.id.eight); break;
        }
        btn1.setImageResource(R.drawable.nought);       //set the image
    }

    //check the status of the game
    public void statusCheck(){

        String status = "";

        switch (ttt.checkForWinner()){                          //call checkforwinner
            case 0 : status = "playing"; break;                 //if no winner return playing
            case 1 : status = "Tie"; ttt.clearBoard(); clearButtons(); break;   //if tie reset board print tie
            case 2 : status = "Cross Won!"; ttt.clearBoard(); clearButtons(); break; //if win reset board print winner
            case 3 : status = "Nought Won!"; ttt.clearBoard(); clearButtons(); break; //if win reset board print winner
        }

        TextView out = (TextView)findViewById(R.id.status);     //set the status text
        out.setText(status);
        out.setTextColor(Color.WHITE);
    }


    //method to reset the board and status
    public void restart(View view){
        ttt.clearBoard();
        clearButtons(); //clear the board
        TextView out = (TextView)findViewById(R.id.status); //clear status
        out.setText("");
    }

    //button click method for button one
    public void onClickOne(View view){
        if(ttt.setMove(1,0) == true) {                              //if a move is possible in this location
            ImageButton btn = (ImageButton) findViewById(R.id.zero); //set the button
            btn.setImageResource(R.drawable.cross);
            ttt.setMove(1, 0);                                        //make the move
        }
        int cMove = ttt.getComputerMove();                              //have the computer make a move
        ttt.setMove(2, cMove);
        setCompTile(cMove);                                             //set the tile for the computer
        statusCheck();                                                  // check the status
    }


    //button click method for button two
    public void onClickTwo(View view){
        if(ttt.setMove(1,1) == true) {                                  //if the move is possible in this locatoin
            ImageButton btn = (ImageButton) findViewById(R.id.one);     //set the buttton and the move
            btn.setImageResource(R.drawable.cross);
            ttt.setMove(1, 1);
        }
        int cMove = ttt.getComputerMove();                              //set the button image and the move
        ttt.setMove(2, cMove);
        setCompTile(cMove);
        statusCheck();                                                  //check for winner
    }

    //button listener for button three
    public void onClickThree(View view){
        if(ttt.setMove(1,2) == true) {                                  //if the move is possbile in this location
            ImageButton btn = (ImageButton) findViewById(R.id.two);     //set the button and the move
            btn.setImageResource(R.drawable.cross);
            ttt.setMove(1, 2);
        }
        int cMove = ttt.getComputerMove();                              //set computer move and button
        ttt.setMove(2, cMove);
        setCompTile(cMove);
        statusCheck();                                                  //check game status

    }

    //butten click method for button four
    public void onClickFour(View view){
        if(ttt.setMove(1,3) == true) {                                  //check if move is possible in this locatoin
            ImageButton btn = (ImageButton) findViewById(R.id.three);   //set the button and the move for the player
            btn.setImageResource(R.drawable.cross);
            ttt.setMove(1, 3);
        }
        int cMove = ttt.getComputerMove();                              //set computer move and button
        ttt.setMove(2, cMove);
        setCompTile(cMove);
        statusCheck();                                                  //check game status
    }

    //button click method for button five
    public void onClickFive(View view){
        if(ttt.setMove(1,4) == true) {                                  //check if the move is possible in this location
            ImageButton btn = (ImageButton) findViewById(R.id.four);    //set the button and the move for the player
            btn.setImageResource(R.drawable.cross);
            ttt.setMove(1, 4);
        }
        int cMove = ttt.getComputerMove();                              //set the computer move and button
        ttt.setMove(2, cMove);
        setCompTile(cMove);
        statusCheck();                                                  //check game status
    }

    //button click for button six
    public void onClickSix(View view){
        if(ttt.setMove(1,5) == true) {                                  //check if the move is possible in this location
        ImageButton btn = (ImageButton) findViewById(R.id.five);        //ser the button and the move for player
            btn.setImageResource(R.drawable.cross);
            ttt.setMove(1, 5);
        }
        int cMove = ttt.getComputerMove();                              //set computer move and button
        ttt.setMove(2, cMove);
        setCompTile(cMove);
        statusCheck();                                                  //check game status
    }

    //button click method for button seven
    public void onClickSeven(View view){
        if(ttt.setMove(1,6) == true) {                                  //check if the move is possible in this location
            ImageButton btn = (ImageButton) findViewById(R.id.six);     //set player move and button
            btn.setImageResource(R.drawable.cross);
            ttt.setMove(1, 6);
        }
        int cMove = ttt.getComputerMove();                              //set computer button and move
        ttt.setMove(2, cMove);
        setCompTile(cMove);
        statusCheck();                                                  //check the game status
    }

    //button click method for button eight
    public void onClickEight(View view){
        if(ttt.setMove(1,7) == true) {                                  //check if the move is possibl in this location
            ImageButton btn = (ImageButton) findViewById(R.id.seven);   //set the player move and button
            btn.setImageResource(R.drawable.cross);
            ttt.setMove(1, 7);
        }
        int cMove = ttt.getComputerMove();                              //set computer move and button
        ttt.setMove(2, cMove);
        setCompTile(cMove);
        statusCheck();                                                  //check the game status
    }

    //button click for button nine
    public void onClickNine(View view) {
    if(ttt.setMove(1,8) == true) {                                      //check if the move is p[ossible in this location
            ImageButton btn = (ImageButton) findViewById(R.id.eight);   //set the player move and button
            btn.setImageResource(R.drawable.cross);
            ttt.setMove(1, 8);
        }
        int cMove = ttt.getComputerMove();                              //set the computer move and location
        ttt.setMove(2, cMove);
        setCompTile(cMove);
        statusCheck();                                                  //check the game status
    }

}
