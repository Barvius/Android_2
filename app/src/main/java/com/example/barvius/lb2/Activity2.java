package com.example.barvius.lb2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        Author a = (Author) getIntent().getParcelableExtra(Author.class.getCanonicalName());
        TextView tw1 = findViewById(R.id.tw1_3);
        TextView tw2 = findViewById(R.id.tw2_3);
        TextView tw3 = findViewById(R.id.tw3_3);
        TextView tw4 = findViewById(R.id.tw4);
        tw1.setText("Фамилия: " + a.getFirstName());
        tw2.setText("Имя: " + a.getLastName());
        tw3.setText("Отчество: " + a.getThirdName());
        tw4.setText("Ср. балл: " + Float.toString(a.getAvgValue()));

        Button btn = (Button) findViewById(R.id.button1);
        btn.setOnClickListener(oclBtn);

        Log.i("myAppLog", "Activity 2: create");
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
        Intent intent = new Intent();
        intent.putExtra("str", "Данные получены");
        setResult(RESULT_OK, intent);
        finish();
        Log.i("myAppLog", "Activity 2: sendResult");
    }

}
