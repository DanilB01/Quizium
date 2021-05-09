package ru.tsu.quizium

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_quiz.view.*
import kotlinx.android.synthetic.main.item_category.view.*

class RecyclerViewAdapter (
        private val context: Context,
        private val itemList: List<RecyclerViewItem>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == AppConst.TYPE_CATEGORY) {
            val view = inflater.inflate(R.layout.item_category, parent, false)
            CategoryViewHolder(view)
        } else {
            val view = inflater.inflate(R.layout.item_quiz, parent, false)
            QuizViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == AppConst.TYPE_CATEGORY) {
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
        return if (itemList[position].typeCode == AppConst.TYPE_CATEGORY) {
            AppConst.TYPE_CATEGORY
        } else {
            AppConst.TYPE_QUIZ
        }
    }

    class QuizViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(quiz: Quiz?, context: Context) {
            val picId = context.resources.getIdentifier(quiz?.pictureName, "drawable", context.packageName)
            itemView.quizLogoImageView.setImageDrawable(context.resources.getDrawable(picId))
            itemView.titleTextView.text = quiz?.name
            itemView.descriptionTextView.text = quiz?.description
            itemView.authorTextView.text = String.format("%s %s", context.getString(R.string.author), quiz?.author)
            itemView.cardView.setOnClickListener {
                CurrentQuiz.quiz = quiz!!
                val intent = Intent(context, QuizStartActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                context.startActivity(intent)
            }
        }

    }

    class CategoryViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(category: Category?) {
            itemView.quizCategoryTextView.text = category!!.name
        }

    }

}