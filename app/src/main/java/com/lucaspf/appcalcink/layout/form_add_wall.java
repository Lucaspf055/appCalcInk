package com.lucaspf.appcalcink.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.lucaspf.appcalcink.R;

public class form_add_wall extends AppCompatActivity {
    ViewHolder mViewHolder = new ViewHolder();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_add_wall);

        this.mViewHolder.add_wall_altura = findViewById(R.id.add_wall_altura);
        this.mViewHolder.add_wall_largura = findViewById(R.id.add_wall_largura);
        this.mViewHolder.add_wall_portas = findViewById(R.id.add_wall_portas);
        this.mViewHolder.add_wall_janelas = findViewById(R.id.add_wall_janelas);
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