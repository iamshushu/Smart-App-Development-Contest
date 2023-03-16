package com.example.ohumbrella;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private EditText et_id;
    private EditText et_pass;
    private Button login_btn,join_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_id = findViewById(R.id.et_id);
        et_pass = findViewById(R.id.et_pass);
        login_btn = findViewById(R.id.login_btn);
        join_btn = findViewById(R.id.join_btn);


        join_btn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, joinAct.class);
            startActivity(intent);
        });

        login_btn.setOnClickListener(v -> {
            doLogin();
        });


    }
    @Override
    public void onBackPressed(){
        ActivityCompat.finishAffinity(this);
        System.runFinalization();
        System.exit(0);
    }

    private void doLogin() {
        //EditText에 현재 입력되어있는 값 get
        String Id = et_id.getText().toString().trim();
        String Pass = et_pass.getText().toString().trim();

        if (Id.length() == 0) {
            Toast.makeText(this, "아이디를 입력해주세요. ", Toast.LENGTH_SHORT).show();
            et_id.requestFocus();
            return;
        }

        if (Pass.length() == 0) {
            Toast.makeText(this, "비밀번호를 입력해주세요. ", Toast.LENGTH_SHORT).show();
            et_pass.requestFocus();
            return;
        }

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try{
                    JSONObject jsonObject = new JSONObject(response);
                    boolean success = jsonObject.getBoolean("success");
                    if(success){
                        String userId = jsonObject.getString("userId");
                        String userPassword= jsonObject.getString("userPassword");
                        Toast.makeText(getApplicationContext(),"로그인에 성공하였습니다.",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this,homeAct.class);
                        //아이디 패스워드를 homeAct로 값전달
                        intent.putExtra("userId",userId);
                        intent.putExtra("userPassword",userPassword);

                        startActivity(intent);
                        et_pass.setText(null); //비밀번호 칸 비우는건데 어색하면 변경,,
                    }else{//회원등록에 실패한 경우
                        Toast.makeText(getApplicationContext(),"로그인에 실패하였습니다.",Toast.LENGTH_SHORT).show();
                    }
                }catch(JSONException e){
                    e.printStackTrace();
                }
            }
        };
        //서버로 Volley를 이용해서 요청을 함.
        LoginRequest loginRequest = new LoginRequest(Id,Pass,responseListener);
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        queue.add(loginRequest);
    }

}
