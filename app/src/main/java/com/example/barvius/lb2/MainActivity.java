package com.example.barvius.lb2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("myAppLog", "Main activity: create");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null) {return;}
        String str = data.getStringExtra("str");
        Toast toast = Toast.makeText(getApplicationContext(),
                str, Toast.LENGTH_SHORT);
        toast.show();
        Log.i("myAppLog", "Main activity: resieveResult");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        menu.add(0, 0, 0, "Вторая активность").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                TextView fn = findViewById(R.id.fn);
                TextView ln = findViewById(R.id.ln);
                TextView tn = findViewById(R.id.tn);
                TextView avg = findViewById(R.id.avg);
                TextView gr = findViewById(R.id.gr);
                if(cut(fn.getText().toString()).matches("") || cut(ln.getText().toString()).matches("") || cut(tn.getText().toString()).matches("") || cut(avg.getText().toString()).matches("") || cut(gr.getText().toString()).matches("")){
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Заполните все поля!", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    Author a = new Author(fn.getText().toString(),ln.getText().toString(),tn.getText().toString(),Float.parseFloat(avg.getText().toString()));
                    Intent intent = new Intent(MainActivity.this, Activity2.class);
                    intent.putExtra(Author.class.getCanonicalName(), a);
                    startActivityForResult(intent, 1);
                    Log.i("myAppLog", "Main activity: send data to activity2");
                }
                return true;
            }
        });

        menu.add(0, 1, 0, "Третья активность").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                TextView fn = findViewById(R.id.fn);
                TextView ln = findViewById(R.id.ln);
                TextView tn = findViewById(R.id.tn);
                TextView avg = findViewById(R.id.avg);
                TextView gr = findViewById(R.id.gr);
                if(cut(fn.getText().toString()).matches("") || cut(ln.getText().toString()).matches("") || cut(tn.getText().toString()).matches("") || cut(avg.getText().toString()).matches("") || cut(gr.getText().toString()).matches("")){
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Заполните все поля!", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    Author a = new Author(fn.getText().toString(),ln.getText().toString(),tn.getText().toString(),Float.parseFloat(avg.getText().toString()));
                    Intent intent = new Intent("com.barvius.lb2.activity3");
                    intent.putExtra(Author.class.getCanonicalName(), a);
                    intent.putExtra("group", gr.getText().toString());
                    startActivityForResult(intent, 1);
                    Log.i("myAppLog", "Main activity: send data to activity3");
                }
                return true;
            }
        });

        return true;
    }

    String cut(String s){
        return s.trim();
    }

}
