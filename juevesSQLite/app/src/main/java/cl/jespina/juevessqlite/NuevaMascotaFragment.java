package cl.jespina.juevessqlite;


import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import cl.jespina.juevessqlite.modelo.CRUDMascota;
import cl.jespina.juevessqlite.modelo.POJOMascota;

/**
 * A simple {@link Fragment} subclass.
 */
public class NuevaMascotaFragment extends Fragment {
    private EditText txtNombre, txtPeso;
    private Spinner spinnerGenero;
    private Button btn;

    public NuevaMascotaFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nueva_mascota, container, false);
        txtNombre = view.findViewById(R.id.txtFragNuevaNombre);
        txtPeso = view.findViewById(R.id.txtFragNuevaPeso);
        spinnerGenero = view.findViewById(R.id.spinnerFragNuevaGenero);
        btn = view.findViewById(R.id.btnFragNuevaMascota);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardarMascota();
            }
        });
        return view;
    }

    public void guardarMascota() {
        CRUDMascota crud = new CRUDMascota(getActivity());
        crud.insertar(
            new POJOMascota(
                txtNombre.getText().toString(),
                Double.valueOf(txtPeso.getText().toString()),
                spinnerGenero.getSelectedItem().toString()
            )
        );
        Log.i("JOSE",String.valueOf(crud.todos().size()));
    }
}
