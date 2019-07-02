package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/*
Difficulty: Medium
Companies: Google

Note: This is a companion problem to the System Design problem: Design TinyURL.
TinyURL is a URL shortening service where you enter a URL such as
https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk.

Design the encode and decode methods for the TinyURL service. There is no restriction on how your
encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL
and the tiny URL can be decoded to the original URL.
 */
public class LC_535_EncodeandDecodeTinyURL {

    /**
     * Questions:
     * 1. Assume we always can have tinyURL
     * 2. What happens if there is a collision? Avoid it?
     * 3. Do we need to think for delete and add more, or update?
     * 4. How many url's do we expect
     * 5. Can we assume there is a hashing method which guarantees to return the end of the tinyURL
     * always?
     * The initial Idea is to store two maps where in the first one key is the longURL and values is
     * the tinyURL
     * In the second one the opposite, key is the tinyURL and value is the longURL
     * @param longUrl
     * @return
     */

    private static final String tinyUrl = "http://tinyurl.com/";
    private static final String alphabet = "abcdefghijklmnoprstuvyzxwABCDEFGHIJKLMNOPRSTUVYZXW0123456789";

    private Map<String, String> url2code = new HashMap<>();
    private Map<String, String> code2url = new HashMap<>();

    public String encode(String longUrl) {
        if (!url2code.containsKey(longUrl)) {
            StringBuilder code = new StringBuilder();
            for(int i = 0; i < 6; i++) {
                int randomNum = ThreadLocalRandom.current().nextInt(0, 60 + 1);
                code.append(alphabet.charAt(randomNum));
            }
            if(!code2url.containsKey(code.toString())) {
                url2code.put(longUrl, code.toString());
                code2url.put(code.toString(), longUrl);
            }
        }

        return tinyUrl + url2code.get(longUrl);
    }

    public String decode(String shortUrl) {
        return code2url.get(shortUrl.substring(shortUrl.length() - 6));
    }



    List<String> urls = new ArrayList<>();

    // Encodes a URL to a shortened URL.
    public String encode2(String longUrl) {
        urls.add(longUrl);

        return tinyUrl + "urls.size() - 1";
    }

    // Decodes a shortened URL to its original URL.
    public String decode2(String shortUrl) {
        int index = shortUrl.lastIndexOf('/');
        String indexStr = shortUrl.substring(index, shortUrl.length() - 1);
        return urls.get(Integer.valueOf(indexStr));
    }
}
