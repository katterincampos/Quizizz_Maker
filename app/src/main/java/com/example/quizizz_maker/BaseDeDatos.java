package com.example.quizizz_maker;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDeDatos extends SQLiteOpenHelper {
    public static final String Quizz_maker = "QuizzMaker";
    public static final int v = 1;
    String cuestionarios = "create table cuestionarios (idCuestionario integer primary key autoincrement, nombre text, categoria text, pregunta1 text, respuestaCorrecta1_1 text, respuesta1_1 text, respuesta1_2 text, respuesta1_3 text, pregunta2 text, respuestaCorrecta2_1 text, respuesta2_1 text, respuesta2_2 text, respuesta2_3 text, pregunta3 text, respuestaCorrecta3_1 text, respuesta3_1 text, respuesta3_2 text, respuesta3_3 text, pregunta4 text, respuestaCorrecta4 text, respuesta4_1 text, respuesta4_2 text, respuesta4_3 text)";

    public BaseDeDatos(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, Quizz_maker, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(cuestionarios);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    public void guardarCuestionario(String Nombre,String Categoria, String Pregunt, String RespCor, String RespInc1, String RespInc2, String RespInc3, String accion, String Id, String Pregunt2, String RespCor2, String RespInc2_1, String RespInc2_2, String RespInc2_3, String Pregunt3, String RespCor3, String RespInc3_1, String RespInc3_2, String RespInc3_3, String Pregunt4, String RespCor4, String RespInc4_1, String RespInc4_2, String RespInc4_3){
        SQLiteDatabase db = getWritableDatabase();
        if(accion.equals("modificar")){
            db.execSQL("update cuestionarios set  Nombre='"+Nombre+"',Categoria='"+Categoria+"',pregunta='"+ Pregunt +"', respuestaCorrecta='"+ RespCor +"',respuestaInc1='"+RespInc1+"', respuestaInc2='"+RespInc2+"',respuestaInc3='"+RespInc3+"',pregunta2='"+ Pregunt2 +"', respuestaCorrecta2='"+ RespCor2 +"',respuestaInc2_1='"+RespInc2_1+"', respuestaInc2_2='"+RespInc2_2+"',respuestaInc2_3='"+RespInc2_3+"',pregunta3='"+ Pregunt3 +"', respuestaCorrecta3='"+ RespCor3 +"',respuestaInc3_1='"+RespInc3_1+"', respuestaInc3_2='"+RespInc3_2+"',respuestaInc3_3='"+RespInc3_3+"',pregunta4='"+ Pregunt4 +"', respuestaCorrecta4='"+ RespCor4 +"',respuestaInc4_1='"+RespInc4_1+"', respuestaInc4_2='"+RespInc4_2+"',respuestaInc4_3='"+RespInc4_3+"' where idCuestionario='"+ Id +"'");
        } else{
            db.execSQL("insert into cuestionarios (nombre, categoria, pregunta1, respuestaCorrecta1_1, respuesta1_1, respuesta1_2, respuesta1_3, pregunta2, respuestaCorrecta2_1, respuesta2_1, respuesta2_2, respuesta2_3, pregunta3, respuestaCorrecta3_1, respuesta3_1, respuesta3_2, respuesta3_3, pregunta4, respuestaCorrecta4, respuesta4_1 ,respuesta4_2 ,respuesta4_3 ) values('"+Nombre+"','"+Categoria+"','"+Pregunt+"','"+RespCor+"', '"+RespInc1+"','"+RespInc2+"','"+RespInc3+"','"+Pregunt2+"','"+RespCor2+"','"+RespInc2_1+"','"+RespInc2_2+"','"+RespInc2_3+"','"+Pregunt3+"','"+RespCor3+"','"+RespInc3_1+"','"+RespInc3_2+"','"+RespInc3_3+"','"+Pregunt4+"','"+RespCor4+"','"+RespInc4_1+"', '"+RespInc4_2+"','"+RespInc4_3+"')");
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


