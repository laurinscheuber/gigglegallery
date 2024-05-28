package ch.fhnw.webec.exercise.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "USERS")
public class Users implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty
    @Column(nullable = false, unique = true)
    private String username;

    @NotEmpty
    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Friendship> friendshipList;


    private String guiltyPleasurePlaylist;

    private String bingeWatchingBeichte;

    private String zeitreiseZiel;

    private String superheldenSpitzname;

    private String favoriteGIF;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> authorities;

    public Users(String username, String password, Set<String> authorities, String guiltyPleasurePlaylist, String bingeWatchingBeichte, String zeitreiseZiel, String superheldenSpitzname, String favoriteGIF) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.guiltyPleasurePlaylist = guiltyPleasurePlaylist;
        this.bingeWatchingBeichte = bingeWatchingBeichte;
        this.zeitreiseZiel = zeitreiseZiel;
        this.superheldenSpitzname = superheldenSpitzname;
        this.favoriteGIF = favoriteGIF;

    }

    public Users(String username, String password, Set<String> authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public Users() {
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities.stream().map(SimpleGrantedAuthority::new).toList();
    }

    public long getId() {
        return id;
    }

    public String getGuiltyPleasurePlaylist() {
        return guiltyPleasurePlaylist;
    }

    public void setGuiltyPleasurePlaylist(String guiltyPleasurePlaylist) {
        this.guiltyPleasurePlaylist = guiltyPleasurePlaylist;
    }

    public String getBingeWatchingBeichte() {
        return bingeWatchingBeichte;
    }

    public void setBingeWatchingBeichte(String bingeWatchingBeichte) {
        this.bingeWatchingBeichte = bingeWatchingBeichte;
    }

    public String getZeitreiseZiel() {
        return zeitreiseZiel;
    }

    public void setZeitreiseZiel(String zeitreiseZiel) {
        this.zeitreiseZiel = zeitreiseZiel;
    }

    public String getSuperheldenSpitzname() {
        return superheldenSpitzname;
    }

    public void setSuperheldenSpitzname(String superheldenSpitzname) {
        this.superheldenSpitzname = superheldenSpitzname;
    }

    public String getFavoriteGIF() {
        return favoriteGIF;
    }

    public void setFavoriteGIF(String favoriteGIF) {
        this.favoriteGIF = favoriteGIF;
    }

    public String getValue() {
        return String.valueOf(this.getId());
    }


    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Friendship> getFriendshipList() {
        return friendshipList;
    }

    public void setId(int id) {
        this.id = id;
    }
}
