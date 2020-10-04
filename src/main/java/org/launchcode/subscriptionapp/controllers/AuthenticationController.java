package org.launchcode.subscriptionapp.controllers;

import org.launchcode.subscriptionapp.data.OwnerRepository;
import org.launchcode.subscriptionapp.models.Owner;
import org.launchcode.subscriptionapp.models.dto.LoginFormDTO;
import org.launchcode.subscriptionapp.models.dto.RegisterFormDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@Controller
public class AuthenticationController {

    @Autowired
    OwnerRepository ownerRepository;

    private static final String userSessionKey = "owner";

    public Owner getOwnerFromSession(HttpSession session) {
        Integer ownerId = (Integer) session.getAttribute(userSessionKey);
        if (ownerId == null) {
            return null;
        }

        Optional<Owner> owner = ownerRepository.findById(ownerId);

        if (owner.isEmpty()) {
            return null;
        }

        return owner.get();

    }

    private static void setUserInSession(HttpSession session, Owner owner) {
        session.setAttribute(userSessionKey, owner.getId());
    }

    @GetMapping("/register")
    public String displayRegistrationForm(Model model) {
        model.addAttribute(new RegisterFormDTO());
        model.addAttribute("title", "Register");
        return "register";
    }

    @PostMapping("/register")
    public String processRegistrationForm(@ModelAttribute @Valid RegisterFormDTO registerFormDTO, Errors errors, HttpServletRequest request, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Register");
            return "register";
        }

        Owner existingOwner = ownerRepository.findByUsername(registerFormDTO.getUsername());

        if (existingOwner != null) {
            errors.rejectValue("username", "username.alreadyexists", "An owner with that username already exists");
            model.addAttribute("title", "Register");
            return "register";
        }

        String password = registerFormDTO.getPassword();
        String verifyPassword = registerFormDTO.getVerifyPassword();
        if (!password.equals(verifyPassword)) {
            errors.rejectValue("password", "passwords.mismatch", "Passwords do not match");
            model.addAttribute("title", "Register");
        }

        Owner newOwner = new Owner(registerFormDTO.getUsername(), registerFormDTO.getPassword());
        ownerRepository.save(newOwner);
        setUserInSession(request.getSession(), newOwner);

        return "redirect:";
    }

    @GetMapping("/login")
    public String displayLoginForm(Model model) {
        model.addAttribute(new LoginFormDTO());
        model.addAttribute("title", "Log In");
        return "login";
    }

    @PostMapping("/login")
    public String processLoginForm(@ModelAttribute @Valid LoginFormDTO loginFormDTO, Errors errors, HttpServletRequest request, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Log In");
            return "login";
        }

        Owner theOwner = ownerRepository.findByUsername(loginFormDTO.getUsername());

            if (theOwner == null) {
                errors.rejectValue("username", "user.invalid", "The given username does not exist.");
                model.addAttribute("title", "Log In");
                return "login";
            }

            String password = loginFormDTO.getPassword();

            if (!theOwner.isMatchingPassword(password)) {
                errors.rejectValue("password", "password.invalid", "Invalid password");
                model.addAttribute("title", "Log In");
                return "login";
            }

            setUserInSession(request.getSession(), theOwner);

            return "redirect:";

    }


}
