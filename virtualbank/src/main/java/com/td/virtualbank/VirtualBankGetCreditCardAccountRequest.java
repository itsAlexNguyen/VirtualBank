package com.td.virtualbank;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;

public abstract class VirtualBankGetCreditCardAccountRequest implements Listener<JSONObject>, Response.ErrorListener {

    @Override
    public void onResponse(JSONObject response) {
        try {
            GsonBuilder builder = new GsonBuilder();
            builder.setPrettyPrinting();
            Gson gson = builder.create();
            VirtualBankCreditCardAccount obj = gson.fromJson(response.getJSONObject("result").getJSONObject("creditCardAccount").toString(),VirtualBankCreditCardAccount.class);
            onSuccess(obj);
        } catch (JSONException e) {
            Log.e("VirtualBank", "No values found");
        }
    }

    @Override
    public void onErrorResponse(VolleyError error){
        onError(error);
    }

    public abstract void onSuccess(VirtualBankCreditCardAccount response);

    public abstract void onError(VolleyError error);

}