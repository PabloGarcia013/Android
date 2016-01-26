package com.example.cice.mistrastos.database;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.cice.mistrastos.database.exception.CursorParserException;
import com.example.cice.mistrastos.database.exception.DatabaseException;
import com.example.cice.mistrastos.model.Trasto;

import java.util.ArrayList;


/**
 * Created by CICE on 19/1/16.
 */
public class TrastosDatabaseManager implements TrastosTable {

    Context context;
    DatabaseManager databaseManager;

    public TrastosDatabaseManager(Context context) {
        this.context=context;
        databaseManager = DatabaseManager.getInstance(context);
    }

    @Override
    public long insertTrastos(Trasto trasto) throws DatabaseException {

        SQLiteDatabase db = databaseManager.getWritableDatabase();

        ContentValues row = new ContentValues();

        row.put(TrastosTable.COLUMN_NAME, trasto.getName());
        row.put(TrastosTable.COLUMN_INFO, trasto.getInfo());
        row.put(TrastosTable.COLUMN_PRICE, trasto.getPrice());
        row.put(TrastosTable.COLUMN_ONSALE, trasto.isOnSale());
        row.put(TrastosTable.COLUMN_INFO, trasto.getInfo());
        //TODO: Meter la foto en la base de datos.

        long id = db.insert(TrastosTable.TABLE_NAME, null, row);
        db.close();

        if (id == -1){
            throw new DatabaseException("No se pudo crear el nuevo trasto");
        }

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
    public Trasto getTrasto(long id) throws DatabaseException {
        SQLiteDatabase db = databaseManager.getReadableDatabase();
        String WHERE = TrastosTable.COLUMN_ID + "=?";
        String [] WHERE_ARGS = {String.valueOf(id)};

        Cursor cursor = db.query(TrastosTable.TABLE_NAME,
                TrastosTable.PROJECTION_TOTAL,
                WHERE,
                WHERE_ARGS,
                null,
                null,
                null
        );
        try {
            Trasto trasto = TrastosDatabaseParser.parseTrasto(cursor);
            db.close();
            return trasto;
        } catch (CursorParserException e) {
            db.close();
            throw new DatabaseException(e.getMessage());
        }

    }

    @Override
    public ArrayList<Trasto> getTrastos() {

        SQLiteDatabase db = databaseManager.getReadableDatabase();

        Cursor cursor = db.query(TrastosTable.TABLE_NAME,
                TrastosTable.PROJECTION_TOTAL,
                null,
                null,
                null,
                null,
                null);
        ArrayList<Trasto> trastos = TrastosDatabaseParser.parseTrastos(cursor);
        db.close();
        return trastos;
    }

    @Override
    public ArrayList<Trasto> getOnSaleTrastos() {

        String selection = TrastosTable.COLUMN_ONSALE + "=?";
        String[] selectionArgs = {TrastosTable.ON_SALE};
        SQLiteDatabase db = databaseManager.getReadableDatabase();
        Cursor cursor = db.query(TrastosTable.TABLE_NAME,
                TrastosTable.PROJECTION_TOTAL,
                selection,
                selectionArgs,
                null,
                null,
                null);
        ArrayList<Trasto> trastos = TrastosDatabaseParser.parseTrastos(cursor);
        db.close();
        return trastos;

    }

    @Override
    public ArrayList<Trasto> getNotOnSaleTrastos() {
        String selection = TrastosTable.COLUMN_ONSALE + "=?";
        String[] selectionArgs = {TrastosTable.NOT_ON_SALE};
        SQLiteDatabase db = databaseManager.getReadableDatabase();
        Cursor cursor = db.query(TrastosTable.TABLE_NAME,
                TrastosTable.PROJECTION_TOTAL,
                selection,
                selectionArgs,
                null,
                null,
                null);
        ArrayList<Trasto> trastos = TrastosDatabaseParser.parseTrastos(cursor);
        db.close();
        return trastos;
    }


}
