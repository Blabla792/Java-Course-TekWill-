package game.manager;

import game.model.Question;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class DataManager {
    private final List<Question> gameQuestions;

    private static final int MIN_DIFFICULTY_LEVEL = 1;
    private static final int MAX_DIFFICULTY_LEVEL = 5;
    private static final int QUESTION_PER_LEVEL = 3;

    public DataManager(String filePath) {
        this.gameQuestions = new ArrayList<>();
        parseData(filePath);
    }

    private void parseData(String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        File jsonFile = new File(filePath);

        if (!jsonFile.exists()) {
            throw new RuntimeException("CRITICAL ERROR: Data file not found at " + filePath);
        }

        try {
            List<Question> allQuestions = mapper.readValue(jsonFile, new TypeReference<>() {});

            if (allQuestions == null) return;

            Map<Integer, List<Question>> questionsByLevel = allQuestions.stream()
                    .filter(Objects::nonNull)
                    .collect(Collectors.groupingBy(Question::getDifficultyLevel));

            int gameIndex = 1;

            for (int currentLevel = MIN_DIFFICULTY_LEVEL; currentLevel <= MAX_DIFFICULTY_LEVEL; currentLevel++) {
                List<Question> levelPool = new ArrayList<>(questionsByLevel.getOrDefault(currentLevel, Collections.emptyList()));

                Collections.shuffle(levelPool);

                int questionsToPick = Math.min(QUESTION_PER_LEVEL, levelPool.size());
                for (int i = 0; i < questionsToPick; i++) {
                    Question chosen = levelPool.get(i);
                    chosen.setQuestionNumber(gameIndex++);
                    gameQuestions.add(chosen);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("CRITICAL ERROR: Failed to parse JSON data. Please check the file format. " + e.getMessage());
        }
    }

    public List<Question> getGameQuestions() {
        return Collections.unmodifiableList(gameQuestions);
    }
}
