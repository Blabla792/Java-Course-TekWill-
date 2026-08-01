package game.config;

import game.entity.Question;
import game.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.NonNull;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
@Order(1)
public class DatabaseInitializer implements CommandLineRunner {
    private final QuestionRepository questionRepository;
    private final ObjectMapper objectMapper;

    @Override
    public void run(String @NonNull ... args) {
        // 1. Check if the database already has questions to avoid duplicates every time you restart
        if (questionRepository.count() > 0) {
            log.info("Database already contains questions. Skipping import.");
            return;
        }

        log.info("Starting JSON to Database migration...");

        String filePath = "question/data/questionsData.json";
        File jsonFile = new File(filePath);

        if (!jsonFile.exists()) {
            log.error("CRITICAL ERROR: Data jsonFile not found at {}", filePath);
            return;
        }

        try {
            List<Question> allQuestions = objectMapper.readValue(jsonFile,
                    new TypeReference<>() {});

            if (allQuestions != null && !allQuestions.isEmpty()) {
                questionRepository.saveAll(allQuestions);
                log.info("Successfully imported {} questions into the database!", allQuestions.size());
            } else {
                log.warn("JSON file was found but contained no questions.");
            }
        } catch (Exception e) {
            log.error("Failed to import JSON data: {}", e.getMessage());
        }
    }
}
