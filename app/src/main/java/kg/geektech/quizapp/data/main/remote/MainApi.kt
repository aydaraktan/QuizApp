package kg.geektech.quizapp.data.main.remote

import kg.geektech.quizapp.domain.main.entity.CategoryEntityResponse
import retrofit2.Response
import retrofit2.http.GET

interface MainApi {
    @GET("api_category.php")
    suspend fun getCategoryList(): Response<CategoryEntityResponse>
}