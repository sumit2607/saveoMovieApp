package com.savio.movieAssignment.data.repo

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.savio.movieAssignment.data.movieApi.apiService
import com.savio.movieAssignment.model.Movie
import io.reactivex.disposables.CompositeDisposable

class MovieDataSourceFactory (private val apiService : apiService, private val compositeDisposable: CompositeDisposable)
    : DataSource.Factory<Int, Movie>() {

    val moviesLiveDataSource =  MutableLiveData<MovieDataSource>()

    override fun create(): DataSource<Int, Movie> {
        val movieDataSource = MovieDataSource(apiService,compositeDisposable)

        moviesLiveDataSource.postValue(movieDataSource)
        return movieDataSource
    }
}

////code by sumit rai//