package ru.geekbrains.persist;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class UserRepository {

private Map<Long, User> userMap = new ConcurrentHashMap<Long, User>();
private AtomicLong identify = new AtomicLong(0);

public List<User> findAll (){
    return new ArrayList<User>(userMap.values());
}

public  User findById(long id) {
    return userMap.get(id);
}

public void insert (User user) {
    long id = identify.incrementAndGet();
    user.setId(id);
    userMap.put(id,user);
}

public void update (User user) {
    userMap.put(user.getId(), user);
}

public void delete (long id) {
    userMap.remove(id);
}

}
