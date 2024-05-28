# webeC - Graded Exercise

## Project

### Team members

** Unser Team: ** Tamira Leber & Laurin Scheuber

### Description

** Unsere Idee: ** Ein digitales Freundschaftsbuch, die "GiggleGallery". Jeder Nutzer loggt sich ein und erstellt seine eigene Seite des Freundschaftsbuches. Dies hat nebst normalen Informationen wie Namen und Geburtsdatum auch lustige Kategorien wie Guilty Pleasure Playlist, Binge-Watching-Beichte, Zeitreise-Ziel, Superhelden-Spitzname etc. Dann kann man Personen als Freunde anfragen. Wenn diese die Anfrage annehmen, erscheint ihre Seite im eigenen Freundschaftsbuch.

### Entitäten

- User (Profilepicture, bio, name, ...)
- FriendRequest (Sender, Receiver)
- Category (category name)

### Beziehungen

- User (n) -- friends -- (m) User
- User (1) -- (n) FriendRequest (n) -- (1) User
- FriendRequest (n) -- (1) Category

### Individual

- API Anbindung (Giphy)
- User Login

## Installation and run instructions

1. Clone repository
2. Run application
3. Connect to `http://localhost:8080`

