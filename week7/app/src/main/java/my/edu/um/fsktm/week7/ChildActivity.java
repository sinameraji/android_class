package my.edu.um.fsktm.week7;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class ChildActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.child_activity);
        Toolbar myChildToolbar = (Toolbar) findViewById(R.id.TBChild);
        setSupportActionBar(myChildToolbar);

        //Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        //Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);

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
}
