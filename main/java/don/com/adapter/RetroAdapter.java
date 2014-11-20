package don.com.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import don.com.pojo.SPData;
import don.com.sp_retrofit.R;

/**
 * Created by new on 11/12/14.
 */
public class RetroAdapter extends ArrayAdapter<SPData> {

    //
    Context mContext;
    List<SPData> contributorsList;
    LayoutInflater mLayoutInflater;
    int Resource;
    ViewHolder holder;

    // Default RetroAdapter Constructor
    public RetroAdapter(Context context, int resource, List<SPData> contributors) {

        super(context, resource, contributors);

//        contributorsList = contributors;
        this.mContext = context;
        mLayoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        if(v == null) {
            holder = new ViewHolder();
            v = mLayoutInflater.inflate(Resource, parent, false);
            holder.itemTextView = (TextView) v.findViewById(R.id.nametv);
            holder.itemContributions = (TextView) v.findViewById(R.id.contributionstv);
            holder.itemImageView = (ImageView) v.findViewById(R.id.retroImage);

            v.setTag(holder);
        } else {
            holder = (ViewHolder)v.getTag();
        }

        SPData spData = super.getItem(position);

        holder.itemTextView.setText(spData.getName());
        holder.itemContributions.setText(spData.getContributions());

        Picasso.with(getContext())
                .load(spData.getImage())
                .into(holder.itemImageView);

        Animation anim = AnimationUtils.loadAnimation(getContext(), R.anim.basic_itemmotion);
        v.startAnimation(anim);

        return v;
    }

    static class ViewHolder {
        public TextView itemTextView;
        public TextView itemContributions;
        public ImageView itemImageView;
    }
}
