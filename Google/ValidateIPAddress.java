import java.util.regex.*;
class Solution {
    static final String IPv4Chunk = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
    static final String IPv6Chunk = "([0-9a-fA-F]{1,4})";
    static final String patternIPv4 = "^(" + IPv4Chunk + "\\.){3}" + IPv4Chunk + "$";
    static final String patternIPv6 = "^(" + IPv6Chunk + "\\:){7}" + IPv6Chunk + "$";
    
    Pattern ipv4Pattern = Pattern.compile(patternIPv4);
    Pattern ipv6Pattern = Pattern.compile(patternIPv6);
    
    public String validIPAddress(String IP) {
        if(ipv4Pattern.matcher(IP).matches()){
            return "IPv4";
        }
        
        return (ipv6Pattern.matcher(IP).matches()) ? "IPv6" : "Neither";
    }
}
