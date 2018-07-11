import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {

  public static void main(String[] args) {
    String s = "()";
    ValidParentheses validParentheses = new ValidParentheses();

    validParentheses.isValid(s);
  }

  public boolean isValid(String s) {
    Deque<Character> stack = new ArrayDeque<>();
    if(s.length() < 2) {
      return false;
    }
    for(char c : s.toCharArray()) {
      System.out.println(c);

      if(c == '(' || c == '[' || c == '{') {
        stack.addFirst(c);
      } else if (c == ')') {
        System.out.println(stack.peekFirst());
        if (stack.peekFirst() != '(' || stack.peekFirst() == null) {
          return false;
        }
        stack.removeFirst();
      } else if (c == ']') {
        if (stack.peekFirst() != '[' || stack.peekFirst() == null) {
          return false;
        }
        stack.removeFirst();
      } else {
        if (stack.peekFirst() != '{' || stack.peekFirst() == null) {
          return false;
        }
        stack.removeFirst();
      }
    }
    return true;
  }
}
