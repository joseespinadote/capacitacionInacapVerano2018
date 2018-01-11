package com.example.clrubilarc.fragment2;

import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,frag1.OnFragmentInteractionListener,frag2.OnFragmentInteractionListener {

    Button btnfrag1,btnfrag2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //crea un nuevo fragmento
        frag1 Fragmento1 = new frag1();
         //frag2 Fragmento2 = new frag2();

        //Inflar  o visualizar el fragment
        getSupportFragmentManager().beginTransaction().add(R.id.contenedor,Fragmento1);
        Button btnfrag1 = (Button)findViewById(R.id.btnFrag1);
          Button btnfrag2 = (Button)findViewById(R.id.btnFrag2);

        btnfrag1.setOnClickListener(this);
        btnfrag2.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
         //botn haga algo
            case R.id.btnFrag1:

              //crea un nuevo fragmento
                frag1 Fragmento1 = new frag1();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                //reemplaza lo que hay en el contenedor
                transaction.replace(R.id.contenedor,Fragmento1);
                transaction.commit();

                //Si agregas varios cambios a la transacción (como otro add() o remove()) y llamas a addToBackStack(),
                // todos los cambios aplicados antes de llamar a commit() se agregarán a la pila de retroceso como una
                // transacción única, y el botón Atrás los revertirá juntos.

          break;

            case R.id.btnFrag2:
                frag2 Fragmento2 = new frag2();
                FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();
                transaction2.replace(R.id.contenedor,Fragmento2);
                transaction2.commit();

        }

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
