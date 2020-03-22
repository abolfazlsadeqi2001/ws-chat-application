var ws = new WebSocket("ws://localhost:8080/chat_app");

console.log("I'm runned");

ws.onopen = function(){
	console.log("I'm connected");
};

ws.onmessage = function(event){
	var fieldSetElement = document.createElement("fieldset");
	
	var legendElement = document.createElement("legend");
	// TODO setup the name into legend innter html
	
	fieldSetElement.appendChild(legendElement);
	fieldSetElement.innerHTML += event.data;
	
	var messageContainerElement = document.querySelector(".message-container");
	messageContainerElement.appendChild(fieldSetElement);
};

ws.onclose = function(event){
	console.log(event.code);
};

function send(){
	var textAreaElement = document.querySelector("textarea");
	
	ws.send(textAreaElement.value);
}