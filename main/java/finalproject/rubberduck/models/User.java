package finalproject.rubberduck.models;

import android.content.Context;

import finalproject.rubberduck.db.DBCommunicator;
import finalproject.rubberduck.db.DBHelper;

import java.util.ArrayList;
import java.util.List;

public class User extends DBCommunicator {

    public User(Context context ) {
        super(context);
        this.table_name = "user";
        this.properties.add("id");
        this.properties.add("name");
        this.properties.add("email");
        this.properties.add("contact_number");
    }

}
