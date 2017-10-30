package ar.edu.unlam.tallerweb2tp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlam.tallerweb2tp.adapters.ProductAdapter;
import ar.edu.unlam.tallerweb2tp.api.Client;
import ar.edu.unlam.tallerweb2tp.models.Product;
import ar.edu.unlam.tallerweb2tp.models.ProductSearchResult;
import ar.edu.unlam.tallerweb2tp.models.Result;
import ar.edu.unlam.tallerweb2tp.utils.Dialogs;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListProductoActivity extends BaseActivity {

    @BindView(R.id.listadoProductos)
    RecyclerView listadoProductos;
    @BindView(R.id.txtNotFound)
    TextView notFound;


    ProductAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_producto);
        ButterKnife.bind(this);

        configurarLayoutManager();
    }

    private void configurarLayoutManager() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.listadoProductos.setLayoutManager(linearLayoutManager);

        executeSearch();

        this.adapter = new ProductAdapter();
        this.listadoProductos.setAdapter(adapter);
        this.adapter.notifyDataSetChanged();

    }


    private void executeSearch() {

        Client.search(getIntent().getStringExtra("q"), new Callback<ProductSearchResult>() {
            @Override
            public void onResponse(Call<ProductSearchResult> call, Response<ProductSearchResult> response) {
                if (response.isSuccessful()) {

                    ProductSearchResult result = response.body();

                    if (result.getResults().isEmpty()) {
                        notFound.setVisibility(View.VISIBLE);
                        listadoProductos.setVisibility(View.GONE);
                    } else {
                        adapter.showResults(result.getResults());
                        notFound.setVisibility(View.GONE);
                        listadoProductos.setVisibility(View.VISIBLE);
                    }

                } else {
                    notFound.setVisibility(View.GONE);
                    listadoProductos.setVisibility(View.GONE);
                    Dialogs.alertDialog(ListProductoActivity.this, errorTitle, errorHttp);
                }
            }

            @Override
            public void onFailure(Call<ProductSearchResult> call, Throwable t) {
                notFound.setVisibility(View.GONE);
                listadoProductos.setVisibility(View.GONE);
                Dialogs.alertDialog(ListProductoActivity.this, errorTitle, errorHttp).show();
            }
        });
    }

}
