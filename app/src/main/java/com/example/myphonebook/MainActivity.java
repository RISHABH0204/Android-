package com.example.myphonebook;

import static android.provider.ContactsContract.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> listContacts= new ArrayList<>();
    String name,number, id;
    public static final int code=1;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView) findViewById(R.id.contactlist);
        searchView=(SearchView) findViewById(R.id.search);
        enableRuntimePermission();
        displayContacts();




    }
    @SuppressLint("Range")
    public void displayContacts(){
        ContentResolver contentResolver= getContentResolver();
        Cursor cursor= contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null);
        if(cursor!=null && cursor.getCount()>0){
            while (cursor.moveToNext()){
                id= cursor.getString(cursor.getColumnIndex(Contacts._ID));
                name= cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                listContacts.add(name);
                if(Integer.parseInt(cursor.getString(cursor.getColumnIndex(Contacts.HAS_PHONE_NUMBER))) >0){
                    Cursor mCursor=contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID+" = ?",new String[]{id},null);
                    while (mCursor.moveToNext()){
                        number=mCursor.getString(mCursor.getColumnIndex(CommonDataKinds.Phone.NUMBER));
                        listContacts.add(number);
                    }
                }
                ArrayAdapter adapter=new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,listContacts);
                listView.setAdapter(adapter);

                
                searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String s) {
                        return false;
                    }

                    @Override
                    public boolean onQueryTextChange(String s) {
                        adapter.getFilter().filter(s);
                        return false;
                    }
                });
            }
        }
        cursor.close();

    }

    public void enableRuntimePermission(){
        if(ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, Manifest.permission.READ_CONTACTS))
        {
            Toast.makeText(MainActivity.this,"Contacts allows us to Access contacts",Toast.LENGTH_SHORT).show();
        }else{
            ActivityCompat.requestPermissions(MainActivity.this,new String[]{
                    Manifest.permission.READ_CONTACTS}, code);
        }

    }
}