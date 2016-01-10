package com.zeus.bookcase.app.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.quinny898.library.persistentsearch.SearchBox;
import com.quinny898.library.persistentsearch.SearchResult;
import com.zeus.bookcase.R;
import com.zeus.common.menu.DropDownMenu;
import com.zeus.common.menu.OnMenuSelectedListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zeus_coder on 2015/12/3.
 */
public class BookSearchActivity extends Activity {

    private SearchBox search;
    private DropDownMenu menu;
    private ListView list;

    //填充数据
    private int city_index;
    private int sex_index;
    private int age_index;
    private List<String> data;
    final String[] arr1=new String[]{"综合排序","价格从低到高","价格从高到低","信用排序"};
    final String[] arr2=new String[]{"销量优先","距离优先"};
    final String[] arr3=new String[]{"筛选","价格区间","折扣和服务","发货地","分类"};

    final String[] strings=new String[]{"综合排序","销量优先","筛选"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app__activity_search);
        search = (SearchBox) findViewById(R.id.searchbox);
        search.enableVoiceRecognition(this);
        setSearchSetting();

        //筛选
        menu = (DropDownMenu) findViewById(R.id.choose_menu);
        setMenuSetting();

    }

    private void setMenuSetting() {
        menu.setmMenuCount(3);
        menu.setmShowCount(5);
        menu.setShowCheck(true);
        menu.setmMenuTitleTextSize(16);
        menu.setmMenuTitleTextColor(Color.parseColor("#777777"));
        menu.setmMenuListTextSize(16);
        menu.setmMenuListTextColor(Color.BLACK);
        menu.setmMenuBackColor(Color.parseColor("#eeeeee"));
        menu.setmMenuPressedBackColor(Color.WHITE);
        menu.setmMenuPressedTitleTextColor(Color.BLACK);

        menu.setmCheckIcon(R.mipmap.icon_make);

        menu.setmUpArrow(R.mipmap.arrow_up);
        menu.setmDownArrow(R.mipmap.arrow_down);

        menu.setDefaultMenuTitle(strings);


        menu.setShowDivider(false);
        menu.setmMenuListBackColor(getResources().getColor(R.color.white));
        menu.setmMenuListSelectorRes(R.color.white);
        menu.setmArrowMarginTitle(20);

        menu.setMenuSelectedListener(new OnMenuSelectedListener() {
            @Override
            public void onSelected(View listview, int RowIndex, int ColumnIndex) {
                Log.i("BookSearchActivity", "select " + ColumnIndex + " column and " + RowIndex + " row");
                if (ColumnIndex == 0) {
                    city_index = RowIndex;
                } else if (ColumnIndex == 1) {
                    sex_index = RowIndex;
                } else {
                    age_index = RowIndex;
                }
                //过滤筛选
                setFilter();
            }
        });
        List<String[]> items = new ArrayList<>();
        items.add(arr1);
        items.add(arr2);
        items.add(arr3);
        menu.setmMenuItems(items);

//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                List<String[]> items = new ArrayList<>();
//                items.add(arr1);
//                items.add(arr2);
//                items.add(arr3);
//                mMenu.setmMenuItems(items);
//
//            }
//        }, 1000);

        menu.setIsDebug(false);

        list=(ListView)findViewById(R.id.lv_list);
        data=getData();
        list.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, data));
    }

    private void setFilter(){
        List<String> temp=new ArrayList<String>();
        for (int i=0;i<getData().size();i++){
            boolean city=((city_index==0)?true:data.get(i).contains(arr1[city_index]));
            boolean sex=((sex_index==0)?true:data.get(i).contains(arr2[sex_index]));
            boolean age=((age_index==0)?true:data.get(i).contains(arr3[age_index]));
            if(city && sex && age){
                temp.add(data.get(i));
            }
        }
        list.setAdapter(new ArrayAdapter<String>(BookSearchActivity.this, android.R.layout.simple_expandable_list_item_1,temp));
    }

    private List<String> getData(){
        List<String> data = new ArrayList<String>();
        data.add("上海－男－10");
        data.add("上海－男－20");
        data.add("上海－男－30");
        data.add("上海－男－40");
        data.add("上海－男－50");
        data.add("上海－男－60");
        data.add("上海－男－70");
        data.add("广州－男－10");
        data.add("广州－女－10");
        data.add("北京－男－20");
        data.add("北京－女－10");
        data.add("广州－男－10");
        data.add("北京－男－10");
        data.add("广州－男－10");
        data.add("上海－女－60");
        data.add("上海－女－20");
        return data;
    }

    private void setSearchSetting() {
        //填充历史记录
        for(int x = 0; x < 10; x++){
            SearchResult option = new SearchResult("Result " + Integer.toString(x), getResources().getDrawable(R.mipmap.ic_history));
            search.addSearchable(option);
        }

        //menu设置
        search.setMenuListener(new SearchBox.MenuListener() {
            @Override
            public void onMenuClick() {
                //Hamburger has been clicked
                Toast.makeText(BookSearchActivity.this, "Menu click", Toast.LENGTH_LONG).show();
            }
        });

        //搜索监听事件
        search.setSearchListener(new SearchBox.SearchListener() {

            @Override
            public void onSearchOpened() {
                //Use this to tint the screen
            }

            @Override
            public void onSearchClosed() {
                //Use this to un-tint the screen
            }

            @Override
            public void onSearchTermChanged(String term) {
                //React to the search term changing
                //Called after it has updated results
            }

            @Override
            public void onSearch(String searchTerm) {
                Toast.makeText(BookSearchActivity.this, searchTerm + " Searched", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onResultClick(SearchResult result) {
                //React to a result being clicked
            }

            @Override
            public void onSearchCleared() {
                //Called when the clear button is clicked
            }

        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1234 && resultCode == RESULT_OK) {
            ArrayList<String> matches = data
                    .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            search.populateEditText(matches.get(0));
        }
        super.onActivityResult(requestCode, resultCode, data);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
