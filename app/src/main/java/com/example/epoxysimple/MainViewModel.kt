package com.example.epoxysimple

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.epoxysimple.repostory.MainRepository
import com.example.epoxysimple.model.Post
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo

class MainViewModel : ViewModel() {

    private val compositeDisposable = CompositeDisposable()
    private val mainRepository = MainRepository()
    private val _postLiviData = MutableLiveData<MutableList<Post>>()

    fun getPost(): LiveData<MutableList<Post>> {
        mainRepository.getPost().subscribe(
                { result ->
                    if (result.isSuccessful) {
                        _postLiviData.postValue(result.body()?.toMutableList())
                    }
                }, {

        }).addTo(compositeDisposable)
        return _postLiviData
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}