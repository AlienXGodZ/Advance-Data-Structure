class trienodes{

    trienodes[] children = new trienodes[26];
    boolean isendofword;
    int prefixcount;
    int exactwordcount;
}

public class Test45 {

    private trienodes root;

    public Test45(){

        root = new trienodes();

    }

    public void insert(String word){

        trienodes current = root;

        for(char ch : word.toCharArray()){

            int index = ch - 'a';

            if(current.children[index] == null){

                current.children[index] = new trienodes();

            }

            current = current.children[index];
            current.prefixcount++;

        }

        current.isendofword = true;
        current.exactwordcount++;

    }

    public boolean search(String word){

        trienodes current = root;

        for(char ch : word.toCharArray()){

            int index = ch - 'a';

            if(current.children[index] == null){

                return false;
            }

            current = current.children[index];

        }

        return current.isendofword;

    }

    public boolean startwith(String word){

        trienodes current = root;

        for(char ch : word.toCharArray()){

            int index = ch - 'a';

            if(current.children[index] == null){

                return false;

            }

            current = current.children[index];

        }

        return true;

    }

    public boolean delete(String word) {

        return delete(root,word,0);

    }

    public boolean delete(trienodes current,String word,int depth){

        if(current == null){

            return false;

        }

        if(depth == word.length()) {

            if (!current.isendofword) {

                return false;

            }

            current.isendofword = false;

            return nochildren(current);

        }

            int index = word.charAt(depth) - 'a';

            trienodes child = current.children[index];

            if(child == null){

                return false;

            }

            boolean shoulddelete = delete(child,word,depth + 1);

            if(shoulddelete) {

                current.children[index] = null;

                return !current.isendofword && nochildren(current);

            }



        return false;

    }

     private boolean nochildren(trienodes node){

        for(trienodes child : node.children){

            if(child != null){

                return false;

            }

        }

        return true;

     }

     public int prefixcount(String word){

        trienodes current = root;

        for(char ch : word.toCharArray()){

            int index = ch - 'a';

            if(current.children[index] == null){

                return 0;

            }

            current = current.children[index];

        }

        return current.prefixcount;

     }

     public boolean deleteword(String word){

        if(!search(word)){
            return false;
        }

        trienodes current = root;

        for(char ch : word.toCharArray()){

            int index = ch - 'a';

            current = current.children[index];

            current.prefixcount--;


            }

        current.isendofword = false;

        return true;

        }

        public int countchild(trienodes node){

        int count = 0;

        for(trienodes child : node.children){

               if(child != null){

                   count++;

               }


           }

        return count;
        }

        public String longestprefixcount(){

         trienodes current = root;

         StringBuilder result = new StringBuilder();

         while(countchild(current) == 1 && !current.isendofword){

             for(int i = 0; i < 26; i++){

                 if(current.children[i] != null){

                     char ch = (char)(i + 'a');

                     result.append(ch);

                     current = current.children[i];

                     break;

                 }

             }

         }

         return result.toString();

        }

        public void autocomplete(String word){

        trienodes current = root;

        for(char ch : word.toCharArray()){

            int index = ch - 'a';

            if(current.children[index] == null){

                System.out.println("No Suggestion");
                return;

            }

            current = current.children[index];

        }

        collectword(current,word);

        }

        public void collectword(trienodes current,String word){

            if(current.isendofword){

                System.out.println(word);

            }

            for(int i = 0 ; i < 26; i++){

                if(current.children[i] != null){

                    char ch = (char) (i + 'a');

                    collectword(current.children[i],word + ch);

                }

            }

        }

        public int exactwordcount(String word){

            trienodes current = root;

            for(char ch : word.toCharArray()){

                int index = ch - 'a';

                if(current.children[index] == null){

                    return 0;

                }

                current = current.children[index];

            }

            return current.exactwordcount;

        }

        public boolean prodelete(String word) {

            if (exactwordcount(word) == 0) {

                return false;

            }

            trienodes current = root;

            trienodes[] path = new trienodes[word.length() + 1];

            int[] indexes = new int[word.length()];

            path[0] = root;

            for (int i = 0; i < word.length(); i++) {

                int index = word.charAt(i) - 'a';

                indexes[i] = index;

                current = current.children[index];

                path[i + 1] = current;

            }

            for (int i = 1; i < path.length; i++) {

                path[i].prefixcount--;

            }

            trienodes lastnode = path[word.length()];

            lastnode.exactwordcount--;

        if(lastnode.exactwordcount == 0){

            lastnode.isendofword = false;

        }

        for(int i = 0; i < word.length(); i++) {

            trienodes child = path[i + 1];

            if (child.prefixcount == 0) {

                path[i].children[indexes[i]] = null;

                break;

            }

        }

        return true;


            }

            public boolean ultraprodelete(String word){

              if(exactwordcount(word) == 0){

                  return false;

              }

              trienodes current = root;

              trienodes[] path = new trienodes[word.length() + 1];

              int[] indexes = new int[word.length()];

              path[0] = root;

              for(int i = 0; i < word.length(); i++){

                  int index = word.charAt(i) - 'a';

                  indexes[i] = index;

                  current = current.children[i];

                  path[i+1] = current;

              }

              for(int i = 1; i < path.length;i++){

                  path[i].prefixcount--;

              }

              trienodes lastnode = path[word.length()];

              lastnode.exactwordcount--;

              if(lastnode.exactwordcount == 0){

                  lastnode.isendofword = false;

              }

              for(int i = 0; i < path.length; i++){

                  trienodes child = path[i+1];

                  if(child.prefixcount == 0){

                      path[i].children[indexes[i]] = null;

                      break;

                  }

              }

                return true;

            }

    public static void main(String[] args){

        Test45 trie = new Test45();

        trie.insert("allen");
        trie.insert("all");
        trie.insert("alleno");
        trie.insert("allenooo");
        trie.insert("allen");

        System.out.println(trie.search("allen"));

        System.out.println(trie.startwith("all"));

        System.out.println(trie.delete("all"));

        System.out.println(trie.prefixcount("allen"));

        System.out.println(trie.deleteword("allen"));

        System.out.println(trie.longestprefixcount());

        trie.autocomplete("all");

        System.out.println(trie.exactwordcount("allen"));

        System.out.println(trie.prodelete("allen"));

        System.out.println(trie.ultraprodelete("allen"));


    }
}
