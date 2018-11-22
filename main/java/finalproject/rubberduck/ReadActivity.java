package finalproject.rubberduck;

import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import finalproject.rubberduck.models.Book;
import finalproject.rubberduck.models.User;

import java.util.List;

public class ReadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.read);

        TableLayout user_table_layout=(TableLayout)findViewById(R.id.user_table_layout);
        TableRow user_row_header = new TableRow(this);
        user_row_header.setBackgroundColor(Color.parseColor("#c0c0c0"));
        user_row_header.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT));

        for(String props: new User(this).properties) {
            TextView text_view = new TextView(this);
            text_view.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                    TableRow.LayoutParams.WRAP_CONTENT));
            text_view.setGravity(Gravity.CENTER);
            text_view.setTextSize(18);
            text_view.setPadding(5, 5, 5, 5);
            text_view.setText(props);
            user_row_header.addView(text_view);
        }
        user_table_layout.addView(user_row_header);


        List<List<Object>> users = new User(this).read();

        for(List<Object> objs : users) {
            TableRow row = new TableRow(this);
            row.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.WRAP_CONTENT));
            for(Object text : objs) {
                TextView text_view = new TextView(this);
                text_view.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                        TableRow.LayoutParams.WRAP_CONTENT));
                text_view.setGravity(Gravity.CENTER);
                text_view.setTextSize(16);
                text_view.setPadding(5, 5, 5, 5);
                text_view.setText(text.toString());
                row.addView(text_view);
            }
            user_table_layout.addView(row);
        }




        //BOOK

        TableLayout book_table_layout=(TableLayout)findViewById(R.id.book_table_layout);
        TableRow book_row_header = new TableRow(this);
        book_row_header.setBackgroundColor(Color.parseColor("#c0c0c0"));
        book_row_header.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT));

        for(String props: new Book(this).properties) {
            TextView text_view = new TextView(this);
            text_view.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                    TableRow.LayoutParams.WRAP_CONTENT));
            text_view.setGravity(Gravity.CENTER);
            text_view.setTextSize(18);
            text_view.setPadding(5, 5, 5, 5);
            text_view.setText(props);
            book_row_header.addView(text_view);
        }
        book_table_layout.addView(book_row_header);


        List<List<Object>> books = new Book(this).read();

        for(List<Object> objs : books) {
            TableRow row = new TableRow(this);
            row.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.WRAP_CONTENT));
            for(Object text : objs) {
                TextView text_view = new TextView(this);
                text_view.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                        TableRow.LayoutParams.WRAP_CONTENT));
                text_view.setGravity(Gravity.CENTER);
                text_view.setTextSize(16);
                text_view.setPadding(5, 5, 5, 5);
                text_view.setText(text.toString());
                row.addView(text_view);
            }
            book_table_layout.addView(row);
        }

    }

    @Override
    public void onBackPressed()  {
        finish();
    }
}
