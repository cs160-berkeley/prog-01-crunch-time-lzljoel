package com.example.joel.crunchtime;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    private int calories = 0;
    private TextSwitcher mSwitcher1;
    private TextSwitcher mSwitcher2;
    private int equalAmount = 0;
    private double amount = 0;
    private RadioGroup groupFrom, groupTo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //for displaying calories
        mSwitcher1 = (TextSwitcher) findViewById(R.id.switcher1);

        //for displaying equivalent amount of exercise
        mSwitcher2 = (TextSwitcher) findViewById(R.id.switcher2);

        // Set the factory used to create TextViews to switch between
        mSwitcher1.setFactory(mFactory);
        mSwitcher2.setFactory(mFactory);

        //Setting the animation for the switchers
        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.fade_out);
        mSwitcher1.setInAnimation(in);
        mSwitcher2.setOutAnimation(out);

        onClickListenerButton();
        mSwitcher1.setCurrentText(String.valueOf(calories));
        mSwitcher2.setCurrentText(String.valueOf(equalAmount));

    }

    public void onClickListenerButton(){
        groupFrom = (RadioGroup) findViewById(R.id.radioGroup1);
        groupTo = (RadioGroup) findViewById(R.id.radioGroup2);
        Button b = (Button) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                try{
                    EditText editText = (EditText) findViewById(R.id.numExercise);
                    String exerciseInput = editText.getText().toString();
                    amount = Integer.parseInt(exerciseInput);
                }
                catch(Exception e){

                }
                int idFrom = groupFrom.getCheckedRadioButtonId();
                int idTo = groupTo.getCheckedRadioButtonId();
                // Check which radio button was clicked
                switch(idFrom) {
                    case R.id.pushup1:
                        calories =(int)Math.round(amount/350*100);
                        mSwitcher1.setText(String.valueOf(calories));
                        switch(idTo){
                            case R.id.pushup2:
                                equalAmount = (int) amount;
                                mSwitcher2.setText(String.valueOf(equalAmount));
                                break;
                            case R.id.situp2:
                                equalAmount = (int) Math.round(amount/350*200);
                                mSwitcher2.setText(String.valueOf(equalAmount));
                                break;
                            case R.id.jump2:
                                equalAmount = (int) Math.round(amount/350*10);
                                mSwitcher2.setText(String.valueOf(equalAmount));
                                break;
                            case R.id.jogging2:
                                equalAmount = (int) Math.round(amount/350*12);
                                mSwitcher2.setText(String.valueOf(equalAmount));
                                break;
                        }
                        break;
                    case R.id.situp1:
                        calories =(int) Math.round(amount/200*100);
                        mSwitcher1.setText(String.valueOf(calories));
                        switch(idTo){
                            case R.id.pushup2:
                                equalAmount = (int) Math.round(amount/200*350);
                                mSwitcher2.setText(String.valueOf(equalAmount));
                                break;
                            case R.id.situp2:
                                equalAmount = (int) Math.round(amount);
                                mSwitcher2.setText(String.valueOf(equalAmount));
                                break;
                            case R.id.jump2:
                                equalAmount = (int) Math.round(amount/200*10);
                                mSwitcher2.setText(String.valueOf(equalAmount));
                                break;
                            case R.id.jogging2:
                                equalAmount = (int) Math.round(amount/200*12);
                                mSwitcher2.setText(String.valueOf(equalAmount));
                                break;
                        }
                        break;
                    case R.id.jump1:
                        calories = (int)Math.round(amount/10*100);
                        mSwitcher1.setText(String.valueOf(calories));
                        switch(idTo){
                            case R.id.pushup2:
                                equalAmount = (int) Math.round(amount/10*350);
                                mSwitcher2.setText(String.valueOf(equalAmount));
                                break;
                            case R.id.situp2:
                                equalAmount = (int) Math.round(amount/10*200);
                                mSwitcher2.setText(String.valueOf(equalAmount));
                                break;
                            case R.id.jump2:
                                equalAmount = (int) Math.round(amount);
                                mSwitcher2.setText(String.valueOf(equalAmount));
                                break;
                            case R.id.jogging2:
                                equalAmount = (int) Math.round(amount/10*12);
                                mSwitcher2.setText(String.valueOf(equalAmount));
                                break;
                        }
                        break;
                    case R.id.jogging1:
                        calories = (int) Math.round(amount/12*100);
                        mSwitcher1.setText(String.valueOf(calories));
                        switch(idTo){
                            case R.id.pushup2:
                                equalAmount = (int) Math.round(amount/12*350);
                                mSwitcher2.setText(String.valueOf(equalAmount));
                                break;
                            case R.id.situp2:
                                equalAmount = (int) Math.round(amount/12*200);
                                mSwitcher2.setText(String.valueOf(equalAmount));
                                break;
                            case R.id.jump2:
                                equalAmount = (int) Math.round(amount/12*10);
                                mSwitcher2.setText(String.valueOf(equalAmount));
                                break;
                            case R.id.jogging2:
                                equalAmount = (int) Math.round(amount);
                                mSwitcher2.setText(String.valueOf(equalAmount));
                                break;
                        }
                        break;
                }
            }
        });

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


    private ViewSwitcher.ViewFactory mFactory = new ViewSwitcher.ViewFactory() {

        @Override
        public View makeView() {

            // Create a new TextView
            TextView t = new TextView(MainActivity.this);
            t.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
            t.setTextAppearance(MainActivity.this, android.R.style.TextAppearance_Large);
            return t;
        }
    };
}
