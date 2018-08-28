package in.semicolonindia.senddataoneactivity_second_eg_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
@SuppressWarnings("ALL")
public class SecondActivity extends AppCompatActivity {
    private EditText ed_data;
    private Button btn_back;
    private TextView tv_first/*,tv_second*/;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ed_data=(EditText)findViewById(R.id.ed_data);
        btn_back=(Button)findViewById(R.id.btn_back);
        tv_first=(TextView)findViewById(R.id.tv_first);
        /*tv_second=(TextView)findViewById(R.id.tv_second);*/

        Intent in =getIntent();
        Bundle b=in.getExtras();
        String str1=b.getString("name");
        String str2=b.getString("value");
       /* tv_first.setText(str1);
        tv_second.setText(str2);*/

        tv_first.append(str1+"\n"+str2+"\n");


        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = ed_data.getText().toString();
                // Intent intent=new Intent(SecondActivity.this,FirstActivity.class);
                Intent intent = new Intent();
                intent.putExtra("name", name);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
