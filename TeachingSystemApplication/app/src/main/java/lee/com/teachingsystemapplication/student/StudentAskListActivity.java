package lee.com.teachingsystemapplication.student;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import lee.com.teachingsystemapplication.R;
import lee.com.teachingsystemapplication.TSABaseAdapter;

public class StudentAskListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_ask_list);

        ListView askList = (ListView)findViewById(R.id.askList);
        AskAdapter askAdapter = new AskAdapter(this);
        askList.setAdapter(askAdapter);
        askAdapter.addData(askList());

        askList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentAskListActivity.this,StudentAskActivity.class));
            }
        });
    }

    class AskItem{
        public String askTitle;
        public String askStatus;
    }

    class AskAdapter extends TSABaseAdapter<AskItem>{

        public AskAdapter(Activity context) {
            super(context);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = mLayoutInflater.inflate(R.layout.item_ask,null);
            AskItem item = getItem(position);
            TextView statusText = (TextView)convertView.findViewById(R.id.statusText);
            TextView titleText = (TextView)convertView.findViewById(R.id.titleText);
            statusText.setText(item.askStatus);
            titleText.setText(item.askTitle);

            return convertView;
        }
    }

    private List<AskItem> askList(){
        List<AskItem> list = new ArrayList<>();
        for(int i=1;i<100;i++){
            AskItem item = new AskItem();
            if(i%5==1){
                item.askStatus = "未回答";
            }else {
                item.askStatus = "已回答";
            }
            item.askTitle = "请问XXXXXXXXXXX"+i;
            list.add(item);
        }
        return list;
    }
}
