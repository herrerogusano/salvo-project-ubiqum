

let array_list=[];
const url = 'http://localhost:8080/api/players';
async function showPlayers()  {
    fetch(url)
          .then(response => {
            if (response.ok) {
              return response.json();
            } else {
              throw new Error(response.statusText);
            }
          })
          .then(data => {
          console.log(data)
            array_list=data;
            populate(array_list)
          });
}

    const populate = (players_list) => {
        const container = document.getElementById("list");
        for (let i=0;i<players_list.length;i++) {
          let li = document.createElement("li");
          let node = document.createTextNode(players_list[i].userName);
          li.appendChild(node);
          container.appendChild(li);
        }
    }

    /*const form = document.getElementById('form');


    form.addEventListener("submit", event => {
      event.preventDefault();

        const formData = new FormData(event.target);
        const formDataObj = Object.fromEntries(formData.entries());
              let player = formDataObj;*/



      /*fetch(url, {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify(data)
      })
        .then(response => response.json())
        .then(data => console.log(data))
        .catch(error => console.error(error));
    });*/

window.addEventListener("load", () => {
  function sendData() {
    const XHR = new XMLHttpRequest();

    // Bind the FormData object and the form element
    const FD = new FormData(form);

    // Define what happens on successful data submission
    XHR.addEventListener("load", (event) => {
      alert(event.target.responseText);
    });

    // Define what happens in case of error
    XHR.addEventListener("error", (event) => {
      alert('Oops! Something went wrong.');
    });

    // Set up our request
    XHR.open("POST", url);

    // The data sent is what the user provided in the form
    XHR.send(FD);
  }

  // Get the form element
  const form = document.getElementById("form");

  // Add 'submit' event handler
  form.addEventListener("submit", (event) => {
    event.preventDefault();

    sendData();
  });
});



showPlayers();