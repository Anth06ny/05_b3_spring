package org.example._5_b3_spring

import org.example._5_b3_spring.config.CHANNEL_NAME
import org.example._5_b3_spring.entities.MessageEntity
import org.example._5_b3_spring.entities.MessageService
import org.springframework.context.event.EventListener
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.messaging.simp.stomp.StompHeaderAccessor
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.socket.messaging.SessionSubscribeEvent

@Controller
@RequestMapping("/ws") // Chemin de base pour toutes les méthodes de ce contrôleur
class WebSocketController( val messageService: MessageService, private val messagingTemplate: SimpMessagingTemplate) {


    @MessageMapping("/chat")
    fun receiveMessage(message: MessageEntity) {
        println("/ws/chat $message")
        messageService.addMessage(message)
    }

    //A mettre dans le controller
    @EventListener
    fun handleWebSocketSubscribeListener(event: SessionSubscribeEvent) {
        val headerAccessor = StompHeaderAccessor.wrap(event.message)
        if (CHANNEL_NAME == headerAccessor.destination) {
            messagingTemplate.convertAndSend(CHANNEL_NAME, messageService.getAllMessages())
        }
    }
}