package my.edu.um.fsktm.week7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.TB);
        setSupportActionBar(myToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.action_settings:
                // user chose the "settings" item, show the app settings UI...
                return true;
            case R.id.action_favorite:
                //user chose the "favorite" action, mark the current item
                //as a favorite
                return true;
            default:
                //if we got here, the user's action was not recognised
                // invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }
    }

    public void BtnToRLActOnClicked (View view)

    {

        Intent child = new Intent (this, ChildActivity.class);

        startActivityForResult(child, 1);

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
