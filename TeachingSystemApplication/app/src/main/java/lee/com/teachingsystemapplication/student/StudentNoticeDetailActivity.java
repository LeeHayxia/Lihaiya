package lee.com.teachingsystemapplication.student;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import lee.com.teachingsystemapplication.R;

public class StudentNoticeDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_notice_detail);

        String date = getIntent().getStringExtra("date");
        String title = getIntent().getStringExtra("title");

        TextView dateText = (TextView)findViewById(R.id.dateText);
        TextView titleText = (TextView)findViewById(R.id.titleText);
        dateText.setText(date);
        titleText.setText(title);


    }

}
