package class04;

import okhttp3.*;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

import static java.util.concurrent.TimeUnit.MINUTES;
import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @author : Hyuk
 * @description : OkHttpclientUtil
 * @date : 2020/10/26 1:03 上午
 */
public class OkHttpclientUtil {

    private static final int CONNECT_TIMEOUT = 50;
    private static final int READ_TIMEOUT = 20;
    private static final int WRITE_TIMEOUT = 20;
    private static final int MAX_IDLE_CONNECTIONS = 10;
    private static final int KEEP_ALIVE_DURATION = 5;

    public static OkHttpClient createdOkHttpClient() {
        return new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .connectionPool(new ConnectionPool(MAX_IDLE_CONNECTIONS, KEEP_ALIVE_DURATION, MINUTES))
                .connectTimeout(CONNECT_TIMEOUT, SECONDS)
                .readTimeout(READ_TIMEOUT, SECONDS)
                .writeTimeout(WRITE_TIMEOUT, SECONDS)
                .build();
    }

    /**
     * get请求
     * @return
     */
    public static String get(String url) {
        Request request = new Request.Builder()
                .url(url)
                .build();
        return execute(request);
    }

    /**
     * post请求
     * @param uri
     * @param params
     * @param headerMap
     * @return
     */
    public static String post(String uri, Map<String, String> params) {

        FormBody.Builder formBuilder = new FormBody.Builder();
        params.forEach((key, value) -> {
            if (key != null && value != null) {
                formBuilder.add(key, value);
            }
        });

        FormBody formBody = formBuilder.build();
        Request request = new Request.Builder()
                .url(uri)
                .post(formBody)
                .build();

        return execute(request);
    }

    private static String execute(Request request) {
        Response response;
        try {
            response = createdOkHttpClient().newCall(request)
                    .execute();
            if (response.isSuccessful()) {
                return response.body().string();
            } else {
                throw new RuntimeException("http请求出现错误");
            }
        } catch (IOException e) {
            throw new RuntimeException("目标服务器无法正常访问");
        }
    }
}
