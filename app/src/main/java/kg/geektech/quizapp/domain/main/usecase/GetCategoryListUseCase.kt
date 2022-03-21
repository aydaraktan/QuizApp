package kg.geektech.quizapp.domain.main.usecase

import kg.geektech.quizapp.domain.main.entity.CategoryEntity
import kg.geektech.quizapp.domain.main.repository.MainRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCategoryListUseCase @Inject constructor(private val repository: MainRepository) {
    suspend fun invoke(): Flow<List<CategoryEntity>> = repository.getCategoryList()
}