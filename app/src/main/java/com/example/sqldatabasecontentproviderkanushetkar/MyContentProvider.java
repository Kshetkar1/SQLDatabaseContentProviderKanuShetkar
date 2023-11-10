package com.example.sqldatabasecontentproviderkanushetkar;

import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

public class MyContentProvider extends android.content.ContentProvider {


    public final static String DBNAME = "NameDatabase";

    protected static final class MainDatabaseHelper extends SQLiteOpenHelper {
        MainDatabaseHelper(Context context) {
            super(context, DBNAME, null, 1);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(SQL_CREATE_MAIN);
        }
        @Override
        public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        }
    };


    public final static String TABLE_NAMESTABLE = "PokemonData";
    public final static String NationalNumber = "number";
    public final static String Name = "name";

    public final static String Species = "species";

    public final static String Gender = "gender";
    public final static String Height = "height";

    public final static String Weight = "weight";
    public final static String Level = "level";
    public final static String HP = "hp";
    public final static String Attack = "attack";
    public final static String Defense = "defense";

    public static final String AUTHORITY = "Kanupoketracker";
    public static final Uri CONTENT_URI = Uri.parse(
            "content://" + AUTHORITY +"/" + TABLE_NAMESTABLE);

    private static UriMatcher sUriMatcher;

    private MainDatabaseHelper mOpenHelper;

    private static final String SQL_CREATE_MAIN = "CREATE TABLE " +
            TABLE_NAMESTABLE +  // Table's name
            "(" +               // The columns in the table
            " _id INTEGER PRIMARY KEY, " +
            NationalNumber +
            " INTEGER," +
            Name +
            " TEXT," +
            Species +
            "TEXT," +
            Gender +
            "TEXT," +
            Height +
            "INTEGER," +
            Weight +
            "INTEGER," +
            Level +
            "INTEGER," +
            HP +
            "INTEGER," +
            Attack +
            "INTEGER," +
            Defense +
            "INTEGER)";


    public MyContentProvider() {

    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return mOpenHelper.getWritableDatabase().delete(TABLE_NAMESTABLE, selection, selectionArgs);
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {

//        String fname = values.getAsString(COLUMN_FIRSTNAME).trim();
//        String lname = values.getAsString(COLUMN_LASTNAME).trim();

//        if (fname.equals(""))
//            return null;
//
//        if (lname.equals(""))
//            return null;

        long id = mOpenHelper.getWritableDatabase().insert(TABLE_NAMESTABLE, null, values);

        return Uri.withAppendedPath(CONTENT_URI, "" + id);
    }

    @Override
    public boolean onCreate() {
        mOpenHelper = new MainDatabaseHelper(getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        return mOpenHelper.getReadableDatabase().query(TABLE_NAMESTABLE, projection, selection, selectionArgs,
                null, null, sortOrder);
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        return mOpenHelper.getWritableDatabase().update(TABLE_NAMESTABLE, values, selection, selectionArgs);
    }
}