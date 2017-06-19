package sk.topo.softs.app.rudebot.core;

/**
 * Created by Fanthomo on 28.5.2017.
 */

public class WordProcessor {

    private String[] greetings = {"ahoj", "cau", "zdar", "hi", "hallo", "greetings"};

    public String getResponseOnMessage(String message) {
        String response;
        if (contains(message, greetings)){
            response = "Zdravim Ta, je prijemne stretnut niekoho, kto vie slusne pozdravit ;) [Hallo nice to meet you]";
        } else {
            response = "Bohuzial, nerozumiem tomu co pises, som este mlady a neskuseny, pockaj mozno sa naucim casom viac :P [Sorry, my word database is soooo small and young, maybe future will gain more and I will understand you ;)]";
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
