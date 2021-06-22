package leetcode;

import java.util.*;

/**
 * @Author:lx
 * 单词接龙
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 * 1.每次转换只能改变一个字母。
 * 2.转换过程中的中间单词必须是字典中的单词。
 * @Date: 2020/11/5 10:57
 * @Description:
 */
public class LC127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //把字典加入到HashSet中，便于找
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)){
            return 0;
        }
        wordSet.remove(beginWord);
        //创建一个队列存放当前要遍历的单词，创建一个set存放已经遍历过的单词
        Queue<String> queue = new LinkedList<String>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        //开始遍历，广度优先遍历
        int step = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curWord = queue.poll();
                if (isEndWord(queue,visited,endWord,curWord,wordSet)){
                    return step + 1;
                }
            }
            step++;
        }
        return 0;
    }

    public boolean isEndWord(Queue<String> queue, Set<String> visited, String endWord,String curWord,Set<String> wordSet){
        char[] chars = curWord.toCharArray();
        for (int i = 0 ;i< endWord.length();i++){
            char originChar = chars[i];
            //从第一个字母开始，遍历
            for (char k='a'; k<='z';k++ ){
                if(originChar == k){
                    continue;
                }
                chars[i] = k;//现在chars是一个新的单词
                String newWord = String.valueOf(chars);
                if (wordSet.contains(newWord)){
                    if (newWord.equals(endWord)){
                        return true;
                    }
                    if (!visited.contains(newWord)){
                        queue.add(newWord);
                        visited.add(newWord);
                    }
                }

            }
            chars[i] = originChar;
        }
        return false;

    }
}
