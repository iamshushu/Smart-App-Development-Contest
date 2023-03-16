package com.example.ohumbrella;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class homeAct extends AppCompatActivity {

    private long backKeyPressedTime = 0;
    private Toast toast;

    public static Context context_main;
    public boolean borrow_umb = true; //한번만 빌릴 수 있도록 제한
    public boolean return_umb = false; //빌려야지만 반납할 수 있다.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        context_main = this;

        boolean borrow1 = Control_borrow_return.getInstance().getBorrow1();
        boolean return1 = Control_borrow_return.getInstance().getReturn1();



        Button button1=findViewById(R.id.borrow_btn);
        Button button2=findViewById(R.id.return_btn);
        Button button3=findViewById(R.id.rest_time_btn);
        Button button4=findViewById(R.id.report_btn);

        //대여완료시 대여기능 막기, 대여중 아닐때 반납기능막기
//        if(borrow1){
//            button1.setEnabled(true);
//            button2.setEnabled(false);
//        }
//        if(return1){
//            button1.setEnabled(false);
//            button2.setEnabled(true);
//        }

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(homeAct.this, borrowAct.class);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent=new Intent(homeAct.this,returnAct.class);
                startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent=new Intent(homeAct.this,Rest_timeAct.class);
                startActivity(intent);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent=new Intent(homeAct.this,reportAct.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed(){
        if (System.currentTimeMillis() > backKeyPressedTime + 2000) {
            backKeyPressedTime = System.currentTimeMillis();
            toast = Toast.makeText(this, "한번 더 누르면 로그아웃됩니다.", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        // 마지막으로 뒤로가기 버튼을 눌렀던 시간에 2초를 더해 현재시간과 비교 후
        // 마지막으로 뒤로가기 버튼을 눌렀던 시간이 2초가 지나지 않았으면 종료
        // 현재 표시된 Toast 취소
        if (System.currentTimeMillis() <= backKeyPressedTime + 2000) {
            Intent intent=new Intent(homeAct.this,MainActivity.class);
            startActivity(intent);

        }



    }
}
