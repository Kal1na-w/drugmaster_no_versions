package ua.od.atomspace.drugfiinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.od.atomspace.drugfiinder.dao.model.UserCredentials;
import ua.od.atomspace.drugfiinder.dto.JwtDto;
import ua.od.atomspace.drugfiinder.dto.UserCredentialsDto;
import ua.od.atomspace.drugfiinder.model.JwtPayload;
import ua.od.atomspace.drugfiinder.service.JwtService;
import ua.od.atomspace.drugfiinder.service.UserCredentialsService;

@RestController
@RequestMapping("/login")
public class JwtLoginController {

    private final JwtService jwtService;
    private final UserCredentialsService userCredentialsService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public JwtLoginController(JwtService jwtService, UserCredentialsService userCredentialsService, PasswordEncoder passwordEncoder) {
        this.jwtService = jwtService;
        this.userCredentialsService = userCredentialsService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping
    public JwtDto generateJwt(@RequestBody UserCredentialsDto userCredentialsDto) {
        UserCredentials byUsername = userCredentialsService.findByUsername(userCredentialsDto.getUsername());
        if (passwordEncoder.matches(userCredentialsDto.getPassword(), byUsername.getPassword())) {

            String encode = jwtService.encode(JwtPayload.builder()
                    .username(byUsername.getUsername())
                    .build());

            return JwtDto.builder()
                    .jwt(encode)
                    .build();
        }
        throw new BadCredentialsException("User has bap credentials");
    }
}
