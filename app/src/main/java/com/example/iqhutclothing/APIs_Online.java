package com.example.iqhutclothing;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public class APIs_Online {

    public static final String key = "";
    public static final String url = "http://192.168.0.105/";


    public static PaymentOrderList paymentOrderList= null;

    public static PaymentOrderList getPaymentOrderList() {
        if (paymentOrderList == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl( url )
                    .addConverterFactory( GsonConverterFactory.create() )
                    .build();

            paymentOrderList = retrofit.create( PaymentOrderList.class );
        }

        return paymentOrderList;
    }

    public interface PaymentOrderList {
//        @GET("/metrox2/payment/list/API")
//        Call<List<ModelSalesPaymentOrderListBack>> paymentList();

        @GET("/metrox2/payment/list/API?")
        Call<List<ModelSalesPaymentOrderList>> paymentList( @Query("page") int nextPage);
    }


}
