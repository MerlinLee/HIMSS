package cn.edu.jlu.limf.model;

import javax.persistence.*;

/**
 * Created by merlin on 17-5-2.
 */
@Entity
@Table(name = "t_roleprivilege", schema = "HIMSDB", catalog = "")
public class TRoleprivilegeEntity {
    private int rpid;
    private String rolecode;
    private int mpid;

    @Id
    @Column(name = "RPID", nullable = false)
    public int getRpid() {
        return rpid;
    }

    public void setRpid(int rpid) {
        this.rpid = rpid;
    }

    @Basic
    @Column(name = "ROLECODE", nullable = false, length = 20)
    public String getRolecode() {
        return rolecode;
    }

    public void setRolecode(String rolecode) {
        this.rolecode = rolecode;
    }

    @Basic
    @Column(name = "MPID", nullable = false)
    public int getMpid() {
        return mpid;
    }

    public void setMpid(int mpid) {
        this.mpid = mpid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TRoleprivilegeEntity that = (TRoleprivilegeEntity) o;

        if (rpid != that.rpid) return false;
        if (mpid != that.mpid) return false;
        if (rolecode != null ? !rolecode.equals(that.rolecode) : that.rolecode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rpid;
        result = 31 * result + (rolecode != null ? rolecode.hashCode() : 0);
        result = 31 * result + mpid;
        return result;
    }
}
