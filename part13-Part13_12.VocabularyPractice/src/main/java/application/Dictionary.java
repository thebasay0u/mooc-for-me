package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/* 
 * Dictionary class is responsible for keeping track of the _words and _translations. 
 * _words are stored in an array list, while the word:translation pairs are stored in a Hash Map
 */
public class Dictionary {

    private List<String> _words;
    private Map<String, String> _translations;

    public Dictionary() {
        this._words = new ArrayList<>();
        this._translations = new HashMap<>();

        add("ko-to-ba", "word; phrase");
    }

    /**
     * * returns a word from the array list of _words
     * 
     * @param word
     * @return
     */
    public String get(String word) {
        return this._translations.get(word);
    }

    /**
     * * add a word and translation to the _translations hash map
     * 
     * @param word
     * @param translation
     */
    public void add(String word, String translation) {
        if (!this._translations.containsKey(word)) {
            this._words.add(word);
        }
        this._translations.put(word, translation);

    }

    /**
     * * pulls a random word from the array list of _words
     * 
     * @return
     */
    public String getRandomWord() {
        Random random = new Random();
        return this._words.get(random.nextInt(this._words.size()));

    }

}
