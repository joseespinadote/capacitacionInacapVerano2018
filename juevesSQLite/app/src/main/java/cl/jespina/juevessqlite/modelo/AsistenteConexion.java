package cl.jespina.juevessqlite.modelo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AsistenteConexion extends SQLiteOpenHelper{
    private static final String BD_NOMBRE = "basedatos";
    private static final int BD_VERSION = 2;
    public static final String TABLA_NOMBRE = "tabla01";
    public static final String TABLA_COLUMNA_ID = "id";
    public static final String TABLA_COLUMNA_NOMBRE = "nombre";
    public static final String TABLA_COLUMNA_PESO = "peso";
    public static final String TABLA_COLUMNA_GENERO = "genero";

    public AsistenteConexion(Context conext) {
        super(conext, BD_NOMBRE, null, BD_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE " + TABLA_NOMBRE + " ( ";
        sql += TABLA_COLUMNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, ";
        sql += TABLA_COLUMNA_NOMBRE + " text, ";
        sql += TABLA_COLUMNA_PESO + " double, ";
        sql += TABLA_COLUMNA_GENERO + " text);";
        sqLiteDatabase.execSQL(sql);
        sqLiteDatabase.execSQL(
            "INSERT INTO " + TABLA_NOMBRE + " VALUES (NULL,'prueba concepto',95.5,'macho')"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE " + TABLA_NOMBRE);
        onCreate(sqLiteDatabase);
    }
}
