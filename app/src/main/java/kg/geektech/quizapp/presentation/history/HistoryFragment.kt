package kg.geektech.quizapp.presentation.history

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kg.geektech.quizapp.R
import kg.geektech.quizapp.core.BaseFragment
import kg.geektech.quizapp.databinding.FragmentHistoryBinding

class HistoryFragment : BaseFragment<FragmentHistoryBinding>() {
private lateinit var adapter: HistoryAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    private fun initAdapter() {
        adapter = HistoryAdapter()
        binding.rvHistory.layoutManager = LinearLayoutManager(requireContext())
        binding.rvHistory.adapter = adapter

        val list:ArrayList<HistoryEntity> = ArrayList()
        for(i in 0..5){
            list.add(
                HistoryEntity(  i,
                    "Category: Mixed $i",
                    "Correct answers: $i/10",
                    "Difficulty: Easy ",
                    "21 mart 2022 20:32")
            )
        }
        adapter.submitList(list)

    }

    override fun bind(): FragmentHistoryBinding {
        return  FragmentHistoryBinding.inflate(layoutInflater)
    }

    override fun setupUi() {

    }

    override fun setupListeners() {

    }

    override fun setupObserver() {
    }

}