package com.timecat.plugin.data;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bin.david.form.core.SmartTable;
import com.timecat.identity.readonly.RouterHub;
import com.timecat.data.system.database.DB;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dlink
 * @email linxy59@mail2.sysu.edu.cn
 * @date 2018/6/16
 * @description 权限+喵密钥
 * @usage null
 */
@Route(path = RouterHub.Data_DataDetailActivity)
public class DataDetailActivity extends AppCompatActivity {

    @Autowired
    String title = "任务";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        ARouter.getInstance().inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_activity_datadetail);

        setSupportActionBar(findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(title);

        SmartTable table = findViewById(R.id.table);
        table.setZoom(true);
        List a = new ArrayList();
        if ("任务".equals(title)) {
            a = DB.schedules().findAll();
        } else if ("笔记".equals(title)) {
            a = DB.notes().findAll();
        } else if ("笔记本".equals(title)) {
            a = DB.notebooks().findAll();
        } else if ("计划".equals(title)) {
            a = DB.plans().findAll();
        } else if ("子计划".equals(title)) {
            a = DB.subPlans().findAll();
        } else if ("习惯".equals(title)) {
            a = DB.habits().findAll();
        }
        if (a == null) a = new ArrayList();
        Log.e("plugin-module-data", "size: " + a.size());
        Log.e("plugin-module-data", "data: " + a);
        table.setData(a);
    }

}
