import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class DictionaryOfManyTranslations {

    private HashMap<String, ArrayList<String>> dictionary;

    public DictionaryOfManyTranslations() {
        this.dictionary = new HashMap<>();

    }

    /**
     * * adds the translation for the word and preserves old translations
     * 
     * @param word
     * @param translation
     */
    public void add(String word, String translation) {
        ArrayList<String> translations = new ArrayList<>();

        // # if the dictionary does not contain the word, add it and add the
        // translations
        if (!(dictionary.keySet().contains(word))) {

            translations.add(translation);
            dictionary.put(word, translations);
        } else {
            translations = (ArrayList<String>) dictionary.get(word).clone();
            translations.add(translation);
            dictionary.put(word, translations);
        }

    }

    /**
     * * returns a list of the translations added for the word. If the word has no
     * * translations the method should return an empty list
     * 
     * @param word
     * @return
     */
    public ArrayList<String> translate(String word) {
        if (!this.dictionary.keySet().contains(word)) {
            return new ArrayList<String>();
        } else {
            return dictionary.get(word);

        }

    }

    /**
     * * removes the word and all its translations from the dictionary
     * 
     * @param word
     */
    public void remove(String word) {
        if (dictionary.keySet().contains(word)) {
            dictionary.remove(word);
        }

    }
}
