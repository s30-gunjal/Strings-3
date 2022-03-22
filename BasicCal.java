class Solution {
    public int calculate(String s) {
        Stack<Integer> num = new Stack<>();
        if (s == null || s.isEmpty()) return 0;
        
        //int i=0;
        int currNum=0;
        char operation = '+';
        
         for (int i = 0; i < s.length(); i++) {
            char a= s.charAt(i);
           
            if(Character.isDigit(a)){
                currNum*=10;
                currNum+= a- '0';
            }
             if(!Character.isDigit(a)  && !Character.isWhitespace(a)|| i == s.length() - 1){
                if (operation == '-') {
                    num.push(-currNum);
                }
                else if (operation == '+') {
                    num.push(currNum);
                }
                else if (operation == '*') {
                    num.push(num.pop() * currNum);
                }
                else if (operation == '/') {
                    num.push(num.pop() / currNum);
                }
                operation = a;
                currNum = 0;
            }  
           
        }
        int result=0;
        while(!num.isEmpty()){   
            result += num.pop();
        }
        return result;
    }
}
//Time Complexity: O(n), where n is the length of the string s

//Space Complexity: O(n)