import java.util.Arrays;

/**
 * @ClassName Test
 * @Description TODO
 * @Author 张春海
 * @Date 2020/10/14 21:02
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) {
        String a = "123456.56660";
        String[] b = a.split("\\.");
        System.out.println(Arrays.toString(b));
    }
}
