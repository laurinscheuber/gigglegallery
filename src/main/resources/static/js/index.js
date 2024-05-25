document.addEventListener("DOMContentLoaded", function() {
    let currentPage = 0;
    const pages = document.querySelectorAll(".book-pages .page");
    const prevButton = document.getElementById("prev-page");
    const nextButton = document.getElementById("next-page");

    function updatePageVisibility() {
        pages.forEach((page, index) => {
            page.style.display = index === currentPage ? "block" : "none";
        });
    }
document.addEventListener('DOMContentLoaded', (event) => {
    document.getElementById('search-button').addEventListener('click', fetchGifs);
});

function fetchGifs() {
    const query = document.getElementById('query-input').value;
    if (!query) {
        alert('Please enter a search query');
        return;
    }

    prevButton.addEventListener("click", function() {
        if (currentPage > 0) {
            currentPage--;
            updatePageVisibility();
        }
    });

    nextButton.addEventListener("click", function() {
        if (currentPage < pages.length - 1) {
            currentPage++;
            updatePageVisibility();
        }
    });

    updatePageVisibility();

    // Fetch current user data
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
        });

    // Fetch friend requests
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
        });
});
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
            gifsContainer.appendChild(img);
        });
    } else {
        gifsContainer.innerHTML = 'No results found';
    }
}