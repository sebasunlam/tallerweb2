package ar.edu.unlam.tallerweb2tp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.widget.EditText;

import java.io.IOException;
import java.util.List;

import ar.edu.unlam.tallerweb2tp.api.Client;
import ar.edu.unlam.tallerweb2tp.api.MercadoLibreApi;
import ar.edu.unlam.tallerweb2tp.models.ProductSearchResult;
import ar.edu.unlam.tallerweb2tp.utils.Dialogs;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends BaseActivity {


    @BindView(R.id.txtSearch)
    EditText txtSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnSearch)
    public void search(){
        Client.search(txtSearch.getText().toString(), new Callback<ProductSearchResult>() {
            @Override
            public void onResponse(Call<ProductSearchResult> call, Response<ProductSearchResult> response) {
                if(response.isSuccessful()){
                    Intent intent = new Intent(MainActivity.this, ProductDetailActivity.class);
                    ProductSearchResult result = response.body();
                    intent.putExtra("productId", result.getResults().get(0).getId());
                    startActivity(intent);
                }else{
                    Dialogs.alertDialog(MainActivity.this,errorTitle,errorHttp);
                }
            }

            @Override
            public void onFailure(Call<ProductSearchResult> call, Throwable t) {
                Dialogs.alertDialog(MainActivity.this,errorTitle,errorHttp).show();
            }
        });
    }
}
