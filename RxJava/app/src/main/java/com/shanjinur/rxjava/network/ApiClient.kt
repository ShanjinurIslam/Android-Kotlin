package com.shanjinur.rxjava.network

import android.content.Context
import android.text.TextUtils
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.shanjinur.rxjava.app.Const
import com.shanjinur.rxjava.utils.PrefUtils
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiClient {
    companion object {
        lateinit var retrofit:Retrofit
        val REQUEST_TIMEOUT:Long = 60
        lateinit var okHttpClient: OkHttpClient

        fun getClient(context: Context): Retrofit {
            retrofit = Retrofit.Builder().baseUrl(Const.BASE_URL).client(okHttpClient).addCallAdapterFactory(
                RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create()).build()

            return retrofit
        }

        fun initOkHttp(context: Context) {
            var httpClient:OkHttpClient.Builder = OkHttpClient().newBuilder()
                .connectTimeout(REQUEST_TIMEOUT,TimeUnit.SECONDS)
                .readTimeout(REQUEST_TIMEOUT,TimeUnit.SECONDS)
                .writeTimeout(REQUEST_TIMEOUT,TimeUnit.SECONDS)

            val interceptor:HttpLoggingInterceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY

            httpClient.addInterceptor(interceptor)

            httpClient.addInterceptor { chain ->
                val original = chain.request()

                val requestBuilder = original.newBuilder()
                    .addHeader("Accept","application/json")
                    .addHeader("Context-Type","application/json")

                if (! TextUtils.isEmpty(PrefUtils.getApiKey(context))){
                    requestBuilder.addHeader("Authorization",PrefUtils.getApiKey(context))
                }

                val request:Request = requestBuilder.build()
                chain.proceed(request)
            }

            okHttpClient = httpClient.build()
        }
    }
}