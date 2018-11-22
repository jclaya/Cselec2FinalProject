package finalproject.rubberduck;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import finalproject.rubberduck.models.Book;
import finalproject.rubberduck.models.User;

import java.util.ArrayList;
import java.util.List;

public class CreateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create);

        Button delete_button_user = (Button)findViewById(R.id.create_user);
        delete_button_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createUser();
            }
        });

        Button delete_button_book= (Button)findViewById(R.id.create_book);
        delete_button_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createBook();
            }
        });

    }

    public void createUser() { //todo if else for toast
        EditText name_text = (EditText)findViewById(R.id.user_name);
        EditText email_text = (EditText)findViewById(R.id.user_email);
        EditText contact_number_text = (EditText)findViewById(R.id.user_contact_number);


        String name = name_text.getText().toString();
        String email = email_text.getText().toString();
        int contact_number = Integer.parseInt(contact_number_text.getText().toString());

        List<Object> list = new ArrayList<>();
        list.add(name);
        list.add(email);
        list.add(contact_number);

        new User(this).create(list);
    }

    public void createBook() {

        EditText name_text = (EditText)findViewById(R.id.book_name);
        EditText author_text = (EditText)findViewById(R.id.book_author);


        String name = name_text.getText().toString();
        String author = author_text.getText().toString();

        List<Object> list = new ArrayList<>();
        list.add(name);
        list.add(author);

        new Book(this).create(list);
    }

    @Override
    public void onBackPressed()  {
        finish();
    }
}
