package org.example._5_b3_spring.entities

import jakarta.persistence.*
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service

@Entity
@Table(name = "message")
data class MessageEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var pseudo: String = "",
    var message: String = ""
)

@Repository                       //<Entity, Typage Id>
interface MessageRepository : JpaRepository<MessageEntity, Long> {

}

@Service
class MessageService(val messageRep: MessageRepository) {


    fun addMessage(messageEntity: MessageEntity) {
        messageRep.save(messageEntity)
    }

    fun getAllMessages() = messageRep.findAll()

}

