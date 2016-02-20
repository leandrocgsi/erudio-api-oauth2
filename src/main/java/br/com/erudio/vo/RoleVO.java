package br.com.erudio.vo;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class RoleVO implements GrantedAuthority {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;

	@JsonIgnore
	private Set<UserVO> users = new HashSet<UserVO>();

	@Override
	public String getAuthority() {
		return name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<UserVO> getUsers() {
		return users;
	}

	public void setUsers(Set<UserVO> users) {
		this.users = users;
	}

}
