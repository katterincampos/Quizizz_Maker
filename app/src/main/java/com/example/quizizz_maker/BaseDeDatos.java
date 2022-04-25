package com.example.quizizz_maker;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDeDatos extends SQLiteOpenHelper {
    public static final String db_usuarios = "db_usuario";
    public static final int v = 1;
    String sqlTabla = "create table usuarios(idCuestionario integer primary key autoincrement, nombreCuestionario text,pregunta1 text,respuesta1 text,pregunta2 text,respuesta2 text,pregunta3 text,respuesta3 text,pregunta4 text,respuesta4 text,pregunta5 text,respuesta5 text,pregunta6 text,respuesta6 text,pregunta7 text,respuesta7 text,pregunta8 text,respuesta8 text,pregunta9 text,respuesta9 text,pregunta10 text,respuesta10 text)";

    public BaseDeDatos(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, db_usuarios, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlTabla);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    public void guardarCuestionario(String nomcues, String pregunta1, String respuesta1 ,String pregunta2, String respuesta2,String pregunta3, String respuesta3,String pregunta4, String respuesta4,String pregunta5, String respuesta5,String pregunta6, String respuesta6,String pregunta7, String respuesta7,String pregunta8, String respuesta8,String pregunta9, String respuesta9,String pregunta10, String respuesta10, String accion, String id){
        SQLiteDatabase db = getWritableDatabase();
        if(accion.equals("modificar")){
            db.execSQL("update usuarios set nombre='"+ nomcues +"', Pregunta1='"+ pregunta1 +"', Respuesta1='"+ respuesta1 +"',Pregunta2='"+pregunta2+"', Respuesta2='"+respuesta2+"',Pregunta3='"+pregunta3+"', Respuesta3='"+respuesta3+"', Pregunta4='"+pregunta4+"',Respuesta4='"+respuesta4+"',Pregunta5='"+pregunta5+"', Respuesta5='"+respuesta5+"', Pregunta6='"+pregunta6+"',Respuesta6='"+respuesta6+"', Pregunta7='"+pregunta7+"', Respuesta7='"+respuesta7+"', Pregunta8='"+pregunta8+"', respuesta8='"+respuesta8+"', Pregunta9='"+pregunta9+"',Respuesta9='"+respuesta9+"', Pregunta10='"+pregunta10+"',Respuesta10='"+respuesta10+"' where idCuestionario='"+ id +"'");
        } else{
            db.execSQL("insert into usuarios (nomCuestionario, pregunta1, respuesta1, pregunta2, respuesta2,pregunta3, respuesta3, pregunta4, respuesta4, pregunta5, respuesta5, pregunta6, respuesta6, pregunta7, respuesta7, pregunta8, respuesta8, pregunta9, respuesta9, pregunta10, respuesta10) values('"+ nomcues +"','"+ pregunta1 +"','"+ respuesta1 +"','"+ pregunta2 +"','"+ pregunta3 +"','"+ respuesta3+"','"+ pregunta4 +"','"+ respuesta4 +"','"+ pregunta5 +"','"+ respuesta5 +"','"+ pregunta6 +"','"+ respuesta6 +"','"+ pregunta7 +"','"+ respuesta7 +"','"+ pregunta8 +"','"+ respuesta8 +"','"+ pregunta9 +"','"+ respuesta9 +"','"+ pregunta10 +"','"+ respuesta10 +"')");
        }
    }
    public void eliminarUsuario(String id){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("delete from usuarios where idUsuario='"+ id +"'");
    }
    public Cursor consultarUsuarios(){
        String sql = "select * from usuarios order by nombre asc";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);
        return c;
    }
}

