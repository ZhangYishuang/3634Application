package com.example.shuhao20.finalapplication;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Base64;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;


import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class LoginActivity extends AppCompatActivity {

    LoginButton loginButton;
    TextView name;
    ImageView profile;
    CallbackManager callbackManager;
    String id;
    String url;
    String myname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        intent = getIntent();
//        position = intent.getIntExtra("pos", 0);
        facebooklogin();
        }

        public void facebooklogin(){
            loginButton = (LoginButton)findViewById(R.id.login_button);

            name = (TextView)findViewById(R.id.Name);

            loginButton.setReadPermissions(Arrays.asList("public_profile","email"));


            callbackManager = CallbackManager.Factory.create();
            loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
                @Override
                public void onSuccess(LoginResult loginResult) {
                    //textView.setText("Login Sucess \n" + loginResult.getAccessToken().getUserId()+"\n"+loginResult.getAccessToken().getToken());

                   id = loginResult.getAccessToken().getUserId();
                    System.out.println(id);
                    GraphRequest graphRequest = GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                        @Override
                        public void onCompleted(JSONObject object, GraphResponse response) {

//                            String url = "http://graph.facebook.com/"+id+"/picture?type=large";
//                            name.setText(url);

                            displayUserInfo(object);

//                            Intent intent = new Intent(MainActivity.this, SecondAct.class);
//
//                            intent.putExtra("url",url);
//                            intent.putExtra("name",myname);
//                            startActivity(intent);


                        }
                    });

                    Bundle parameters = new Bundle();
                    parameters.putString("fields", "first_name, email, id");
                    graphRequest.setParameters(parameters);
                    graphRequest.executeAsync();
                }

                @Override
                public void onCancel() {
                    name.setText("Loging Cancelled");
                }
                @Override
                public void onError(FacebookException error) {

                }
            });

    }


    public void displayUserInfo(JSONObject object) {
        TextView yyyyyyy=findViewById(R.id.success);
        try {
            System.out.println(myname);
            profile = (ImageView)findViewById(R.id.Image);
            url = "http://graph.facebook.com/"+id+"/picture?type=large";
            myname = object.getString("first_name");

            Glide.with(this).load(url).into(profile);
            System.out.println("1"+myname);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println("2"+myname);
        yyyyyyy.setText(myname);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

}
