package com.example.addnames;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.addnames.storage.NameStorage;

public class MainActivity extends AppCompatActivity {
    ListView listNames;
    EditText name;
    Button btn;
    NameStorage ns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ns = NameStorage.getInstance();
        listNames = findViewById(R.id.list_names);
        name = findViewById(R.id.name);
        btn = findViewById(R.id.btn);
        final ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, ns.getNames());
        listNames.setAdapter(arrayAdapter);
//        arrayAdapter.notifyDataSetChanged();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name_txt = name.getText().toString();
                ns.putName(name_txt);
                arrayAdapter.notifyDataSetChanged();
//                listNames.invalidateViews();
            }
        });
    }

}
