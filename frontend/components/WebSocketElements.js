import styled from 'styled-components'


export const MessagesContainer = styled.div`
width:80%;
min-height:80vh;
height:auto;
box-sizing: border-box;
background:white;
border:2px solid black;
position:relative;
top:50px;
left:10%;

`

export const MessageIndicationRed = styled.div`
color:red;

`

export const MessageIndicationGreen = styled.div`
color:green;


`

export const MessageDiv = styled.div`
background:#bae8e8;

position:relative;
height:40px;
width:40%;
border-radius:15px;
left:30px;
z-index:2;
border:1px solid black;
&:before{
    
    content:'';
    position:absolute;
    width:22px;
    height:22px;
    background:#bae8e8;
    bottom:0px;
    left:0.2%;
    transform:translate(-40%) translateY(-7px) rotate(130deg);
    border-bottom:1px solid black;
    border-right:1px solid black;
    z-index:0;
}

`

export const MessageContent = styled.p`
position:relative;
left:20px;
bottom:8px;

`