package com.vanna.connectingtointernet;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeRequest();
            }
        });

    }

    void makeRequest() {
        Context context = getApplicationContext();
        RequestQueue requestQueue = Volley.newRequestQueue(context);

        StringRequest stringRequest  = new StringRequest(Request.Method.GET, "http://google.com", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                TextView textView = (TextView) findViewById(R.id.textView);
                textView.setText(response);
                // SUCCESS
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // ERROR
                TextView textView = (TextView) findViewById(R.id.textView);
                textView.setText(error.toString());
            }
        });

        requestQueue.add(stringRequest);
    }
}
