import React, { useState, useEffect } from 'react';
import SockJS from 'sockjs-client';
import Stomp from 'stompjs';


// Set the backend location
const ENDPOINT = "http://localhost:8080/ws";


function WebSocket(userid) {

  const [stompClient, setStompClient] = useState(null);
  const [msgToSend, setSendMessage] = useState("Enter your message here!");


  useEffect(() => {
    // use SockJS as the websocket client
    const socket = SockJS(ENDPOINT);

    // Set stomp to use websockets
    const stompClient = Stomp.over(socket);
    
    // connect to the backend
    stompClient.connect({}, () => { 
      // subscribe to the backend
      stompClient.subscribe('/login/greeting', (data) => {
        console.log(data);
        console.log("message recieved");
        onMessageReceived(data);
        stompClient.disconnect();
      });
    });
    // maintain the client for sending and receiving
    setStompClient(stompClient);
    console.log("testing connection USE EFFECT");
    console.log(stompClient);
    setTimeout(() => {  sendMessage() }, 3000);

  }, []);

  // send the data using Stomp
  function sendMessage() {
    console.log(userid.userid);
    try{
      stompClient.send("/websocket/getGreeting", {}, userid.userid);
      
    }
    catch{

      alert("could not connect to the socket")
    }
  };

  // display the received data
  function onMessageReceived(data)
  {
    // console.log(data.body)
    // // const result = JSON.parse(data);
    
    alert(data.body);
    
  };

  //TODO, add a solution for disconnection

  return (
    <div> 

  </div>
  );

}

export default WebSocket;