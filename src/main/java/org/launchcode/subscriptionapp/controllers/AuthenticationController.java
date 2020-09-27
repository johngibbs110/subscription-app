package org.launchcode.subscriptionapp.controllers;

import org.launchcode.subscriptionapp.data.OwnerRepository;
import org.launchcode.subscriptionapp.models.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;
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

}
