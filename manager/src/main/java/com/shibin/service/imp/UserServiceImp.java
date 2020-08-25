package com.shibin.service.imp;

import com.shibin.service.UserService;
import com.shibin.bean.User;
import com.shibin.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    public User getUserByMsg(User user) {
        return userDao.getUserByMsg(user);
    }

    public List<User> findUsers(Map<String, Integer> pageMap) {
        return userDao.findUsers(pageMap);
    }

    /**
     * 查询用户总数量
     * @return 用户总数量
     */
    public int findUserCounts() {
        return userDao.findUserCounts();
    }

    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.select(1);
        Transaction transaction = jedis.multi();
        transaction.set("k11", "v11");
        transaction.set("k22", "v22");
        transaction.exec();
    }
}
