package com.empsi.entities.rights;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
@Entity
@XmlRootElement
@Table(name = "groups")
public class Group implements Serializable{

	@Transient
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private Long id;
	private String groupName ;
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, cascade={CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name="group_right_table",joinColumns=
            @JoinColumn(name="group_id", referencedColumnName="ID"),
        inverseJoinColumns=
            @JoinColumn(name="right_id", referencedColumnName="ID")
        )
    private List<Right> rights;
	
	@JsonIgnore
	@ManyToMany()
	@JoinTable(name = "group_user_table", 
		joinColumns = @JoinColumn(name = "group_id", referencedColumnName = "ID"), 
		inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "ID") )
	private List<User> users;

	private Boolean deletable ;
	
	public Group() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Right> getRights() {
		return rights;
	}

	public void setRights(List<Right> rights) {
		this.rights = rights;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Boolean getDeletable() {
		return deletable;
	}

	public void setDeletable(Boolean deletable) {
		this.deletable = deletable;
	}
	
	@Override
	public String toString() {
		return "Group [id=" + id + ", groupName=" + groupName + ", deletable="
				+ deletable + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((deletable == null) ? 0 : deletable.hashCode());
		result = prime * result
				+ ((groupName == null) ? 0 : groupName.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((rights == null) ? 0 : rights.hashCode());
		result = prime * result + ((users == null) ? 0 : users.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Group other = (Group) obj;
		if (deletable == null) {
			if (other.deletable != null)
				return false;
		} else if (!deletable.equals(other.deletable))
			return false;
		if (groupName == null) {
			if (other.groupName != null)
				return false;
		} else if (!groupName.equals(other.groupName))
			return false;
		if (id != other.id)
			return false;
		if (rights == null) {
			if (other.rights != null)
				return false;
		} else if (!rights.equals(other.rights))
			return false;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		return true;
	}
	
	

}
