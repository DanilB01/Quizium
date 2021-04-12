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

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    //private final List<Quiz> quizList;
    private final List<RecyclerViewItem> itemList;
    private final LayoutInflater inflater;
    private final Context context;

    RecyclerViewDataTypeCode typeCode = new RecyclerViewDataTypeCode();

    RecyclerViewAdapter(Context context, List<RecyclerViewItem> itemList) {
        this.itemList = itemList;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == typeCode.TYPE_CATEGORY){
            View view = inflater.inflate(R.layout.item_category, parent, false);
            return new CategoryViewHolder(view);
        }
        else {
            View view = inflater.inflate(R.layout.item_quiz, parent, false);
            return new QuizViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(getItemViewType(position) == typeCode.TYPE_CATEGORY){
            CategoryViewHolder curHolder = (CategoryViewHolder)holder;
            curHolder.bind(itemList.get(position).getCategory());
        } else {
            QuizViewHolder curHolder = (QuizViewHolder)holder;
            curHolder.bind(itemList.get(position).getQuiz(), context);
        }
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (itemList.get(position).getTypeCode() == typeCode.TYPE_CATEGORY){
            return typeCode.TYPE_CATEGORY;
        } else {
          return typeCode.TYPE_QUIZ;
        }
    }

    public static class QuizViewHolder extends RecyclerView.ViewHolder{
        final ImageView previewPictureView;
        final TextView nameView, descriptionView, authorView;
        QuizViewHolder(View view) {
            super(view);
            previewPictureView = (ImageView) view.findViewById(R.id.quizLogoImageView);
            nameView = (TextView) view.findViewById(R.id.titleTextView);
            descriptionView = (TextView) view.findViewById(R.id.descriptionTextView);
            authorView = (TextView) view.findViewById(R.id.authorTextView);
        }
        public void bind(Quiz quiz, Context context){
            previewPictureView.setImageResource(quiz.getPreviewPicture());
            nameView.setText(quiz.getName());
            descriptionView.setText(quiz.getDescription());
            authorView.setText(String.format("%s %s", context.getString(R.string.author), quiz.getAuthor()));
        }
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder{
        final TextView categoryView;
        CategoryViewHolder(View view) {
            super(view);
            categoryView = (TextView) view.findViewById(R.id.quizCategoryTextView);
        }
        public void bind(Category category){
            categoryView.setText(category.getName());
        }
    }

}
