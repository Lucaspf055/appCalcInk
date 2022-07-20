package com.lucaspf.appcalcink.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lucaspf.appcalcink.R;
import com.lucaspf.appcalcink.data.Data;
import com.lucaspf.appcalcink.model.Wall;

public class form_add_wall extends AppCompatActivity implements View.OnClickListener {
    ViewHolder mViewHolder = new ViewHolder();
    Data data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_add_wall);

        data = new Data(this);

        this.mViewHolder.add_wall_altura = findViewById(R.id.add_wall_altura);
        this.mViewHolder.add_wall_largura = findViewById(R.id.add_wall_largura);
        this.mViewHolder.add_wall_portas = findViewById(R.id.add_wall_portas);
        this.mViewHolder.add_wall_janelas = findViewById(R.id.add_wall_janelas);


        //Button
        this.mViewHolder.button_add_wall = findViewById(R.id.button_add_wall);
        this.mViewHolder.button_back = findViewById(R.id.button_back);

        this.mViewHolder.button_back.setOnClickListener(this);
        this.mViewHolder.button_add_wall.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button_back) {
            Intent intent = new Intent();
            setResult(Activity.RESULT_CANCELED, intent);

            this.finish();
        }
        else if (view.getId() == R.id.button_add_wall) {
            Intent intent = new Intent();
            Gson gson = new Gson();

            Wall wall = new Wall(Double.parseDouble(String.valueOf(this.mViewHolder.add_wall_altura.getText())), Double.parseDouble(String.valueOf(this.mViewHolder
            .add_wall_altura.getText())), Integer.parseInt(String.valueOf(this.mViewHolder.add_wall_portas.getText())), Integer.parseInt(String.valueOf(this.mViewHolder.add_wall_janelas.getText())));

            String jsonWall = gson.toJson(wall);

            this.data.storeString("Wall_" + data.getNumWalls(), jsonWall);
            setResult(Activity.RESULT_OK, intent);
            this.finish();
        }
    }

    private static class ViewHolder {
        EditText add_wall_altura;
        EditText add_wall_largura;
        EditText add_wall_portas;
        EditText add_wall_janelas;

        Button button_add_wall;
        Button button_back;
    }
}