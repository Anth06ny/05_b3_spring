package org.example._5_b3_spring

import org.example._5_b3_spring.entities.MessageEntity
import org.example._5_b3_spring.entities.MessageService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class TchatRestController(val messageService: MessageService) {

    //http://localhost:8080/api/allMessages
    @GetMapping("allMessages")
    fun allMessages() = messageService.getAllMessages()

    //http://localhost:8080/api/addMessage?pseudo=toto&message=hello
    @GetMapping("addMessage")
    fun addMessage(pseudo: String, message: String): List<MessageEntity> {

        messageService.addMessage(MessageEntity(pseudo = pseudo, message = message))
        return messageService.getAllMessages()
    }

    //http://localhost:8080/api/saveMessage
    //
    @PostMapping("saveMessage")
    fun saveMessage(@RequestBody message: MessageEntity) {
        messageService.addMessage(message)
    }
}