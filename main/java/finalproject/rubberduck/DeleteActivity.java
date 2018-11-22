package finalproject.rubberduck;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import finalproject.rubberduck.models.User;

public class DeleteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete);

        Button delete_button_user = (Button)findViewById(R.id.delete_user);
        delete_button_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteUser();
            }
        });

        Button delete_button_book= (Button)findViewById(R.id.delete_book);
        delete_button_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteBook();
            }
        });

    }

    public void deleteUser() { //todo if else for toast
        EditText text = (EditText)findViewById(R.id.user_id);
        int id = Integer.parseInt(text.getText().toString());
        new User(this).delete(id);
    }

    public void deleteBook() {

        EditText text = (EditText)findViewById(R.id.book_id);
        int id = Integer.parseInt(text.getText().toString());
        new User(this).delete(id);
    }

    @Override
    public void onBackPressed()  {
        finish();
    }
}
