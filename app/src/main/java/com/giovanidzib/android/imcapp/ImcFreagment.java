package com.giovanidzib.android.imcapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by alumno on 23/02/18.
 */

public class ImcFreagment extends Fragment {
    EditText mCampoPeso;
    EditText mCampoEstatura;
    Button mBotoncalcular;
    Button mBotonLimpiar;
    TextView mEtiquetaImc;
    TextView mSituaciònNutricional;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mCampoPeso =(EditText) getView().findViewById(R.id.campo_peso);
        mCampoEstatura=(EditText) getView().findViewById(R.id.campo_estatura);
        mBotoncalcular=(Button) getView().findViewById(R.id.boton_calcular);
        mBotonLimpiar=(Button)getView().findViewById(R.id.boton_limpiar);
        mEtiquetaImc=(TextView) getView().findViewById(R.id.etiqueta_imc);
        mSituaciònNutricional=
                (TextView) getView().findViewById(R.id.etiqueta_situacion);

        mBotoncalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view ){
                String s =mCampoPeso.getText().toString();
                double peso =Double.parseDouble(s);
                s=mCampoEstatura.getText().toString();
                double estatura =Double.parseDouble(s);
                double imc=peso/(estatura * estatura);
                s=String.format("%2.2f",imc);
                mEtiquetaImc.setText(s);
                if(imc < 18.5){
                    mSituaciònNutricional.setText(
                            R.string.texto_situacion_peso_bajo
                            );
                }else if(imc<25.0){
                    mSituaciònNutricional.setText(
                            R.string.texto_situacion_peso_normal);
                }else if(imc<30.0){
                    mSituaciònNutricional.setText(
                            R.string.texto_situacion_sobrepeso);
                }else if(imc<40.0){
                    mSituaciònNutricional.setText(
                            R.string.texto_situacion_obesidad);
                }else{
                    mSituaciònNutricional.setText(
                            R.string.texto_situacion_obesidad_extrema
                    );
                }
            }
        });

        mBotonLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCampoPeso.setText("");
                mCampoEstatura.setText("");
                mEtiquetaImc.setText("0.0");
                mSituaciònNutricional.setText("");

            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_imc,container,false);
        return  v;


}
}


