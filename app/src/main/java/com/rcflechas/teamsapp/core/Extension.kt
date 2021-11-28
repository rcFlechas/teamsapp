package com.rcflechas.teamsapp.core

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.view.View
import android.widget.SearchView
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rcflechas.teamsapp.application.BaseApplication
import com.rcflechas.teamsapp.utilities.Event
import com.rcflechas.teamsapp.utilities.UIState
import io.reactivex.Completable
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

inline fun <T> LiveData<Event<T>>.observeEvent(owner: LifecycleOwner, crossinline onEventUnhandledContent: (T) -> Unit) {
    observe(owner, { it.getContentIfNotHandled()?.let(onEventUnhandledContent) })
}

internal infix fun View.onClick(function: () -> Unit) {
    setOnClickListener { function() }
}

internal fun AndroidViewModel.isConnect(): Boolean {

    val connectivityManager = this.getApplication<BaseApplication>().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val network = connectivityManager.activeNetwork ?: return false
    val networkCapabilities = connectivityManager.getNetworkCapabilities(network) ?: return false

    return when {
        networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
        networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
        networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
        networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_BLUETOOTH) -> true
        else -> false
    }
}

fun <T> Completable.subscribe(errorMutableLiveData: MutableLiveData<Event<UIState<T>>>): Disposable = this.subscribeOn(Schedulers.io())
    .subscribeBy(
        onError = {
            errorMutableLiveData.postValue(Event(UIState.OnError(it.message ?: "Error")))
        }
    )

fun SearchView.clear(submit: Boolean = false) {
    this.setQuery(String(), submit);
    this.clearFocus();
}
