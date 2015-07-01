package com.example.nagatomo.test06271;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class FragListAdapter extends ArrayAdapter<Item> {
    private LayoutInflater mInflater;
    //コンストラクタ
    public FragListAdapter(Context context, List<Item> objects) {//ArrayAdapter クラスのコンストラクターで、使わない引数（textViewResourceId）の分を除いたコンストラクターを作っておく。基本的に、オブジェクトのリストか、オブジェクトの配列を受け取れるようにすればよい。
        super(context, 0, objects);// 第2引数はtextViewResourceIdとされていますが、カスタムリストアイテムを使用する場合は特に意識する必要のない引数です。ArrayAdapter クラスのコンストラクターを呼び出す。このとき、textViewResourceId は指定されていないので、0 にしておく。
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);// レイアウトXML自体をソースコード上にViewとして、 システムサービスからLayoutInflaterを取得
    }

    // 1行ごとのビューを生成する
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (convertView == null) {// ListViewに表示する分のレイアウトが生成されていない場合レイアウトを作成する。convertViewは使い回しされている可能性があるのでnullの時だけ新しく作る。convertViewがnullだった場合のみLayoutInflaterを利用して、activity_itemrow.xmlからビューを取得する
            view = mInflater.inflate(R.layout.activity_itemrow, null);
        }

        Item item = this.getItem(position);    // position行目のデータを取得する。特定の行(position)のデータを得る// 現在参照しているリストの位置からItemを取得する
        if (item != null) {

            TextView textView = (TextView)view.findViewById(R.id.item_title);
            textView.setText(item.getTitle());
            textView.setTextSize(11);
            textView.setHeight(11);
            textView.setMinimumHeight(11);
            textView.setTextColor(Color.parseColor("blue"));
            TextView textView2 = (TextView)view.findViewById(R.id.item_pubdate);
            textView2.setText(item.getURL());
            TextView textView3 = (TextView)view.findViewById(R.id.item_descr);
            textView3.setText(item.getDescription());


        }
        return view;//viewを返す
    }
}
