package com.sduiBackend.api;

import com.sduiBackend.api.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @GetMapping("/users")
    public void printUsers(@RequestParam Long id){
//        Long dum=1L;
        userRepository.findById(id).ifPresentOrElse(user->{
            System.out.println("--- User Details ---");
            System.out.println("ID: " + user.getId());
            System.out.println("Name: " + user.getName());
            System.out.println("Country" + user.getCountry());
            System.out.println("State: " + user.getState());
        },
                ()->System.out.println("User not found with ID: " + id)
        );

//        users.forEach(user->System.out.println("user"+user.getName()));
    }


}
