import com.example.cardinfofinder.Domain.Result
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface ApiService {
//    @GET("posts/{id}")
//    fun getPostById(@Path("id") postId: Int): Call<Post>

    @Headers(
        "X-RapidAPI-Key: e961a94fd7msh2f2a850403935e3p16f845jsn269ae8c8012b",
        "X-RapidAPI-Host: binlist.p.rapidapi.com", "Accept: application/json")
    @GET("json/{number}")
    fun fetchCardNumberResults(@Path("number") cardNumber: String) : Call<Result>
}