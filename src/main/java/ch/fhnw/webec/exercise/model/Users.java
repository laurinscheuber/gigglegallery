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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotEmpty
    @Column(nullable = false, unique = true)
    private String username;

    @NotEmpty
    @Column(nullable = false)
    private String password;

    @OneToMany
    private List<Friendship> friendshipList;

    private int age;

    private String guiltyPleasurePlaylist;

    private String bingeWatchingBeichte;

    private String zeitreiseZiel;

    private String superheldenSpitzname;

    private String favoriteGIF;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> authorities;

    public Users(String username, String password, Set<String> authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    protected Users() {
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities.stream().map(SimpleGrantedAuthority::new).toList();
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
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



}
