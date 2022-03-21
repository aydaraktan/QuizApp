package kg.geektech.quizapp.presentation.main

import android.util.Log
import android.widget.ArrayAdapter
import android.widget.SeekBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kg.geektech.quizapp.R
import kg.geektech.quizapp.databinding.FragmentMainBinding
import kg.geektech.quizapp.core.BaseFragment
import kg.geektech.quizapp.domain.main.entity.CategoryEntity
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>() {

    private val viewModel: MainViewModel by viewModels()


    override fun bind(): FragmentMainBinding {
        return FragmentMainBinding.inflate(layoutInflater)
    }



    override fun setupUi() {
        setupSpinnerDifficult()
    }

    override fun setupListeners() {
        binding.sbCount.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                binding.tvCountQs.text = p1.toString()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

        })

    }

    override fun setupObserver() {
        viewModel.categoryList.flowWithLifecycle(lifecycle, Lifecycle.State.STARTED).onEach {
            handleCategory(it)
        }.launchIn(lifecycleScope)
    }

    private fun handleCategory(categoryList: List<CategoryEntity>) {
        Log.e("TAG","handleCategory: 1 $categoryList")

        val listCategory:ArrayList<CategoryEntity> = ArrayList()
        listCategory.add(CategoryEntity(-1,"Any Categories"))

        categoryList.forEach {
            listCategory.add(it)
        }

        val adapter: ArrayAdapter<CategoryEntity> =
            ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_dropdown_item,
            listCategory
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spCategory.adapter = adapter



//        binding.spCategory.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
//            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
//
//            }
//
//            override fun onNothingSelected(p0: AdapterView<*>?) {
//
//            }
//
//        }
    }
    private fun setupSpinnerDifficult(){
        val listForDiffSpinner: ArrayList<String> = ArrayList()
        listForDiffSpinner.add("Any Difficulty")
        listForDiffSpinner.add("Easy")
        listForDiffSpinner.add("Medium")
        listForDiffSpinner.add("Hard")

        val adapter: ArrayAdapter<String> =
            ArrayAdapter(
                requireContext(),
                android.R.layout.simple_spinner_dropdown_item,
                listForDiffSpinner
            )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spDifficult.adapter = adapter

    }

}