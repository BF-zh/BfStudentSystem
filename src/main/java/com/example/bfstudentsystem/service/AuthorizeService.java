package com.example.bfstudentsystem.service;

import org.springframework.security.core.userdetails.UserDetailsService;


public interface AuthorizeService extends UserDetailsService {
    /**
     * 发送验证邮箱
     *
     * @param email      邮箱
     * @param sessionId  sessionId
     * @param hasAccount 是否有账号
     * @return 是否发送成功
     */
    String sendValidateEmail(String email, String sessionId, boolean hasAccount);

    String validateAndRegister(String username, String password, String email, String code, String sessionId);

    String validateOnly(String email, String code, String sessionId);

    boolean resetPassword(String password, String email);
}
