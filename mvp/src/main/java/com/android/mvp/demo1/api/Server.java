package com.android.mvp.demo1.api;


import org.apache.http.conn.ssl.SSLSocketFactory;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Server {

    private Api api;

    private Server() {
        //OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        //okHttpClientBuilder.sslSocketFactory(RxUtils.createSSLSocketFactory());
        //okHttpClientBuilder.hostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        api = retrofit.create(Api.class);
    }

    public static class ServerHolder {
        private static Server server = new Server();
    }

    public static Server getInstance() {
        return ServerHolder.server;
    }

    public Api api() {
        return api;
    }


}
