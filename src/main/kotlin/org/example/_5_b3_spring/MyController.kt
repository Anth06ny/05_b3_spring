package org.example._5_b3_spring

import org.example._5_b3_spring.entities.StudentEntity
import org.example._5_b3_spring.entities.UserEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.servlet.mvc.support.RedirectAttributes

@Controller
class MyController {


    //http://localhost:8080/hello
    @GetMapping("/hello")
    fun testHello(model: Model): String {
        println("/hello")

        model.addAttribute("texte", "Bonjour")
        model.addAttribute("studentEntity", StudentEntity("Toto", 12))
        model.addAttribute("studentList", arrayOf(
            StudentEntity("Bob", 10),
            StudentEntity("Bobby", 18),
            StudentEntity("Charles", 20)
        ))



        //Nom du fichier HTML que l'on souhaite afficher
        return "welcome"
    }

    //http://localhost:8080/login
    @GetMapping("/login") //Affiche le formulaire
    fun login(userEntity: UserEntity): String {
        println("/login")
        return "login" //Lance login.html
    }

    @PostMapping("/loginSubmit") //traite le formulaire
    fun loginSubmit(userEntity: UserEntity, redirectAttributes: RedirectAttributes) : String {
        println("/loginSubmit : userEntity=$userEntity")

        try {
                if(userEntity.pseudo.length < 3 || userEntity.password.length < 3 ){
                    throw Exception("Il faut 3 caratères")
                }


        }
        catch(e:Exception){
            e.printStackTrace()
            redirectAttributes.addFlashAttribute("errorMessage", e.message)
            redirectAttributes.addFlashAttribute("userEntity", userEntity)
            return "redirect:login"
        }
        //Traitement du formulaire
        //Afin d'éviter la duplication de code, redirige sur la page qui s'occupe de l'affichage
        return "redirect:hello"
    }



}