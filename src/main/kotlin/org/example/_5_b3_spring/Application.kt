package org.example._5_b3_spring

import org.example._5_b3_spring.entities.MessageEntity
import org.example._5_b3_spring.entities.MessageRepository
import org.example._5_b3_spring.entities.MessageService
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Application(val messageRepository: MessageRepository) : CommandLineRunner {

    override fun run(vararg args: String) {
        if(messageRepository.count() == 0L) {
            messageRepository.save(MessageEntity(pseudo = "1er message", message = "1er message"))
        }
    }
}

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}
