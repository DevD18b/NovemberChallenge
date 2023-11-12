import java.util.*;

public class problem2 {
    public static List<String> findHighAccessEmployee(List<List<String>> arr) {

        List<String> ans = new ArrayList<>();
        HashMap<String, List<Integer>> map = new HashMap<>();

        for (List<String> list : arr) {
            String employeeName = list.get(0);
            String time = list.get(1);
            map.computeIfAbsent(employeeName, k -> new ArrayList<>()).add(Integer.parseInt(time));
        }

        for (String employee : map.keySet()) {
            List<Integer> times = map.get(employee);
            Collections.sort(times);
            if (isHighTimes(times)) {
                ans.add(employee);
            }
        }
        return ans;
    }

    public static boolean isHighTimes(List<Integer> times) {
        for (int i = 2; i < times.size(); i++) {
            // we gonna maintain window of 3.
            // and every time we check via adding 99 to prevPrev
            // 532,549,621 since we dont have to consider exactly 1 hour difference.
            // so we just add 99 and check because 532-632 is 1 hour but
            // that condition is banned in the
            // question.
            //
            int currrent = times.get(i);
            int prevPrev = times.get(i - 2);
            if (prevPrev + 99 >= currrent) {
                // if this hold than we have 3 events occuring in 1 hrs in this window.
                return true;
            }
        }
        return false;
    }
}
