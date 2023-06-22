package com.example.demo4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MainController {

    @Autowired
    CredentialRepository credentialRepository;

    @GetMapping("/save")
    public String saveCredential()
    {
        Credential cd = new Credential();
        cd.setUsername("Alex");
        cd.setPassword("1234");
        credentialRepository.save(cd);
        return "New saved";

    }
}
