package ar.edu.unlam.tallerweb2tp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import java.io.IOException;
import java.util.List;

import ar.edu.unlam.tallerweb2tp.api.Client;
import ar.edu.unlam.tallerweb2tp.api.MercadoLibreApi;
import ar.edu.unlam.tallerweb2tp.models.ProductSearchResult;
import ar.edu.unlam.tallerweb2tp.utils.Dialogs;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends BaseActivity {


    @BindView(R.id.txtSearch)
    EditText txtSearch;
    @BindView(R.id.textInputLayoutSearch)
    TextInputLayout textInputLayoutSearch;
    @BindView(R.id.progressMain)
    ProgressBar progressMain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnSearch)
    public void search() {
        textInputLayoutSearch.setError(null);
        if (!txtSearch.getText().toString().isEmpty()) {
            Intent intent = new Intent(MainActivity.this, ListProductoActivity.class);

            intent.putExtra("q",txtSearch.getText().toString());
            startActivity(intent);

        } else {
            textInputLayoutSearch.setError("Debe ingresar parametros de busqueda");
        }

    }

    @OnTextChanged(R.id.txtSearch)
    public void hideError() {
        textInputLayoutSearch.setError(null);
    }
}
