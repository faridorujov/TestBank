package com.ofarido.testbank;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

public class ExpandableListViewAdapter extends BaseExpandableListAdapter {

    String[] years = {"2018", "2017", "2016","2015","2014","2013","2012","2011","2010","2009","2008","2007",
    "2006","2005","2004","2003","2002","2001","2000","1999","1998","1997","1996"};
    String[][] examName = {{"Sınaq imtahanı 1", "Sınaq imtahanı 2", "Qəbul imtahanı"}, {"a", "b"}, {"a", "b"}};

    Context context;

    public ExpandableListViewAdapter(Context context) {
        this.context = context;

    }

    @Override
    public int getGroupCount() {
        return years.length;
    }

    @Override
    public int getChildrenCount(int i) {
        return examName[i].length;
    }

    @Override
    public Object getGroup(int i) {
        return years[i];
    }

    @Override
    public Object getChild(int i, int i1) {
        return examName[i][i1];
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {

        View v = view;

        if(v == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.grouplistlayout, viewGroup, false);
        }

        TextView year_textView = v.findViewById(R.id.year_tv);
        year_textView.setText(years[i]);

        if(b){
            year_textView.setTypeface(null, Typeface.NORMAL);
            year_textView.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_action_up, 0);

        } else {
            year_textView.setTypeface(null, Typeface.NORMAL);
            year_textView.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_action_down, 0);
        }

        return v;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        TextView textView = new TextView(context);
        textView.setText(examName[i][i1]);
        textView.setPadding(48, 48, 48, 48);
        textView.setTextColor(ContextCompat.getColor(context, R.color.colorSecondary));
        textView.setTextSize(24);
        return textView;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
