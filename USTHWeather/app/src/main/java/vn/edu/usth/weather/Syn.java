package vn.edu.usth.weather;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class Syn {
    private static Syn syn;
    private RequestQueue requestQueue;
    private static Context mCtx;
    private Syn(Context context){
        mCtx = context;
    }

    public RequestQueue getRequestQueue() {
        if(requestQueue ==null){
            requestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return requestQueue;
    }

    public static synchronized Syn getInstance(Context context){
        if(syn == null){
            syn = new Syn(context);
        }
        return syn;
    }

    public <T> void addToRequestQue(Request<T> request){
        requestQueue.add(request);
    }
}
