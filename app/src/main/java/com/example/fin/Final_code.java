package com.example.fin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Final_code extends AppCompatActivity {
    note_details code;
    EditText ed;
    DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_code);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Note");

        ed = findViewById(R.id.d_fin);
        code = getIntent().getParcelableExtra("code");
        ed.setText(code.getDetails());
        myRef.child(code.getId()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                note_details val = dataSnapshot.getValue(note_details.class);
                ed.setText(val.getDetails());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        ed.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                myRef.child(code.getId()).setValue(new note_details(code.getId(),s.toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
}

