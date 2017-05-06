package lee.com.teachingsystemapplication.student;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import lee.com.teachingsystemapplication.R;

public class StudentMainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_main);
        ((TextView)findViewById(R.id.titleText)).setText("学生系统");
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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_kaoqin:
                startActivity(new Intent(this,KaoqinActivity.class));
                break;
            case R.id.tv_student_info:
                startActivity(new Intent(this,StudentInfoActivity.class));
                break;
            case R.id.courseGradeText:
                startActivity(new Intent(this,CourseGradeActivity.class));
                break;
            case R.id.noticeTv:
                startActivity(new Intent(this,StudentNoticeListActivity.class));
                break;
            case R.id.applyLeaveText:
                startActivity(new Intent(this,StudentApplyLeaveActivity.class));
                break;
            case R.id.askText:
                startActivity(new Intent(this,StudentAskListActivity.class));
                break;
            default:
                Toast.makeText(this,"暂未开放，敬请期待",Toast.LENGTH_LONG).show();
                break;

        }
    }
}
