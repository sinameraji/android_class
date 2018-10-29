package my.edu.um.fsktm.week3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class Checkbox extends AppCompatActivity {
    Button buttonOrder;
    CheckBox red, blue, green;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbox);
        addListenerOnButtonClick();
    }

    public void addListenerOnButtonClick(){
        //Getting instance of CheckBoxes and Button from the activty_main.xml file
        red=(CheckBox)findViewById(R.id.CBred);
        blue=(CheckBox)findViewById(R.id.CBblue);
        green=(CheckBox)findViewById(R.id.CBgreen);
        buttonOrder=(Button)findViewById(R.id.button);

        //Applying the Listener on the Button click
        buttonOrder.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                StringBuilder result=new StringBuilder();
                result.append("Selected Items:");
                if(red.isChecked())
                    result.append("\nRed");

                if(blue.isChecked())
                    result.append("\nBlue");

                if(green.isChecked())
                    result.append("\nGreen");

                //Displaying the message on the toast
                Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_LONG).show();
            }

        });
    }
}
