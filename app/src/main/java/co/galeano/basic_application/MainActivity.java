package co.galeano.basic_application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //----- Declaration of variables  -----
    private TextView life_cycle;
    private TextView tvmessage;
    private EditText inputText;
    private AppCompatButton btn_Happy;
    private AppCompatButton btn_Sad;
    private AppCompatButton btn_Send;
    String Tag = "life_cycle";
    boolean late = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(Tag, "On Create");

        life_cycle = (TextView) findViewById(R.id.User);
        life_cycle.setText("On create");
    }

    @Override
    protected void onStart() {
        super.onStart();
        setContentView(R.layout.activity_main);

        Log.i(Tag, "On Start");
        life_cycle = (TextView) findViewById(R.id.User);
        life_cycle.setText("On create");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(Tag, "On Resume");
        setContentView(R.layout.activity_main);

        initComponent();
        life_cycle.setText("On Resume");
        initListener();
    }

    @Override
    protected void onPause() {
        super.onPause();
        setContentView(R.layout.activity_main);

        Log.i(Tag, "On Pause");
        life_cycle = (TextView) findViewById(R.id.User);
        life_cycle.setText("On Pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        setContentView(R.layout.activity_main);

        Log.i(Tag, "On Stop");
        life_cycle = (TextView) findViewById(R.id.User);
        life_cycle.setText("On Stop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        setContentView(R.layout.activity_main);

        Log.i(Tag, "On Destroy");
        life_cycle = (TextView) findViewById(R.id.User);
        life_cycle.setText("On Destroy");
    }

    private void initComponent() {
        life_cycle = (TextView) findViewById(R.id.User);
        inputText = findViewById(R.id.inputText);
        tvmessage = (TextView) findViewById(R.id.tvmessage);
        btn_Happy = findViewById(R.id.btn_Happy);
        btn_Sad = findViewById(R.id.btn_Sad);
        btn_Send = findViewById(R.id.btn_Send);
    }

    private void initListener() {
        btn_Happy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Happy = getString(R.string.txt_happy);
                tvmessage.setText(Happy);
            }
        });
        btn_Sad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Sad = getString(R.string.txt_sad);
                tvmessage.setText(Sad);
            }
        });
        btn_Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Nombre = inputText.getText().toString();
                Intent intent = new Intent(getApplicationContext(), Content.class);
                intent.putExtra("name", Nombre);
                startActivity(intent);
            }
        });
    }

}