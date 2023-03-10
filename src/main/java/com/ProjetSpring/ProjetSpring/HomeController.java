package com.ProjetSpring.ProjetSpring;

import com.ProjetSpring.ProjetSpring.Repository.AnimalRepository;
import com.ProjetSpring.ProjetSpring.Repository.ContactRepository;
import com.ProjetSpring.ProjetSpring.Repository.DemandeRepository;
import com.ProjetSpring.ProjetSpring.model.Animal;
import com.ProjetSpring.ProjetSpring.model.Contact;
import com.ProjetSpring.ProjetSpring.model.DemandeRemboursement;
import com.ProjetSpring.ProjetSpring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ContactRepository contactRepo;

    @Autowired
    private DemandeRepository demandeRepo;

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private AnimalRepository animalRepo;


    @GetMapping("")
    public String home(){
        return "home";
    }

    @GetMapping("/admin")
    public String admin(){
        return "This is admin page";
    }

    @GetMapping("/login")
    public String login(){
        return "/login";
    }

    @GetMapping("/Contacter")
    public String Contacter(Model model, Principal principal){
        CustomUserDetails userDetails = (CustomUserDetails) ((Authentication) principal).getPrincipal();
        model.addAttribute("user", userDetails);
        model.addAttribute("contact", new Contact());
        return "Contacter";
    }

    @GetMapping("/users")
    public String users(Model model, Principal principal){
        CustomUserDetails userDetails = (CustomUserDetails) ((Authentication) principal).getPrincipal();
        model.addAttribute("user", userDetails);
        return "users";
    }

    @GetMapping("/logout")
    public String logout(){
        return "/logout";
    }
    @GetMapping("/AjoutAnimal")
    public String AjoutAnimal(Model model, Principal principal){
        CustomUserDetails userDetails = (CustomUserDetails) ((Authentication) principal).getPrincipal();
        model.addAttribute("user", userDetails);
        model.addAttribute("animal", new Animal());
        return "AjoutAnimal";
    }
    @GetMapping("/DepotDemande")
    public String DepotDemande(Model model, Principal principal){
        CustomUserDetails userDetails = (CustomUserDetails) ((Authentication) principal).getPrincipal();
        model.addAttribute("user", userDetails);
        model.addAttribute("demande", new DemandeRemboursement());
        return "DepotDemande";
    }
    @GetMapping("/InfosUser/{idUser}")
    public String InfosUser(Model model,Principal principal, @PathVariable Long idUser){
        CustomUserDetails userDetails = (CustomUserDetails) ((Authentication) principal).getPrincipal();
        model.addAttribute("user", userDetails);
        List<Animal> listAnimal = animalRepo.findByUserIdUser(idUser);
        model.addAttribute("listAnimal", listAnimal);
        return "/InfosUser";
    }

    @GetMapping("/ParamsUser/{idUser}")
    public String ParamsUser(Model model,Principal principal, @PathVariable Long idUser){
        CustomUserDetails userDetails = (CustomUserDetails) ((Authentication) principal).getPrincipal();
        model.addAttribute("user", userDetails);
        List<Animal> listAnimal = animalRepo.findByUserIdUser(idUser);
        model.addAttribute("listAnimal", listAnimal);
        return "/ParamsUser";
    }

    @PostMapping("/AjoutAnimalProcess")
    public String processRegister(Animal animal, Model model,@RequestParam("idUser") Long userId)  {
        User existingUser = userRepo.findById(userId).get();
        animal.setUser(existingUser);
        animalRepo.save(animal);
        return "redirect:/users"; }

    @PostMapping("/AjoutDemandeProcess")
    public String ajoutDemandeProcess(DemandeRemboursement demande, Model model, @RequestParam("idUser") Long userId, @RequestParam("idAnimal") int animalId)  {
        User existingUser = userRepo.findById(userId).get();
        Animal existingAnimal = animalRepo.findById(animalId).get();
        demande.setUser(existingUser);
        demande.setAnimal(existingAnimal);
        demandeRepo.save(demande);
        return "redirect:/users"; }

    @PostMapping("/ContactProcess")
    public String ContactProcess(Contact contact, Model model, @RequestParam("idUser") Long userId)  {
        User existingUser = userRepo.findById(userId).get();
        contact.setUser(existingUser);
        contactRepo.save(contact);
        return "redirect:/users"; }

}