document.addEventListener('DOMContentLoaded', (event) => {
    document.getElementById('search-button').addEventListener('click', fetchGifts);
});

function fetchGifts() {
    const query = document.getElementById('query-input').value;
    if (!query) {
        alert('Please enter a search query');
        return;
    }

    const url = `/search_gifs?query=${encodeURIComponent(query)}&limit=10`;
    fetch(url)
        .then(response => response.json())
        .then(data => displayGifs(data))
        .catch(error => console.error('Error fetching GIFs:', error));
}

function displayGifs(data) {
    const gifsContainer = document.getElementById('gifs-container');
    gifsContainer.innerHTML = ''; // Clear previous results
    if (data && data.data && data.data.left > 0) {
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