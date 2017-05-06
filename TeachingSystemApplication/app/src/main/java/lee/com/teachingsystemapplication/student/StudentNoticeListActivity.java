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
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import lee.com.teachingsystemapplication.R;
import lee.com.teachingsystemapplication.TSABaseAdapter;

public class StudentNoticeListActivity extends AppCompatActivity {

    ListView mNoticeList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_notice_list);

        mNoticeList = (ListView)findViewById(R.id.noticeList);
        final NoticeAdapter noticeAdapter = new NoticeAdapter(this);
        mNoticeList.setAdapter(noticeAdapter);
        noticeAdapter.addData(noticeListData());
        mNoticeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                NoticeItem item = noticeAdapter.getItem(position);
                Intent intent = new Intent(StudentNoticeListActivity.this,StudentNoticeDetailActivity.class);
                intent.putExtra("title",item.titleString);
                intent.putExtra("date",item.dateString);
                startActivity(intent);
            }
        });
    }

    public class NoticeItem {
        public String dateString;
        public String titleString;
    }

    class NoticeAdapter extends TSABaseAdapter<NoticeItem>{
        private Activity activity;

        public NoticeAdapter(Activity context) {
            super(context);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = mLayoutInflater.inflate(R.layout.item_notice,null);
            TextView dateText = (TextView)convertView.findViewById(R.id.dateText);
            TextView titleText = (TextView)convertView.findViewById(R.id.titleText);

            NoticeItem item = getItem(position);
            dateText.setText(item.dateString);
            titleText.setText(item.titleString);

            return convertView;
        }
    }

    private List<NoticeItem> noticeListData(){
        List<NoticeItem> list = new ArrayList<>();

        for(int i = 1;i<51;i++){
            NoticeItem item = new NoticeItem();
            switch (i/10){
                case 1:
                    item.dateString = "2017.5.4";
                    break;
                case 2:
                    item.dateString = "2017.5.2";
                    break;
                case 3:
                    item.dateString = "2017.5.1";
                    break;
                case 4:
                    item.dateString = "2017.4.29";
                    break;
                case 5:
                    item.dateString = "2017.4.25";
                    break;
                default:
                    item.dateString = "2017.5.10";
                    break;
            }
            item.dateString = "2017.4.10";
            item.titleString = "浙江工业大学计算机学院公告"+i;
            list.add(item);
        }

        return list;
    }

}
