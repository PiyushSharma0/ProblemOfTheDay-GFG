// Link: https:/practice.geeksforgeeks.org/problems/reversing-the-equation/0
// Time Complexity: O(n)
// Space Complexity: O(n)

   String reverseEqn(String s) {
        Stack<String> st = new Stack<>();
        StringBuilder reversedEqn = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                st.push(temp.toString());
                temp.setLength(0);
                temp.append(c);
                st.push(temp.toString());
                temp.setLength(0);
            } else {
                temp.append(c);
            }
        }

        if (temp.length() > 0) {
            st.push(temp.toString());
        }

        while (!st.empty()) {
            reversedEqn.append(st.peek());
            st.pop();
        }

        return reversedEqn.toString();
    }
