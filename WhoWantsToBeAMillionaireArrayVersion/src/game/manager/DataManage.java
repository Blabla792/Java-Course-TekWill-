package game.manager;

import game.model.Answer;
import game.model.Question;
import game.utils.GlobalUtils;

public class DataManage {
    private Question[] gameQuestions;

    private static final int GAME_TOTAL_QUESTIONS = 15;

    private final String data = """
            ## LEVEL 1 - QUESTION 1 ##
            How many planets are in our solar system? | 1
            7 | 8 | 9 | B
            ## LEVEL 1 - QUESTION 2 ##
            How many colors are there in a standard rainbow? | 1
            5 | 6 | 7 | 8 | C
            ## LEVEL 1 - QUESTION 3 ##
            Who is credited with discovering the law of universal gravitation? | 1
            Isaac Newton | Albert Einstein | Nikola Tesla | Galileo Galilei | A
            ## LEVEL 1 - QUESTION 4 ##
            Which planet is closest to our Sun? | 1
            Venus | Mars | Mercury | Jupiter | C
            ## LEVEL 1 - QUESTION 5 ##
            Which planet is often known as Earth's "twin" due to its similar size and mass? | 1
            Mars | Venus | Mercury | Neptune | B
            ## LEVEL 2 - QUESTION 1 ##
            The Earth is approximately how many kilometers away from the Sun? | 2
            15 million km | 63 million km | 150 million km | 311 million km | C
            ## LEVEL 2 - QUESTION 2 ##
            Which of these chemical elements is not a metal? | 2
            Iron | Tin | Copper | Helium | D
            ## LEVEL 2 - QUESTION 3 ##
            Which of these is the longest river in the world? | 2
            Amazon River | Yangtze River | Mississippi River | Nile River | D
            ## LEVEL 2 - QUESTION 4 ##
            Who painted the famous portrait known as the Mona Lisa? | 2
            Vincent van Gogh | Pablo Picasso | Leonardo da Vinci | Michelangelo | C
            ## LEVEL 2 - QUESTION 5 ##
            In computing terminology, what does the acronym "RAM" stand for? | 2
            Read Access Memory | Random Access Memory | Run All Media | Rapid Action Module | B
            ## LEVEL 3 - QUESTION 1 ##
            Which insect shorted out an early supercomputer and inspired the term "computer bug"? | 3
            Moth | Roach | Fly | Japanese beetle | A
            ## LEVEL 3 - QUESTION 2 ##
            In what year did the Titanic sink? | 3
            1905 | 1912 | 1918 | 1923 | B
            ## LEVEL 3 - QUESTION 3 ##
            Who is credited with inventing the first mass-produced helicopter? | 3
            Igor Sikorsky | Elmer Sperry | Ferdinand von Zeppelin | Gottlieb Daimler | A
            ## LEVEL 3 - QUESTION 4 ##
            Who was the first person to step foot on the Moon? | 3
            Buzz Aldrin | Yuri Gagarin | Neil Armstrong | John Glenn | C
            ## LEVEL 3 - QUESTION 5 ##
            Who is generally credited with inventing the first practical telephone? | 3
            Thomas Edison | Nikola Tesla | Alexander Graham Bell | Guglielmo Marconi | C
            ## LEVEL 4 - QUESTION 1 ##
            Which company created the first portable CD player, the Discman? | 4
            Panasonic | Hitachi | Sony | Casio | C
            ## LEVEL 4 - QUESTION 2 ##
            Which of these is the horse's fastest gait? | 4
            Walk | Trot | Canter | Gallop | D
            ## LEVEL 4 - QUESTION 3 ##
            Hematite is the main ore of which metal? | 4
            Aluminum | Mercury | Lead | Iron | D
            ## LEVEL 4 - QUESTION 4 ##
            Who is the only woman in history to win a Nobel Prize in two different scientific fields? | 4
            Rosalind Franklin | Ada Lovelace | Dorothy Hodgkin | Marie Curie | D
            ## LEVEL 4 - QUESTION 5 ##
            In 1928, Scottish scientist Alexander Fleming discovered the first widely effective antibiotic. What was it? | 4
            Amoxicillin | Penicillin | Tetracycline | Streptomycin | B
            ## LEVEL 5 - QUESTION 1 ##
            What is studied and collected by a vexillologist? | 5
            Feathers | Flags | Wine Corks | Dictionaries | B
            ## LEVEL 5 - QUESTION 2 ##
            The heaviest bird of prey is what kind of bird? | 5
            Hawk | Owl | Condor | Kestrel | C
            ## LEVEL 5 - QUESTION 3 ##
            Which of these conditions is caused by a deficiency in B1? | 5
            Rickets | Scurvy | Beriberi | Malaria | C
            ## LEVEL 5 - QUESTION 4 ##
            What was the call sign of the Apollo 11 Lunar Module that landed on the Moon in 1969? | 5
            Columbia | Falcon | Eagle | Intrepid | C
            ## LEVEL 5 - QUESTION 5 ##
            Which ancient civilization is widely credited with inventing the first known system of writing, cuneiform? | 5
            Sumerians | Egyptians | Minoans | Harappans | A
            """;

    public DataManage() {
        parseData();
    }

    private void parseData() {
        String[] lines = data.split("\n");

        int totalParsedQuestions = lines.length / 3;
        Question[] allQuestions = new Question[totalParsedQuestions];

        for (int i = 0; i < lines.length; i += 3) {

            int arrayIndex = i / 3;
            String[] questionData = lines[i + 1].split("\\|");

            String questionText = questionData[0].trim();
            int difficultyLevel = Integer.parseInt(questionData[1].trim());

            String[] answerData = lines[i + 2].split("\\|");
            int optionsCount = answerData.length - 1;
            String[] options = new String[optionsCount];

            for (int j = 0; j < optionsCount; j++) {
                options[j] = answerData[j].trim();
            }
            char correctAnswer = answerData[optionsCount].trim().charAt(0);
            Answer answers = new Answer(options, correctAnswer);

            allQuestions[arrayIndex] = new Question(0, questionText, answers, difficultyLevel);
        }

        gameQuestions = new Question[GAME_TOTAL_QUESTIONS];
        int gameIndex = 0;


        for (int questionLevel = 1; questionLevel <= 5; questionLevel++) {
            int numberOfQuestionsByLevel = 0;

            // Determination levelPool size
            for (Question question : allQuestions) {
                if (question.getDifficultyLevel() == questionLevel) {
                    numberOfQuestionsByLevel++;
                }
            }

            Question[] levelPool = new Question[numberOfQuestionsByLevel];
            int poolIndex = 0;
            for (Question question : allQuestions) {
                if (question != null && question.getDifficultyLevel() == questionLevel) {
                    levelPool[poolIndex++] = question;
                }
            }

            for (int i = 0; i < levelPool.length; i++) {
                int randomIndex = GlobalUtils.RANDOM.nextInt(levelPool.length);

                Question temp = levelPool[i];
                levelPool[i] = levelPool[randomIndex];
                levelPool[randomIndex] = temp;
            }

            int questionToPick = Math.min(3, levelPool.length);
            for (int i = 0; i < questionToPick; i++) {
                Question chosen = levelPool[i];
                chosen.setQuestionNumber(gameIndex + 1);
                gameQuestions[gameIndex] = chosen;
                gameIndex++;
            }
        }
    }

    public Question[] getGameQuestions() {
        return gameQuestions;
    }
}
