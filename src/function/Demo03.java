package function;/*
    @author  zjc
    @create 2021-02-24-19:01  
*/

import java.util.function.Consumer;

/**
 *   消费型接口  有参数  没有返回值
 */
public class Demo03 {
    public static void main(String[] args) {
//        Consumer<String> consumer = new Consumer<String>() {
//            @Override
//            public void accept(String str) {
//                System.out.println(str);
//            }
//        };
        Consumer<String> consumer = (str) ->{
            System.out.println(str);
        };
        consumer.accept("sss");

    }
}
