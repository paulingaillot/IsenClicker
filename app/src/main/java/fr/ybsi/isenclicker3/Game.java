package fr.ybsi.isenclicker3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Game extends AppCompatActivity {

    private ImageView head;
    private ImageView shop;
    private static String user;
    private static int clics;
    private static TextView cpm;
    private TextView total;
    private static ArrayList<Long> array= new ArrayList<Long>();
    private TextView username;
    private ImageView leaderboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


        this.head = findViewById(R.id.imageView);
        this.total = findViewById(R.id.textView2);
        this.cpm = findViewById(R.id.textView4);
        this.shop = findViewById(R.id.imageView3);
        this.username = findViewById(R.id.textView6);
        this.leaderboard = findViewById(R.id.imageView2);

        //username.setText("Ca marche !!!! "+UserHelper.getUser("ybsi"));

        user = getIntent().getStringExtra("username");
        clics = getIntent().getIntExtra("points", 0);
        total.setText("" + clics);
        username.setText("User : " + user);

        cps();
        updater();

        ((Button)findViewById(R.id.retour))
                // Nous paramétrons un écouteur sur l’événement ‘click’ de ce bouton
                .setOnClickListener(new View.OnClickListener()
                                    {
                                        public void onClick(View v)
                                        {
                                            this.LectureActivity.finish(); // LectureActivity est mon activité
                                        }
                                    }
                );

        leaderboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent Menu = new Intent(getApplicationContext(), LeaderBoard.class);
                Menu.putExtra("username", user);
                startActivity(Menu);
                finish();

            }
        });

        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent Menu = new Intent(getApplicationContext(), shop.class);
                startActivity(Menu);
                finish();
            }
        });

        head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clics++;
                array.add(System.currentTimeMillis());

                ArrayList<Integer> array2= new ArrayList<Integer>();
                int i =0;
                for(Long value : array) {
                    if(value+1000< System.currentTimeMillis()) {
                        array2.add(i);
                    }
                    i++;
                }

                try {
                    for (int j : array2) {
                        array.remove(j);
                    }
                }catch(Exception e){

                }
                cpm.setText(""+array.size());

                total.setText("" + clics);

                if(clics > 250 && clics < 550) {

                    head.setImageResource(R.drawable.physique);

                }
                else if(clics > 550 && clics < 1200) {

                    head.setImageResource(R.drawable.linux);

                }
                else if(clics > 1200 && clics < 2550) {

                    head.setImageResource(R.drawable.algo);

                }
                else if(clics > 2550 && clics < 5300) {

                    head.setImageResource(R.drawable.isab elle);

                }
                else if(clics > 5300 && clics < 10850) {

                    head.setImageResource(R.drawable.maths);

                }
                else if(clics > 10850 && clics < 22000) {

                    head.setImageResource(R.drawable.si);

                }
                else if(clics > 22000 && clics < 44350) {

                    head.setImageResource(R.drawable.si);

                }
                else if(clics > 44350 && clics < 89100) {

                    head.setImageResource(R.drawable.si);

                }
                else if(clics > 89100 && clics < 178650) {

                    head.setImageResource(R.drawable.si);

                }
                else if(clics > 178650 && clics < 357800) {

                    head.setImageResource(R.drawable.si);

                }
                else if(clics > 357800){

                    head.setImageResource(R.drawable.si);

                }

            }
        });


    }

    private static final ScheduledExecutorService scheduler1 = Executors.newScheduledThreadPool(0);

        public static void updater() {
        Runnable Uptime_Update = new Runnable() {

            @Override
            public void run() {
                UserHelper.updatePoints(user, clics);
                   array.add(System.currentTimeMillis());
            }
        };
        ScheduledFuture<?> UptimeHandle = scheduler1.scheduleAtFixedRate(Uptime_Update,30 , 30, TimeUnit.SECONDS);
    }


    public static void cps() {
        Runnable Uptime_Update = new Runnable(){

            @Override
            public void run() {

                ArrayList<Integer> array2= new ArrayList<Integer>();
                int i =0;
                for(Long value : array) {
                    if(value+1000< System.currentTimeMillis()) {
                        array2.add(i);
                    }
                    i++;
                }

                try {
                    for (int j : array2) {
                        array.remove(j);
                    }
                }catch(Exception e){

                }
                cpm.setText(""+array.size());

            }
        };
        ScheduledFuture<?> UptimeHandle = scheduler1.scheduleAtFixedRate(Uptime_Update, 1, 1, TimeUnit.MILLISECONDS);
    }

}





