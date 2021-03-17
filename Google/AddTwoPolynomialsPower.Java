/**
 * Definition for polynomial singly-linked list.
 * class PolyNode {
 *     int coefficient, power;
 *     PolyNode next = null;
 
 *     PolyNode() {}
 *     PolyNode(int x, int y) { this.coefficient = x; this.power = y; }
 *     PolyNode(int x, int y, PolyNode next) { this.coefficient = x; this.power = y; this.next = next; }
 * }
 */

class Solution {
    public PolyNode addPoly(PolyNode poly1, PolyNode poly2) {
        PolyNode tempPoly = new PolyNode();
        PolyNode prev = tempPoly;
        while(poly1 != null && poly2 != null){
            if(poly1.power == poly2.power){
                int coefficientSum = poly1.coefficient + poly2.coefficient;
                if(coefficientSum == 0){
                    poly1 = poly1.next;
                    poly2 = poly2.next;
                    continue;
                }
                poly1.coefficient = coefficientSum;
                prev.next = poly1;
                poly1 = poly1.next;
                poly2 = poly2.next;
            } else if (poly1.power > poly2.power){
                prev.next = poly1;
                poly1 = poly1.next;
            } else {
                prev.next = poly2;
                poly2 = poly2.next;
            }
            prev = prev.next;
        }
        prev.next = (poly1 == null) ? poly2 : poly1;
        return tempPoly.next;
    }
}

//Time Complexity O(n+m) and Space Complexity O(1)
//This is linear Equations
