package com.example.peticiones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {

    PeticionesApi peticionesApi;
    TextView Title;
    ImageView Background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Title = findViewById(R.id.Title);
        Background = findViewById(R.id.Background);
        //Peticion no funciona revisar
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://superapi.netlify.app/api/")
                .addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).build();

        peticionesApi = retrofit.create(PeticionesApi.class);

        Title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                peticionesApi.obtenerArtistas().enqueue(new Callback<List<ResponseTrapiItem>>() {
                    @Override
                    public void onResponse(Call<List<ResponseTrapiItem>> call, Response<List<ResponseTrapiItem>> response) {
                        Glide.with(getApplicationContext()).load(response.body().get(3).pic).into(Background);

                    }

                    @Override
                    public void onFailure(Call<List<ResponseTrapiItem>> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "ko", Toast.LENGTH_SHORT).show();

                    }
                });
                }

        });
    }
}
