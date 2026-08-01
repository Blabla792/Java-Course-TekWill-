package game;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Main extends Application {
    private ConfigurableApplicationContext springContext;

    @Override
    public void init() {
        springContext = new SpringApplicationBuilder(Main.class).run();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/game.fxml"));

        // Tell JavaFX to use Spring's context to create controllers
        // (This allows dependency injection in your UI controllers)
        fxmlLoader.setControllerFactory(springContext::getBean);

        Parent root = fxmlLoader.load();
        primaryStage.setTitle("Who Wants to Be a Millionaire?");
        primaryStage.setScene(new Scene(root, 1000, 700));
        primaryStage.show();
    }

    @Override
    public void stop() {
        springContext.close();
        Platform.exit();
    }
}
