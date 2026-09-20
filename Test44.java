class trienode{

    trienode[] children = new trienode[26];
    boolean isendofword;
    int prefixcount;
    int wordcount;

}

public class Test44{

    private trienode root;

   public Test44(){

        root = new trienode();

    }

    public void insert(String word){

        trienode current = root;

        for(char ch : word.toCharArray()){

            int index = ch - 'a';

            if(current.children[index] == null){

                current.children[index] = new trienode();

            }

            current = current.children[index];
            current.prefixcount++;

        }

        current.isendofword = true;
        current.wordcount++;

    }

    public boolean search(String word){

        trienode current = root;

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

        trienode current = root;

        for(char ch : word.toCharArray()){

            int index = ch - 'a';

            if(current.children[index] == null){

                return false;

            }

            current = current.children[index];


        }

        return true;

    }

    public boolean delete(String word){

       return delete(root,word,0);

    }

    public boolean delete(trienode current,String word,int depth){

       if(current == null){

           return false;

       }

       if(depth == word.length()){

           if(!current.isendofword){

               return false;

           }

           current.isendofword = false;

           return nochildren(current);

       }

         int index = word.charAt(depth) - 'a';

         trienode child = current.children[index];

         if(child == null){

             return false;

         }

         boolean safedelete = delete(child,word,depth+1);

         if(safedelete){

             current.children[index] = null;

             return !current.isendofword && nochildren(current);

         }

         return false;

    }

    public boolean nochildren(trienode node){

       for(trienode child : node.children){

           if(child != null){
               return false;
           }

       }

       return true;

    }

    public int countprefix(String word){

       trienode current = root;

       for(char ch : word.toCharArray()) {

           int index = ch - 'a';

           if (current.children[index] == null) {

               return 0;

           }

           current = current.children[index];

       }

       return current.prefixcount;

    }

    public int countchildren(trienode node){

       int count = 0;

       for(trienode child : node.children){

           if(child != null){

               count++;

           }

       }

       return count;

    }

    public String longestcommonprefix() {

        StringBuilder result = new StringBuilder();

        trienode current = root;

        while (countchildren(current) == 1 && !current.isendofword) {

            for (int i = 0; i < 26; i++) {

                if (current.children[i] != null) {

                    char ch = (char) (i + 'a');

                    result.append(ch);

                    current = current.children[i];

                    break;

                }

            }
        }
        return result.toString();
    }

      public void autocomplete(String word){

          trienode current = root;

          for(char ch : word.toCharArray()){

              int index = ch - 'a';

              if(current.children[index] == null){

                  System.out.println("No Suggestions");
                  return;
              }

              current = current.children[index];


          }

          collectionword(current,word);

      }

      public void collectionword(trienode current,String word){

          if(current.isendofword){
              System.out.println(word);
          }

          for(int i = 0; i < 26; i++){

              if(current.children[i] != null){

                  char ch =(char)(i + 'a');

                  collectionword(current.children[i],word + ch);


              }
          }


      }

      public int wordcount(String word) {

          trienode current = root;

          for (char ch : word.toCharArray()) {

              int index = ch - 'a';

              if (current.children[index] == null) {

                  return 0;

              }

              current = current.children[index];

          }

          return current.wordcount;

      }

      public boolean prodelete(String word){

         if(wordcount(word) == 0){
             return false;
         }

         trienode current = root;

         trienode[] path = new trienode[word.length() + 1];

         int[] indexes = new int[word.length()];

         path[0] = root;

          for(int i = 0; i < word.length(); i++){

             int index = word.charAt(i) - 'a';

             indexes[i] = index;

             current = current.children[index];

             path[i+1] = current;

         }

         for(int i = 1; i < path.length ; i++){

             path[i].prefixcount--;

         }

         trienode lastnode = path[word.length()];

         lastnode.wordcount--;


         if(lastnode.wordcount == 0){

             lastnode.isendofword = false;

         }

         for(int i = 0; i < word.length(); i++){

             trienode child = path[i+1];

             if(child.prefixcount == 0){

                 path[i].children[indexes[i]] = null;

                 break;

             }

         }

         return true;

      }


    public static void main(String[] args){

        Test44 trie = new Test44();

        trie.insert("allen");
        trie.insert("allenr");
        trie.insert("allenoo");
        trie.insert("allronaa");
        trie.insert("allharvey");

        System.out.println(trie.search("allro"));
        System.out.println(trie.search("allen"));

        System.out.println(trie.startwith("allr"));

        System.out.println((trie.countprefix("allharvey")));

       System.out.println(trie.longestcommonprefix());

       trie.autocomplete("all");

       System.out.println(trie.wordcount("allen"));

       System.out.println(trie.prodelete("allen"));

    }
}