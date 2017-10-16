package ar.edu.unlam.tallerweb2tp.api;

import java.util.List;

import ar.edu.unlam.tallerweb2tp.models.Descripcion;
import ar.edu.unlam.tallerweb2tp.models.Product;
import ar.edu.unlam.tallerweb2tp.models.ProductSearchResult;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by spardo on 16/10/17.
 */

public interface MercadoLibreApi {
    @GET("/sites/MLU/search")
    Call<ProductSearchResult> search(@Query("q")String query);

    @GET("/items/{itemId}")
    Call<Product> get(@Path("itemId")String id);
    @GET("items/{itemId}/description")
    Call<Descripcion> getDescripcion(@Path("itemId")String id);
}
