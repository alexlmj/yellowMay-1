package net.bluehack.yellowmay;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by k_bluehack on 2016. 9. 27..
 */

public class FutsalCardViewHolder extends RecyclerView.ViewHolder {

    CardView futsalCardView;
    ImageView futsalImage;
    TextView futsalName;
    TextView futsalDistance;
    TextView futsalCharge;

    public FutsalCardViewHolder(View view) {
        super(view);

        futsalCardView = (CardView)view.findViewById(R.id.futsal_card_view);
        futsalImage = (ImageView)view.findViewById(R.id.futsal_image);
        futsalName = (TextView)view.findViewById(R.id.futsal_name);
        futsalDistance = (TextView)view.findViewById(R.id.futsal_distance);
        futsalCharge = (TextView)view.findViewById(R.id.futsal_charge);
    }
}
