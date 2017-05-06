package lee.com.teachingsystemapplication.student;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import lee.com.teachingsystemapplication.R;

public class StudentAskActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_ask);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.okButton:
                Toast.makeText(this,"提问成功！",Toast.LENGTH_LONG).show();
                onBackPressed();
                break;
            case R.id.cancelButton:
                onBackPressed();
                break;
        }
    }

}
