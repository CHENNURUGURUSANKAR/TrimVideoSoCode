package com.gurusankar149.trimevideotutorial;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import static com.gurusankar149.trimevideotutorial.Database.allVideoList;

public class AllExistingVideosAdapter extends RecyclerView.Adapter<AllExistingVideosAdapter.ViewHolder> {
    Context mcontext;

    AllExistingVideosAdapter(Context mcontext) {
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.videoitem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Uri videouri = Uri.fromFile(allVideoList.get(position));
        Glide.with(mcontext).load(videouri).thumbnail().into(holder.thumbnail);

        MediaPlayer mediaPlayer = MediaPlayer.create(holder.thumbnail.getContext(), videouri);
        int duration = mediaPlayer.getDuration() / 1000;
        int hr = duration / 3600;
        int rem = duration % 3600;
        int min = rem / 60;
        int sec = rem % 60;
        String time = String.format("%02d", hr) + ":" + String.format("%02d", min) + ":" + String.format("%02d", sec);
        holder.duration.setText(time);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(holder.thumbnail.getContext(), TrimVideoActivty.class);
                intent.putExtra(MainActivity.VideoUri, videouri.toString());

                holder.thumbnail.getContext().startActivity(intent);
            }
        });


    }


    @Override
    public int getItemCount() {
        return allVideoList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView thumbnail;
        TextView duration;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            thumbnail = itemView.findViewById(R.id.thumbnail);
            duration = itemView.findViewById(R.id.video_duration);
        }
    }

}
