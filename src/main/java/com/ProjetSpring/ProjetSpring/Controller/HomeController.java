package com.ProjetSpring.ProjetSpring.Controller;

import com.ProjetSpring.ProjetSpring.CustomUserDetails;
import com.ProjetSpring.ProjetSpring.Repository.AnimalRepository;
import com.ProjetSpring.ProjetSpring.Repository.ContactRepository;
import com.ProjetSpring.ProjetSpring.Repository.DemandeRepository;
import com.ProjetSpring.ProjetSpring.Service.UserService;
import com.ProjetSpring.ProjetSpring.UserRepository;
import com.ProjetSpring.ProjetSpring.model.Animal;
import com.ProjetSpring.ProjetSpring.model.Contact;
import com.ProjetSpring.ProjetSpring.model.DemandeRemboursement;
import com.ProjetSpring.ProjetSpring.model.User;
import jakarta.servlet.http.HttpSession;
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
    private UserService userService;
    // Added this method (createClient)
    /**/
    @PostMapping("/createUser")
    public String createUser(@ModelAttribute User user, HttpSession session) {
        boolean f = userService.checkUsername(user.getUsername());
        if (f) {
            session.setAttribute("msg","Client déja existant, veuillez vous connecter ou changez de coordonnées");
        }
        else {
            //System.out.println(user);
            User userDtls = userService.createUser(user);
            if(userDtls != null) {
                session.setAttribute("msg","Enregistré!");
            }else {
                session.setAttribute("msg","Erreur du serveur");
            }
        }
        //clientService.save(client);
        return "redirect:/login";
    }
    // End of the method
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

    @GetMapping("/Connection")
    public String Connection(){

        return "Connection";
    }
    @GetMapping("/chat")
    public String chat(){

        return "chat";
    }

    @GetMapping("/Historique/{idUser}")
    public String Historique(Model model,Principal principal, @PathVariable Long idUser){
        CustomUserDetails userDetails = (CustomUserDetails) ((Authentication) principal).getPrincipal();
        model.addAttribute("user", userDetails);
        List<DemandeRemboursement> listDemandeRemboursement = demandeRepo.findByUserIdUser(idUser);
        model.addAttribute("listDemandeRemboursement", listDemandeRemboursement);
        return "/Historique";
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

    @GetMapping("/pack")
    public String pack(){

        return "pack";
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

    //@GetMapping("/History")
    //public String History(){
        /*
        Model model,Principal principal, @PathVariable Long idUser
        CustomUserDetails userDetails = (CustomUserDetails) ((Authentication) principal).getPrincipal();
        model.addAttribute("user", userDetails);
        List<Animal> listAnimal = animalRepo.findByUserIdUser(idUser);
        model.addAttribute("listAnimal", listAnimal);*/
        //return "/History";
    //}

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