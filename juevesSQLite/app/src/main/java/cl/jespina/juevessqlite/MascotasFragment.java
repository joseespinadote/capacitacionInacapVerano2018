package cl.jespina.juevessqlite;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cl.jespina.juevessqlite.adaptador.AdaptadorMascotas;
import cl.jespina.juevessqlite.modelo.CRUDMascota;


/**
 * A simple {@link Fragment} subclass.
 */
public class MascotasFragment extends Fragment {


    public MascotasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mascotas, container, false);
        RecyclerView rv = view.findViewById(R.id.recycleMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(view.getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(llm);
        CRUDMascota crud = new CRUDMascota(view.getContext());
        rv.setAdapter(new AdaptadorMascotas(crud.todos(), R.layout.item_mascota, getActivity()));
        return view;
    }

}
