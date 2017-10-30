package ar.edu.unlam.tallerweb2tp.adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import ar.edu.unlam.tallerweb2tp.ProductDetailActivity;
import ar.edu.unlam.tallerweb2tp.R;
import ar.edu.unlam.tallerweb2tp.models.Result;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by spardo on 28/10/17.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private List<Result> productList;

    public void showResults(List<Result> results) {
        this.productList = results;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_producto, null);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //esto pasa cada vez que se asigna un valor a un item del view holder
        final Result producto = this.productList.get(position);

        holder.titulo.setText(producto.getTitulo());
        holder.precio.setText(producto.getPrecio());

        Picasso.with(holder.imagen.getContext())
                .load(producto.getImgUrl())
                .placeholder(R.drawable.image_holder)
                .error(R.drawable.descarga)
                .into(holder.imagen);

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ProductDetailActivity.class);
                intent.putExtra("productId", producto.getId());
                view.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        //Devuelve la cuenta de items que tengo en pantalla
        return productList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        View view;
        @BindView(R.id.imgPrincipal)
        ImageView imagen;
        @BindView(R.id.txtTitulo)
        TextView titulo;
        @BindView(R.id.txtPrecio)
        TextView precio;

        //Este seria el "layout" del adapter
        public ViewHolder(View itemView) {

            super(itemView);
            ButterKnife.bind(this, itemView);
            this.view = itemView;
        }
    }
}
