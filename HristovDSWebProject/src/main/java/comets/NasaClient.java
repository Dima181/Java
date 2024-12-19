package comets;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class NasaClient {
    private static final Retrofit client = (new Retrofit.Builder()).baseUrl("https://data.nasa.gov/").addConverterFactory(JacksonConverterFactory.create((new JsonMapper()).registerModule(new JavaTimeModule()))).build();

    public NasaClient() {
    }

    public static void main(String[] args) {
        NasaService nasaService = (NasaService)client.create(NasaService.class);

        try {
            Response<List<Asteroid>> response = nasaService.getAsteroids().execute();
            if (response.isSuccessful() && response.body() != null) {
                Optional<Asteroid> latestAsteroid = ((List)response.body()).stream().max(Comparator.comparing(Asteroid::getDiscoveryDate));
                latestAsteroid.ifPresent((asteroid) -> {
                    System.out.println("Последний обнаруженный астероид: " + String.valueOf(asteroid));
                });
            } else {
                System.out.println("Ошибка: " + response.errorBody().string());
            }
        } catch (IOException var4) {
            IOException e = var4;
            System.err.println("Ошибка при выполнении запроса: " + e.getMessage());
        }

    }
}
