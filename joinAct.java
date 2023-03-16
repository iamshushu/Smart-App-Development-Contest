package com.example.ohumbrella;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class joinAct extends AppCompatActivity {

    private EditText et_id;
    private EditText et_pass;
    private EditText et_passck;
    private EditText et_name;
    private EditText et_hak;
    private EditText et_maj;
    private Button register_btn,validate_btn;
    private Dialog dialog;
    private boolean validate = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        et_id = findViewById(R.id.et_id);
        et_pass = findViewById(R.id.et_pass);
        et_passck = findViewById(R.id.et_passck);
        et_name = findViewById(R.id.et_name);
        et_hak = findViewById(R.id.et_hak);
        et_maj = findViewById(R.id.et_maj);

        validate_btn = findViewById(R.id.validate_btn);
        register_btn = findViewById(R.id.register_btn);

        validate_btn.setOnClickListener(v -> {

            doCheck();
        });
        //회원가입 버튼 클릭시 수행
        register_btn.setOnClickListener(v -> {
            doJoin();
        });
    }
    private void doCheck(){
        String Id = et_id.getText().toString();
        if(validate){
            return;
        }
        if(Id.equals("")){
            AlertDialog.Builder ad = new AlertDialog.Builder(joinAct.this);
            dialog = ad.setMessage("아이디는 빈 칸일 수 없습니다.").setPositiveButton("확인",null).create();
            dialog.show();
            return;
        }
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try{
                    JSONObject jsonObject = new JSONObject(response);
                    boolean success = jsonObject.getBoolean("success");
                    if(success){
                        AlertDialog.Builder ad = new AlertDialog.Builder(joinAct.this);
                        ad.setMessage("사용할 수 있는 아이디입니다.");
                        ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        ad.show();
                        et_id.setEnabled(false);
                        validate = true;
                        validate_btn.setBackgroundColor(getResources().getColor(R.color.colorRoyalBlue));
                    }else{//아이디 중복인 경우
                        AlertDialog.Builder ad = new AlertDialog.Builder(joinAct.this);
                        ad.setMessage("사용할 수 없는 아이디입니다.");
                        ad.setNegativeButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        ad.show();
                    }
                }catch(JSONException e){
                    e.printStackTrace();
                }

            }

        };
        UserValidateRequest userValidateRequest = new UserValidateRequest(Id,responseListener);
        RequestQueue queue = Volley.newRequestQueue(joinAct.this);
        queue.add(userValidateRequest);
    }
    private void doJoin(){
        //EditText에 현재 입력되어있는 값 get
        String Id = et_id.getText().toString().trim();
        String Pass = et_pass.getText().toString().trim();
        String Passck = et_passck.getText().toString().trim();
        String Name = et_name.getText().toString().trim();
        String Hak= et_hak.getText().toString().trim();
        String Maj= et_maj.getText().toString().trim();

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
        if(Pass.equals(Passck)==false){
            Toast.makeText(this,"비밀번호가 일치하지 않습니다. ",Toast.LENGTH_SHORT).show();
            et_passck.requestFocus();
            return;
        }
        if(Name.length() == 0){
            Toast.makeText(this,"이름을 입력해주세요. ",Toast.LENGTH_SHORT).show();
            et_name.requestFocus();
            return;
        }
        if(Hak.length()==0){
            Toast.makeText(this,"학번을 입력해주세요. ",Toast.LENGTH_SHORT).show();
            et_hak.requestFocus();
            return;
        }if(Maj.length() == 0){
            Toast.makeText(this,"전공을 입력해주세요. ",Toast.LENGTH_SHORT).show();
            et_maj.requestFocus();
            return;
        }

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try{
                    JSONObject jsonObject = new JSONObject(response);
                    boolean success = jsonObject.getBoolean("success");
                    if(success){
                        Toast.makeText(getApplicationContext(),"회원등록에 성공하였습니다.",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(joinAct.this,MainActivity.class);
                        startActivity(intent);
                    }else{//회원등록에 실패한 경우
                        Toast.makeText(getApplicationContext(),"회원등록에 실패하였습니다.",Toast.LENGTH_SHORT).show();
                    }
                }catch(JSONException e){
                    e.printStackTrace();
                }

            }
        };
        //서버로 Volley를 이용해서 요청을 함.
        RegisterRequest registerRequest = new RegisterRequest(Id,Pass,Name,Hak,Maj,responseListener);
        RequestQueue queue = Volley.newRequestQueue(joinAct.this);
        queue.add(registerRequest);
    }
}
