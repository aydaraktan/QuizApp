package kg.geektech.quizapp.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kg.geektech.quizapp.domain.main.entity.CategoryEntity
import kg.geektech.quizapp.domain.main.usecase.GetCategoryListUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val getCategoryListUseCase: GetCategoryListUseCase): ViewModel() {
    private val _categoryList = MutableStateFlow<List<CategoryEntity>>(mutableListOf())
    val categoryList: StateFlow<List<CategoryEntity>> get()= _categoryList

    init {
        fetchCategoryList()
    }

    private fun fetchCategoryList() {
        viewModelScope.launch {
            getCategoryListUseCase.invoke()
                .onStart {
                    setLoading()
                }
                .catch {
                    hideLoading()
                    showToast("Error")
                }
                .collect{
                    hideLoading()
                    _categoryList.value = it
                }
        }
    }

    private fun showToast(msg: String) {

    }

    private fun hideLoading() {

    }

    private fun setLoading() {

    }

}