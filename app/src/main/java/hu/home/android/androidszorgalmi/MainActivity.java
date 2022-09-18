package hu.home.android.androidszorgalmi;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBarRed;
    private SeekBar seekBarGreen;
    private SeekBar seekBarBlue;

    private TextView textViewRed;
    private TextView textViewGreen;
    private TextView textViewBlue;

    private TextView textViewDisplay;

    private int red;
    private int green;
    private int blue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        seekBarChanges();
    }

    private void colorChange(){
        textViewDisplay.setText(String.format("(%d, %d, %d)", red, green, blue));
        textViewDisplay.setBackgroundColor(Color.rgb(red, green, blue));
        if ((red + green + blue) < 140){
            textViewDisplay.setTextColor(Color.WHITE);
        } else {
            textViewDisplay.setTextColor(Color.BLACK);
        }
    }

    private void seekBarChanges(){
        seekBarRed.setMax(255);
        seekBarGreen.setMax(255);
        seekBarBlue.setMax(255);

        seekBarRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textViewRed.setText("Red: " + i);
                red = i;
                colorChange();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarGreen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textViewGreen.setText("Green: " + i);
                green = i;
                colorChange();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarBlue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textViewBlue.setText("Blue: " + i);
                blue = i;
                colorChange();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void init(){
        seekBarRed = findViewById(R.id.seekBarRed);
        seekBarGreen = findViewById(R.id.seekBarGreen);
        seekBarBlue = findViewById(R.id.seekBarBlue);

        textViewRed = findViewById(R.id.textViewRed);
        textViewGreen = findViewById(R.id.textViewGreen);
        textViewBlue = findViewById(R.id.textViewBlue);

        textViewDisplay = findViewById(R.id.textViewDisplay);
    }
}