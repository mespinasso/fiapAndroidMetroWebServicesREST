package br.com.mespinasso.metrosprest.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.mespinasso.metrosprest.R;
import br.com.mespinasso.metrosprest.api.APIUtils;
import br.com.mespinasso.metrosprest.model.Linha;

public class LinhaAdapter extends RecyclerView.Adapter<LinhaAdapter.LinhaViewHolder> {

    private List<Linha> linhas;
    private OnItemClickListener listener;

    public LinhaAdapter(List<Linha> linhas, OnItemClickListener listener) {
        this.linhas = linhas;
        this.listener = listener;
    }

    @Override
    public LinhaAdapter.LinhaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View customLayout = inflater.inflate(R.layout.linha_row, parent, false);

        return new LinhaViewHolder(customLayout);
    }

    @Override
    public void onBindViewHolder(LinhaAdapter.LinhaViewHolder holder, final int position) {
        holder.tvCor.setText(linhas.get(position).getCor());
        holder.tvNumero.setText(linhas.get(position).getNumero());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View v) {
                                                   listener.onItemClick(linhas.get(position));
                                               }
                                           });

                Picasso.with(holder.itemView.getContext())
                        .load(APIUtils.BASE_URL + linhas.get(position).getUrlImagem())
                        .placeholder(R.mipmap.ic_launcher)
                        .error(R.mipmap.ic_launcher)
                        .into(holder.ivLogo);
    }

    @Override
    public int getItemCount() {
        return linhas.size();
    }

    public void update(List<Linha> linhas) {
        this.linhas = linhas;
        notifyDataSetChanged();
    }

    public class LinhaViewHolder extends RecyclerView.ViewHolder {

        public ImageView ivLogo;
        public TextView tvCor;
        public TextView tvNumero;

        public  LinhaViewHolder(View itemView) {
            super(itemView);

            ivLogo = (ImageView) itemView.findViewById(R.id.ivLogo);
            tvCor = (TextView) itemView.findViewById(R.id.tvCor);
            tvNumero = (TextView) itemView.findViewById(R.id.tvNumero);
        }
    }
}
