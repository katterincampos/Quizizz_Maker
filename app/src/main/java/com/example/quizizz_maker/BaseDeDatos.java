package com.example.quizizz_maker;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDeDatos extends SQLiteOpenHelper {
    public static final String db_usuarios = "db_usuario";
    public static final int v = 1;
    String sqlTabla = "create table cuestionarios(idCuestionario integer primary key autoincrement, pregunta text,respuestaCorrecta text,respuesta2 text,respuesta3 text,respuesta4 text)";

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
    public void guardarCuestionario( String Pregunt, String RespCor ,String RespInc1, String RespInc2,String RespInc3, String accion, String Id){
        SQLiteDatabase db = getWritableDatabase();
        if(accion.equals("modificar")){
            db.execSQL("update cuestionarios set  pregunta='"+ Pregunt +"', respuestaCorrecta='"+ RespCor +"',respuestaInc1='"+RespInc1+"', respuestaInc2='"+RespInc2+"',respuestaInc3='"+RespInc3+"' where idCuestionario='"+ Id +"'");
        } else{
            db.execSQL("insert into cuestionarios ( pregunta, respuestaCorrecta, respuesta2, respuesta3,respuesta4) values('"+ Pregunt +"','"+ RespCor +"','"+ RespInc1 +"','"+ RespInc2 +"','"+ RespInc3+"')");
        }
    }
    public void eliminarCuestionario(String id){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("delete from cuestionarios where idCuestionario='"+ id +"'");
    }
    public Cursor consultarCuestionarios(){
        String sql = "select * from cuestionarios order by nombre asc";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);
        return c;
    }
}

