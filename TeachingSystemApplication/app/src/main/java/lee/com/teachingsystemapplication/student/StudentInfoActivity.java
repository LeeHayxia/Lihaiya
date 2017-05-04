package lee.com.teachingsystemapplication.student;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import lee.com.teachingsystemapplication.R;

public class StudentInfoActivity extends AppCompatActivity {

    private boolean mShowTypeEdit = false;
    private LinearLayout mViewEdit;
    private EditText mAddressEdit;
    private EditText mPhoneEdit;
    private Button mButtonEdit;

    private String mDefaultAddress = "浙江省台州市三门县XX镇XX村01#";
    private String mDefaultPhone = "13509384754";
    private boolean mShowEdit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);

        mViewEdit = (LinearLayout)findViewById(R.id.viewEdit);
        mAddressEdit = (EditText)findViewById(R.id.addressEdit);
        mPhoneEdit = (EditText)findViewById(R.id.phoneEdit);
        mButtonEdit = (Button)findViewById(R.id.buttonEdit);

        mAddressEdit.setText(mDefaultAddress);
        mPhoneEdit.setText(mDefaultPhone);

    }

    private void showChange(){
        mViewEdit.setVisibility(mShowEdit?View.VISIBLE:View.GONE);
        mAddressEdit.setEnabled(mShowEdit);
        mPhoneEdit.setEnabled(mShowEdit);
        mButtonEdit.setVisibility(mShowEdit?View.GONE:View.VISIBLE);
    }

    public void onEditClick(View v){
        mShowEdit = true;
        showChange();
    }

    public void onEditCancelClick(View v){
        mAddressEdit.setText(mDefaultAddress);
        mPhoneEdit.setText(mDefaultPhone);
        mShowEdit =false;
        showChange();
    }

    public void onEditDoneClick(View v){
        mDefaultAddress = mAddressEdit.getText().toString();
        mDefaultPhone = mPhoneEdit.getText().toString();
        mShowEdit =false;
        showChange();
    }

    public void onModifyPasswordClick(View v){
        startActivity(new Intent(this,StudentModifyPwdActivity.class));
    }
}
