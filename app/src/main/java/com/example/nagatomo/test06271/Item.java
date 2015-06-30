package com.example.nagatomo.test06271;

/**
 * Created by Nagatomo on 2015/06/29.
 */
public class Item {
    public CharSequence mTitle;// 記事のタイトル
    private CharSequence mDescription;// 記事の本文
    private CharSequence mPubDate;// 記事の本文
    public Item() {
        mTitle = "";
        mDescription = "";
        mPubDate = "";
    }
    public CharSequence getDescription() {return mDescription;}
    public void setDescription(CharSequence description) {mDescription = description;}
    public CharSequence getTitle() {return mTitle;}
    public void setTitle(CharSequence title) {mTitle = title;}
    public CharSequence getPubDate() {return mPubDate;}
    public void setPubDate(CharSequence pubdate) {mPubDate = pubdate;}
}
