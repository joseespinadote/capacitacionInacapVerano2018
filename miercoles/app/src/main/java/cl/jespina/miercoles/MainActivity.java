package cl.jespina.miercoles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.client.HttpClient;
import modelo.Comentario;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnVerComentariosClick(View view) {
        Intent i = new Intent(this, VerComentariosActivity.class);
        startActivity(i);
    }

    public void btnInsertarComentarioClick(View view) {
        Intent i = new Intent(this, InsertarComentariosActivity.class);
        startActivity(i);
    }
}
