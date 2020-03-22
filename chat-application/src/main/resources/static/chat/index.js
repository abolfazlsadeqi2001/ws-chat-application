var ws = new WebSocket("ws://localhost:8080/chat_app");
var name = "";

console.log("I'm runned");

ws.onopen = function(){
	console.log("I'm connected");
};

ws.onmessage = function(event){
	var data = event.data.split(",");
	
	var fieldSetElement = document.createElement("fieldset");
	
	var legendElement = document.createElement("legend");
	legendElement.innerHTML = data[0];
	
	fieldSetElement.appendChild(legendElement);
	var body = "";
	for(var i=0; i<data.length; i++){
		body += data[i];
	}
	fieldSetElement.innerHTML += body;
	
	var messageContainerElement = document.querySelector(".message-container");
	messageContainerElement.appendChild(fieldSetElement);
};

ws.onclose = function(event){
	console.log(event.code);
};

function send(){
	if(name != ""){
		var textAreaElement = document.querySelector("textarea");
		
		var valueToSend = textAreaElement.value.split("\n").join("<br>");
		
		ws.send(name+","+valueToSend);
		
		textAreaElement.value = "";
	}else {
		alert("set name before everything");
	}
}

function setName(){
	var setNameButtonElement = document.querySelector("input[onclick='setName()']");
	var nameInputElement = document.querySelector("input[placeholder='name']");
	
	name = nameInputElement.value;
	
	setNameButtonElement.remove();
	nameInputElement.remove();
}