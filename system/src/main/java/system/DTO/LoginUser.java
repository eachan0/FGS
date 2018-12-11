package system.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;
import system.DO.SysMenu;
import system.DO.SysUser;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: FGS
 * @description:
 * @author: zhuyc
 * @create: 2018-12-07 16:38
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class LoginUser extends SysUser implements UserDetails {
    private static final long serialVersionUID = 5112807781139178657L;

    /** 登陆时间戳（毫秒） */
    private Long loginTime;
    /** 过期时间戳 */
    private Long expireTime;

    private String token;

    private List<SysMenu> menus;

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return menus.parallelStream().filter(p -> !StringUtils.isEmpty(p.getPermission()))
                .map(p -> new SimpleGrantedAuthority(p.getPermission())).collect(Collectors.toSet());
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return super.getIsExpired();
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return super.getIsLock();
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return super.getIsEnable();
    }
}
