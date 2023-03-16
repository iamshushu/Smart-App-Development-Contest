package com.example.ohumbrella;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import java.util.Calendar;

public class return_umb_1science extends AppCompatDialogFragment implements View.OnClickListener {

    public static Context context_umb_1science;
    //boolean borrow_umb = ((homeAct)homeAct.context_main).borrow_umb; //homeAct 와 변수 공유
    public String datestr;
    Calendar c;
    private String string1;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.activity_return_umb_1science, container, false);
        Button btn1 = (Button) v.findViewById(R.id.btn_umb1);
        Button btn2 = (Button) v.findViewById(R.id.btn_umb2);
        Button btn3 = (Button) v.findViewById(R.id.btn_umb3);
        Button btn4 = (Button) v.findViewById(R.id.btn_umb4);
        Button btn5 = (Button) v.findViewById(R.id.btn_umb5);
        Button btn6 = (Button) v.findViewById(R.id.btn_umb6);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);

        return v;
    }
    public Calendar getBorrowTime(){
        return c;
    }
    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_umb1){
            AlertDialog.Builder ad = new AlertDialog.Builder(v.getContext());
            ad.setMessage("제1과기대 1에 반납하시겠습니까? ");

            ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //borrow_umb = false;
                    string1 = "제1과기대1";
                    dialog.dismiss();
                    Intent intent=new Intent(v.getContext(),homeAct.class);
                    startActivity(intent);
                    Toast.makeText(v.getContext(),"반납을 성공하였습니다.", Toast.LENGTH_SHORT).show();
                    //대여시간 초기화
                    Get_borrowTime.getInstance().setTime("");
                }
            });
            ad.setNegativeButton("취소",null);
            ad.show();
        }else if(v.getId()==R.id.btn_umb2){
            AlertDialog.Builder ad = new AlertDialog.Builder(v.getContext());
            ad.setMessage("제1과기대 2에 반납하시겠습니까? ");

            ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    string1 = "제1과기대2";
                    dialog.dismiss();
                    Intent intent=new Intent(v.getContext(),homeAct.class);
                    startActivity(intent);
                    Toast.makeText(v.getContext(),"반납을 성공하였습니다.",Toast.LENGTH_SHORT).show();
                    Get_borrowTime.getInstance().setTime("");
                }
            });
            ad.setNegativeButton("취소",null);
            ad.show();
        }else if(v.getId()==R.id.btn_umb3){
            AlertDialog.Builder ad = new AlertDialog.Builder(v.getContext());
            ad.setMessage("제1과기대 3에 반납하시겠습니까? ");

            ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    string1 = "제1과기대3";
                    dialog.dismiss();
                    Intent intent=new Intent(v.getContext(),homeAct.class);
                    startActivity(intent);
                    Toast.makeText(v.getContext(),"반납을 성공하였습니다.",Toast.LENGTH_SHORT).show();
                    Get_borrowTime.getInstance().setTime("");
                }
            });
            ad.setNegativeButton("취소",null);
            ad.show();
        }else if(v.getId()==R.id.btn_umb4){
            AlertDialog.Builder ad = new AlertDialog.Builder(v.getContext());
            ad.setMessage("제1과기대 4에 반납하시겠습니까? ");

            ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    string1 = "제1과기대4";
                    dialog.dismiss();
                    Intent intent=new Intent(v.getContext(),homeAct.class);
                    startActivity(intent);
                    Toast.makeText(v.getContext(),"반납을 성공하였습니다.",Toast.LENGTH_SHORT).show();
                    Get_borrowTime.getInstance().setTime("");
                }
            });
            ad.setNegativeButton("취소",null);
            ad.show();
        }else if(v.getId()==R.id.btn_umb5){
            AlertDialog.Builder ad = new AlertDialog.Builder(v.getContext());
            ad.setMessage("제1과기대 5에 반납하시겠습니까? ");

            ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    string1 = "제1과기대5";
                    dialog.dismiss();
                    Intent intent=new Intent(v.getContext(),homeAct.class);
                    startActivity(intent);
                    Toast.makeText(v.getContext(),"반납을 성공하였습니다.",Toast.LENGTH_SHORT).show();
                    Get_borrowTime.getInstance().setTime("");
                }
            });
            ad.setNegativeButton("취소",null);
            ad.show();
        }else if(v.getId()==R.id.btn_umb6){
            AlertDialog.Builder ad = new AlertDialog.Builder(v.getContext());
            ad.setMessage("제1과기대 6에 반납하시겠습니까? ");

            ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    string1 = "제1과기대6";
                    dialog.dismiss();
                    Intent intent=new Intent(v.getContext(),homeAct.class);
                    startActivity(intent);
                    Toast.makeText(v.getContext(),"반납을 성공하였습니다.",Toast.LENGTH_SHORT).show();
                    Get_borrowTime.getInstance().setTime("");
                }
            });
            ad.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    return;
                }
            });
            ad.show();
        }

    }

}

