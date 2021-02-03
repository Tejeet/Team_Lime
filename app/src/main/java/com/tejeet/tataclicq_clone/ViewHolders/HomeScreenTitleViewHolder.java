package com.tejeet.tataclicq_clone.ViewHolders;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tejeet.tataclicq_clone.DataNModels.ModelTopHeaderImages;
import com.tejeet.tataclicq_clone.R;

public class HomeScreenTitleViewHolder extends RecyclerView.ViewHolder {

    private static final String TAG = "tag";
    private ImageView mImageTitle;

    public HomeScreenTitleViewHolder(@NonNull View itemView) {
        super(itemView);

        mImageTitle = itemView.findViewById(R.id.ivtopImages);

    }

    public void setData(ModelTopHeaderImages data){

        Log.d(TAG, "Data is "+data.getImageID());
        mImageTitle.setImageResource(data.getImageID());

    }
}
