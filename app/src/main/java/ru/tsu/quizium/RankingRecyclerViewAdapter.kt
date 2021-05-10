package ru.tsu.quizium

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_category.view.*
import kotlinx.android.synthetic.main.item_quiz.view.*
import kotlinx.android.synthetic.main.item_ranking.view.*
import ru.tsu.quizium.dto.Category
import ru.tsu.quizium.dto.Quiz
import ru.tsu.quizium.dto.RankingItem
import ru.tsu.quizium.dto.RecyclerViewItem

class RankingRecyclerViewAdapter (
        private val context: Context,
        private val itemList: List<RankingItem>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val inflater: LayoutInflater = LayoutInflater.from(context)

    class ViewHolder(v: View): RecyclerView.ViewHolder(v)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = inflater.inflate(R.layout.item_ranking, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.rankingNameTextView.text = itemList[position].userName
        holder.itemView.rankingPointsTextView.text = itemList[position].point.toString()
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

}