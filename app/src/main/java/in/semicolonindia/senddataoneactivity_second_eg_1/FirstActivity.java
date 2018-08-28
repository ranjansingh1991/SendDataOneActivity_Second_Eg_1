package in.semicolonindia.senddataoneactivity_second_eg_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

@SuppressWarnings("ALL")
public class FirstActivity extends AppCompatActivity {
    private EditText ed_Name,ed_Vale;
    private Button btn_send;
    TextView tv_data;

    private static final int SECOND_ACTIVITY_REQUEST_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_main);
        ed_Name = (EditText) findViewById(R.id.ed_Name);
        ed_Vale = (EditText) findViewById(R.id.ed_Vale);
        btn_send = (Button) findViewById(R.id.btn_send);
        tv_data = (TextView) findViewById(R.id.tv_data);

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = ed_Name.getText().toString();
                String value = ed_Vale.getText().toString();
                if (name.length()==0){
                    ed_Name.setError("name can not blank");
                }else if (value.length()==0){
                    ed_Vale.setError("values can not be blank");
                }
                else {
                    Intent i = new Intent(FirstActivity.this, SecondActivity.class);
                    i.putExtra("name", name);
                    i.putExtra("value", value);
                    startActivityForResult(i, SECOND_ACTIVITY_REQUEST_CODE);

                    ed_Name.setText(" ");
                    ed_Vale.setText(" ");
                }
//   startActivity(i);
            }
        });


    }

    // This method is called when the second activity finishes
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // check that it is the SecondActivity with an OK result
        if (requestCode == SECOND_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {

                Bundle b = data.getExtras();

                // get String data from Intent
                String returnString = b.getString("name");
                tv_data.setText(returnString);
            }
        }
    }
}
