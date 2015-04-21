package android.cs594.piggame;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    private FrameLayout die1, die2;
    private Button roll, hold;
    private int i1=0,i2=0,i3=0,i4=0,i5=0,i6=0;
    private TextView p1, p2,rounds;
     int val1;
    int val2;
    static int val3=0,val5=0;
    int sum = 0;
    private int[] val = new int[1];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        roll = (Button) findViewById(R.id.button);
         roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice();


            }
        });

        hold = (Button)findViewById(R.id.hold);
        hold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*The commented out code here was the code we used
                in class to send an integer to the next activty.
                It was replaced by an alert dialog to be used to indicate
                a winner (for demonstration purposes).
                Use the alert dialog code in your program where appropriate*/

                p1.setText("P1 : " + val5);
                p2.setText("P2 : "+android.cs594.piggame.Player2.val6);

                Intent intent = new Intent(android.cs594.piggame.MainActivity.this, Player2.class);
                intent.putExtra("score", val5);

                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);

               /* AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                alertDialog.setTitle("You Won!");
                alertDialog.setMessage("Yipeeaieahhh!");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();*/
            }

        });


        die1 = (FrameLayout) findViewById(R.id.die1);
        die2 = (FrameLayout) findViewById(R.id.die2);


    }

    //get two random ints between 1 and 6 inclusive
    public void rollDice() {
         val1 = 1 + (int) (6 * Math.random());
         val2 = 1 + (int) (6 * Math.random());
        setDie(val1, die1);
        setDie(val2, die2);
        p1.setText("P1: "+val5);
        p2.setText("P2: "+ Player2.val6);
        rounds.setText("Rounds: "+ Player2.round);
        if(val5>=100){
            AlertDialog alertDialog = new AlertDialog.Builder(android.cs594.piggame.MainActivity.this).create();
            alertDialog.setTitle("You Won!");
            alertDialog.setMessage("Player 1 won the game!");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
            Player2.round=0;
            val5 = 0;
            Player2.val6=0;


        }

    }

    //set the appropriate picture for each die per int
    public void setDie(int value, FrameLayout layout) {
        Drawable pic = null;

        switch (value) {
            case 1:
                pic = getResources().getDrawable(R.drawable.die_face_1);
                i1=1;
                break;
            case 2:
                pic = getResources().getDrawable(R.drawable.die_face_2);
                i2 = 2;
                break;
            case 3:
                pic = getResources().getDrawable(R.drawable.die_face_3);
                i3 = 3;
                break;
            case 4:
                pic = getResources().getDrawable(R.drawable.die_face_4);
                i4 = 4;
                break;
            case 5:
                pic = getResources().getDrawable(R.drawable.die_face_5);
                i5 = 5;
                break;
            case 6:
                pic = getResources().getDrawable(R.drawable.die_face_6);
                i6= 6;
                break;
        }
        layout.setBackground(pic);
                p1 = (TextView)findViewById(R.id.p1);
                p2 = (TextView) findViewById(R.id.p2);
                rounds = (TextView)findViewById(R.id.round);


                val3 = val1 + val2 ;
                val5 = val5+val3;





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
}
/*
* AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
alertDialog.setTitle("Alert");
alertDialog.setMessage("Alert message to be shown");
alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
    new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();
        }
    });
alertDialog.show();*/