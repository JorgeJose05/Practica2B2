package com.example.practica2b;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    boolean turno;
    int varpuntosactuales;
    int Sumpuntosactuales=0;
    int puntostotales=0;
    TextView j1pt;
    TextView j2pt;
    TextView j1pa;
    TextView j2pa;
ImageView dado;
    Button lanzar;
    Button sostener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        turno = true;// no se si puedo inicializarlo arriba
        lanzar = findViewById(R.id.lanzar);
        sostener = findViewById(R.id.sostener);

        j1pa = findViewById(R.id.j1pa);
        j1pt = findViewById(R.id.j1pt);

        j2pa = findViewById(R.id.j2pa);
        j2pt = findViewById(R.id.j2pt);

        dado = findViewById(R.id.dado);

        lanzar.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if (turno== true){
                    //aqui para jugador 1 en el otro para el 2
                    varpuntosactuales =(int)  ((Math.random()*(6-1))+1);
                    if (varpuntosactuales != 1){
                        Sumpuntosactuales += varpuntosactuales;

                        j1pa.setText("Puntos actuales\n" + Sumpuntosactuales);


                        dado.setBackgroundColor(111);
                    }else{
                        dado.setBackgroundColor(999);
                        j1pa.setText("Puntos actuales\n" + 0);
                        turno = false;
                        varpuntosactuales =0;
                        Sumpuntosactuales =0;
                    }




                }else{
                    //aqui para jugador 1 en el otro para el 2

                    varpuntosactuales =(int)  ((Math.random()*(6-1))+1);
                    if (varpuntosactuales != 1){
                        Sumpuntosactuales += varpuntosactuales;

                        j2pa.setText("Puntos actuales\n" + Sumpuntosactuales);



                    }else{
                        j2pa.setText("Puntos actuales\n" + 0);
                        turno = true;
                        varpuntosactuales =0;
                        Sumpuntosactuales =0;
                    }



                }
            }
        });


        sostener.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if (turno){
                    //aqui para jugador 1 en el otro para el 2
                        puntostotales +=Sumpuntosactuales;
                        j1pt.setText("Puntos totales\n" + puntostotales);

                        turno = false;
                        varpuntosactuales =0;
                        Sumpuntosactuales =0;


                }else{
                    //aqui para jugador 1 en el otro para el 2

                    puntostotales +=Sumpuntosactuales;
                    j2pt.setText("Puntos totales\n" + puntostotales);

                    turno = true;
                    varpuntosactuales =0;
                    Sumpuntosactuales =0;

                }
            }
        });





    }
}