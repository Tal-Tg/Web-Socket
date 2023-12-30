import React,{useEffect,useState} from "react";
import SockJS from 'sockjs-client'
// import WebSocket from 'ws';
import Stomp from 'stompjs';
import {MessagesContainer,MessageDiv,MessageIndicationRed,MessageIndicationGreen ,
    MessageContent} from './WebSocketElements'
import {BsCircleFill} from 'react-icons/bs';




export default function WebSocketTest(){

    const [test, setTest] = useState(false)
    const [textMessage, setTextMessage] = useState('');
    const [messages, setMessages] = useState([]);
    const [indication, setIndication] = useState(false);

    var socket = new SockJS('http://localhost:8080/stomp-endpoint');
    var stompClient = Stomp.over(socket);
    
    
    

    function Connect(){
        
        //here we connecting to websocket server
        socket = new SockJS('http://localhost:8080/stomp-endpoint');

        //we gonna need to use stomp(for Streaming)
        stompClient = Stomp.over(socket);
        // here we gitting the frame connect details
        stompClient.connect({}, function(frame){
            // console.log(frame);
            setIndication(true);
            //here we subscribe and get the data and getting the callback(response)
            // stompClient.subscribe("/topic/messages",(response) => {
            //     console.log("here");
            //     console.log(JSON.parse(response.body).body);
            //     setMessages(JSON.parse(response.body).body);
            //     })
            stompClient.subscribe("/topic/messages",(response) => {
                // console.log("here");
                // console.log(JSON.parse(response.body).body);
                // const test3 = JSON.parse(response.body).body; 
                return setMessages(JSON.parse(response.body).body);
                // return ;
            })
        })

    }

    try {
        
        var disconnect = () =>{
            
            stompClient.disconnect();
            setIndication(false);
            console.log("disconnected");
        }
    } catch (error) {
        
    }


    // function sendName(){
    //     //here we send the message 
    //     stompClient.send("/app/hello",{},JSON.stringify({'message':textMessage}).valueOf())

    // }



    const handleInputMessage = (e) =>{
        // console.log(e.target.value);
        setTextMessage(e.target.value);
    }

    function sendName(){
        //here we send the message 
        if(!indication){
            console.log("not connected");
        }
        stompClient.send("/app/hello",{},JSON.stringify({'message':textMessage}).valueOf())

    }



    return(
        <div>
            <div>
                online status:<span>{!indication ? <MessageIndicationRed><BsCircleFill/></MessageIndicationRed> : <MessageIndicationGreen><BsCircleFill/></MessageIndicationGreen> }</span>
                <br/>
                {/* <button onClick={() => sendName()}></button> */}
                {/* <form> */}
                send message: &nbsp;
                    <input type="text" onChange={handleInputMessage}/>&nbsp;&nbsp;&nbsp;
                    <button onClick={() => Connect()}>connect</button>&nbsp;
                    <button onClick={() => sendName()}>send</button>&nbsp;
                    <button onClick={() => disconnect()}>disconnect</button>
                {/* </form> */}
            </div>
            <MessagesContainer>
                {messages.map((m) => 
                <div key={m.id}>
                    <br/>
                    <MessageDiv><MessageContent>{m.message} </MessageContent> </MessageDiv>
                </div>
                )}
                <br/>
            </MessagesContainer>

        </div>
    )

}