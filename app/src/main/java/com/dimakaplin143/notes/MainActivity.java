package com.dimakaplin143.notes;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static String NOTE_TEXT = "note_text";

    private EditText mInputNote;
    private Button mBtnSaveNote;
    private SharedPreferences myNoteSharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        getDateFromSharedPref();


    }

    private void initViews() {
        mInputNote = findViewById(R.id.inputNote);
        mBtnSaveNote = findViewById(R.id.btnSaveNote);
        myNoteSharedPref = getSharedPreferences("MyNote", MODE_PRIVATE);

        mBtnSaveNote.setOnClickListener(v-> {

            SharedPreferences.Editor myEditor = myNoteSharedPref.edit();
            String noteTxt = mInputNote.getText().toString();
            myEditor.putString(NOTE_TEXT, noteTxt);
            myEditor.apply();

            String message = getText(R.string.save_message).toString();

            Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();



        });

    }

    private void getDateFromSharedPref() {
        String noteTxt = myNoteSharedPref.getString(NOTE_TEXT, "");
        mInputNote.setText(noteTxt);
    }
}
