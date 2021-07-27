package com.example.golive;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;


import org.json.JSONException;
import org.json.JSONObject;

public class showscore extends AppCompatActivity {
    SwipeRefreshLayout refreshLayout;
    TextView textView1;
    Vibrator vibrator;
//    AdView adview;
    ImageView imageView;
    RequestQueue queue;
    TextView vs;
    public int img[] = {R.drawable.cskvshyd,R.drawable.mivsrr,R.drawable.dcvskkr,R.drawable.rcbvspun,R.drawable.cskvsmi,R.drawable.hydvsrr,R.drawable.punvsdc,R.drawable.rcbvskkr,R.drawable.srhvsmum,R.drawable.cskvsrr,R.drawable.rcbvspun,R.drawable.cskvshyd,R.drawable.dcvskkr,R.drawable.mivsrr,R.drawable.punvscsk,R.drawable.rcbvshyd,R.drawable.kkrvsmi,R.drawable.dcvsrr,R.drawable.kkrvscsk,R.drawable.punvsmi,R.drawable.hydvsrr,R.drawable.rcbvsdc,R.drawable.kkrvspun,R.drawable.rcbvsrr,R.drawable.cskvsmi,R.drawable.dcvshyd,R.drawable.kkrvsrr,R.drawable.punvshyd,R.drawable.rcbvsmi,R.drawable.kkrvshyd,R.drawable.dcvscsk,R.drawable.punvsrr,R.drawable.dcvsmum,R.drawable.rcbvscsk};
    public String date[] ={"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","",""};
    public String apiindlink[]={"https://cricapi.com/api/cricketScore?apikey=1eTyqiLLG8QtFXQ3omhRDI6BDBl2&unique_id=1254080","https://cricapi.com/api/cricketScore?apikey=1eTyqiLLG8QtFXQ3omhRDI6BDBl2&unique_id=1254081","https://cricapi.com/api/cricketScore?apikey=1eTyqiLLG8QtFXQ3omhRDI6BDBl2&unique_id=1254082","https://cricapi.com/api/cricketScore?apikey=1eTyqiLLG8QtFXQ3omhRDI6BDBl2&unique_id=1254083","https://cricapi.com/api/cricketScore?apikey=1eTyqiLLG8QtFXQ3omhRDI6BDBl2&unique_id=1254084","https://cricapi.com/api/cricketScore?apikey=1eTyqiLLG8QtFXQ3omhRDI6BDBl2&unique_id=1254085","https://cricapi.com/api/cricketScore?apikey=1eTyqiLLG8QtFXQ3omhRDI6BDBl2&unique_id=1254086","https://cricapi.com/api/cricketScore?apikey=1eTyqiLLG8QtFXQ3omhRDI6BDBl2&unique_id=1254087","https://cricapi.com/api/cricketScore?apikey=1eTyqiLLG8QtFXQ3omhRDI6BDBl2&unique_id=1254088","https://cricapi.com/api/cricketScore?apikey=1eTyqiLLG8QtFXQ3omhRDI6BDBl2&unique_id=1254089","https://cricapi.com/api/cricketScore?apikey=1eTyqiLLG8QtFXQ3omhRDI6BDBl2&unique_id=1254090","https://cricapi.com/api/cricketScore?apikey=1eTyqiLLG8QtFXQ3omhRDI6BDBl2&unique_id=1254091","https://cricapi.com/api/cricketScore?apikey=1eTyqiLLG8QtFXQ3omhRDI6BDBl2&unique_id=1254092","https://cricapi.com/api/cricketScore?apikey=1eTyqiLLG8QtFXQ3omhRDI6BDBl2&unique_id=1254093","https://cricapi.com/api/cricketScore?apikey=1eTyqiLLG8QtFXQ3omhRDI6BDBl2&unique_id=1254094","https://cricapi.com/api/cricketScore?apikey=1eTyqiLLG8QtFXQ3omhRDI6BDBl2&unique_id=1254095","https://cricapi.com/api/cricketScore?apikey=1eTyqiLLG8QtFXQ3omhRDI6BDBl2&unique_id=1254096","https://cricapi.com/api/cricketScore?apikey=1eTyqiLLG8QtFXQ3omhRDI6BDBl2&unique_id=1254097","https://cricapi.com/api/cricketScore?apikey=1eTyqiLLG8QtFXQ3omhRDI6BDBl2&unique_id=1254098","https://cricapi.com/api/cricketScore?apikey=1eTyqiLLG8QtFXQ3omhRDI6BDBl2&unique_id=1254099","https://cricapi.com/api/cricketScore?apikey=1eTyqiLLG8QtFXQ3omhRDI6BDBl2&unique_id=12540100","https://cricapi.com/api/cricketScore?apikey=1eTyqiLLG8QtFXQ3omhRDI6BDBl2&unique_id=12540101","https://cricapi.com/api/cricketScore?apikey=1eTyqiLLG8QtFXQ3omhRDI6BDBl2&unique_id=12540102","https://cricapi.com/api/cricketScore?apikey=1eTyqiLLG8QtFXQ3omhRDI6BDBl2&unique_id=12540103","https://cricapi.com/api/cricketScore?apikey=1eTyqiLLG8QtFXQ3omhRDI6BDBl2&unique_id=12540104","https://cricapi.com/api/cricketScore?apikey=1eTyqiLLG8QtFXQ3omhRDI6BDBl2&unique_id=12540105","https://cricapi.com/api/cricketScore?apikey=1eTyqiLLG8QtFXQ3omhRDI6BDBl2&unique_id=12540106","https://cricapi.com/api/cricketScore?apikey=1eTyqiLLG8QtFXQ3omhRDI6BDBl2&unique_id=12540107","https://cricapi.com/api/cricketScore?apikey=1eTyqiLLG8QtFXQ3omhRDI6BDBl2&unique_id=12540108","https://cricapi.com/api/cricketScore?apikey=1eTyqiLLG8QtFXQ3omhRDI6BDBl2&unique_id=12540109","https://cricapi.com/api/cricketScore?apikey=1eTyqiLLG8QtFXQ3omhRDI6BDBl2&unique_id=12540110","https://cricapi.com/api/cricketScore?apikey=1eTyqiLLG8QtFXQ3omhRDI6BDBl2&unique_id=12540111","https://cricapi.com/api/cricketScore?apikey=1eTyqiLLG8QtFXQ3omhRDI6BDBl2&unique_id=12540112","https://cricapi.com/api/cricketScore?apikey=1eTyqiLLG8QtFXQ3omhRDI6BDBl2&unique_id=12540113"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showscore);
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        textView1=findViewById(R.id.score);
//        adview=findViewById(R.id.adView); // add
        AdRequest adRequest = new AdRequest.Builder().build();
//        adview.loadAd(adRequest); // add

//        adview.setAdListener(new AdListener() {
//            @Override
//            public void onAdFailedToLoad(LoadAdError adError) { // adError stores our error..
//                Toast.makeText(showscore.this,adError.toString(), Toast.LENGTH_SHORT).show();
//            }    });
//        textView2=findViewById(R.id.team2);
//        textView2=findViewById(R.id.vs);
        Intent intent = getIntent();
        int poss = intent.getIntExtra("tt",0);
        refreshLayout=findViewById(R.id.swiperefresh);
//        imageView.setImageResource(img[poss]);
        satnamswipe(poss);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                satnamswipe(poss);
                refreshLayout.setRefreshing(false);
            }
        });
//        String tempapi = apiindlink[poss];

    }

    public void satnamswipe(int poss)
    {
        queue= Volley.newRequestQueue(getApplicationContext());
        JsonObjectRequest request1 = new JsonObjectRequest(Request.Method.GET, apiindlink[poss], null,
                response -> {
                    try { // it is always a good practice to put our response in try{} and catch{} because from getting information from web there are anoonemus kind of errors .
                        //---------------------------------------------------JSON PARSING
                        String wholetext = response.toString();
                        JSONObject root = new JSONObject(wholetext);
                        String scores = root.getString("score");
                        //---------------------------------------------------JSON PARSING
                        textView1.setText(scores);
                    } catch (JSONException e) {
                        Toast.makeText(showscore.this, "" + e, Toast.LENGTH_SHORT).show();
                    }
                },
                error -> {
                    Toast.makeText(this, "Unable to fetch data from servers...", Toast.LENGTH_SHORT).show();
                } );
        queue.add(request1);
    }
    public void onclickcardhotstar(View v){
        vibrator.vibrate(60);
        Uri parsedlink = Uri.parse("https://www.hotstar.com"); // Uri is "Uniform Resource Identifier" ie. it is used to pares the string which we are getting from our data source into the orignal link. and which is stored on variable parsedlink of data type Uri.
        Intent intent = new Intent(Intent.ACTION_VIEW,parsedlink); // First of all "ACTION_VIEW" is one of the filter on Intent , This is other form of Intent (Explicit Intent) in which we first have to specify the "Action" we want to perform for eg ,we want to view the video therefor we "setAction" as "ACTION_VIEW".
        startActivity(intent);
    }
  public void vibratecard(View v){
    vibrator.vibrate(60);
  }
}


// we can also use singleton class
// why??
// because if we have more request that is we are making more object and filling memory.
// singleton class make only one object and in that object it creates the "instance(path or copy)" of the document or the thing which we are retreving from "api" and can be accesseble to all class in that project. it remove the problem of multiple object creation. resource :- "udemy"