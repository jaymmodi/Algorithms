package Heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentWords2 {

    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding", "coding"};

        topKFrequent(words, 2).forEach(System.out::println);
    }

    public static List<String> topKFrequent(String[] words, int k) {
        if (words.length == 0 || words == null) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        Map<String, Integer> countMap = new HashMap<>();
        List<String>[] freqList = new List[words.length + 1];

        for (String word : words) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> set : countMap.entrySet()) {
            int freq = set.getValue();

            if (freqList[freq] == null) {
                List<String> strings = new ArrayList<>();
                strings.add(set.getKey());
                freqList[freq] = strings;
            } else {
                List<String> list = freqList[freq];
                list.add(set.getKey());
                list.sort(String::compareTo);

                freqList[freq] = list;
            }
        }

        for (int i = freqList.length - 1; i >= 0 && result.size() < k; i--) {
            List<String> strings = freqList[i];

            if (strings != null) {
                for (int j = 0; j < strings.size() && result.size() < k; j++) {
                    result.add(strings.get(j));
                }
            }
        }

        return result;
    }
}
