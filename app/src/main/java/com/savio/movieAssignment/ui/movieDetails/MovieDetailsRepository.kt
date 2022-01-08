package com.savio.movieAssignment.ui.movieDetails

import androidx.lifecycle.LiveData
import com.savio.movieAssignment.data.movieApi.apiService
import com.savio.movieAssignment.data.repo.MovieDetailsNetworkDataSource
import com.savio.movieAssignment.networkState.NetworkState
import com.savio.movieAssignment.model.MovieDetails
import io.reactivex.disposables.CompositeDisposable

class MovieDetailsRepository (private val apiService : apiService) {

    lateinit var movieDetailsNetworkDataSource: MovieDetailsNetworkDataSource

    fun fetchSingleMovieDetails (compositeDisposable: CompositeDisposable, movieId: Int) : LiveData<MovieDetails> {

        movieDetailsNetworkDataSource = MovieDetailsNetworkDataSource(apiService,compositeDisposable)
        movieDetailsNetworkDataSource.fetchMovieDetails(movieId)

        return movieDetailsNetworkDataSource.downloadedMovieResponse

    }

    fun getMovieDetailsNetworkState(): LiveData<NetworkState> {
        return movieDetailsNetworkDataSource.networkState
    }



}

//code by sumit rai