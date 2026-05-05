package org.example._5_b3_spring

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class MyController {


    //http://localhost:8080/hello
    @GetMapping("/hello")
    fun testHello(model: Model): String {
        println("/hello")

        model.addAttribute("texte", "Bonjour")
        model.addAttribute("studentEntity", StudentEntity("Toto", 12))
        model.addAttribute("studentList", arrayOf(StudentEntity("Bob", 10), StudentEntity("Bobby", 18), StudentEntity("Charles", 20)))



        //Nom du fichier HTML que l'on souhaite afficher
        return "welcome"
    }

}