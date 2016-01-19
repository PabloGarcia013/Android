package com.example.cice.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by CICE on 19/1/16.
 */
public class TrastosDatabaseManager implements TrastosTable{

    Context context;
    DatabaseManager databaseManager;

    public TrastosDatabaseManager(Context contex) {
        this.context=contex;
        databaseManager = DatabaseManager.getInstance(contex);
    }

    @Override
    public long insertTrastos(Trasto trasto) {

        SQLiteDatabase db = databaseManager.getWritableDatabase();

        ContentValues row = new ContentValues();

        row.put(TrastosTable.COLUMN_NAME, trasto.getName());

        long id = db.insert(TrastosTable.TABLE_NAME, null, row);
        db.close();

        return id;
    }

    @Override
    public void deleteTrasto(Trasto trasto) {

        String[] args = {String.valueOf(trasto.getId())};
        SQLiteDatabase db = databaseManager.getWritableDatabase();

        db.delete(TrastosTable.TABLE_NAME,TrastosTable.COLUMN_ID + "=?", args);

        db.close();
    }

    @Override
    public void updateTrasto(Trasto trasto) {

    }

    @Override
    public Trasto getTrasto(long id) {
        return null;
    }

    @Override
    public ArrayList<Trasto> getTrastos() {
        return null;
    }
}
