package game.entity;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Answer {
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> options;
    private char correctAnswer;
}
