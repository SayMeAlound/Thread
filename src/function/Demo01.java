package function;
/*
    @author  zjc
    @create 2021-02-24-17:18  
*/

import java.util.function.Function;

/**
 * 函数型接口 Function
 */
public class Demo01 {
    public static void main(String[] args) {
        //工具类  输出输入的值
//        Function function = new Function<String,String>() {
//            @Override
//            public String apply(String str) {
//
//                return str;
//            }
//        };
        Function function = str -> {return str;};
        System.out.println(function.apply("asd"));

    }
}
