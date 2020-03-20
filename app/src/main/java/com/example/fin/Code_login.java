package com.example.fin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Code_login extends AppCompatActivity {
    EditText ldt;
    private DatabaseReference myRef;
    note_details note_detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_login);
        ldt= findViewById(R.id.log_edt);



    }

    public void log(View view) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Note");

        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            boolean flage=true;
            note_details nota;
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {




                for (DataSnapshot childDataSnapshot : dataSnapshot.getChildren()) {

                    if (childDataSnapshot.getValue(note_details.class).getId().equals(ldt.getText().toString().trim()))
                    {
                        nota= childDataSnapshot.getValue(note_details.class);
                        flage=false;


                    }
                }
                if(flage)
                    Toast.makeText(Code_login.this,"enter a right code", Toast.LENGTH_SHORT).show();
                else{
                    Intent j=new Intent(Code_login.this,Final_code.class);
                    j.putExtra("code",nota);
                    startActivity(j);


                }


            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}

