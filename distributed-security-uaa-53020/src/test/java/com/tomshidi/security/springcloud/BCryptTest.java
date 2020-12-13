package com.tomshidi.security.springcloud;

import org.springframework.security.crypto.bcrypt.BCrypt;

/**
 * @author TomShiDi
 * @description
 * @date 2020/12/13 16:01
 **/
public class BCryptTest {

    public static void main(String[] args) {
        System.out.println(BCrypt.hashpw("secret", BCrypt.gensalt()));
    }
}
