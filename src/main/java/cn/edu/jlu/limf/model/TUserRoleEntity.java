package cn.edu.jlu.limf.model;

import javax.persistence.*;

/**
 * Created by merlin on 17-5-2.
 */
@Entity
@Table(name = "t_user_role", schema = "HIMSDB", catalog = "")
public class TUserRoleEntity {
    private int arid;
    private String userAccountId;
    private String roleCode;

    @Id
    @Column(name = "ARID", nullable = false)
    public int getArid() {
        return arid;
    }

    public void setArid(int arid) {
        this.arid = arid;
    }

    @Basic
    @Column(name = "userAccountId", nullable = false, length = 20)
    public String getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(String userAccountId) {
        this.userAccountId = userAccountId;
    }

    @Basic
    @Column(name = "roleCode", nullable = false, length = 20)
    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TUserRoleEntity that = (TUserRoleEntity) o;

        if (arid != that.arid) return false;
        if (userAccountId != null ? !userAccountId.equals(that.userAccountId) : that.userAccountId != null)
            return false;
        if (roleCode != null ? !roleCode.equals(that.roleCode) : that.roleCode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = arid;
        result = 31 * result + (userAccountId != null ? userAccountId.hashCode() : 0);
        result = 31 * result + (roleCode != null ? roleCode.hashCode() : 0);
        return result;
    }
}
