package fr.ybsi.isenclicker3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;

public class inscription extends AppCompatActivity {

    private Button valid1 ;
    private EditText username1 ;
    private EditText password1 ;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        this.valid1 = findViewById(R.id.button);
        this.username1 = findViewById(R.id.editText3);
        this.password1 = findViewById(R.id.editText4);
        this.text = findViewById(R.id.textView15);

        valid1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = username1.getText().toString();
                String password = password1.getText().toString();

                    Task<DocumentSnapshot> task = UserHelper.getUser(username);

                task.addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot snapshot) {

                        String username = username1.getText().toString();
                        String password = password1.getText().toString();

                        if (snapshot.exists() ) {
                            text.setText("Ce pseudo est deja utilisé. Veuillez en selectionner un autre");
                            return;
                        } else {
                            UserHelper.createUser(username, password);

                            Intent game = new Intent(getApplicationContext(), Game.class);
                            game.putExtra("username", username);
                            startActivity(game);
                            finish();
                        }
                    }
                });



            }
        });





    }
}
