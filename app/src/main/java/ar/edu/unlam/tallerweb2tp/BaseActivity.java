package ar.edu.unlam.tallerweb2tp;

import android.support.v7.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import butterknife.BindString;

/**
 * Created by spardo on 16/10/17.
 */

public class BaseActivity extends AppCompatActivity{

    @BindString(R.string.ErrorProduct)
    protected String errorProduct;
    @BindString(R.string.Error)
    protected String errorTitle;
    @BindString(R.string.ErrorHttp)
    protected String errorHttp;
    @BindString(R.string.ErrorDescription)
    protected String errorDescription;

    Picasso.Builder picassoBuilder = new Picasso.Builder(this);

    Picasso picasso = picassoBuilder.build();

    public BaseActivity(){

    }

}
