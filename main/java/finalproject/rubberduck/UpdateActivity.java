package finalproject.rubberduck;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import finalproject.rubberduck.models.Book;
import finalproject.rubberduck.models.User;


public class UpdateActivity extends AppCompatActivity {

    Spinner user_properties;
    Spinner book_properties;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update);

        user_properties = (Spinner) findViewById(R.id.user_properties);
        user_properties.setSelection(0);

        ArrayAdapter<String> user_adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, new User(this).properties);
        user_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        user_properties.setAdapter(user_adapter);

        book_properties = (Spinner) findViewById(R.id.book_properties);
        book_properties.setSelection(0);

        ArrayAdapter<String> book_adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, new Book(this).properties);
        book_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        book_properties.setAdapter(book_adapter);

        Button update_button_user = (Button)findViewById(R.id.update_user);
        update_button_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateUser();
            }
        });

        Button update_button_book= (Button)findViewById(R.id.update_book);
        update_button_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateBook();
            }
        });
    }

    @Override
    public void onBackPressed()  {
        finish();
    }

    void updateUser() {
        EditText id_text = (EditText)findViewById(R.id.user_id);
        EditText new_val_text = (EditText)findViewById(R.id.user_new_value);

        int id = Integer.parseInt(id_text.getText().toString());
        String col = user_properties.getSelectedItem().toString();
        String new_val = new_val_text.getText().toString();

        new User(this).update(new_val, col, id);
    }

    void updateBook() {
        EditText id_text = (EditText)findViewById(R.id.book_id);
        EditText new_val_text = (EditText)findViewById(R.id.book_new_value);

        int id = Integer.parseInt(id_text.getText().toString());
        String col = book_properties.getSelectedItem().toString();
        String new_val = new_val_text.getText().toString();

        new Book(this).update(new_val, col, id);
    }
}
