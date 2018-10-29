package my.edu.um.fsktm.layoutselector;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Relative extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative);
    }

    public void BtnBackHomeOnClicked(View view)

    {

        EditText ETName = (EditText)findViewById(R.id.ETName);

        Intent RLBackIntent = new Intent();

        RLBackIntent.putExtra("Name", ETName.getText().toString());

        setResult(RESULT_OK, RLBackIntent);

        finish();

    }
}
