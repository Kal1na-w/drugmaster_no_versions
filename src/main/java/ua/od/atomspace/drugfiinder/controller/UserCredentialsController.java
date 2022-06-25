package ua.od.atomspace.drugfiinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ua.od.atomspace.drugfiinder.dto.UserCredentialsDto;
import ua.od.atomspace.drugfiinder.service.UserCredentialsService;

@RestController
@RequestMapping("/userCredentials")
public class UserCredentialsController {

    private final UserCredentialsService userCredentialsService;

    @Autowired
    public UserCredentialsController(UserCredentialsService userCredentialsService) {
        this.userCredentialsService = userCredentialsService;
    }

    @PostMapping("/registration")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void register(@RequestBody UserCredentialsDto userCredentialsDto) {
        userCredentialsService.create(userCredentialsDto);
    }

}
