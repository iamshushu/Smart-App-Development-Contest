package com.example.ohumbrella;


import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class reportRequest2 extends StringRequest {

    final static private String URL = "http://bjan0227.dothome.co.kr/Report2.php";
    private Map<String,String> map;

    public reportRequest2(String et_umbId, Response.Listener<String> listener){
        super(Method.POST,URL,listener,null);

        map = new HashMap<>();
        map.put("umbId",et_umbId);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }

}

