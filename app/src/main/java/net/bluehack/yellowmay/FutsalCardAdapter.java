package net.bluehack.yellowmay;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by k_bluehack on 2016. 9. 27..
 */

public class FutsalCardAdapter extends RecyclerView.Adapter<FutsalCardViewHolder> {

    private Context context;
    private ArrayList<FutsalItem> futsalItemList; //TODO : 서버에서 받아온 데이터 폼이 FutsalItem 형태로 보낼 예정

    public FutsalCardAdapter(Context context, ArrayList<FutsalItem> futsalItemList) {
        this.context = context;
        this.futsalItemList = futsalItemList;
    }

    @Override
    public FutsalCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.futsal_cardview, null);
        return new FutsalCardViewHolder(v);
    }

    @Override
    public void onBindViewHolder(FutsalCardViewHolder holder, int position) {

        final FutsalItem item = futsalItemList.get(position);

        holder.futsalImage.setBackground(ContextCompat.getDrawable(context,item.getImg()));
        holder.futsalName.setText(item.getName());
        holder.futsalDistance.setText(item.getDistance());
        holder.futsalCharge.setText(item.getCharge());

        holder.futsalCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.d(TAG,"onClick event !!!");
                Intent intent = new Intent(context, DetailFieldActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivities(new Intent[]{intent});

            }
        });
    }

    @Override
    public int getItemCount() {
        return this.futsalItemList.size();
    }
}
