package finalproject.rubberduck.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static DBHelper instance;

    public DBHelper(Context context) {
        super(context, SQLScripts.DB_NAME, null, SQLScripts.VERSION);
    }

    public static synchronized DBHelper getInstance(Context context) {
        if(instance == null) {
            instance = new DBHelper(context);
        }

        return instance;
    }


    @Override
    public void onCreate(SQLiteDatabase sqlite_database) {



        for(String script : SQLScripts.getScripts()) {
            sqlite_database.execSQL(script);
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqlite_database, int old_version, int new_version) {
        if(new_version > old_version) {

            for(String table_name : SQLScripts.getTables())  {
                sqlite_database.execSQL("drop table if exists " + table_name);
            }

            this.onCreate(sqlite_database);

        }
    }


}