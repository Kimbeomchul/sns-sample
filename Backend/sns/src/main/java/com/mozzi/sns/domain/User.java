package com.mozzi.sns.domain;

import com.mozzi.sns.domain.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

@Getter
@AllArgsConstructor
public class User implements UserDetails {

    private Long id;
    private String userName;
    private String password;
    private String nickname;
    private String userImage;
    private UserLive livingAt;
    private UserRole role;
    private Timestamp registeredAt;
    private Timestamp updatedAt;
    private String deletedYn;


    public static User fromEntity(UserEntity entity){
        return new User(
                entity.getId(),
                entity.getUserName(),
                entity.getPassword(),
                entity.getNickname(),
                entity.getUserImage(),
                entity.getLivingAt(),
                entity.getRole(),
                entity.getRegisteredAt(),
                entity.getUpdatedAt(),
                entity.getDeletedYn()
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(this.getRole().toString()));
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return "N".equals(this.deletedYn);
    }

    @Override
    public boolean isAccountNonLocked() {
        return "N".equals(this.deletedYn);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return "N".equals(this.deletedYn);
    }

    @Override
    public boolean isEnabled() {
        return "N".equals(this.deletedYn);
    }
}
