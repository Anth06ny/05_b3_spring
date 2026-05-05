package org.example._5_b3_spring

import org.example._5_b3_spring.entities.MessageEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class TchatRestController {

    val list = arrayListOf(MessageEntity("Toto", "1er message"))


    //http://localhost:8080/api/allMessages
    @GetMapping("allMessages")
    fun allMessages() = list

    //http://localhost:8080/api/addMessage?pseudo=toto&message=hello
    @GetMapping("addMessage")
    fun addMessage(pseudo: String, message: String): List<MessageEntity> {
        list.add(MessageEntity(pseudo, message))
        return list
    }

    //http://localhost:8080/api/saveMessage
    //
    @PostMapping("saveMessage")
    fun saveMessage(@RequestBody message: MessageEntity) {
        list.add(message)

    }


}