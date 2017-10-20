package za.ac.cput.fidit.infoshareapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;


public class Reader extends AppCompatActivity {

ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reader);
        String items [] =  new String [] {"story 1", "story 2", "story 3" };
        listView  = (ListView) findViewById(R.id.Listview);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.activity_list_item, items);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
             public void onItemClick(AdapterView<?> adapterView, View view, int i,
                                    int position, long l) {

                if (position==0){
                    Intent myintent = new Intent(view.getContext(), ReadStory.class);
                    startActivityForResult(myintent,0);

                }
                if (position==1) {
                    Intent myintent = new Intent(view.getContext(), ReadStory.class);
                    startActivityForResult(myintent, 1);

                }

                if (position==2) {
                    Intent myintent = new Intent(view.getContext(), ReadStory.class);
                    startActivityForResult(myintent, 2);

                }
                if (position==3) {
                    Intent myintent = new Intent(view.getContext(), ReadStory.class);
                    startActivityForResult(myintent, 3);
                }
            }

        });


    }
}

