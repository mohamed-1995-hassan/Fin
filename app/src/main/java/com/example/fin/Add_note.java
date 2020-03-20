package com.example.fin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

public class Add_note extends AppCompatActivity {
    EditText ed;
    DatabaseReference myRef;

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        ed=findViewById(R.id.did);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Note");
        tv =findViewById(R.id.ttv);
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        tv.setText( String.format("%06d", number));
        if(!ed.getText().toString().equals("")) {
            myRef.child(tv.getText().toString()).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    note_details val = dataSnapshot.getValue(note_details.class);
                    ed.setText(val.getDetails());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

        ed.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                myRef.child(tv.getText().toString()).setValue(new note_details(tv.getText().toString(),s.toString()));

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

}
