package com.example.cice.sqlite;

import java.util.ArrayList;

/**
 * Created by CICE on 19/1/16.
 */
public interface TrastosTable {

    String TABLE_NAME = "t_trastos";

    String COLUMN_ID        = "id";
    String COLUMN_NAME      = "name";

    int INDEX_COLUMN_ID     = 0;
    int INDEX_COLUMN_NAME   = 1;

    String ID   = COLUMN_ID     + " INTEGER PRIMARY KEY AUTOINCREMENT, ";
    String NAME = COLUMN_NAME   + " TEXT";


    // Todas estas creaciones son la misma
    String CREATE = "CREATE TABLE '" + TABLE_NAME + "' (" +
            COLUMN_ID       + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_NAME     + " TEXT" +
            ");";


    String CREATE2 = String.format("CREATE TABLE '%s' (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT);",
            TABLE_NAME,
            COLUMN_ID,
            COLUMN_NAME);

    String CREATE3 = String
        .format("CREATE TABLE %s (%s, %s);",
                TABLE_NAME,
                ID,
                NAME);

    long insertTrastos(Trasto trasto);
    void deleteTrasto(Trasto trasto);
    void updateTrasto(Trasto trasto);
    Trasto getTrasto(long id);
    ArrayList<Trasto> getTrastos();
}
