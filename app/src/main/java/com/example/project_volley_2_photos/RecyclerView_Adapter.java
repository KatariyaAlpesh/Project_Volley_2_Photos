package com.example.project_volley_2_photos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.helper.widget.Layer;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerView_Adapter extends RecyclerView.Adapter<RecyclerView_Adapter.Myclass>
{

    Context context;
    ArrayList<DataModel> arrayListDataModel;

    public RecyclerView_Adapter(Context context, ArrayList<DataModel> arrayListDataModel)
    {

        this.context = context;
        this.arrayListDataModel = arrayListDataModel;

    }

    public class Myclass extends RecyclerView.ViewHolder
    {
        TextView textViewalbum , textViewid ;
        TextView textViewurl , textViewtitle;
        ImageView imageViewphoto;

        public Myclass(@NonNull View itemView)
        {
            super(itemView);

            textViewid = itemView.findViewById(R.id.TextViewId);
            textViewalbum = itemView.findViewById(R.id.TextViewAlbum);
            textViewurl = itemView.findViewById(R.id.TextViewUrl);
            textViewtitle = itemView.findViewById(R.id.TextViewTitle);
            imageViewphoto = itemView.findViewById(R.id.ImageViewPhotoId);

        }
    }
    @NonNull
    @Override
    public Myclass onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_item_page , parent , false);

        Myclass M = new Myclass(view);

        return M;
    }

    @Override
    public void onBindViewHolder(@NonNull Myclass holder, int position)
    {
        holder.textViewalbum.setText("" + arrayListDataModel.get(position).getAlbumId());
        holder.textViewid.setText("" + arrayListDataModel.get(position).getId());
        holder.textViewurl.setText(arrayListDataModel.get(position).getUrl());
        holder.textViewtitle.setText(arrayListDataModel.get(position).getTitle());

        Glide.with(context).load(arrayListDataModel.get(position).getThumbnailUrl()).into(holder.imageViewphoto);
        Picasso.get().load(arrayListDataModel.get(position).getThumbnailUrl()).placeholder(R.drawable.image_loader).into(holder.imageViewphoto);

    }

    @Override
    public int getItemCount()
    {
        return arrayListDataModel.size();
    }

}
