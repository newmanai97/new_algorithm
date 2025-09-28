package leetCode.question;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class leetCode347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        Map<Integer, Integer> sortedMap = map.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldVal, newVal) -> oldVal, // 合并函数（不会冲突）
                        LinkedHashMap::new // 保持排序顺序
                ));
        int[] res = new int[k];
        int num = 0;
        for (Integer i : sortedMap.keySet()) {
            res[num++] = i;
            if (num == k){
                break;
            }
        }
        return res;
    }
}
