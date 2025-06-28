package com.dikahadir_selenium.utilities;

public class StringExtractorUtil {
	
	public static String getPartBeforeOf(String originalText) {
        if (originalText == null) {
            return null;
        }

        String lowerCaseText = originalText.toLowerCase();
        int indexOfOf = lowerCaseText.indexOf(" of ");

        if (indexOfOf != -1) {
            return originalText.substring(0, indexOfOf).trim();
        } else {
            return originalText;
        }
    }

}
