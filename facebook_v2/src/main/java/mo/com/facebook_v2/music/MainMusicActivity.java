package mo.com.facebook_v2.music;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import mo.com.facebook_v2.R;

/**
 * Created by Administrator on 2015/8/25.
 */
public class MainMusicActivity  extends ActionBarActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_ui_main);

        // 设置ToolBar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // Title
        toolbar.setTitle("Toolbar的标题");
        // App Logo
        // toolbar.setLogo(R.drawable.ic_launcher);
        // Sub Title
//		toolbar.setSubtitle("Sub title");

        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        // Navigation Icon 要設定在 setSupoortActionBar 才有作用
        // 否則會出現 back button
        toolbar.setNavigationIcon(R.drawable.perm_group_system_tools);

        // 打開 up button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        // 實作 drawer toggle 並放入 toolbar
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.drawer_open,
                R.string.drawer_close);
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        //在左边栏中使用打气筒的方式添加元素
//        LinearLayout drawer_view = (LinearLayout) findViewById(R.id.drawer_view);
//        View.inflate(this,R.layout.item_musicui_main,null);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
