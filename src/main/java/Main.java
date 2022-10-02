import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final String URL =
            "https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats";

    public static void main(String[] args) {
        try (CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setUserAgent("Cats Facts")
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)
                        .setConnectionRequestTimeout(30000)
                        .setRedirectsEnabled(false)
                        .build())
                .build()) {
            HttpGet request = new HttpGet(URL);

            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();

            try (CloseableHttpResponse response = httpClient.execute(request)) {
                //получаем тело ответа
                String body = new String(response.getEntity().getContent().readAllBytes());
                //преобразуем тело ответа в лист
                Type listType = new TypeToken<ArrayList<Fact>>() {}.getType();
                List<Fact> facts = gson.fromJson(body, listType);
                //фильтруем по upvotes и выводим на экран
                facts.stream()
                        .filter(vote -> vote.getUpvotes() == null)
                        .forEach(System.out::println);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

