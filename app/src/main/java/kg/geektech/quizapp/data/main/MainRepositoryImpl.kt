package kg.geektech.quizapp.data.main

import kg.geektech.quizapp.data.main.remote.MainApi
import kg.geektech.quizapp.domain.main.entity.CategoryEntity
import kg.geektech.quizapp.domain.main.repository.MainRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

open class MainRepositoryImpl @Inject constructor(private val mainApi: MainApi): MainRepository {
    override suspend fun getCategoryList(): Flow<List<CategoryEntity>> {
        return flow {
            val response = mainApi.getCategoryList()
            if(response.isSuccessful){
                val body = response.body()
                body?.triviaCategories?.let { emit(it) }
            }
        }
    }
}