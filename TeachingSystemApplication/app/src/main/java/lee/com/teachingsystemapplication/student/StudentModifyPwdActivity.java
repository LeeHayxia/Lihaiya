package lee.com.teachingsystemapplication.student;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import lee.com.teachingsystemapplication.R;

public class StudentModifyPwdActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText oldPwdEdit;
    private EditText newPwdEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_modify_pwd);

        oldPwdEdit = (EditText)findViewById(R.id.oldPwdEdit);
        newPwdEdit = (EditText)findViewById(R.id.newPwdEdit);
    }


    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.doneButton){
            if (checkPwd()){
                Toast.makeText(this,"修改成功",Toast.LENGTH_LONG).show();
                finish();
            }
        }else{
            finish();
        }
    }

    private boolean checkPwd(){
        String oldPwd = oldPwdEdit.getText().toString();
        if(TextUtils.isEmpty(oldPwd)||!oldPwd.equals("1234567")){
            oldPwdEdit.setError("旧密码输入错误");
            oldPwdEdit.requestFocus();
            return false;
        }
        String newPwd = newPwdEdit.getText().toString();
        if(TextUtils.isEmpty(newPwd)||newPwd.length()<6){
            newPwdEdit.setError("新密码长度不能少于6位");
            newPwdEdit.requestFocus();
            return false;
        }
        return true;
    }
}
