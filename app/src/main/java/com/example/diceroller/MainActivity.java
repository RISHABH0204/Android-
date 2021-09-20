package com.example.diceroller;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.diceroller.db.AppDB;
import com.example.diceroller.db.User;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button mRoll, mHistory;
    ImageView imageView;
    Date date;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=findViewById(R.id.dice_image);
        mHistory=findViewById(R.id.his_button);
        mRoll=findViewById(R.id.roll_button);
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this)) ;

        mHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        mRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random=new Random();
                int num=random.nextInt(6)+1;
                switch(num){
                    case 1:
                        imageView.setImageResource(R.drawable.dice_1);
                        saveData(num, date);
                        break;
                    case 2:
                        imageView.setImageResource(R.drawable.dice_2);
                        saveData(num, date);
                        break;
                    case 3:
                        imageView.setImageResource(R.drawable.dice_3);
                        saveData(num,date);
                        break;
                    case 4:
                        imageView.setImageResource(R.drawable.dice_4);
                        saveData(num, date);
                        break;
                    case 5:
                        imageView.setImageResource(R.drawable.dice_5);
                        saveData(num, date);
                        break;
                    case 6:
                        imageView.setImageResource(R.drawable.dice_6);
                        saveData(num,date);
                        showmessage("Jackpot","It's a SIX");
                        break;
                }
            }

            private void saveData(int num, Date date) {

                AppDB db=AppDB.getInstance(getApplicationContext());
                User user= new User(num,Calendar.getInstance().getTime());
                user.setValue(String.valueOf(num));
                user.setDate(date);
                db.userDao().insertUser(user);
                finish();
            }


        });
    }
    public void showmessage(String title, String message) {
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}