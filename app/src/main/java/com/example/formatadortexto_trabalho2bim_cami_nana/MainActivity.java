package com.example.formatadortexto_trabalho2bim_cami_nana;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
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

    private int radioSelecionado = 0;

    private EditText txtTam;
    private Button btnTam;

    private Button btnRed;
    private Button btnBlue;
    private Button btnGreen;

    private CheckBox chkBold;
    private CheckBox chkItalic;

    private int estilo = 0;
    boolean bold = false;
    boolean italic = false;


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

            EscutadorBotoesTextos ebt = new EscutadorBotoesTextos();
            btnTxt1.setOnClickListener(ebt);
            btnTxt2.setOnClickListener(ebt);

            EscutadorRadioGroup ebr = new EscutadorRadioGroup();
            radioGroup.setOnCheckedChangeListener(ebr);

            EscutadorBotaoTamanho ebs = new EscutadorBotaoTamanho();
            btnTam.setOnClickListener(ebs);

            EscutadorBotoesCores ebc = new EscutadorBotoesCores();
            btnRed.setOnClickListener(ebc);
            btnBlue.setOnClickListener(ebc);
            btnGreen.setOnClickListener(ebc);

            EscutadorBotaoEstilo ebe = new EscutadorBotaoEstilo();
            chkBold.setOnClickListener(ebe);
            chkItalic.setOnClickListener(ebe);
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

    public class EscutadorRadioGroup implements RadioGroup.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            switch (i) {
                case R.id.radTxt1:
                    radioSelecionado = 1;
                    break;
                case R.id.radTxt2:
                    radioSelecionado = 2;
                    break;
            }
        }
    }

    public class EscutadorBotaoTamanho implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            float tamanho = Float.parseFloat( txtTam.getText().toString() );
            if(radioSelecionado == 1){
                lblTexto1.setTextSize(tamanho);
            }else if(radioSelecionado == 2){
                lblTexto2.setTextSize(tamanho);
            }
        }
    }

    public class EscutadorBotoesCores implements View.OnClickListener{

        @Override
        public void onClick(View view){

            Button b = (Button) view;
            int cor = 0;

            switch(b.getId()){
                case R.id.btnRed:
                    cor = Color.RED;
                    if(radioSelecionado == 1){
                        lblTexto1.setTextColor(cor);
                    }else if(radioSelecionado == 2){
                        lblTexto2.setTextColor(cor);
                    }
                    break;
                case R.id.btnBlue:
                    cor = Color.BLUE;
                    if(radioSelecionado == 1){
                        lblTexto1.setTextColor(cor);
                    }else if(radioSelecionado == 2){
                        lblTexto2.setTextColor(cor);
                    }
                    break;
                case R.id.btnGreen:
                    cor = Color.GREEN;
                    if(radioSelecionado == 1){
                        lblTexto1.setTextColor(cor);
                    }else if(radioSelecionado == 2){
                        lblTexto2.setTextColor(cor);
                    }
                    break;

            }

        }

    }

    private class EscutadorBotaoEstilo implements View.OnClickListener{
        @Override
        public void onClick(View view){
            CheckBox chk = (CheckBox) view;

            switch (chk.getId()){
                case R.id.chkBold:
                    if(chkBold.isChecked()) {
                        bold = true;
                    } else {
                        bold = false;
                    }
                    break;
                case R.id.chkItalic:
                    if(chkItalic.isChecked()) {
                        italic = true;
                    } else {
                        italic = false;
                    }
                    break;

            }

            if(bold && italic) {
                estilo = Typeface.BOLD_ITALIC;
            } else if(bold) {
                estilo = Typeface.BOLD;
            } else if(italic) {
                estilo = Typeface.ITALIC;
            } else {
                estilo = Typeface.NORMAL;
            }

            if(radioSelecionado == 1){
                lblTexto1.setTypeface(null, estilo);
            } else if(radioSelecionado == 2){
                lblTexto2.setTypeface(null, estilo);
            }
        }
    }

}