package com.jaygoo.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.jaygoo.selector.MultiSelectPopWindow;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> names = new ArrayList<>(7);
    private boolean[] selection = new boolean[7];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new MultiSelectPopWindow.Builder(MainActivity.this)
                        .setNameArray(names)
                        .setSelection(selection)
                        .setConfirmListener(new MultiSelectPopWindow.OnConfirmClickListener() {
                            @Override
                            public void onClick(ArrayList<Integer> indexList, ArrayList<String> selectedList) {
                                Toast.makeText(getApplication(), indexList.size()+"", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setCancel("Anuluj")
                        .setConfirm("Ok")
                        .setTitle("Wybór")
                        .setSelectAll("wszystkie")
                        .build()
                        .show(findViewById(R.id.mBottom));
            }
        });

    }

    private void initData() {
        names.add("Monday");
        names.add("Tuesday");
        names.add("Wednesday");
        names.add("Thursday");
        names.add("Friday");
        names.add("Saturday");
        names.add("Sunday");
        selection[1] = true;
    }
}
