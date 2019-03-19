package kr.co.woobi.imyeon.callbackinfragmentreview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private FragmentColor mFragmentColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final FragmentColorList fragementList = (FragmentColorList) getSupportFragmentManager().findFragmentById(R.id.fragmentList);

        mFragmentColor = (FragmentColor) getSupportFragmentManager().findFragmentById(R.id.fragmnetColor);
        mFragmentColor.setColor(Color.GRAY);

        fragementList.setOnSelectListener(new FragmentColorList.onSelectListener() {
            @Override
            public void onSelectColor(int position) {
                String colorString = fragementList.mRecyclerAdapter.mItem.get(position);
                int color = Color.GRAY;
                switch (colorString) {
                    case "Red":
                        color = Color.RED;
                        break;
                    case "Green":
                        color = Color.GREEN;
                        break;
                    case "Blue":
                        color = Color.BLUE;
                        break;
                }
                mFragmentColor.setColor(color);
            }
        });
    }
}
