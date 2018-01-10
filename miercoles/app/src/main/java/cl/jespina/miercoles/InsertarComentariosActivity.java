package cl.jespina.miercoles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import cz.msebera.android.httpclient.Header;

public class InsertarComentariosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_comentarios);
    }

    public void btnInsertaComentarioClick(View view) {
        TextView txtNombre = findViewById(R.id.txtNombre);
        TextView txtComentario = findViewById(R.id.txtComentario);
        insertaComentario (txtNombre.getText().toString(), txtComentario.getText().toString());
    }

    public void insertaComentario (String nombre, String comentario) {
        AsyncHttpClient clienteAsincrono = new AsyncHttpClient();
        String url = "http://rapidfresh.todojava.net/index.php/insertComments";
        RequestParams params = new RequestParams();
        params.put("name", nombre);
        params.put("comment", comentario);
        clienteAsincrono.post(url, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode==200) {
                    String respuesta = new String(responseBody);
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }
}
