import com.google.gson.annotations.SerializedName

data class HeadlinesResponse(

	@SerializedName("status") val status : String,
	@SerializedName("totalResults") val totalResults : Int,
	@SerializedName("articles") val articles : List<Articles>
)