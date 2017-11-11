package ar.edu.unlam.tallerweb2tp;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.StrictMode;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import ar.edu.unlam.tallerweb2tp.api.Client;
import ar.edu.unlam.tallerweb2tp.models.Descripcion;
import ar.edu.unlam.tallerweb2tp.models.Product;
import ar.edu.unlam.tallerweb2tp.utils.Dialogs;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductDetailActivity extends BaseActivity {

    @BindView(R.id.txtTitulo)
    TextView txtTitulo;
    @BindView(R.id.txtDescripcion)
    TextView txtDescripcion;
    @BindView(R.id.imgPrincipal)
    ImageView image;
    @BindView(R.id.precio)
    TextView precio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        ButterKnife.bind(this);

        if (this.getSupportActionBar() != null)
            this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        manageProductCall();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }

    private void manageProductCall() {

        Client.getProduct(getIntent().getStringExtra("productId"), new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                if (response.isSuccessful()) {

                    Product product = response.body();

                    txtTitulo.setText(product.getTitle());
                    precio.setText(product.getPrecio());

                    Picasso.with(ProductDetailActivity.this)
                            .load(product.getPictures().get(0).getUrl())
                            .placeholder(R.drawable.image_holder)
                            .error(R.drawable.descarga)
                            .into(image);

                    manageDescription(product.getId());
                } else {

                    Dialogs.alertDialog(ProductDetailActivity.this, errorTitle, errorProduct).show();
                }
            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {


                Dialogs.alertDialog(ProductDetailActivity.this, errorTitle, errorHttp).show();
            }
        });
    }

    private void manageDescription(String productId) {
        Client.getDescripcion(productId, new Callback<Descripcion>() {
            @Override
            public void onResponse(Call<Descripcion> call, Response<Descripcion> response) {
                if (response.isSuccessful())
                    txtDescripcion.setText(response.body().getPlainText());
                else
                    Dialogs.alertDialog(ProductDetailActivity.this, errorTitle, errorDescription).show();
            }

            @Override
            public void onFailure(Call<Descripcion> call, Throwable t) {
                Dialogs.alertDialog(ProductDetailActivity.this, errorTitle, errorHttp).show();
            }
        });
    }
}
