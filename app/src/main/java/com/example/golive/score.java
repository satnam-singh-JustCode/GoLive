package com.example.golive;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;



import java.util.Collections;

public class score extends AppCompatActivity {


        Vibrator vibrator;
        ListView listview;
        public int img[] = {R.drawable.cskvshyd,R.drawable.mivsrr,R.drawable.dcvskkr,R.drawable.rcbvspun,R.drawable.cskvsmi,R.drawable.hydvsrr,R.drawable.punvsdc,R.drawable.rcbvskkr,R.drawable.srhvsmum,R.drawable.cskvsrr,R.drawable.rcbvspun,R.drawable.cskvshyd,R.drawable.dcvskkr,R.drawable.mivsrr,R.drawable.punvscsk,R.drawable.rcbvshyd,R.drawable.kkrvsmi,R.drawable.dcvsrr,R.drawable.kkrvscsk,R.drawable.punvsmi,R.drawable.hydvsrr,R.drawable.rcbvsdc,R.drawable.kkrvspun,R.drawable.rcbvsrr,R.drawable.cskvsmi,R.drawable.dcvshyd,R.drawable.kkrvsrr,R.drawable.punvshyd,R.drawable.rcbvsmi,R.drawable.kkrvshyd,R.drawable.dcvscsk,R.drawable.punvsrr,R.drawable.dcvsmum,R.drawable.rcbvscsk};
        public String date[] ={"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","",""};
        public String apiindlink[]={"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","",""};
        int countermain=2;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
            setContentView(R.layout.activity_main);
            vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
            listview = findViewById(R.id.listview);
            satnamcustomlistview sv = new satnamcustomlistview(this, R.layout.mylist, img,date); // all custom views are stored in object sv.
            // adapter are used to convert the data source into views and help to place them in list view.
            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    vibrator.vibrate(60);
                    Intent intent = new Intent(score.this,splashscreenofitems.class);
                    intent.putExtra("t",position);
                    startActivity(intent);
                }
            });
            listview.setAdapter(sv); // putting every views in listView.
        }

        //        Here is a further list of layouts that you can use: http://developer.android.com/reference/android/R.layout.html
//        (Updated link thanks @Estel: https://github.com/android/platform_frameworks_base/tree/master/core/res/res/layout )
        public class satnamcustomlistview extends ArrayAdapter {
            private int imgtemp[];
            private String tempname[];

            // public satnamcustomlistview(@NonNull Context context, int resource,String[] name, String[] desc, int[] img)
            //                                               /             /
            public satnamcustomlistview(@NonNull Context main1, int mylist, int img[], String []date) {
                super(main1,mylist,date);
                this.imgtemp=img;
                this.tempname=date;
            }




            @NonNull
            @Override
            public View getView(int position, View temp_view, @NonNull ViewGroup parent) {
                View temp = getLayoutInflater().inflate(R.layout.mylist, parent, false); // layoutinflater will make exact copy of our custom adapter into temp_view.
//            TextView tempdesc = temp.findViewById(R.id.textView);
                ImageView tempimg = temp.findViewById(R.id.imageView);

//            tempdesc.setText(tempname[position]);
                tempimg.setImageResource(imgtemp[position]);

                return temp;
            }
        }
}