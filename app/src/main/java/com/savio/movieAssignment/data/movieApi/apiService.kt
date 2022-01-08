package com.savio.movieAssignment.data.movieApi

import com.savio.movieAssignment.model.MovieDetails
import com.savio.movieAssignment.model.MovieResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface apiService {

////code by sumit rai//

    @GET("movie/popular")
    fun getPopularMovie(@Query("page") page: Int): Single<MovieResponse>

    @GET("movie/{movie_id}")
    fun getMovieDetails(@Path("movie_id") id: Int): Single<MovieDetails>
}