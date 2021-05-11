public class addTwoNumbers {
    public static LinkNode func(LinkNode L1, LinkNode L2){
        LinkNode head1 = L1;
        LinkNode head2 = L2;
        LinkNode dummyNode = new LinkNode(-1);
        LinkNode head = dummyNode;
        int hSum = 0;
        int yuShu = 0;

        while (head1 != null || head2 != null){
            hSum = 0;
            if (head1 != null){
                hSum += head1.val;
                head1 = head1.next;
            }
            if (head2 != null){
                hSum += head2.val;
                head2 = head2.next;
            }

            if (yuShu > 0){
                hSum += yuShu;
                yuShu = 0;
            }
            head.next = new LinkNode(hSum%10);

            if (hSum >= 10){
                yuShu = hSum / 10;
            }
            head = head.next;

        }
        if (yuShu > 0){
            head.next = new LinkNode(1);
        }
        return dummyNode.next;
    }
}