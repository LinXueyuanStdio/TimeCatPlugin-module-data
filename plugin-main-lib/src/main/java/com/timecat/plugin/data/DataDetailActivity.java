package com.timecat.plugin.data;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.bin.david.form.core.SmartTable;
import com.tencent.shadow.sample.plugin.R;
import com.timecat.component.data.RouterHub;
import com.timecat.component.data.database.DB;

/**
 * @author dlink
 * @email linxy59@mail2.sysu.edu.cn
 * @date 2018/6/16
 * @discription 权限+喵密钥
 * @usage null
 */
@Route(path = RouterHub.Data_DataDetailActivity)
public class DataDetailActivity extends AppCompatActivity {

    @Autowired
    String title = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //    ARouter.getInstance().inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_activity_datadetail);

        setSupportActionBar(findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(title);

        SmartTable table = findViewById(R.id.table);
        table.setZoom(true);
        if ("任务".equals(title)) {
            table.setData(DB.schedules().findAllForActiveUser());
        } else if ("笔记".equals(title)) {
            table.setData(DB.notes().findAllForActiveUser());
        } else if ("笔记本".equals(title)) {
            table.setData(DB.notebooks().findAllForActiveUser());
        } else if ("计划".equals(title)) {
            table.setData(DB.plans().findAllForActiveUser());
        } else if ("子计划".equals(title)) {
            table.setData(DB.subPlans().findAllForActiveUser());
        } else if ("习惯".equals(title)) {
            table.setData(DB.habits().findAllForActiveUser());
        }
    }

}
