package com.example.alumnossur.martes.modelo;

import java.util.ArrayList;

/**
 * Created by alumnossur on 09/01/2018.
 */

public class Te {
    private String title;
    private int resourceImage;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getResourceImage() {
        return resourceImage;
    }

    public void setResourceImage(int resourceImage) {
        this.resourceImage = resourceImage;
    }

    public Te(String title, int resourceImage) {
        this.title = title;
        this.resourceImage = resourceImage;
    }

    public Te() {

    }

    public static ArrayList<Te> getLista() {
        ArrayList<Te> lista = new ArrayList<>();
        lista.add(new Te("titulo 1", android.R.mipmap.sym_def_app_icon));
        lista.add(new Te("titulo 2", android.R.mipmap.sym_def_app_icon));
        lista.add(new Te("titulo 3", android.R.mipmap.sym_def_app_icon));
        lista.add(new Te("titulo 4", android.R.mipmap.sym_def_app_icon));
        lista.add(new Te("titulo 5", android.R.mipmap.sym_def_app_icon));
        lista.add(new Te("ñañañña", android.R.mipmap.sym_def_app_icon));
        return lista;
    }

    public static int getImageDrawable(String title) {
        ArrayList<Te> lista = getLista();
        for (int index = 0; index < getLista().size(); index++) {
            if (lista.get(index).getTitle()=="title") {
                return index;
            }
        }
        return 0;
    }
}
