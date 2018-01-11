package cl.jespina.juevessqlite;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fm;
    private FragmentTransaction ft;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fm = getFragmentManager();
        ft = fm.beginTransaction();
        fragment = new NuevaMascotaFragment();
        ft.replace(R.id.contenedor, fragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }

    public void btnVerMascotasClick(View view) {
        muestraFragmentoMascotas();
    }

    public void muestraFragmentoMascotas() {
        fm = getFragmentManager();
        ft = fm.beginTransaction();
        fragment = new MascotasFragment();
        ft.replace(R.id.contenedor, fragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }
}
