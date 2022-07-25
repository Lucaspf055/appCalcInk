package com.lucaspf.appcalcink.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Rating;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lucaspf.appcalcink.R;
import com.lucaspf.appcalcink.data.Data;
import com.lucaspf.appcalcink.model.Wall;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewHolder mViewHolder = new ViewHolder();
    private Data mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mData = new Data(this);

        mData.setNumWall("0");


        // Buttons
        this.mViewHolder.button_add = findViewById(R.id.button_add);
        this.mViewHolder.button_calc = findViewById(R.id.button_calc);

        // Layouts
        this.mViewHolder.layout_empty = findViewById(R.id.layout_empty);
        this.mViewHolder.layout_room = findViewById(R.id.layout_room);

        // Parede 1
        this.mViewHolder.layout_wall1 = findViewById(R.id.layout_wall1);
        this.mViewHolder.wall1_altura = findViewById(R.id.wall1_altura);
        this.mViewHolder.wall1_largura = findViewById(R.id.wall1_largura);
        this.mViewHolder.wall1_janelas = findViewById(R.id.wall1_janelas);
        this.mViewHolder.wall1_portas = findViewById(R.id.wall1_portas);
        this.mViewHolder.wall1_header = findViewById(R.id.wall1_header);
        this.mViewHolder.wall1_info = findViewById(R.id.wall1_info);

        // Parede 2
        this.mViewHolder.layout_wall2 = findViewById(R.id.layout_wall2);
        this.mViewHolder.wall2_altura = findViewById(R.id.wall2_altura);
        this.mViewHolder.wall2_largura = findViewById(R.id.wall2_largura);
        this.mViewHolder.wall2_janelas = findViewById(R.id.wall2_janelas);
        this.mViewHolder.wall2_portas = findViewById(R.id.wall2_portas);
        this.mViewHolder.wall2_header = findViewById(R.id.wall2_header);
        this.mViewHolder.wall2_info = findViewById(R.id.wall2_info);

        // Parede 3
        this.mViewHolder.layout_wall3 = findViewById(R.id.layout_wall3);
        this.mViewHolder.wall3_altura = findViewById(R.id.wall3_altura);
        this.mViewHolder.wall3_largura = findViewById(R.id.wall3_largura);
        this.mViewHolder.wall3_janelas = findViewById(R.id.wall3_janelas);
        this.mViewHolder.wall3_portas = findViewById(R.id.wall3_portas);
        this.mViewHolder.wall3_header = findViewById(R.id.wall3_header);
        this.mViewHolder.wall3_info = findViewById(R.id.wall3_info);

        // Parede 4
        this.mViewHolder.layout_wall4 = findViewById(R.id.layout_wall4);
        this.mViewHolder.wall4_altura = findViewById(R.id.wall4_altura);
        this.mViewHolder.wall4_largura = findViewById(R.id.wall4_largura);
        this.mViewHolder.wall4_janelas = findViewById(R.id.wall4_janelas);
        this.mViewHolder.wall4_portas = findViewById(R.id.wall4_portas);
        this.mViewHolder.wall4_header = findViewById(R.id.wall4_header);
        this.mViewHolder.wall4_info = findViewById(R.id.wall4_info);


        this.mViewHolder.button_add.setOnClickListener(this);
        this.mViewHolder.button_calc.setOnClickListener(this);
        this.mViewHolder.wall1_header.setOnClickListener(this);
        this.mViewHolder.wall2_header.setOnClickListener(this);
        this.mViewHolder.wall3_header.setOnClickListener(this);
        this.mViewHolder.wall4_header.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_add) {
            Intent intent = new Intent(this, form_add_wall.class);
            startActivityForResult(intent, 37);
        } else if (v.getId() == R.id.wall1_header) {
            hideInfo();
            showInfo(1);
        } else if (v.getId() == R.id.wall2_header) {
            hideInfo();
            showInfo(2);
        } else if (v.getId() == R.id.wall3_header) {
            hideInfo();
            showInfo(3);
        } else if (v.getId() == R.id.wall4_header) {
            hideInfo();
            showInfo(4);
        } else if (v.getId() == R.id.button_calc) {
            Toast.makeText(this, "lalala", Toast.LENGTH_SHORT).show();
        }


    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        this.mViewHolder.layout_empty.setVisibility(View.GONE);
        this.mViewHolder.layout_room.setVisibility(View.VISIBLE);

        if (requestCode == 37) {
            if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Ação cancelada", Toast.LENGTH_SHORT).show();
            } else if (resultCode == RESULT_OK) {
                Gson gson = new Gson();

                if (this.mData.getNumWalls().equals("0")) {
                    String jsonWall = this.mData.getStoredString("Wall_0");

                    Wall wall = gson.fromJson(jsonWall, Wall.class);

                    Double altura = wall.getAltura();
                    Double largura = wall.getLargura();
                    int porta = wall.getPortas();
                    int janelas = wall.getJanelas();

                    this.mViewHolder.wall1_janelas.setText(String.valueOf(wall.getJanelas()));
                    this.mViewHolder.wall1_portas.setText(String.valueOf(wall.getPortas()));
                    this.mViewHolder.wall1_largura.setText(String.format("%.2f", wall.getLargura()));
                    this.mViewHolder.wall1_altura.setText(String.format("%.2f", wall.getAltura()));


                    this.mViewHolder.layout_wall1.setVisibility(View.VISIBLE);

                    this.mData.setNumWall("1");
                } else if (this.mData.getNumWalls().equals("1")) {
                    String jsonWall = this.mData.getStoredString("Wall_1");

                    Wall wall = gson.fromJson(jsonWall, Wall.class);

                    Double altura = wall.getAltura();
                    Double largura = wall.getLargura();
                    int porta = wall.getPortas();
                    int janelas = wall.getJanelas();

                    this.mViewHolder.wall2_janelas.setText(String.valueOf(wall.getJanelas()));
                    this.mViewHolder.wall2_portas.setText(String.valueOf(wall.getPortas()));
                    this.mViewHolder.wall2_largura.setText(String.format("%.2f", wall.getLargura()));
                    this.mViewHolder.wall2_altura.setText(String.format("%.2f", wall.getAltura()));


                    this.mViewHolder.layout_wall2.setVisibility(View.VISIBLE);
                    this.mData.setNumWall("2");
                } else if (this.mData.getNumWalls().equals("2")) {
                    String jsonWall = this.mData.getStoredString("Wall_2");

                    Wall wall = gson.fromJson(jsonWall, Wall.class);

                    Double altura = wall.getAltura();
                    Double largura = wall.getLargura();
                    int porta = wall.getPortas();
                    int janelas = wall.getJanelas();

                    this.mViewHolder.wall3_janelas.setText(String.valueOf(wall.getJanelas()));
                    this.mViewHolder.wall3_portas.setText(String.valueOf(wall.getPortas()));
                    this.mViewHolder.wall3_largura.setText(String.format("%.2f", wall.getLargura()));
                    this.mViewHolder.wall3_altura.setText(String.format("%.2f", wall.getAltura()));


                    this.mViewHolder.layout_wall3.setVisibility(View.VISIBLE);
                    this.mData.setNumWall("3");
                } else if (this.mData.getNumWalls().equals("3")) {
                    String jsonWall = this.mData.getStoredString("Wall_3");

                    Wall wall = gson.fromJson(jsonWall, Wall.class);

                    Double altura = wall.getAltura();
                    Double largura = wall.getLargura();
                    int porta = wall.getPortas();
                    int janelas = wall.getJanelas();

                    this.mViewHolder.wall4_janelas.setText(String.valueOf(wall.getJanelas()));
                    this.mViewHolder.wall4_portas.setText(String.valueOf(wall.getPortas()));
                    this.mViewHolder.wall4_largura.setText(String.format("%.2f", wall.getLargura()));
                    this.mViewHolder.wall4_altura.setText(String.format("%.2f", wall.getAltura()));


                    this.mViewHolder.layout_wall4.setVisibility(View.VISIBLE);
                    this.mViewHolder.button_add.setVisibility(View.GONE);
                    this.mViewHolder.button_calc.setVisibility(View.VISIBLE);

                    this.mData.setNumWall("4");
                }

                Toast.makeText(this, "Parede adicionada", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void showInfo(int number) {
        if (number == 1)
            this.mViewHolder.wall1_info.setVisibility(View.VISIBLE);
        else if (number == 2)
            this.mViewHolder.wall2_info.setVisibility(View.VISIBLE);
        else if (number == 3)
            this.mViewHolder.wall3_info.setVisibility(View.VISIBLE);
        else this.mViewHolder.wall4_info.setVisibility(View.VISIBLE);
    }

    public Double calculaTintaNecessaria() {
        Gson gson = new Gson();

        String jsonWall1 = this.mData.getStoredString("Wall_1");
        String jsonWall2 = this.mData.getStoredString("Wall_2");
        String jsonWall3 = this.mData.getStoredString("Wall_3");
        String jsonWall4 = this.mData.getStoredString("Wall_4");

        Wall parede1 = gson.fromJson(jsonWall1, Wall.class);
        Wall parede2 = gson.fromJson(jsonWall2, Wall.class);
        Wall parede3 = gson.fromJson(jsonWall3, Wall.class);
        Wall parede4 = gson.fromJson(jsonWall4, Wall.class);

        Double area_parede_1 = parede1.getAltura() * parede1.getLargura();
        Double area_parede_2 = parede1.getAltura() * parede2.getLargura();
        Double area_parede_3 = parede1.getAltura() * parede3.getLargura();
        Double area_parede_4 = parede1.getAltura() * parede4.getLargura();

        Double areaTotal = area_parede_1 + area_parede_2 + area_parede_3 + area_parede_4;
        Double tintaN = areaTotal / 5;

        Double[] latas = {18.00, 3.60, 2.50, 0.50};
        Integer[] latasN = {0, 0, 0, 0};
        Integer i = 0;

        while (i <= 3) {
            if (tintaN >= latas[i]) {
                tintaN = tintaN - latas[i];
                latasN[i]++;
            } else i++;
        }
        while (tintaN >= 0.01) {
            tintaN = tintaN - latas[3];
            latasN[3]++;
        }
        return 0.00;
    }

    public void hideInfo() {
        this.mViewHolder.wall1_info.setVisibility(View.GONE);
        this.mViewHolder.wall2_info.setVisibility(View.GONE);
        this.mViewHolder.wall3_info.setVisibility(View.GONE);
        this.mViewHolder.wall4_info.setVisibility(View.GONE);
    }


    public static class ViewHolder {
        // botoes
        Button button_add;
        Button button_calc;

        //empyt
        RelativeLayout layout_empty;

        //Room
        RelativeLayout layout_room;

        //parede 1
        RelativeLayout layout_wall1;
        RelativeLayout wall1_header;
        RelativeLayout wall1_info;
        TextView wall1_portas;
        TextView wall1_janelas;
        TextView wall1_altura;
        TextView wall1_largura;

        //parede 2
        RelativeLayout layout_wall2;
        RelativeLayout wall2_header;
        RelativeLayout wall2_info;
        TextView wall2_portas;
        TextView wall2_janelas;
        TextView wall2_altura;
        TextView wall2_largura;

        //parede 3
        RelativeLayout layout_wall3;
        RelativeLayout wall3_header;
        RelativeLayout wall3_info;
        TextView wall3_portas;
        TextView wall3_janelas;
        TextView wall3_altura;
        TextView wall3_largura;

        //parede 4
        RelativeLayout layout_wall4;
        RelativeLayout wall4_header;
        RelativeLayout wall4_info;
        TextView wall4_portas;
        TextView wall4_janelas;
        TextView wall4_altura;
        TextView wall4_largura;
    }
}