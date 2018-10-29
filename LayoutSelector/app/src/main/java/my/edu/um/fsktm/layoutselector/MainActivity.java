package my.edu.um.fsktm.layoutselector;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void BtnToRLActOnClicked (View view)

    {

        Intent RlAct = new Intent (this, Relative.class);

        startActivityForResult(RlAct, 1);

    }

    public void BtnToConstraintOnClicked (View view)

    {

        Intent RlAct = new Intent (this, Constraint.class);

        startActivityForResult(RlAct, 1);

    }


    public void onActivityResult(int requestCode, int resultCode, Intent data)

    {

        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1){

            if (resultCode == RESULT_OK) {

                String strName = data.getStringExtra("Name");

                Toast.makeText(getApplicationContext(), "Welcome Back, " + strName, Toast.LENGTH_LONG).show();

            }

        }

    }
}
