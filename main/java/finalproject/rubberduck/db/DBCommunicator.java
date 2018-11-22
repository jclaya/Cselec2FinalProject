package finalproject.rubberduck.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DBCommunicator {

    public List<String> properties;
    protected String table_name;

    private SQLiteDatabase sqlite_database;
    private Cursor cursor;

    private SQLiteStatement sql_statement;
    private Context context;

    private String sql;

    public DBCommunicator(Context context) {
        this.context = context;
        properties = new ArrayList<>();
    }


    public void create(List<Object> values) {

        sql = "INSERT INTO " + table_name + "( ";
        Iterator<String> properties_iterator = properties.iterator();

        int count_properties = 0;
        properties_iterator.next();

        while(properties_iterator.hasNext()) {

            sql += properties_iterator.next();
            count_properties++;
            if(properties.size()-1 != count_properties) {
                sql += ", ";
            }
        }

        sql+= " ) VALUES ( ";

        for(; count_properties > 0; count_properties--) {
            sql += "?";
            if(count_properties != 1) {
                sql += ", ";
            }
        }
        sql+=" ) ";


        sqlite_database  = DBHelper.getInstance(context).getWritableDatabase();
        sqlite_database.beginTransactionNonExclusive();

        sql_statement = sqlite_database.compileStatement(sql);

        int i = 0;
        for(Object value: values) {
            i++;
            if( value instanceof  String) {
                sql_statement.bindString(i, value.toString());
            }else if(value instanceof Long || value instanceof Integer) {
                sql_statement.bindLong(i, Long.parseLong(value.toString()));

            }
        }
        sql_statement.execute();
        sql_statement.clearBindings();
        sqlite_database.setTransactionSuccessful();
        sqlite_database.endTransaction();
        sqlite_database.close();
        sql = "";

    }

    public List<List<Object>> read() {
        List<List<Object>> output_list = new ArrayList<>();

        sqlite_database = DBHelper.getInstance(context).getWritableDatabase();
        cursor = sqlite_database.query(table_name, null, null, null, null, null, null);

        boolean has_record = cursor.moveToFirst();

        if(has_record) {
            while(cursor.moveToNext()) {

                List<Object> output = new ArrayList<>();

                for (int i = 0; i < properties.size(); i++) {

                    switch (cursor.getType(i)) {
                        case 1: //int
                        case 2://long
                            output.add(cursor.getInt(i));
                            break;
                        case 3: //string
                            output.add(cursor.getString(i));
                            break;
                    }
                }

                output_list.add(output);
            }

        }

        return output_list;
    }

    public List<Object> read(int id) {
        List<Object> output = new ArrayList<>();

        sqlite_database = DBHelper.getInstance(context).getWritableDatabase();
        cursor = sqlite_database.query(table_name, null, "id = ?", new String[] {Integer.toString(id)}, null, null, null);

        boolean has_record = cursor.moveToFirst();

        if(has_record) {
            for (int i = 0; cursor.moveToNext(); i++) {

                switch (cursor.getType(i)) {
                    case 1: //int
                    case 2://long
                        output.add(cursor.getInt(i));
                        break;
                    case 3: //string
                        output.add(cursor.getString(i));
                        break;
                }
            }
        }
        return output;
    }

    public void update(Object new_value, String update_column, int id/*String where_clause, Object where_value*/) {

        sqlite_database = DBHelper.getInstance(context).getWritableDatabase();

        ContentValues cv = new ContentValues();

        if(new_value instanceof Integer || new_value instanceof Long) {
            cv.put(update_column, (Integer) new_value);
        }else if(new_value instanceof String) {
            cv.put(update_column, new_value.toString());
        }
        //where_clause += " = ?";
        sqlite_database.update(table_name, cv, "id = ?", new String[]{ Integer.toString(id) });
        //sqlite_database.update(table_name, cv, where_clause, new String[]{(where_value instanceof String) ? where_value.toString() : Integer.toString((Integer) where_value) });
    }
    public void delete(int id) {

        sqlite_database = DBHelper.getInstance(context).getWritableDatabase();
        sqlite_database.delete(table_name, " id = ?", new String[]{Integer.toString(id)});

    }

}
