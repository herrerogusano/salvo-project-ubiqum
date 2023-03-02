

fetch( "http://localhost:8080/api/players")
    .then((response) => response.json())
    .then((data) => {
        console.log("hola", data)
});