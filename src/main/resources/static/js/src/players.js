

fetch( "http://localhost:8080/players").then((response) => {
  console.log('Request succeeded: ' + response.statusText);
}).catch((error) => {
  console.log( "Request failed: " + error.message );
});