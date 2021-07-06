
package cn.bif.general_list.p1401_p1500;

import java.util.*;

/**
 * <br/>[1418]点菜展示表
 * <br/>给你一个数组 orders，表示客户在餐厅中完成的订单，确切地说， orders[i]=[customerNamei,tableNumberi,foodIt
 * <br/>emi] ，其中 customerNamei 是客户的姓名，tableNumberi 是客户所在餐桌的桌号，而 foodItemi 是客户点的餐品名称。
 * <br/>
 * <br/> 请你返回该餐厅的 点菜展示表 。在这张表中，表中第一行为标题，其第一列为餐桌桌号 “Table” ，后面每一列都是按字母顺序排列的餐品名称。接下来每一行中
 * <br/>的项则表示每张餐桌订购的相应餐品数量，第一列应当填对应的桌号，后面依次填写下单的餐品数量。
 * <br/>
 * <br/> 注意：客户姓名不是点菜展示表的一部分。此外，表中的数据行应该按餐桌桌号升序排列。
 * <br/>
 * <br/>
 * <br/>
 * <br/> 示例 1：
 * <br/>
 * <br/> 输入：orders = [["David","3","Ceviche"],["Corina","10","Beef Burrito"],["David",
 * <br/>"3","Fried Chicken"],["Carla","5","Water"],["Carla","5","Ceviche"],["Rous","3","
 * <br/>Ceviche"]]
 * <br/>输出：[["Table","Beef Burrito","Ceviche","Fried Chicken","Water"],["3","0","2","1
 * <br/>","0"],["5","0","1","0","1"],["10","1","0","0","0"]]
 * <br/>解释：
 * <br/>点菜展示表如下所示：
 * <br/>Table,Beef Burrito,Ceviche,Fried Chicken,Water
 * <br/>3    ,0           ,2      ,1            ,0
 * <br/>5    ,0           ,1      ,0            ,1
 * <br/>10   ,1           ,0      ,0            ,0
 * <br/>对于餐桌 3：David 点了 "Ceviche" 和 "Fried Chicken"，而 Rous 点了 "Ceviche"
 * <br/>而餐桌 5：Carla 点了 "Water" 和 "Ceviche"
 * <br/>餐桌 10：Corina 点了 "Beef Burrito"
 * <br/>
 * <br/>
 * <br/> 示例 2：
 * <br/>
 * <br/> 输入：orders = [["James","12","Fried Chicken"],["Ratesh","12","Fried Chicken"],[
 * <br/>"Amadeus","12","Fried Chicken"],["Adam","1","Canadian Waffles"],["Brianna","1","
 * <br/>Canadian Waffles"]]
 * <br/>输出：[["Table","Canadian Waffles","Fried Chicken"],["1","2","0"],["12","0","3"]]
 * <br/>
 * <br/>解释：
 * <br/>对于餐桌 1：Adam 和 Brianna 都点了 "Canadian Waffles"
 * <br/>而餐桌 12：James, Ratesh 和 Amadeus 都点了 "Fried Chicken"
 * <br/>
 * <br/>
 * <br/> 示例 3：
 * <br/>
 * <br/> 输入：orders = [["Laura","2","Bean Burrito"],["Jhon","2","Beef Burrito"],["Melis
 * <br/>sa","2","Soda"]]
 * <br/>输出：[["Table","Bean Burrito","Beef Burrito","Soda"],["2","1","1","1"]]
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/> 提示：
 * <br/>
 * <br/>
 * <br/> 1 <= orders.length <= 5 * 10^4
 * <br/> orders[i].length == 3
 * <br/> 1 <= customerNamei.length, foodItemi.length <= 20
 * <br/> customerNamei 和 foodItemi 由大小写英文字母及空格字符 ' ' 组成。
 * <br/> tableNumberi 是 1 到 500 范围内的整数。
 * <br/>
 * <br/> Related Topics 数组 哈希表 字符串 有序集合 排序
 * <br/> 👍 49 👎 0
 **/
public class P1418_DisplayTableOfFoodOrdersInARestaurant {
    public static void main (String[] args) {
        Solution solution = new P1418_DisplayTableOfFoodOrdersInARestaurant().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> displayTable (List<List<String>> orders) {
            TreeSet<String> tableSet = new TreeSet<>(Comparator.comparing(Integer::valueOf));
            Map<String,Map<String,Integer>> foodOrders = new TreeMap<>();
            for (List<String> order : orders) {
                String table = order.get(1);
                String food = order.get(2);
                Map<String,Integer> tableMaps = foodOrders.getOrDefault(food, new HashMap<>());
                tableMaps.put(table,tableMaps.getOrDefault(table,0)+1);
                tableSet.add(table);
                foodOrders.put(food,tableMaps);
            }
            
            List<List<String>> result = new ArrayList<>();
            
            List<String> title = new ArrayList<>();
            title.add("Table");
            title.addAll(foodOrders.keySet());
    
            result.add(title);
    
            for (String s : tableSet) {
                List<String> table = new ArrayList<>();
                table.add(s);
                foodOrders.forEach((s1, map) -> {
                    table.add(String.valueOf(map.getOrDefault(s,0)));
                });
                
                result.add(table);
                
            }
            
            
            return result;
            
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
