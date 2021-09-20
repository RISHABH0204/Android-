package com.example.diceroller.db;




import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {User.class}, version =1)
@TypeConverters(DateConverter.class)
public abstract class AppDB extends RoomDatabase {
    public abstract UserDao userDao();
    public static final String DATABASE_NAME="appdatabase";
    public static volatile AppDB instance;
    private static final Object Lock=new Object();


    public static AppDB getInstance(Context context){
        if (instance==null)
            synchronized (Lock){
                if(instance==null){
                    instance=Room.databaseBuilder(context.getApplicationContext(),AppDB.class, DATABASE_NAME)
                            .allowMainThreadQueries()
                            .build();
                }
            }
        return instance;
    }

    /*private static AppDB INSTANCE;
    public static AppDB getDbInstance(Context context){
        if(INSTANCE== null){
            INSTANCE= Room.databaseBuilder(context.getApplicationContext(),AppDB.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build();

        }
        return INSTANCE;
     }*/

}
