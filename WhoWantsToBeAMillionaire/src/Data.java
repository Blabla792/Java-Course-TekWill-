public class Data {

    private Question[] questions;
    private Answer[] answers;

    private final String data = """
            ## QUESTION 1 ##
            1 | How many planets are in our solar system? | 100 | 1
            7 | 8 | 9 | B
            ## QUESTION 2 ##
            2 | How many colors are there in a standard rainbow? | 200 | 1
            5 | 6 | 7 | 8 | C
            ## QUESTION 3 ##
            3 | Who is credited with discovering the law of universal gravitation? | 300 | 1
            Isaac Newton | Albert Einstein | Nikola Tesla | Galileo Galilei | A
            ## QUESTION 4 ##
            4 | The Earth is approximately how many kilometers away from the Sun? | 500 | 2
            15 million km | 63 million km | 150 million km | 311 million km | C
            ## QUESTION 5 ##
            5 | Which of these chemical elements is not a metal? | 1000 | 2
            Iron | Tin | Copper | Helium | D
            ## QUESTION 6 ##
            6 | Which of these is the longest river in the world? | 2000 | 2
            Amazon River | Yangtze River | Mississippi River | Nile River | D
            ## QUESTION 7 ##
            7 | Which insect shorted out an early supercomputer and inspired the term "computer bug"? | 4000 | 3
            Moth | Roach | Fly | Japanese beetle | A
            ## QUESTION 8 ##
            8 | In what year did the Titanic sink? | 8000 | 3
            1905 | 1912 | 1918 | 1923 | B
            ## QUESTION 9 ##
            9 | Who is credited with inventing the first mass-produced helicopter? | 16000 | 3
            Igor Sikorsky | Elmer Sperry | Ferdinand von Zeppelin | Gottlieb Daimler | A
            ## QUESTION 10 ##
            10 | Which company created the first portable CD player, the Discman? | 32000 | 4
            Panasonic | Hitachi | Sony | Casio | C
            ## QUESTION 11 ##
            11 | Which of these is the horse's fastest gait? | 64000 | 4
            Walk | Trot | Canter | Gallop | D
            ## QUESTION 12 ##
            12 | Hematite is the main ore of which metal? | 125000 | 4
            Aluminum | Mercury | Lead | Iron | D
            ## QUESTION 13 ##
            12 | What is studied and collected by a vexillologist? | 250000 | 5
            Feathers | Flags | Wine Corks | Dictionaries | B
            ## QUESTION 14 ##
            14 | The heaviest bird of prey is what kind of bird? | 500000 | 5
            Hawk | Owl | Condor | Kestrel | C
            ## QUESTION 15 ##
            15 | Which of these conditions is caused by a deficiency in B1? | 1000000 | 5
            Rickets | Scurvy | Beriberi | Malaria | C
            """;

    public Data() {
        parseData();
    }

    private void parseData() {
        String[] lines = data.split("\n");

        int totalQuestions = lines.length / 3;

        questions = new Question[totalQuestions];
        answers = new Answer[totalQuestions];

        for (int i = 0; i < lines.length; i += 3) {

            int arrayIndex = i / 3;

            String[] questionData = lines[i + 1].split("\\|");

            int questionNumber = Integer.parseInt(questionData[0].trim());
            String question = questionData[1].trim();
            int questionValue = Integer.parseInt(questionData[2].trim());
            int difficultyLevel = Integer.parseInt(questionData[3].trim());

            String[] answerData = lines[i + 2].split("\\|");

            int optionsCount = answerData.length - 1;
            String[] options = new String[optionsCount];

            for (int j = 0; j < optionsCount; j++) {
                options[j] = answerData[j].trim();
            }

            char correctAnswer = answerData[optionsCount].charAt(0);

            answers[arrayIndex] = new Answer(options, correctAnswer);

            questions[arrayIndex] = new Question(questionNumber, question, answers[arrayIndex], questionValue, difficultyLevel);
        }
    }

    public Question[] getQuestions() {
        return questions;
    }

    public Answer[] getAnswers() {
        return answers;
    }
}
