/*
 * Copyright (c) 2005, 2019, EVECOM Technology Co.,Ltd. All rights reserved.
 * EVECOM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package cn.bif.common;

import java.util.List;

/**
 * @author Ted Wang
 * @created 2020/9/1 10:37 上午
 */
public class ListNode {
    public int val;
    public ListNode next;
    
    public ListNode (int x) {
        val = x;
    }
    
    public ListNode () {
    }
    
    public ListNode (int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    
    public ListNode nextNode (int x) {
        this.next = new ListNode(x);
        return this.next;
    }
    
    public static ListNode init (int[] numbers) {
        if (numbers.length == 0) {
            return null;
        }
        ListNode first = new ListNode(numbers[0]);
        ListNode cur = first;
        
        for (int i = 1; i < numbers.length; i++) {
            ListNode l = new ListNode(numbers[i]);
            cur.next = l;
            cur = cur.next;
        }
        return first;
    }
    
    /**
     * Returns a string representation of the object. In general, the
     * {@code toString} method returns a string that
     * "textually represents" this object. The result should
     * be a concise but informative representation that is easy for a
     * person to read.
     * It is recommended that all subclasses override this method.
     * <p>
     * The {@code toString} method for class {@code Object}
     * returns a string consisting of the name of the class of which the
     * object is an instance, the at-sign character `{@code @}', and
     * the unsigned hexadecimal representation of the hash code of the
     * object. In other words, this method returns a string equal to the
     * value of:
     * <blockquote>
     * <pre>
     * getClass().getName() + '@' + Integer.toHexString(hashCode())
     * </pre></blockquote>
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString () {
        ListNode cur = this;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (cur != null) {
            sb.append(cur.val);
            sb.append(",");
            cur = cur.next;
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        
        return sb.toString();
    }
}
