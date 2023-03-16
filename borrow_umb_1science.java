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

public class borrow_umb_1science extends AppCompatDialogFragment implements View.OnClickListener {

    public String datestr;
    Calendar c;
    private boolean borrow1;
    private boolean return1;
    //String umbLocation = "제1과기대1";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        //super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.activity_umb_1science, container, false);
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
        if (v.getId() == R.id.btn_umb1) {
            AlertDialog.Builder ad = new AlertDialog.Builder(v.getContext());
            ad.setMessage("제1과기대 1에서 빌리시겠습니까? ");

            ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();

//                    //여기부분 지금 안맞음
//                    Response.Listener<String> responseListener = new Response.Listener<String>() {
//                        @Override
//                        public void onResponse(String response) {
//                            try{
//                                JSONObject jsonObject = new JSONObject(response);
//                                boolean success = jsonObject.getBoolean("success");
//                                if (success) {
//                                    String umbId = jsonObject.getString("umbId");
//                                    String umbLocation= jsonObject.getString("umbLocation");
//                                    Toast.makeText(v.getContext(), ""+umbId+", "+umbLocation, Toast.LENGTH_SHORT).show();
//
//                                } else {//대여에 실패한 경우
//                                    String umbId = jsonObject.getString("umbId");
//                                    String umbLocation= jsonObject.getString("umbLocation");
//                                    Toast.makeText(v.getContext(), ""+umbId+", "+umbLocation, Toast.LENGTH_SHORT).show();
//                                }
//                            }catch (JSONException e) {
//                                e.printStackTrace();
//                            }
//
//                        }
//                    };
//                    //서버로 Volley를 이용해서 요청을 함.
//                    Get_umbId_umbState_Request get_umbId_umbState_request= new Get_umbId_umbState_Request("제1과기대1",responseListener);
//                    RequestQueue queue = Volley.newRequestQueue(v.getContext());
//                    queue.add(get_umbId_umbState_request);
                    borrow1 = false;
                    return1 = true;
                    Control_borrow_return.getInstance().setBorrow1(borrow1);
                    Control_borrow_return.getInstance().setReturn1(return1);

                    Toast.makeText(v.getContext(),"대여를 성공하였습니다.",Toast.LENGTH_SHORT).show();

                    c = Calendar.getInstance();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/HH/mm/ss");
                    datestr = sdf.format(c.getTime());
                    Get_borrowTime.getInstance().setTime(datestr);

                    Intent intent = new Intent(v.getContext(), homeAct.class);
                    startActivity(intent);

                }
            });
            ad.setNegativeButton("취소", null);
            ad.show();
//            Response.Listener<String> responseListener = new Response.Listener<String>() {
//                @Override
//                public void onResponse(String response) {
//                    try{
//                        JSONObject jsonObject = new JSONObject(response);
//                        boolean success = jsonObject.getBoolean("success");
//                        if(success){
//                            String umbId = jsonObject.getString("umbId");
//                            String umbState= jsonObject.getString("umbState");
//                            Toast.makeText(v.getContext(),""+umbId+","+umbState,Toast.LENGTH_SHORT).show();
////                        Intent intent = new Intent(MainActivity.this,homeAct.class);
////                        //아이디 패스워드를 homeAct로 값전달
////                        intent.putExtra("userId",userId);
////                        intent.putExtra("userPassword",userPassword);
//
////                        startActivity(intent);
//                        }else{//umb정보 갖고오는데 실패할경우
//                            Toast.makeText(v.getContext(),"umbId와 umbState받아오는데 실패",Toast.LENGTH_SHORT).show();
//                        }
//                    }catch(JSONException e){
//                        e.printStackTrace();
//                    }
//                }
//            };
//            //서버로 Volley를 이용해서 요청을 함.
//            Get_umbId_umbState_Request get_umbId_umbState_request= new Get_umbId_umbState_Request(umbLocation,responseListener);
//            RequestQueue queue = Volley.newRequestQueue(v.getContext());
//            queue.add(get_umbId_umbState_request);


        } else if (v.getId() == R.id.btn_umb2) {
            AlertDialog.Builder ad = new AlertDialog.Builder(v.getContext());
            ad.setMessage("제1과기대 2에서 빌리시겠습니까? ");

            ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();

                    borrow1 = false;
                    return1 = true;
                    Control_borrow_return.getInstance().setBorrow1(borrow1);
                    Control_borrow_return.getInstance().setReturn1(return1);

                    Intent intent = new Intent(v.getContext(), homeAct.class);
                    startActivity(intent);
                    Toast.makeText(v.getContext(),"대여를 성공하였습니다.",Toast.LENGTH_SHORT).show();

                    c = Calendar.getInstance();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/HH/mm/ss");
                    datestr = sdf.format(c.getTime());
                    Get_borrowTime.getInstance().setTime(datestr);
                }
            });
            ad.setNegativeButton("취소", null);
            ad.show();
        } else if (v.getId() == R.id.btn_umb3) {
            AlertDialog.Builder ad = new AlertDialog.Builder(v.getContext());
            ad.setMessage("제1과기대 3에서 빌리시겠습니까? ");

            ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    Intent intent = new Intent(v.getContext(), homeAct.class);
                    startActivity(intent);
                    Toast.makeText(v.getContext(), "대여를 성공하였습니다.", Toast.LENGTH_SHORT).show();

                    c = Calendar.getInstance();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/HH/mm/ss");
                    datestr = sdf.format(c.getTime());
                    Get_borrowTime.getInstance().setTime(datestr);
                }
            });
            ad.setNegativeButton("취소", null);
            ad.show();
        } else if (v.getId() == R.id.btn_umb4) {
            AlertDialog.Builder ad = new AlertDialog.Builder(v.getContext());
            ad.setMessage("제1과기대 4에서 빌리시겠습니까? ");

            ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    Intent intent = new Intent(v.getContext(), homeAct.class);
                    startActivity(intent);
                    Toast.makeText(v.getContext(), "대여를 성공하였습니다.", Toast.LENGTH_SHORT).show();

                    c = Calendar.getInstance();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/HH/mm/ss");
                    datestr = sdf.format(c.getTime());
                    Get_borrowTime.getInstance().setTime(datestr);
                }
            });
            ad.setNegativeButton("취소", null);
            ad.show();
        } else if (v.getId() == R.id.btn_umb5) {
            AlertDialog.Builder ad = new AlertDialog.Builder(v.getContext());
            ad.setMessage("제1과기대 5에서 빌리시겠습니까? ");

            ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    Intent intent = new Intent(v.getContext(), homeAct.class);
                    startActivity(intent);
                    Toast.makeText(v.getContext(), "대여를 성공하였습니다.", Toast.LENGTH_SHORT).show();

                    c = Calendar.getInstance();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/HH/mm/ss");
                    datestr = sdf.format(c.getTime());
                    Get_borrowTime.getInstance().setTime(datestr);
                }
            });
            ad.setNegativeButton("취소", null);
            ad.show();
        } else if (v.getId() == R.id.btn_umb6) {
            AlertDialog.Builder ad = new AlertDialog.Builder(v.getContext());
            ad.setMessage("제1과기대 6에서 빌리시겠습니까? ");

            ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    Intent intent = new Intent(v.getContext(), homeAct.class);
                    startActivity(intent);
                    Toast.makeText(v.getContext(), "대여를 성공하였습니다.", Toast.LENGTH_SHORT).show();

                    c = Calendar.getInstance();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/HH/mm/ss");
                    datestr = sdf.format(c.getTime());
                    Get_borrowTime.getInstance().setTime(datestr);
                }
            });
            ad.setNegativeButton("취소", null);
            ad.show();
        }
    }
}
