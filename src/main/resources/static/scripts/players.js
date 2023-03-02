

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

    const data = { username: "example" };
const newPlayer = async (data) => {
    fetch(url, {
          method: "POST", // or 'PUT'

          body: JSON.stringify(data),
        })
          .then((response) => response.json())
          .then((data) => {
            console.log("Success:", data);
          })
          .catch((error) => {
            console.error("Error:", error);
          });
}

//newPlayer();
showPlayers();