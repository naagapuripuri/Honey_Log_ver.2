package com.example.nagatomo.test06271;

/**
 * Created by Nagatomo on 2015/06/28.
 */
import android.app.FragmentTransaction;
import android.app.ActionBar.Tab;
import android.app.ActionBar;
import android.app.Fragment;



public class MyTabListener implements ActionBar.TabListener {
    private Fragment mFragment;

    // 新規タブを作成する際にフラグメントインスタンスを一緒に渡す
    public MyTabListener(Fragment fragment) {
        mFragment = fragment;
    }

    @Override
    public void onTabSelected(Tab tab, FragmentTransaction ft) {
        // タブが選択された時の処理
        // フラグメントを追加する
        ft.add(R.id.fragcontainer, mFragment, null);
    }

    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
        // タブが切り替えられた時の処理
        // フラグメントを削除する
        ft.remove(mFragment);
    }

    @Override
    public void onTabReselected(Tab tab, FragmentTransaction ft) {
        // 同じタブを再度タップされた時の処理
        // do nothing
    }
}