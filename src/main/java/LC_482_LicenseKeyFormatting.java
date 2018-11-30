/*
You are given a license key represented as a string S which consists only alphanumeric character and dashes. The string is separated into N+1 groups by N dashes.

Given a number K, we would want to reformat the strings such that each group contains exactly K characters, except for the first group which could be shorter than K, but still must contain at least one character. Furthermore, there must be a dash inserted between two groups and all lowercase letters should be converted to uppercase.

Given a non-empty string S and a number K, format the string according to the rules described above.

Example 1:
Input: S = "5F3Z-2e-9-w", K = 4

Output: "5F3Z-2E9W"

Explanation: The string S has been split into two parts, each part has 4 characters.
Note that the two extra dashes are not needed and can be removed.
Example 2:
Input: S = "2-5g-3-J", K = 2

Output: "2-5G-3J"

Explanation: The string S has been split into three parts, each part has 2 characters except the first part as it could be shorter as mentioned above.
Note:
The length of string S will not exceed 12,000, and K is a positive integer.
String S consists only of alphanumerical characters (a-z and/or A-Z and/or 0-9) and dashes(-).
String S is non-empty.
 */

public class LC_482_LicenseKeyFormatting {

    //Just replace - dashes and convert String to upper case. This part is very easy and given just try to confuse.
    //Then from the back, append dashes at every K position. Since - dashes appended from the back, they do not
    //confuse the length of the string, instead if we would start from the beginning it would confuse.
    public String licenseKeyFormatting(String S, int K) {
        S = S.replace("-", "");
        S = S.toUpperCase();

        StringBuilder sb = new StringBuilder(S);

        int len = sb.length();
        for(int i = len - K; i > 0; i = i - K) {
            sb.insert(i, "-");
        }

        return sb.toString();
    }

    //This is my old solution, which is very complex and uses chars to upper case end deletion of the dashes. Instead
    //We could just use built in String replace and toUppperCase() methods. Then instead of complex mathematics,
    //just add dashes from the back clevery
    public String licenseKeyFormatting2(String S, int K) {
        int len = S.length();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++) {
            char c = S.charAt(i);
            if(c == '-') {
                continue;
            }

            //Convert to upper case letter
            if(c >= 'a' && c <= 'z') {
                sb.append(c + 26);
            } else {
                sb.append(c);
            }

            int newLen = sb.length();
            int div = newLen % K;
            int rem = newLen / K;  //First part will have rem length
            StringBuilder sbNew = new StringBuilder();

            if(div == 0) {
                for(int i2 = 0; i < newLen; i2 = i2 + (K / rem)) {
                    sbNew.append(sb.substring(i2, i2 + (K / rem)));
                    sbNew.append("-");
                }
            } else {
                sbNew.append(sb.substring(0, div));
                for(int ii = 0; ii < newLen - 1; ii = ii + (K / rem)) {
                    sbNew.append(sb.substring(ii + div, ii + div + (K / rem)));
                    sbNew.append("-");
                }
            }

            sbNew.deleteCharAt(sb.length() - 1);
            return sbNew.toString();
        }
        return null;
    }
}
