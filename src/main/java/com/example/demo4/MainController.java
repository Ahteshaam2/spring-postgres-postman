package com.example.demo4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@Controller
public class MainController {

    @Autowired
    CredentialRepository credentialRepository;
    @GetMapping("/")
    public String getLandingPage(){
        return "landingpage";
    }

   @GetMapping("/save")
   public String saveCredential()
    {
       Credential cd = new Credential();
      cd.setUsername("Alex");
       cd.setPassword("1234");
       credentialRepository.save(cd);
        return "New saved";

    }
@PostMapping("/signup")
    public String signup(@RequestParam("username") String username,@RequestParam("password") String password){
    Credential credential = new Credential();
    credential.setUsername("Alex");
    credential.setPassword("1234");
    credentialRepository.save(credential);
    return "dashboard";
    }
    @PostMapping("/login")
    public String signin(@RequestParam("username") String username, @RequestParam("password") String password , HttpSession session) {

        Credential credential = credentialRepository.findByUsername(username);
  session.setAttribute("username",username);
        if (credential != null && credential.getPassword().equals(password)) {

            return "dashboard";
        } else {

            return "redirect:/login?error";
        }
    }
}
