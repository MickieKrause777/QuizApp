let socket = new WebSocket("ws://localhost:8080/quiz");

socket.onopen = function() {
    console.log("Connected to WebSocket server");
};

socket.onmessage = function(event) {
    let message = event.data;
    console.log("Received: " + message);
    // Handle received message (e.g., update quiz questions in real-time)
};

socket.onclose = function() {
    console.log("Disconnected from WebSocket server");
};

function sendMessage(message) {
    socket.send(message);
    console.log("Sent: " + message);
}