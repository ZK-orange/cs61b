public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        Deque list=new ArrayDeque();
        for(int i=0;i<word.length();i++){
            list.addLast(word.charAt(i));
        }
        return list;
    }
    public boolean isPalindrome(String word){
        Deque list=this.wordToDeque(word);
        while(list.size()>1){
            if(list.removeFirst()!=list.removeLast()){
                return false;
            }
        }
        return true;
    }
    public boolean isPalindrome(String word, CharacterComparator cc){
        Deque list=this.wordToDeque(word);
        while(list.size()>1){
            if(!cc.equalChars((char)list.removeFirst(),(char)list.removeLast())){
                return false;
            }
        }
        return true;
    }
}
