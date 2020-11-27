/*
 * Copyright (c) 2005, 2019, EVECOM Technology Co.,Ltd. All rights reserved.
 * EVECOM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package cn.bif.general_list.p101_p200;

import cn.bif.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ted Wang
 * @created 2020/9/29 4:26 下午
 */
public class P145 {
    
    /**
     * 描述
     * 左->右->根
     * @return java.util.List<java.lang.Integer>
     * @author Ted Wang
     * @created 2020/9/29 4:30 下午
     **/
    public List<Integer> postorderTraversal(TreeNode root) {
        
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
    
    
        if (root.left != null) {
            List<Integer> list1 = postorderTraversal(root.left);
            list.addAll(list1);
        }
    
    
    
        if (root.right != null) {
            List<Integer> list1 = postorderTraversal(root.right);
            list.addAll(list1);
        }
        list.add(root.val);
    
        return list;
    }
    
}
