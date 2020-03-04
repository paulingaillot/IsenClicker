package fr.ybsi.isenclicker3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;

import java.util.Map;

public class shop extends AppCompatActivity {

    private static ImageView image1;
    private static ImageView image2;
    private static ImageView image3;

    private static TextView name1;
    private static TextView name2;
    private static TextView name3;

    private static TextView price1;
    private static TextView price2;
    private static TextView price3;

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        this.image1 = findViewById(R.id.imageView16);
        this.image2 = findViewById(R.id.imageView18);
        this.image3 = findViewById(R.id.imageView19);

        this.name1 = findViewById(R.id.textView19);
        this.name2 = findViewById(R.id.textView20);
        this.name3 = findViewById(R.id.textView21);

        this.price1 = findViewById(R.id.textView25);
        this.price2 = findViewById(R.id.textView26);
        this.price3 = findViewById(R.id.textView27);

        final String username = getIntent().getStringExtra("username");
        String passwd = getIntent().getStringExtra("password");

        final Task<DocumentSnapshot> task = UserHelper.getUser(username);


        task.addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot snapshot) {

                long lastShop;
                try {
                    lastShop = Long.parseLong(snapshot.get("lastShop").toString());
                }catch(Exception e){
                    lastShop = 0;
                }

                final Map<String, Boolean> map1 = (Map<String, Boolean>)snapshot.get("map");

                int lengh = map1.size();
                int price = 100;

                for(int i=0; i<lengh; i++) {
                    price = (int)(price*1.5);
                }

                long delay = System.currentTimeMillis() - lastShop;

                if(delay > 10800000) {

                    int market1 = 1 + (int)(Math.random() * ((8 - 1) + 1));
                    int market2 = 1 + (int)(Math.random() * ((8 - 1) + 1));
                    int market3 = 1 + (int)(Math.random() * ((8 - 1) + 1));

                    UserHelper.getUsersCollection().document(username).update("market1", market1);
                    UserHelper.getUsersCollection().document(username).update("market2", market2);
                    UserHelper.getUsersCollection().document(username).update("market3", market3);

                    UserHelper.getUsersCollection().document(username).update("lastShop", System.currentTimeMillis());

                }

                    final int market1 = Integer.parseInt(snapshot.get("market1").toString());

                    if(market1 == 1){

                        image1.setImageResource(R.drawable.maths);
                        name1.setText("Maths");
                        price1.setText(price+"$");

                    }
                    else if(market1 == 2){

                        image1.setImageResource(R.drawable.isabelle);
                        name1.setText("Isabelle");
                        price1.setText(price+"$");

                    }
                    else if(market1 == 3){

                        image1.setImageResource(R.drawable.linux);
                        name1.setText("Linux");
                        price1.setText(price+"$");

                    }
                    else if(market1 == 4){

                        image1.setImageResource(R.drawable.physique);
                        name1.setText("Physique");
                        price1.setText(price+"$");

                    }
                    else if(market1 == 5){

                        image1.setImageResource(R.drawable.algo);
                        name1.setText("Algo");
                        price1.setText(price+"$");

                    }
                    else if(market1 == 6){

                        image1.setImageResource(R.drawable.si);
                        name1.setText("SI");
                        price1.setText(price+"$");

                    }

                    final int market2 = Integer.parseInt(snapshot.get("market2").toString());

                    if(market2 == 1){

                        image2.setImageResource(R.drawable.maths);
                        name2.setText("Maths");
                        price2.setText(price+"$");

                    }
                    else if(market2 == 2){

                        image2.setImageResource(R.drawable.isabelle);
                        name2.setText("Isabelle");
                        price2.setText(price+"$");

                    }
                    else if(market2 == 3){

                        image2.setImageResource(R.drawable.linux);
                        name2.setText("Linux");
                        price2.setText(price+"$");

                    }
                    else if(market2 == 4){

                        image2.setImageResource(R.drawable.physique);
                        name2.setText("Physique");
                        price2.setText(price+"$");

                    }
                    else if(market2 == 5){

                        image2.setImageResource(R.drawable.algo);
                        name2.setText("Algo");
                        price2.setText(price+"$");

                    }
                    else if(market2 == 6){

                        image2.setImageResource(R.drawable.si);
                        name2.setText("SI");
                        price2.setText(price+"$");

                    }


                    final int market3 = Integer.parseInt(snapshot.get("market3").toString());

                    if(market3 == 1){

                        image3.setImageResource(R.drawable.maths);
                        name3.setText("Maths");
                        price3.setText(price+"$");

                    }
                    else if(market3 == 2){

                        image3.setImageResource(R.drawable.isabelle);
                        name3.setText("Isabelle");
                        price3.setText(price+"$");

                    }
                    else if(market3 == 3){

                        image3.setImageResource(R.drawable.linux);
                        name3.setText("Linux");
                        price3.setText(price+"$");

                    }
                    else if(market3 == 4){

                        image3.setImageResource(R.drawable.physique);
                        name3.setText("Physique");
                        price3.setText(price+"$");

                    }
                    else if(market3 == 5){

                        image3.setImageResource(R.drawable.algo);
                        name3.setText("Algo");
                        price3.setText(price+"$");

                    }
                    else if(market3 == 6){

                        image3.setImageResource(R.drawable.si);
                        name3.setText("SI");
                        price3.setText(price+"$");

                    }

                final int finalPrice = price;
                final int money = Integer.parseInt(snapshot.get("money").toString());
                image1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(money < finalPrice) {
                            finish();
                        }
                        else {
                            if (market1 == 1) {

                                map1.put("maths", true);

                            } else if (market1 == 2) {

                                map1.put("isabelle", true);

                            } else if (market1 == 3) {

                                map1.put("linux", true);

                            } else if (market1 == 4) {

                                map1.put("physique", true);

                            } else if (market1 == 5) {

                                map1.put("algo", true);

                            } else if (market1 == 6) {

                                map1.put("si", true);

                            }
                            int rest = money - finalPrice;
                            UserHelper.getUsersCollection().document(username).update("money",money);
                            UserHelper.getUsersCollection().document(username).update("map",map1);

                        }

                    }

                });

                image2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if(money < finalPrice) {
                            finish();
                        }
                        else {
                            if (market2 == 1) {

                                map1.put("maths", true);

                            } else if (market2 == 2) {

                                map1.put("isabelle", true);

                            } else if (market2 == 3) {

                                map1.put("linux", true);

                            } else if (market2 == 4) {

                                map1.put("physique", true);

                            } else if (market2 == 5) {

                                map1.put("algo", true);

                            } else if (market2 == 6) {

                                map1.put("si", true);

                            }
                            int rest = money - finalPrice;
                            UserHelper.getUsersCollection().document(username).update("money",money);
                            UserHelper.getUsersCollection().document(username).update("map",map1);

                        }

                    }

                });

                image3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if(money < finalPrice) {
                            finish();
                        }
                        else {
                            if (market3 == 1) {

                                map1.put("maths", true);

                            } else if (market3 == 2) {

                                map1.put("isabelle", true);

                            } else if (market3 == 3) {
                                map1.put("linux", true);

                            } else if (market3 == 4) {

                                map1.put("physique", true);

                            } else if (market3 == 5) {

                                map1.put("algo", true);

                            } else if (market3 == 6) {

                                map1.put("si", true);

                            }
                            int rest = money - finalPrice;
                            UserHelper.getUsersCollection().document(username).update("money",money);
                            UserHelper.getUsersCollection().document(username).update("map",map1);

                        }

                    }

                    });


            }
        });
    }
}
