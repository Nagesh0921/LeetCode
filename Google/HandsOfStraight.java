class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        HashMap<Integer, Integer> cards = new HashMap<>();
        int len = hand.length;
        for(Integer n : hand){
            if(!cards.containsKey(n)){
                cards.put(n, 1);
            } else {
                cards.put(n, cards.get(n)+1);
            }
        }
        Arrays.sort(hand);
        for(Integer card : hand){
            if(cards.get(card)<=0){
                continue;
            }
            for(int i=0; i<W; i++){
                if(!cards.containsKey(card) || cards.get(card)<=0){
                    return false;
                }
                cards.put(card, cards.get(card)-1);
                card++;
            }
        }
        return true;
    }
}

//Time Complexity O(NlogN) Space Complexity O(N)
