package com.example.ohumbrella;

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

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class reportAct extends AppCompatActivity {

    private EditText et_umbId;
    private EditText et_suggestion;
    private Button btn_report;
    private boolean report = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        et_umbId = findViewById(R.id.et_umbId);
        et_suggestion= findViewById(R.id.et_suggestion);
        btn_report=findViewById(R.id.btn_report);

        btn_report.setOnClickListener(view -> {
            doReport();
            et_umbId.setText(null);
            et_suggestion.setText(null);
            et_umbId.requestFocus();
        });
    }

    private void doReport(){

        String umbId = et_umbId.getText().toString().trim();
        String suggestion = et_suggestion.getText().toString().trim();
        Calendar reporttime = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yy/MM/dd");
        String report_time =formatter.format(reporttime.getTime());

        if(report){
            return;
        }
        if(umbId.equals("")){
            AlertDialog.Builder ad = new AlertDialog.Builder(reportAct.this);
            ad.setMessage("우산 번호는 손잡이에 붙어 있습니다. \n우산 번호를 입력해주세요.");
            ad.setPositiveButton("확인",null);
            ad.show();
            return;
        }
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try{
                    JSONObject jsonObject = new JSONObject(response);
                    boolean success = jsonObject.getBoolean("success");
                    if(success){
                        Intent intent = new Intent(reportAct.this,homeAct.class);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(),"신고 접수가 완료되었습니다.",Toast.LENGTH_SHORT).show();
                        report = true;
                    }else{//신고접수에 실패한 경우
                        Toast.makeText(getApplicationContext(),"신고 접수가 실패하였습니다.",Toast.LENGTH_SHORT).show();
                    }
                }catch(JSONException e){
                    e.printStackTrace();
                }

            }
        };

        //서버로 Volley를 이용해서 요청을 함.
        reportRequest ReportRequest = new reportRequest(umbId,suggestion,report_time,responseListener);
        RequestQueue queue = Volley.newRequestQueue(reportAct.this);
        queue.add(ReportRequest);

        reportRequest2 ReportRequest2 = new reportRequest2(umbId,responseListener);
        RequestQueue queue2 = Volley.newRequestQueue(reportAct.this);
        queue2.add(ReportRequest2);

    }
}
