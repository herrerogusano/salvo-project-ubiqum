const gamesList = document.getElementById("games-list");

const fetchGames = url =>
    fetch(url).then(response => {
        if (response.ok) {
            return response.json();
        } else {
            throw new Error('error: ' + response.statusText);
        }
    });


const createListOfGamesInfo = (gameInfo) => {
    const listItem = document.createElement('li');
    const listItemText = document.createTextNode(gameInfo);
    listItem.appendChild(listItemText);
    gamesList.appendChild(listItem);
}


fetchGames('http://localhost:8080/api/games').then(games => {
    const gamesInfo = games.map((game) => {
            const dateTimeString = game['created'];
            const dateObj = new Date(dateTimeString);
            const formattedDateTime = dateObj.toLocaleString();

            const playerNames = game['gamePlayers']
              .map((gamePlayer) => gamePlayer['player']['userName'])
              .sort()
              .join(',');

            return formattedDateTime + ' - ' + playerNames;
          });

    gamesInfo.forEach(createListOfGamesInfo);
});

