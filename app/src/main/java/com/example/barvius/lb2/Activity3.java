package com.example.barvius.lb2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        Author a = (Author) getIntent().getParcelableExtra(Author.class.getCanonicalName());
        String gr = getIntent().getStringExtra("group");
        TextView tw1 = findViewById(R.id.tw1_3);
        TextView tw2 = findViewById(R.id.tw2_3);
        TextView tw3 = findViewById(R.id.tw3_3);
        TextView tw4 = findViewById(R.id.tw4_3);
        TextView tw5 = findViewById(R.id.tw5_3);
        tw1.setText("Фамилия: " + a.getFirstName());
        tw2.setText("Имя: " + a.getLastName());
        tw3.setText("Отчество: " + a.getThirdName());
        tw4.setText("Ср. балл: " + Float.toString(a.getAvgValue()));
        tw5.setText("Группа: " + gr);
        Button btn = (Button) findViewById(R.id.button2);
        btn.setOnClickListener(oclBtn);
        Log.i("myAppLog", "Activity 3: create");
    }

    @Override
    public void onBackPressed() {
        back();
    }

    View.OnClickListener oclBtn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            back();
        }
    };

    private void back(){
        final String[] selectedItem = new String[1];
        final String[] list = {"Слабая", "Умеренная", "Сильная"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Интересна запись?");

        builder.setSingleChoiceItems(list, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent();
                intent.putExtra("str", "Степень заинтересованности: "+list[which]);
                setResult(RESULT_OK, intent);
                finish();
                Log.i("myAppLog", "Activity 3: sendResult");
            }
        });

        builder.setCancelable(false);
        builder.create().show();
    }
}
