package sk.topo.softs.app.rudebot.core;

/**
 * Created by Fanthomo on 28.5.2017.
 */

public class WordProcessor {

    private String[] greetings = {"ahoj", "cau", "zdar"};

    public String getResponseOnMessage(String message) {
        String response;
        if (contains(message, greetings)){
            response = "No vitaj skrcek, ja som Rudebot, je mile ze vies aspon pozdravit :P";
        } else {
            response = "Akoze nauc sa pisat lebo ja ti vobec absolutne nerozumiem, rozumie ti vobec niekto? Povinna skolska dochadzka ukoncena? :P";
        }
        return response;
    }

    private boolean contains(String message, String[] array) {
        message = message.toLowerCase();
        for (String s : array) {
            if (message.equals(s)) {
                return true;
            }
        }
        return false;
    }

}
