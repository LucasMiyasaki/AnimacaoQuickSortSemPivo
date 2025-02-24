package com.example.animacaoordenacao;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.text.Font;

import java.util.Random;

public class Principal extends Application {
    AnchorPane pane;
    Button botao_inicio, valor1, valor2, sinal;
    Text codigo, title;
    private Button vet[];
    int TL = 8;
    Circle doti, dotj, dot1, dot2, cod;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Pesquisa e Ordenacao");
        pane = new AnchorPane();

        title = new Text();
        title.setText("Quick Sort Sem Pivo");
        title.setStyle("-fx-font: 25 arial;");
        title.setLayoutX(100);
        title.setLayoutY(100);

        pane.getChildren().add(title);

        botao_inicio = new Button();
        botao_inicio.setLayoutX(10);
        botao_inicio.setLayoutY(200);
        botao_inicio.setText("INICIAR A ORDENAÇÃO");
        botao_inicio.setOnAction(e -> {
            quickSort();
        });
        pane.getChildren().add(botao_inicio);

        doti = new Circle(5, Color.ORANGE);
        doti.setLayoutX(120);
        doti.setLayoutY(365);

        dotj = new Circle(5, Color.BLUE);
        dotj.setLayoutX(680);
        dotj.setLayoutY(370);

        dot1 = new Circle(5, Color.ORANGE);
        dot1.setLayoutX(270);
        dot1.setLayoutY(255);

        dot2 = new Circle(5, Color.BLUE);
        dot2.setLayoutX(370);
        dot2.setLayoutY(255);

        pane.getChildren().add(doti);
        pane.getChildren().add(dotj);
        pane.getChildren().add(dot1);
        pane.getChildren().add(dot2);

        vet = new Button[TL];

        for (int i = 0, j = 100; i < TL; i++, j += 80) {
            vet[i] = new Button("" + new Random().nextInt(12));
            vet[i].setLayoutX(j);
            vet[i].setLayoutY(300);
            vet[i].setMinHeight(40);
            vet[i].setMinWidth(40);
            vet[i].setFont(new Font(14));
            vet[i].setStyle("-fx-background-color: lightgrey;");
            pane.getChildren().add(vet[i]);
        }

        valor1 = new Button();
        valor1.setLayoutX(250);
        valor1.setLayoutY(200);
        valor1.setMinHeight(40);
        valor1.setMinWidth(40);
        valor1.setFont(new Font(14));
        valor1.setStyle("-fx-background-color: lightgrey;");

        valor2 = new Button();
        valor2.setLayoutX(350);
        valor2.setLayoutY(200);
        valor2.setMinHeight(40);
        valor2.setMinWidth(40);
        valor2.setFont(new Font(14));
        valor2.setStyle("-fx-background-color: lightgrey;");

        sinal = new Button();
        sinal.setLayoutX(300);
        sinal.setLayoutY(200);
        sinal.setMinHeight(40);
        sinal.setMinWidth(40);
        sinal.setFont(new Font(14));
        sinal.setStyle("-fx-background-color: lightgrey;");

        pane.getChildren().add(valor1);
        pane.getChildren().add(valor2);
        pane.getChildren().add(sinal);

        codigo = new Text();
        codigo.setStyle("-fx-font: 20 arial;");
        codigo.setText("public void quickSort() {\n" +
                "|       quickSP(0, TL-1);\n" +
                "}\n\n" +
                "private void quickSP(int ini, int fim) {\n" +
                "|       int i = ini, j = fim, aux;\n" +
                "|       boolean flag = true;\n|\n" +
                "|       while(i < j) {\n" +
                "|       |        if(flag)\n" +
                "|       |                while(i < j && vet[i] <= vet[j])\n" +
                "|       |                        i++;\n|       |\n" +
                "|       |        else\n" +
                "|       |                while(j > i && vet[j] >= vet[i])\n" +
                "|       |                        j--;\n|       |\n" +
                "|       |        aux = vet[i];\n" +
                "|       |        vet[i] = vet[j];\n" +
                "|       |        vet[j] = aux;\n|       |\n" +
                "|       |        flag = !flag;\n" +
                "|       }\n" +
                "|       if(ini < i-1)\n" +
                "|               quickSP(ini, i-1);\n" +
                "|       if(j+1 < fim)\n" +
                "|               quickSP(j+1, fim);\n" +
                "}");
        codigo.setLayoutX(900);
        codigo.setLayoutY(200);

        cod = new Circle(5, Color.RED);
        cod.setLayoutX(880);//40
        cod.setLayoutY(195);//23

        pane.getChildren().add(codigo);
        pane.getChildren().add(cod);

        Scene scene = new Scene(pane, 800, 600);
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();
    }

    public void move_botoes(int pos1, int pos2, int dist) {
//permutação na tela
        for (int i = 0; i < 10; i++) {
            Platform.runLater(() -> vet[pos1].setLayoutY(vet[pos1].getLayoutY() + 5));
            Platform.runLater(() -> vet[pos2].setLayoutY(vet[pos2].getLayoutY() - 5));
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < dist / 5; i++) {
            Platform.runLater(() -> vet[pos1].setLayoutX(vet[pos1].getLayoutX() + 5));
            Platform.runLater(() -> vet[pos2].setLayoutX(vet[pos2].getLayoutX() - 5));
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 10; i++) {
            Platform.runLater(() -> vet[pos1].setLayoutY(vet[pos1].getLayoutY() - 5));
            Platform.runLater(() -> vet[pos2].setLayoutY(vet[pos2].getLayoutY() + 5));
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//permutação na memória
        Button aux = vet[pos1];
        vet[pos1] = vet[pos2];
        vet[pos2] = aux;
    }


    //QUICKSORT
    public void quickSort() {
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() {
                quickSP(0, TL - 1, 0);

                for (int i = 0; i < TL; i++) {
                    int finalI = i;
                    Platform.runLater(() -> {
                        vet[finalI].setLayoutY(300);
                    });
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                return null;
            }
        };
        Thread thread = new Thread(task);
        thread.start();
    }

    public void quickSP(int ini, int fim, int desc) {
        int i = ini, j = fim, test = 0;
        boolean flag = true;

        dot1.setLayoutY(255);

        dot2.setLayoutY(255);

        doti.setLayoutX(120 + i * 80);

        dotj.setLayoutX(120 + j * 80);

        for (int k = i; k <= j; k++) {
            int finalK = k;
            Platform.runLater(() -> {
                vet[finalK].setLayoutY(vet[finalK].getLayoutY() + desc);
            });
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Platform.runLater(() -> {
            doti.setLayoutY(vet[ini].getLayoutY() + 70);
            dotj.setLayoutY(vet[fim].getLayoutY() + 65);
        });
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        moveDot(8, 1);
        if (ini != fim) {
            while (i < j) {
                if (flag) {
                    moveDot(9, 2);
                    if (test != 0) {
                        moveDot(21, 2);
                        swapDot();
                    }
                    //MUDANÇA DE SINAL PARA VER SE O VET[I] É MAIOR QUE VET[J]
                    Platform.runLater(() -> sinal.setText(">"));
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    moveDot(10, 3);
                    //LAÇO DE REPETIÇÃO PARA ENCONTRAR O NUMERO QUE É MAIOR QUE VET[I]
                    while (i < j && Integer.parseInt(vet[i].getText()) <= Integer.parseInt(vet[j].getText())) {
                        moveDot(10, 3);
                        int aux1 = i, aux2 = j;
                        //TROCANDO A COR DOS BOTÕES PARA BRANCO
                        colorGrey(valor1, valor2, sinal);
                        i++;
                        Platform.runLater(() -> {
                            valor1.setText(vet[aux1].getText());
                            valor2.setText(vet[aux2].getText());
                        });
                        //TROCANDO A COR PARA VERMELHO INDICANDO QUE NÃO É MAIOR
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        colorRed(valor1, valor2, sinal);
                        moveDot(11, 4);
                        movDotI(doti);
                    }
                    //SE FOR MAIOR = VERDE
                    if (Integer.parseInt(vet[i].getText()) > Integer.parseInt(vet[j].getText())) {
                        moveDot(10, 3);
                        int finalI1 = i;
                        int finalJ1 = j;
                        Platform.runLater(() -> {
                            valor1.setText(vet[finalI1].getText());
                            valor2.setText(vet[finalJ1].getText());
                            colorGrey(valor1, valor2, sinal);
                        });
                        try {
                            Thread.sleep(950);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        colorGreen(valor1, valor2, sinal);
                    }
                } else {
                    moveDot(21, 2);
                    swapDot();
                    moveDot(9, 2);
                    moveDot(13, 2);
                    //MUDANÇA DE SINAL PARA PROCURAR VALOR DE VET[J] QUE É MENOR QUE VET[I]
                    Platform.runLater(() -> sinal.setText("<"));
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    moveDot(14, 3);
                    while (i < j && Integer.parseInt(vet[i].getText()) <= Integer.parseInt(vet[j].getText())) {
                        moveDot(14, 3);
                        int aux1 = i, aux2 = j;
                        //TROCA DE COR PARA BRANCO
                        colorGrey(valor1, valor2, sinal);
                        j--;
                        Platform.runLater(() -> {
                            valor1.setText(vet[aux2].getText());
                            valor2.setText(vet[aux1].getText());
                        });
                        //COR VERMELHA INDICANDO QUE O NÚMERO É MAIOR
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        colorRed(valor1, valor2, sinal);
                        moveDot(15, 4);
                        movDotJ(dotj);
                    }
                    //SE NÚMERO MENOR = VERDE
                    if (Integer.parseInt(vet[i].getText()) > Integer.parseInt(vet[j].getText())) {
                        moveDot(14, 3);
                        int finalI2 = i;
                        int finalJ2 = j;

                        Platform.runLater(() -> {
                            valor1.setText(vet[finalJ2].getText());
                            valor2.setText(vet[finalI2].getText());
                            colorGrey(valor1, valor2, sinal);
                        });
                        try {
                            Thread.sleep(950);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        colorGreen(valor1, valor2, sinal);
                    }
                }
                moveDot(18, 2);
                move_botoes(i, j, (j - i) * 80);
                flag = !flag;
                test++;
            }
            int finalI = i;
            Platform.runLater(() -> {
                vet[finalI].setStyle("-fx-background-color: lightgreen;");
            });
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            moveDot(23, 1);
            if (ini <= i - 1) {
                moveDot(24, 2);
                quickSP(ini, i - 1, 50);
            }
            moveDot(25, 1);
            if (j + 1 <= fim) {
                moveDot(26, 2);
                quickSP(j + 1, fim, 50);
            }

        } else {
            int finalI = i;
            Platform.runLater(() -> {
                vet[finalI].setStyle("-fx-background-color: lightgreen;");
            });
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void colorGreen(Button bt1, Button bt2, Button bt3) {
        Platform.runLater(() -> {
            bt1.setStyle("-fx-background-color: lightgreen;");
            bt2.setStyle("-fx-background-color: lightgreen;");
            bt3.setStyle("-fx-background-color: lightgreen;");
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void colorGrey(Button bt1, Button bt2, Button bt3) {
        Platform.runLater(() -> {
            bt1.setStyle("-fx-background-color: lightgrey;");
            bt2.setStyle("-fx-background-color: lightgrey;");
            bt3.setStyle("-fx-background-color: lightgrey;");
        });
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void colorRed(Button bt1, Button bt2, Button bt3) {
        Platform.runLater(() -> {
            bt1.setStyle("-fx-background-color: #ff5555;");
            bt2.setStyle("-fx-background-color: #ff5555;");
            bt3.setStyle("-fx-background-color: #ff5555;");
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void movDotI(Circle dot) {
        Platform.runLater(() -> {
            dot.setLayoutX(dot.getLayoutX() + 80);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void movDotJ(Circle dot) {
        Platform.runLater(() -> {
            dot.setLayoutX(dot.getLayoutX() - 80);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void swapDot() {
        for (int i = 0; i < 20; i++) {
            Platform.runLater(() -> {
                dot1.setLayoutX(dot1.getLayoutX() + 5);
                dot2.setLayoutX(dot2.getLayoutX() - 5);
            });
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Circle aux = dot1;
        dot1 = dot2;
        dot2 = aux;
    }

    public void moveDot(int lin, int col) {
        int i = 880, j = 195;

        Platform.runLater(() -> {
            cod.setLayoutX(i + col*47);
            cod.setLayoutY(j + lin*23);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}