package data.repositories;
import data.models.User;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private int count;
    private List<User> users = new ArrayList<>();

    @Override
    public long count() {
        return users.size();
    }

    @Override
    public User save(User user) {
        if(isNew(user)) saveNew(user);
        else update(user);
        return user;
    }

    private void update(User user) {
        users.remove(findById(user.getUserId()));
        users.add(user);
    }

    private void saveNew(User user) {
        count++;
        user.setUserId(count);
        users.add(user);
    }

    private boolean isNew(User user) {
        for(User checkedUser : users) {
            if(checkedUser.getUserId() == user.getUserId()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public User findById(int id) {
        if(id <= 0 || id > count) return null;
        return users.get(id - 1);
    }

    @Override
    public boolean existsById(int id) {
        return id > 0 && id <= count;
    }

    @Override
    public void deleteById(int id) {
        users.remove(findById(id));
    }

    @Override
    public void deleteAll() {
        users.clear();
    }
}