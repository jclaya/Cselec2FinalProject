package finalproject.rubberduck.models;

import android.content.Context;

import finalproject.rubberduck.db.DBCommunicator;


public class Book extends DBCommunicator{

    public Book(Context context) {
        super(context);
        this.table_name = "book";
        this.properties.add("id");
        this.properties.add("name");
        this.properties.add("author");
    }
}
