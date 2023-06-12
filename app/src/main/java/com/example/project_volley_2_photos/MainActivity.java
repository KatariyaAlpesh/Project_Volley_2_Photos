package com.example.project_volley_2_photos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{

    RecyclerView recyclerView;

    String url;

    ArrayList<DataModel> ArrayListDataModel = new ArrayList<DataModel>();


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.RecyclerViewMain);

        url = "https://jsonplaceholder.typicode.com/photos" ;

        call_API();
    }

    private void call_API()
    {
        RequestQueue queue = Volley.newRequestQueue(this);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>()
        {
                    @Override
                    public void onResponse(String response)
                    {
                        try
                        {
                            JSONArray jsonArray = new JSONArray(response);

                            for (int i = 0 ; i < jsonArray.length() ; i++)
                            {
                                JSONObject mainObject = jsonArray.getJSONObject(i);

                                long albumID = mainObject.getLong("albumId");
                                long id = mainObject.getLong("id");
                                String title = mainObject.getString("title");
                                String url = mainObject.getString("url");
                                String thumbnailURL = mainObject.getString("thumbnailUrl");


                                DataModel dataModel = new DataModel(albumID , id , title , url , thumbnailURL);

                                ArrayListDataModel.add(dataModel);

                            }

                        RecyclerView_Adapter recyclerView_adapter = new RecyclerView_Adapter(MainActivity.this , ArrayListDataModel);
                        recyclerView.setAdapter(recyclerView_adapter);

                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this ,
                                                                                        LinearLayoutManager.VERTICAL , false);
                        recyclerView.setLayoutManager(linearLayoutManager);

                        }
                        catch (JSONException e)
                        {
                            throw new RuntimeException(e);
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {
//                textView.setText("That didn't work!");
            }
        });
        queue.add(stringRequest);

    }

}