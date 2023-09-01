// Link: https://practice.geeksforgeeks.org/problems/permutations-of-a-given-string2041/1
// Time Complexity: O(N*N!)
// Space Complexity: O(N*N!)

public List<String> find_permutation(String S) {
        List<String> result = new ArrayList<>();
        char[] chars = S.toCharArray();
        Arrays.sort(chars);
        boolean[] used = new boolean[S.length()];
        StringBuilder sb = new StringBuilder();
        generatePermutations(chars, used, sb, result);
        return result;
    }

private void generatePermutations(char[] chars, boolean[] used, StringBuilder sb, List<String> result) {
    if (sb.length() == chars.length) {
        result.add(sb.toString());
        return;
    }

    for (int i = 0; i < chars.length; i++) {
        if (used[i] || (i > 0 && chars[i] == chars[i - 1] && !used[i - 1])) {
            continue;
        }
        used[i] = true;
        sb.append(chars[i]);
        generatePermutations(chars, used, sb, result);
        sb.deleteCharAt(sb.length() - 1);
        used[i] = false;
    }
}