package com.haier.verticalrollingview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.haier.verticalrollingview.verticalrollingview.DataSetAdapter;
import com.haier.verticalrollingview.verticalrollingview.VerticalRollingTextView;

import java.util.ArrayList;
import java.util.List;

public class VerticalRollingView extends Activity {

    private VerticalRollingTextView vertical_rolling_textview;
    private LinearLayout ll_message;
    private RelativeLayout activity_vertical_rolling_view;
    private List<MessageBean> messageTrue = new ArrayList<>();//实际显示的message
    private MessageBean messageBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertical_rolling_view);
        initDate();
        initView();
    }

    private void initView() {
        vertical_rolling_textview = (VerticalRollingTextView) findViewById(R.id.vertical_rolling_textview);
        ll_message = (LinearLayout) findViewById(R.id.ll_message);
        activity_vertical_rolling_view = (RelativeLayout) findViewById(R.id.activity_vertical_rolling_view);
        vertical_rolling_textview.setDataSetAdapter(new DataSetAdapter<MessageBean>(messageTrue) {

            @Override
            protected String text(MessageBean s) {
                return s.getMessagName();
            }
        });
        vertical_rolling_textview.run();
        vertical_rolling_textview.setOne(true);
        vertical_rolling_textview.setOnItemClickListener(new VerticalRollingTextView.OnItemClickListener() {
            @Override
            public void onItemClick(VerticalRollingTextView view, int index) {
                Toast.makeText(VerticalRollingView.this, "" + messageTrue.get(index).getMessagName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initDate() {
        for (int i = 0; i < 1; i++) {
            messageBean = new MessageBean();
            messageBean.setMessagName("自定义的练习" + i);
            messageTrue.add(messageBean);
        }
    }
}
