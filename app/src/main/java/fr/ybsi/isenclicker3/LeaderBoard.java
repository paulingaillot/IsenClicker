package fr.ybsi.isenclicker3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LeaderBoard extends AppCompatActivity {

    private TextView leader;

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_board);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        this.leader = findViewById(R.id.textView14);

        Task<QuerySnapshot> task = UserHelper.getUsersCollection().get();
        task.addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot snapshot) {

                HashMap<String,Integer> map = new HashMap<String,Integer>();
                for(DocumentSnapshot doc :snapshot.getDocuments()) {
                    String username1 = doc.get("username").toString();
                    Integer points1 = Integer.parseInt(doc.get("points").toString());

                    map.put(username1, points1);
                }
                ValueComparator comparateur = new ValueComparator(map);
                TreeMap<String,Integer> mapTriee = new TreeMap<String,Integer>(comparateur);
                mapTriee.putAll(map);
                String result = ""+mapTriee;
                result = result.replaceAll("\\{", ",");
                result = result.replaceAll("\\}", "");
                String[] words = result.split(",");
                int o =0;
                result = "";
                for(String word : words) {
                    if (!word.equals("")) {
                        o++;
                        result = result + "\n" + o + " - " + word;
                    }
                }
                leader.setText(""+result);




            }
        });

    }

    class ValueComparator implements Comparator<String> {
        Map<String, Integer> base;
        public ValueComparator(Map<String, Integer> base) {
            this.base = base;
        }

        public int compare(String a, String b) {
            if (base.get(a) >= base.get(b)) {
                return -1;
            } else {
                return 1;
            }
        }
    }

}
