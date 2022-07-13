package com.lucaspf.appcalcink;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.mViewHolder.button_add = findViewById(R.id.button_add);
        this.mViewHolder.layout_wall1 = findViewById(R.id.layout_wall1);
        this.mViewHolder.layout_empty = findViewById(R.id.layout_empty);
        this.mViewHolder.layout_room = findViewById(R.id.layout_room);


        this.mViewHolder.button_add.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_add) {
            this.mViewHolder.layout_empty.setVisibility(View.GONE);
            this.mViewHolder.layout_room.setVisibility(View.VISIBLE);
            this.mViewHolder.layout_wall1.setVisibility(View.VISIBLE);

        }
    }

    public static class ViewHolder {
        // botoes
        Button button_add;

        //empyt
        RelativeLayout layout_empty;

        //Room

        RelativeLayout layout_room;

        //parede 1

        RelativeLayout layout_wall1;


    }
}