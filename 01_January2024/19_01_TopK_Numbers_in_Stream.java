// Link: https://practice.geeksforgeeks.org/problems/top-k-numbers3425/1
// Time Complexity: O(N * log(K))
// Space Complexity: O(N)

class Pair {
    int num;
    int freq;

    Pair(int n, int f) {
        num = n;
        freq = f;
    }
}
class Solution {
    static class PairComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair p1, Pair p2) {
            if (p1.freq != p2.freq)
                return Integer.compare(p2.freq, p1.freq);
            return Integer.compare(p1.num, p2.num);
        }
    }

    public static ArrayList<ArrayList<Integer>> kTop(int[] arr, int N, int K) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        HashMap<Integer, Pair> frequencyMap = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>(new PairComparator());

        for (int i = 0; i < N; i++) {
            int currentNum = arr[i];
            int currentFreq = 1;
            // Update the frequency of the current number in the PriorityQueue
            Pair currentPair = frequencyMap.get(currentNum);
            if (currentPair != null) {
                currentFreq+=currentPair.freq;
                pq.remove(currentPair);
            }

            currentPair = new Pair(currentNum, currentFreq);
            frequencyMap.put(currentNum, currentPair);
            pq.add(currentPair);

            ArrayList<Integer> currentList = new ArrayList<>();
            PriorityQueue<Pair> tempPQ = new PriorityQueue<>(pq);

            int count = 0;
            while (!tempPQ.isEmpty() && count < K) {
                currentList.add(tempPQ.poll().num);
                count++;
            }

            result.add(new ArrayList<>(currentList));
        }

        return result;
    }
}