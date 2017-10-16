package ar.edu.unlam.tallerweb2tp;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import butterknife.BindString;

/**
 * Created by spardo on 16/10/17.
 */

public class BaseActivity extends AppCompatActivity {

    @BindString(R.string.ErrorProduct)
    protected String errorProduct;
    @BindString(R.string.Error)
    protected String errorTitle;
    @BindString(R.string.ErrorHttp)
    protected String errorHttp;
    @BindString(R.string.ErrorDescription)
    protected String errorDescription;
    @BindString(R.string.NotFoundMessage)
    protected String notFoundMessage;
    @BindString(R.string.NotFoundTitle)
    protected String notFoundTitle;

    protected ProgressBar progressBarWait;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

}
