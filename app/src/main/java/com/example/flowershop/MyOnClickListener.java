package com.example.flowershop;

import android.content.Context;
import android.content.Intent;
import android.view.View;

public class MyOnClickListener implements View.OnClickListener{

    Context context;
    Class activityClass;

    public MyOnClickListener(View v, Context context, Class activityClass) {
        this.context = context;
        this.activityClass = activityClass;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(context,activityClass);
        context.startActivity(intent);
    }
}
