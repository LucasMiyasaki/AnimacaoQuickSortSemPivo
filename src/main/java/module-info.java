module com.example.animacaoordenacao {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.animacaoordenacao to javafx.fxml;
    exports com.example.animacaoordenacao;
}