package comets;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface NasaService {
    @GET("resource/2vr3-k9wn.json")
    Call<List<Asteroid>> getAsteroids();
}
