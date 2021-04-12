package ru.tsu.quizium;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private final List<Quiz> quizList;
    private final LayoutInflater inflater;

    RecyclerViewAdapter(Context context, List<Quiz> quizList) {
        this.quizList = quizList;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView previewPictureView;
        final TextView nameView, descriptionView, authorView;
        ViewHolder(View view){
            super(view);
            previewPictureView = (ImageView) view.findViewById(R.id.quizLogoImageView);
            nameView = (TextView) view.findViewById(R.id.titleTextView);
            descriptionView = (TextView) view.findViewById(R.id.descriptionTextView);
            authorView = (TextView) view.findViewById(R.id.quizAuthorTextView);
        }
    }
}
