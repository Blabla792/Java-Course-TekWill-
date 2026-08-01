package game.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "questions")
@Getter
@NoArgsConstructor // Required by JPA
@AllArgsConstructor
// This tells Jackson to ignore the "_comment" fields in your JSON
@JsonIgnoreProperties(ignoreUnknown = true)
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @JsonProperty("question")
    private String questionText;
    private int difficultyLevel;

    @Embedded
    private Answer answers;
}
