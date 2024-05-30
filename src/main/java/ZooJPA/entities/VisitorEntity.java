package ZooJPA.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;
import java.util.Collection;

@Entity
@Table(name = "visitor", schema = "public", catalog = "shaimart")
public class VisitorEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_visitor")
    private int idVisitor;
    @Basic
    @Column(name = "ticketofficenumber")
    private int ticketofficenumber;
    @Basic
    @Column(name = "timevisit")
    private Time timevisit;
    @Basic
    @Column(name = "datevisit")
    private Date datevisit;
    @OneToMany(mappedBy = "visitorByIdVisitor")
    private Collection<TovisitEntity> tovisitsByIdVisitor;

    public int getIdVisitor() {
        return idVisitor;
    }

    public void setIdVisitor(int idVisitor) {
        this.idVisitor = idVisitor;
    }

    public int getTicketofficenumber() {
        return ticketofficenumber;
    }

    public void setTicketofficenumber(int ticketofficenumber) {
        this.ticketofficenumber = ticketofficenumber;
    }

    public Time getTimevisit() {
        return timevisit;
    }

    public void setTimevisit(Time timevisit) {
        this.timevisit = timevisit;
    }

    public Date getDatevisit() {
        return datevisit;
    }

    public void setDatevisit(Date datevisit) {
        this.datevisit = datevisit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VisitorEntity that = (VisitorEntity) o;

        if (idVisitor != that.idVisitor) return false;
        if (ticketofficenumber != that.ticketofficenumber) return false;
        if (timevisit != null ? !timevisit.equals(that.timevisit) : that.timevisit != null) return false;
        if (datevisit != null ? !datevisit.equals(that.datevisit) : that.datevisit != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idVisitor;
        result = 31 * result + ticketofficenumber;
        result = 31 * result + (timevisit != null ? timevisit.hashCode() : 0);
        result = 31 * result + (datevisit != null ? datevisit.hashCode() : 0);
        return result;
    }

    public Collection<TovisitEntity> getTovisitsByIdVisitor() {
        return tovisitsByIdVisitor;
    }

    public void setTovisitsByIdVisitor(Collection<TovisitEntity> tovisitsByIdVisitor) {
        this.tovisitsByIdVisitor = tovisitsByIdVisitor;
    }
}
