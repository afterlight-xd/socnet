package v7x.socnet.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "messages", schema = "soc_net")
public class Messages {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="id_user_seq")
    @SequenceGenerator(name="id_user_seq", schema = "soc_net", sequenceName="id_user_seq", allocationSize = 1)
    @Column(name = "id_message") private Long id;
    @Column(name = "message_sender") private String senderId;
    @Column(name = "message_reciever") private String recieverId;
    @Column(name = "message_time") private String time;
    @Column(name = "message_text") private String text;
}
