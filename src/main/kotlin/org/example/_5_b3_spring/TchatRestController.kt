package org.example._5_b3_spring

import jdk.internal.joptsimple.internal.Messages.message
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class TchatRestController {

    val list = arrayListOf(MessageEntity("Toto", "1er message"))

    @GetMapping("/test")
    fun test(): String {
        println("/test")
        return "test ok"
    }

    @GetMapping("addMessage")
    fun addMessage(): List<MessageEntity> {
        return list
    }

    @GetMapping("allMessages")
    fun allMessages() = list

    @PostMapping("saveMessage")
    fun saveMessage(@RequestBody message: MessageEntity): String {
        return "Message received: $message"
    }


}