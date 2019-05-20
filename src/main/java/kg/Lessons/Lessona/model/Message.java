package kg.Lessons.Lessona.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.sun.javafx.beans.IDProperty;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity

public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String isStatus;
    private String text;
    private LocalDateTime data;

    public Message() {
    }

    public Message(String isStatus, String text) {
        this.isStatus = isStatus;
        this.text = text;
        this.data = LocalDateTime.now();
    }

    public String getIsStatus() {
        return isStatus;
    }

    public void setIsStatus(String isStatus) {
        this.isStatus = isStatus;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
