package com.example.a1027.hyunwoolee.mamber;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a1027.hyunwoolee.R;

import java.util.ArrayList;

/**
 * Created by 1027 on 2016-10-22.
 */

public class MemberAdapter extends BaseAdapter {
    ArrayList<MemberDTO> list;
    LayoutInflater inflater;
    private int[] photos = {
            R.drawable.cupcake,
            R.drawable.images,
            R.drawable.images2,
            R.drawable.images3,
            R.drawable.images4,
            R.drawable.images5,
            R.drawable.images6,
            R.drawable.images7,
            R.drawable.images8,
            R.drawable.images9
    };

    public MemberAdapter(Context context, ArrayList<MemberDTO> list){
        this.list = list;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View v, ViewGroup g) {
        VieHolder holder;
        if(v == null){
            v = inflater.inflate(R.layout.member_list,null);
            holder = new VieHolder();
            holder.ivPhoto = (ImageView) v.findViewById(R.id.iv_photo);
            holder.tvName = (TextView)v.findViewById(R.id.tv_name);
            holder.tvPhone = (TextView)v.findViewById(R.id.tv_phone);
            v.setTag(holder);
        }else{
            holder = (VieHolder) v.getTag();
        }
        Log.d("어댑터에서 체크 한 이름", list.get(i).getName());
        holder.ivPhoto.setImageResource(photos[i]);
        holder.tvName.setText(list.get(i).getName());
        holder.tvPhone.setText(list.get(i).getPhone());
        return v;
    }
    static class VieHolder{
        ImageView ivPhoto;
        TextView tvName;
        TextView tvPhone;
    }
}
