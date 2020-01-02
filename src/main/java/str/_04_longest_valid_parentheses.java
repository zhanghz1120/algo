package str;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * 给出一个仅包含字符'('和')'的字符串，计算最长的格式正确的括号子串的长度。
 * 对于字符串"(()"来说，最长的格式正确的子串是"()"，长度为2.
 * 再举一个例子：对于字符串")()())",来说，最长的格式正确的子串是"()()"，长度为4.
 * ()(()
 *
 *
 */
public class _04_longest_valid_parentheses {
    int solution(String s){
        if(s == null || "".equals(s)){
            return 0;
        }
        int count = 0;
        int max = 0;
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                stack.push(ch);
            }else{
                if(stack.size() > 0){
                    stack.pop();
                    count++;
                }else{
                    max = count;
                    count = 0;
                }
            }

            if(count > max){
                max = count;
            }
        }
        return max * 2;
    }

    @Test
    public void testSolution(){
        String s = "()(()";
        int ret = new _04_longest_valid_parentheses().solution(s);
        Assert.assertEquals(2, ret);
    }


}
