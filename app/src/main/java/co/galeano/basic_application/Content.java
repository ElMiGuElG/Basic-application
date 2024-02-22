package co.galeano.basic_application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Content extends AppCompatActivity {

    //----- Declaration of variables  -----
    private TextView life_cycle;
    private TextView tvNombre;
    private AppCompatButton btn_back;
    String Tag = "life_cycle";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        Log.i(Tag, "On Create");

        life_cycle = (TextView) findViewById(R.id.User);
        life_cycle.setText("On create");
    }
    @Override
    protected void onStart() {
        super.onStart();
        setContentView(R.layout.activity_content);

        Log.i(Tag, "On Start");
        life_cycle = (TextView) findViewById(R.id.User);
        life_cycle.setText("On create");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(Tag, "On Resume");
        setContentView(R.layout.activity_content);

        initComponent();
        life_cycle.setText("On Resume");
        String Name = getIntent().getStringExtra("name");
        tvNombre.setText(Name);
        initListener();
    }

    @Override
    protected void onPause() {
        super.onPause();
        setContentView(R.layout.activity_content);

        Log.i(Tag, "On Pause");
        life_cycle = (TextView) findViewById(R.id.User);
        life_cycle.setText("On Pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        setContentView(R.layout.activity_content);

        Log.i(Tag, "On Stop");
        life_cycle = (TextView) findViewById(R.id.User);
        life_cycle.setText("On Stop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        setContentView(R.layout.activity_content);

        Log.i(Tag, "On Destroy");
        life_cycle = (TextView) findViewById(R.id.User);
        life_cycle.setText("On Destroy");
    }

    private void initComponent() {
        life_cycle = (TextView) findViewById(R.id.User);
        tvNombre = (TextView) findViewById(R.id.tvName);
        btn_back = findViewById(R.id.btn_back);
    }

    private void initListener(){
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {;
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}