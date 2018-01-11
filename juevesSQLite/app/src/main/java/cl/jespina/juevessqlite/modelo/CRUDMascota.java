package cl.jespina.juevessqlite.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;

public class CRUDMascota {

    private SQLiteDatabase db;
    private ContentValues values;
    private AsistenteConexion asistente;

    public CRUDMascota(Context context) {
        asistente = new AsistenteConexion(context);
    }

    public void insertar(POJOMascota pm) {
        db = asistente.getWritableDatabase();
        values = new ContentValues();
        values.clear();
        values.put(AsistenteConexion.TABLA_COLUMNA_NOMBRE,pm.getNombre());
        values.put(AsistenteConexion.TABLA_COLUMNA_GENERO,pm.getGenero());
        values.put(AsistenteConexion.TABLA_COLUMNA_PESO,pm.getPeso());
        db.insert(AsistenteConexion.TABLA_NOMBRE, null, values);
    }

    public void eliminar(int id) {
        db = asistente.getWritableDatabase();
        db.delete(AsistenteConexion.TABLA_NOMBRE,
            AsistenteConexion.TABLA_COLUMNA_ID + "=?",
            new String[]{String.valueOf(id)});
    }

    public void actualizar(POJOMascota pm) {
        db = asistente.getWritableDatabase();
        values.clear();
        values.put(AsistenteConexion.TABLA_COLUMNA_NOMBRE,pm.getNombre());
        values.put(AsistenteConexion.TABLA_COLUMNA_GENERO,pm.getGenero());
        values.put(AsistenteConexion.TABLA_COLUMNA_GENERO,pm.getPeso());
        db.update(
            AsistenteConexion.TABLA_NOMBRE,
            values,
            AsistenteConexion.TABLA_COLUMNA_ID+"=?",
            new String[]{String.valueOf(pm.getId())}
        );
    }

    public POJOMascota buscar(int id) {
        db = asistente.getReadableDatabase();
        Cursor c;
        c = db.rawQuery("SELECT * FROM " + AsistenteConexion.TABLA_NOMBRE, new String[]{String.valueOf(id)});
        if(c.moveToNext()) {
            return new POJOMascota(
                id,                                    //id
                c.getString(1),                     // nombre
                c.getDouble(2),                     // peso
                c.getString(3)                      // genero
            );
        }
        return null;
    }

    public ArrayList<POJOMascota> todos() {
        ArrayList<POJOMascota> list = new ArrayList<>();
        db = asistente.getReadableDatabase();
        Cursor c;
        c = db.rawQuery("SELECT * FROM " + AsistenteConexion.TABLA_NOMBRE, null);
        if(c.moveToFirst()) {
            do {
                list.add(new POJOMascota(
                        c.getInt(0),                        // id
                        c.getString(1),                     // nombre
                        c.getDouble(2),                     // peso
                        c.getString(3)                      // genero
                ));
            } while (c.moveToNext());
        }
        return list;
    }
}
