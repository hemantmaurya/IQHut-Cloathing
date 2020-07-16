package com.example.iqhutclothing;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private TextInputLayout etUname, etPass;
    private Button btnlogin;
    private TextView tvreg;
    private PreferenceHelper preferenceHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_login );
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN );

        preferenceHelper = new PreferenceHelper(this);

        if(preferenceHelper.getIsLogin()){
            finish();
            startActivity( new Intent( this, MainActivity.class ) );
        }

        etUname = (TextInputLayout) findViewById(R.id.username);
        etPass =  (TextInputLayout) findViewById(R.id.password);

        btnlogin = (Button) findViewById(R.id.go);
//        tvreg = (TextView) findViewById(R.id.tvreg);



//        tvreg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                startActivity(intent);
//                LoginActivity.this.finish();
//            }
//        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getBaseContext(), "lxxxlogin This is my Toast message!",
//                        Toast.LENGTH_LONG).show();
                loginUser();
            }
        });



    }

    private void loginUser() {
        final String username = etUname.getEditText().getText().toString().trim();
        final String password = etPass.getEditText().getText().toString().trim();

        Toast.makeText( LoginActivity.this, username, Toast.LENGTH_SHORT ).show();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl( APIs.LOGINURL )
                .addConverterFactory( ScalarsConverterFactory.create() )
                .build();

        APIs api = retrofit.create( APIs.class );


        Call<String> call = api.getUserLogin( username, password );

        call.enqueue( new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i( "Responsestring", response.body().toString() );

                //Toast.makeText()

                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.i( "onSuccess", response.body().toString() );

                        String jsonresponse = response.body().toString();
                        parseLoginData(jsonresponse);

                    } else {
                        Log.i( "onEmptyResponse", "Returned empty response" );//Toast.makeText(getContext(),"Nothing returned",Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        } );
    }


        private void parseLoginData(String response){
            try {
                JSONObject jsonObject = new JSONObject(response);
                if (jsonObject.getString("status").equals("true")) {

                    saveInfo(response);

                    Toast.makeText(LoginActivity.this, "Login Successfully!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    this.finish();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        private void saveInfo(String response){

            preferenceHelper.putIsLogin(true);
            try {
                JSONObject jsonObject = new JSONObject(response);
                if (jsonObject.getString("status").equals("true")) {
                    JSONArray dataArray = jsonObject.getJSONArray("data");
                    for (int i = 0; i < dataArray.length(); i++) {

                        JSONObject dataobj = dataArray.getJSONObject(i);
                        preferenceHelper.putName(dataobj.getString("name"));
                        preferenceHelper.putHobby(dataobj.getString("hobby"));
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
}

