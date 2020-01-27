package fr.ybsi.isenclicker3;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class UserHelper {

    private static final String COLLECTION_NAME = "Users";

    // --- COLLECTION REFERENCE ---

    public static CollectionReference getUsersCollection(){
        return FirebaseFirestore.getInstance().collection(COLLECTION_NAME);
    }

    // --- CREATE ---

    public static Task<Void> createUser(String username, String password) {
        User userToCreate = new User( username, password);
        return UserHelper.getUsersCollection().document(username).set(userToCreate);
    }

    // --- GET ---

    public static Task<DocumentSnapshot> getUser(String username){

        return UserHelper.getUsersCollection().document(username).get();
    }

    // --- UPDATE ---

    public static Task<Void> updateUsername(String username, String password) {
        return UserHelper.getUsersCollection().document(username).update("username", username);
    }

    public static Task<Void> updatePassword(String uid, String password) {
        return UserHelper.getUsersCollection().document(uid).update("isMentor", password);
    }

    public static Task<Void> updatePoints(String uid, int points) {
        return UserHelper.getUsersCollection().document(uid).update("points", points);
    }


    // --- DELETE ---

    public static Task<Void> deleteUser(String uid) {
        return UserHelper.getUsersCollection().document(uid).delete();
    }

}