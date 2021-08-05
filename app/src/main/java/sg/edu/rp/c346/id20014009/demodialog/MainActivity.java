package sg.edu.rp.c346.id20014009.demodialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
Button btnDemo1,btnDemo2,btnDemo3, btnex3, btnDemo4,btnDemo5;
TextView tvDemo2, tvDemo3, tvTotal, tvDemo4,tvDemo5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDemo1=findViewById(R.id.buttonDemo1);
        btnDemo2=findViewById(R.id.buttonDemo2);
        btnDemo3=findViewById(R.id.buttonDemo3);
        btnex3=findViewById(R.id.btnex3);
        btnDemo4=findViewById(R.id.buttonDemo4);
        btnDemo5=findViewById(R.id.buttonDemo5);

        tvDemo2=findViewById(R.id.textViewDemo2);
        tvDemo3=findViewById(R.id.textViewDemo3);
        tvTotal=findViewById(R.id.tvTotal);
        tvDemo4=findViewById(R.id.textViewDemo4);
        tvDemo5=findViewById(R.id.textViewDemo5);


        btnDemo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder myBuilder=new AlertDialog.Builder(MainActivity.this);
                /*
                myBuilder.setTitle("Demo 1-Simple Dialog");
                myBuilder.setMessage("I can develop Android App.");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("Close",null);
                */

                myBuilder.setTitle("Congratulations");
                myBuilder.setMessage("You have completed a simple Dialog Box.");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("Dismiss",null);

                AlertDialog myDialog=myBuilder.create();
                myDialog.show();
            }
        });

        btnDemo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder myBuilder=new AlertDialog.Builder(MainActivity.this);

                myBuilder.setTitle("Demo 2 Buttons Dialog");
                myBuilder.setMessage("Select one of the Buttons below.");
                myBuilder.setCancelable(false);

                myBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvDemo2.setText("You have selected Positive.");
                    }
                });

                myBuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvDemo2.setText("You have selected Negative.");
                    }
                });

                myBuilder.setNeutralButton("Cancel",null);
                AlertDialog myDialog=myBuilder.create();
                myDialog.show();




            }
        });

        btnDemo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog=inflater.inflate(R.layout.input,null);

                final EditText etInput=viewDialog.findViewById(R.id.editTextInput);

                AlertDialog.Builder mybuilder=new AlertDialog.Builder(MainActivity.this);
                mybuilder.setView(viewDialog);
                mybuilder.setTitle("Demo 3-Text Input Dialog");
                mybuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String message=etInput.getText().toString();
                        tvDemo3.setText(message);
                    }
                });
                mybuilder.setNegativeButton("CANCEL",null);
                AlertDialog myDialog=mybuilder.create();
                myDialog.show();




            }
        });


        btnex3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog=inflater.inflate(R.layout.exercise3,null);

                final EditText etNum1=viewDialog.findViewById(R.id.editTextNumber1);
                final EditText etNum2=viewDialog.findViewById(R.id.editTextNumber2);

                AlertDialog.Builder mybuilder=new AlertDialog.Builder(MainActivity.this);
                mybuilder.setView(viewDialog);
                mybuilder.setTitle("Exercise 3");
                mybuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int total=Integer.valueOf(etNum1.getText().toString())+Integer.valueOf(etNum2.getText().toString());
                        String message="The sum is "+total;
                        tvTotal.setText(message);
                    }
                });
                mybuilder.setNegativeButton("CANCEL",null);
                AlertDialog myDialog=mybuilder.create();
                myDialog.show();


            }
        });

        btnDemo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog.OnDateSetListener myDateListener=new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        tvDemo4.setText("Date: "+dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
                    }
                };

                Calendar now=Calendar.getInstance();
                int year=now.get(Calendar.YEAR);
                int month=now.get(Calendar.MONTH);
                int day=now.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog myDateDialog=new DatePickerDialog(MainActivity.this,myDateListener,year,month,day);




                myDateDialog.show();
            }
        });


        btnDemo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog.OnTimeSetListener myTimeListener=new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        tvDemo5.setText("Time: "+hourOfDay+":"+minute);
                    }
                };

                TimePickerDialog myTimeDialog=new TimePickerDialog(MainActivity.this,myTimeListener,20,00,true);

                myTimeDialog.show();



            }
        });




    }
}