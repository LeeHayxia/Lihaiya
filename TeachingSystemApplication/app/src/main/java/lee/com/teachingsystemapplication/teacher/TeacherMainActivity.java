package lee.com.teachingsystemapplication.teacher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import lee.com.teachingsystemapplication.R;

public class TeacherMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_main);
    }


    private long mLastOnBackPressedTime;
    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - mLastOnBackPressedTime > 1000) {
            Toast.makeText(this,getString(R.string.exit_app),Toast.LENGTH_LONG).show();
            mLastOnBackPressedTime = System.currentTimeMillis();
        } else {
            super.onBackPressed();
        }
    }
}
