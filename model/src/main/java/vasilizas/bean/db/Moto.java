package vasilizas.bean.db;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Table(name = "moto")
@NamedQuery(name = "bySport", query = "select modelType  from Moto where sport = :sport")
@NamedQuery(name = "byFuel", query = "select p from Moto p where p.fuel = :fuel")
public class Moto extends AbstractEntity {

    private String sport;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fuel", insertable = false, updatable = false)
    private TypeFuel typeFuel;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Moto moto = (Moto) o;
        return sport.equals(moto.sport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), sport);
    }

    @Override
    public String toString() {
        return " sport = '" + sport + '\'' +
                ", typeFuel = " + typeFuel + super.toString();
    }
}
