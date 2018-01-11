package cl.jespina.jueves;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txt;
    private static final int CHUNK = 1000000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = findViewById(R.id.txtTexto01);
    }

    public void btnWorkClick(View view) {
        Tarea tarea = new Tarea();
        tarea.execute(CHUNK);
    }

    class Tarea extends AsyncTask<Integer, String, Void> {

        @Override
        protected Void doInBackground(Integer... values) {
            int chunk = values[0];
            for (int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; i++) {
                if(i%chunk==0)
                    publishProgress(String.valueOf(i/chunk) + " / 10^" + String.valueOf(String.valueOf(chunk).length()-1));
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            txt.setText(values[0]);
            super.onProgressUpdate(values);
        }
    }
}
