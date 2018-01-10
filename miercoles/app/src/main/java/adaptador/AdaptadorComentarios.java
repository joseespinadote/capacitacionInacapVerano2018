package adaptador;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import cl.jespina.miercoles.R;
import modelo.Comentario;

public class AdaptadorComentarios extends RecyclerView.Adapter<AdaptadorComentarios.ViewHolder> {
    private ArrayList<Comentario> comentarios;

    public AdaptadorComentarios(ArrayList<Comentario> _comentarios)
    {
        comentarios = _comentarios;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.comentario_fila, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.getTextViewAutor().setText(comentarios.get(position).getNombre());
        holder.getTextViewComentario().setText(comentarios.get(position).getTexto());
    }

    @Override
    public int getItemCount() {
        return comentarios.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewComentario;
        private final TextView textViewAutor;

        public ViewHolder(View v) {
            super(v);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.i("JOSE", "se clickeó el elemento " + getAdapterPosition());
                }
            });
            textViewComentario = v.findViewById(R.id.txtComentarioItem);
            textViewAutor = v.findViewById(R.id.txtAutorItem);
        }

        public TextView getTextViewComentario() {
            return textViewComentario;
        }
        public TextView getTextViewAutor() {
            return textViewAutor;
        }
    }
}
