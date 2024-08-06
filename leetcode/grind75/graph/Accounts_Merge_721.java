package graph;

import java.util.*;

public class Accounts_Merge_721 {
    public static void main(String[] args) {
        Accounts_Merge_721 ss = new Accounts_Merge_721();
        Accounts_Merge_721.Solution solution = ss.new Solution();

//        String[][] accounts = {{"John", "AA", "BB"}, {"John", "AA", "CC"}, {"Mary", "DD"}, {"John", "EE"}};
        String[][] accounts = {
                {"David", "David0@m.co", "David1@m.co"},
                {"David", "David3@m.co", "David4@m.co"},
                {"David", "David4@m.co", "David5@m.co"},
                {"David", "David2@m.co", "David3@m.co"},
                {"David", "David1@m.co", "David2@m.co"}};
        List<List<String>> accountsList = new ArrayList<>();
        for (String[] account : accounts) {
            accountsList.add(Arrays.asList(account));
        }

        List<List<String>> result = solution.accountsMerge(accountsList);
        System.out.println(result);
    }

    /**
     * Runtime: 49 ms, Beats 19.23%
     */
//    class Solution {
//        Map<String, String> emailToName = new HashMap<>();
//        Map<String, String> parent = new HashMap<>();
//        Map<String, TreeSet<String>> unions = new HashMap<>();
//        Map<String, Integer> rank = new HashMap<>();
//
//        public List<List<String>> accountsMerge(List<List<String>> accounts) {
//            // 初始化每個郵件的父節點為自己，並記錄郵件和名字的映射
//            for (List<String> account : accounts) {
//                String name = account.get(0);
//                for (int i = 1; i < account.size(); i++) {
//                    emailToName.put(account.get(i), name);
//                    parent.put(account.get(i), account.get(i));
//                    rank.put(account.get(i), 0);
//                }
//            }
//
//            // 合併每個帳戶中的所有郵件
//            // 以第一個 email 以及後面的 email 作為 union 參數，簡單說就是遍歷所有 email 找出 共同 root
//            for (List<String> account : accounts) {
//                String firstEmail = account.get(1);
//                for (int i = 2; i < account.size(); i++) {
//                    union(firstEmail, account.get(i));
//                }
//            }
//
//            // 將每個郵件加入其所在的連通分量
//            // 以 root 為 key，email 就放到同一個 root 之中
//            for (String email : parent.keySet()) {
//                String root = find(email); // union 只是把 不同團的只到同一個 root 所以還沒有路徑壓縮
//                System.out.println("root:" + root + ", email:" + email);
//                if (!unions.containsKey(root)) {
//                    unions.put(root, new TreeSet<>());
//                }
//                unions.get(root).add(email);
//            }
//
//            // 組合結果 這時候 unions 都是 root 為 key 底下都是 對應的 emails
//            List<List<String>> result = new ArrayList<>();
//            for (String root : unions.keySet()) {
//                List<String> emails = new ArrayList<>(unions.get(root));
//                emails.add(0, emailToName.get(root)); // 在第一個插入 name
//                result.add(emails);
//            }
//
//            return result;
//        }
//
//        // 查找並查集的根
//        public String find(String email) {
//            if (!email.equals(parent.get(email))) {
//                parent.put(email, find(parent.get(email)));
//            }
//            return parent.get(email);
//        }
//
//        // 合併兩個郵件的集合
//        public void union(String email1, String email2) {
//            String root1 = find(email1);
//            String root2 = find(email2);
//
//            if (!root1.equals(root2)) {
//                int rank1 = rank.get(root1);
//                int rank2 = rank.get(root2);
//
//                if (rank1 > rank2) {
//                    parent.put(root2, root1);
//                } else if (rank1 < rank2) {
//                    parent.put(root1, root2);
//                } else {
//                    parent.put(root2, root1);
//                    rank.put(root1, rank1 + 1);
//                }
//            }
//        }
//    }

    /**
     * Runtime: 16 ms, Beats 100.00%
     */
    class Solution {

        public int[] parent;
        public String[] owners, emails;
        public Map<String, Integer> emailToId;
        int emailId = 0;

        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            int n = accounts.size() * 9; // 2 <= accounts[i].length <= 10, and the first is the name
            parent = new int[n];
            owners = new String[n];
            emails = new String[n];
            emailToId = new HashMap<>(n);

            // 初始化 自己就是自己的 root
            for (int i = 0; i < n; i++)
                parent[i] = i;

            // 遍歷每一個 email 並且轉成 id 做後續 union
            // 做的時候也會儲存 owner[id] emails[id]
            for (List<String> account : accounts) {
                String owner = account.get(0);
                int first = getId(account.get(1), owner);
                for (int i = 2; i < account.size(); i++) {
                    union(first, getId(account.get(i), owner));
                }
            }

            // 依據 emailId 開始找 root 並依照 root 去合併
            int size = emailId;
            List<String>[] merge = new List[size];
            for (int i = 0; i < size; i++) {
                int parent = find(i);
                if (merge[parent] == null)
                    merge[parent] = new ArrayList<>();

                merge[parent].add(emails[i]);
            }

            // 依照 merge 內容挑出不為 null 然後 排序 + name 在第一個
            List<List<String>> result = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (merge[i] == null)
                    continue;

                Collections.sort(merge[i]);
                merge[i].add(0, owners[i]);
                result.add(merge[i]);
            }
            return result;
        }

        public int getId(String email, String owner) {
            Integer id = emailToId.get(email);
            if (id == null) {
                id = emailId++;
                emailToId.put(email, id);
            }

            owners[id] = owner;
            emails[id] = email;
            return id;
        }

        private int find(int x) {
            return parent[x] == x ? x : (parent[x] = find(parent[x]));
        }

        private void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY)
                return;

            parent[rootY] = rootX;
        }
    }
}
