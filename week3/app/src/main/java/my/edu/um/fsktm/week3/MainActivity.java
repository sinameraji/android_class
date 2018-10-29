package my.edu.um.fsktm.week3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    CheckBox red,blue,green;
    Button buttonOrder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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


//    public void Addition(View view) {
//        EditText ETNum1 = (EditText) findViewById(R.id.ETNum1);
//        EditText ETNum2 = (EditText) findViewById(R.id.ETNum2);
//        TextView TVResult = (TextView) findViewById(R.id.TVResult);
//        int result = Integer.parseInt(ETNum1.getText().toString()) + Integer.parseInt(ETNum2.getText().toString());
//        TVResult.setText(Integer.toString(result));
//
//    }


}
