package com.example.ohumbrella;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class Get_umbId_umbState_Request extends StringRequest {

    final static private String URL = "http://bjan0227.dothome.co.kr/Report.php";
    private Map<String,String> map;

    public Get_umbId_umbState_Request(String umbLocation, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("umbLocation", umbLocation);

    }
    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
