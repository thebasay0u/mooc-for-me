package dictionary;

import java.io.PrintWriter;
import java.nio.file.Paths;
import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SaveableDictionary {

    private Map<String, String> _dictionary;
    private String _file;

    public SaveableDictionary() {
        this._dictionary = new HashMap<>();

    }

    public SaveableDictionary(String file) {
        this._dictionary = new HashMap<>();
        this._file = file;

    }

    /**
     * * loads the dictionary from the file given to the constructor as a parameter
     * * if program is unable to open the file or read from it, the method returns
     * * false, otherwise it returns true
     * 
     * @return
     */
    public boolean load() {

        try (Scanner scanner = new Scanner(Paths.get(this._file))) {

            while (scanner.hasNextLine()) {
                String currentLine = scanner.nextLine();
                // # read one line
                String[] entry = currentLine.split(":");
                this.add(entry[0], entry[1]);

            }
            return true;

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    public boolean save() {

        try (PrintWriter pw = new PrintWriter(this._file)) {
            for (java.util.Map.Entry<String, String> entry : this._dictionary.entrySet()) {
                String word = entry.getKey();
                String translation = entry.getValue();
                pw.write(word + ":" + translation + "\n");

            }
            return true;

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
            return false;
        }

    }

    public void add(String words, String translation) {
        // # adds a word to the dictionary
        // # Every word has just one translation. annd if the same word is added for the
        // second time, nothing happens

        this._dictionary.putIfAbsent(words, translation);
    }

    /**
     * * returns the translation for the given word. If the word is not in dict,
     * * return null
     * 
     * @param word
     * @return
     */
    public String translate(String word) {
        // # If the word is in keyset, return value
        if (this._dictionary.containsKey(word)) {
            return this._dictionary.get(word);
        }
        // # If the word is in values
        if (this._dictionary.containsValue(word)) {
            // # iterate through each entry in the hashmap
            for (java.util.Map.Entry<String, String> entry : this._dictionary.entrySet()) {
                // # if value is found, return the key
                if (entry.getValue().equals(word)) {
                    return entry.getKey();
                }
            }

        }

        // # return null by default
        return null;
    }

    /**
     * * deletes the given word and its translation from the dictionary
     * 
     * @param word
     */
    public void delete(String word) {
        // # if neither the keyset nor values contain the word, return

        if (!this._dictionary.containsKey(word) && !this._dictionary.containsValue(word)) {
            return;
        }
        // # If the word is in keyset, delete using standard remove()

        if (this._dictionary.containsKey(word)) {
            this._dictionary.remove(word);
        }
        // # If word is a value in the dictionary

        if (this._dictionary.containsValue(word)) {
            // # helper variable to store value found
            String wordToDelete = "";
            // # traverse the entry set
            for (java.util.Map.Entry<String, String> entry : this._dictionary.entrySet()) {
                // # if word equals a value found in entry set
                if (entry.getValue().equals(word)) {
                    // # set the helper variable to the key
                    wordToDelete = entry.getKey();
                }
            }
            // # remove the associated key
            this._dictionary.remove(wordToDelete);

        }

    }

}
