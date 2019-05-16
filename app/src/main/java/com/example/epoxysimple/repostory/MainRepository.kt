package com.example.epoxysimple.repostory

import com.example.epoxysimple.model.Post
import com.traning.suriya.coroutinesex.service.RetrofitClient
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Response

class MainRepository {

    fun getPost(): Single<Response<List<Post>>> {
        return RetrofitClient.makeRetrofitService().getPosts()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())

    }
}