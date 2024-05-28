package com.example.in_class_activity_drsamer_28_5;

import static android.R.layout.simple_list_item_1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private RequestQueue re;
    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btnc);
        list = findViewById(R.id.list);
        re = Volley.newRequestQueue(this);
    }

    public void btnclick(View v) {
        String url = "https://jsonplaceholder.typicode.com/users";
        JsonArrayRequest RE = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        ArrayList<Employee> ar = new ArrayList<>();
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject o = response.getJSONObject(i);
                                ar.add(new Employee(o.getString("name"), o.getString("email")));
                            } catch (JSONException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        ArrayAdapter<Employee> arrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, ar);
                        // Assuming you have a ListView named listView
                        list.setAdapter(arrayAdapter);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Volley", "Error: " + error.toString());
                        if (error.networkResponse != null) {
                            Log.e("Volley", "Status code: " + error.networkResponse.statusCode);
                            Log.e("Volley", "Response data: " + new String(error.networkResponse.data));
                        }
                    }
                });

// Assuming you have a RequestQueue named requestQueue
        re.add(RE);
    }
}


