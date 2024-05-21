document.addEventListener("DOMContentLoaded", function() {
    const gifElement = document.querySelector(".favorite-gif");

    fetch("https://api.giphy.com/v1/gifs/random?api_key=INxBzxb2ollIFoM1gjnPbJUIP0PQXa2A&tag=&rating=g")
        .then(response => response.json())
        .then(data => {
            gifElement.src = data.data.image_url;
        })
        .catch(error => console.error("Error fetching GIF:", error));
});