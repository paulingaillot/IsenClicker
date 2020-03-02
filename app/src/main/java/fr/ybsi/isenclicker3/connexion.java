package fr.ybsi.isenclicker3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;

public class connexion extends AppCompatActivity {

    private Button valid1 ;
    private EditText username1 ;
    private EditText password1 ;
    private TextView mdp;

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        this.valid1 = findViewById(R.id.button);
        this.username1 = findViewById(R.id.editText3);
        this.password1 = findViewById(R.id.editText4);
        this.mdp = findViewById(R.id.textView12);


        valid1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = username1.getText().toString();
                String password = password1.getText().toString();

                Task<DocumentSnapshot> task;
                try {
                    task = UserHelper.getUser(username);
                }catch(Exception e){
                    mdp.setText("Ce joueur n'existe pas.");
                    return;
                }
                mdp.setText("Chargement en cours");

                task.addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot snapshot) {

                        if(!snapshot.exists()){
                            mdp.setText("Ce joueur n'existe pas.");
                            return;
                        }

                        String passwd = snapshot.get("password").toString();

                        String username = username1.getText().toString();
                        String password = password1.getText().toString();
                        int points =  Integer.parseInt(snapshot.get("points").toString());

                        if(password.equals(passwd)) {

                            Intent game = new Intent(getApplicationContext(), Game.class);
                            game.putExtra("username", username);
                            game.putExtra("points",points);
                            startActivity(game);
                            finish();

                        }else {
                            mdp.setText("Mot de passe erroné");


                        }


                    }
                });




            }
        });

    }
}
