package vasilizas.bean.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fuel")
public class TypeFuel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fuel;
    private String typeFuel;

    @OneToMany(mappedBy = "fuel", fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private List<Moto> moto = new LinkedList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeFuel typeFuel1 = (TypeFuel) o;
        return Objects.equals(fuel, typeFuel1.fuel) && Objects.equals(typeFuel, typeFuel1.typeFuel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fuel, typeFuel);
    }

    @Override
    public String toString() {
        return typeFuel;
    }
}
