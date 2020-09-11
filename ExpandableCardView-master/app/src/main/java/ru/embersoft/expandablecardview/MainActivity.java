package ru.embersoft.expandablecardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout expandableView,expandableViewpoleData,expandableViewfeederData;
    Button arrowBtn;
    Button arrowButtonPole,getbtn,arrowBtnfeederData;
    CardView cardView,feederCardView;
    Switch poleSupport,spurs , threephase,swStreetLamp;
    Spinner conducterType,line_typenew;
    CheckBox feeder_one,feeder_two,feeder_three,feeder_four,feeder_five,feeder_six,feeder_seven,feeder_eight,feeder_nine,feeder_ten;
    TextView tvLatitude, tvLongitude, tvID,text_view_display_Longitude,text_view_display_Accuracy,text_view_display_Latitude;

    TextView tv;
    Button incrementer,decrementer;

    int count = 0;
    int quantity = 0;


    LinearLayout layoutspurs3phase1,layoutStreetLamp,layoutTransformerData,layoutspurs,layoutPole ,layoutLVpoledata,layoutConductorTypetwo,layoutOnePhase,layoutTwoPhase, layoutThreePhase,layoutLFedderData,layoutStreet,layoutConductorType,layoutConductorTypef2;
    LinearLayout layoutConductorTypeone,layoutConductorTypethree,layoutConductorTypef4,layoutConductorTypef5,layoutConductorTypef6,layoutConductorTypef7,layoutConductorTypef8,layoutConductorTypef9,layoutConductorTypef10;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expandableView = findViewById(R.id.expandableView);
        expandableViewpoleData = findViewById(R.id.expandableViewpoleData);
        expandableViewfeederData =  findViewById(R.id.expandableViewfeederData);
        arrowBtn = findViewById(R.id.arrowBtn);
        arrowButtonPole = findViewById(R.id.arrowBtnpoleData);
        arrowBtnfeederData = findViewById(R.id.arrowBtnfeederData);
        cardView = findViewById(R.id.cardView);
        conducterType = (Spinner)findViewById(R.id.line_type);
        line_typenew = (Spinner)findViewById(R.id.line_typenew);

        ImageView greenbadge = (ImageView)findViewById(R.id.greenbadge);
        ImageView redbadge = (ImageView)findViewById(R.id.redbadge);
        feederCardView  = findViewById(R.id.viewfeederata);

        swStreetLamp = (Switch)findViewById(R.id.swStreetLamp);

        layoutStreetLamp = (LinearLayout)findViewById(R.id.layoutStreetLamp);



        text_view_display_Latitude =  (TextView) findViewById(R.id.text_view_display_Latitude);
        text_view_display_Longitude = (TextView) findViewById(R.id.text_view_display_Longitude);

        text_view_display_Accuracy = (TextView) findViewById(R.id.text_view_display_Accuracy);

        tv=(EditText)findViewById(R.id.txttransformernofeeders);
        incrementer=findViewById(R.id.increment);
        decrementer = findViewById(R.id.decrement);





        layoutTransformerData = (LinearLayout)findViewById(R.id.layoutTransformerData);
        layoutLVpoledata = (LinearLayout)findViewById(R.id.layoutLVpoledata);
        layoutOnePhase = (LinearLayout)findViewById(R.id.onephase);

        layoutspurs = (LinearLayout)findViewById(R.id.layoutspurs);

        layoutTwoPhase = (LinearLayout)findViewById(R.id.twophase);

        layoutThreePhase = (LinearLayout)findViewById(R.id.threephase);

        layoutspurs3phase1 = (LinearLayout)findViewById(R.id.layoutspurs3phase1);

        layoutPole = (LinearLayout)findViewById(R.id.layoutPoleSupport);
        layoutConductorTypeone =  layoutConductorType =(LinearLayout)findViewById(R.id.layoutConductorTypeone);
        layoutConductorType =(LinearLayout)findViewById(R.id.layoutConductorType);
        layoutConductorTypetwo  = (LinearLayout)findViewById(R.id.layoutConductorTypetwo);
        layoutConductorTypethree  = (LinearLayout)findViewById(R.id.layoutConductorTypethree);
        layoutConductorTypef4  = (LinearLayout)findViewById(R.id.layoutConductorTypefour);
        layoutConductorTypef5 = (LinearLayout)findViewById(R.id.layoutConductorTypefive);
        layoutConductorTypef6 = (LinearLayout)findViewById(R.id.layoutConductorTypesix);
        layoutConductorTypef7 = (LinearLayout)findViewById(R.id.layoutConductorTypeseven);
        layoutConductorTypef8 = (LinearLayout)findViewById(R.id.layoutConductorTypeeight);
        layoutConductorTypef9  = (LinearLayout)findViewById(R.id.layoutConductorTypenine);
        layoutConductorTypef10  = (LinearLayout)findViewById(R.id.layoutConductorTypeten);


        feeder_one = (CheckBox)findViewById(R.id.feeder_f1);
        feeder_two = (CheckBox)findViewById(R.id.feeder_f2);
        feeder_three = (CheckBox)findViewById(R.id.feeder_f3);
        feeder_four = (CheckBox)findViewById(R.id.feeder_f4);
        feeder_five = (CheckBox)findViewById(R.id.feeder_f5);
        feeder_six = (CheckBox)findViewById(R.id.feeder_f6);
        feeder_seven = (CheckBox)findViewById(R.id.feeder_f7);
        feeder_eight = (CheckBox)findViewById(R.id.feeder_f8);
        feeder_nine = (CheckBox)findViewById(R.id.feeder_f9);
        feeder_ten = (CheckBox)findViewById(R.id.feeder_10);
        spurs = (Switch)findViewById(R.id.spurs);
        threephase= (Switch)findViewById(R.id.spurs3phaseSwitch);

        poleSupport = (Switch)findViewById(R.id.polesupport);


//Extracting the stored data from the bundle55544tt
        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            String valueLaongitude = bundle.getString("Longitude");

            String valueLatitude = bundle.getString("Latitude");
            String valueAccuarcy= bundle.getString("Accuracy");

          double valueAccuarcytwo = Double.parseDouble( bundle.getString("Accuracy"));



            TextView textViewLaongitude = findViewById(R.id.text_view_display_Longitude);
            TextView textViewLatitude = findViewById(R.id.text_view_display_Latitude);
            TextView textViewAccuracy =   findViewById(R.id.text_view_display_Accuracy);

            textViewLaongitude.setText(valueLaongitude);
            textViewLatitude.setText(valueLatitude);
            textViewAccuracy.setText(valueAccuarcy);

            if(valueAccuarcytwo <= 50)
            {

                textViewAccuracy.setTextColor(Color.rgb(24,203,80));

                greenbadge.setVisibility(View.VISIBLE);
                redbadge.setVisibility(View.GONE);

            }
            else {
                textViewAccuracy.setTextColor(Color.RED);
                redbadge.setVisibility(View.VISIBLE);
                greenbadge.setVisibility(View.GONE);
         ;
            }

        }


        tv.setText("1");
        incrementer.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // score operation like score += increment_value;



                String present_value_string = tv.getText().toString();

                    int present_value_int = Integer.parseInt(present_value_string);
                    present_value_int++;
                    tv.setText(String.valueOf(present_value_int));





            }
        });



        decrementer.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // score operation like score += increment_value;

                String present_value_string = tv.getText().toString();
                int present_value_int = Integer.parseInt(present_value_string);
                present_value_int--;

                tv.setText(String.valueOf(present_value_int));
            }
        });





        arrowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expandableView.getVisibility()==View.GONE){
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    expandableView.setVisibility(View.VISIBLE);
                    expandableViewpoleData.setVisibility(View.GONE);

                    arrowBtn.setBackgroundResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
                } else {
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    expandableView.setVisibility(View.GONE);


                    arrowBtn.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                }
            }
        });

        arrowButtonPole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expandableViewpoleData.getVisibility()==View.GONE){
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    expandableViewpoleData.setVisibility(View.VISIBLE);
                    expandableView.setVisibility(View.GONE);

                    arrowButtonPole.setBackgroundResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
                } else {
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    expandableViewpoleData.setVisibility(View.GONE);


                    arrowButtonPole.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                }
            }
        });


       /* arrowBtnfeederData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expandableViewfeederData.getVisibility()==View.GONE){
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    expandableViewfeederData.setVisibility(View.VISIBLE);
                    expandableView.setVisibility(View.GONE);
                    arrowButtonPole.setBackgroundResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
                } else {
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    expandableViewfeederData.setVisibility(View.GONE);
                    arrowButtonPole.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                }
            }
        });*/

        poleSupport.setOnClickListener(new View.OnClickListener() {   // inside oncreate
            @Override
            public void onClick(View view) {

                if( poleSupport.isChecked() ){
                    layoutPole.setVisibility(view.VISIBLE);
                }
                else
                {
                    layoutPole.setVisibility(view.GONE);
                }
            }
        });


        spurs.setOnClickListener(new View.OnClickListener() {   // inside oncreate
            @Override
            public void onClick(View view) {

                if( spurs.isChecked() ){
                    layoutspurs.setVisibility(view.VISIBLE);
                }
                else
                {
                    layoutspurs.setVisibility(view.GONE);
                }
            }
        });

        threephase.setOnClickListener(new View.OnClickListener() {   // inside oncreate
            @Override
            public void onClick(View view) {

                if( threephase.isChecked() ){
                    layoutspurs3phase1.setVisibility(view.VISIBLE);
                }
                else
                {
                    layoutspurs3phase1.setVisibility(view.GONE);
                }
            }
        });





        swStreetLamp.setOnClickListener(new View.OnClickListener() {   // inside oncreate
            @Override
            public void onClick(View view) {

                if( swStreetLamp.isChecked() ){
                    layoutStreetLamp.setVisibility(view.VISIBLE);
                }
                else
                {
                    layoutStreetLamp.setVisibility(view.GONE);
                }
            }
        });


















        conducterType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String point_type =  conducterType.getSelectedItem().toString();
                if (point_type.equals("1P AAC")) {

                    layoutTwoPhase.setVisibility(view.GONE);
                    layoutThreePhase.setVisibility(view.GONE);
                    layoutOnePhase.setVisibility(view.VISIBLE);

                } else if(point_type.equals("1P ABC")) {

                    layoutTwoPhase.setVisibility(view.GONE);
                    layoutThreePhase.setVisibility(view.GONE);
                    layoutOnePhase.setVisibility(view.VISIBLE);


                }else if(point_type.equals("2P AAC")){
                    layoutTwoPhase.setVisibility(view.VISIBLE);
                    layoutThreePhase.setVisibility(view.GONE);
                    layoutOnePhase.setVisibility(view.GONE);
                }
                else if(point_type.equals("2P ABC")){
                    layoutTwoPhase.setVisibility(view.VISIBLE);
                    layoutThreePhase.setVisibility(view.GONE);
                    layoutOnePhase.setVisibility(view.GONE);
                }
                else if(point_type.equals("3P AAC")){
                    layoutTwoPhase.setVisibility(view.GONE);
                    layoutThreePhase.setVisibility(view.VISIBLE);
                    layoutOnePhase.setVisibility(view.GONE);
                }
                else if(point_type.equals("3P ABC")){
                    layoutTwoPhase.setVisibility(view.GONE);
                    layoutThreePhase.setVisibility(view.VISIBLE);
                    layoutOnePhase.setVisibility(view.GONE);
                }
                else if(point_type.equals("3P AAC Lamp")){
                    layoutTwoPhase.setVisibility(view.GONE);
                    layoutThreePhase.setVisibility(view.VISIBLE);
                    layoutOnePhase.setVisibility(view.GONE);
                }
                else if(point_type.equals("3P ABC Lamp")){
                    layoutTwoPhase.setVisibility(view.GONE);
                    layoutThreePhase.setVisibility(view.VISIBLE);
                    layoutOnePhase.setVisibility(view.GONE);
                }



                else{
                    layoutTwoPhase.setVisibility(view.GONE);
                    layoutOnePhase.setVisibility(view.GONE);
                    layoutThreePhase.setVisibility(view.GONE);
                }
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });


        line_typenew.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String point_type =  conducterType.getSelectedItem().toString();
                if (point_type.equals("1P AAC")) {

                    layoutTwoPhase.setVisibility(view.GONE);
                    layoutThreePhase.setVisibility(view.GONE);
                    layoutOnePhase.setVisibility(view.VISIBLE);

                } else if(point_type.equals("1P ABC")) {

                    layoutTwoPhase.setVisibility(view.GONE);
                    layoutThreePhase.setVisibility(view.GONE);
                    layoutOnePhase.setVisibility(view.VISIBLE);


                }else if(point_type.equals("2P AAC")){
                    layoutTwoPhase.setVisibility(view.VISIBLE);
                    layoutThreePhase.setVisibility(view.GONE);
                    layoutOnePhase.setVisibility(view.GONE);
                }
                else if(point_type.equals("2P ABC")){
                    layoutTwoPhase.setVisibility(view.VISIBLE);
                    layoutThreePhase.setVisibility(view.GONE);
                    layoutOnePhase.setVisibility(view.GONE);
                }
                else if(point_type.equals("3P AAC")){
                    layoutTwoPhase.setVisibility(view.GONE);
                    layoutThreePhase.setVisibility(view.VISIBLE);
                    layoutOnePhase.setVisibility(view.GONE);
                }
                else if(point_type.equals("3P ABC")){
                    layoutTwoPhase.setVisibility(view.GONE);
                    layoutThreePhase.setVisibility(view.VISIBLE);
                    layoutOnePhase.setVisibility(view.GONE);
                }
                else if(point_type.equals("3P AAC Lamp")){
                    layoutTwoPhase.setVisibility(view.GONE);
                    layoutThreePhase.setVisibility(view.VISIBLE);
                    layoutOnePhase.setVisibility(view.GONE);
                }
                else if(point_type.equals("3P ABC Lamp")){
                    layoutTwoPhase.setVisibility(view.GONE);
                    layoutThreePhase.setVisibility(view.VISIBLE);
                    layoutOnePhase.setVisibility(view.GONE);
                }



                else{
                    layoutTwoPhase.setVisibility(view.GONE);
                    layoutOnePhase.setVisibility(view.GONE);
                    layoutThreePhase.setVisibility(view.GONE);
                }
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });
    }






    public void onCheckboxClicked(View view) {


        boolean checked = ((CheckBox) view).isChecked();


        switch(view.getId()) {

            case R.id.feeder_f1:
                if (feeder_one.isChecked()){
                    layoutConductorTypeone.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(), "F1 Selected", Toast.LENGTH_LONG).show();
                }
                //  c1 is cheked
                 else
                    layoutConductorTypeone.setVisibility(View.GONE);
                break;
            case R.id.feeder_f2:
                if (feeder_two.isChecked()){
                    layoutConductorTypetwo.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(), "F2 Selected", Toast.LENGTH_LONG).show();
                }
                // c2: is cheked
                else
                    // c2: is ubcheked
                    layoutConductorTypetwo.setVisibility(View.GONE);
                break;

            case R.id.feeder_f3:
                if (feeder_three.isChecked()){
                    layoutConductorTypethree.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(), "F3 Selected", Toast.LENGTH_LONG).show();
                }
                // c2: is cheked
                else
                    // c2: is ubcheked
                    layoutConductorTypethree.setVisibility(View.GONE);

                break;
            case R.id.feeder_f4:
                if (feeder_four.isChecked()){
                    layoutConductorTypef4.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(), "F4 Selected", Toast.LENGTH_LONG).show();
                }
                // c2: is cheked
                else
                    // c2: is ubcheked
                    layoutConductorTypef4.setVisibility(View.GONE);
                break;

            case R.id.feeder_f5:
                if (feeder_five.isChecked()){
                    layoutConductorTypef5.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(), "F5 Selected", Toast.LENGTH_LONG).show();
                }
                // c2: is cheked
                else
                    // c2: is ubcheked
                    layoutConductorTypef5.setVisibility(View.GONE);
                break;
            case R.id.feeder_f6:
                if (feeder_six.isChecked()){
                    layoutConductorTypef6.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(), "F6 Selected", Toast.LENGTH_LONG).show();
                }
                // c2: is cheked
                else
                    // c2: is ubcheked
                    layoutConductorTypef6.setVisibility(View.GONE);
                break;


            case R.id.feeder_f7:
                if (feeder_seven.isChecked()){
                    layoutConductorTypef7.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(), "F7 Selected", Toast.LENGTH_LONG).show();
                }
                // c2: is cheked
                else
                    // c2: is ubcheked
                    layoutConductorTypef7.setVisibility(View.GONE);
                break;


            case R.id.feeder_f8:
                if (feeder_eight.isChecked()){
                    layoutConductorTypef8.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(), "F8 Selected", Toast.LENGTH_LONG).show();
                }
                // c2: is cheked
                else
                    // c2: is ubcheked
                    layoutConductorTypef8.setVisibility(View.GONE);
                break;

            case R.id.feeder_f9:
                if (feeder_nine.isChecked()){
                    layoutConductorTypef9.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(), "F9 Selected", Toast.LENGTH_LONG).show();
                }
                // c2: is cheked
                else
                    // c2: is ubcheked
                    layoutConductorTypef9.setVisibility(View.GONE);
                break;


            case R.id.feeder_10:
                if (feeder_ten.isChecked()){
                    layoutConductorTypef10.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(), "F10 Selected", Toast.LENGTH_LONG).show();
                }
                // c2: is cheked
                else
                    // c2: is ubcheked
                    layoutConductorTypef10.setVisibility(View.GONE);
                break;


        }
    }







}
