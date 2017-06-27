package br.com.mespinasso.metrosprest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.mespinasso.metrosprest.adapter.LinhaAdapter;
import br.com.mespinasso.metrosprest.adapter.OnItemClickListener;
import br.com.mespinasso.metrosprest.api.APIUtils;
import br.com.mespinasso.metrosprest.api.MetroAPI;
import br.com.mespinasso.metrosprest.model.Linha;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvLinhas;
    private LinhaAdapter linhaAdapter;
    private MetroAPI metroAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvLinhas = (RecyclerView) findViewById(R.id.rvLinhas);

        linhaAdapter = new LinhaAdapter(new ArrayList<Linha>(), new OnItemClickListener() {
            @Override
            public void onItemClick(Linha item) {
                Toast.makeText(getApplicationContext(), item.getCor(), Toast.LENGTH_SHORT).show();
            }
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvLinhas.setLayoutManager(layoutManager);
        rvLinhas.setAdapter(linhaAdapter);
        rvLinhas.setHasFixedSize(true);

        loadData();
    }

    private void loadData() {
        metroAPI = APIUtils.getLinhasMetro();

        metroAPI.getLinhas().enqueue(new Callback<List<Linha>>() {
            @Override
            public void onResponse(Call<List<Linha>> call, Response<List<Linha>> response) {
                if(response.isSuccessful()) {
                    linhaAdapter.update(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Linha>> call, Throwable t) {
                Log.e("REST ERROR", "Erro ao trazer os dados.");
            }
        });
    }
}
