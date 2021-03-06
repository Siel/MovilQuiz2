package com.dev.siel.movilquiz2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends Activity {

    String preguntas[];
    boolean respuestas[]={false,true,true,false,true,true,false,true,true,false,false,true,false,false,true};
    int indice=0;
    int selecciones[];
    int puntaje=0;
    TextView quizText;
    TextView scoreValue;
    Button trueButton;
    Button falseButton;
    Button nextButton;
    Button restartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preguntas= new String[15];
        preguntas[0]=getString(R.string.pregunta1);
        preguntas[1]=getString(R.string.pregunta2);
        preguntas[2]=getString(R.string.pregunta3);
        preguntas[3]=getString(R.string.pregunta4);
        preguntas[4]=getString(R.string.pregunta5);
        preguntas[5]=getString(R.string.pregunta6);
        preguntas[6]=getString(R.string.pregunta7);
        preguntas[7]=getString(R.string.pregunta8);
        preguntas[8]=getString(R.string.pregunta9);
        preguntas[9]=getString(R.string.pregunta10);
        preguntas[10]=getString(R.string.pregunta11);
        preguntas[11]=getString(R.string.pregunta12);
        preguntas[12]=getString(R.string.pregunta13);
        preguntas[13]=getString(R.string.pregunta14);
        preguntas[14]=getString(R.string.pregunta15);
        selecciones = new int[10];
        Random rand = new Random();
        int visited[] = new int[15];
        int randomNum;
        for (int i = 0; i<10;i++){
            do {
                randomNum = rand.nextInt(15);
            }while(visited[randomNum]==1);
            visited[randomNum]=1;
            selecciones[i]=randomNum;
        }
        quizText=(TextView) findViewById(R.id.QuizText);
        scoreValue=(TextView) findViewById((R.id.scoreValue));
        quizText.setText(preguntas[selecciones[indice]]);
        scoreValue.setText(""+puntaje);
        trueButton = (Button)findViewById(R.id.button);
        falseButton = (Button)findViewById(R.id.button2);
        nextButton = (Button)findViewById(R.id.button3);
        restartButton = (Button)findViewById(R.id.button4);
    }
    public void trueClick(View v){
        if(indice<9){
            if(respuestas[selecciones[indice]]==true)
                puntaje++;
            indice++;
            quizText.setText(preguntas[selecciones[indice]]);
            scoreValue.setText(""+puntaje);
        }else{
            trueButton.setVisibility(Button.INVISIBLE);
            falseButton.setVisibility(Button.INVISIBLE);
            nextButton.setVisibility(Button.INVISIBLE);
            quizText.setVisibility(TextView.INVISIBLE);
            restartButton.setVisibility(TextView.VISIBLE);
            if(respuestas[selecciones[indice]]==false)
                puntaje++;
            scoreValue.setText(""+puntaje);
        }

    }
    public void falseClick(View v){
        if(indice<9){
            if(respuestas[selecciones[indice]]==false)
                puntaje++;
            indice++;
            quizText.setText(preguntas[selecciones[indice]]);
            scoreValue.setText(""+puntaje);
        }else{
            trueButton.setVisibility(Button.INVISIBLE);
            falseButton.setVisibility(Button.INVISIBLE);
            nextButton.setVisibility(Button.INVISIBLE);
            quizText.setVisibility(TextView.INVISIBLE);
            restartButton.setVisibility(TextView.VISIBLE);
            if(respuestas[selecciones[indice]]==false)
                puntaje++;
            scoreValue.setText(""+puntaje);
        }
    }
    public void nextClick(View v){
        if(indice<9){
            indice++;
            quizText.setText(preguntas[selecciones[indice]]);
            scoreValue.setText(""+puntaje);
        }else{
            trueButton.setVisibility(Button.INVISIBLE);
            falseButton.setVisibility(Button.INVISIBLE);
            nextButton.setVisibility(Button.INVISIBLE);
            quizText.setVisibility(TextView.INVISIBLE);
            restartButton.setVisibility(TextView.VISIBLE);
            }
    }
    public void restartClick(View v){
        trueButton.setVisibility(Button.VISIBLE);
        falseButton.setVisibility(Button.VISIBLE);
        nextButton.setVisibility(Button.VISIBLE);
        quizText.setVisibility(TextView.VISIBLE);
        restartButton.setVisibility(TextView.INVISIBLE);
        Random rand = new Random();
        int visited[] = new int[15];
        int randomNum;
        for (int i = 0; i<10;i++){
            do {
                randomNum = rand.nextInt(15);
            }while(visited[randomNum]==1);
            visited[randomNum]=1;
            selecciones[i]=randomNum;
        }
        indice=0;
        puntaje=0;
        scoreValue.setText(""+puntaje);
        quizText.setText(preguntas[selecciones[indice]]);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
