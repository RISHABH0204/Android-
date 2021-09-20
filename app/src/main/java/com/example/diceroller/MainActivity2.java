package com.example.diceroller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.diceroller.db.AppDB;
import com.example.diceroller.db.User;
import com.example.diceroller.db.UserDao;

import java.util.List;

public class MainActivity2 extends AppCompatActivity {


    private List<User> mUser;
    RecyclerView mRecyclerview;
    MyAdapter myAdapter;
    User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        mRecyclerview=findViewById(R.id.recyclerView);

    }
    private void showData(){
        //User user=new User(this, );
        AppDB myDb= AppDB.getInstance(this.getApplicationContext());
        mUser=myDb.userDao().getAllData();
        myAdapter = new MyAdapter(mUser);
        mRecyclerview.setAdapter(myAdapter);
    }
}