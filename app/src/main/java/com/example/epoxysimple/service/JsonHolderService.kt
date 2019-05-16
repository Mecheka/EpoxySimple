package com.traning.suriya.coroutinesex.service

import com.example.epoxysimple.model.Post
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET

interface JsonHolderService {
    @GET("/posts")
    fun getPosts(): Single<Response<List<Post>>>
}