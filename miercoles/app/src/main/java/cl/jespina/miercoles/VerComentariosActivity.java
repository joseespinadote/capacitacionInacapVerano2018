package cl.jespina.miercoles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;

import java.util.ArrayList;

import adaptador.AdaptadorComentarios;
import cz.msebera.android.httpclient.Header;
import modelo.Comentario;

public class VerComentariosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_comentarios);
        leeComentarios();
    }

    public void leeComentarios() {
        AsyncHttpClient clienteAsincrono = new AsyncHttpClient();
        String url = "http://rapidfresh.todojava.net/index.php/comments";
        clienteAsincrono.post(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode==200) {
                    String respuesta = new String(responseBody);
                    Log.i("JOSE", respuesta);
                    procesaRespuestaHTTP(respuesta);
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

    private void procesaRespuestaHTTP(String respuesta) {
        JSONArray json;
        ArrayList<Comentario> arrComentarios = new ArrayList<>();
        try {
            json = new JSONArray(respuesta);
            for(int i = 0; i < json.length(); i++) {
                arrComentarios.add(
                        new Comentario(
                                json.getJSONObject(i).getString("name"),
                                json.getJSONObject(i).getString("comment")
                        )
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        AdaptadorComentarios adaptador = new AdaptadorComentarios(arrComentarios);
        RecyclerView recycler = findViewById(R.id.recyclerComentarios);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(llm);
        recycler.setAdapter(adaptador);
    }
}
