package com.erdem.samples;

import com.erdem.samples.dao.User;
import com.erdem.samples.dao.UserRepositoryDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

/**
 * Created by bilginc_user on 15.06.2017.
 */
@RestController
//@Scope(value = SCOPE_PROTOTYPE)
public class GreetingController {

    @Autowired
    private UserRepositoryDao userRepositoryDao;

    @Autowired
    private Worker worker;

    public GreetingController() {
        LOGGER.info("GreetingController constructed {}", System.identityHashCode(this));
    }

    private static final String template = "Hello, %s!";
    private static final AtomicLong counter = new AtomicLong();
    private static final Logger LOGGER = LoggerFactory.getLogger(GreetingController.class);

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        long id = counter.incrementAndGet();
        LOGGER.info("Greeting request number {}", id);
        return new Greeting(id, String.format(template, name));
    }

    @RequestMapping("/getAllUsers")
    public List<User> getAllUsers(){
        return userRepositoryDao.findAll();
    }

    @RequestMapping("/saveUser")
    public boolean saveUser(@RequestParam User user){
        return userRepositoryDao.save(user);
    }

    @RequestMapping("/saveNewUser")
    public boolean saveNewUser(@RequestParam String name, @RequestParam String surname){
        LOGGER.debug("Saving a new user {} {}", name, surname);
        boolean isSaved = userRepositoryDao.save(new User(name, surname));
        worker.doWork();
        return isSaved;
    }
}
