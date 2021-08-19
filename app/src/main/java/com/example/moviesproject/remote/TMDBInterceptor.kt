package com.example.moviesproject.remote

import okhttp3.Interceptor
import okhttp3.Response

class TMDBInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val url = chain.request()
            .url
            .newBuilder()
            .addQueryParameter("api_key", "271ada379987d5ea2863b9cfb2905419")
            .addQueryParameter("language", "pt-BR")
            .build()

        val request = chain.request()
            .newBuilder()
            .url(url)
            .build()

        return chain.proceed(request)
    }
}
