package com.dikahadir_selenium.utilities;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.List;
import java.util.ArrayList;

public class SimpleSortValidationUtil {

    
    public static void validateNumericThenAlphaOrder(List<WebElement> webElements) {
        if (webElements == null || webElements == null) {
            System.out.println("Warning: The list of WebElements is empty or null. No sorting validation performed.");
            return;
        }

        List<String> actualData = new ArrayList<>();
        for (WebElement element : webElements) {
            actualData.add(element.getText().trim());
        }

        for (int i = 1; i < actualData.size(); i++) {
            String prev = actualData.get(i - 1);
            String curr = actualData.get(i);

            // Pastikan string tidak kosong sebelum mencoba mengambil karakter pertama
            boolean isPrevEmpty = prev.isEmpty();
            boolean isCurrEmpty = curr.isEmpty();

            Integer firstDigitPrev = isPrevEmpty ? null : getFirstDigitValue(prev.charAt(0));
            Integer firstDigitCurr = isCurrEmpty ? null : getFirstDigitValue(curr.charAt(0));

            if (firstDigitPrev != null && firstDigitCurr != null) {
                // Keduanya diawali dengan digit
                Assert.assertTrue(firstDigitPrev <= firstDigitCurr,
                    String.format("Validasi gagal: Angka awal tidak berurutan. '%s' (digit awal %d) seharusnya <= '%s' (digit awal %d) di indeks %d.",
                                  prev, firstDigitPrev, curr, firstDigitCurr, i - 1));
            } else if (firstDigitPrev == null && firstDigitCurr == null) {
                // Keduanya tidak diawali dengan digit (atau string kosong), bandingkan sebagai alfabet
                int comparison = prev.compareToIgnoreCase(curr);
                Assert.assertTrue(comparison <= 0,
                    String.format("Validasi gagal: Alfabet tidak berurutan. '%s' seharusnya <= '%s' di indeks %d.",
                                  prev, curr, i - 1));
            } else if (firstDigitPrev != null && firstDigitCurr == null) {
                
            } else { // firstDigitPrev == null && firstDigitCurr != null
                Assert.fail(String.format(
                    "Validasi gagal: Urutan salah. '%s' (alfabet) diikuti oleh '%s' (angka) di indeks %d.",
                    prev, curr, i - 1));
            }
        }
    }
    


    private static Integer getFirstDigitValue(char c) {
        if (Character.isDigit(c)) {
            return Character.getNumericValue(c);
        }
        return null; 
    }
}