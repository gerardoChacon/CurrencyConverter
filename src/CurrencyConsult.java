import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class CurrencyConsult {

    public CurrencyValue searchCurrencys(String baseCurrency, String targetCurrency) {

        String direction = "https://v6.exchangerate-api.com/v6/e3219568bdd4b99a7c22f5f9/pair/"
                + baseCurrency + "/" + targetCurrency;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direction))
                .build();

        try {
            HttpResponse<String> response;
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), CurrencyValue.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("No encontré ese tipo de cambio");
        }

    }
}
