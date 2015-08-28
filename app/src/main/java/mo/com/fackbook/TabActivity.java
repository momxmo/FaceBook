package mo.com.fackbook;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TabHost;

public class TabActivity extends android.app.TabActivity {
    TabHost mytabHost;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mytabHost = getTabHost();
        LayoutInflater.from(this).inflate(R.layout.activity_tar, mytabHost.getTabContentView(), true);

        mytabHost.setBackgroundColor(Color.argb(150, 22, 70, 150));

        mytabHost.addTab(mytabHost.newTabSpec("One").setIndicator("A", getResources()
                .getDrawable(R.drawable.music)).
                setContent(R.id.linearLayout_red));

        mytabHost.addTab(mytabHost.newTabSpec("Two").setIndicator("B", getResources()
                .getDrawable(R.drawable.music)).
                setContent(R.id.linearLayout_blue));

        mytabHost.addTab(mytabHost.newTabSpec("Tree").setIndicator("C", getResources()
                .getDrawable(R.drawable.music)).
                setContent(R.id.linearLayout_green));


    }
}
