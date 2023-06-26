

/*let array_list=[];
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

showPlayers();*/

const textBox = document.querySelector('#newPlayer');

    document.querySelector("button").addEventListener("click", () => {
        if (!textBox.value) {
            alert('No value is given');
            return;
        }
        addPerson(textBox.value).then(_ => {
            textBox.value = '';
            location.reload();
        });
    });


    const fetchJson = url =>
        fetch(url).then((response) => {
            if (response.ok) {
                return response.json();
            } else {
                throw new Error(response.statusText);
            }
        });

    fetchJson('http://localhost:8080/rest/players').then(json => {
        json['_embedded']['players'].forEach(player => {
            const listItem = document.createElement('li');
            const listItemText = document.createTextNode(player['userName'])
            listItem.appendChild(listItemText);
            document.getElementById('playerList').appendChild(listItem);
        })
    }).catch(error => {
        console.log(error);
    });


    const addPerson = (userName) =>
      fetch('http://localhost:8080/api/players', {
        method: 'POST',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({ userName: userName }) // Wrap userName in an object
      }).then(response => {
        if (response.ok) {
          alert('Person added successfully');
        } else {
          throw new Error('add person error ' + response.statusText);
        }
      });
