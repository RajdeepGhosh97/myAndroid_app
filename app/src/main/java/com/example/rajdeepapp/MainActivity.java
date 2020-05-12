package com.example.rajdeepapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //VARIABLE CREATION
    private EditText amtTxt;
    private TextView inrTxt;
    private ImageButton btn;
    private Spinner spin;
    private int spin_index;
    private double inputValue;
    private double tot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            //FINDING VIEW BY ID
        inrTxt=(TextView) findViewById(R.id.inrTxt);
        btn = (ImageButton) findViewById(R.id.btn);
        spin = (Spinner) findViewById(R.id.spin);
        amtTxt=(EditText) findViewById(R.id.amtTxt);
        //Creating the drop_down spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.currency,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spin.setAdapter(adapter);
        //Creating spinner listener
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spin_index = position;

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Creating btn click Listener
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                if(amtTxt.getText().toString().trim().length() > 0 && !amtTxt.getText().toString().trim().equals("."))
                {
                    String textValue = amtTxt.getText().toString();
                    inputValue = Double.parseDouble(textValue);

                   if(spin_index == 0)
                   {
                       tot = (inputValue* 49.15);//AUD TO INR
                    //   inrTxt.setText(String.valueOf(tot));

                   }
                   else if(spin_index == 1)
                   {
                       tot = (inputValue*20.60);//AED TO INR
                     //  inrTxt.setText(String.valueOf(tot));
                   }
                   else if(spin_index == 2)
                   {
                       tot = (inputValue*54.14);//CAD TO INR
                    //   inrTxt.setText(String.valueOf(tot));
                   }
                   else if(spin_index == 3)
                   {
                       tot = (inputValue*10.68);//CNY TO INR
                      // inrTxt.setText(String.valueOf(tot));
                   }
                   else if(spin_index == 4)
                   {
                       tot = (inputValue*82.07);//EUR TO INR
                      // inrTxt.setText(String.valueOf(tot));
                   }
                   else if(spin_index == 5)
                   {
                       tot = (inputValue*93.62);//GBP TO INR
                    //   inrTxt.setText(String.valueOf(tot));
                   }
                   else if(spin_index == 6)
                   {
                       tot = (inputValue*0.71);//JPY TO INR
                       //inrTxt.setText(String.valueOf(tot));
                   }
                   else if(spin_index == 7)
                   {
                       tot = (inputValue*0.062);//KWR TO INR
                      // inrTxt.setText(String.valueOf(tot));
                   }
                   else if(spin_index == 8)
                   {
                       tot = (inputValue*1.02);//RUB TO INR
                      // inrTxt.setText(String.valueOf(tot));
                   }
                   else if(spin_index == 9)
                   {
                       tot = (inputValue*75.65);//USD TO INR
                     //  inrTxt.setText(String.valueOf(tot));
                   }
                    inrTxt.setText(String.valueOf(tot));
                   //new calculate().execute();
                }
                else{
                    String str = "Enter correct value";
                    Toast.makeText(MainActivity.this,str,Toast.LENGTH_LONG).show();
                }

            }
        });


    }

}