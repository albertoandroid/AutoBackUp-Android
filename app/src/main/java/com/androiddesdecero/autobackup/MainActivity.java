package com.androiddesdecero.autobackup;

import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String SHARED_PREF_NORMARL =
            "com.androiddesdecero.autobackup.SHARED_PREF_NORMARL";

    private static final String SHARED_PREF_INCLUDE =
            "com.androiddesdecero.autobackup.SHARED_PREF_INCLUDE";

    private static final String SHARED_PREF_EXCLUDE =
            "com.androiddesdecero.autobackup.SHARED_PREF_EXCLUDE";

    private static final String TEXT_SP_NORMAL = "TEXT_SP_NORMAL";
    private static final String TEXT_SP_INCLUDE = "TEXT_SP_INCLUDE";
    private static final String TEXT_SP_EXCLUDE = "TEXT_SP_EXCLUDE";

    private EditText autoBackUpNormalEt;
    private EditText autoBackUpExcludeEt;
    private EditText autoBackUpIncludeEt;

    private TextView autoBackUpNormalTv;
    private TextView autoBackUpExcludeTv;
    private TextView autoBackUpIncludeTv;

    private Button button;
    private Button buttonGetBackUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configView();
    }

    private void configView(){
        autoBackUpNormalEt = findViewById(R.id.autoBackUpNormalEt);
        autoBackUpExcludeEt = findViewById(R.id.autoBackUpExcludeEt);
        autoBackUpIncludeEt = findViewById(R.id.autoBackUpIncludeEt);

        autoBackUpNormalTv = findViewById(R.id.autoBackUpNormalTv);
        autoBackUpExcludeTv = findViewById(R.id.autoBackUpExcludeTv);
        autoBackUpIncludeTv = findViewById(R.id.autoBackUpIncludeTv);

        button = findViewById(R.id.autoBackUpButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSharedPreferences(SHARED_PREF_NORMARL, Context.MODE_PRIVATE)
                        .edit()
                        .putString(TEXT_SP_NORMAL, autoBackUpNormalEt.getText().toString())
                        .apply();

                getSharedPreferences(SHARED_PREF_INCLUDE, Context.MODE_PRIVATE)
                        .edit()
                        .putString(TEXT_SP_INCLUDE, autoBackUpIncludeEt.getText().toString())
                        .apply();

                getSharedPreferences(SHARED_PREF_EXCLUDE, Context.MODE_PRIVATE)
                        .edit()
                        .putString(TEXT_SP_EXCLUDE, autoBackUpExcludeEt.getText().toString())
                        .apply();
            }
        });

        buttonGetBackUp = findViewById(R.id.autoBackUpButtonRecover);
        buttonGetBackUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                autoBackUpNormalTv.setText(getSharedPreferences(SHARED_PREF_NORMARL, Context.MODE_PRIVATE)
                        .getString(TEXT_SP_NORMAL, null));
                autoBackUpIncludeTv.setText(getSharedPreferences(SHARED_PREF_INCLUDE, Context.MODE_PRIVATE)
                        .getString(TEXT_SP_INCLUDE, null));
                autoBackUpExcludeTv.setText(getSharedPreferences(SHARED_PREF_EXCLUDE, Context.MODE_PRIVATE)
                        .getString(TEXT_SP_EXCLUDE, null));
            }
        });
    }
}
