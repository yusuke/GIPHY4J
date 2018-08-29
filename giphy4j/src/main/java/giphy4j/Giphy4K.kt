package giphy4j

import com.squareup.moshi.JsonReader
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import okio.Okio
import java.net.URL

open class Giphy4K(private val apiKey:String) {
    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build().adapter(__Giphy4KInternal::class.java)
    private val moshi2 = Moshi.Builder().add(KotlinJsonAdapterFactory()).build().adapter(__Giphy4KInternal2::class.java)


    /**
     * Search all GIPHY GIFs for a word or phrase. Punctuation will be stripped and ignored. Use a plus or url encode for phrases. Example paul+rudd, ryan+gosling or american+psycho.
     * @see <a href="https://developers.giphy.com/docs/#operation--gifs-search-get">Getting Started with the GIPHY API - Search Endpoint</a>
     * @param q Search query term or phrase. GIPHY search will automatically look for exact matches to queries + AND match + OR match. Explicit AND + OR boolean clauses in search queries are not supported.
     * @param limit The maximum number of records to return. Defaults to 25.
     * @param offset An optional results offset. Defaults to 0.
     * @param rating Filters results by specified rating.
     * @param lang Specify default language for regional content; use a 2-letter ISO 639-1 language code. See list of supported languages <a href="https://developers.giphy.com/docs/#language-support">here</a>.
     * @param fmt Used to indicate the expected response format. Default is Json.
     * @return list of Gifs
     */
    fun search(q: String, limit: Int = 25, offset: Int = 0, rating: String = "g", lang: String = "en", fmt: String = "json"): List<Gif> {
        val urlConnection = URL("https://api.giphy.com/v1/gifs/search?apiKey=${apiKey}&q=${q}&limit=${limit}%offset=${offset}&rating=${rating}&lang=${lang}&fmt=${fmt}").openConnection()
        urlConnection.connect()
        return moshi.fromJson(JsonReader.of(Okio.buffer(Okio.source(urlConnection.inputStream))))!!.data
    }


    /**
     * Returns a random GIF, limited by tag. Excluding the tag parameter will return a random GIF from the GIPHY catalog.
     * @see <a href="https://developers.giphy.com/docs/#operation--gifs-random-get">Getting Started with the GIPHY API - Random Endpoint</a>
     * @param tag Filters results by specified tag.
     * @param rating Filters results by specified rating.
     * @param fmt Used to indicate the expected response format. Default is Json.
     * @return Gif
     */
    fun random(tag:String, rating: String = "g" ,fmt: String = "json"): Gif {
        val urlConnection = URL("https://api.giphy.com/v1/gifs/random?apiKey=${apiKey}&tag=${tag}&rating=${rating}&fmt=${fmt}").openConnection()
        urlConnection.connect()
        return moshi2.fromJson(JsonReader.of(Okio.buffer(Okio.source(urlConnection.inputStream))))!!.data
    }
}
class __Giphy4KInternal(val data: List<Gif>)
class __Giphy4KInternal2(val data: Gif)


data class Gif(
        val type: String,
        val id: String,
        val slug: String,
        val url: String,
        val bitly_gif_url: String,
        val bitly_url: String,
        val embed_url: String,
        val username: String,
        val source: String,
        val rating: String?,
        val content_url: String,
        val source_tld: String,
        val source_post_url: String,
        val is_sticker: String,
        val import_datetime: String,
        val trending_datetime: String,
        val user: User?,
        val images: Images
)

data class User(
        val avatar_url: String,
        val banner_url: String,
        val banner_image: String?,
        val profile_url: String,
        val username: String,
        val display_name: String,
        val is_verified: Boolean
)

data class Images(
        val fixed_height_still: Image,
        val original_still: Image,
        val fixed_width: Image,
        val fixed_height_small_still: Image,
        val fixed_height_downsampled: Image,
        val preview: Image,
        val fixed_height_small: Image,
        val downsized_still: Image,
        val downsized: Image,
        val downsized_large: Image,
        val fixed_width_small_still: Image,
        val preview_webp: Image,
        val fixed_width_still: Image,
        val fixed_width_small: Image,
        val downsized_small: Image,
        val fixed_width_downsampled: Image,
        val downsized_medium: Image,
        val original: Image,
        val fixed_height: Image,
        val looping: Image,
        val original_mp4: Image
)

data class Image(
        val url: String?,
        val width: Int?,
        val height: Int?,
        val size: Int?,
        val frames: Int?,
        val mp4: String?,
        val mp4_size: Int?,
        val webp: String?,
        val webp_size: Int?
)