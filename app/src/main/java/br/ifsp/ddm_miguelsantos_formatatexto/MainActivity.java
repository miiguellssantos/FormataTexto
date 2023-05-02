package br.ifsp.ddm_miguelsantos_formatatexto;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView lblTexto1;
    private TextView lblTexto2;
    private EditText txtTexto1;
    private Button btnGravaTxt1;
    private EditText txtTexto2;
    private Button btnGravaTxt2;
    private RadioGroup radioGroup;
    private RadioButton rad1;
    private RadioButton rad2;
    private EditText txtTam;
    private Button btnGravaTam;
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
        txtTam = findViewById(R.id.txtTam);
        btnGravaTxt1 = findViewById(R.id.btnGravaTxt1);
        btnGravaTxt2 = findViewById(R.id.btnGravaTxt2);
        btnGravaTam = findViewById(R.id.btnGravaTam);
        btnRed = findViewById(R.id.btnRed);
        btnBlue = findViewById(R.id.btnBlue);
        btnGreen = findViewById(R.id.btnGreen);
        radioGroup = findViewById(R.id.radioGroup);
        rad1 = findViewById(R.id.rad1);
        rad2 = findViewById(R.id.rad2);
        chkBold = findViewById(R.id.chkBold);
        chkItalic = findViewById(R.id.chkItalic);

        btnGravaTxt1.setOnClickListener(new EscutadorBtnGravaTxt1());
        btnGravaTxt2.setOnClickListener(new EscutadorBtnGravaTxt2());

        radioGroup.setOnCheckedChangeListener(new EscutadorRadioGroup());

        EscutadorTamanho etam = new EscutadorTamanho();
        btnGravaTam.setOnClickListener(etam);

        EscutadorCorRed ered = new EscutadorCorRed();
        EscutadorCorBlue eblue = new EscutadorCorBlue();
        EscutadorCorGreen egreen = new EscutadorCorGreen();

        btnRed.setOnClickListener(ered);
        btnBlue.setOnClickListener(eblue);
        btnGreen.setOnClickListener(egreen);

        EscutadorCheckBox echk = new EscutadorCheckBox();
        chkBold.setOnClickListener(echk);
        chkItalic.setOnClickListener(echk);
    }

    private class EscutadorBtnGravaTxt1 implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            String texto = txtTexto1.getText().toString();
            lblTexto1.setText(texto);
        }
    }

    private class EscutadorBtnGravaTxt2 implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            String texto = txtTexto2.getText().toString();
            lblTexto2.setText(texto);
        }
    }

    private class EscutadorRadioGroup implements RadioGroup.OnCheckedChangeListener{
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            String msg = "";

            switch (checkedId){
                case R.id.rad1:
                    msg = "Texto 1 selecionado";
                    break;
                case R.id.rad2:
                    msg = "Texto 2 selecionado";
                    break;
            }
            Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
        }
    }

    private class EscutadorTamanho implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            int radioSelecionado = radioGroup.getCheckedRadioButtonId();
            if (radioSelecionado == -1){
                Toast.makeText(MainActivity.this, "Nenhum texto selecionado!", Toast.LENGTH_SHORT).show();
            }else{
                switch (radioSelecionado) {
                    case R.id.rad1:
                        float tamanho = Float.parseFloat(txtTam.toString());
                        lblTexto1.setTextSize(tamanho);
                        break;
                    case R.id.rad2:
                        tamanho = Float.parseFloat(txtTam.toString());
                        lblTexto2.setTextSize(tamanho);
                        break;
                }
            }
        }
    }

    private class EscutadorCorRed implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            int radioSelecionado = radioGroup.getCheckedRadioButtonId();
            if (radioSelecionado == -1){
                Toast.makeText(MainActivity.this, "Nenhum texto selecionado!", Toast.LENGTH_SHORT).show();
            }else{
                switch (radioSelecionado) {
                    case R.id.rad1:
                        lblTexto1.setTextColor(Color.RED);
                        break;
                    case R.id.rad2:
                        lblTexto2.setTextColor(Color.RED);
                        break;
                }
            }
        }
    }

    private class EscutadorCorBlue implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            int radioSelecionado = radioGroup.getCheckedRadioButtonId();
            if (radioSelecionado == -1){
                Toast.makeText(MainActivity.this, "Nenhum texto selecionado!", Toast.LENGTH_SHORT).show();
            }else{
                switch (radioSelecionado) {
                    case R.id.rad1:
                        lblTexto1.setTextColor(Color.BLUE);
                        break;
                    case R.id.rad2:
                        lblTexto2.setTextColor(Color.BLUE);
                        break;
                }
            }
        }
    }

    private class EscutadorCorGreen implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            int radioSelecionado = radioGroup.getCheckedRadioButtonId();
            if (radioSelecionado == -1){
                Toast.makeText(MainActivity.this, "Nenhum texto selecionado!", Toast.LENGTH_SHORT).show();
            }else{
                switch (radioSelecionado) {
                    case R.id.rad1:
                        lblTexto1.setTextColor(Color.GREEN);
                        break;
                    case R.id.rad2:
                        lblTexto2.setTextColor(Color.GREEN);
                        break;
                }
            }
        }
    }

    private class EscutadorCheckBox implements View.OnClickListener{
        @SuppressLint("NonConstantResourceId")
        @Override
        public void onClick(View v) {
            int radioSelecionado = radioGroup.getCheckedRadioButtonId();
            CheckBox chk = (CheckBox) v;
            switch(chk.getId()) {
                case R.id.chkBold:
                    if (chkBold.isChecked()){
                        switch (radioSelecionado) {
                            case R.id.rad1:
                                int estilo = Typeface.BOLD;
                                lblTexto1.setTypeface(null, estilo);
                                break;
                            case R.id.rad2:
                                lblTexto2.setTypeface(null, Typeface.BOLD);
                                break;
                        }
                    }else{
                        switch (radioSelecionado) {
                            case R.id.rad1:
                                lblTexto1.setTypeface(null, Typeface.NORMAL);
                                break;
                            case R.id.rad2:
                                lblTexto2.setTypeface(null, Typeface.NORMAL);
                                break;
                        }
                    }
                    break;
                case R.id.chkItalic:
                    if (chkItalic.isChecked()){
                        switch (radioSelecionado) {
                            case R.id.rad1:
                                lblTexto1.setTypeface(null, Typeface.ITALIC);
                                break;
                            case R.id.rad2:
                                lblTexto2.setTypeface(null, Typeface.ITALIC);
                                break;
                        }
                    }else{
                        switch (radioSelecionado) {
                            case R.id.rad1:
                                lblTexto1.setTypeface(null, Typeface.NORMAL);
                                break;
                            case R.id.rad2:
                                lblTexto2.setTypeface(null, Typeface.NORMAL);
                                break;
                        }
                    }
                    break;
            }
        }
    }
}