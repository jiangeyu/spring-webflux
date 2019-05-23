package aop;

import org.springframework.stereotype.Component;




/**
 * @author: <a href="mailto:lingxiao@2dfire.com">凌霄</a>
 * @time: Created in 上午8:14 2019/5/21
 * @desc
 */
@Component("johnMayer")
public class GrammyGuitarist implements main.java.aop.Singer {

    @Override
    public void sing(Guitar guitar) {
        System.out.println("sing: Gravity is working against me\n" +
                "And gravity wants to bring me down");
    }


    public void rest() {
        System.out.println("zzz");
    }

    public void talk() {
        System.out.println("talk");
    }

}