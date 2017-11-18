import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * Created by sj on 2017/11/17.
 */
public class Test {

    public static void main(String[] args) {
        String hashAlgorithmName = "MD5";
        String credentials = "aaa111";
        int hashIterations = 2;
        Object obj = new SimpleHash(hashAlgorithmName, credentials, null, hashIterations);
        System.out.println(obj);
    }
}
