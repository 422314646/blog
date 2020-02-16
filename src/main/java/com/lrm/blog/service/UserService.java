package com.lrm.blog.service;

import com.lrm.blog.po.User;


/**
 * Created by limi on 2017/10/15.
 */
public interface UserService {

    User checkUser(String username, String password);

    String email(Long id);
}
