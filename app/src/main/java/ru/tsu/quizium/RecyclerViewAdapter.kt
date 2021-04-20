package ru.tsu.quizium

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter internal constructor(context: Context, //private final List<Quiz> quizList;
                                               private val itemList: List<RecyclerViewItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val inflater: LayoutInflater
    private val context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == RecyclerViewDataTypeCode.TYPE_CATEGORY) {
            val view = inflater.inflate(R.layout.item_category, parent, false)
            CategoryViewHolder(view)
        } else {
            val view = inflater.inflate(R.layout.item_quiz, parent, false)
            QuizViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == RecyclerViewDataTypeCode.TYPE_CATEGORY) {
            val curHolder = holder as CategoryViewHolder
            curHolder.bind(itemList[position].category)
        } else {
            val curHolder = holder as QuizViewHolder
            curHolder.bind(itemList[position].quiz, context)
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (itemList[position].typeCode == RecyclerViewDataTypeCode.TYPE_CATEGORY) {
            RecyclerViewDataTypeCode.TYPE_CATEGORY
        } else {
            RecyclerViewDataTypeCode.TYPE_QUIZ
        }
    }

    class QuizViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {
        val previewPictureView: ImageView
        val nameView: TextView
        val descriptionView: TextView
        val authorView: TextView
        fun bind(quiz: Quiz?, context: Context) {
            previewPictureView.setImageResource(quiz!!.previewPicture)
            nameView.text = quiz.name
            descriptionView.text = quiz.description
            authorView.text = String.format("%s %s", context.getString(R.string.author), quiz.author)
        }

        init {
            previewPictureView = view.findViewById<View>(R.id.quizLogoImageView) as ImageView
            nameView = view.findViewById<View>(R.id.titleTextView) as TextView
            descriptionView = view.findViewById<View>(R.id.descriptionTextView) as TextView
            authorView = view.findViewById<View>(R.id.authorTextView) as TextView
        }
    }

    class CategoryViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {
        private val categoryView: TextView = view.findViewById<View>(R.id.quizCategoryTextView) as TextView
        fun bind(category: Category?) {
            categoryView.text = category!!.name
        }

    }

    init {
        inflater = LayoutInflater.from(context)
        this.context = context
    }
}