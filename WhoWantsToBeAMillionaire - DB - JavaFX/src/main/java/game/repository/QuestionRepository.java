package game.repository;

import game.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    @Query(value = "SELECT * FROM questions WHERE difficulty_level = :level ORDER BY RANDOM()" +
            "LIMIT 3", nativeQuery = true)
    List<Question> findRandomQuestionsByDifficultyLevel(@Param("level") int difficultyLevel);
}
