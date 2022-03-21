package kg.geektech.quizapp.presentation.history

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kg.geektech.quizapp.databinding.FragmentHistoryBinding
import kg.geektech.quizapp.databinding.ItemForHistoryFragmentBinding

class HistoryAdapter():
    ListAdapter<HistoryEntity, HistoryAdapter.ViewHolder>(HistoryDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemForHistoryFragmentBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val history = getItem(position)
        holder.bind(history)
    }


    class ViewHolder(private val binding: ItemForHistoryFragmentBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(history: HistoryEntity) {
            binding.tvCategoryName.text = history.category
            binding.tvCorrectAnswers.text = history.correctAnswer
            binding.tvDifficulty.text = history.difficulty
            binding.tvDate.text = history.date
        }

    }
}