package com.savio.movieAssignment.ui.mainmovie

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.savio.movieAssignment.data.movieApi.POST_PER_PAGE
import com.savio.movieAssignment.data.movieApi.apiService
import com.savio.movieAssignment.data.repo.MovieDataSource
import com.savio.movieAssignment.data.repo.MovieDataSourceFactory
import com.savio.movieAssignment.networkState.NetworkState
import com.savio.movieAssignment.model.Movie
import io.reactivex.disposables.CompositeDisposable

class MoviePagedListRepository (private val apiService : apiService) {

    lateinit var moviePagedList: LiveData<PagedList<Movie>>
    lateinit var moviesDataSourceFactory: MovieDataSourceFactory

    fun fetchLiveMoviePagedList (compositeDisposable: CompositeDisposable) : LiveData<PagedList<Movie>> {
        moviesDataSourceFactory = MovieDataSourceFactory(apiService, compositeDisposable)

        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(POST_PER_PAGE)
            .build()

        moviePagedList = LivePagedListBuilder(moviesDataSourceFactory, config).build()

        return moviePagedList
    }

    fun getNetworkState(): LiveData<NetworkState> {
        return Transformations.switchMap<MovieDataSource, NetworkState>(
            moviesDataSourceFactory.moviesLiveDataSource, MovieDataSource::networkState)
    }
}
////code by sumit rai//