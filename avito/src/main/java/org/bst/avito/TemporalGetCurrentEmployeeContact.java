package org.bst.avito;

import java.util.List;

//Temp class
public class TemporalGetCurrentEmployeeContact {
    private static boolean getted = false;

    private static List<String> contacts = List.of(
            "Александр - +7 (995) 48-00-666",
            "Илья - +7 (995) 857-01-45"
    );

    public static String get() {
        if(getted) {
            getted = false;

            return contacts.get(0);
        } else {
            getted = true;

            return contacts.get(1);
        }
    }
}
