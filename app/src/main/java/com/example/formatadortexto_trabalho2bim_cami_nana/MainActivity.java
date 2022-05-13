package com.example.formatadortexto_trabalho2bim_cami_nana;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Dupla: Camila Devita Basaglia & Nana de Souza Ekman Simões

    //atributos

    private TextView lblTexto1;
    private TextView lblTexto2;

    private EditText txtTexto1;
    private EditText txtTexto2;

    private Button btnTxt1;
    private Button btnTxt2;

    private RadioGroup radioGroup;
    private RadioButton radTxt1;
    private RadioButton radTxt2;

    private EditText txtTam;
    private Button btnTam;

    private Button btnRed;
    private Button btnBlue;
    private Button btnGreen;

    private CheckBox chkBold;
    private CheckBox chkItalic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            lblTexto1 = findViewById(R.id.lblTexto1);
            lblTexto2 = findViewById(R.id.lblTexto2);

            txtTexto1 = findViewById(R.id.txtTexto1);
            txtTexto2 = findViewById(R.id.txtTexto2);

            btnTxt1 = findViewById(R.id.btnTxt1);
            btnTxt2 = findViewById(R.id.btnTxt2);

            radioGroup = findViewById(R.id.radioGroup);
            radTxt1 = findViewById(R.id.radTxt1);
            radTxt2 = findViewById(R.id.radTxt2);

            txtTam = findViewById(R.id.txtTam);
            btnTam = findViewById(R.id.btnTam);

            btnRed = findViewById(R.id.btnRed);
            btnBlue = findViewById(R.id.btnBlue);
            btnGreen = findViewById(R.id.btnGreen);

            chkBold = findViewById(R.id.chkBold);
            chkItalic = findViewById(R.id.chkItalic);
    }

    public class EscutadorBotoesTextos implements View.OnClickListener {

        @Override
        public void onClick(View view) {

            Button b = (Button) view;

            switch (b.getId()){

                case R.id.btnTxt1:
                    String texto1 = txtTexto1.getText().toString();
                    lblTexto1.setText(texto1);
                    break;

                case R.id.btnTxt2:
                    String texto2 = txtTexto2.getText().toString();
                    lblTexto2.setText(texto2);
                    break;
            }
        }
    }

}