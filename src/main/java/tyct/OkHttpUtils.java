package tyct;

import okhttp3.*;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;


public class OkHttpUtils {
    private static final OkHttpClient CLIENT;

    static {
        CLIENT = new OkHttpClient.Builder()
                .connectTimeout(3, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .retryOnConnectionFailure(false)
                .build();
    }

    private OkHttpUtils() {
    }

    public static String get(String url) {
        Request request = new Request.Builder()
                .url(url)
                .get()
                .header(HttpHeaders.ACCEPT_CHARSET, "*")
                .header(HttpHeaders.CONNECTION, "keep-alive")
//                .header(HttpHeaders.CONNECTION, "Keep-Alive")
                .build();

        return executeRequest(url, request);
    }

    public static String post(String url, String json) {
        RequestBody requestBody = FormBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .header(HttpHeaders.ACCEPT_CHARSET, "*")
                .header(HttpHeaders.CONNECTION, "close")
                .header("Cookie", "PHPSESSID=tkq4oummlt4bi54oaojku9atk0; u_username=haibara; u_password=fcd2013141463102")
//                .header(HttpHeaders.CONNECTION, "Keep-Alive")
                .build();

        return executeRequest(url, request);
    }

    private static String executeRequest(String url, Request request) {
        Call call = CLIENT.newCall(request);
        try (Response response = call.execute()) {
            if (response.code() == HttpStatus.SC_OK && Objects.nonNull(response.body())) {
                return response.body().string();
            } else {
                System.out.println("url: " + url + "req: "+ request + "response code: " + response.code());
            }
        } catch (Exception e) {
            System.out.println("okhttp execute failed url: " + url + "req: "+ request + e);
        }
        return null;
    }

    public static void main(String[] args) {
        String s = get("https://wap.tylott.website/index.php/game/getOrdered/109");
        System.out.println(s);
    }

    public static String buildUrl(String url, Map<String, String> params) {
        HttpUrl urlParse = HttpUrl.parse(url);
        if (urlParse == null) {
            return null;
        }
        HttpUrl.Builder builder = urlParse.newBuilder();
        if (params != null && params.size() > 0) {
            for (String key : params.keySet()) {
                builder.addQueryParameter(key, params.get(key));
            }
        }
        return builder.build().toString();
    }
}
