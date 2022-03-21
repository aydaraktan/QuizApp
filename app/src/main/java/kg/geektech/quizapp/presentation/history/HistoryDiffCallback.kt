package kg.geektech.quizapp.presentation.history

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil

class HistoryDiffCallback: DiffUtil.ItemCallback<HistoryEntity>() {
    override fun areItemsTheSame(oldItem: HistoryEntity, newItem: HistoryEntity)=oldItem.id == newItem.id

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: HistoryEntity, newItem: HistoryEntity )= oldItem == newItem
}