class FileSystem {

    class Directory{
        LinkedHashMap<String, Directory> dirs = new LinkedHashMap<>();
        LinkedHashMap<String, String> files = new LinkedHashMap<>();
    }
    
    Directory root;
    
    public FileSystem() {
        root = new Directory();
    }
    
    public List<String> ls(String path) {
        Directory dir = root;
        List<String> files = new ArrayList<>();
        
        if(!path.equals("/")){
            String[] d = path.split("/");
            for(int i=1; i<d.length-1; i++){
                dir = dir.dirs.get(d[i]);
            }

            if(dir.files.containsKey(d[d.length - 1])){
                files.add(d[d.length-1]);
                return files;
            } else {
                dir = dir.dirs.get(d[d.length-1]);
            }
        }
        
        files.addAll(new ArrayList<>(dir.dirs.keySet()));
        files.addAll(new ArrayList<>(dir.files.keySet()));
        Collections.sort(files);
        return files;
    }
    
    public void mkdir(String path) {
        Directory dir = root;
        String[] d = path.split("/");
        for(int i=1; i<d.length; i++){
            if(!dir.dirs.containsKey(d[i])){
                dir.dirs.put(d[i], new Directory());
            }
            dir = dir.dirs.get(d[i]);
        }
    }
    
    public void addContentToFile(String filePath, String content) {
        Directory dir = root;
        String[] d = filePath.split("/");
        for(int i=1; i<d.length-1; i++){
            dir = dir.dirs.get(d[i]);
        }
        dir.files.put(d[d.length-1], dir.files.getOrDefault(d[d.length-1], "") + content);
    }
    
    public String readContentFromFile(String filePath) {
        Directory dir = root;
        String[] d = filePath.split("/");
        for(int i=1; i<d.length-1; i++){
            dir = dir.dirs.get(d[i]);
        }
        return dir.files.get(d[d.length - 1]);
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */

//This can be done with Trie -> Next Try :)
