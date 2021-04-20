package com.example.testd2kotlin

import io.reactivex.Single
import retrofit2.http.POST

interface MockyService {
    @POST("/v2/5ddcd3673400005800eae483")
    fun getCompany(): Single<RootObject>
}