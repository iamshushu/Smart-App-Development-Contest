package com.example.ohumbrella;


import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class reportRequest extends StringRequest {

    final static private String URL = "http://bjan0227.dothome.co.kr/Report.php";
    private Map<String,String> map;

    public reportRequest(String et_umbId,String et_suggestion, String report_time,Response.Listener<String> listener){
        super(Method.POST,URL,listener,null);

        map = new HashMap<>();
        map.put("umbId",et_umbId);
        map.put("text",et_suggestion);
        map.put("report_time",report_time);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }

}

