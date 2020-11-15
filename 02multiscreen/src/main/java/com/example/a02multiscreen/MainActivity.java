  package com.example.a02multiscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.List;

  public class MainActivity extends ListActivity {

      //создадим массив строк (пункты по которым будем переходить из одного окна в другое)
      String[] things = {"msARGENTINA", "msBRAZILIA", "msCHILI", "msCOLUMBIA"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //добавляем наследник адаптера
        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, things);

        //подключаем адаптер
        setListAdapter(adapter);

        //включить обработку нажатия
        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        Intent intent1 = new Intent(MainActivity.this, msArgentina.class);
                        startActivity(intent1);

                        break;
                    case 1:
                        Intent intent2 = new Intent(MainActivity.this, msBrazilia.class);
                        startActivity(intent2);
                        break;
                    case 2:
                        Intent intent3 = new Intent(MainActivity.this, msCHili.class);
                        startActivity(intent3);
                        break;
                    case 3:
                        Intent intent4 = new Intent(MainActivity.this, msColumbia.class);
                        startActivity(intent4);
                        break;
                }
                //вызывает всплывающее окно
                Toast.makeText(getApplicationContext(), "You are change!"
                        + parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();


            }
        };
        //запустим обработчик, который защищает listView
        getListView().setOnItemClickListener(itemListener);


    }
}
