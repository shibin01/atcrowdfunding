package com.shibin.service;

import com.shibin.bean.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface UserService {

    User getUserByMsg(User user);

    /**
     * 分页查询用户数据
     * @param pageMap
     * @return
     */
    List<User> findUsers(Map<String, Integer> pageMap);

    /**
     * 用户总条数
     * @return 用户总数量
     */
    int findUserCounts();
}
