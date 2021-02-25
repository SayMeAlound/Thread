package function;/*
    @author  zjc
    @create 2021-02-24-19:09  
*/

import java.util.function.Supplier;

/*
*   供给型接口  没有参数 只有返回值
*
*/
public class Demo04 {
    public static void main(String[] args) {
//        Supplier supplier = new Supplier<String>() {
//            @Override
//            public String get() {
//                return "1024";
//            }
//        };
        Supplier supplier = () -> "1024";
        System.out.println(supplier.get());
    }
}
