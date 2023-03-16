package com.example.ohumbrella;

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

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class borrow_umb_jeongui extends AppCompatDialogFragment implements View.OnClickListener {

    public String datestr;
    Calendar c;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.activity_umb_jeongui, container, false);
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

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_umb1){
            AlertDialog.Builder ad = new AlertDialog.Builder(v.getContext());
            ad.setMessage("정의관 1에서 빌리시겠습니까? ");

            ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    Intent intent=new Intent(v.getContext(),homeAct.class);
                    startActivity(intent);
                    Toast.makeText(v.getContext(),"대여를 성공하였습니다.",Toast.LENGTH_SHORT).show();

                    c = Calendar.getInstance();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/HH/mm/ss");
                    datestr = sdf.format(c.getTime());
                    Get_borrowTime.getInstance().setTime(datestr);
                }
            });
            ad.setNegativeButton("취소",null);
            ad.show();
        }else if(v.getId()==R.id.btn_umb2){
            AlertDialog.Builder ad = new AlertDialog.Builder(v.getContext());
            ad.setMessage("정의관 2에서 빌리시겠습니까? ");

            ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    Intent intent=new Intent(v.getContext(),homeAct.class);
                    startActivity(intent);
                    Toast.makeText(v.getContext(),"대여를 성공하였습니다.",Toast.LENGTH_SHORT).show();

                    c = Calendar.getInstance();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/HH/mm/ss");
                    datestr = sdf.format(c.getTime());
                    Get_borrowTime.getInstance().setTime(datestr);
                }
            });
            ad.setNegativeButton("취소",null);
            ad.show();
        }else if(v.getId()==R.id.btn_umb3){
            AlertDialog.Builder ad = new AlertDialog.Builder(v.getContext());
            ad.setMessage("정의관 3에서 빌리시겠습니까? ");

            ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    Intent intent=new Intent(v.getContext(),homeAct.class);
                    startActivity(intent);
                    Toast.makeText(v.getContext(),"대여를 성공하였습니다.",Toast.LENGTH_SHORT).show();

                    c = Calendar.getInstance();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/HH/mm/ss");
                    datestr = sdf.format(c.getTime());
                    Get_borrowTime.getInstance().setTime(datestr);
                }
            });
            ad.setNegativeButton("취소",null);
            ad.show();
        }else if(v.getId()==R.id.btn_umb4){
            AlertDialog.Builder ad = new AlertDialog.Builder(v.getContext());
            ad.setMessage("정의관 4에서 빌리시겠습니까? ");

            ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    Intent intent=new Intent(v.getContext(),homeAct.class);
                    startActivity(intent);
                    Toast.makeText(v.getContext(),"대여를 성공하였습니다.",Toast.LENGTH_SHORT).show();

                    c = Calendar.getInstance();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/HH/mm/ss");
                    datestr = sdf.format(c.getTime());
                    Get_borrowTime.getInstance().setTime(datestr);
                }
            });
            ad.setNegativeButton("취소",null);
            ad.show();
        }else if(v.getId()==R.id.btn_umb5){
            AlertDialog.Builder ad = new AlertDialog.Builder(v.getContext());
            ad.setMessage("정의관 5에서 빌리시겠습니까? ");

            ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    Intent intent=new Intent(v.getContext(),homeAct.class);
                    startActivity(intent);
                    Toast.makeText(v.getContext(),"대여를 성공하였습니다.",Toast.LENGTH_SHORT).show();

                    c = Calendar.getInstance();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/HH/mm/ss");
                    datestr = sdf.format(c.getTime());
                    Get_borrowTime.getInstance().setTime(datestr);
                }
            });
            ad.setNegativeButton("취소",null);
            ad.show();
        }else if(v.getId()==R.id.btn_umb6){
            AlertDialog.Builder ad = new AlertDialog.Builder(v.getContext());
            ad.setMessage("정의관 6에서 빌리시겠습니까? ");

            ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    Intent intent=new Intent(v.getContext(),homeAct.class);
                    startActivity(intent);
                    Toast.makeText(v.getContext(),"대여를 성공하였습니다.",Toast.LENGTH_SHORT).show();

                    c = Calendar.getInstance();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/HH/mm/ss");
                    datestr = sdf.format(c.getTime());
                    Get_borrowTime.getInstance().setTime(datestr);
                }
            });
            ad.setNegativeButton("취소",null);
            ad.show();
        }
    }
}
