package stonks;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Optional;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import stonks.util.DatabaseService;
import stonks.util.DatabaseServiceImpl;

public class StonksClient {
    private static final Retrofit client = (new Retrofit.Builder()).baseUrl("https://www.cbr.ru").addConverterFactory(JacksonConverterFactory.create(new XmlMapper())).build();

    public StonksClient() {
    }

    public static void main(String[] args) {
        try {
            DatabaseService databaseService = new DatabaseServiceImpl();
            StonksService stonksService = (StonksService)client.create(StonksService.class);
            LocalDate dateToCheck = LocalDate.of(2003, 4, 25);
            String formattedDate = dateToCheck.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            Response<DailyCurs> response = stonksService.getDailyCurs(formattedDate).execute();
            if (response.isSuccessful() && response.body() != null) {
                DailyCurs dailyCurs = (DailyCurs)response.body();
                Optional<Valute> maxValute = dailyCurs.getValutes().stream().filter((valutex) -> {
                    return !valutex.getName().equals("СДР (специальные права заимствования)");
                }).max(Comparator.comparingDouble(Valute::getValue));
                Valute valute;
                if (maxValute.isPresent()) {
                    valute = (Valute)maxValute.get();
                    System.out.println("Max Valute: " + String.valueOf(valute));
                    databaseService.saveMaxValuteOfDate("Hristov Dmitriy Sergeevich", valute, dateToCheck);
                } else {
                    System.out.println("Не удалось найти максимальную валюту.");
                }

                valute = databaseService.getValuteOfDate(dateToCheck);
                System.out.println("Saved Valute: " + String.valueOf(valute));
            } else {
                System.out.println("Response failed: " + response.errorBody().string());
            }
        } catch (IOException var9) {
            IOException e = var9;
            System.err.println("Ошибка при выполнении запроса: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception var10) {
            Exception e = var10;
            System.err.println("Произошла ошибка: " + e.getMessage());
            e.printStackTrace();
        }

    }
}