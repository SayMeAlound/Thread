package function;/*
    @author  zjc
    @create 2021-02-24-17:47  
*/

import java.util.function.Predicate;

/*
*   断定型接口  一个输入参数  返回布尔值
*
**/
public class Demo02 {

    public static void main(String[] args) {
        //判断字符串是否为空
//        Predicate predicate =new Predicate<String>(){
//
//            @Override
//            public boolean test(String str) {
//                return str.isEmpty();
//            }
//        };
        Predicate<String> predicate = str-> str.isEmpty();
        System.out.println(predicate.test(""));
    }


}
