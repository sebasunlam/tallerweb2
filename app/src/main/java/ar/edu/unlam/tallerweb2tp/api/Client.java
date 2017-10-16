package ar.edu.unlam.tallerweb2tp.api;

import java.util.List;

import ar.edu.unlam.tallerweb2tp.constants.ConstantOpenMl;
import ar.edu.unlam.tallerweb2tp.models.Descripcion;
import ar.edu.unlam.tallerweb2tp.models.Product;
import ar.edu.unlam.tallerweb2tp.models.ProductSearchResult;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by spardo on 16/10/17.
 */

public class Client {

    private static Retrofit retrofit = null;

    public static MercadoLibreApi getClient(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(ConstantOpenMl.ApiBase)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(MercadoLibreApi.class);
    }

    public static void search(String query, Callback<ProductSearchResult> callback){
        getClient().search(query).enqueue(callback);
    }

    public static void getProduct(String id, Callback<Product> callback){
        getClient().get(id).enqueue(callback);
    }

    public static void getDescripcion(String id, Callback<Descripcion> callback){
        getClient().getDescripcion(id).enqueue(callback);
    }
}
