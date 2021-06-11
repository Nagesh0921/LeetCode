//Theory: Web Crawler in System Design, is a classic design problem. Also known as Spider or Crawler. Widely used in Seach Engine to discover updated content on web.
//Usage of Web Crawler - Seach Engine Indexing -> to create local index. 2. Web Archieval 3. Web Mining
//Web Crawler Algo is simple.
// 1. Given a set of URLs, download all the web pages addressed by the URLs.
// 2. Extract URLs from the web pages list.
// 3. Add New URLs to the list of URLs to be downloaded.
// This can be imagined as a graph containing node as Host and pages as leaf nodes connected with an edge.
// Hence DFS/BFS the classic Graph Traversal Algo can be used.

/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */

class Solution {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        q.add(startUrl);
        String hostName = getHostName(startUrl);
        while(!q.isEmpty()){
            String url = q.poll();
            visited.add(url);
            List<String> urlsInWebPages = htmlParser.getUrls(url);
            urlsInWebPages.forEach(childUrl -> {
                if(!visited.contains(childUrl) && getHostName(childUrl).equals(hostName)){
                    q.offer(childUrl);
                }
            });
        }
        return new ArrayList<>(visited);
    }
    
    private String getHostName(String url){
        int index = url.indexOf("http://");
        if(index >= 0){
            url = url.substring("http://".length());
        }
        
        return url.split("/")[0];
    }
}
