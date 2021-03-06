package com.savio.movieAssignment.networkState

enum class Status {
    RUNNING,
    SUCCESS,
    FAILED
    //for showing Result we are using enum

}

class NetworkState(val status: Status, val msg: String) {

    companion object {//for static
        //
        val LOADED: NetworkState
        val LOADING: NetworkState
        val ERROR: NetworkState
        val ENDOFLIST: NetworkState

        init {
            LOADED = NetworkState(Status.SUCCESS, "Success")

            LOADING = NetworkState(Status.RUNNING, "Running")

            ERROR = NetworkState(Status.FAILED, "Something went wrong")

            ENDOFLIST = NetworkState(Status.FAILED, "You have reached the end")
        }
    }
}
////code by sumit rai//