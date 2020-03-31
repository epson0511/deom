package com.example.Controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.example.Model.ChatClientModel;
import com.example.Model.ServerResponseModel;

@Controller
public class CharRoomController {
	@MessageMapping("/messageControl")
	@SendTo("/topic/getResponse")
		public ServerResponseModel said(ChatClientModel responseMessage) throws InterruptedException{
			Thread.sleep(1000);
			return new ServerResponseModel("歡迎來到," + responseMessage.getName());
	}
}
