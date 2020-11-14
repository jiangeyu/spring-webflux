package lang;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午5:08 2019/10/28
 */
public class ExceptionTest {

    public static int noException(){
        int i=10;
        try{
            System.out.println("i in try block is "+i);
            return --i;
        }catch(Exception e){
            --i;
            System.out.println("i in catch - form try block is "+i);
            return --i;
        }finally{

            System.out.println("i in finally - from try or catch block is "+i);
            return --i;
        }
    }

    public static int withException(){
        int i=10;
        try{
            System.out.println("i in try block is--"+i);
            i = i/0;
            return --i;
        }catch(Exception e){
            System.out.println("i in catch - form try block is--"+i);
            --i;
            System.out.println("i in catch block is--"+i);
            return --i;
        }finally{

            System.out.println("i in finally - from try or catch block is--"+i);
            --i;
            System.out.println("i in finally block is--"+i);
            return --i;
        }
    }

    public static void main(String[] args) {
        withException();
    }
}

