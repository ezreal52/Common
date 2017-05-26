package com.example.kshclf1.myapplication.adapter;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.kshclf1.myapplication.R;
import com.example.kshclf1.myapplication.fragment.AppFragment;
import com.example.kshclf1.myapplication.fragment.MainFragment;
import com.example.kshclf1.myapplication.fragment.MineFragment;
import com.example.kshclf1.myapplication.fragment.WorkFragment;

public class HomePageAdapter extends FragmentStatePagerAdapter {
    private Fragment[] fragments = new Fragment[] {new MainFragment(), new WorkFragment(), new AppFragment(), new MineFragment()};
    private int tabTitles[] = new int[]{ R.string.Main,
            R.string.Work,R.string.App, R.string.Mine}; //标题
    private int defaultImages[] = new int[]{R.drawable.icon_main, R.drawable.icon_work, R.drawable.icon_app, R.drawable.icon_mine}; //图片
    private int selectedImages[] = new int[]{R.drawable.icon_main_selected, R.drawable.icon_work_selected, R.drawable.icon_app_selected, R.drawable.icon_mine_selected};   //图片

    private Context context;

    public HomePageAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    /**
     * 设置底部导航栏子项样式
     *
     * @param position
     * @return
     */
    public View setTabView(int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_home_tab, null);
        TextView tv = (TextView) view.findViewById(R.id.txt);
        ImageView img = (ImageView) view.findViewById(R.id.img);

        tv.setTextColor(context.getResources().getColor(R.color.black));
        tv.setText(tabTitles[position]);
        img.setImageResource(defaultImages[position]);

        return view;
    }

    /**
     * 重置布局
     */
    public View resetView(View view, int position) {
        LayoutInflater.from(context).inflate(R.layout.layout_home_tab, null);
        TextView tv = (TextView) view.findViewById(R.id.txt);
        ImageView img = (ImageView) view.findViewById(R.id.img);

        tv.setTextColor(context.getResources().getColor(R.color.black));
        img.setImageResource(defaultImages[position]);
        return view;
    }

    /**
     * 选择布局
     *
     * @param position
     */
    public View selectView(View view, int position) {
        TextView tv = (TextView) view.findViewById(R.id.txt);
        ImageView img = (ImageView) view.findViewById(R.id.img);

        tv.setTextColor(context.getResources().getColor(R.color.colorPrimary));
        img.setImageResource(selectedImages[position]);
        return view;
    }
}

