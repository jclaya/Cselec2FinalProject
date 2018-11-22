package finalproject.rubberduck.db;

public class SQLScripts {
    public static String[] scripts;
    public static String[] tables;

    public static String DB_NAME = "RubberDuck.db";

    public static int VERSION = 1;

    public static String[] getScripts() {
        return new String[] {
                "CREATE TABLE user (id integer primary key autoincrement, name text, email text, contact_number real) ",
                "CREATE TABLE book (id integer primary key autoincrement, name text, author text)"
        };
    }

    public static String[] getTables() {
        return new String[] {
                "user",
                "book"
        };
    }
}
