import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author wrh
 * @version 1.0
 * @date 2020/7/13 13:52
 * @describe Lambda 表达式，也可称为闭包，它是推动 Java 8 发布的最重要新特性。
 * Lambda 允许把函数作为一个方法的参数（函数作为参数传递进方法中）。
 * 使用Lambda 表达式可以使代码变的更加简洁紧凑。
 */

public class LambdaTest {

    @Test
    public void test1Old() {
        Runnable run = new Runnable() {
            public void run() {
                System.out.println("old run");
            }
        };
        run.run();
    }

    @Test
    public void test1New() {
        Runnable run = () -> System.out.println("new run");
        run.run();
    }

    /**
     * 使用lambda表达式对列表进行迭代
     */
    @Test
    public void test2() {
        List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        features.forEach(n -> System.out.println(n));
        features.forEach(System.out::println);
    }

    /**
     * 使用lambda表达式和函数式接口Predicate，适合用于过滤；
     * 同时它提供类似于逻辑操作符AND和OR的方法，名字叫做and()、or()和xor()，用于将传入 filter() 方法的条件合并起来
     */
    @Test
    public void test3() {
        List<String> names = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
        Predicate<String> startsWithJ = (n) -> n.startsWith("J");
        Predicate<String> fourLetterLong = (n) -> n.length() == 4;
        names.stream()
                .filter(startsWithJ.and(fourLetterLong))
                .forEach((n) -> System.out.print("nName, which starts with 'J' and four letter long is : " + n));
    }

    /**
     * 使用lambda表达式的Map和Reduce
     */
    @Test
    public void test4() {
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        costBeforeTax.stream().map((cost) -> cost + .12 * cost).forEach(System.out::println);  // map 用来映射stream中的元素结果
        double total = costBeforeTax.stream().map((cost) -> cost + .12 * cost).reduce((sum, cost) -> sum + cost).get(); //根据一定的规则将Stream中的元素进行计算后返回一个唯一的值
        System.out.println("total: " + total);
    }


}
