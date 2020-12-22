package v7x.socnet.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "dialogs", schema = "soc_net")
public class Dialogs {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="id_user_seq")
    @SequenceGenerator(name="id_user_seq", schema = "soc_net", sequenceName="id_user_seq", allocationSize = 1)
    @Column(name = "id_dialog") private Long id;
}
