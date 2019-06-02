package com.github.stack;

import java.io.Serializable;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午9:14 2019/6/2
 */
public class EmptyStackException extends RuntimeException implements Serializable {


    private static final long serialVersionUID = -8766038608920134747L;


    public EmptyStackException(){
        super();
    }

    public EmptyStackException(String msg){
        super(msg);
    }
}
