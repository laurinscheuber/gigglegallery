document.addEventListener("DOMContentLoaded", function () {
    let currentPage = 0;
    const pages = document.querySelectorAll(".book-pages .page");
    const prevButton = document.getElementById("prev-page");
    const nextButton = document.getElementById("next-page");
    const modal = document.querySelector(".modal");
    const addGifButtons = document.getElementById("add-gif");
    const closeButton = document.getElementById("close-button");
    const searchButton = document.getElementById("search-button");
    const addFriend = document.getElementById("add-friend-button"); // via topics Multiselect Booklist
    const modalFriends = document.querySelector(".modal-friends");
    const closeButtonFriends = document.getElementById("add-friend-close");

    function updatePageVisibility() {
        pages.forEach((page, index) => {
            page.style.display = index === currentPage ? "block" : "none";
        });
    }

//Initialize page visibility
    updatePageVisibility();


    prevButton.addEventListener("click", () => {
        if (currentPage > 0) {
            currentPage--;
            updatePageVisibility();
        }
    });

    nextButton.addEventListener("click", () => {
        if (currentPage < pages.length - 1) {
            currentPage++;
            updatePageVisibility();
        }
    });

    searchButton.addEventListener("click", fetchGifs);

    addGifButtons.addEventListener("click", () => {
        modal.style.display = "block";
    });

    closeButton.addEventListener("click", () => {
        modal.style.display = "none";
    });
    window.addEventListener("click", (event) => {
        if (event.target === modal) {
            modal.style.display = "none";
        }
    });
    addFriend.addEventListener("click", () => {
        modalFriends.style.display = "block";
    });
    closeButtonFriends.addEventListener("click", () => {
        modalFriends.style.display = "none";
    });
    window.addEventListener("click", (event) => {
        if (event.target === modal) {
            modalFriends.style.display = "none";
        }
    });

    /*// Fetch current user data
    fetch('/api/users/me')
        .then(response => response.json())
        .then(data => {
            document.querySelector('.own-page .header h2').innerText = data.name;
            document.querySelector('.own-page .profile-picture').src = data.profilePicture;
            document.querySelector('.own-page .details').innerHTML = `
                    <p><strong>Name:</strong> ${data.name}</p>
                    <p><strong>Geburtsdatum:</strong> ${data.birthdate}</p>
                    <p><strong>Guilty Pleasure Playlist:</strong> ${data.guiltyPleasurePlaylist}</p>
                    <p><strong>Binge-Watching-Beichte:</strong> ${data.bingeWatchingConfession}</p>
                    <p><strong>Zeitreise-Ziel:</strong> ${data.timeTravelDestination}</p>
                    <p><strong>Superhelden-Spitzname:</strong> ${data.superheroNickname}</p>
                    <p><strong>Favorite GIF:</strong></p>
                    <img src="${data.favoriteGif}" alt="Favorite GIF" class="favorite-gif">
                `;
        });*/


    /*// Fetch friend requests
    fetch('/api/friendRequests')
        .then(response => response.json())
        .then(data => {
            const friendsList = document.querySelector('.friends-list');
            friendsList.innerHTML = '';
            data.forEach(request => {
                const friendElement = document.createElement('div');
                friendElement.classList.add('friend');
                friendElement.innerText = request.sender.name;
                friendsList.appendChild(friendElement);
            });
        });*/

    function fetchGifs() {
        const query = document.getElementById('query-input').value;
        if (!query) {
            alert('Please enter a search query');
            return;
        }
        const url = `/search_gifs?query=${encodeURIComponent(query)}&limit=10`;
        fetch(url)
            .then(response => {
                if (!response.ok) {
                    throw new Error(`HTTP error! Status: ${response.status}`);
                }
                return response.json();
            })
            .then(data => displayGifs(data))
            .catch(error => {
                console.error('Error fetching GIFs:', error);
                const gifsContainer = document.getElementById('gifs-container');
                gifsContainer.innerHTML = 'Error fetching GIFs. Please try again later.';
            });
    }

    function displayGifs(data) {
        const gifsContainer = document.getElementById('gifs-container');
        gifsContainer.innerHTML = ''; // Clear previous results
        if (data && data.data && data.data.length > 0) {
            data.data.forEach(gif => {
                const img = document.createElement('img');
                img.src = gif.images.fixed_height.url;
                img.alt = gif.title;
                img.addEventListener('click', () => {
                    selectGif(gif);
                });
                gifsContainer.appendChild(img);
            });
        } else {
            gifsContainer.innerHTML = 'No results found';
        }
    }

    function selectGif(gif) {
        const gifContainer = document.getElementById('gifContainer');
        gifContainer.innerHTML = `
            <img src="${gif.images.fixed_height.url}" alt="${gif.title}">
        `;
        modal.style.display = 'none';
        // Update the user's favorite GIF on the server
        fetch('/api/users/me/favoriteGif', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({favoriteGif: gif.images.fixed_height.url})
        }).then(response => {
            if (response.ok) {
                console.log('Favoriten-GIF erfolgreich aktualisiert.');
            } else {
                console.error('Fehler beim Aktualisieren des Favoriten-GIFs.');
            }
        });
    }
})
