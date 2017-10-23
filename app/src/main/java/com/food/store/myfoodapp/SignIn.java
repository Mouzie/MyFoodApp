package com.food.store.myfoodapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.food.store.myfoodapp.Common.Common;
import com.food.store.myfoodapp.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

public class SignIn extends AppCompatActivity {

    MaterialEditText txtPhone, txtPassword, txtName;
    Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        txtPhone = (MaterialEditText)findViewById(R.id.txtPhone);
        txtPassword = (MaterialEditText)findViewById(R.id.txtPassword);
        txtName = (MaterialEditText)findViewById(R.id.txtName);
        btnSignIn = (Button)findViewById(R.id.btnSignIn);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog mDialog = new ProgressDialog(SignIn.this);
                mDialog.setMessage("Please wait . . .");
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                            if(dataSnapshot.child(txtPhone.getText().toString()).exists()){

                            User user = dataSnapshot.child(txtPhone.getText().toString()).getValue(User.class);
                            if (user.getPassword().equals(txtPassword.getText().toString()))
                            {
//                                Toast.makeText(SignIn.this, "Sign In was good!!!", Toast.LENGTH_SHORT);
                                Intent homeIntent = new Intent(SignIn.this, Home.class);
                                Common.currentUser = user;
                                startActivity(homeIntent);
                                finish();
                            } else {
                                mDialog.dismiss();
                                Toast.makeText(SignIn.this, "Ey man, wrong password!!!", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else{
                                Toast.makeText(SignIn.this, "You're not a member.", Toast.LENGTH_SHORT);
                            }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}
