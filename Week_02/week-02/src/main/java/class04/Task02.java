package class04;

import java.util.HashMap;

/**
 * @author : Hyuk
 * @description : Task02
 * @date : 2020/10/26 12:57 上午
 */
public class Task02 {

    public static void main(String[] args) {
        System.out.println(OkHttpclientUtil.get("https://www.baidu.com"));
        System.out.println(OkHttpclientUtil.post("https://www.baidu.com", new HashMap<>(4)));
    }
}
