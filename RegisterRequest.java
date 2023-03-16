package com.example.ohumbrella;


import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {

    //서버 URL 설정 (PHP 파일 연동)
    final static private String URL = "http://bjan0227.dothome.co.kr/Register.php";
    private Map<String,String> map;

    public RegisterRequest(String userId, String userPassword, String userName, String userStdnumber, String userMajor, Response.Listener<String> listener){
        super(Method.POST,URL,listener,null);

        map = new HashMap<>();
        map.put("userId",userId);
        map.put("userPassword",userPassword);
        map.put("userName",userName);
        map.put("userStdnumber",userStdnumber+"");
        map.put("userMajor",userMajor);

    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
