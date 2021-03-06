package fr.ybsi.isenclicker3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BackPack extends AppCompatActivity {

    private ImageView case1;
    private ImageView case2;
    private ImageView case3;
    private ImageView case4;
    private ImageView case5;
    private ImageView case6;
    private ImageView case7;
    private ImageView case8;

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_pack);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        this.case1 = findViewById(R.id.imageView6);
        this.case2 = findViewById(R.id.imageView7);
        this.case3 = findViewById(R.id.imageView8);
        this.case4 = findViewById(R.id.imageView9);
        this.case5 = findViewById(R.id.imageView10);
        this.case6 = findViewById(R.id.imageView11) ;
        this.case7 = findViewById(R.id.imageView12);
        this.case8 = findViewById(R.id.imageView13);

        String user = getIntent().getStringExtra("username");

        Task<DocumentSnapshot> task = UserHelper.getUser(user);
        task.addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot snapshot) {
                    Map<String, Boolean> map1 = (Map<String, Boolean>)snapshot.get("map");

                    try {
                        if (map1.get("maths") == true) case1.setImageResource(R.drawable.maths);
                    }catch(Exception e){
                        case1.setImageResource(R.drawable.lock);
                    }

                    try {
                        if (map1.get("algo") == true) case2.setImageResource(R.drawable.algo);
                    }catch(Exception e){
                        case2.setImageResource(R.drawable.lock);
                    }

                    try {
                        if (map1.get("physique") == true) case3.setImageResource(R.drawable.physique);
                    }catch(Exception e){
                        case2.setImageResource(R.drawable.lock);
                    }

                    try {
                        if (map1.get("si") == true) case4.setImageResource(R.drawable.si);
                    }catch(Exception e){
                        case3.setImageResource(R.drawable.lock);
                    }

                    try {
                        if (map1.get("linux") == true) case5.setImageResource(R.drawable.linux);
                    }catch(Exception e){
                        case4.setImageResource(R.drawable.lock);
                    }

                    try {
                        if (map1.get("isabelle") == true) case6.setImageResource(R.drawable.isabelle);
                    }catch(Exception e){
                        case5.setImageResource(R.drawable.lock);
                    }
                case7.setImageResource(R.drawable.lock);
                case8.setImageResource(R.drawable.lock);


                }


        });


    }
}
