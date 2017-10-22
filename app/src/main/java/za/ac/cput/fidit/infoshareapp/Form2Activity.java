package za.ac.cput.fidit.infoshareapp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class Form2Activity extends AppCompatActivity {
    Form2Activity.API_TASK api_task=null;
    private EditText tvId;
    private EditText tvDesc;

    private TextView tvRes;
    private Button btnSend;
    private Button btnRcv;
    private ConstraintLayout constraintLayout;
    private static String API_URL_R = "https://infoapi.hash-code.com/content/categories";
    private static String API_URL_S = "https://infoapi.hash-code.com/content/category/create";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        setContentView(R.layout.content_form2);
        tvId= (EditText) findViewById(R.id.etId);
        tvDesc= (EditText) findViewById(R.id.etDesc);
        tvRes= (TextView) findViewById(R.id.textView);
        btnSend= (Button) findViewById(R.id.btnSend);
        btnRcv= (Button) findViewById(R.id.btnRcv);
        constraintLayout=(ConstraintLayout)findViewById(R.id.consLay);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(api_task==null) {
                    String ar[]={tvId.getText().toString(),"TEST",tvDesc.getText().toString()};
                    api_task=new Form2Activity.API_TASK(API_URL_S,ar);
                    api_task.execute();
                }
            }
        });

        btnRcv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                api_task=new Form2Activity.API_TASK(API_URL_R);
                api_task.execute();

            }
        });


    }

    public class API_TASK extends AsyncTask<Void, Void, String> {
        private byte choice=0;
        private  String args[]=null;
        private  String api_url;

        API_TASK(String url,String arg[]) {
            api_url=url;
            args = arg;
            choice=1;
        }
        API_TASK(String url) {
            api_url=url;
            choice=0;
        }

        @Override
        protected void onPreExecute() {
            if(choice==1)
                btnSend.setText("Waiting");
            else
                btnRcv.setText("Waiting");
        }

        @Override
        protected String doInBackground(Void... params) {
            // TODO: attempt authentication against a network service.

            //String email = emailText.getText().toString();
            // Do some validation here
            HttpHandler con = new HttpHandler();
            if(choice==1) {

                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("id", args[0]);
                    jsonObject.put("name", args[1]);
                    jsonObject.put("description", args[2]);


                } catch (JSONException e) {
                    e.printStackTrace();

                }

               // Toast.makeText(getApplicationContext(),"HI", Toast.LENGTH_LONG).show();
                return con.POST(api_url, jsonObject);


            }
            else
                return con.GET(api_url);

        }

        protected void onPostExecute(String response) {
            if(response == null) {
                response = "THERE WAS AN ERROR";
            }

            Log.i("INFO", response);

            tvRes.setText(response);


        }

        @Override
        protected void onCancelled() {

        }
    }


}
