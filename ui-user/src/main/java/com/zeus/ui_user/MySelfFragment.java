package com.zeus.ui_user;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
//import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zeus.common.widget.NonScrollingGridView;
import com.zeus.skeleton.Skeleton;
import com.zeus.ui_user.activity.BookCollectionTabActivity;
import com.zeus.ui_user.activity.BookListLabelActivity;
import com.zeus.ui_user.activity.ExpressTimeLineActivity;
import com.zeus.ui_user.activity.UserFavoritesActivity;
import com.zeus.ui_user.activity.UserShoppingCartActivity;
import com.zeus.ui_user.activity.UserWelfareActivity;
import com.zeus.ui_user.adapter.WelfareAdapter;
import com.zeus.ui_user.interfaces.OnDragStateChangeListener;
import com.zeus.ui_user.model.Function;
import com.zeus.ui_user.view.InboxBackgroundScrollView;
import com.zeus.ui_user.view.InboxLayoutBase;
import com.zeus.ui_user.view.InboxLayoutListView;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by zeus_coder on 2015/10/31.
 */
public class MySelfFragment extends Fragment {

    private Button setting;
    private TextView allOrder;
    private Button payOrder;
    private Button deliverOrder;
    private Button receiveOrder;
    private Button commandOrder;
    private LinearLayout favorites;
    private LinearLayout shoppingCart;
    private LinearLayout welfare;

    //private ViewPager pager;
    private CircleImageView photo;
    //private NonScrollingGridView functionGridView;

    private InboxLayoutListView inboxLayoutListView;

    private List<Function> functions = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        System.out.print("_________________-moumoumoumou_____" + Skeleton.component().app());
        return inflater.inflate(R.layout.user_fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUIView(view);
    }

    @Override
    public void onResume() {
        super.onResume();
        //fillView();
    }

    private void initUIView(View view) {
        setting = (Button) view.findViewById(R.id.user_setting);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(getActivity(), ExpressTimeLineActivity.class));
                startActivity(new Intent(getActivity(), LogInActivity.class));
            }
        });

        favorites = (LinearLayout) view.findViewById(R.id.user_favorites);
        favorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), UserFavoritesActivity.class));
            }
        });

        shoppingCart = (LinearLayout) view.findViewById(R.id.user_shopping_cart);
        shoppingCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), UserShoppingCartActivity.class));
            }
        });

        welfare = (LinearLayout) view.findViewById(R.id.user_welfare);
        welfare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), UserWelfareActivity.class));
            }
        });

        photo = (CircleImageView) view.findViewById(R.id.user_profile_photo);
        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), BookListLabelActivity.class));
            }
        });

        allOrder = (TextView) view.findViewById(R.id.user_account_all_order);
        allOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), BookCollectionTabActivity.class).putExtra("position",0));
            }
        });

        payOrder = (Button)view.findViewById(R.id.user_account_pay);
        payOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), BookCollectionTabActivity.class).putExtra("position",1));
            }
        });

        deliverOrder = (Button)view.findViewById(R.id.user_account_deliver);
        deliverOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), BookCollectionTabActivity.class).putExtra("position",2));
            }
        });

        receiveOrder = (Button)view.findViewById(R.id.user_account_receive);
        receiveOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), BookCollectionTabActivity.class).putExtra("position",3));
            }
        });

        commandOrder = (Button)view.findViewById(R.id.user_account_command);
        commandOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), BookCollectionTabActivity.class).putExtra("position",4));
            }
        });
        //initFunctionView(view);
        initScrollView(view);
    }

    private void initScrollView(View view) {
        final InboxBackgroundScrollView inboxBackgroundScrollView = (InboxBackgroundScrollView) view.findViewById(R.id.user_profile_scroll_view);
        inboxLayoutListView = (InboxLayoutListView) view.findViewById(R.id.inboxlayout);
        inboxLayoutListView.setBackgroundScrollView(inboxBackgroundScrollView);//绑定scrollview
        inboxLayoutListView.setCloseDistance(50);
        inboxLayoutListView.setOnDragStateChangeListener(new OnDragStateChangeListener() {
            @Override
            public void dragStateChange(InboxLayoutBase.DragState state) {
                switch (state) {
                    case CANCLOSE:
                        //设置标题
                        break;
                    case CANNOTCLOSE:
                        //设置标题
                        break;
                }
            }
        });
        /*inboxLayoutListView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return 15;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                LayoutInflater inflater = getActivity().getLayoutInflater();
                View view = inflater.inflate(R.layout.user_setting_item, null);
                return view;
            }
        });*/
        inboxLayoutListView.setAdapter(new WelfareAdapter(getActivity()));
        initItem(view);
    }

    private void initItem(View view) {
        final LinearLayout zichan = (LinearLayout)view.findViewById(R.id.zichan);
        zichan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inboxLayoutListView.openWithAnim(zichan);
            }
        });

/*        final LinearLayout jifen = (LinearLayout)view.findViewById(R.id.jifen);
        jifen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inboxLayoutListView.openWithAnim(jifen);
            }
        });*/

        final LinearLayout tuijian = (LinearLayout)view.findViewById(R.id.tuijian);
        tuijian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inboxLayoutListView.openWithAnim(tuijian);
            }
        });

        final LinearLayout member = (LinearLayout)view.findViewById(R.id.member);
        member.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inboxLayoutListView.openWithAnim(member);
            }
        });

        final LinearLayout choujiang = (LinearLayout)view.findViewById(R.id.choujiang);
        choujiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inboxLayoutListView.openWithAnim(choujiang);
            }
        });

        final LinearLayout diyongquan = (LinearLayout)view.findViewById(R.id.diyongquan);
        diyongquan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inboxLayoutListView.openWithAnim(diyongquan);//bottom item set true
            }
        });
    }

    private void initFunctionView(View view) {
        int[] icons = { R.mipmap.user_function_item1,
                R.mipmap.user_function_item2,
                R.mipmap.user_function_item3,
                R.mipmap.user_function_item4,
                R.mipmap.user_function_item5,
                R.mipmap.user_function_item6,
                R.mipmap.user_function_item7,
                R.mipmap.user_function_item8 };
        for(int i = 0;i < 8;i++) {
            Function function = new Function();
            function.setName("收藏夹" + i);
            function.setTitle("帅气达人" + i);
            function.setIcon(icons[i]);
            functions.add(function);
        }
        //functionGridView = (NonScrollingGridView) view.findViewById(R.id.user_function_list);
        //functionGridView.setAdapter(new UserFunctionAdapter(getActivity(), functions));
    }

/*    private void fillView() {
        initTopBar(R.string.user_myself, 0);
    }*/

/*    private void initTopBar(int titleId, int rightStrId) {
        if(getView() == null) {
            return;
        }
        ((TextView)getView().findViewById(R.id.topbar_title)).setText(this.getString(titleId));
        getView().findViewById(R.id.leftBtn).setVisibility(View.GONE);
        TextView btnRight = (TextView)getView().findViewById(R.id.rightBtn);
        if(rightStrId == 0) {
            btnRight.setVisibility(View.GONE);
        } else {
            btnRight.setVisibility(View.VISIBLE);
            btnRight.setText(getResources().getString(rightStrId));
        }
    }*/


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}
