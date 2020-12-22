package v7x.socnet.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "photos", schema = "soc_net")
public class Photos {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="id_user_seq")
    @SequenceGenerator(name="id_user_seq", schema = "soc_net", sequenceName="id_user_seq", allocationSize = 1)
    @Column(name = "id_photo") private Long id;
    @Column(name = "id_user") private String idUser;
}
