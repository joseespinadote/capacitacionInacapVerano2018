package cl.jespina.juevessqlite.adaptador;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import cl.jespina.juevessqlite.R;
import cl.jespina.juevessqlite.modelo.POJOMascota;

public class AdaptadorMascotas extends RecyclerView.Adapter<AdaptadorMascotas.MascotaViewHolder>{
    private ArrayList<POJOMascota> lista;
    private int resource;
    private Activity activity;

    public AdaptadorMascotas(ArrayList<POJOMascota> lista, int resource, Activity activity) {
        this.lista = lista;
        this.resource = resource;
        this.activity = activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
       return new MascotaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder holder, int position) {
        POJOMascota pm = lista.get(position);
        holder.txtItemMascotaId.setText(String.valueOf(pm.getId()));
        holder.txtItemMascotaNombre.setText(pm.getNombre());
        holder.txtItemMascotaGenero.setText(pm.getGenero());
        holder.txtItemMascotaPeso.setText(String.valueOf(pm.getPeso()));
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class MascotaViewHolder extends RecyclerView.ViewHolder {
        private TextView txtItemMascotaId, txtItemMascotaNombre, txtItemMascotaPeso,
            txtItemMascotaGenero;
        public MascotaViewHolder(View itemView) {
            super(itemView);
            txtItemMascotaId = itemView.findViewById(R.id.txtItemMascotaId);
            txtItemMascotaNombre = itemView.findViewById(R.id.txtItemMascotaNombre);
            txtItemMascotaPeso = itemView.findViewById(R.id.txtItemMascotaPeso);
            txtItemMascotaGenero = itemView.findViewById(R.id.txtItemMascotaGenero);
        }
    }
}
