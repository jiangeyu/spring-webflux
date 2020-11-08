import concurrent.TestExecuter;
import lang.reflect.MyClassRuntimeAnno;
import lang.reflect.SimpleObj;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.util.StringTokenizer;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午4:22 2020/6/13
 */
public class StringTokenierTest {

    @Test
    public void test () {
        String test = "hello,world;,ddd";
        StringTokenizer stringTokenizer = new StringTokenizer(test,",");
        if(stringTokenizer.countTokens() > 0) {
            String[] names = new String[stringTokenizer.countTokens()];
            for(int i =0;i<names.length;i++) {
                names[i] = stringTokenizer.nextToken();
            }

            for (String name : names) {
                System.out.println(name);
            }
        }


    }


    @Test
    public void testAnno() {
        Annotation[] annotations = SimpleObj.class.getAnnotations();

        MyClassRuntimeAnno myClassRuntimeAnno = SimpleObj.class.getAnnotation(MyClassRuntimeAnno.class);
        System.out.println(myClassRuntimeAnno.name()+"level ="+myClassRuntimeAnno.level());
        System.out.println(myClassRuntimeAnno == annotations[0]);
    }

    @Test
    public void print() {
        TestExecuter t= new TestExecuter();
        t.aa();
    }
}
