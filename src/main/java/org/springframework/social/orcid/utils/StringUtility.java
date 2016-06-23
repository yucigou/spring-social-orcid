package org.springframework.social.orcid.utils;

/**
 * @author Yuci Gou
 *
 */
public class StringUtility {
    public static boolean hasContent(String str) {
        if (str == null) {
            return false;
        }
        
        str = str.trim();
        
        if (str == null || str.isEmpty()) {
            return false;
        }
        
        if (str.equalsIgnoreCase("null")) {
            return false;
        }
        
        return true;
    }
}
