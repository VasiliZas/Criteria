package vasilizas.bean.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class AbstractEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        private String modelType;
        private Integer fuel;

        public AbstractEntity withId(Integer id) {
            setId(id);
            return this;
        }

    @Override
    public String toString() {
        return  ", id = " + id +
                ", modelType = '" + modelType + '\'' ;
    }
}
