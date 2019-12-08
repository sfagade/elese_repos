package org.tsp.projects.wbt.util;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ApplicationUtility {

    /**
     * This method is used to generate random strings for things like passwords
     *
     * @param codeLength length of the string to return
     * @param id ID to add to the string generation
     * @return String
     */
    public static String createRandomCode(int codeLength, String id) {
        List<Character> temp = id.chars()
                .mapToObj(i -> (char) i)
                .collect(Collectors.toList());
        Collections.shuffle(temp, new java.util.Random());
        return temp.stream()
                .map(Object::toString)
                .limit(codeLength)
                .collect(Collectors.joining());
    }
}
